package era.foss.vieweditor.viewlayoutviewer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import era.foss.erf.ErfPackage;
import era.foss.erf.ViewElement;

/**
 * Our generic edit part.
 */
public class ViewElementEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener, Adapter {

    // default height and width in case the values are not retrieved by the model
    private int elementHeightUnit = 20;
    private int elementWidthUnit = 20;

    /**
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
     **/
    protected IFigure createFigure() {

        // add listener to react on changes of an view element
        addEditPartListener();

        // in case there is a grid use size of grid for the height units
        Object viewerGridSpacingObject = this.getViewer().getProperty( SnapToGrid.PROPERTY_GRID_SPACING );
        if( viewerGridSpacingObject instanceof Dimension ) {
            this.elementHeightUnit = ((Dimension)viewerGridSpacingObject).height;
            this.elementWidthUnit = ((Dimension)viewerGridSpacingObject).width;
        }

        // create the figure
        RoundedRectangle rectangle = new RoundedRectangle();
        rectangle.setSize( getModelRectangle().getSize() );
        rectangle.setLocation( getModelRectangle().getLocation() );
        rectangle.setBackgroundColor( ColorConstants.menuBackground );

        return rectangle;
    }

    /**
     * Add a listener for - changing colors for selected events
     */
    private void addEditPartListener() {
        this.addEditPartListener( new EditPartListener() {

            @Override
            public void childAdded( EditPart child, int index ) {
                // TODO Auto-generated method stub

            }

            @Override
            public void partActivated( EditPart editpart ) {
                // TODO Auto-generated method stub

            }

            @Override
            public void partDeactivated( EditPart editpart ) {
                // TODO Auto-generated method stub

            }

            @Override
            public void removingChild( EditPart child, int index ) {
                // TODO Auto-generated method stub

            }

            @Override
            public void selectedStateChanged( EditPart editpart ) {
                if( editpart.getSelected() == EditPart.SELECTED
                    || editpart.getSelected() == EditPart.SELECTED_PRIMARY ) {
                    ViewElementEditPart.this.getFigure().setBackgroundColor( ColorConstants.menuBackgroundSelected );
                } else {
                    ViewElementEditPart.this.getFigure().setBackgroundColor( ColorConstants.menuBackground );
                }
            }

        } );
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
     **/
    protected void createEditPolicies() {

    }

    /**
     * @see org.eclipse.gef.editparts.AbstractEditPart#refreshVisuals()
     **/
    protected void refreshVisuals() {
        Rectangle r = getModelRectangle();
        ((GraphicalEditPart)getParent()).setLayoutConstraint( this, getFigure(), r );

    }

    /**
     * Get a rectangle with the position and size of the viewElement
     * 
     * @return
     */
    private Rectangle getModelRectangle() {
        ViewElement viewElement = (ViewElement)getModel();

        int x = viewElement.getEditorColumnPosition() * this.elementWidthUnit;
        int y = viewElement.getEditorRowPosition() * this.elementHeightUnit;
        int width = viewElement.getEditorColumnSpan() * this.elementWidthUnit;
        int height = viewElement.getEditorRowSpan() * this.elementHeightUnit;
        return new Rectangle( x, y, width, height );
    }

    /**
     * @see org.eclipse.gef.EditPart#activate()
     **/
    public void activate() {
        if( isActive() == false ) {
            super.activate();
            ((ViewElement)getModel()).eAdapters().add( this );
        }
    }

    /**
     * @see org.eclipse.gef.EditPart#deactivate()
     **/
    public void deactivate() {
        if( isActive() == true ) {
            super.deactivate();
            ((ViewElement)getModel()).eAdapters().remove( this );
        }
    }

    @Override
    public void notifyChanged( Notification notification ) {
        Object feature = notification.getFeature();
        if( feature == null ) {
            return;
        }

        if( feature.equals( ErfPackage.Literals.VIEW_ELEMENT__EDITOR_COLUMN_POSITION )
            || feature.equals( ErfPackage.Literals.VIEW_ELEMENT__EDITOR_ROW_POSITION )
            || feature.equals( ErfPackage.Literals.VIEW_ELEMENT__EDITOR_COLUMN_SPAN )
            || feature.equals( ErfPackage.Literals.VIEW_ELEMENT__EDITOR_ROW_SPAN ) ) {
            refreshVisuals();
        }

    }

    @Override
    public Notifier getTarget() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setTarget( Notifier newTarget ) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isAdapterForType( Object type ) {
        if( type instanceof ViewElement ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void propertyChange( PropertyChangeEvent evt ) {
        // TODO Auto-generated method stub

    }

}
