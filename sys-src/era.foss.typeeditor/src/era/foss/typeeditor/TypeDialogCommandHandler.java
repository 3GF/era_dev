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
* $Id$
*************************************************************************/
package era.foss.typeeditor;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * The CommandHandler for the ERA type dialog.
 * <p>
 * This class is registered as extension point="org.eclipse.ui.handlers" in plugin.xml.
 * <p>
 * Upon {@link #execute(ExecutionEvent)} it instantiates the ERA type dialog.
 * 
 */
public class TypeDialogCommandHandler extends AbstractHandler {

    /* (non-Javadoc)
     * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
     */
    public Object execute( ExecutionEvent event ) throws ExecutionException {
        IEditorPart editor = HandlerUtil.getActiveEditor( event );

        TypeDialog typeEditor = new TypeDialog( Display.getCurrent().getActiveShell(), editor );
        typeEditor.open();
        return null;
    }

}
