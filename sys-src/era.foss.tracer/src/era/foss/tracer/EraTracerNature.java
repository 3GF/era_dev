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

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

/**
 * The Class EraTracerNature.
 */
public class EraTracerNature implements IProjectNature {

    final String BUILDER_ID = Activator.PLUGIN_ID + ".eratracerbuilder";
    private IProject project;

    public void configure() throws CoreException {
        // nature::configure => install nature's Builder
        IProjectDescription desc = project.getDescription();
        ICommand[] commands = desc.getBuildSpec();

        boolean found = false;
        for( int i = 0; i < commands.length; ++i ) {
            if( commands[i].getBuilderName().equals( BUILDER_ID ) ) {
                found = true;
                break;
            }
        }
        if( !found ) {
            // add builder to project
            ICommand command = desc.newCommand();
            command.setBuilderName( BUILDER_ID );
            ICommand[] newCommands = new ICommand[commands.length + 1];

            // Add it before other builders.
            System.arraycopy( commands, 0, newCommands, 1, commands.length );
            newCommands[0] = command;
            desc.setBuildSpec( newCommands );
            project.setDescription( desc, null );
        }
    }

    public void deconfigure() throws CoreException {
        // nature::deconfigure => deinstall nature's Builder
        IProjectDescription desc = project.getDescription();
        ICommand[] commands = desc.getBuildSpec();

        int foundIdx = -1;
        for( int i = 0; i < commands.length; ++i ) {
            if( commands[i].getBuilderName().equals( BUILDER_ID ) ) {
                foundIdx = i;
                break;
            }
        }
        if( foundIdx >= 0 ) {
            // Remove the nature-specific information here.
            ICommand[] newCommands = new ICommand[commands.length - 1];

            // Remove it
            System.arraycopy( commands, 0, newCommands, 0, foundIdx );
            System.arraycopy( commands, (foundIdx + 1), newCommands, foundIdx, (commands.length - foundIdx) );

            desc.setBuildSpec( newCommands );
            project.setDescription( desc, null );
        }
    }

    public IProject getProject() {
        return project;
    }

    public void setProject( IProject value ) {
        project = value;
    }
}