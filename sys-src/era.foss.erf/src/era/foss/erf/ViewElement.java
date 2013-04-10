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
package era.foss.erf;

import org.eclipse.emf.ecore.EObject;

/**
 * The Interface ViewElement.
 * 
 * @model
 */
public interface ViewElement extends EObject {

    /**
     * Gets the attribute definition.
     * 
     * @return the attribute definition
     * @model lowerBound="1"
     * @Not generated
     */
    public AttributeDefinition getAttributeDefinition();

    /**
     * Sets the value of the '{@link era.foss.erf.ViewElement#getAttributeDefinition <em>Attribute Definition</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Attribute Definition</em>' reference.
     * @see #getAttributeDefinition()
     * @generated
     */
    void setAttributeDefinition( AttributeDefinition value );

    /**
     * Checks if is editor show label.
     * 
     * @return true, if is editor show label
     * @model unique="false" default="true" required="true"
     * @Not generated
     */
    boolean isEditorShowLabel();

    /**
     * Sets the value of the '{@link era.foss.erf.ViewElement#isEditorShowLabel <em>Editor Show Label</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Editor Show Label</em>' attribute.
     * @see #isEditorShowLabel()
     * @generated
     */
    void setEditorShowLabel( boolean value );

    /**
     * Gets the editor row position.
     * 
     * @return the editor row position
     * @model unique="false" default="1" lowerBound="1" upperBound="1"
     * @Not generated
     */
    int getEditorRowPosition();

    /**
     * Sets the value of the '{@link era.foss.erf.ViewElement#getEditorRowPosition <em>Editor Row Position</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Editor Row Position</em>' attribute.
     * @see #getEditorRowPosition()
     * @generated
     */
    void setEditorRowPosition( int value );

    /**
     * Gets the editor row span.
     * 
     * @return the editor row span
     * @model unique="false" default="1" lowerBound="1" upperBound="1"
     * @Not generated
     */
    int getEditorRowSpan();

    /**
     * Sets the value of the '{@link era.foss.erf.ViewElement#getEditorRowSpan <em>Editor Row Span</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Editor Row Span</em>' attribute.
     * @see #getEditorRowSpan()
     * @generated
     */
    void setEditorRowSpan( int value );

    /**
     * Gets the editor column position.
     * 
     * @return the editor column position
     * @model unique="false" default="1" lowerBound="1" upperBound="1"
     * @Not generated
     */
    int getEditorColumnPosition();

    /**
     * Sets the value of the '{@link era.foss.erf.ViewElement#getEditorColumnPosition <em>Editor Column Position</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Editor Column Position</em>' attribute.
     * @see #getEditorColumnPosition()
     * @generated
     */
    void setEditorColumnPosition( int value );

    /**
     * Gets the editor column span.
     * 
     * @return the editor column span
     * @model unique="false" default="1" lowerBound="1" upperBound="1"
     * @Not generated
     */
    int getEditorColumnSpan();

    /**
     * Sets the value of the '{@link era.foss.erf.ViewElement#getEditorColumnSpan <em>Editor Column Span</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Editor Column Span</em>' attribute.
     * @see #getEditorColumnSpan()
     * @generated
     */
    void setEditorColumnSpan( int value );

}
