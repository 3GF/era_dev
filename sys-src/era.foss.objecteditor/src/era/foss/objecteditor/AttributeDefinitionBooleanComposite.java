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
package era.foss.objecteditor;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

import era.foss.erf.AttributeDefinitionBoolean;
import era.foss.erf.AttributeValue;
import era.foss.erf.AttributeValueBoolean;
import era.foss.erf.ErfPackage;
import era.foss.erf.SpecObject;
import era.foss.erf.ViewElement;
import era.foss.erf.impl.ErfFactoryImpl;

/**
 * The Class AttributeDefinitionBooleanComposite.
 */
public class AttributeDefinitionBooleanComposite extends AbstractAttributeDefinitionComposite {

    /** The GUI element representing a AttributeDefinitionBoolean. */
    Button checkBox;

    /** The default value modify listener. */
    private DefaultModifyListener defaultValueModifyListener;

    /**
     * Instantiates a new attribute definition boolean composite.
     *
     * @param parent the parent
     * @param viewElement the view element
     * @param specObject the spec object
     */
    public AttributeDefinitionBooleanComposite( Composite parent, ViewElement viewElement, SpecObject specObject ) {
        super( parent, viewElement );

    }

    public Control createControl() {
        this.checkBox = new Button( this, SWT.CHECK );
        return checkBox;
    }

    @Override
    public void doBind( SpecObject specObject, AttributeValue attributeValue, EditingDomain editingDomain ) {
        AttributeDefinitionBoolean attributeDefinition = (AttributeDefinitionBoolean)viewElement.getAttributeDefinition();

        if( attributeValue == null ) {

            if( attributeDefinition.getDefaultValue() != null ) {
                checkBox.setSelection( attributeDefinition.getDefaultValue().getTheValue() );
                checkBox.setBackground( Display.getDefault().getSystemColor( COLOR_DEFAULT_VALUE ) );
            } else {
                checkBox.setText( "" );
                checkBox.setSelection( false);
                checkBox.setBackground( Display.getDefault().getSystemColor( SWT.COLOR_WIDGET_BACKGROUND ) );
            }
            defaultValueModifyListener = new DefaultModifyListener( specObject, editingDomain );
            checkBox.addSelectionListener( defaultValueModifyListener );

        } else {
            this.binding = dbc.bindValue( SWTObservables.observeSelection( checkBox ),
                                          EMFEditProperties.value( editingDomain,
                                                                   ErfPackage.Literals.ATTRIBUTE_VALUE_BOOLEAN__THE_VALUE )
                                                           .observe( attributeValue ) );
            checkBox.setBackground( Display.getDefault().getSystemColor( SWT.COLOR_WIDGET_BACKGROUND ) );
        }
    }

    @Override
    public void unbind() {

        if( defaultValueModifyListener != null ) {
            checkBox.removeSelectionListener( defaultValueModifyListener );
        }
        super.unbind();
    }

    /**
     * Listener which adds a AttributeValue to a SpecObject in case no.
     *
     * @see DefaultModifyEvent
     */
    private class DefaultModifyListener implements SelectionListener {

        /** Spec Object for which a AttributeValue has to be created in case the content of the Text control is changed. */
        SpecObject specObject;
        
        /** The editing domain. */
        EditingDomain editingDomain;

        public DefaultModifyListener( SpecObject specObject, EditingDomain editingDomain ) {
            super();
            this.specObject = specObject;
            this.editingDomain = editingDomain;
        }

        @Override
        public void widgetSelected( SelectionEvent e ) {
            AttributeDefinitionBoolean attributeDefinition = (AttributeDefinitionBoolean)viewElement.getAttributeDefinition();
            Button checkBox = ((Button)e.widget);

            // as now a value is entered this listener is obsolete
            checkBox.removeSelectionListener( this );

            // create an Attribute Value
            AttributeValueBoolean attributeValue = ErfFactoryImpl.eINSTANCE.createAttributeValueBoolean();

            // set reference to the respective Attribute Definition
            attributeValue.setDefinition( attributeDefinition );
            // set value of attribute definition
            attributeValue.setTheValue( checkBox.getSelection() );

            // create new Attribute value in the model
            Command cmd = AddCommand.create( editingDomain,
                                             specObject,
                                             ErfPackage.SPEC_OBJECT__VALUES,
                                             attributeValue );
            editingDomain.getCommandStack().execute( cmd );
            AttributeDefinitionBooleanComposite.this.bind( specObject, attributeValue, editingDomain );
        }

        @Override
        public void widgetDefaultSelected( SelectionEvent e ) {
            // TODO Auto-generated method stub

        }
    }

    /* (non-Javadoc)
     * @see era.foss.objecteditor.AbstractAttributeDefinitionComposite#getControl()
     */
    @Override
    public Control getControl() {
        return checkBox;
    }

}
