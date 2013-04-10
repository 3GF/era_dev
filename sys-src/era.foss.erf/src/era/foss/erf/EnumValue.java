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
 * The Interface EnumValue.
 * 
 * @model
 */
public interface EnumValue extends Identifiable {

    /**
     * Gets the color.
     * 
     * @return the color
     * @model lowerBound="1" upperBound="1" containment="true"
     */
    Color getColor();

    /**
     * Sets the value of the '{@link era.foss.erf.EnumValue#getColor <em>Color</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Color</em>' containment reference.
     * @see #getColor()
     * @generated
     */
    void setColor( Color value );

    /**
     * Gets the properties.
     * 
     * @return the properties
     * @model lowerBound="1" upperBound="1" containment="true"
     */
    EmbeddedValue getProperties();

    /**
     * Sets the value of the '{@link era.foss.erf.EnumValue#getProperties <em>Properties</em>}' containment reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Properties</em>' containment reference.
     * @see #getProperties()
     * @generated
     */
    void setProperties( EmbeddedValue value );

}
