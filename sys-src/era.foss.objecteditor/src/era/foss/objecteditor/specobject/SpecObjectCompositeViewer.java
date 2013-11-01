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
package era.foss.objecteditor.specobject;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.viewers.IViewerObservableValue;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IInputSelectionProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.nebula.widgets.compositetable.CompositeTable;
import org.eclipse.swt.nebula.widgets.compositetable.IRowContentProvider;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import era.foss.erf.ERF;
import era.foss.erf.EraToolExtension;
import era.foss.erf.ErfPackage;
import era.foss.erf.SpecObject;
import era.foss.erf.SpecType;
import era.foss.erf.ToolExtension;
import era.foss.erf.contrib.HierachicalSpecObjectProvider;
import era.foss.objecteditor.contrib.IAllowViewerSchemaChange;
import era.foss.objecteditor.contrib.SpecObjectHandler;
import era.foss.ui.contrib.NotifyingListSizeProperty;

/**
 * The Class SpecObjectCompositeViewer.
 */
public class SpecObjectCompositeViewer extends Viewer implements IInputSelectionProvider, IAllowViewerSchemaChange {

    /** Master observable referring to the currently selected view. */
    IViewerObservableValue viewMaster;

    /** ERF Model. */
    ERF erfModel;

    /** ERA specific extensions. */
    EraToolExtension toolExtension;

    /** top level composite of this viewer. */
    Composite topLevelComposite;

    /** composite table showing the spec objects. */
    CompositeTable compositeTable;

    /** Button bar for various buttons (adding elements, selecting views,... */
    Composite buttonBarComposite;

    /** editing Domain. */
    EditingDomain editingDomain;

    /** Databinding context for this viewer. */
    DataBindingContext dbc;

    /** The current selected SpecObjects. */
    protected LinkedHashMap<Integer, SpecObject> selectedSpecObjectMap = new LinkedHashMap<Integer, SpecObject>();

    /** List of selection changed listeners of this viewer. */
    List<ISelectionChangedListener> selectionChangedListeners = new LinkedList<ISelectionChangedListener>();

    HierachicalSpecObjectProvider specObjectProvider;

    /** The spec type master. */
    protected IObservableValue specTypeMaster;

    /**
     * Create a Viewer for the SpecObjects.
     * 
     * @param parent the parent
     * @param editingDomain the editing domain
     * @param erfModel the erf model
     */
    public SpecObjectCompositeViewer( Composite parent, AdapterFactoryEditingDomain editingDomain, ERF erfModel ) {
        this.editingDomain = editingDomain;
        this.erfModel = erfModel;
        this.dbc = new DataBindingContext();

        // find Era specific tool extensions
        for( ToolExtension toolExtension : this.erfModel.getToolExtensions() ) {
            if( toolExtension.eClass().getClassifierID() == ErfPackage.ERA_TOOL_EXTENSION ) {
                this.toolExtension = (EraToolExtension)toolExtension;
            }
        }
        assert (this.toolExtension != null);

        specObjectProvider = new HierachicalSpecObjectProvider( this.erfModel.getCoreContent()
                                                                             .getSpecifications()
                                                                             .get( 0 ) );

        doLayout( parent );

        // binding the UI with the model
        binding();

    }

