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
 * The Interface Color.
 *
 * @model
 */
public interface Color extends EObject {

    /**
     * Gets the red.
     *
     * @return the red
     * @model
     */
    int getRed();

    /**
     * Sets the value of the '{@link era.foss.erf.Color#getRed <em>Red</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value the new value of the '<em>Red</em>' attribute.
     * @see #getRed()
     * @generated
     */
    void setRed( int value );

    /**
     * Gets the green.
     *
     * @return the green
     * @model
     */
    int getGreen();

    /**
     * Sets the value of the '{@link era.foss.erf.Color#getGreen <em>Green</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Green</em>' attribute.
     * @see #getGreen()
     * @generated
     */
    void setGreen( int value );

    /**
     * Gets the blue.
     *
     * @return the blue
     * @model
     */
    int getBlue();

    /**
     * Sets the value of the '{@link era.foss.erf.Color#getBlue <em>Blue</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value the new value of the '<em>Blue</em>' attribute.
     * @see #getBlue()
     * @generated
     */
    void setBlue( int value );

    /**
     * Gets the color.
     *
     * @return the color
     */
    public org.eclipse.swt.graphics.Color getColor();

}
