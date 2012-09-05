/**************************************************************************
 * ERA - Eclipse Requirements Analysis
 * ==============================================
 * Copyright (C) 2009-2011 by Georg Blaschke, Christoph P. Neumann
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
 * $Id$
 *************************************************************************/
package era.foss.typeeditor.spectype;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.CellEditorProperties;
import org.eclipse.jface.databinding.viewers.IViewerObservableValue;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableValueEditingSupport;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;

import era.foss.erf.AttributeDefinition;
import era.foss.erf.AttributeValueSimple;
import era.foss.erf.DatatypeDefinition;
import era.foss.erf.ErfPackage;
import era.foss.erf.SpecType;
import era.foss.typeeditor.common.AbstractErfTypesForm;
import era.foss.typeeditor.common.AddDeleteTableViewer;
import era.foss.typeeditor.common.Ui;

/**
 * A form for editing the {@link SpecType}.
 * <p>
 * At the moment there exists exactly one {@link SpecType} in an ERA ERF model. The form holds a reference to this
 * single {@link SpecType}.
 * <p>
 * Each {@link SpecType} essentially consists of list of {@link AttributeDefinition}s which are linked to a
 * {@link DatatypeDefinition}.
 * <p>
 * The inner class {@link .AttributesAdapterFactoryContentProvider} is registered to the {@link AddDeleteTableViewer}
 * and extracts all {@link AttributeDefinition}s for a {@link SpecType} from the ERF model -- by the {@link SpecType}'s
 * reference named "specAttributes".
 * <p>
 * The inner class {@link .AttributesLabelProvider} is registered to the {@link AddDeleteTableViewer} and provides the
 * cell values from the {@link AttributeDefinition} element.
 * 
 * @see SpecType
 * @see AttributeDefinition
 * @see AttributeValueSimple
 */
public class SpecTypeForm extends AbstractErfTypesForm {

    /** Table viewer showing the attributes of a SpecType. */
    private AddDeleteTableViewer specAttributeTableViewer;

    /** object for create data binding from model to UI widgets */
    private DataBindingContext dataBindContext;

    /** object for creating and binding ui elements. */
    private Ui ui;

    private IViewerObservableValue specTypeMaster;

    /**
     * Instantiates a new spec type form.
     * 
     * @param parent the parent
     * @param editor the editor
     */
    public SpecTypeForm( Composite parent, IEditorPart editor ) {
        super( parent, editor, SWT.NONE );

        dataBindContext = new DataBindingContext();
        ui = new Ui( editingDomain );

        // set-up layout
        GridLayout gridLayout = new GridLayout( 3, true );
        this.setLayout( gridLayout );

        // set up table viewer for attributes of the selected SpecType
        createSpecTypeTableViewer();

        // set up table viewer for attributes of the selected SpecType
        createSpecAttributeTableViewer();

        // set up viewer for details of a SpecAttribitute
        createSpecAttributeDetailViewer();
    }

