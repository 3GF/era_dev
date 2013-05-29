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
 * The Interface DatatypeDefinitionInteger.
 * 
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='NonNegative MaxGreaterThanMin'"
 */
public interface DatatypeDefinitionInteger extends DatatypeDefinitionSimple {

    /**
     * Gets the max.
     * 
     * @return the max
     * @model unsettable="true" ordered="false"
     */
    public Integer getMax();

    /**
     * Sets the value of the '{@link era.foss.erf.DatatypeDefinitionInteger#getMax <em>Max</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Max</em>' attribute.
     * @see #isSetMax()
     * @see #unsetMax()
     * @see #getMax()
     * @generated
     */
    void setMax( Integer value );

    /**
     * Unsets the value of the '{@link era.foss.erf.DatatypeDefinitionInteger#getMax <em>Max</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isSetMax()
     * @see #getMax()
     * @see #setMax(Integer)
     * @generated
     */
    void unsetMax();

    /**
     * Returns whether the value of the '{@link era.foss.erf.DatatypeDefinitionInteger#getMax <em>Max</em>}' attribute is set.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return whether the value of the '<em>Max</em>' attribute is set.
     * @see #unsetMax()
     * @see #getMax()
     * @see #setMax(Integer)
     * @generated
     */
    boolean isSetMax();

    /**
     * Gets the min.
     * 
     * @return the min
     * @model unsettable="true" ordered="false"
     */
    public Integer getMin();

    /**
     * Sets the value of the '{@link era.foss.erf.DatatypeDefinitionInteger#getMin <em>Min</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Min</em>' attribute.
     * @see #isSetMin()
     * @see #unsetMin()
     * @see #getMin()
     * @generated
     */
    void setMin( Integer value );

    /**
     * Unsets the value of the '{@link era.foss.erf.DatatypeDefinitionInteger#getMin <em>Min</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isSetMin()
     * @see #getMin()
     * @see #setMin(Integer)
     * @generated
     */
    void unsetMin();

    /**
     * Returns whether the value of the '{@link era.foss.erf.DatatypeDefinitionInteger#getMin <em>Min</em>}' attribute is set.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return whether the value of the '<em>Min</em>' attribute is set.
     * @see #unsetMin()
     * @see #getMin()
     * @see #setMin(Integer)
     * @generated
     */
    boolean isSetMin();
}
