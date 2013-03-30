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

/**
 * The Class ViewLayoutViewer.
 */
public class ViewLayoutViewer extends ScrollingGraphicalViewer {

    /** The Constant ID. */
    public static final String ID = "test.view";

    // GEF editing domain
    /** The gef editing domain. */
    private EditDomain gefEditingDomain;

    // eMF editing domain
    /** The emf editing domain. */
    private EditingDomain emfEditingDomain;

    /** The view master. */
    IViewerObservableValue viewMaster;

    /** The viewer filter list. */
    final private List<ViewerFilter> viewerFilterList = new ArrayList<ViewerFilter>();

    /**
     * Instantiates a new view layout viewer.
     * 
     * @param editingDomain the editing domain
     * @param parent the parent
     */
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

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gef.ui.parts.AbstractEditPartViewer#setContents(java.lang.Object)
     */
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

    /**
     * Refresh.
     */
    public void refresh() {
        ViewLayoutViewer.super.setContents( viewMaster.getValue() );
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gef.ui.parts.AbstractEditPartViewer#getSelection()
     */
    public ISelection getSelection() {

        @SuppressWarnings("unchecked")
        List<EditPart> selectionEditPartList = this.getSelectedEditParts();
        List<Object> modelElementList = new ArrayList<Object>();

        // get model elements of edit parts
        for( EditPart editPart : selectionEditPartList ) {
            modelElementList.add( editPart.getModel() );
        }

        return new StructuredSelection( modelElementList );
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gef.ui.parts.AbstractEditPartViewer#setSelection(org.eclipse.jface.viewers.ISelection)
     */
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
     * add a filter.
     * 
     * @param filter the filter
     */
    public void addFilter( ViewerFilter filter ) {
        this.viewerFilterList.add( filter );
    }

    /**
     * remove a filter.
     * 
     * @param filter the filter
     */
    public void removeFilter( ViewerFilter filter ) {
        this.viewerFilterList.remove( filter );
    }

    /**
     * add the emf editing domain.
     * 
     * @return the emf editing domain
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