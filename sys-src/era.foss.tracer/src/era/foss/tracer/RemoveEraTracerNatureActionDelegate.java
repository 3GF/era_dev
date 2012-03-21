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
public class RemoveEraTracerNatureActionDelegate extends AbstractEraTracerNatureActionDelegate {

    protected void doRun() {
        if( project == null ) return;

        try {
            IProjectDescription desc = project.getDescription();
            String[] natures = desc.getNatureIds();

            int foundIdx = -1;
            for( int i = 0; i < natures.length; ++i ) {
                if( natures[i].equals( NATURE_ID ) ) {
                    foundIdx = i;
                    break;
                }
            }
            if( foundIdx >= 0 ) {
                // remove builder from project
                String[] newNatures = new String[natures.length - 1];
                // remove it
                System.arraycopy( natures, 0, newNatures, 0, foundIdx );
                System.arraycopy( natures, (foundIdx + 1), newNatures, foundIdx, (natures.length - foundIdx) );

                // desc.setNatureIds( newNatures );
                project.setDescription( desc, null );
            }
        } catch( CoreException e ) {
            e.printStackTrace();
        }
    }
}
