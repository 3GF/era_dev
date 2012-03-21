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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see era.foss.erf.ErfPackage
 * @generated
 */
public interface ErfFactory extends EFactory {

    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ErfFactory eINSTANCE = era.foss.erf.impl.ErfFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Spec Object</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Spec Object</em>'.
     * @generated
     */
    SpecObject createSpecObject();

    /**
     * Returns a new object of class '<em>Spec Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Spec Type</em>'.
     * @generated
     */
    SpecType createSpecType();

    /**
     * Returns a new object of class '<em>Attribute Value Simple</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Attribute Value Simple</em>'.
     * @generated
     */
    AttributeValueSimple createAttributeValueSimple();

    /**
     * Returns a new object of class '<em>Datatype Definition Integer</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Datatype Definition Integer</em>'.
     * @generated
     */
    DatatypeDefinitionInteger createDatatypeDefinitionInteger();

    /**
     * Returns a new object of class '<em>Datatype Definition String</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Datatype Definition String</em>'.
     * @generated
     */
    DatatypeDefinitionString createDatatypeDefinitionString();

    /**
     * Returns a new object of class '<em>Attribute Definition Simple</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Attribute Definition Simple</em>'.
     * @generated
     */
    AttributeDefinitionSimple createAttributeDefinitionSimple();

    /**
     * Returns a new object of class '<em>ERF</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>ERF</em>'.
     * @generated
     */
    ERF createERF();

    /**
     * Returns a new object of class '<em>Content</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Content</em>'.
     * @generated
     */
    Content createContent();

    /**
     * Returns a new object of class '<em>Spec Relation</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Spec Relation</em>'.
     * @generated
     */
    SpecRelation createSpecRelation();

    /**
     * Returns a new object of class '<em>Embedded Value</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Embedded Value</em>'.
     * @generated
     */
    EmbeddedValue createEmbeddedValue();

    /**
     * Returns a new object of class '<em>Enum Value</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Enum Value</em>'.
     * @generated
     */
    EnumValue createEnumValue();

    /**
     * Returns a new object of class '<em>Datatype Definition Enumeration</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Datatype Definition Enumeration</em>'.
     * @generated
     */
    DatatypeDefinitionEnumeration createDatatypeDefinitionEnumeration();

    /**
     * Returns a new object of class '<em>Attribute Definition Enumeration</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Attribute Definition Enumeration</em>'.
     * @generated
     */
    AttributeDefinitionEnumeration createAttributeDefinitionEnumeration();

    /**
     * Returns a new object of class '<em>Attribute Value Enumeration</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Attribute Value Enumeration</em>'.
     * @generated
     */
    AttributeValueEnumeration createAttributeValueEnumeration();

    /**
     * Returns a new object of class '<em>Datatype Definition Boolean</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Datatype Definition Boolean</em>'.
     * @generated
     */
    DatatypeDefinitionBoolean createDatatypeDefinitionBoolean();

    /**
     * Returns a new object of class '<em>Attribute Definition Boolean</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Attribute Definition Boolean</em>'.
     * @generated
     */
    AttributeDefinitionBoolean createAttributeDefinitionBoolean();

    /**
     * Returns a new object of class '<em>Attribute Value Boolean</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Attribute Value Boolean</em>'.
     * @generated
     */
    AttributeValueBoolean createAttributeValueBoolean();

    /**
     * Returns a new object of class '<em>View</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>View</em>'.
     * @generated
     */
    View createView();

    /**
     * Returns a new object of class '<em>View Element</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>View Element</em>'.
     * @generated
     */
    ViewElement createViewElement();

    /**
     * Returns a new object of class '<em>Era Tool Extension</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Era Tool Extension</em>'.
     * @generated
     */
    EraToolExtension createEraToolExtension();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    ErfPackage getErfPackage();

} //ErfFactory
