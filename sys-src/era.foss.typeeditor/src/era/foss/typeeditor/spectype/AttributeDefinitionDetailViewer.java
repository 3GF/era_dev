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
 * $Id: DetailViewer.java 314 2011-04-05 22:28:39Z schorsch $
 *************************************************************************/
package era.foss.typeeditor.spectype;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;

import era.foss.erf.AttributeDefinition;
import era.foss.erf.AttributeDefinitionBoolean;
import era.foss.erf.AttributeDefinitionEnumeration;
import era.foss.erf.AttributeDefinitionSimple;
import era.foss.erf.AttributeValue;
import era.foss.erf.AttributeValueEnumeration;
import era.foss.erf.EnumValue;
import era.foss.erf.ErfPackage;
import era.foss.erf.impl.ErfFactoryImpl;
import era.foss.typeeditor.common.AbstractDetailViewer;
import era.foss.typeeditor.common.BindingCheckBox;
import era.foss.typeeditor.common.BindingText;
import era.foss.typeeditor.common.Ui;

/**
 * Create GUI elements for structural features of EMF model elements.A structural feature is only shown in case it has a
 * annotation 'UI' where the annotation detail key 'Detail' is set to 'true'
 * <p>
 * Currently following structural features are supported:
 * <li>Attributes holding a boolean or string value
 * <li>Containment references
 * 
 */
public class AttributeDefinitionDetailViewer extends AbstractDetailViewer {

    /**
     * @see AbstractDetailViewer#AbstractDetailViewer(Composite, int, EditingDomain, IObservableValue)
     */
    AttributeDefinitionDetailViewer( Composite parent, int style, EditingDomain editingDomain, IObservableValue master ) {
        super( parent, style, editingDomain, master );
    }

    /**
     * create UI elements according to the type of the DatatypeDefition
     */
    protected void createDetails() {

        // In case no dataType definition has been selected
        if( master.getValue() == null ) {
            return;
        }

        // pick function for creating GUI elements according to type of DatatypeDefinition
        ui = new Ui( editingDomain );
        assert (master.getValue() instanceof AttributeDefinition);
        AttributeDefinition attributeDefintion = (AttributeDefinition)master.getValue();

        switch (attributeDefintion.eClass().getClassifierID()) {

        case ErfPackage.ATTRIBUTE_DEFINITION_SIMPLE:
            createDetailsSimple();
            break;

        case ErfPackage.ATTRIBUTE_DEFINITION_BOOLEAN:
            createDetailsBoolean();
            break;

        case ErfPackage.ATTRIBUTE_DEFINITION_ENUMERATION:
            createDetailsEnumeration();
            break;
        }
    }

    /**
     * Show UI elements for DatatypeDefintionInteger
     */
    private void createDetailsSimple() {
        AttributeDefinitionSimple attributeDefinitionSimple = (AttributeDefinitionSimple)master.getValue();

        Button defaultValueCheckbox = createDefaultValueCheckbox( attributeDefinitionSimple,
                                                                  ErfPackage.Literals.ATTRIBUTE_DEFINITION_SIMPLE__DEFAULT_VALUE );

        // label for default value
        Label defaultValueLabel = new Label( detailComposite, SWT.NONE );
        defaultValueLabel.setText( Ui.getUiName( ErfPackage.Literals.ATTRIBUTE_DEFINITION_SIMPLE__DEFAULT_VALUE ) );
        defaultValueLabel.setLayoutData( new GridData( SWT.LEFT, SWT.CENTER, true, false ) );

        // text field for default value
        BindingText defaultValueTextfield = new BindingText( detailComposite, SWT.BORDER );
        defaultValueTextfield.bind( editingDomain, new EStructuralFeature[]{
            ErfPackage.Literals.ATTRIBUTE_DEFINITION_SIMPLE__DEFAULT_VALUE,
            ErfPackage.Literals.ATTRIBUTE_VALUE_SIMPLE__THE_VALUE}, master );
        defaultValueTextfield.setLayoutData( new GridData( SWT.FILL, SWT.CENTER, true, false ) );

        // only enable textfield in case the checkbox is set
        dataBindingContext.bindValue( SWTObservables.observeEnabled( defaultValueTextfield ),
                                      SWTObservables.observeSelection( defaultValueCheckbox ) );

    }