    /**
     * Create table viewer showing the SpecTypes
     */
    private void createSpecTypeTableViewer() {
        AddDeleteTableViewer specTypeTableViewer = new AddDeleteTableViewer( this, SWT.MULTI
            | SWT.V_SCROLL
            | SWT.BORDER
            | SWT.FULL_SELECTION );
        specTypeTableViewer.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true ) );
        specTypeTableViewer.setEditingDomain( editingDomain );
        specTypeTableViewer.setElementInformation( erfModel.getCoreContent(),
                                                   ErfPackage.Literals.CONTENT__SPEC_TYPES,
                                                   ErfPackage.Literals.SPEC_TYPE );

        ObservableListContentProvider cp = new ObservableListContentProvider();
        specTypeTableViewer.setContentProvider( cp );

        TableColumnLayout columnLayout = (TableColumnLayout)specTypeTableViewer.getTable().getParent().getLayout();

        // create column with name of the SpecType
        TableViewerColumn nameColumn = new TableViewerColumn( specTypeTableViewer, SWT.NONE );
        columnLayout.setColumnData( nameColumn.getColumn(), new ColumnWeightData( 100, 70 ) );
        nameColumn.getColumn().setResizable( false );
        nameColumn.getColumn().setMoveable( false );
        nameColumn.getColumn().setText( Ui.getUiName( ErfPackage.Literals.IDENTIFIABLE__LONG_NAME ) );
        EStructuralFeature[] structuralFeature = {ErfPackage.Literals.IDENTIFIABLE__LONG_NAME};
        ui.bindColumn( nameColumn, structuralFeature );

        // provide input for the table
        IEMFListProperty specTypeProperty = EMFProperties.list( ErfPackage.Literals.CONTENT__SPEC_TYPES );
        specTypeTableViewer.setInput( specTypeProperty.observe( erfModel.getCoreContent() ) );
        specTypeTableViewer.getTable().select( 0 );

        this.specTypeMaster = ViewerProperties.singleSelection().observe( specTypeTableViewer );
    }

    /**
     * Create Table viewer showing attributes of the selected SpecType
     */
    private void createSpecAttributeTableViewer() {

        specAttributeTableViewer = new AddDeleteTableViewer( this, SWT.MULTI
            | SWT.V_SCROLL
            | SWT.BORDER
            | SWT.FULL_SELECTION ) {

            @Override
            public void addElement() {
                this.elementOwner = (EObject)specTypeMaster.getValue();
                super.addElement();
            }
        };
        specAttributeTableViewer.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true ) );

        specAttributeTableViewer.setEditingDomain( editingDomain );
        specAttributeTableViewer.setElementInformation( (EObject)specTypeMaster.getValue(),
                                                        ErfPackage.Literals.SPEC_TYPE__SPEC_ATTRIBUTES,
                                                        ErfPackage.Literals.ATTRIBUTE_DEFINITION_SIMPLE );

        ObservableListContentProvider contentProvider = new ObservableListContentProvider();
        specAttributeTableViewer.setContentProvider( contentProvider );

        TableColumnLayout columnLayout = (TableColumnLayout)specAttributeTableViewer.getTable()
                                                                                    .getParent()
                                                                                    .getLayout();

        // create column with name of attribute definition
        createSpecAttributeNameColumn( specAttributeTableViewer, columnLayout );

        // create column with reference to datatype defintion
        createSpecAttributeTypeColumn( specAttributeTableViewer, columnLayout );

        // provide input for the table
        IEMFListProperty specAttributeProperty = EMFProperties.list( ErfPackage.Literals.SPEC_TYPE__SPEC_ATTRIBUTES );
        specAttributeTableViewer.setInput( specAttributeProperty.observeDetail( specTypeMaster ) );
        specAttributeTableViewer.getTable().select( 0 );

    }

    /** Create column for selecting the DatatypeDefinition associated with the AttributeDefinition */
    private void createSpecAttributeNameColumn( AddDeleteTableViewer specAttributeTableViewer,
                                                TableColumnLayout columnLayout ) {

        //
        TableViewerColumn nameColumn = new TableViewerColumn( specAttributeTableViewer, SWT.NONE );

        nameColumn.getColumn().setText( Ui.getUiName( ErfPackage.Literals.IDENTIFIABLE__LONG_NAME ) );
        nameColumn.getColumn().setResizable( true );
        nameColumn.getColumn().setMoveable( false );
        columnLayout.setColumnData( nameColumn.getColumn(), new ColumnWeightData( 34, 100 ) );
        IValueProperty nameColumnElementProperty = EMFEditProperties.value( editingDomain,
                                                                            ErfPackage.Literals.IDENTIFIABLE__LONG_NAME );
        // add label provider
        IObservableMap nameColumnAttributeMap = nameColumnElementProperty.observeDetail( ((ObservableListContentProvider)specAttributeTableViewer.getContentProvider()).getKnownElements() );
        nameColumn.setLabelProvider( new ObservableMapCellLabelProvider( nameColumnAttributeMap ) );

        // add editing support
        IValueProperty nameColumnCellEditorProperty = CellEditorProperties.control()
                                                                          .value( WidgetProperties.text( SWT.Modify ) );
        EditingSupport editingSupport = ObservableValueEditingSupport.create( specAttributeTableViewer,
                                                                              dataBindContext,
                                                                              new TextCellEditor(
                                                                                  specAttributeTableViewer.getTable() ),
                                                                              nameColumnCellEditorProperty,
                                                                              nameColumnElementProperty );
        nameColumn.setEditingSupport( editingSupport );

    }

    /** Create column for selecting the DatatypeDefinition associated with the AttributeDefinition */
    private void createSpecAttributeTypeColumn( TableViewer specAttributeTableViewer, TableColumnLayout columnLayout ) {

        TableViewerColumn dataTypeColumn = new TableViewerColumn( specAttributeTableViewer, SWT.NONE );
        dataTypeColumn.getColumn().setText( Ui.getUiName( ErfPackage.Literals.ATTRIBUTE_DEFINITION__TYPE ) );
        dataTypeColumn.getColumn().setResizable( false );
        dataTypeColumn.getColumn().setMoveable( false );
        columnLayout.setColumnData( dataTypeColumn.getColumn(), new ColumnWeightData( 33, 100 ) );
        IValueProperty dataTypeNameProperty = EMFEditProperties.value( editingDomain,
                                                                       FeaturePath.fromList( new EStructuralFeature[]{
                                                                           ErfPackage.Literals.ATTRIBUTE_DEFINITION__TYPE,
                                                                           ErfPackage.Literals.IDENTIFIABLE__LONG_NAME} ) );

        // add label provider
        ObservableMapCellLabelProvider labelProvider = new ObservableMapCellLabelProvider(
            dataTypeNameProperty.observeDetail( ((ObservableListContentProvider)specAttributeTableViewer.getContentProvider()).getKnownElements() ) );
        dataTypeColumn.setLabelProvider( labelProvider );

        // add editing support
        dataTypeColumn.setEditingSupport( new AttributeDefinitionTypeEditingSupport( specAttributeTableViewer ) );

    }

    /**
     * create detailed viewer for selected element.
     */
    private void createSpecAttributeDetailViewer() {
        // setup Data type properties viewer
        AttributeDefinitionDetailViewer detailViewer = new AttributeDefinitionDetailViewer(
            this,
            SWT.NONE,
            editingDomain,
            ViewerProperties.singleSelection().observe( specAttributeTableViewer ) );
        detailViewer.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true ) );

    }

    /**
     * The Class DatatypeDefinitionEditingSupport.
     */
    private class AttributeDefinitionTypeEditingSupport extends EditingSupport {

        /** The cell editor. */
        private CellEditor cellEditor;

        /**
         * Instantiates a new datatype definition editing support.
         * 
         * @param viewer the viewer
         * @param column the column
         */
        public AttributeDefinitionTypeEditingSupport( ColumnViewer viewer ) {
            super( viewer );
            ComboBoxViewerCellEditor comboCellEditor = new ComboBoxViewerCellEditor(
                ((TableViewer)viewer).getTable(),
                SWT.READ_ONLY );
            // set content provider
            ObservableListContentProvider contentProvider = new ObservableListContentProvider();
            comboCellEditor.setContenProvider( contentProvider );
            // set label provider
            comboCellEditor.setLabelProvider( new ObservableMapLabelProvider(
                EMFProperties.value( ErfPackage.Literals.IDENTIFIABLE__LONG_NAME )
                             .observeDetail( contentProvider.getKnownElements() ) ) );
            IEMFListProperty dataTypeDefinitions = EMFProperties.list( ErfPackage.Literals.CONTENT__DATA_TYPES );
            comboCellEditor.setInput( dataTypeDefinitions.observe( erfModel.getCoreContent() ) );

            this.cellEditor = comboCellEditor;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.EditingSupport#canEdit(java.lang.Object)
         */
        @Override
        protected boolean canEdit( Object element ) {
            return true;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.EditingSupport#getCellEditor(java.lang.Object)
         */
        @Override
        protected CellEditor getCellEditor( Object element ) {
            return this.cellEditor;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.EditingSupport#getValue(java.lang.Object)
         */
        @Override
        protected Object getValue( Object element ) {
            return ((AttributeDefinition)element).getType();
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.EditingSupport#setValue(java.lang.Object, java.lang.Object)
         */
        @Override
        protected void setValue( Object element, Object value ) {
            assert (element instanceof AttributeDefinition);
            AttributeDefinition attributeDefinition = (AttributeDefinition)element;

            assert (value instanceof DatatypeDefinition);
            DatatypeDefinition newDatatypeDefinition = (DatatypeDefinition)value;

            if( newDatatypeDefinition != null
                && attributeDefinition.getType() != null
                && attributeDefinition.getType().getID() == newDatatypeDefinition.getID() ) {
                // do nothing as exactly the same Datatype has been set as it was before
                return;
            }
            EList<Adapter> l = new BasicEList<Adapter>( attributeDefinition.eAdapters() );
            attributeDefinition.eAdapters().clear();
            // set selected DatatypeDefintion
            Command setCommand = new SetCommand(
                editingDomain,
                attributeDefinition,
                ErfPackage.Literals.ATTRIBUTE_DEFINITION__TYPE,
                newDatatypeDefinition );
            editingDomain.getCommandStack().execute( setCommand );

            // adapt AttributeDefintion to selected datatypeDefinition
            AttributeDefinition newAttributeDefinition = adaptAttributeDefintion( attributeDefinition );

            if( attributeDefinition.eClass().getClassifierID() != newAttributeDefinition.eClass().getClassifierID() ) {
                // reset the cellEditor (remember: there is only one object, which handles all cell in its row)
                // because the selected value must not propagate if another row is selected
                ((ComboBoxViewerCellEditor)this.cellEditor).setValue( null );
                ((CCombo)((ComboBoxViewerCellEditor)this.cellEditor).getControl()).clearSelection();

                // set the selection of the viewer to the newly created AttributeDefintion object
                super.getViewer().setSelection( new StructuredSelection( newAttributeDefinition ) );

            } else {
                attributeDefinition.eAdapters().addAll( l );
            }

            // refresh the tableViewer
            super.getViewer().refresh();

        }
    }

}
