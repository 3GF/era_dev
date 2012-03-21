/**************************************************************************
* ERA - Eclipse Requirements Analysis
* ==============================================
* Copyright (C) 2009-2011 by Georg Blaschke, Christoph P. Neumann
* and Bernd Haberstumpf (http://era.origo.ethz.ch)
**************************************************************************
* Licensed under the Eclipse Public License - v 1.0 (the "License");
* you may not use this file except in compliance with
* the License. You may obtain a copy of the License at
* http://www.eclipse.org/org/documents/epl-v10.html
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
**************************************************************************
* $Id: RifExportWizardMainPage.java 309 2011-04-01 17:56:22Z cpn $
*************************************************************************/
package era.foss.erf.exporter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

/**
 * The Class RifExportWizardMainPage.
 */
public class RifExportWizardMainPage extends WizardPage {

    /**
     * Instantiates a new rif export wizard main page.
     * 
     * @param pageName the page name
     * @param erfFileList the erf file list
     */
    public RifExportWizardMainPage( String pageName, List<IFile> erfFileList ) {
        super( pageName );
        this.setTitle( Activator.getPlugin().getString( "export.wizard.rif.description" ) );
        this.setErrorMessage( Activator.getPlugin().getString( "export.wizard.rif.error.selectDir" ) );
        this.erfWorkspaceResourceList = erfFileList;
    }

    // Text field holding the directory name where the output is written to
    /** The erf workspace resource list. */
    private List<IFile> erfWorkspaceResourceList;
    
    /** The Dir name. */
    private Text DirName;
    
    /** The is complete. */
    private boolean isComplete;

    /* (non-Javadoc)
     * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
     */
    @Override
    public void createControl( Composite parent ) {

        // create the composite to hold the widgets
        Composite composite = new Composite( parent, SWT.NULL );

        // create the desired layout for this wizard page
        GridLayout gl = new GridLayout();
        gl.numColumns = 3;
        composite.setLayout( gl );

        /*
         * Create Label, text field and button for selecting the output directory
         */
        new Label( composite, SWT.NONE ).setText( "Directory" );

        DirName = new Text( composite, SWT.BORDER );
        DirName.setLayoutData( new GridData( GridData.FILL_HORIZONTAL ) );

        if( erfWorkspaceResourceList.size() > 0 ) {
            DirName.setText( erfWorkspaceResourceList.get( 0 ).getParent().getLocation().toOSString() );
            RifExportWizardMainPage.this.setErrorMessage( null );
            RifExportWizardMainPage.this.setComplete( true );
            RifExportWizardMainPage.this.getWizard().canFinish();
        }

        Button buttonSelectFile = new Button( composite, SWT.PUSH );
        buttonSelectFile.setText( "Browse..." );
        buttonSelectFile.addListener( SWT.Selection, new Listener() {

            public void handleEvent( Event event ) {
                DirectoryDialog dirDialog = new DirectoryDialog( Display.getCurrent().getActiveShell(), SWT.MULTI );
                dirDialog.setFilterPath( DirName.getText() );
                String dirName = dirDialog.open();
                if( dirName != null ) {
                    DirName.setText( dirName );
                    RifExportWizardMainPage.this.setErrorMessage( null );
                    RifExportWizardMainPage.this.setComplete( true );
                    RifExportWizardMainPage.this.getWizard().canFinish();
                } else {
                    DirName.setText( "" );
                    RifExportWizardMainPage.this.setErrorMessage( Activator.getPlugin()
                                                                           .getString( "export.wizard.rif.error.selectDir" ) );
                    RifExportWizardMainPage.this.setComplete( false );
                }
                RifExportWizardMainPage.this.getWizard().getContainer().updateButtons();

            }
        } );

        // use composite as main widget for this page
        setControl( composite );
    }

