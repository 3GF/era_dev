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
package era.foss.typeeditor.view;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.viewers.IViewerObservableValue;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableValueEditingSupport;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IEditorPart;

import era.foss.erf.AttributeDefinition;
import era.foss.erf.EraToolExtension;
import era.foss.erf.ErfPackage;
import era.foss.erf.SpecType;
import era.foss.erf.ToolExtension;
import era.foss.erf.View;
import era.foss.erf.ViewElement;
import era.foss.objecteditor.EraCommandStack;
import era.foss.typeeditor.Activator;
import era.foss.typeeditor.common.AbstractErfTypesForm;
import era.foss.typeeditor.common.AddDeleteTableViewer;
import era.foss.typeeditor.common.BindingCheckBox;
import era.foss.typeeditor.common.Ui;
import era.foss.typeeditor.view.layoutviewer.ViewLayoutViewer;
import era.foss.ui.contrib.CheckingSelectionChangedListener;
import era.foss.ui.contrib.ComboBoxViewerCellEditorSp;

/**
 * The topmost UI class of the typeeditor plug-in: representing the overall dialog.
 * <p>
 * Structured by a tab folder for which it instantiates forms for DatatypeDefinitions and SpecificationTypes.
 * <p>
 * Instantiates the {@link EraCommandStack} for handling the OK and Cancel buttons.
 * 
 */
public class ViewForm extends AbstractErfTypesForm {

    /**
     * Era Tool extension model object
     */
    private EraToolExtension toolExtension;

    /** The databinding context for binding model elements to widgets show in this dialog */
    DataBindingContext dataBindContext;

    /** Master object for observing the selected {@link View}s */
    private IViewerObservableValue viewMaster;

    /** Master object for observing the selected {@link SpecType} */
    private IViewerObservableValue specTypeMaster;

    /** Master object for observing the selected {@link ViewElement}s */
    private IViewerObservableValue viewElementMaster;

    /** table viewer showing holding view elements */
    private AddDeleteTableViewer viewElementTableViewer;

    /** gef viewer showing layout of view elements in a view */
    ViewLayoutViewer viewLayoutViewer;

    /**
     * Checks if the {@link AttributeDefinition} refers to the same {@link SpecType} as is selected in
     * {@link specTypeMaster}
     */
    class SpecTypeFilter extends ViewerFilter {

        @Override
        public boolean select( Viewer viewer, Object parentElement, Object element ) {
            assert (element instanceof ViewElement);
            ViewElement viewElement = (ViewElement)element;
            if( (ViewForm.this.specTypeMaster.getValue() != null)
                && ((viewElement.getAttributeDefinition() == null) || (viewElement.getAttributeDefinition()
                                                                                  .getSpecType().equals( ViewForm.this.specTypeMaster.getValue() ))) ) {
                return true;
            }
            return false;
        }
    }

    /**
     * Creates a editor for {@link View} elements.
     *
     * @param parent the parent
     * @param editor the editor
     */
    public ViewForm( Composite parent, IEditorPart editor ) {
        super( parent, editor, SWT.NONE );

        // find Era specific tool extensions
        for( ToolExtension toolExtension : this.erfModel.getToolExtensions() ) {
            if( toolExtension.eClass().getClassifierID() == ErfPackage.ERA_TOOL_EXTENSION ) {
                this.toolExtension = (EraToolExtension)toolExtension;
            }
        }
        // The existence of the EraToolExtension object as part of the model is currently
        // guaranteed by the EraModelWizard that creates it explicitly
        assert (this.toolExtension != null);

        dataBindContext = new DataBindingContext();

        this.setLayout( new GridLayout( 4, true ) );

        createViewTableViewer( this );
        createViewElementComposite( this );
        createViewLayoutViewer( this );
        createDetails( this );
    }

