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
package era.foss.tracer;

import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;

import era.foss.tracer.wizard.TracerNewProjectWizard;

/**
 * The Class WizardbasedEraTracerNatureActionDelegate.
 *
 * @see http
 * ://source.jboss.org/browse/JBossTools/trunk/jsf/plugins/org.jboss.tools.jsf.ui/src/org/jboss/tools/jsf/ui/action
 * /AddJSFNatureActionDelegate.java
 * @see http
 * ://source.jboss.org/browse/JBossTools/trunk/common/plugins/org.jboss.tools.common.model.ui/src/org/jboss/tools
 * /common/model/ui/action/AddNatureActionDelegate.java
 */
public class WizardbasedEraTracerNatureActionDelegate extends AbstractEraTracerNatureActionDelegate {

    WizardDialog dialog = null;
    
    protected void doRun() {
        if( project == null ) return;

        IWizard wizard = new TracerNewProjectWizard();
        dialog = new WizardDialog(
            PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
            wizard );
        dialog.open();
        // FIXME (@poldi) dialog "finish" does nothing
    }
    
    @Override
    public void dispose() {
        // FIXME (@poldi) dialog "finish" does nothing
        dialog.close();
        dialog = null;
    }
}
