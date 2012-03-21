package era.foss.objecteditor;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.AbstractListViewer;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

import era.foss.erf.AttributeDefinitionEnumeration;
import era.foss.erf.AttributeValue;
import era.foss.erf.AttributeValueEnumeration;
import era.foss.erf.ErfPackage;
import era.foss.erf.SpecObject;
import era.foss.erf.ViewElement;
import era.foss.erf.impl.ErfFactoryImpl;
import era.foss.ui.contrib.MultiComboViewer;

public class AttributeDefinitionEnumComposite extends AbstractAttributeDefinitionComposite {

    /** The GUI element representing a AttributeDefinitionBoolean */
    AbstractListViewer comboViewer;

    private DefaultModifyListener defaultValueModifyListener;

    private AttributeDefinitionEnumeration attributeDefinition;

    public AttributeDefinitionEnumComposite( Composite parent, ViewElement viewElement, SpecObject specObject ) {
        super( parent, viewElement );

    }

    public Control createControl() {
        attributeDefinition = (AttributeDefinitionEnumeration)viewElement.getAttributeDefinition();

        if( attributeDefinition.isMultiValued() ) {
            comboViewer = new MultiComboViewer( this, SWT.READ_ONLY | SWT.BORDER );
        } else {
            comboViewer = new ComboViewer( new CCombo( this, SWT.READ_ONLY | SWT.BORDER ) );
        }

        ObservableListContentProvider contentProvider = new ObservableListContentProvider();

        // set content provider
        comboViewer.setContentProvider( contentProvider );

        // set label provider
        comboViewer.setLabelProvider( new ObservableMapLabelProvider(
            EMFProperties.value( ErfPackage.Literals.IDENTIFIABLE__LONG_NAME )
                         .observeDetail( contentProvider.getKnownElements() ) ) );

        // set input
        IEMFListProperty dataTypeDefinitions = EMFProperties.list( ErfPackage.Literals.DATATYPE_DEFINITION_ENUMERATION__SPECIFIED_VALUES );
        IObservableList observableList = dataTypeDefinitions.observe( attributeDefinition.getType() );
        comboViewer.setInput( observableList );

        return comboViewer.getControl();
    }

    @Override
    public void doBind( SpecObject specObject, AttributeValue attributeValue, EditingDomain editingDomain ) {
        if( attributeValue == null ) {

            if( attributeDefinition.getDefaultValue() != null ) {
                comboViewer.setSelection( new StructuredSelection( attributeDefinition.getDefaultValue().getValues() ) );
                comboViewer.getControl().setBackground( Display.getDefault().getSystemColor( COLOR_DEFAULT_VALUE ) );
            } else {
                comboViewer.setSelection( StructuredSelection.EMPTY );
                comboViewer.getControl().setBackground( Display.getDefault().getSystemColor( SWT.COLOR_WHITE ) );
            }
            defaultValueModifyListener = new DefaultModifyListener( specObject, editingDomain );
            comboViewer.addSelectionChangedListener( defaultValueModifyListener );

        } else {
            this.binding = dbc.bindList( ViewerProperties.multipleSelection().observe( comboViewer ),
                                         EMFEditProperties.list( editingDomain,
                                                                 ErfPackage.Literals.ATTRIBUTE_VALUE_ENUMERATION__VALUES )
                                                          .observe( attributeValue ) );
            comboViewer.getControl().setBackground( Display.getDefault().getSystemColor( SWT.COLOR_WHITE ) );
        }
    }

    @Override
    public void unbind() {

        if( defaultValueModifyListener != null ) {
            comboViewer.removeSelectionChangedListener( defaultValueModifyListener );
        }
        super.unbind();
    }

    /**
     * Listener whichs adds a AttributeValue to a SpecObject in case no
     * 
     */
    private class DefaultModifyListener implements ISelectionChangedListener {

        /**
         * Spec Object for which a AttributeValue has to be created in case the content of the Text control is changed
         */
        SpecObject specObject;
        EditingDomain editingDomain;

        public DefaultModifyListener( SpecObject specObject, EditingDomain editingDomain ) {
            super();
            this.specObject = specObject;
            this.editingDomain = editingDomain;
        }

        @SuppressWarnings("unchecked")
        @Override
        public void selectionChanged( SelectionChangedEvent e ) {
            AttributeDefinitionEnumeration attributeDefinition = (AttributeDefinitionEnumeration)viewElement.getAttributeDefinition();
            AbstractListViewer comboViewer = ((AbstractListViewer)e.getSource());

            // as now a value is entered this listener is obsolete
            comboViewer.removeSelectionChangedListener( this );

            // create an Attribute Value
            AttributeValueEnumeration attributeValue = ErfFactoryImpl.eINSTANCE.createAttributeValueEnumeration();

            // set reference to the respective Attribute Definition
            attributeValue.setDefinition( attributeDefinition );

            // set value of attribute definition
            attributeValue.getValues().addAll( ((IStructuredSelection)e.getSelection()).toList() );

            // create new Attribute value in the model
            Command cmd = AddCommand.create( editingDomain,
                                             specObject,
                                             ErfPackage.SPEC_OBJECT__VALUES,
                                             attributeValue );
            editingDomain.getCommandStack().execute( cmd );
            AttributeDefinitionEnumComposite.this.bind( specObject, attributeValue, editingDomain );

        }
    }

    @Override
    public Control getControl() {
        return comboViewer.getControl();
    }

}