    /**
     * Show UI elements for DatatypeDefintionBoolean
     */
    private void createDetailsBoolean() {
        AttributeDefinitionBoolean attributeDefinitionBoolean = (AttributeDefinitionBoolean)master.getValue();

        Button defaultValueEnableCheckbox = createDefaultValueCheckbox( attributeDefinitionBoolean,
                                                                        ErfPackage.Literals.ATTRIBUTE_DEFINITION_BOOLEAN__DEFAULT_VALUE );

        // label for default value
        Label defaultValueLabel = new Label( detailComposite, SWT.NONE );
        defaultValueLabel.setText( Ui.getUiName( ErfPackage.Literals.ATTRIBUTE_DEFINITION_BOOLEAN__DEFAULT_VALUE ) );
        defaultValueLabel.setLayoutData( new GridData( SWT.LEFT, SWT.CENTER, true, false ) );

        // text field for default value
        BindingCheckBox defaultValueCheckBox = new BindingCheckBox( detailComposite, SWT.NONE );
        defaultValueCheckBox.bind( editingDomain, new EStructuralFeature[]{
            ErfPackage.Literals.ATTRIBUTE_DEFINITION_BOOLEAN__DEFAULT_VALUE,
            ErfPackage.Literals.ATTRIBUTE_VALUE_BOOLEAN__THE_VALUE}, master );
        defaultValueCheckBox.setLayoutData( new GridData( SWT.FILL, SWT.CENTER, true, false ) );

        // only enable textfield in case the checkbox is set
        dataBindingContext.bindValue( SWTObservables.observeEnabled( defaultValueCheckBox ),
                                      SWTObservables.observeSelection( defaultValueEnableCheckbox ) );

    }

