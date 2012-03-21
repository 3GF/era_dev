/**
 * 
 */
package era.foss.tracer.wizard;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

/**
 * @author haberstu
 */
public class TracerNewProjectWizard extends Wizard implements INewWizard {

    private IProject project;

    /**
	 * 
	 */
    public TracerNewProjectWizard() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
     * org.eclipse.jface.viewers.IStructuredSelection)
     */
    @Override
    public void init( IWorkbench workbench, IStructuredSelection selection ) {
        Object o = selection.getFirstElement();
        assert o instanceof IProject;
        project = (IProject)o;
    }

    @Override
    public void addPages() {
        addPage( new TracerConfigurationPage() );
        super.addPages();
    }

    final static protected String NATURE_ID = "era.foss.tracer.eratracernature";

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.wizard.Wizard#performFinish()
     */
    @Override
    public boolean performFinish() {
        if( project == null ) return false;

        boolean retVal = false;
        try {
            IProjectDescription desc = project.getDescription();
            String[] natures = desc.getNatureIds();
            boolean found = false;

            for( int i = 0; i < natures.length; ++i ) {
                if( natures[i].equals( NATURE_ID ) ) {
                    found = true;
                    break;
                }
            }
            if( !found ) {
                // add builder to project
                String[] newNatures = new String[natures.length + 1];
                // Add it before other builders.
                System.arraycopy( natures, 0, newNatures, 1, natures.length );
                newNatures[0] = NATURE_ID;
                desc.setNatureIds( newNatures );
                project.setDescription( desc, null );
            }
            retVal = true;
        } catch( CoreException e ) {
            e.printStackTrace();
            retVal = false;
        }
        return retVal;
    }

    public static class TracerConfigurationPage extends WizardPage {

        public TracerConfigurationPage() {
            super( "Tracer", "Tracer", null );
        }

        @Override
        public void createControl( Composite parent ) {
            setControl( new Label( parent, SWT.NONE ) );

        }
    }

}
