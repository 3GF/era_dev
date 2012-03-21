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
package era.foss.typeeditor;

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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.CellEditorProperties;
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

    /** Table viewer holding the attributes of a spec type. */
    private AddDeleteTableViewer tableViewer;

    /** object for create data binding from model to UI widgets */
    private DataBindingContext dataBindContext;

    /**
     * Instantiates a new spec type form.
     * 
     * @param parent the parent
     * @param editor the editor
     */
    public SpecTypeForm( Composite parent, IEditorPart editor ) {
        super( parent, editor, SWT.NONE );

        dataBindContext = new DataBindingContext();

        // set-up layout
        GridLayout gridLayout = new GridLayout( 2, true );
        this.setLayout( gridLayout );

        // set up table viewer for attribute definitions
        createTableViewer();

        // set up viewer for details
        createDetailViewer();
    }

    /**
     * Create Table viewer showing attributes.
     */
    private void createTableViewer() {

        tableViewer = new AddDeleteTableViewer( this, SWT.MULTI | SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION );
        tableViewer.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true ) );

        tableViewer.setEditingDomain( editingDomain );
        tableViewer.setElementInformation( theOneAndOnlySpecType,
                                           ErfPackage.Literals.SPEC_TYPE__SPEC_ATTRIBUTES,
                                           ErfPackage.Literals.ATTRIBUTE_DEFINITION_SIMPLE );

        ObservableListContentProvider contentProvider = new ObservableListContentProvider();
        tableViewer.setContentProvider( contentProvider );

        TableColumnLayout columnLayout = (TableColumnLayout)tableViewer.getTable().getParent().getLayout();

        // create column with name of attribute definition
        createNameColumn( contentProvider, columnLayout );

        // create column with reference to datatype defintion
        createTypeColumn( contentProvider, columnLayout );

        // provide input for the table
        IEMFListProperty specAttributesProperty = EMFProperties.list( ErfPackage.Literals.SPEC_TYPE__SPEC_ATTRIBUTES );
        tableViewer.setInput( specAttributesProperty.observe( theOneAndOnlySpecType ) );

    }

    /** Create column for selecting the DatatypeDefinition associated with the AttributeDefinition */
    private void createNameColumn( ObservableListContentProvider contentProvider, TableColumnLayout columnLayout ) {

        //
        TableViewerColumn nameColumn = new TableViewerColumn( tableViewer, SWT.NONE );

        nameColumn.getColumn().setText( Ui.getUiName( ErfPackage.Literals.IDENTIFIABLE__LONG_NAME ) );
        nameColumn.getColumn().setResizable( true );
        nameColumn.getColumn().setMoveable( false );
        columnLayout.setColumnData( nameColumn.getColumn(), new ColumnWeightData( 34, 100 ) );
        IValueProperty nameColumnElementProperty = EMFEditProperties.value( editingDomain,
                                                                            ErfPackage.Literals.IDENTIFIABLE__LONG_NAME );
        // add label provider
        IObservableMap nameColumnAttributeMap = nameColumnElementProperty.observeDetail( contentProvider.getKnownElements() );
        nameColumn.setLabelProvider( new ObservableMapCellLabelProvider( nameColumnAttributeMap ) );

        // add editing support
        IValueProperty nameColumnCellEditorProperty = CellEditorProperties.control()
                                                                          .value( WidgetProperties.text( SWT.Modify ) );
        EditingSupport editingSupport = ObservableValueEditingSupport.create( tableViewer,
                                                                              dataBindContext,
                                                                              new TextCellEditor(
                                                                                  tableViewer.getTable() ),
                                                                              nameColumnCellEditorProperty,
                                                                              nameColumnElementProperty );
        nameColumn.setEditingSupport( editingSupport );

    }

    /** Create column for selecting the DatatypeDefinition associated with the AttributeDefinition */
    private void createTypeColumn( ObservableListContentProvider contentProvider, TableColumnLayout columnLayout ) {

        TableViewerColumn dataTypeColumn = new TableViewerColumn( tableViewer, SWT.NONE );
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
            dataTypeNameProperty.observeDetail( contentProvider.getKnownElements() ) );
        dataTypeColumn.setLabelProvider( labelProvider );

        // add editing support
        dataTypeColumn.setEditingSupport( new AttributeDefinitionTypeEditingSupport( tableViewer ) );

    }

    /**
     * create detailed viewer for selected element.
     */
    private void createDetailViewer() {
        // setup Data type properties viewer
        AttributeDefinitionDetailViewer detailViewer = new AttributeDefinitionDetailViewer(
            this,
            SWT.NONE,
            editingDomain,
            ViewerProperties.singleSelection().observe( tableViewer ) );
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