    /**
     * Show UI elements for DatatypeDefintionEnumeration
     */
    private void createDetailsEnumeration() {
        final AttributeDefinitionEnumeration attributeDefinitionEnum = (AttributeDefinitionEnumeration)master.getValue();

        // create label for multiValued property
        Label label = new Label( detailComposite, SWT.NONE );
        label.setText( Ui.getUiName( ErfPackage.Literals.ATTRIBUTE_DEFINITION_ENUMERATION__MULTI_VALUED ) );
        label.setLayoutData( new GridData( SWT.LEFT, SWT.CENTER, true, false ) );

        // create checkbox for multiValued property
        EAttribute[] isMultiValued = {ErfPackage.Literals.ATTRIBUTE_DEFINITION_ENUMERATION__MULTI_VALUED};
        BindingCheckBox multiValuedCheckbox = new BindingCheckBox( detailComposite, SWT.NONE );
        multiValuedCheckbox.setLayoutData( new GridData( SWT.LEFT, SWT.DEFAULT, true, false ) );
        multiValuedCheckbox.bind( editingDomain, isMultiValued, master );

        // create checkbox for enabling default value
        Button defaultValueCheckbox = createDefaultValueCheckbox( attributeDefinitionEnum,
                                                                  ErfPackage.Literals.ATTRIBUTE_DEFINITION_ENUMERATION__DEFAULT_VALUE );

        // create table for selecting default EnumValue elements
        Table defaultValueTable = new Table( detailComposite, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION | SWT.CHECK );
        defaultValueTable.setLinesVisible( true );
        defaultValueTable.setHeaderVisible( true );

        final CheckboxTableViewer defaultValueTableViewer = new CheckboxTableViewer( defaultValueTable );
        defaultValueTable.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true, 2, 1 ) );

        final ObservableListContentProvider cp = new ObservableListContentProvider();
        defaultValueTableViewer.setContentProvider( cp );

        TableViewerColumn column = new TableViewerColumn( defaultValueTableViewer, SWT.NONE );

        column.getColumn().setResizable( false );
        column.getColumn().setMoveable( false );
        column.getColumn().setText( Ui.getUiName( ErfPackage.Literals.ATTRIBUTE_VALUE_ENUMERATION__VALUES ) );
        column.getColumn().pack();

        // set label provider
        IValueProperty elementProperty = EMFEditProperties.value( editingDomain,
                                                                  FeaturePath.fromList( new EStructuralFeature[]{ErfPackage.Literals.IDENTIFIABLE__LONG_NAME} ) );
        IObservableMap attributeMap = elementProperty.observeDetail( cp.getKnownElements() );
        column.setLabelProvider( new ObservableMapCellLabelProvider( attributeMap ) );

        // Add provider for the check stare of the table viewer
        // A value is checked if it is referred by the Default value of the AttributeDefintionEnumeration
        defaultValueTableViewer.setCheckStateProvider( new ICheckStateProvider() {
            @Override
            public boolean isGrayed( Object element ) {
                return false;
            }

            @Override
            public boolean isChecked( Object element ) {
                AttributeValueEnumeration enumDefaultValue = attributeDefinitionEnum.getDefaultValue();
                return enumDefaultValue != null && enumDefaultValue.getValues().contains( element );
            }
        } );

        // If a EnumValue is selected add it to the list of Default values for the AttributeDefintionEnumeration
        // Otherwise remove it from the list of default values
        defaultValueTableViewer.addCheckStateListener( new ICheckStateListener() {

            @Override
            public void checkStateChanged( CheckStateChangedEvent event ) {
                // we don't need to check if the default value object is null as
                // in this case table viewer is disabled
                assert (attributeDefinitionEnum.getDefaultValue() != null);

                EnumValue enumValue = ((EnumValue)event.getElement());
                Command command = null;

                if( event.getChecked() == true ) {
                    command = AddCommand.create( editingDomain,
                                                 attributeDefinitionEnum.getDefaultValue(),
                                                 ErfPackage.Literals.ATTRIBUTE_VALUE_ENUMERATION__VALUES,
                                                 enumValue );
                } else {
                    command = RemoveCommand.create( editingDomain,
                                                    attributeDefinitionEnum.getDefaultValue(),
                                                    ErfPackage.Literals.ATTRIBUTE_VALUE_ENUMERATION__VALUES,
                                                    enumValue );
                }
                editingDomain.getCommandStack().execute( command );
            }
        } );

        // observe values of DatatypeDefinition selected for the AttributeDefintionEnumeration
        IEMFListProperty enumerationProperty = EMFProperties.list( FeaturePath.fromList( new EStructuralFeature[]{
            ErfPackage.Literals.ATTRIBUTE_DEFINITION__TYPE,
            ErfPackage.Literals.DATATYPE_DEFINITION_ENUMERATION__SPECIFIED_VALUES} ) );
        IObservableList dataTypeEnumValueObserver = enumerationProperty.observe( attributeDefinitionEnum );
        defaultValueTableViewer.setInput( dataTypeEnumValueObserver );

        // only enable table viewer in case a default value exists
        dataBindingContext.bindValue( SWTObservables.observeEnabled( defaultValueTable ),
                                      SWTObservables.observeSelection( defaultValueCheckbox ) );

    }

    private Button createDefaultValueCheckbox( final AttributeDefinition attributeDefinition,
                                               final EReference defaultValueEReference ) {

        AttributeValue defaultValue = (AttributeValue)attributeDefinition.eGet( defaultValueEReference );

        // label for enabling default value
        Label label = new Label( detailComposite, SWT.NONE );
        label.setText( "Use Default value" );
        label.setLayoutData( new GridData( SWT.LEFT, SWT.CENTER, true, false ) );

        // checkbox for enabling default value
        // when the checkbox is set a default value object will be created
        Button defaultValueCheckbox = new Button( detailComposite, SWT.CHECK );
        defaultValueCheckbox.setSelection( defaultValue != null );
        defaultValueCheckbox.addListener( SWT.Selection, new Listener() {

            @Override
            public void handleEvent( Event event ) {
                Button defaultValueCheckbox = (Button)event.widget;

                AttributeValue defaultValue = (AttributeValue)attributeDefinition.eGet( defaultValueEReference );

                if( defaultValueCheckbox.getSelection() == false ) {
                    if( defaultValue != null ) {
                        Command defaultValueRemoveCommand = RemoveCommand.create( editingDomain, defaultValue );;
                        editingDomain.getCommandStack().execute( defaultValueRemoveCommand );
                    }

                }
                if( defaultValueCheckbox.getSelection() == true ) {
                    if( defaultValue == null ) {

                        AttributeValue newDefaultValue = (AttributeValue)ErfFactoryImpl.eINSTANCE.create( defaultValueEReference.getEReferenceType() );
                        newDefaultValue.setDefinition( attributeDefinition );
                        Command defaultValueAddCommand = AddCommand.create( editingDomain,
                                                                            attributeDefinition,
                                                                            defaultValueEReference.getFeatureID(),
                                                                            newDefaultValue );
                        editingDomain.getCommandStack().execute( defaultValueAddCommand );
                    }
                }
            }
        } );
        return defaultValueCheckbox;
    }
}
