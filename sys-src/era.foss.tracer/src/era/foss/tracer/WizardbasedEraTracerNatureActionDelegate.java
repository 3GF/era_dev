package era.foss.tracer;

import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;

import era.foss.tracer.wizard.TracerNewProjectWizard;

/**
 * @see http 
 *      ://source.jboss.org/browse/JBossTools/trunk/jsf/plugins/org.jboss.tools.jsf.ui/src/org/jboss/tools/jsf/ui/action
 *      /AddJSFNatureActionDelegate.java
 * @see http 
 *      ://source.jboss.org/browse/JBossTools/trunk/common/plugins/org.jboss.tools.common.model.ui/src/org/jboss/tools
 *      /common/model/ui/action/AddNatureActionDelegate.java
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
