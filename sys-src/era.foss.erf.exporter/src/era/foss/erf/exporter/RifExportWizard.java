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
* $Id: RifExportWizard.java 309 2011-04-01 17:56:22Z cpn $
*************************************************************************/
package era.foss.erf.exporter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;

/**
 * The Class RifExportWizard.
 */
public class RifExportWizard extends Wizard implements IExportWizard {

    // List of files to process
    /** The main page. */
    private RifExportWizardMainPage mainPage;
    
    /** The selection. */
    private IStructuredSelection selection;

    /* (non-Javadoc)
     * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
     */
    @Override
    public void init( IWorkbench workbench, IStructuredSelection selection ) {
        this.selection = selection;
    }

    /**
     * Gets the white checked input resources.
     * 
     * @param selection the selection
     * @return the white checked input resources
     */
    private List<IFile> getWhiteCheckedInputResources( IStructuredSelection selection ) {
        List<IFile> erfFileList = new ArrayList<IFile>();
        Iterator<?> fileIter = selection.iterator();
        while (fileIter.hasNext()) {
            // check if selected element is a file
            Object file = fileIter.next();
            if( file instanceof IFile ) {
                try {
                    if( ((IFile)file).getContentDescription()
                                     .getContentType()
                                     .getId()
                                     .equals( "era.foss.erf.ErfContentType" ) ) {
                        erfFileList.add( (IFile)file );
                    }
                } catch( CoreException e ) {
                }
            }
        }
        return erfFileList;
    }

    /*
     * (non-Javadoc) Method declared on IWizard.
     */
    public void addPages() {
        super.addPages();
        mainPage = new RifExportWizardMainPage( "Rif", getWhiteCheckedInputResources( selection ) );
        addPage( mainPage );
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.wizard.Wizard#performFinish()
     */
    @Override
    public boolean performFinish() {
        try {
            // delegate to main page
            return mainPage.finish();
        } catch( IOException e ) {
            e.printStackTrace();
            return false;
        }
    }

}
