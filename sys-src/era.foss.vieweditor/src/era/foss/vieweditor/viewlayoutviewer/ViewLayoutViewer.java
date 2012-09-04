package era.foss.vieweditor.viewlayoutviewer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.editparts.FreeformGraphicalRootEditPart;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.jface.databinding.viewers.IViewerObservableValue;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import era.foss.erf.ErfPackage;

public class ViewLayoutViewer extends ScrollingGraphicalViewer {
    public static final String ID = "test.view";

    // GEF editing domain
    private EditDomain gefEditingDomain;

    // eMF editing domain
    private EditingDomain emfEditingDomain;

    IViewerObservableValue viewMaster;

    final private List<ViewerFilter> viewerFilterList = new ArrayList<ViewerFilter>();

    public ViewLayoutViewer( EditingDomain editingDomain, Composite parent ) {
        super();

        this.emfEditingDomain = editingDomain;

        this.setControl( new FigureCanvas( parent, SWT.BORDER, getLightweightSystem() ) );
        this.getControl().setBackground( ColorConstants.white );
        this.setProperty( SnapToGrid.PROPERTY_GRID_ENABLED, true );
        this.setProperty( SnapToGrid.PROPERTY_GRID_VISIBLE, true );
        this.setProperty( SnapToGrid.PROPERTY_GRID_SPACING, new Dimension( 30, 30 ) );
        this.setProperty( SnapToGrid.PROPERTY_GRID_ORIGIN, new Point( 0, 0 ) );

        gefEditingDomain = new DefaultEditDomain( null );
        gefEditingDomain.addViewer( this );
        this.setEditPartFactory( new GraphicalPartFactory() );
        this.setRootEditPart( new FreeformGraphicalRootEditPart() );
    }

    @Override
    public void setContents( Object content ) {
        assert (content instanceof IViewerObservableValue);

        viewMaster = (IViewerObservableValue)content;

        viewMaster.addValueChangeListener( new IValueChangeListener() {

            @Override
            public void handleValueChange( ValueChangeEvent event ) {
                ViewLayoutViewer.this.refresh();
            }
        } );

        IEMFListProperty viewsProperty = EMFProperties.list( ErfPackage.Literals.VIEW__VIEW_ELEMENTS );
        viewsProperty.observeDetail( viewMaster ).addChangeListener( new IChangeListener() {
            @Override
            public void handleChange( ChangeEvent event ) {
                ViewLayoutViewer.this.refresh();
            }
        } );

        super.setContents( viewMaster.getValue() );
    }

    public void refresh() {
        ViewLayoutViewer.super.setContents( viewMaster.getValue() );
    }

    public ISelection getSelection() {

        @SuppressWarnings("unchecked")
        List<EditPart> selectionEditPartList = ((IStructuredSelection)super.getSelection()).toList();
        List<Object> modelElementList = new ArrayList<Object>();

        // get model elements of edit parts
        for( EditPart editPart : selectionEditPartList ) {
            modelElementList.add( editPart.getModel() );
        }

        return new StructuredSelection( modelElementList );
    }

    public void setSelection( ISelection selection ) {

        List<Object> newEditPartSelection = new ArrayList<Object>();

        // find edit parts for model elements
        for( Object modelElement : ((IStructuredSelection)selection).toList() ) {
            newEditPartSelection.add( this.getEditPartRegistry().get( modelElement ) );
        }

        /*
         * setting the viewport for the selection. seems we need black magic here....
         * ((FigureCanvas)this.getControl()).getViewport() .setViewLocation(
         * ((AbstractGraphicalEditPart)super.getSelectedEditParts() .get( 0 )).getFigure() .getBounds() .getLocation()
         * );
         */

        super.setSelection( new StructuredSelection( newEditPartSelection ) );
    }

    /**
     * add a filter
     * 
     * @return
     */
    public void addFilter( ViewerFilter filter ) {
        this.viewerFilterList.add( filter );
    }

    /**
     * remove a filter
     */
    public void removeFilter( ViewerFilter filter ) {
        this.viewerFilterList.remove( filter );
    }

    /**
     * add the emf editing domain
     */
    public EditingDomain getEmfEditingDomain() {
        return emfEditingDomain;
    }

    Object[] filter( Object parent, Object[] elements ) {
        Object result[] = elements;
        for( ViewerFilter filter : viewerFilterList ) {
            result = filter.filter( null, parent, result );
        }
        // TODO Auto-generated method stub
        return result;
    }
}