    /**
     * Sets the complete.
     * 
     * @param complete the new complete
     */
    protected void setComplete( boolean complete ) {
        this.isComplete = complete;
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.wizard.WizardPage#isPageComplete()
     */
    public boolean isPageComplete() {
        return this.isComplete;
    }

    /**
     * The Finish button was pressed. Try to do the required work now and answer a boolean indicating success. If false
     * is returned then the wizard will not close.
     * 
     * @return boolean
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public boolean finish() throws IOException {

        if( erfWorkspaceResourceList.isEmpty() ) return true;

        // create rif11 EPackage from .ecore file:
        EPackage rif11Package = null;
        try {
            rif11Package = loadRIF11EPackage( URI.createURI( FileLocator.find( Platform.getBundle( "era.foss.erf.exporter.m2m" ),
                                                                               new Path( "model/rif_11.ecore" ),
                                                                               null )
                                                                        .toExternalForm() ) );
        } catch( IOException e ) {
            throw new IOException( e );
        }
        // rif11Package = loadRIF11EPackage( URI.createURI(
        // METAMODELFILE_RIF_11_ECORE, false ) );
        EPackage.Registry.INSTANCE.put( rif11Package.getNsURI(), rif11Package );

        // prepare ResourceSet for the Resource (for registering EXT-to-Factory
        // differently according to load and store)
        ResourceSet resourceSet = new ResourceSetImpl();

        for( IFile workspaceResource : erfWorkspaceResourceList ) {

            URI sourceErfURI = URI.createURI( workspaceResource.getLocationURI().toString(), true );
            URI targetBasedirURI = URI.createFileURI( DirName.getText().trim() );
            URI targetRifURI = targetBasedirURI.appendSegment( sourceErfURI.trimFileExtension().appendFileExtension( "rif" ).lastSegment() ) ;

            Resource resource = null;

            // transform resource
            try {
                resource = transform( sourceErfURI, targetRifURI );
            } catch( Exception e ) {
                throw new IOException( e );
            }

            // load resource (if Rif-XMI is not directly produced by the transformation as Resource object, but only
            // stored as file)
            if( resource == null ) {
                try {
                    resource = loadRifResourceFromRifXmi( resourceSet, targetRifURI );
                } catch( IOException e ) {
                    throw new IOException( e );
                }
            }

            // serialize resource
            try {
                assert (resource.getURI().equals( targetRifURI ));
                storeRifResourceToRif11Xml( resourceSet, resource );
            } catch( IOException e ) {
                throw new IOException( e );
            }
        }
        return true;
    }

    /**
     * Transform.
     * 
     * @param in the in
     * @param out the out
     * @return the resource
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private Resource transform( URI in, URI out ) throws IOException {
        ATLTranformer transformer = new ATLTranformer();
        transformer.loadModel( "erf", null, getBundleURI( "era.foss.erf", "model/erf.ecore" ) );
        transformer.loadModel( "rif11", null, getBundleURI( "era.foss.erf.exporter.m2m", "model/rif_11.ecore" ) );
        transformer.loadModel( "IN", "erf", in );
        return transformer.transform( getBundleURI( "era.foss.erf.exporter.m2m", "erf2rif11.asm" ).toString(),
                                      "OUT",
                                      out,
                                      "rif11",
                                      false );
    }

    /**
     * Gets the bundle uri.
     * 
     * @param bundle the bundle
     * @param path the path
     * @return the bundle uri
     */
    private URI getBundleURI( String bundle, String path ) {
        return URI.createPlatformPluginURI( bundle + "/" + path, true );
    }

    /**
     * Load ri f11 e package.
     * 
     * @param rif11MetamodelURI the rif11 metamodel uri
     * @return the e package
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static EPackage loadRIF11EPackage( URI rif11MetamodelURI ) throws IOException {
        EPackage rif11Package = null;
        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put( "ecore",
                                                                                 new XMIResourceFactoryImpl() );
        Resource rif11MetamodelResource = resourceSet.createResource( rif11MetamodelURI );
        rif11MetamodelResource.load( null );
        rif11Package = (EPackage)rif11MetamodelResource.getContents().get( 0 );
        return rif11Package;
    }

    /**
     * Load rif resource from rif xmi.
     * 
     * @param resourceSet the resource set
     * @param rifXmiURI the rif xmi uri
     * @return the resource
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private Resource loadRifResourceFromRifXmi( ResourceSet resourceSet, URI rifXmiURI ) throws IOException {
        Resource resource = null;
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put( "rif", new XMIResourceFactoryImpl() );
        resource = resourceSet.createResource( rifXmiURI );
        resource.load( null );
        return resource;
    }

    /**
     * Store rif resource to rif11 xml.
     * 
     * @param resourceSet the resource set
     * @param rifResource the rif resource
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void storeRifResourceToRif11Xml( ResourceSet resourceSet, Resource rifResource ) throws IOException {
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put( "rif", new XMLResourceFactoryImpl() );
        Map<String, Object> saveOptions = new HashMap<String, Object>();
        saveOptions.put( XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE );
        rifResource.save( saveOptions );
    }

}
