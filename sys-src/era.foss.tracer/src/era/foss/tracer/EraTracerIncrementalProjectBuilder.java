package era.foss.tracer;

import java.util.Map;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMemberValuePair;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.ISourceRange;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class EraTracerIncrementalProjectBuilder extends IncrementalProjectBuilder {

    private static final String MARKER_ID = Activator.PLUGIN_ID + ".reqmarker";

    private static final Logger logger = Logger.getLogger( EraTracerIncrementalProjectBuilder.class.getSimpleName() );

    protected IProject[] build( int kind, @SuppressWarnings("rawtypes") Map args, IProgressMonitor monitor ) throws CoreException {
        if( kind == IncrementalProjectBuilder.FULL_BUILD ) {
            fullBuild( monitor );
        } else {
            IResourceDelta delta = getDelta( getProject() );
            if( delta == null ) {
                fullBuild( monitor );
            } else {
                incrementalBuild( delta, monitor );
            }
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.resources.IncrementalProjectBuilder#startupOnInitialize()
     */
    protected void startupOnInitialize() {
        // Informs this builder that it is being started by the build management infrastructure.
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.resources.IncrementalProjectBuilder#clean(org.eclipse.core.runtime.IProgressMonitor)
     */
    protected void clean( IProgressMonitor monitor ) {
        IMarker[] markers;
        try {
            markers = getProject().findMarkers( MARKER_ID, true, IResource.DEPTH_INFINITE );
            for( IMarker marker : markers ) {
                marker.delete();
            }
            logger.info( "DELETED " + markers.length + " markers of type " + MARKER_ID );
        } catch( CoreException e ) {
            // Log the exception and bail out.
        }
    }

    private void fullBuild( final IProgressMonitor monitor ) throws CoreException {
        try {
            getProject().accept( new EraTracerBuildVisitor() );
        } catch( CoreException e ) {
        }
    }

    private static class EraTracerBuildVisitor implements IResourceVisitor {
        public boolean visit( IResource res ) {
            // ignore anything but files
            if( res.getType() != IResource.FILE ) return true;
            // ignore anything but Java file
            String ext = res.getFileExtension();
            ext = (ext == null) ? "" : ext;
            if( !ext.equalsIgnoreCase( "java" ) ) return true;
            // handle it
            IFile file = (IFile)res;
            handleJavaFile( file );
            // return true to continue visiting children.
            return true;
        }

    }

    private void incrementalBuild( IResourceDelta delta, IProgressMonitor monitor ) throws CoreException {
        // the visitor does the work.
        delta.accept( new EraTracerBuildDeltaVisitor() );
    }

    private static class EraTracerBuildDeltaVisitor implements IResourceDeltaVisitor {
        public boolean visit( IResourceDelta delta ) {
            IResource res = delta.getResource();
            // ignore anything but files
            if( res.getType() != IResource.FILE ) return true;
            // ignore anything but Java file
            String ext = res.getFileExtension();
            ext = (ext == null) ? "" : ext;
            if( !ext.equalsIgnoreCase( "java" ) ) return true;

            // process the current (java) file
            IFile file = (IFile)res;

            switch (delta.getKind()) {
            case IResourceDelta.ADDED:
                handleJavaFile( file );
                break;
            case IResourceDelta.REMOVED:
                logger.info( "Resource " + res.getFullPath() + " was removed." );
                break;
            case IResourceDelta.CHANGED:
                handleJavaFile( file );
                break;
            }
            return true; // visit the children
        }
    }

    private static void handleJavaFile( IFile file ) {
        // .java file are the same as ICompilationUnit
        // (@see http://help.eclipse.org/indigo/index.jsp?topic=%2Forg.eclipse.jdt.doc.isv%2Fguide%2Fjdt_int_model.htm)
        IJavaElement javaelem = JavaCore.create( file );
        assert (javaelem instanceof ICompilationUnit);
        ICompilationUnit compilunitabstraction = (ICompilationUnit)javaelem;
        // transform ICompUnit into CompUnit for offset-to-linenumber transformation
        CompilationUnit compilunit = parse( compilunitabstraction );

        try {

            for( IType itype : compilunitabstraction.getTypes() ) {

                for( IAnnotation ianno : itype.getAnnotations() ) {
                    annoToMarker( ianno, itype.getElementName(), file, compilunit );
                }

                for( IField ifield : itype.getFields() ) {
                    for( IAnnotation ianno : ifield.getAnnotations() ) {
                        annoToMarker( ianno, ifield.getElementName(), file, compilunit );
                    }
                }

                for( IMethod imeth : itype.getMethods() ) {
                    for( IAnnotation ianno : imeth.getAnnotations() ) {
                        annoToMarker( ianno, imeth.getElementName(), file, compilunit );
                    }
                }

            }

        } catch( JavaModelException e ) {
            e.printStackTrace();
        }

        logger.info( "Resource " + file.getFullPath() + " has been built." );
    }

    /**
     * @param ianno
     * @return boolean indicating whether it was an ERF Requirement Annotation or not
     */
    private static boolean annoToMarker( IAnnotation ianno, String elementName, IFile file, CompilationUnit cu ) {
        // TODO no foolproof match on Req-Annotation
        // (should be based on Annotation-Type, but such seems not to be supported)
        if( !ianno.getElementName().equals( "Requirement" ) ) return false;

        // MATCHED a Requirement Annotation
        IMemberValuePair[] imvp = null;
        try {
            imvp = ianno.getMemberValuePairs();
        } catch( JavaModelException e ) {
            logger.warning( "No annotation attributes in '@Requirement' of " + elementName );
            return false;
        }

        // extract requid: from MemberValuePairs
        String reqid = null;
        for( int i = 0; i < imvp.length; i++ ) {
            if( imvp[i].getMemberName().equals( "reqid" ) ) {
                reqid = (String)imvp[i].getValue();

            }
        }
        if( reqid == null ) {
            logger.warning( "Missing annotation attribute 'reqid' in '@Requirement' annotation of " + elementName );
            return false;
        }

        // extract lineNumber: based on SourceRange/Offset information
        int char_start = -1;
        int char_end = -1;
        int lineNumber = -1;
        try {
            ISourceRange sr = ianno.getSourceRange();
            char_start = sr.getOffset();
            char_end = char_start + sr.getLength();
            lineNumber = cu.getLineNumber( char_start );
        } catch( JavaModelException e ) {
            e.printStackTrace();
        }

        logger.info( "Found reqid: "
            + reqid
            + " at line: "
            + lineNumber
            + " at char_start: "
            + char_start
            + " and char_end: "
            + char_end );

        // add the reqid as IMarker of type MARKER_ID
        addMarker( file, lineNumber, char_start, char_end, reqid );

        return true;
    }

    /**
     * Reads a ICompilationUnit and creates the AST DOM for manipulating the Java source file
     * 
     * @param unit
     * @return
     */

    private static CompilationUnit parse( ICompilationUnit unit ) {
        ASTParser parser = ASTParser.newParser( AST.JLS4 );
        parser.setKind( ASTParser.K_COMPILATION_UNIT );
        parser.setSource( unit );
        parser.setResolveBindings( true );
        return (CompilationUnit)parser.createAST( null ); // parse
    }

    /**
     * The charStart and -End is currently ignored!
     * 
     * Helpful information: http://www.ibm.com/developerworks/opensource/tutorials/os-eclipse-plugin-guide/section2.html
     * http://help.eclipse.org/indigo/index.jsp?topic=%2Forg.eclipse.platform.doc.isv%2Fguide%2FresAdv_markers.htm
     * http://books.gigatux.nl/mirror/eclipseplugins/032142672X/ch14lev1sec2.html
     * http://wiki.eclipse.org/FAQ_Why_don't_my_markers_appear_in_the_editor's_vertical_ruler%3F
     * http://cubussapiens.hu/2010/11/markers-and-annotations-in-eclipse-for-error-feedback/
     * 
     * @param file
     * @param lineNumber
     * @param reqid
     */
    private static void addMarker( IFile file, int char_start, int char_end, int lineNumber, String reqid ) {
        try {
            IMarker marker = file.createMarker( MARKER_ID );
            // +-> From BOOKMARK
            marker.setAttribute( IMarker.MESSAGE, "supa dupa requirement here" );
            marker.setAttribute( IMarker.LOCATION, "right here: " + reqid );
            // +-> From TEXTMARKER
            // WARN: setting the CHAR_START/_END tangles with the LINE_NUMBER !?!
            // http://www.eclipse.org/forums/index.php/m/294625/#msg_294625
//            marker.setAttribute( IMarker.CHAR_START, char_start );
//            marker.setAttribute( IMarker.CHAR_END, char_end );
            marker.setAttribute( IMarker.LINE_NUMBER, lineNumber );
            // +-> From special ERF REQMARKER
            marker.setAttribute( "reqid", reqid );
            logger.info( marker.getAttributes().values().toString() );
        } catch( CoreException e ) {
            e.printStackTrace();
        }
    }
}