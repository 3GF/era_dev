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
 * The Interface EmbeddedValue.
 * 
 * @model
 */
public interface EmbeddedValue extends EObject {

    /**
     * Gets the key.
     * 
     * @return the key
     * @model unique="false" default="0" lowerBound="1" upperBound="1" ordered="false"
     */
    int getKey();

    /**
     * Sets the value of the '{@link era.foss.erf.EmbeddedValue#getKey <em>Key</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Key</em>' attribute.
     * @see #getKey()
     * @generated
     */
    void setKey( int value );

    /**
     * Gets the other content.
     * 
     * @return the other content
     * @model unique="false" default="" lowerBound="1" upperBound="1" ordered="false"
     */
    String getOtherContent();

    /**
     * Sets the value of the '{@link era.foss.erf.EmbeddedValue#getOtherContent <em>Other Content</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Other Content</em>' attribute.
     * @see #getOtherContent()
     * @generated
     */
    void setOtherContent( String value );
}
