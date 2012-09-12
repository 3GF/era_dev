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

package era.foss.typeeditor.datatype;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.ReplaceCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;

import era.foss.erf.AttributeDefinition;
import era.foss.erf.DatatypeDefinition;
import era.foss.erf.ErfPackage;
import era.foss.erf.impl.ErfFactoryImpl;
import era.foss.typeeditor.common.AbstractErfTypesForm;
import era.foss.typeeditor.common.AddDeleteTableViewer;
import era.foss.typeeditor.common.Ui;

/**
 * A form for editing {@link DatatypeDefinition}s.
 * <p>
 * Presents the list of {@link DatatypeDefinition}s in form of an {@link AddDeleteTableViewer}. Each
 * {@link DatatypeDefinition} is presented as row which consists of a user-defined long name and its model-based class
 * name. On row selection the description property of a {@link DatatypeDefinition} can be edited.
 * <p>
 * A properties viewer for any additional {@link DatatypeDefinition} attributes is instantiated.
 * <p>
 * The inner class {@link .DatatypeDefinitionContentProvider} is registered to the {@link AddDeleteTableViewer} and
 * extracts all {@link DatatypeDefinition} elements from the ERF model -- by the model reference named "dataTypes".
 * <p>
 * The inner class {@link .DatatypeDefinitionLabelProvider} is registered to the {@link AddDeleteTableViewer} and
 * provides the cell values from the {@link DatatypeDefinition} element.
 * 
 * 
 * @see DatatypeDefinition
 */
final public class DatatypeDefinitionsForm extends AbstractErfTypesForm {

    /** Table viewer containing the datatype definitions. */
    private AddDeleteTableViewer tableViewer;

