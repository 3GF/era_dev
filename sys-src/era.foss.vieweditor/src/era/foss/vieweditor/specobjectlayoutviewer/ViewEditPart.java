package era.foss.vieweditor.specobjectlayoutviewer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.CompoundSnapToHelper;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;

import era.foss.erf.View;
import era.foss.erf.ViewElement;

/**
 * Our hello "root" edit part, this one will contains our nodes EditParts...
 */
public class ViewEditPart extends AbstractGraphicalEditPart {

    
    private EditingDomain editingDomain;

    public ViewEditPart(EditingDomain editingDomain) {
        this.editingDomain = editingDomain;
    }
    /**
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
     **/
    protected IFigure createFigure() {
        System.out.println( "Called HelloTopEditPart.createFigure()" );

        Figure f = new FreeformLayer();
        f.setLayoutManager( new FreeformLayout() );

        /*
         * In case no border is set snapToGrid breaks when selecting an element at the border of the drawing area
         */
        f.setBorder( new MarginBorder( 5 ) );

        return f;
    }

    /**
     * Register layout policies for this EditPart.
     */
    protected void createEditPolicies() {
        System.out.println( "Called HelloTopEditPart.createEditPolicies()" );
        installEditPolicy( EditPolicy.COMPONENT_ROLE, new RootComponentEditPolicy() );
        installEditPolicy( EditPolicy.LAYOUT_ROLE, new NodeEditPolicy(editingDomain) );

    }

    /**
     * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren() You must implement this method if you want you
     *      root model to have children!
     **/
    protected List<ViewElement> getModelChildren() {
        System.out.println( "Called HelloTopEditPart.getModelChildren() with model=" + getModel() );
        return ((View)this.getModel()).getViewElements();
    }

    public Object getAdapter( @SuppressWarnings("rawtypes") Class adapter ) {
        if( adapter == SnapToHelper.class ) {
            List<SnapToGrid> snapStrategies = new ArrayList<SnapToGrid>();
            snapStrategies.add( new SnapToGrid( this ) );
            SnapToHelper ss[] = new SnapToHelper[snapStrategies.size()];
            for( int i = 0; i < snapStrategies.size(); i++ )
                ss[i] = (SnapToHelper)snapStrategies.get( i );
            return new CompoundSnapToHelper( ss );
        }
        return super.getAdapter( adapter );
    }

}
