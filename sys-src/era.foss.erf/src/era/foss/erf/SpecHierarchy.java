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

import org.eclipse.emf.common.util.EList;

/**
 * Represents a node in a hierarchically structured requirements specification.
 * 
 * @model
 */
public interface SpecHierarchy extends AccessControlledElement {

    /**
     * 
     * Some requirements authoring tools enable the user to use tables as part of a requirement’s content, where parts
     * of the table represent requirements as well. If that is the case, this attribute needs to be set to true for the
     * root node of the table hierarchy and all descendant SpecHierarchy nodes.
     * 
     * * @model unique="true" default="false" required="false"
     */
    boolean isTableInternal();

    /**
     * Sets the value of the '{@link era.foss.erf.SpecHierarchy#isTableInternal <em>Table Internal</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Table Internal</em>' attribute.
     * @see #isTableInternal()
     * @generated
     */
    void setTableInternal( boolean value );

    /**
     * Next level of owned SpecHierarchy
     * 
     * @model containment="true" ordered="true" opposite="parent"
     */
    public EList<SpecHierarchy> getChildren();

    /**
     * Pointer to the associated SpecObject
     * 
     * @model kind="reference" required="true" opposite="specHierarchy"
     */
    public SpecObject getObject();

    /**
     * Sets the value of the '{@link era.foss.erf.SpecHierarchy#getObject <em>Object</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Object</em>' reference.
     * @see #getObject()
     * @generated
     */
    void setObject( SpecObject value );

    /**
     * Up link to previous level of SpecHierarchy (which owns this level)
     * 
     * @model required="false" opposite="children"
     */
    public SpecHierarchy getParent();

    /**
     * Sets the value of the '{@link era.foss.erf.SpecHierarchy#getParent <em>Parent</em>}' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Parent</em>' container reference.
     * @see #getParent()
     * @generated
     */
    void setParent( SpecHierarchy value );

    /**
     * Up link to specification hierarchy root (which may own this level)
     * 
     * @model required="false" opposite="children"
     */
    public Specification getRoot();

    /**
     * Sets the value of the '{@link era.foss.erf.SpecHierarchy#getRoot <em>Root</em>}' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Root</em>' container reference.
     * @see #getRoot()
     * @generated
     */
    void setRoot( Specification value );

}