    /**
     * Instantiates a new datatype definitions form.
     * 
     * @param parent the parent
     * @param editor the editor
     */
    public DatatypeDefinitionsForm( Composite parent, IEditorPart editor ) {
        super( parent, editor, SWT.NONE );

        // set-up layout
        GridLayout gridLayout = new GridLayout( 2, true );
        this.setLayout( gridLayout );

        createTableViewer();

        // setup Data type properties viewer
        DataTypeDefinitionDetailViewer dataTypeDefinitionDetail = new DataTypeDefinitionDetailViewer(
            this,
            SWT.NONE,
            editingDomain,
            ViewerProperties.singleSelection().observe( tableViewer ) );
        dataTypeDefinitionDetail.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true ) );

    }

    /**
     * The Class DatatypeDefinitionEditingSupport.
     */
    private class DatatypeDefinitionTypeEditingSupport extends EditingSupport {

        /** The cell editor. */
        private CellEditor cellEditor;

        /**
         * Instantiates a new datatype definition editing support.
         * 
         * @param viewer the viewer
         * @param column the column
         */
        public DatatypeDefinitionTypeEditingSupport( ColumnViewer viewer ) {
            super( viewer );
            ComboBoxViewerCellEditor comboCellEditor = new ComboBoxViewerCellEditor(
                ((TableViewer)viewer).getTable(),
                SWT.READ_ONLY );
            comboCellEditor.setContentProvider( new TypesForDatatypeDefinitionComboContentProvider(
                adapterFactory,
                comboCellEditor.getViewer() ) );

            comboCellEditor.setLabelProvider( new TypesForDatatypeDefinitionComboLabelProvider() );
            comboCellEditor.setInput( editingDomain.getResourceSet() );
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
            assert (element instanceof DatatypeDefinition);
            DatatypeDefinition dataType = (DatatypeDefinition)element;
            return dataType.eClass();
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.EditingSupport#setValue(java.lang.Object, java.lang.Object)
         */
        @Override
        protected void setValue( Object element, Object value ) {
            assert (element instanceof DatatypeDefinition);
            DatatypeDefinition dataTypeDefinition = (DatatypeDefinition)element;

            // the value must always be valid (ensured with ComboBox and SWT.READ_ONLY for the cells)
            assert (value instanceof EClass);
            if( ((EClass)value).getClassifierID() == dataTypeDefinition.eClass().getClassifierID() ) {
                // the current data type is the same data type selected in the ComboBox
                // therefore: DO NOTHING
                return;
            }

            // List holding all AttributeDefinitions having this the DatatypeDefinition as type
            List<AttributeDefinition> attributeDefintions = new ArrayList<AttributeDefinition>(
                dataTypeDefinition.getAttributeDefinitions() );

            // clear all adapters of the attribute definition, as these might belong to observables
            // trying to access the elements of the wrong AttributeDefinition
            for( AttributeDefinition attributeDefinition : attributeDefintions ) {
                attributeDefinition.eAdapters().clear();
            }

            // create new a datatypeDefinition based on the value
            DatatypeDefinition newDataTypeDefinition = (DatatypeDefinition)ErfFactoryImpl.eINSTANCE.create( (EClass)value );

            // copy all properties common for all subclasses of DataTypeDefinition
            for( EStructuralFeature datatypeDefinitionEStructuralFeature : ErfPackage.Literals.DATATYPE_DEFINITION.getEAllStructuralFeatures() ) {
                if( datatypeDefinitionEStructuralFeature.isChangeable() == true ) {
                    Command setCommand = new SetCommand(
                        editingDomain,
                        newDataTypeDefinition,
                        datatypeDefinitionEStructuralFeature,
                        dataTypeDefinition.eGet( datatypeDefinitionEStructuralFeature ) );
                    editingDomain.getCommandStack().execute( setCommand );
                }
            }

            // perform the REPLACE
            // remark: the ReplaceCommand issues an REMOVE and ADD notification
            Command replaceCommand = ReplaceCommand.create( editingDomain,
                                                            erfModel.getCoreContent(),
                                                            ErfPackage.Literals.CONTENT__DATA_TYPES,
                                                            dataTypeDefinition,
                                                            Collections.singleton( newDataTypeDefinition ) );

            editingDomain.getCommandStack().execute( replaceCommand );

            // adapt all AttributeDefintions refering to this DatatypeDefinition
            for( AttributeDefinition attributeDefinition : attributeDefintions ) {
                Command setCommand = new SetCommand(
                    editingDomain,
                    attributeDefinition,
                    ErfPackage.Literals.ATTRIBUTE_DEFINITION__TYPE,
                    newDataTypeDefinition );
                editingDomain.getCommandStack().execute( setCommand );
                // attributeDefinition.setType( newDataTypeDefinition );

                adaptAttributeDefintion( attributeDefinition );
            }

            // reset the cellEditor (remember: there is only one object, which handles all cell in its row)
            // because the selected value must not propagate if another row is selected
            ((ComboBoxViewerCellEditor)this.cellEditor).setValue( null );
            ((CCombo)((ComboBoxViewerCellEditor)this.cellEditor).getControl()).clearSelection();

            // set the selection of the viewer to the newly created datatype defintion object
            super.getViewer().setSelection( new StructuredSelection( newDataTypeDefinition ) );

            // refresh the tableViewer
            super.getViewer().refresh();

        }
    }

    /**
     * Label Provider for the Type of the Datatype definition
     */
    public class DatatypeDefinitionTypeLabelProvider extends CellLabelProvider {

        @Override
        public void update( ViewerCell cell ) {
            assert (cell.getElement() instanceof DatatypeDefinition);
            DatatypeDefinition dataType = (DatatypeDefinition)cell.getElement();
            cell.setText( Ui.getUiName( dataType.eClass() ) );
        }
    }

    /**
     * Content provider for the combo box.
     */
    public class TypesForDatatypeDefinitionComboContentProvider extends AdapterFactoryContentProvider {

        /**
         * Instantiates a new types for datatype definition combo content provider.
         * 
         * @param adapterFactory the adapter factory
         * @param viewer the viewer
         */
        public TypesForDatatypeDefinitionComboContentProvider( AdapterFactory adapterFactory, Viewer viewer ) {
            super( adapterFactory );
            this.viewer = viewer;
        }

        /**
         * Get list of typenames for the allowed DatatypeDefinition elements which have to be show in the combobox.
         * 
         * @param object the object
         * @return EClass[] of form (DatatypeDefinition x).eClass()
         * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getElements(java.lang.Object)
         */
        public Object[] getElements( Object object ) {
            EClass supportedDatatypes[] = {
                ErfPackage.Literals.DATATYPE_DEFINITION_INTEGER,
                ErfPackage.Literals.DATATYPE_DEFINITION_STRING,
                ErfPackage.Literals.DATATYPE_DEFINITION_BOOLEAN,
                ErfPackage.Literals.DATATYPE_DEFINITION_ENUMERATION};
            return supportedDatatypes;
        }
    }

    /**
     * Label provider for the Combo box.
     */
    public class TypesForDatatypeDefinitionComboLabelProvider extends LabelProvider implements IBaseLabelProvider {

        @Override
        public String getText( Object element ) {
            assert (element instanceof EClass);
            return Ui.getUiName( (EClass)element );
        }
    }

    /**
     * Creates the table viewer.
     */
    private void createTableViewer() {

        tableViewer = new AddDeleteTableViewer( this, SWT.MULTI | SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION );
        tableViewer.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true ) );
        tableViewer.setEditingDomain( editingDomain );
        tableViewer.setElementInformation( erfModel.getCoreContent(),
                                           ErfPackage.Literals.CONTENT__DATA_TYPES,
                                           ErfPackage.Literals.DATATYPE_DEFINITION_INTEGER );

        ObservableListContentProvider cp = new ObservableListContentProvider();
        tableViewer.setContentProvider( cp );

        TableColumnLayout columnLayout = (TableColumnLayout)tableViewer.getTable().getParent().getLayout();

        // create column with name of the datatype
        TableViewerColumn nameColumn = new TableViewerColumn( tableViewer, SWT.NONE );
        columnLayout.setColumnData( nameColumn.getColumn(), new ColumnWeightData( 100, 70 ) );
        nameColumn.getColumn().setResizable( true );
        nameColumn.getColumn().setMoveable( false );
        nameColumn.getColumn().setText( Ui.getUiName( ErfPackage.Literals.IDENTIFIABLE__LONG_NAME ) );
        EStructuralFeature[] structuralFeature = {ErfPackage.Literals.IDENTIFIABLE__LONG_NAME};
        ui.bindColumn( nameColumn, structuralFeature );

        // create column with type of the datatype
        TableViewerColumn typeColumn = new TableViewerColumn( tableViewer, SWT.NONE );
        columnLayout.setColumnData( typeColumn.getColumn(), new ColumnWeightData( 70, 30 ) );
        typeColumn.getColumn().setResizable( false );
        typeColumn.getColumn().setMoveable( false );
        typeColumn.setEditingSupport( new DatatypeDefinitionTypeEditingSupport( tableViewer ) );
        typeColumn.setLabelProvider( new DatatypeDefinitionTypeLabelProvider() );
        typeColumn.getColumn().setText( typeEditorActivator.getString( "_UI_DataTypeDefinitionType_label" ) );

        // provide input for the table
        IEMFListProperty dataTypeProperty = EMFProperties.list( ErfPackage.Literals.CONTENT__DATA_TYPES );
        tableViewer.setInput( dataTypeProperty.observe( erfModel.getCoreContent() ) );

    }

}
