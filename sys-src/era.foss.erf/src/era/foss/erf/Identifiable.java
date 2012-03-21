/**************************************************************************
 * ERA - Eclipse Requirements Analysis
 * ==============================================
 * Copyright (C) 2009-2011 by Georg Blaschke, Christoph P. Neumann
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
 * $Id$
 *************************************************************************/
package era.foss.erf;

import org.eclipse.emf.ecore.EObject;

/**
 * @model abstract="true"
 * 
 */
public interface Identifiable extends EObject {

    /**
     * @model lowerBound="1" upperBound="1" unsettable="true" unique="true"
     */
    public String getID();

    /**
     * Sets the value of the '{@link era.foss.erf.Identifiable#getID <em>ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>ID</em>' attribute.
     * @see #isSetID()
     * @see #unsetID()
     * @see #getID()
     * @generated
     */
    void setID( String value );

    /**
     * Unsets the value of the '{@link era.foss.erf.Identifiable#getID <em>ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetID()
     * @see #getID()
     * @see #setID(String)
     * @generated
     */
    void unsetID();

    /**
     * Returns whether the value of the '{@link era.foss.erf.Identifiable#getID <em>ID</em>}' attribute is set. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return whether the value of the '<em>ID</em>' attribute is set.
     * @see #unsetID()
     * @see #getID()
     * @see #setID(String)
     * @generated
     */
    boolean isSetID();

    /**
     * @model default=""
     */
    public String getDesc();

    /**
     * Sets the value of the '{@link era.foss.erf.Identifiable#getDesc <em>Desc</em>}' attribute.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Desc</em>' attribute.
     * @see #getDesc()
     * @generated
     */
    void setDesc( String value );

    /**
     * @model default=""
     */
    public String getLongName();

    /**
     * Sets the value of the '{@link era.foss.erf.Identifiable#getLongName <em>Long Name</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Long Name</em>' attribute.
     * @see #getLongName()
     * @generated
     */
    void setLongName( String value );
}
