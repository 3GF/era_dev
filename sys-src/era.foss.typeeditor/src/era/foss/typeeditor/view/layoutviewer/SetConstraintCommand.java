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
package era.foss.typeeditor.view.layoutviewer;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.commands.Command;

import era.foss.erf.ErfPackage;
import era.foss.erf.ViewElement;

/**
 * This command is used to move or to resize the nodes in Hello Gef editor. Support for undo/redo is ready but not used
 * in the example.
 */
public class SetConstraintCommand extends Command {

    private EditingDomain editingDomain;
    private ViewElement viewElement;
    private Rectangle rectangle;
    private int gridHeight = 1;
    private int gridWidth = 1;

    public void execute() {
        CompoundCommand compoundCommand = new CompoundCommand( CompoundCommand.MERGE_COMMAND_ALL );
        compoundCommand.append( new SetCommand(
            editingDomain,
            viewElement,
            ErfPackage.Literals.VIEW_ELEMENT__EDITOR_COLUMN_POSITION,
            rectangle.x / gridWidth ) );
        compoundCommand.append( new SetCommand(
            editingDomain,
            viewElement,
            ErfPackage.Literals.VIEW_ELEMENT__EDITOR_ROW_POSITION,
            rectangle.y / gridHeight ) );
        compoundCommand.append( new SetCommand(
            editingDomain,
            viewElement,
            ErfPackage.Literals.VIEW_ELEMENT__EDITOR_COLUMN_SPAN,
            rectangle.width / gridWidth ) );
        compoundCommand.append( new SetCommand(
            editingDomain,
            viewElement,
            ErfPackage.Literals.VIEW_ELEMENT__EDITOR_ROW_SPAN,
            rectangle.height / gridHeight ) );
        editingDomain.getCommandStack().execute( compoundCommand );
    }

    /**
     * Sets the location.
     *
     * @param rectangle the new location
     */
    public void setLocation( Rectangle rectangle ) {
        this.rectangle = rectangle;
    }

    /**
     * Sets the view element.
     *
     * @param viewElement the new view element
     */
    public void setViewElement( ViewElement viewElement ) {
        this.viewElement = viewElement;
    }

    /**
     * Sets the editing domain.
     *
     * @param editingDomain the new editing domain
     */
    public void setEditingDomain( EditingDomain editingDomain ) {
        this.editingDomain = editingDomain;
    }

    /**
     * Sets the grid.
     *
     * @param gridWidth the grid width
     * @param gridHeight the grid height
     */
    public void setGrid( int gridWidth, int gridHeight ) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;

    }

}