    /**
     * Creates the table viewer for {@link View}s
     */
    private void createViewTableViewer( Composite parent ) {

        AddDeleteTableViewer viewTableViewer = new AddDeleteTableViewer( parent, SWT.MULTI
            | SWT.V_SCROLL
            | SWT.BORDER
            | SWT.FULL_SELECTION );
        
        viewTableViewer.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true, 1, 2 ) );
        viewTableViewer.setEditingDomain( editingDomain );
        viewTableViewer.setElementInformation( toolExtension,
                                               ErfPackage.Literals.ERA_TOOL_EXTENSION__VIEWS,
                                               ErfPackage.Literals.VIEW );

        ObservableListContentProvider cp = new ObservableListContentProvider();
        viewTableViewer.setContentProvider( cp );

        TableColumnLayout columnLayout = (TableColumnLayout)viewTableViewer.getTable().getParent().getLayout();

        // create column with name of the view
        TableViewerColumn nameColumn = new TableViewerColumn( viewTableViewer, SWT.NONE );
        columnLayout.setColumnData( nameColumn.getColumn(), new ColumnWeightData( 100, 70 ) );
        nameColumn.getColumn().setResizable( false );
        nameColumn.getColumn().setMoveable( false );
        nameColumn.getColumn().setText( Ui.getUiName( ErfPackage.Literals.IDENTIFIABLE__LONG_NAME ) );
        ui.bindColumn( nameColumn, new EStructuralFeature[]{ErfPackage.Literals.IDENTIFIABLE__LONG_NAME} );

        // provide input for the table
        IEMFListProperty viewsProperty = EMFProperties.list( ErfPackage.Literals.ERA_TOOL_EXTENSION__VIEWS );
        viewTableViewer.setInput( viewsProperty.observe( toolExtension ) );
        viewTableViewer.getTable().select( 0 );

        this.viewMaster = ViewerProperties.singleSelection().observe( viewTableViewer );

    }

    /**
     * Creates the composite holding the selection of the {@link SpecType} and the table of the {@link ViewElement}
     */
    private void createViewElementComposite( Composite parent ) {

        // composite holding the selection of the specType and the table of the viewElements
        Composite viewElementComposite = new Composite( parent, SWT.NONE );
        viewElementComposite.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true, 1, 2 ) );
        viewElementComposite.setLayout( new GridLayout() );

        Label specTypeLabel = new Label( viewElementComposite, SWT.NONE );
        specTypeLabel.setText( Ui.getUiName( ErfPackage.Literals.SPEC_TYPE ) );
        specTypeLabel.setLayoutData( new GridData( SWT.LEFT, SWT.BOTTOM, true, false ) );
        createSpecTypeComboViewer( viewElementComposite );

        Label viewElementsLabel = new Label( viewElementComposite, SWT.NONE );
        viewElementsLabel.setText( Ui.getUiName( ErfPackage.Literals.VIEW__VIEW_ELEMENTS ) );
        viewElementsLabel.setLayoutData( new GridData( SWT.LEFT, SWT.BOTTOM, true, false ) );
        createViewElementTableViewer( viewElementComposite );
    }

    /**
     * Create a Combo box for selecting the {@link SpecType} of the respective view
     * 
     * @param parent parent composite
     */
    private void createSpecTypeComboViewer( Composite parent ) {

        final ComboViewer specTypeComboViewer = new ComboViewer( parent, SWT.READ_ONLY ) {
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
        specTypeComboViewer.getControl().setLayoutData( new GridData( SWT.FILL, SWT.CENTER, true, false ) );

        // set content provider
        specTypeComboViewer.setContentProvider( contentProvider );
        // set label provider
        specTypeComboViewer.setLabelProvider( new ObservableMapLabelProvider(
            EMFProperties.value( ErfPackage.Literals.IDENTIFIABLE__LONG_NAME )
                         .observeDetail( contentProvider.getKnownElements() ) ) );

        // set input
        IEMFListProperty specTypeProperty = EMFProperties.list( ErfPackage.Literals.CONTENT__SPEC_TYPES );
        specTypeComboViewer.setInput( specTypeProperty.observe( this.erfModel.getCoreContent() ) );
        specTypeMaster = ViewerProperties.singleSelection().observe( specTypeComboViewer );
        if( erfModel.getCoreContent().getSpecTypes().size() > 0 ) {
            specTypeComboViewer.setSelection( new StructuredSelection( erfModel.getCoreContent()
                                                                               .getSpecTypes()
                                                                               .get( 0 ) ) );
        }

        specTypeMaster.addValueChangeListener( new IValueChangeListener() {

            @Override
            public void handleValueChange( ValueChangeEvent event ) {
                viewElementTableViewer.refresh();
                viewLayoutViewer.refresh();

            }
        } );
    }

    /**
     * Creates the table viewer for {@link ViewElements}
     * 
     * @param parent parent composite
     */
    private void createViewElementTableViewer( Composite parent ) {

        this.viewElementTableViewer = new AddDeleteTableViewer( parent, SWT.MULTI
            | SWT.V_SCROLL
            | SWT.BORDER
            | SWT.FULL_SELECTION
            | AddDeleteTableViewer.NO_DESCRIPTION ) {

            @Override
            public void addElement() {
                this.elementOwner = (EObject)viewMaster.getValue();
                super.addElement(); // is_a ViewElement
                ViewElement addedViewElement = (ViewElement)super.getElementAt( super.doGetItemCount() - 1 );
                // default placement of views' elements
                addedViewElement.setEditorRowPosition( getCurrentMaxRowIdx() + 1 );
                addedViewElement.setEditorColumnPosition( 0 );
                addedViewElement.setEditorColumnSpan( 2 );
                addedViewElement.setEditorRowSpan( 1 );
            }

            /**
             * Calculates maximum row index of existing view elements
             * 
             * @return maximum row index
             */
            private int getCurrentMaxRowIdx() {
                int maxRowIdx = 0;
                for( int i = 0; i < super.doGetItemCount(); ++i ) {
                    ViewElement iterViewElement = (ViewElement)super.getElementAt( i );
                    maxRowIdx = Math.max( maxRowIdx,
                                          iterViewElement.getEditorRowPosition()
                                              + (iterViewElement.getEditorRowSpan() - 1) );
                }
                return maxRowIdx;
            }
            
            @Override
            protected void createButtonBar() {
                super.createButtonBar();
                // FIXME @cpn create "add all" button
            }
        };

        // the owner is null as it is set in the overridden addElement() method
        viewElementTableViewer.setElementInformation( (EObject)viewMaster.getValue(),
                                                      ErfPackage.Literals.VIEW__VIEW_ELEMENTS,
                                                      ErfPackage.Literals.VIEW_ELEMENT );

        viewElementTableViewer.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true, 1, 2 ) );
        viewElementTableViewer.setEditingDomain( editingDomain );

        ObservableListContentProvider tableViewerContentProvider = new ObservableListContentProvider();
        viewElementTableViewer.setContentProvider( tableViewerContentProvider );

        TableColumnLayout columnLayout = (TableColumnLayout)viewElementTableViewer.getTable().getParent().getLayout();

        // create column showing the Attribute Definition
        TableViewerColumn attributeDefinitionColumn = new TableViewerColumn( viewElementTableViewer, SWT.NONE );
        columnLayout.setColumnData( attributeDefinitionColumn.getColumn(), new ColumnWeightData( 100, 70 ) );
        attributeDefinitionColumn.getColumn().setResizable( false );
        attributeDefinitionColumn.getColumn().setMoveable( false );
        attributeDefinitionColumn.getColumn()
                                 .setText( Ui.getUiName( ErfPackage.Literals.VIEW_ELEMENT__ATTRIBUTE_DEFINITION ) );

        // label provider for column showing the AttributeDefintion
        IValueProperty elementProperty = EMFEditProperties.value( editingDomain,
                                                                  FeaturePath.fromList( new EStructuralFeature[]{
                                                                      ErfPackage.Literals.VIEW_ELEMENT__ATTRIBUTE_DEFINITION,
                                                                      ErfPackage.Literals.IDENTIFIABLE__LONG_NAME} ) );
        IObservableMap attributeMap = elementProperty.observeDetail( tableViewerContentProvider.getKnownElements() );
        attributeDefinitionColumn.setLabelProvider( new ObservableMapCellLabelProvider( attributeMap ) );

        // editing support column showing the AttributeDefintion

        // Combo box: Create combo box to select choices for the reference
        ComboBoxViewerCellEditor combo = new ComboBoxViewerCellEditorSp(
            (Composite)viewElementTableViewer.getControl(),
            SWT.DROP_DOWN | SWT.READ_ONLY );
        // Combo box: Set Content Provider;
        ObservableListContentProvider comboBoxContentProvider = new ObservableListContentProvider();
        combo.setContentProvider( comboBoxContentProvider );

        // Combo box: Set Label Provider
        combo.setLabelProvider( new ObservableMapLabelProvider(
            EMFProperties.value( ErfPackage.Literals.IDENTIFIABLE__LONG_NAME )
                         .observeDetail( comboBoxContentProvider.getKnownElements() ) ) );
        // Combo box: set input from selected specType
        IEMFListProperty specAttributesProperty = EMFProperties.list( ErfPackage.Literals.SPEC_TYPE__SPEC_ATTRIBUTES );
        combo.setInput( specAttributesProperty.observeDetail( specTypeMaster ) );

        // Set editing support of table cell
        IValueProperty editorElementProperty = EMFEditProperties.value( editingDomain,
                                                                        ErfPackage.Literals.VIEW_ELEMENT__ATTRIBUTE_DEFINITION );
        IValueProperty cellEditorProperty = ViewerProperties.singleSelection();

        attributeDefinitionColumn.setEditingSupport( ObservableValueEditingSupport.create( viewElementTableViewer,
                                                                                           dataBindContext,
                                                                                           combo,
                                                                                           cellEditorProperty,
                                                                                           editorElementProperty ) );

        // provide input for the table
        IEMFListProperty viewsProperty = EMFProperties.list( ErfPackage.Literals.VIEW__VIEW_ELEMENTS );
        viewElementTableViewer.addFilter( new SpecTypeFilter() );
        viewElementTableViewer.setInput( viewsProperty.observeDetail( viewMaster ) );

        viewElementMaster = ViewerProperties.singleSelection().observe( viewElementTableViewer );
        viewElementTableViewer.getTable().select( 0 );
    }

    /**
     * Create graphical representation of the layout of the specType in the respective {@link View}
     * 
     * @param parent parent composite
     */
    private void createViewLayoutViewer( Composite parent ) {

        // composite holding the label and the composite with the widgets
        Composite layoutComposite = new Composite( parent, SWT.NONE );
        layoutComposite.setLayout( new GridLayout( 1, true ) );
        layoutComposite.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true, 2, 1 ) );

        // create label for detail viewer
        Label label = new Label( layoutComposite, SWT.NONE );
        label.setLayoutData( new GridData( SWT.LEFT, SWT.TOP, true, false ) );
        label.setText( Activator.INSTANCE.getString( "_UI_View_Layout_label" ) + ":" );

        // create layout viewer
        this.viewLayoutViewer = new ViewLayoutViewer( editingDomain, layoutComposite );
        viewLayoutViewer.getControl().setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true ) );
        viewLayoutViewer.addFilter( new SpecTypeFilter() );
        viewLayoutViewer.setContents( viewMaster );
        viewLayoutViewer.setSelection( viewElementTableViewer.getSelection() );

        // add listeners so that the selections get updated in each viewer
        viewLayoutViewer.addSelectionChangedListener( new CheckingSelectionChangedListener( viewElementTableViewer ) );
        viewElementTableViewer.addSelectionChangedListener( new CheckingSelectionChangedListener( viewLayoutViewer ) );
    }

    /**
     * Creates detailed view for settings of the selected {@link ViewElement}
     * 
     * @param parent parent composite
     */
    private void createDetails( Composite parent ) {

        // composite holding the label and the composite with the widgets
        Composite detailsComposite = new Composite( parent, SWT.NONE );
        detailsComposite.setLayout( new GridLayout( 1, true ) );
        detailsComposite.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true, 2, 1 ) );

        // create label for detail viewer
        Label label = new Label( detailsComposite, SWT.NONE );
        label.setLayoutData( new GridData( SWT.LEFT, SWT.TOP, true, false ) );
        label.setText( Activator.INSTANCE.getString( "_UI_Details_label" ) + ":" );

        // Create composite holding the UI elements of the
        final Composite widgetComposite = new Composite( detailsComposite, SWT.BORDER );
        widgetComposite.setLayout( new GridLayout( 4, true ) );
        widgetComposite.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true ) );

        if( viewElementMaster.getValue() != null ) {
            createDetailWidgets( widgetComposite );
        }

        viewElementMaster.addValueChangeListener( new IValueChangeListener() {

            /**
             * Redraw the composite with the widgets
             */
            @Override
            public void handleValueChange( ValueChangeEvent event ) {

                if( event.diff.getNewValue() == null ) {
                    for( Control control : widgetComposite.getChildren() ) {
                        control.dispose();
                    }
                }

                if( event.diff.getNewValue() != null && event.diff.getOldValue() == null ) {
                    createDetailWidgets( widgetComposite );
                }

                // we need this so that the modified content will be drawn
                widgetComposite.layout();
                widgetComposite.redraw();
                widgetComposite.update();

                widgetComposite.getParent().layout();
                widgetComposite.getParent().redraw();
                widgetComposite.getParent().update();
            }
        } );

    }

    /**
     * Create widgets in the composite showing the details of an {@link ViewElement}
     * 
     * @param parent parent composite
     */
    private void createDetailWidgets( Composite parent ) {

        // create checkbox for editoShowLabel property
        createCheckbox( parent, ErfPackage.Literals.VIEW_ELEMENT__EDITOR_SHOW_LABEL );
    }

    /**
     * Create a checkbox of a structural feature of the selected {@link ViewElement}
     * 
     * @param parent parent composite
     * @param eStructuralFeature the
     */
    private void createCheckbox( Composite parent, EStructuralFeature eStructuralFeature ) {

        // create label
        Label showLabelLabel = new Label( parent, SWT.NONE );
        showLabelLabel.setText( Ui.getUiName( eStructuralFeature ) );
        showLabelLabel.setLayoutData( new GridData( SWT.LEFT, SWT.CENTER, true, false ) );

        // create checkbox
        BindingCheckBox showLabelCheckbox = new BindingCheckBox( parent, SWT.NONE );
        showLabelCheckbox.bind( editingDomain, eStructuralFeature, viewElementMaster );
        showLabelCheckbox.setLayoutData( new GridData( SWT.LEFT, SWT.DEFAULT, true, false ) );

    }

    /*
     * private void createTextField( Composite parent, EStructuralFeature eStructuralFeature ) { // label for
     * editorRowNumber property Label defaultValueLabel = new Label( parent, SWT.NONE ); defaultValueLabel.setText(
     * Ui.getUiName( eStructuralFeature ) ); defaultValueLabel.setLayoutData( new GridData( SWT.LEFT, SWT.CENTER, true,
     * false ) );
     * 
     * // text field for editorRowNumber property BindingText defaultValueTextfield = new BindingText( parent,
     * SWT.BORDER ); defaultValueTextfield.bind( editingDomain, eStructuralFeature, viewElementMaster );
     * defaultValueTextfield.setLayoutData( new GridData( SWT.FILL, SWT.CENTER, true, false ) );
     * 
     * }
     */
}
