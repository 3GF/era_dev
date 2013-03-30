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

import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;

/**
 * The Class AddEraTracerNatureActionDelegate.
 *
 * @see http
 * ://source.jboss.org/browse/JBossTools/trunk/jsf/plugins/org.jboss.tools.jsf.ui/src/org/jboss/tools/jsf/ui/action
 * /AddJSFNatureActionDelegate.java
 * @see http
 * ://source.jboss.org/browse/JBossTools/trunk/common/plugins/org.jboss.tools.common.model.ui/src/org/jboss/tools
 * /common/model/ui/action/AddNatureActionDelegate.java
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
