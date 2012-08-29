package era.foss.vieweditor.viewlayoutviewer;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

import era.foss.erf.ViewElement;

/**
 * Layout policy for our Hello Gef Editor.
 */
public class NodeEditPolicy extends XYLayoutEditPolicy {

    /**
     * @see org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#createAddCommand(EditPart, Object)
     **/
    protected Command createAddCommand( EditPart child, Object constraint ) {

        return null;
    }

    /**
     * @see org.eclipse.gef.editpolicies.ConstrainedLayoutEditPolicy#createChangeConstraintCommand(EditPart, Object)
     **/
    protected Command createChangeConstraintCommand( ChangeBoundsRequest request, EditPart child, Object constraint ) {
        assert (constraint instanceof Rectangle);

        Rectangle rect = (Rectangle)constraint;
        SetConstraintCommand locationCommand = new SetConstraintCommand();

        /* align size and position to dimensions of grid */
        EditPartViewer viewer = child.getViewer();
        Object viewerGridEnabledObject = viewer.getProperty( SnapToGrid.PROPERTY_GRID_ENABLED );
        Object viewerGridSpacingObject = viewer.getProperty( SnapToGrid.PROPERTY_GRID_SPACING );

        if( viewerGridEnabledObject instanceof Boolean
            && (Boolean)viewerGridEnabledObject == true
            && viewerGridSpacingObject instanceof Dimension ) {

            Dimension viewerGridSpacing = (Dimension)viewerGridSpacingObject;
            int gridHeight = viewerGridSpacing.height;
            int gridWidth = viewerGridSpacing.width;

            rect.height = (rect.height / gridHeight) * gridHeight;
            rect.width = (rect.width / gridWidth) * gridWidth;
            rect.x = (rect.x / gridHeight) * gridHeight;
            rect.y = (rect.y / gridWidth) * gridWidth;
            locationCommand.setGrid( gridWidth, gridHeight );
        }

        /* don't allow to move it out of the boundary or zero sized elements */
        if( rect.x < 0 || rect.y < 0 || rect.height <= 0 || rect.width <= 0 ) {
            return UnexecutableCommand.INSTANCE;
        }

        /*
         * don't allow overlapping objects
         */
        for( Object otherEditPartObject : child.getParent().getChildren() ) {
            EditPart otherEditPart = (EditPart)otherEditPartObject;
            if( otherEditPart instanceof AbstractGraphicalEditPart
                && child instanceof AbstractGraphicalEditPart
                && constraint instanceof Rectangle
                && !otherEditPart.equals( child )
                && otherEditPart.getSelected() == EditPart.SELECTED_NONE
                && ((Rectangle)constraint).intersects( ((AbstractGraphicalEditPart)otherEditPart).getFigure()
                                                                                                 .getBounds() ) ) {
                return UnexecutableCommand.INSTANCE;
            }
        }

        locationCommand.setViewElement( (ViewElement)child.getModel() );
        locationCommand.setEditingDomain( ((ViewLayoutViewer)child.getViewer()).getEmfEditingDomain() );
        locationCommand.setLocation( rect );

        return locationCommand;
    }

    /**
     * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getCreateCommand(CreateRequest)
     **/
    protected Command getCreateCommand( CreateRequest request ) {
        return null;
    }

    /**
     * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#createChildEditPolicy(EditPart)
     **/
    protected EditPolicy createChildEditPolicy( EditPart child ) {
        // return new NonResizableEditPolicy();
        return new ResizableEditPolicy();
    }

    /**
     * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getDeleteDependantCommand(Request)
     **/
    protected Command getDeleteDependantCommand( Request request ) {
        return null;
    }

    protected IFigure getFeedbackLayer() {
        return getLayer( LayerConstants.FEEDBACK_LAYER );
    }

    protected Insets getCreationFeedbackOffset( CreateRequest request ) {
        return new Insets();
    }

}
