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

/**
 * The Interface AttributeDefinitionSimple.
 *
 * @model
 */
public interface AttributeDefinitionSimple extends AttributeDefinition {
    
    /**
     * Gets the default value.
     *
     * @return the default value
     * @model containment="true" unsettable="true" ordered="false"
     */
    public AttributeValueSimple getDefaultValue();

    /**
     * Sets the value of the '{@link era.foss.erf.AttributeDefinitionSimple#getDefaultValue <em>Default Value</em>}' containment reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Value</em>' containment reference.
     * @see #isSetDefaultValue()
     * @see #unsetDefaultValue()
     * @see #getDefaultValue()
     * @generated
     */
    void setDefaultValue( AttributeValueSimple value );

    /**
     * Unsets the value of the '{@link era.foss.erf.AttributeDefinitionSimple#getDefaultValue <em>Default Value</em>}' containment reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #isSetDefaultValue()
     * @see #getDefaultValue()
     * @see #setDefaultValue(AttributeValueSimple)
     * @generated
     */
    void unsetDefaultValue();

    /**
     * Returns whether the value of the '{@link era.foss.erf.AttributeDefinitionSimple#getDefaultValue <em>Default Value</em>}' containment reference is set.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return whether the value of the '<em>Default Value</em>' containment reference is set.
     * @see #unsetDefaultValue()
     * @see #getDefaultValue()
     * @see #setDefaultValue(AttributeValueSimple)
     * @generated
     */
    boolean isSetDefaultValue();

}
