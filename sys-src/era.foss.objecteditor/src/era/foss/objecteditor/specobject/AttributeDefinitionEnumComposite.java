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

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.AbstractListViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

import era.foss.erf.AttributeDefinitionEnumeration;
import era.foss.erf.AttributeValue;
import era.foss.erf.AttributeValueEnumeration;
import era.foss.erf.EnumValue;
import era.foss.erf.ErfPackage;
import era.foss.erf.SpecObject;
import era.foss.erf.ViewElement;
import era.foss.erf.impl.EnumValueImpl;
import era.foss.erf.impl.ErfFactoryImpl;
import era.foss.ui.contrib.ColorComboViewer;
import era.foss.ui.contrib.MultiComboViewer;
import era.foss.ui.contrib.ObservableMapLabelColorProvider;

/**
 * The Class AttributeDefinitionEnumComposite.
 */
public class AttributeDefinitionEnumComposite extends AbstractAttributeDefinitionComposite {

    /** The GUI element representing a AttributeDefinitionBoolean. */
    AbstractListViewer comboViewer;

    /** The value modify listener. */
    private DefaultModifyListener valueModifyListener;

    /** The attribute definition. */
    private AttributeDefinitionEnumeration attributeDefinition;

    /**
     * Instantiates a new attribute definition enum composite.
     * 
     * @param parent the parent
     * @param viewElement the view element
     * @param specObject the spec object
     */
    public AttributeDefinitionEnumComposite( Composite parent, ViewElement viewElement, SpecObject specObject ) {
        super( parent, viewElement );

    }

    public Control createControl() {
        attributeDefinition = (AttributeDefinitionEnumeration)viewElement.getAttributeDefinition();

        if( attributeDefinition.isMultiValued() ) {
            comboViewer = new MultiComboViewer( this, SWT.READ_ONLY | SWT.BORDER );
        } else {
            comboViewer = new ColorComboViewer( new CCombo( this, SWT.READ_ONLY | SWT.BORDER ) );
        }

        ObservableListContentProvider contentProvider = new ObservableListContentProvider();

        // set content provider
        comboViewer.setContentProvider( contentProvider );

        ObservableMapLabelColorProvider labelProvider = new ObservableMapLabelColorProvider( EMFProperties.value( ErfPackage.Literals.IDENTIFIABLE__LONG_NAME )
                                                                                                          .observeDetail( contentProvider.getKnownElements() ) ) {

            @Override
            public String getText( Object element ) {
                return super.getText( element );
            }

            @Override
            public Image getImage( Object element ) {
                return super.getImage( element );
            }

            public Color getForeground( Object element ) {
                return null;
            }

            public Color getBackground( Object element ) {
                org.eclipse.swt.graphics.Color swtColor;
                if( element != null ) {
                    assert (element instanceof EnumValueImpl);
                    EnumValueImpl enumValue = (EnumValueImpl)element;
                    swtColor = enumValue.getColor().getColor();
                } else {
                    swtColor = Display.getDefault().getSystemColor( SWT.COLOR_WHITE );
                }
                return swtColor;
            }

        };

        // set label provider
        comboViewer.setLabelProvider( labelProvider );

        // set input
        IEMFListProperty dataTypeDefinitions = EMFProperties.list( ErfPackage.Literals.DATATYPE_DEFINITION_ENUMERATION__SPECIFIED_VALUES );
        IObservableList observableList = dataTypeDefinitions.observe( attributeDefinition.getType() );
        comboViewer.setInput( observableList );

        return comboViewer.getControl();
    }

    @Override
    public void doBind( SpecObject specObject, AttributeValue attributeValue, EditingDomain editingDomain ) {
        if( attributeValue == null ) {
            valueModifyListener = new DefaultModifyListener( specObject, editingDomain );
            comboViewer.addSelectionChangedListener( valueModifyListener );
            if( attributeDefinition.getDefaultValue() != null ) {
                comboViewer.setSelection( new StructuredSelection( attributeDefinition.getDefaultValue().getValues() ) );
            } else {
                comboViewer.setSelection( StructuredSelection.EMPTY );
            }
        } else {
            this.binding = dbc.bindList( ViewerProperties.multipleSelection().observe( comboViewer ),
                                         EMFEditProperties.list( editingDomain,
                                                                 ErfPackage.Literals.ATTRIBUTE_VALUE_ENUMERATION__VALUES )
                                                          .observe( attributeValue ) );
        }
    }

    /**
     * Sets the k color.
     * 
     * @param enumValue the new k color
     */
    protected void setKColor( EnumValue enumValue ) {
        org.eclipse.swt.graphics.Color swtColor;
        if( enumValue != null ) {
            swtColor = enumValue.getColor().getColor();
        } else if( attributeDefinition.getDefaultValue() != null ) {
            swtColor = attributeDefinition.getDefaultValue().getValues().get( 0 ).getColor().getColor();
        } else {
            swtColor = Display.getDefault().getSystemColor( SWT.COLOR_WHITE );
        }
        comboViewer.getControl().setBackground( swtColor );
    }

    @Override
    public void unbind() {
        if( valueModifyListener != null ) {
            comboViewer.removeSelectionChangedListener( valueModifyListener );
        }
        super.unbind();
    }

    /**
     * Listener which adds a AttributeValue to a SpecObject in case no attributeValue exists yet.
     * 
     * @see DefaultModifyEvent
     */
    private class DefaultModifyListener implements ISelectionChangedListener {

        /** Spec Object for which a AttributeValue has to be created in case the content of the Text control is changed. */
        SpecObject specObject;

        /** The editing domain. */
        EditingDomain editingDomain;

        public DefaultModifyListener( SpecObject specObject, EditingDomain editingDomain ) {
            super();
            this.specObject = specObject;
            this.editingDomain = editingDomain;
        }

        @SuppressWarnings("unchecked")
        @Override
        synchronized public void selectionChanged( SelectionChangedEvent e ) {

            if( AttributeDefinitionEnumComposite.this.attributeValue == null ) {

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
                // AttributeDefinitionEnumComposite.this.bind( specObject, attributeValue, editingDomain );
            }
            comboViewer.refresh();

        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see era.foss.objecteditor.AbstractAttributeDefinitionComposite#getControl()
     */
    @Override
    public Control getControl() {
        return comboViewer.getControl();
    }

}
