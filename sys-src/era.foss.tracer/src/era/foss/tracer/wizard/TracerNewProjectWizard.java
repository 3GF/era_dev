/**************************************************************************
 * ERA - Eclipse Requirements Analysis
 * ==============================================
 * Copyright (C) 2009-2013 by Georg Blaschke, Christoph P. Neumann
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
 * The Class TracerNewProjectWizard.
 */
public class TracerNewProjectWizard extends Wizard implements INewWizard {

    private IProject project;

    /**
     * Instantiates a new tracer new project wizard.
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

    /** The Constant NATURE_ID. */
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

    /**
     * The Class TracerConfigurationPage.
     */
    public static class TracerConfigurationPage extends WizardPage {

        /**
         * Instantiates a new tracer configuration page.
         */
        public TracerConfigurationPage() {
            super( "Tracer", "Tracer", null );
        }

        @Override
        public void createControl( Composite parent ) {
            setControl( new Label( parent, SWT.NONE ) );

        }
    }

}
