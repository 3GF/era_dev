package era.foss.tracer;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

/**
 * @see http 
 *      ://source.jboss.org/browse/JBossTools/trunk/jsf/plugins/org.jboss.tools.jsf.ui/src/org/jboss/tools/jsf/ui/action
 *      /AddJSFNatureActionDelegate.java
 * @see http 
 *      ://source.jboss.org/browse/JBossTools/trunk/common/plugins/org.jboss.tools.common.model.ui/src/org/jboss/tools
 *      /common/model/ui/action/AddNatureActionDelegate.java
 */
abstract public class AbstractEraTracerNatureActionDelegate implements IObjectActionDelegate,
        IWorkbenchWindowActionDelegate {

    protected IProject project;
    protected boolean isWindowAction = false;

    final static protected String NATURE_ID = Activator.PLUGIN_ID + ".eratracernature";

    @Override
    public void setActivePart( IAction action, IWorkbenchPart targetPart ) {
        // ignore
    }

    @Override
    public void run( IAction action ) {
        doRun();
    }

    abstract protected void doRun();

    @Override
    public void selectionChanged( IAction action, ISelection selection ) {
        project = null;
        if( selection instanceof IStructuredSelection ) {
            IStructuredSelection structuredSelection = (IStructuredSelection)selection;
            if( structuredSelection.size() == 1 ) {
                Object object = structuredSelection.getFirstElement();
                if( object instanceof IResource ) {
                    project = ((IResource)object).getProject();
                } else if( object instanceof IJavaElement ) {
                    project = ((IJavaElement)object).getJavaProject().getProject();
                }

                if( project != null ) try {
                    if( !project.isOpen() || project.hasNature( NATURE_ID ) ) project = null;
                } catch( CoreException ex ) {
                    project = null;
                }
            }
        }
        if( action != null ) action.setEnabled( project != null );
    }

    @Override
    public void dispose() {
        // ignore
    }

    @Override
    public void init( IWorkbenchWindow window ) {
        isWindowAction = true;
    }
}