    /**
     * layout the viewer gui elements
     * 
     * @param parent
     */
    void doLayout( Composite parent ) {
        topLevelComposite = new Composite( parent, SWT.NONE );
        topLevelComposite.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true ) );
        topLevelComposite.setLayout( new GridLayout( 1, false ) );

        // button bar
        createButtonBar();

        createCompositeTable();
    }

    /**
     * Create the composite table
     */
    private void createCompositeTable() {
        // composite table
        this.compositeTable = new CompositeTable( topLevelComposite, SWT.NULL | SWT.NO_SCROLL );
        this.compositeTable.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true, 0, 0 ) );

        SpecObjectViewerRow.setViewMaster( viewMaster );
        SpecObjectViewerRow.setEditingDomain( editingDomain );
        SpecObjectViewerRow.setErfModel( erfModel );
        new SpecObjectViewerRow( compositeTable, SWT.NULL );

        compositeTable.setRunTime( true );
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.Viewer#getControl()
     */
    @Override
    public Control getControl() {
        return topLevelComposite;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.Viewer#refresh()
     */
    @Override
    public void refresh() {
        compositeTable.refreshAllRows();
    }

    @Override
    public void recreateViewerSchema() {

        dbc.dispose();
        viewMaster.dispose();

        buttonBarComposite.dispose();
        createButtonBar();

        compositeTable.dispose();
        createCompositeTable();

        binding();

        topLevelComposite.layout();
        // buttonBarComposite.layout();
        // viewerComposite.update();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.Viewer#getInput()
     */
    @Override
    public Object getInput() {
        // TODO implement getInput(..) which stems from IInputProvider
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.Viewer#setInput(java.lang.Object)
     */
    @Override
    public void setInput( Object input ) {
        // TODO implement setInput(..)
    }

    /**
     * A row of the composite table
     */

    /**
     * Create button bar showing:
     * <ul>
     * <li>combo box for the view</li>
     * <li>button for adding new SpecObjects</li>
     * </ul>
     * 
     * 
     * @param viewerComposite the parent composite
     * @return
     */
    private void createButtonBar() {
        buttonBarComposite = new Composite( topLevelComposite, SWT.NONE );
        buttonBarComposite.setLayout( new GridLayout( 4, true ) );
        buttonBarComposite.setLayoutData( new GridData( SWT.FILL, SWT.TOP, true, false, 0, 0 ) );

        /*
         * create combo box showing the availible views
         */
        ComboViewer viewComboViewer = new ComboViewer( buttonBarComposite, SWT.READ_ONLY ) {
            @Override
            protected void doUpdateItem( Widget data, Object element, boolean fullMap ) {
                // memorize the selection before updating the item, as the
                // update routine removes the selection...
                ISelection currentSelection = this.getSelection();
                super.doUpdateItem( data, element, fullMap );
                // set the selection to the previous value
                this.setSelection( currentSelection );
            }
        };
        ObservableListContentProvider contentProvider = new ObservableListContentProvider();
        viewComboViewer.setContentProvider( contentProvider );
        viewComboViewer.setLabelProvider( new ObservableMapLabelProvider(
            EMFProperties.value( ErfPackage.Literals.IDENTIFIABLE__LONG_NAME )
                         .observeDetail( contentProvider.getKnownElements() ) ) );
        IEMFListProperty dataTypeDefinitions = EMFProperties.list( ErfPackage.Literals.ERA_TOOL_EXTENSION__VIEWS );
        IObservableList observableList = dataTypeDefinitions.observe( toolExtension );
        viewComboViewer.setInput( observableList );
        // use first view available
        // TODO: use a dedicated default view if available
        if( toolExtension.getViews().size() > 0 ) {
            viewComboViewer.setSelection( new StructuredSelection( toolExtension.getViews().get( 0 ) ) );
        }
        viewComboViewer.getControl().setLayoutData( new GridData( SWT.LEFT, SWT.CENTER, true, false, 2, 1 ) );

        viewMaster = ViewerProperties.singleSelection().observe( viewComboViewer );

        // refresh composite table in case view has been changed
        viewMaster.addChangeListener( new IChangeListener() {

            @Override
            public void handleChange( ChangeEvent event ) {
                dbc.dispose();

                compositeTable.dispose();
                createCompositeTable();

                binding();

                topLevelComposite.layout();
            }
        } );

        /*
         * Create Combo box for selecting the SpecType
         */
        final ComboViewer specTypecomboViewer = new ComboViewer( buttonBarComposite, SWT.READ_ONLY ) {
            @Override
            protected void doUpdateItem( Widget data, Object element, boolean fullMap ) {
                // memorize the selection before updating the item, as the
                // update routine removes the selection...
                ISelection currentSelection = this.getSelection();
                super.doUpdateItem( data, element, fullMap );
                // set the selection to the previous value
                this.setSelection( currentSelection );
            }
        };
        ObservableListContentProvider comboViewercontentProvider = new ObservableListContentProvider();
        specTypecomboViewer.getControl().setLayoutData( new GridData( SWT.RIGHT, SWT.CENTER, true, false ) );
        // set content provider
        specTypecomboViewer.setContentProvider( comboViewercontentProvider );
        // set label provider
        specTypecomboViewer.setLabelProvider( new ObservableMapLabelProvider(
            EMFProperties.value( ErfPackage.Literals.IDENTIFIABLE__LONG_NAME )
                         .observeDetail( comboViewercontentProvider.getKnownElements() ) ) );
        // set input
        IEMFListProperty specTypeProperty = EMFProperties.list( ErfPackage.Literals.CONTENT__SPEC_TYPES );
        specTypecomboViewer.setInput( specTypeProperty.observe( this.erfModel.getCoreContent() ) );

        // TODO: use a dedicated default type if available
        if( erfModel.getCoreContent().getSpecTypes().size() > 0 ) {
            specTypecomboViewer.setSelection( new StructuredSelection( erfModel.getCoreContent()
                                                                               .getSpecTypes()
                                                                               .get( 0 ) ) );
        }
        specTypeMaster = ViewerProperties.singleSelection().observe( specTypecomboViewer );

        /*
         * create add button
         */
        final Button addButton = new Button( buttonBarComposite, SWT.NONE );
        addButton.setImage( PlatformUI.getWorkbench().getSharedImages().getImage( ISharedImages.IMG_OBJ_ADD ) );
        addButton.setLayoutData( new GridData( SWT.RIGHT, SWT.CENTER, true, false ) );
        addButton.setEnabled( specTypeMaster.getValue() != null );
        addButton.addSelectionListener( new SelectionAdapter() {
            @Override
            public void widgetSelected( SelectionEvent e ) {
                SpecObjectHandler.createNewSpecObject( editingDomain,
                                                       erfModel,
                                                       (SpecType)SpecObjectCompositeViewer.this.specTypeMaster.getValue(),
                                                       erfModel.getCoreContent().getSpecifications().get( 0 ) );
            }
        } );

        specTypeMaster.addValueChangeListener( new IValueChangeListener() {
            @Override
            public void handleValueChange( ValueChangeEvent event ) {
                addButton.setEnabled( event.getObservableValue().getValue() != null );
            }
        } );

    }

    /**
     * Bind composite table and rows of composite table to data model. Also handle selection events from the composite
     * table
     */
    private void binding() {

        dbc.bindValue( PojoObservables.observeValue( compositeTable, "numRowsInCollection" ),
                       new NotifyingListSizeProperty().observe( specObjectProvider.getSpecObjectList() ),
                       new UpdateValueStrategy( UpdateValueStrategy.POLICY_NEVER ),
                       new UpdateValueStrategy() );

        compositeTable.addRowContentProvider( new SpecObjectRowContentProvider() );
    }

    @Override
    public void addSelectionChangedListener( ISelectionChangedListener listener ) {
        if( !selectionChangedListeners.contains( listener ) ) {
            selectionChangedListeners.add( listener );
        }
    }

    @Override
    public void removeSelectionChangedListener( ISelectionChangedListener listener ) {
        selectionChangedListeners.remove( listener );
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.Viewer#getSelection()
     */
    @Override
    public ISelection getSelection() {
        if( selectedSpecObjectMap.size() == 0 ) {
            return StructuredSelection.EMPTY;
        }
        return new StructuredSelection( selectedSpecObjectMap.values().toArray() );
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setSelection( ISelection selection, boolean reveal ) {
        if( selection.isEmpty() ) {
            return;
        }

        // unpack ISelection into SpecObject
        assert (selection instanceof StructuredSelection);

        // remove all Spec Objects
        selectedSpecObjectMap.clear();

        Integer selectedSpecOjectOffset = null;

        // set selectedSpecObject to given one
        for( SpecObject specObject : ((List<SpecObject>)((StructuredSelection)selection).toList()) ) {
            int specOjectOffset = specObjectProvider.getSpecObjectList().indexOf( specObject );
            if( selectedSpecOjectOffset == null ) {
                selectedSpecOjectOffset = specOjectOffset;
            }

            selectedSpecObjectMap.put( specOjectOffset, specObject );
        }

        // if specObject is not yet displayed in the composite table show it in the first row
        if( selectedSpecOjectOffset < compositeTable.getTopRow()
            || selectedSpecOjectOffset > (compositeTable.getTopRow() + compositeTable.getNumRowsVisible()) ) {
            compositeTable.setTopRow( selectedSpecOjectOffset );
            updateRowSelectionStatus( true );
        } else {
            updateRowSelectionStatus( false );
        }

    }

    /**
     * Update the selection status of all rows controls
     */
    private void updateRowSelectionStatus( boolean setFocus ) {
        for( Control control : compositeTable.getRowControls() ) {
            SpecObjectViewerRow row = (SpecObjectViewerRow)control;
            row.setSelected( selectedSpecObjectMap.containsKey( row.getSpecObjectOffset() ), setFocus );
        }

        // send event to selectionChangedListener
        SelectionChangedEvent selectionChangeEvent = new SelectionChangedEvent(
            SpecObjectCompositeViewer.this,
            new StructuredSelection( selectedSpecObjectMap.values().toArray() ) );
        for( ISelectionChangedListener listener : selectionChangedListeners ) {
            listener.selectionChanged( selectionChangeEvent );
        }
    }

    /**
     * Content Provider for Row in the Composite table.
     */
    private class SpecObjectRowContentProvider implements IRowContentProvider {

        /**
         * Keeps a reference of each delete listener for each row, so we can remove a listener when compositetable
         * associate the row to another SpecObject.
         */
        private Map<SpecObjectViewerRow, MouseListener> deleteListenerMap = new HashMap<SpecObjectViewerRow, MouseListener>();

        /**
         * Keeps a reference of each selection listener for each row, so we can remove a listener when compositetable
         * associate the row to another SpecObject.
         */
        private Map<SpecObjectViewerRow, SelectionListener> selectionListenerMap = new HashMap<SpecObjectViewerRow, SelectionListener>();

        /**
         * remove and add selectionlistener bind new SpecObject to Row
         */
        public void refresh( CompositeTable sender, final int currentObjectOffset, Control rowControl ) {

            final SpecObjectViewerRow currentRow = (SpecObjectViewerRow)rowControl;
            final SpecObject currentSpecObject = specObjectProvider.getSpecObjectList().get( currentObjectOffset );

            // set offset of the current specObject
            currentRow.setSpecObject( currentSpecObject, currentObjectOffset );

            // bind the new SpecObject
            currentRow.bind( currentSpecObject );

            // in case the specObject is selected set the selected status of the row
            currentRow.setSelected( selectedSpecObjectMap.containsKey( currentObjectOffset ), false );

            // listener for the delete button of the row
            MouseListener deleteListener = new MouseAdapter() {
                @Override
                public void mouseDown( MouseEvent e ) {
                    SpecObjectHandler.deleteSpecObject( editingDomain, currentSpecObject );
                }
            };

            // listener for selection events of a row
            SelectionListener selectionListener = new SelectionAdapter() {
                @Override
                public void widgetSelected( SelectionEvent e ) {
                    // SHIFT is not pressed: set selection to the SpecObject associated with the current row
                    if( (e.stateMask & SWT.SHIFT) == 0
                        || SpecObjectCompositeViewer.this.selectedSpecObjectMap.isEmpty() ) {
                        SpecObjectCompositeViewer.this.selectedSpecObjectMap.clear();
                        SpecObjectCompositeViewer.this.selectedSpecObjectMap.put( currentObjectOffset,
                                                                                  currentSpecObject );
                    }
                    // SHIFT is pressed: add all elements between the selected SpecObject and the SpecObject
                    // associated with the current row
                    else {
                        int selectedSpecObjectOffset = (Integer)selectedSpecObjectMap.keySet().toArray()[0];

                        int objectOffset = Math.min( currentObjectOffset, selectedSpecObjectOffset );
                        int objectEndOffset = Math.max( currentObjectOffset, selectedSpecObjectOffset );
                        while (objectOffset <= objectEndOffset) {
                            SpecObjectCompositeViewer.this.selectedSpecObjectMap.put( objectOffset,
                                                                                      specObjectProvider.getSpecObjectList()
                                                                                                        .get( objectOffset ) );
                            objectOffset++;
                        }
                    }

                    // Only set the focus in case the event is sent by a composite
                    boolean setFocus = e.widget instanceof Composite;

                    // update the selection status of the row controls
                    SpecObjectCompositeViewer.this.updateRowSelectionStatus( setFocus );
                }
            };

            // add listener to row
            currentRow.addSelectionListener( selectionListener );

            // keep a reference to the listeners to be able to remove it
            // during the next refresh
            deleteListenerMap.put( currentRow, deleteListener );
            selectionListenerMap.put( currentRow, selectionListener );
        }
    }
}
