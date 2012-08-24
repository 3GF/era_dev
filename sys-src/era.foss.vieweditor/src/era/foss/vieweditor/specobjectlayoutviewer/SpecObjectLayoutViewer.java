package era.foss.vieweditor.specobjectlayoutviewer;

import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.editparts.FreeformGraphicalRootEditPart;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.jface.databinding.viewers.IViewerObservableValue;
import org.eclipse.swt.widgets.Composite;

public class SpecObjectLayoutViewer extends ScrollingGraphicalViewer {
    public static final String ID = "test.view";

    private EditDomain editDomain;

    private EditingDomain emfEditingDomain;

    public SpecObjectLayoutViewer( EditingDomain editingDomain, Composite parent ) {
        super();

        this.emfEditingDomain = editingDomain;

        // setup viewer
        this.createControl( parent );
        this.getControl().setBackground( ColorConstants.white );
        this.setProperty( SnapToGrid.PROPERTY_GRID_ENABLED, true );
        this.setProperty( SnapToGrid.PROPERTY_GRID_VISIBLE, true );
        this.setProperty( SnapToGrid.PROPERTY_GRID_SPACING, new Dimension( 30, 30 ) );
        this.setProperty( SnapToGrid.PROPERTY_GRID_ORIGIN, new Point( 0, 0 ) );

        editDomain = new DefaultEditDomain( null );
        editDomain.addViewer( this );
        this.setEditPartFactory( new GraphicalPartFactory( emfEditingDomain ) );
        this.setRootEditPart( new FreeformGraphicalRootEditPart() );
    }

    @Override
    public void setContents( Object content ) {
        IViewerObservableValue viewMaster = (IViewerObservableValue)content;
        viewMaster.addValueChangeListener( new IValueChangeListener() {

            @Override
            public void handleValueChange( ValueChangeEvent event ) {
                // SpecObjectLayoutViewer.this.getRootEditPart().getChildren().clear();
                SpecObjectLayoutViewer.super.setContents( event.getObservableValue().getValue() );
            }
        } );

        super.setContents( viewMaster.getValue() );
    }
}