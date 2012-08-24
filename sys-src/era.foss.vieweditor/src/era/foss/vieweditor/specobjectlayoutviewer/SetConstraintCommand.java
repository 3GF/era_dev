package era.foss.vieweditor.specobjectlayoutviewer;

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
        System.out.println( "Called SetConstraintCommand.execute()" );
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
        System.out.println( "Called SetConstraintCommand.execute()" + rectangle );
        editingDomain.getCommandStack().execute( compoundCommand );
    }

    public void setLocation( Rectangle rectangle ) {
        System.out.println( "Called SetConstraintCommand.setLocation() with r=" + rectangle );
        this.rectangle = rectangle;
    }

    public void setViewElement( ViewElement viewElement ) {
        this.viewElement = viewElement;
    }

    public void setEditingDomain( EditingDomain editingDomain ) {
        this.editingDomain = editingDomain;
    }

    public void setGrid( int gridWidth, int gridHeight ) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;

    }

}
