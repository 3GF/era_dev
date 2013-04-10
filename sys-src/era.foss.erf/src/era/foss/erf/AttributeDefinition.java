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
 * The Interface AttributeDefinition.
 * 
 * @model abstract="true"
 */
public interface AttributeDefinition extends Identifiable {

    /**
     * Gets the type.
     * 
     * @return the type
     * @model lowerBound="1" opposite="attributeDefinitions"
     * @Not generated
     */
    public DatatypeDefinition getType();

    /**
     * The value assigned to this attribute definition is used as ID.
     * 
     * @return true, if is ident
     * @model unique="true" default="false" required="true"
     * @Not generated
     */
    boolean isIdent();

    /**
     * The value assigned to this attribute definition must be unique.
     * 
     * @return true, if is unique
     * @model unique="false" default="false" required="true" ordered="false"
     * @Not generated
     */
    boolean isUnique();

    /**
     * Back linkage to the owning SpecType.
     * 
     * @return the spec type
     * @model kind="reference" opposite="specAttributes" required="true"
     * @Not generated
     */
    SpecType getSpecType();

    /**
     * Sets the value of the '{@link era.foss.erf.AttributeDefinition#getSpecType <em>Spec Type</em>}' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Spec Type</em>' container reference.
     * @see #getSpecType()
     * @generated
     */
    void setSpecType( SpecType value );

    /**
     * Sets the value of the '{@link era.foss.erf.AttributeDefinition#isUnique <em>Unique</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Unique</em>' attribute.
     * @see #isUnique()
     * @generated
     */
    void setUnique( boolean value );

    /**
     * Sets the value of the '{@link era.foss.erf.AttributeDefinition#isIdent <em>Ident</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Ident</em>' attribute.
     * @see #isIdent()
     * @generated
     */
    void setIdent( boolean value );

    /**
     * Sets the value of the '{@link era.foss.erf.AttributeDefinition#getType <em>Type</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Type</em>' reference.
     * @see #getType()
     * @generated
     */
    void setType( DatatypeDefinition value );

}
