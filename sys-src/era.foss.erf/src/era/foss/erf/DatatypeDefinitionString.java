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
 * The Interface DatatypeDefinitionString.
 * 
 * @model
 */
public interface DatatypeDefinitionString extends DatatypeDefinitionSimple {

    /**
     * Gets the max length.
     * 
     * @return the max length
     * @model unsettable="true" ordered="false"
     */
    public Integer getMaxLength();

    /**
     * Sets the value of the '{@link era.foss.erf.DatatypeDefinitionString#getMaxLength <em>Max Length</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Max Length</em>' attribute.
     * @see #isSetMaxLength()
     * @see #unsetMaxLength()
     * @see #getMaxLength()
     * @generated
     */
    void setMaxLength( Integer value );

    /**
     * Unsets the value of the '{@link era.foss.erf.DatatypeDefinitionString#getMaxLength <em>Max Length</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #isSetMaxLength()
     * @see #getMaxLength()
     * @see #setMaxLength(Integer)
     * @generated
     */
    void unsetMaxLength();

    /**
     * Returns whether the value of the '{@link era.foss.erf.DatatypeDefinitionString#getMaxLength <em>Max Length</em>}' attribute is set.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return whether the value of the '<em>Max Length</em>' attribute is set.
     * @see #unsetMaxLength()
     * @see #getMaxLength()
     * @see #setMaxLength(Integer)
     * @generated
     */
    boolean isSetMaxLength();
}
