package era.foss.tracer;

import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;

/**
 * @see http 
 *      ://source.jboss.org/browse/JBossTools/trunk/jsf/plugins/org.jboss.tools.jsf.ui/src/org/jboss/tools/jsf/ui/action
 *      /AddJSFNatureActionDelegate.java
 * @see http 
 *      ://source.jboss.org/browse/JBossTools/trunk/common/plugins/org.jboss.tools.common.model.ui/src/org/jboss/tools
 *      /common/model/ui/action/AddNatureActionDelegate.java
 */
public class AddEraTracerNatureActionDelegate extends AbstractEraTracerNatureActionDelegate {

    protected void doRun() {
        if( project == null ) return;

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
        } catch( CoreException e ) {
            e.printStackTrace();
        }
    }
}
