package era.foss.typeeditor.view.layoutviewer;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import era.foss.erf.View;
import era.foss.erf.ViewElement;

/**
 * Edit parts factory for Gef sample. This factory returns EditPart corresponding to a given model object. In our simple
 * example, an HelloTopEditPart is returned for the top-most HelloModel object, and HelloEditPart is returned for the
 * HelloNodeModel objects (which are children of the HelloModel object).
 **/
public class GraphicalPartFactory implements EditPartFactory {

    /**
     * @see org.eclipse.gef.EditPartFactory#createEditPart(EditPart, Object)
     **/
    public EditPart createEditPart( EditPart iContext, Object iModel ) {

        EditPart editPart = null;

        if( iModel instanceof View ) {
            editPart = new ViewEditPart();
        } else if( iModel instanceof ViewElement ) {
            editPart = new ViewElementEditPart();
        }

        if( editPart != null ) {
            editPart.setModel( iModel );
        }

        return editPart;
    }

}
