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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see era.foss.erf.ErfFactory
 * @model kind="package"
 * @generated
 */
public interface ErfPackage extends EPackage {

    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "erf";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://era/foss/erf";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "era.foss.erf";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ErfPackage eINSTANCE = era.foss.erf.impl.ErfPackageImpl.init();

    /**
     * The meta object id for the '{@link era.foss.erf.impl.AttributeDefinitionImpl <em>Attribute Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.AttributeDefinitionImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getAttributeDefinition()
     * @generated
     */
    int ATTRIBUTE_DEFINITION = 0;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.AttributeValueImpl <em>Attribute Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.AttributeValueImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getAttributeValue()
     * @generated
     */
    int ATTRIBUTE_VALUE = 1;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.DatatypeDefinitionImpl <em>Datatype Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.DatatypeDefinitionImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getDatatypeDefinition()
     * @generated
     */
    int DATATYPE_DEFINITION = 2;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.SpecElementWithUserDefinedAttributesImpl <em>Spec Element With User Defined Attributes</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.SpecElementWithUserDefinedAttributesImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getSpecElementWithUserDefinedAttributes()
     * @generated
     */
    int SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES = 3;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.SpecObjectImpl <em>Spec Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.SpecObjectImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getSpecObject()
     * @generated
     */
    int SPEC_OBJECT = 4;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.SpecTypeImpl <em>Spec Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.SpecTypeImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getSpecType()
     * @generated
     */
    int SPEC_TYPE = 5;

    /**
     * The meta object id for the '{@link java.util.Map <em>Map</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.Map
     * @see era.foss.erf.impl.ErfPackageImpl#getMap()
     * @generated
     */
    int MAP = 6;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.AttributeValueSimpleImpl <em>Attribute Value Simple</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.AttributeValueSimpleImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getAttributeValueSimple()
     * @generated
     */
    int ATTRIBUTE_VALUE_SIMPLE = 7;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.DatatypeDefinitionSimpleImpl <em>Datatype Definition Simple</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.DatatypeDefinitionSimpleImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getDatatypeDefinitionSimple()
     * @generated
     */
    int DATATYPE_DEFINITION_SIMPLE = 9;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.DatatypeDefinitionIntegerImpl <em>Datatype Definition Integer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.DatatypeDefinitionIntegerImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getDatatypeDefinitionInteger()
     * @generated
     */
    int DATATYPE_DEFINITION_INTEGER = 8;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.DatatypeDefinitionStringImpl <em>Datatype Definition String</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.DatatypeDefinitionStringImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getDatatypeDefinitionString()
     * @generated
     */
    int DATATYPE_DEFINITION_STRING = 10;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.IdentifiableImpl <em>Identifiable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.IdentifiableImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getIdentifiable()
     * @generated
     */
    int IDENTIFIABLE = 11;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IDENTIFIABLE__ID = 0;

    /**
     * The feature id for the '<em><b>Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IDENTIFIABLE__DESC = 1;

    /**
     * The feature id for the '<em><b>Long Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IDENTIFIABLE__LONG_NAME = 2;

    /**
     * The number of structural features of the '<em>Identifiable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IDENTIFIABLE_FEATURE_COUNT = 3;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION__ID = IDENTIFIABLE__ID;

    /**
     * The feature id for the '<em><b>Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION__DESC = IDENTIFIABLE__DESC;

    /**
     * The feature id for the '<em><b>Long Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION__LONG_NAME = IDENTIFIABLE__LONG_NAME;

    /**
     * The feature id for the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION__TYPE = IDENTIFIABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Ident</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION__IDENT = IDENTIFIABLE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION__UNIQUE = IDENTIFIABLE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Spec Type</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION__SPEC_TYPE = IDENTIFIABLE_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Attribute Definition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VALUE__ID = IDENTIFIABLE__ID;

    /**
     * The feature id for the '<em><b>Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VALUE__DESC = IDENTIFIABLE__DESC;

    /**
     * The feature id for the '<em><b>Long Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VALUE__LONG_NAME = IDENTIFIABLE__LONG_NAME;

    /**
     * The feature id for the '<em><b>Definition</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VALUE__DEFINITION = IDENTIFIABLE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Attribute Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VALUE_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION__ID = IDENTIFIABLE__ID;

    /**
     * The feature id for the '<em><b>Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION__DESC = IDENTIFIABLE__DESC;

    /**
     * The feature id for the '<em><b>Long Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION__LONG_NAME = IDENTIFIABLE__LONG_NAME;

    /**
     * The feature id for the '<em><b>Attribute Definitions</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION__ATTRIBUTE_DEFINITIONS = IDENTIFIABLE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Datatype Definition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__ID = IDENTIFIABLE__ID;

    /**
     * The feature id for the '<em><b>Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__DESC = IDENTIFIABLE__DESC;

    /**
     * The feature id for the '<em><b>Long Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__LONG_NAME = IDENTIFIABLE__LONG_NAME;

    /**
     * The feature id for the '<em><b>Values</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__VALUES = IDENTIFIABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__TYPE = IDENTIFIABLE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Spec Element With User Defined Attributes</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_OBJECT__ID = SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__ID;

    /**
     * The feature id for the '<em><b>Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_OBJECT__DESC = SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__DESC;

    /**
     * The feature id for the '<em><b>Long Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_OBJECT__LONG_NAME = SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__LONG_NAME;

    /**
     * The feature id for the '<em><b>Values</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_OBJECT__VALUES = SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__VALUES;

    /**
     * The feature id for the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_OBJECT__TYPE = SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__TYPE;

    /**
     * The feature id for the '<em><b>Sources</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_OBJECT__SOURCES = SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Targets</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_OBJECT__TARGETS = SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Spec Object</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_OBJECT_FEATURE_COUNT = SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_TYPE__ID = IDENTIFIABLE__ID;

    /**
     * The feature id for the '<em><b>Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_TYPE__DESC = IDENTIFIABLE__DESC;

    /**
     * The feature id for the '<em><b>Long Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_TYPE__LONG_NAME = IDENTIFIABLE__LONG_NAME;

    /**
     * The feature id for the '<em><b>Spec Attributes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_TYPE__SPEC_ATTRIBUTES = IDENTIFIABLE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Spec Type</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_TYPE_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Map</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MAP_FEATURE_COUNT = 0;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VALUE_SIMPLE__ID = ATTRIBUTE_VALUE__ID;

    /**
     * The feature id for the '<em><b>Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VALUE_SIMPLE__DESC = ATTRIBUTE_VALUE__DESC;

    /**
     * The feature id for the '<em><b>Long Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VALUE_SIMPLE__LONG_NAME = ATTRIBUTE_VALUE__LONG_NAME;

    /**
     * The feature id for the '<em><b>Definition</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VALUE_SIMPLE__DEFINITION = ATTRIBUTE_VALUE__DEFINITION;

    /**
     * The feature id for the '<em><b>The Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VALUE_SIMPLE__THE_VALUE = ATTRIBUTE_VALUE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Attribute Value Simple</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VALUE_SIMPLE_FEATURE_COUNT = ATTRIBUTE_VALUE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_SIMPLE__ID = DATATYPE_DEFINITION__ID;

    /**
     * The feature id for the '<em><b>Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_SIMPLE__DESC = DATATYPE_DEFINITION__DESC;

    /**
     * The feature id for the '<em><b>Long Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_SIMPLE__LONG_NAME = DATATYPE_DEFINITION__LONG_NAME;

    /**
     * The feature id for the '<em><b>Attribute Definitions</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_SIMPLE__ATTRIBUTE_DEFINITIONS = DATATYPE_DEFINITION__ATTRIBUTE_DEFINITIONS;

    /**
     * The number of structural features of the '<em>Datatype Definition Simple</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_SIMPLE_FEATURE_COUNT = DATATYPE_DEFINITION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_INTEGER__ID = DATATYPE_DEFINITION_SIMPLE__ID;

    /**
     * The feature id for the '<em><b>Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_INTEGER__DESC = DATATYPE_DEFINITION_SIMPLE__DESC;

    /**
     * The feature id for the '<em><b>Long Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_INTEGER__LONG_NAME = DATATYPE_DEFINITION_SIMPLE__LONG_NAME;

    /**
     * The feature id for the '<em><b>Attribute Definitions</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_INTEGER__ATTRIBUTE_DEFINITIONS = DATATYPE_DEFINITION_SIMPLE__ATTRIBUTE_DEFINITIONS;

    /**
     * The feature id for the '<em><b>Max</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_INTEGER__MAX = DATATYPE_DEFINITION_SIMPLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Min</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_INTEGER__MIN = DATATYPE_DEFINITION_SIMPLE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Datatype Definition Integer</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_INTEGER_FEATURE_COUNT = DATATYPE_DEFINITION_SIMPLE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_STRING__ID = DATATYPE_DEFINITION_SIMPLE__ID;

    /**
     * The feature id for the '<em><b>Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_STRING__DESC = DATATYPE_DEFINITION_SIMPLE__DESC;

    /**
     * The feature id for the '<em><b>Long Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_STRING__LONG_NAME = DATATYPE_DEFINITION_SIMPLE__LONG_NAME;

    /**
     * The feature id for the '<em><b>Attribute Definitions</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_STRING__ATTRIBUTE_DEFINITIONS = DATATYPE_DEFINITION_SIMPLE__ATTRIBUTE_DEFINITIONS;

    /**
     * The feature id for the '<em><b>Max Length</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_STRING__MAX_LENGTH = DATATYPE_DEFINITION_SIMPLE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Datatype Definition String</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_STRING_FEATURE_COUNT = DATATYPE_DEFINITION_SIMPLE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.AttributeDefinitionSimpleImpl <em>Attribute Definition Simple</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.AttributeDefinitionSimpleImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getAttributeDefinitionSimple()
     * @generated
     */
    int ATTRIBUTE_DEFINITION_SIMPLE = 12;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_SIMPLE__ID = ATTRIBUTE_DEFINITION__ID;

    /**
     * The feature id for the '<em><b>Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_SIMPLE__DESC = ATTRIBUTE_DEFINITION__DESC;

    /**
     * The feature id for the '<em><b>Long Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_SIMPLE__LONG_NAME = ATTRIBUTE_DEFINITION__LONG_NAME;

    /**
     * The feature id for the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_SIMPLE__TYPE = ATTRIBUTE_DEFINITION__TYPE;

    /**
     * The feature id for the '<em><b>Ident</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_SIMPLE__IDENT = ATTRIBUTE_DEFINITION__IDENT;

    /**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_SIMPLE__UNIQUE = ATTRIBUTE_DEFINITION__UNIQUE;

    /**
     * The feature id for the '<em><b>Spec Type</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_SIMPLE__SPEC_TYPE = ATTRIBUTE_DEFINITION__SPEC_TYPE;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_SIMPLE__DEFAULT_VALUE = ATTRIBUTE_DEFINITION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Attribute Definition Simple</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_SIMPLE_FEATURE_COUNT = ATTRIBUTE_DEFINITION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.ERFImpl <em>ERF</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.ERFImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getERF()
     * @generated
     */
    int ERF = 13;

    /**
     * The feature id for the '<em><b>Core Content</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ERF__CORE_CONTENT = 0;

    /**
     * The feature id for the '<em><b>Tool Extensions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ERF__TOOL_EXTENSIONS = 1;

    /**
     * The number of structural features of the '<em>ERF</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ERF_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.ContentImpl <em>Content</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.ContentImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getContent()
     * @generated
     */
    int CONTENT = 14;

    /**
     * The feature id for the '<em><b>Spec Objects</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTENT__SPEC_OBJECTS = 0;

    /**
     * The feature id for the '<em><b>Spec Types</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTENT__SPEC_TYPES = 1;

    /**
     * The feature id for the '<em><b>Data Types</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTENT__DATA_TYPES = 2;

    /**
     * The feature id for the '<em><b>Spec Relations</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTENT__SPEC_RELATIONS = 3;

    /**
     * The number of structural features of the '<em>Content</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTENT_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.SpecRelationImpl <em>Spec Relation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.SpecRelationImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getSpecRelation()
     * @generated
     */
    int SPEC_RELATION = 15;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_RELATION__ID = SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__ID;

    /**
     * The feature id for the '<em><b>Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_RELATION__DESC = SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__DESC;

    /**
     * The feature id for the '<em><b>Long Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_RELATION__LONG_NAME = SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__LONG_NAME;

    /**
     * The feature id for the '<em><b>Values</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_RELATION__VALUES = SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__VALUES;

    /**
     * The feature id for the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_RELATION__TYPE = SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__TYPE;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_RELATION__SOURCE = SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_RELATION__TARGET = SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Spec Relation</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SPEC_RELATION_FEATURE_COUNT = SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.EmbeddedValueImpl <em>Embedded Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.EmbeddedValueImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getEmbeddedValue()
     * @generated
     */
    int EMBEDDED_VALUE = 16;

    /**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMBEDDED_VALUE__KEY = 0;

    /**
     * The feature id for the '<em><b>Other Content</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMBEDDED_VALUE__OTHER_CONTENT = 1;

    /**
     * The number of structural features of the '<em>Embedded Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMBEDDED_VALUE_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.EnumValueImpl <em>Enum Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.EnumValueImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getEnumValue()
     * @generated
     */
    int ENUM_VALUE = 17;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENUM_VALUE__ID = IDENTIFIABLE__ID;

    /**
     * The feature id for the '<em><b>Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENUM_VALUE__DESC = IDENTIFIABLE__DESC;

    /**
     * The feature id for the '<em><b>Long Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENUM_VALUE__LONG_NAME = IDENTIFIABLE__LONG_NAME;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENUM_VALUE__PROPERTIES = IDENTIFIABLE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Color</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENUM_VALUE__COLOR = IDENTIFIABLE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Enum Value</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ENUM_VALUE_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.DatatypeDefinitionEnumerationImpl <em>Datatype Definition Enumeration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.DatatypeDefinitionEnumerationImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getDatatypeDefinitionEnumeration()
     * @generated
     */
    int DATATYPE_DEFINITION_ENUMERATION = 18;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_ENUMERATION__ID = DATATYPE_DEFINITION__ID;

    /**
     * The feature id for the '<em><b>Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_ENUMERATION__DESC = DATATYPE_DEFINITION__DESC;

    /**
     * The feature id for the '<em><b>Long Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_ENUMERATION__LONG_NAME = DATATYPE_DEFINITION__LONG_NAME;

    /**
     * The feature id for the '<em><b>Attribute Definitions</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_ENUMERATION__ATTRIBUTE_DEFINITIONS = DATATYPE_DEFINITION__ATTRIBUTE_DEFINITIONS;

    /**
     * The feature id for the '<em><b>Specified Values</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_ENUMERATION__SPECIFIED_VALUES = DATATYPE_DEFINITION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Datatype Definition Enumeration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_ENUMERATION_FEATURE_COUNT = DATATYPE_DEFINITION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.AttributeDefinitionEnumerationImpl <em>Attribute Definition Enumeration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.AttributeDefinitionEnumerationImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getAttributeDefinitionEnumeration()
     * @generated
     */
    int ATTRIBUTE_DEFINITION_ENUMERATION = 19;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_ENUMERATION__ID = ATTRIBUTE_DEFINITION__ID;

    /**
     * The feature id for the '<em><b>Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_ENUMERATION__DESC = ATTRIBUTE_DEFINITION__DESC;

    /**
     * The feature id for the '<em><b>Long Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_ENUMERATION__LONG_NAME = ATTRIBUTE_DEFINITION__LONG_NAME;

    /**
     * The feature id for the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_ENUMERATION__TYPE = ATTRIBUTE_DEFINITION__TYPE;

    /**
     * The feature id for the '<em><b>Ident</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_ENUMERATION__IDENT = ATTRIBUTE_DEFINITION__IDENT;

    /**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_ENUMERATION__UNIQUE = ATTRIBUTE_DEFINITION__UNIQUE;

    /**
     * The feature id for the '<em><b>Spec Type</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_ENUMERATION__SPEC_TYPE = ATTRIBUTE_DEFINITION__SPEC_TYPE;

    /**
     * The feature id for the '<em><b>Multi Valued</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_ENUMERATION__MULTI_VALUED = ATTRIBUTE_DEFINITION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_ENUMERATION__DEFAULT_VALUE = ATTRIBUTE_DEFINITION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Attribute Definition Enumeration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_ENUMERATION_FEATURE_COUNT = ATTRIBUTE_DEFINITION_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.AttributeValueEnumerationImpl <em>Attribute Value Enumeration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.AttributeValueEnumerationImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getAttributeValueEnumeration()
     * @generated
     */
    int ATTRIBUTE_VALUE_ENUMERATION = 20;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VALUE_ENUMERATION__ID = ATTRIBUTE_VALUE__ID;

    /**
     * The feature id for the '<em><b>Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VALUE_ENUMERATION__DESC = ATTRIBUTE_VALUE__DESC;

    /**
     * The feature id for the '<em><b>Long Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VALUE_ENUMERATION__LONG_NAME = ATTRIBUTE_VALUE__LONG_NAME;

    /**
     * The feature id for the '<em><b>Definition</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VALUE_ENUMERATION__DEFINITION = ATTRIBUTE_VALUE__DEFINITION;

    /**
     * The feature id for the '<em><b>Values</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VALUE_ENUMERATION__VALUES = ATTRIBUTE_VALUE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Attribute Value Enumeration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VALUE_ENUMERATION_FEATURE_COUNT = ATTRIBUTE_VALUE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.DatatypeDefinitionBooleanImpl <em>Datatype Definition Boolean</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.DatatypeDefinitionBooleanImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getDatatypeDefinitionBoolean()
     * @generated
     */
    int DATATYPE_DEFINITION_BOOLEAN = 21;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_BOOLEAN__ID = DATATYPE_DEFINITION__ID;

    /**
     * The feature id for the '<em><b>Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_BOOLEAN__DESC = DATATYPE_DEFINITION__DESC;

    /**
     * The feature id for the '<em><b>Long Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_BOOLEAN__LONG_NAME = DATATYPE_DEFINITION__LONG_NAME;

    /**
     * The feature id for the '<em><b>Attribute Definitions</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_BOOLEAN__ATTRIBUTE_DEFINITIONS = DATATYPE_DEFINITION__ATTRIBUTE_DEFINITIONS;

    /**
     * The number of structural features of the '<em>Datatype Definition Boolean</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATATYPE_DEFINITION_BOOLEAN_FEATURE_COUNT = DATATYPE_DEFINITION_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.AttributeDefinitionBooleanImpl <em>Attribute Definition Boolean</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.AttributeDefinitionBooleanImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getAttributeDefinitionBoolean()
     * @generated
     */
    int ATTRIBUTE_DEFINITION_BOOLEAN = 22;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_BOOLEAN__ID = ATTRIBUTE_DEFINITION__ID;

    /**
     * The feature id for the '<em><b>Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_BOOLEAN__DESC = ATTRIBUTE_DEFINITION__DESC;

    /**
     * The feature id for the '<em><b>Long Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_BOOLEAN__LONG_NAME = ATTRIBUTE_DEFINITION__LONG_NAME;

    /**
     * The feature id for the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_BOOLEAN__TYPE = ATTRIBUTE_DEFINITION__TYPE;

    /**
     * The feature id for the '<em><b>Ident</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_BOOLEAN__IDENT = ATTRIBUTE_DEFINITION__IDENT;

    /**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_BOOLEAN__UNIQUE = ATTRIBUTE_DEFINITION__UNIQUE;

    /**
     * The feature id for the '<em><b>Spec Type</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_BOOLEAN__SPEC_TYPE = ATTRIBUTE_DEFINITION__SPEC_TYPE;

    /**
     * The feature id for the '<em><b>Default Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_BOOLEAN__DEFAULT_VALUE = ATTRIBUTE_DEFINITION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Attribute Definition Boolean</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_DEFINITION_BOOLEAN_FEATURE_COUNT = ATTRIBUTE_DEFINITION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.AttributeValueBooleanImpl <em>Attribute Value Boolean</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.AttributeValueBooleanImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getAttributeValueBoolean()
     * @generated
     */
    int ATTRIBUTE_VALUE_BOOLEAN = 23;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VALUE_BOOLEAN__ID = ATTRIBUTE_VALUE__ID;

    /**
     * The feature id for the '<em><b>Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VALUE_BOOLEAN__DESC = ATTRIBUTE_VALUE__DESC;

    /**
     * The feature id for the '<em><b>Long Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VALUE_BOOLEAN__LONG_NAME = ATTRIBUTE_VALUE__LONG_NAME;

    /**
     * The feature id for the '<em><b>Definition</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VALUE_BOOLEAN__DEFINITION = ATTRIBUTE_VALUE__DEFINITION;

    /**
     * The feature id for the '<em><b>The Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VALUE_BOOLEAN__THE_VALUE = ATTRIBUTE_VALUE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Attribute Value Boolean</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ATTRIBUTE_VALUE_BOOLEAN_FEATURE_COUNT = ATTRIBUTE_VALUE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.ToolExtensionImpl <em>Tool Extension</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.ToolExtensionImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getToolExtension()
     * @generated
     */
    int TOOL_EXTENSION = 24;

    /**
     * The number of structural features of the '<em>Tool Extension</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TOOL_EXTENSION_FEATURE_COUNT = 0;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.ViewImpl <em>View</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.ViewImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getView()
     * @generated
     */
    int VIEW = 25;

    /**
     * The feature id for the '<em><b>ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW__ID = IDENTIFIABLE__ID;

    /**
     * The feature id for the '<em><b>Desc</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW__DESC = IDENTIFIABLE__DESC;

    /**
     * The feature id for the '<em><b>Long Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW__LONG_NAME = IDENTIFIABLE__LONG_NAME;

    /**
     * The feature id for the '<em><b>View Elements</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW__VIEW_ELEMENTS = IDENTIFIABLE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>View</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.ViewElementImpl <em>View Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.ViewElementImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getViewElement()
     * @generated
     */
    int VIEW_ELEMENT = 26;

    /**
     * The feature id for the '<em><b>Editor Show Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_ELEMENT__EDITOR_SHOW_LABEL = 0;

    /**
     * The feature id for the '<em><b>Editor Column Span</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_ELEMENT__EDITOR_COLUMN_SPAN = 1;

    /**
     * The feature id for the '<em><b>Attribute Definition</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_ELEMENT__ATTRIBUTE_DEFINITION = 2;

    /**
     * The feature id for the '<em><b>Editor Row Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_ELEMENT__EDITOR_ROW_POSITION = 3;

    /**
     * The feature id for the '<em><b>Editor Row Span</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_ELEMENT__EDITOR_ROW_SPAN = 4;

    /**
     * The feature id for the '<em><b>Editor Column Position</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_ELEMENT__EDITOR_COLUMN_POSITION = 5;

    /**
     * The number of structural features of the '<em>View Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIEW_ELEMENT_FEATURE_COUNT = 6;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.EraToolExtensionImpl <em>Era Tool Extension</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.EraToolExtensionImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getEraToolExtension()
     * @generated
     */
    int ERA_TOOL_EXTENSION = 27;

    /**
     * The feature id for the '<em><b>Views</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ERA_TOOL_EXTENSION__VIEWS = TOOL_EXTENSION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Era Tool Extension</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ERA_TOOL_EXTENSION_FEATURE_COUNT = TOOL_EXTENSION_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link era.foss.erf.impl.ColorImpl <em>Color</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see era.foss.erf.impl.ColorImpl
     * @see era.foss.erf.impl.ErfPackageImpl#getColor()
     * @generated
     */
    int COLOR = 28;

    /**
     * The feature id for the '<em><b>Red</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLOR__RED = 0;

    /**
     * The feature id for the '<em><b>Green</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLOR__GREEN = 1;

    /**
     * The feature id for the '<em><b>Blue</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLOR__BLUE = 2;

    /**
     * The number of structural features of the '<em>Color</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLOR_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '<em>Diagnostic Chain</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.DiagnosticChain
     * @see era.foss.erf.impl.ErfPackageImpl#getDiagnosticChain()
     * @generated
     */
    int DIAGNOSTIC_CHAIN = 29;

    /**
     * Returns the meta object for class '{@link era.foss.erf.AttributeDefinition <em>Attribute Definition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Attribute Definition</em>'.
     * @see era.foss.erf.AttributeDefinition
     * @generated
     */
    EClass getAttributeDefinition();

    /**
     * Returns the meta object for the reference '{@link era.foss.erf.AttributeDefinition#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Type</em>'.
     * @see era.foss.erf.AttributeDefinition#getType()
     * @see #getAttributeDefinition()
     * @generated
     */
    EReference getAttributeDefinition_Type();

    /**
     * Returns the meta object for the attribute '{@link era.foss.erf.AttributeDefinition#isIdent <em>Ident</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ident</em>'.
     * @see era.foss.erf.AttributeDefinition#isIdent()
     * @see #getAttributeDefinition()
     * @generated
     */
    EAttribute getAttributeDefinition_Ident();

    /**
     * Returns the meta object for the attribute '{@link era.foss.erf.AttributeDefinition#isUnique <em>Unique</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Unique</em>'.
     * @see era.foss.erf.AttributeDefinition#isUnique()
     * @see #getAttributeDefinition()
     * @generated
     */
    EAttribute getAttributeDefinition_Unique();

    /**
     * Returns the meta object for the container reference '{@link era.foss.erf.AttributeDefinition#getSpecType <em>Spec Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Spec Type</em>'.
     * @see era.foss.erf.AttributeDefinition#getSpecType()
     * @see #getAttributeDefinition()
     * @generated
     */
    EReference getAttributeDefinition_SpecType();

    /**
     * Returns the meta object for class '{@link era.foss.erf.AttributeValue <em>Attribute Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Attribute Value</em>'.
     * @see era.foss.erf.AttributeValue
     * @generated
     */
    EClass getAttributeValue();

    /**
     * Returns the meta object for the reference '{@link era.foss.erf.AttributeValue#getDefinition <em>Definition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Definition</em>'.
     * @see era.foss.erf.AttributeValue#getDefinition()
     * @see #getAttributeValue()
     * @generated
     */
    EReference getAttributeValue_Definition();

    /**
     * Returns the meta object for class '{@link era.foss.erf.DatatypeDefinition <em>Datatype Definition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Datatype Definition</em>'.
     * @see era.foss.erf.DatatypeDefinition
     * @generated
     */
    EClass getDatatypeDefinition();

    /**
     * Returns the meta object for the reference list '{@link era.foss.erf.DatatypeDefinition#getAttributeDefinitions <em>Attribute Definitions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Attribute Definitions</em>'.
     * @see era.foss.erf.DatatypeDefinition#getAttributeDefinitions()
     * @see #getDatatypeDefinition()
     * @generated
     */
    EReference getDatatypeDefinition_AttributeDefinitions();

    /**
     * Returns the meta object for class '{@link era.foss.erf.SpecElementWithUserDefinedAttributes <em>Spec Element With User Defined Attributes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Spec Element With User Defined Attributes</em>'.
     * @see era.foss.erf.SpecElementWithUserDefinedAttributes
     * @generated
     */
    EClass getSpecElementWithUserDefinedAttributes();

    /**
     * Returns the meta object for the containment reference list '{@link era.foss.erf.SpecElementWithUserDefinedAttributes#getValues <em>Values</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Values</em>'.
     * @see era.foss.erf.SpecElementWithUserDefinedAttributes#getValues()
     * @see #getSpecElementWithUserDefinedAttributes()
     * @generated
     */
    EReference getSpecElementWithUserDefinedAttributes_Values();

    /**
     * Returns the meta object for the reference '{@link era.foss.erf.SpecElementWithUserDefinedAttributes#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Type</em>'.
     * @see era.foss.erf.SpecElementWithUserDefinedAttributes#getType()
     * @see #getSpecElementWithUserDefinedAttributes()
     * @generated
     */
    EReference getSpecElementWithUserDefinedAttributes_Type();

    /**
     * Returns the meta object for class '{@link era.foss.erf.SpecObject <em>Spec Object</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Spec Object</em>'.
     * @see era.foss.erf.SpecObject
     * @generated
     */
    EClass getSpecObject();

    /**
     * Returns the meta object for the reference list '{@link era.foss.erf.SpecObject#getSources <em>Sources</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Sources</em>'.
     * @see era.foss.erf.SpecObject#getSources()
     * @see #getSpecObject()
     * @generated
     */
    EReference getSpecObject_Sources();

    /**
     * Returns the meta object for the reference list '{@link era.foss.erf.SpecObject#getTargets <em>Targets</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Targets</em>'.
     * @see era.foss.erf.SpecObject#getTargets()
     * @see #getSpecObject()
     * @generated
     */
    EReference getSpecObject_Targets();

    /**
     * Returns the meta object for class '{@link era.foss.erf.SpecType <em>Spec Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Spec Type</em>'.
     * @see era.foss.erf.SpecType
     * @generated
     */
    EClass getSpecType();

    /**
     * Returns the meta object for the containment reference list '{@link era.foss.erf.SpecType#getSpecAttributes <em>Spec Attributes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Spec Attributes</em>'.
     * @see era.foss.erf.SpecType#getSpecAttributes()
     * @see #getSpecType()
     * @generated
     */
    EReference getSpecType_SpecAttributes();

    /**
     * Returns the meta object for class '{@link java.util.Map <em>Map</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Map</em>'.
     * @see java.util.Map
     * @model instanceClass="java.util.Map" typeParameters="T T1"
     * @generated
     */
    EClass getMap();

    /**
     * Returns the meta object for class '{@link era.foss.erf.AttributeValueSimple <em>Attribute Value Simple</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Attribute Value Simple</em>'.
     * @see era.foss.erf.AttributeValueSimple
     * @generated
     */
    EClass getAttributeValueSimple();

    /**
     * Returns the meta object for the attribute '{@link era.foss.erf.AttributeValueSimple#getTheValue <em>The Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>The Value</em>'.
     * @see era.foss.erf.AttributeValueSimple#getTheValue()
     * @see #getAttributeValueSimple()
     * @generated
     */
    EAttribute getAttributeValueSimple_TheValue();

    /**
     * Returns the meta object for class '{@link era.foss.erf.DatatypeDefinitionInteger <em>Datatype Definition Integer</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Datatype Definition Integer</em>'.
     * @see era.foss.erf.DatatypeDefinitionInteger
     * @generated
     */
    EClass getDatatypeDefinitionInteger();

    /**
     * Returns the meta object for the attribute '{@link era.foss.erf.DatatypeDefinitionInteger#getMax <em>Max</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Max</em>'.
     * @see era.foss.erf.DatatypeDefinitionInteger#getMax()
     * @see #getDatatypeDefinitionInteger()
     * @generated
     */
    EAttribute getDatatypeDefinitionInteger_Max();

    /**
     * Returns the meta object for the attribute '{@link era.foss.erf.DatatypeDefinitionInteger#getMin <em>Min</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Min</em>'.
     * @see era.foss.erf.DatatypeDefinitionInteger#getMin()
     * @see #getDatatypeDefinitionInteger()
     * @generated
     */
    EAttribute getDatatypeDefinitionInteger_Min();

    /**
     * Returns the meta object for class '{@link era.foss.erf.DatatypeDefinitionSimple <em>Datatype Definition Simple</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Datatype Definition Simple</em>'.
     * @see era.foss.erf.DatatypeDefinitionSimple
     * @generated
     */
    EClass getDatatypeDefinitionSimple();

    /**
     * Returns the meta object for class '{@link era.foss.erf.DatatypeDefinitionString <em>Datatype Definition String</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Datatype Definition String</em>'.
     * @see era.foss.erf.DatatypeDefinitionString
     * @generated
     */
    EClass getDatatypeDefinitionString();

    /**
     * Returns the meta object for the attribute '{@link era.foss.erf.DatatypeDefinitionString#getMaxLength <em>Max Length</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Max Length</em>'.
     * @see era.foss.erf.DatatypeDefinitionString#getMaxLength()
     * @see #getDatatypeDefinitionString()
     * @generated
     */
    EAttribute getDatatypeDefinitionString_MaxLength();

    /**
     * Returns the meta object for class '{@link era.foss.erf.Identifiable <em>Identifiable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Identifiable</em>'.
     * @see era.foss.erf.Identifiable
     * @generated
     */
    EClass getIdentifiable();

    /**
     * Returns the meta object for the attribute '{@link era.foss.erf.Identifiable#getID <em>ID</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>ID</em>'.
     * @see era.foss.erf.Identifiable#getID()
     * @see #getIdentifiable()
     * @generated
     */
    EAttribute getIdentifiable_ID();

    /**
     * Returns the meta object for the attribute '{@link era.foss.erf.Identifiable#getDesc <em>Desc</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Desc</em>'.
     * @see era.foss.erf.Identifiable#getDesc()
     * @see #getIdentifiable()
     * @generated
     */
    EAttribute getIdentifiable_Desc();

    /**
     * Returns the meta object for the attribute '{@link era.foss.erf.Identifiable#getLongName <em>Long Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Long Name</em>'.
     * @see era.foss.erf.Identifiable#getLongName()
     * @see #getIdentifiable()
     * @generated
     */
    EAttribute getIdentifiable_LongName();

    /**
     * Returns the meta object for class '{@link era.foss.erf.AttributeDefinitionSimple <em>Attribute Definition Simple</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Attribute Definition Simple</em>'.
     * @see era.foss.erf.AttributeDefinitionSimple
     * @generated
     */
    EClass getAttributeDefinitionSimple();

    /**
     * Returns the meta object for the containment reference '{@link era.foss.erf.AttributeDefinitionSimple#getDefaultValue <em>Default Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Default Value</em>'.
     * @see era.foss.erf.AttributeDefinitionSimple#getDefaultValue()
     * @see #getAttributeDefinitionSimple()
     * @generated
     */
    EReference getAttributeDefinitionSimple_DefaultValue();

    /**
     * Returns the meta object for class '{@link era.foss.erf.ERF <em>ERF</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>ERF</em>'.
     * @see era.foss.erf.ERF
     * @generated
     */
    EClass getERF();

    /**
     * Returns the meta object for the containment reference '{@link era.foss.erf.ERF#getCoreContent <em>Core Content</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Core Content</em>'.
     * @see era.foss.erf.ERF#getCoreContent()
     * @see #getERF()
     * @generated
     */
    EReference getERF_CoreContent();

    /**
     * Returns the meta object for the containment reference list '{@link era.foss.erf.ERF#getToolExtensions <em>Tool Extensions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Tool Extensions</em>'.
     * @see era.foss.erf.ERF#getToolExtensions()
     * @see #getERF()
     * @generated
     */
    EReference getERF_ToolExtensions();

    /**
     * Returns the meta object for class '{@link era.foss.erf.Content <em>Content</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Content</em>'.
     * @see era.foss.erf.Content
     * @generated
     */
    EClass getContent();

    /**
     * Returns the meta object for the containment reference list '{@link era.foss.erf.Content#getSpecObjects <em>Spec Objects</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Spec Objects</em>'.
     * @see era.foss.erf.Content#getSpecObjects()
     * @see #getContent()
     * @generated
     */
    EReference getContent_SpecObjects();

    /**
     * Returns the meta object for the containment reference list '{@link era.foss.erf.Content#getSpecTypes <em>Spec Types</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Spec Types</em>'.
     * @see era.foss.erf.Content#getSpecTypes()
     * @see #getContent()
     * @generated
     */
    EReference getContent_SpecTypes();

    /**
     * Returns the meta object for the containment reference list '{@link era.foss.erf.Content#getDataTypes <em>Data Types</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Data Types</em>'.
     * @see era.foss.erf.Content#getDataTypes()
     * @see #getContent()
     * @generated
     */
    EReference getContent_DataTypes();

    /**
     * Returns the meta object for the containment reference list '{@link era.foss.erf.Content#getSpecRelations <em>Spec Relations</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Spec Relations</em>'.
     * @see era.foss.erf.Content#getSpecRelations()
     * @see #getContent()
     * @generated
     */
    EReference getContent_SpecRelations();

    /**
     * Returns the meta object for class '{@link era.foss.erf.SpecRelation <em>Spec Relation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Spec Relation</em>'.
     * @see era.foss.erf.SpecRelation
     * @generated
     */
    EClass getSpecRelation();

    /**
     * Returns the meta object for the reference '{@link era.foss.erf.SpecRelation#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Source</em>'.
     * @see era.foss.erf.SpecRelation#getSource()
     * @see #getSpecRelation()
     * @generated
     */
    EReference getSpecRelation_Source();

    /**
     * Returns the meta object for the reference '{@link era.foss.erf.SpecRelation#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target</em>'.
     * @see era.foss.erf.SpecRelation#getTarget()
     * @see #getSpecRelation()
     * @generated
     */
    EReference getSpecRelation_Target();

    /**
     * Returns the meta object for class '{@link era.foss.erf.EmbeddedValue <em>Embedded Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Embedded Value</em>'.
     * @see era.foss.erf.EmbeddedValue
     * @generated
     */
    EClass getEmbeddedValue();

    /**
     * Returns the meta object for the attribute '{@link era.foss.erf.EmbeddedValue#getKey <em>Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see era.foss.erf.EmbeddedValue#getKey()
     * @see #getEmbeddedValue()
     * @generated
     */
    EAttribute getEmbeddedValue_Key();

    /**
     * Returns the meta object for the attribute '{@link era.foss.erf.EmbeddedValue#getOtherContent <em>Other Content</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Other Content</em>'.
     * @see era.foss.erf.EmbeddedValue#getOtherContent()
     * @see #getEmbeddedValue()
     * @generated
     */
    EAttribute getEmbeddedValue_OtherContent();

    /**
     * Returns the meta object for class '{@link era.foss.erf.EnumValue <em>Enum Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Enum Value</em>'.
     * @see era.foss.erf.EnumValue
     * @generated
     */
    EClass getEnumValue();

    /**
     * Returns the meta object for the containment reference '{@link era.foss.erf.EnumValue#getProperties <em>Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Properties</em>'.
     * @see era.foss.erf.EnumValue#getProperties()
     * @see #getEnumValue()
     * @generated
     */
    EReference getEnumValue_Properties();

    /**
     * Returns the meta object for the containment reference '{@link era.foss.erf.EnumValue#getColor <em>Color</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Color</em>'.
     * @see era.foss.erf.EnumValue#getColor()
     * @see #getEnumValue()
     * @generated
     */
    EReference getEnumValue_Color();

    /**
     * Returns the meta object for class '{@link era.foss.erf.DatatypeDefinitionEnumeration <em>Datatype Definition Enumeration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Datatype Definition Enumeration</em>'.
     * @see era.foss.erf.DatatypeDefinitionEnumeration
     * @generated
     */
    EClass getDatatypeDefinitionEnumeration();

    /**
     * Returns the meta object for the containment reference list '{@link era.foss.erf.DatatypeDefinitionEnumeration#getSpecifiedValues <em>Specified Values</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Specified Values</em>'.
     * @see era.foss.erf.DatatypeDefinitionEnumeration#getSpecifiedValues()
     * @see #getDatatypeDefinitionEnumeration()
     * @generated
     */
    EReference getDatatypeDefinitionEnumeration_SpecifiedValues();

    /**
     * Returns the meta object for class '{@link era.foss.erf.AttributeDefinitionEnumeration <em>Attribute Definition Enumeration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Attribute Definition Enumeration</em>'.
     * @see era.foss.erf.AttributeDefinitionEnumeration
     * @generated
     */
    EClass getAttributeDefinitionEnumeration();

    /**
     * Returns the meta object for the attribute '{@link era.foss.erf.AttributeDefinitionEnumeration#isMultiValued <em>Multi Valued</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Multi Valued</em>'.
     * @see era.foss.erf.AttributeDefinitionEnumeration#isMultiValued()
     * @see #getAttributeDefinitionEnumeration()
     * @generated
     */
    EAttribute getAttributeDefinitionEnumeration_MultiValued();

    /**
     * Returns the meta object for the containment reference '{@link era.foss.erf.AttributeDefinitionEnumeration#getDefaultValue <em>Default Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Default Value</em>'.
     * @see era.foss.erf.AttributeDefinitionEnumeration#getDefaultValue()
     * @see #getAttributeDefinitionEnumeration()
     * @generated
     */
    EReference getAttributeDefinitionEnumeration_DefaultValue();

    /**
     * Returns the meta object for class '{@link era.foss.erf.AttributeValueEnumeration <em>Attribute Value Enumeration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Attribute Value Enumeration</em>'.
     * @see era.foss.erf.AttributeValueEnumeration
     * @generated
     */
    EClass getAttributeValueEnumeration();

    /**
     * Returns the meta object for the reference list '{@link era.foss.erf.AttributeValueEnumeration#getValues <em>Values</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Values</em>'.
     * @see era.foss.erf.AttributeValueEnumeration#getValues()
     * @see #getAttributeValueEnumeration()
     * @generated
     */
    EReference getAttributeValueEnumeration_Values();

    /**
     * Returns the meta object for class '{@link era.foss.erf.DatatypeDefinitionBoolean <em>Datatype Definition Boolean</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Datatype Definition Boolean</em>'.
     * @see era.foss.erf.DatatypeDefinitionBoolean
     * @generated
     */
    EClass getDatatypeDefinitionBoolean();

    /**
     * Returns the meta object for class '{@link era.foss.erf.AttributeDefinitionBoolean <em>Attribute Definition Boolean</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Attribute Definition Boolean</em>'.
     * @see era.foss.erf.AttributeDefinitionBoolean
     * @generated
     */
    EClass getAttributeDefinitionBoolean();

    /**
     * Returns the meta object for the containment reference '{@link era.foss.erf.AttributeDefinitionBoolean#getDefaultValue <em>Default Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Default Value</em>'.
     * @see era.foss.erf.AttributeDefinitionBoolean#getDefaultValue()
     * @see #getAttributeDefinitionBoolean()
     * @generated
     */
    EReference getAttributeDefinitionBoolean_DefaultValue();

    /**
     * Returns the meta object for class '{@link era.foss.erf.AttributeValueBoolean <em>Attribute Value Boolean</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Attribute Value Boolean</em>'.
     * @see era.foss.erf.AttributeValueBoolean
     * @generated
     */
    EClass getAttributeValueBoolean();

    /**
     * Returns the meta object for the attribute '{@link era.foss.erf.AttributeValueBoolean#getTheValue <em>The Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>The Value</em>'.
     * @see era.foss.erf.AttributeValueBoolean#getTheValue()
     * @see #getAttributeValueBoolean()
     * @generated
     */
    EAttribute getAttributeValueBoolean_TheValue();

    /**
     * Returns the meta object for class '{@link era.foss.erf.ToolExtension <em>Tool Extension</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Tool Extension</em>'.
     * @see era.foss.erf.ToolExtension
     * @generated
     */
    EClass getToolExtension();

    /**
     * Returns the meta object for class '{@link era.foss.erf.View <em>View</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>View</em>'.
     * @see era.foss.erf.View
     * @generated
     */
    EClass getView();

    /**
     * Returns the meta object for the containment reference list '{@link era.foss.erf.View#getViewElements <em>View Elements</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>View Elements</em>'.
     * @see era.foss.erf.View#getViewElements()
     * @see #getView()
     * @generated
     */
    EReference getView_ViewElements();

    /**
     * Returns the meta object for class '{@link era.foss.erf.ViewElement <em>View Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>View Element</em>'.
     * @see era.foss.erf.ViewElement
     * @generated
     */
    EClass getViewElement();

    /**
     * Returns the meta object for the attribute '{@link era.foss.erf.ViewElement#isEditorShowLabel <em>Editor Show Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Editor Show Label</em>'.
     * @see era.foss.erf.ViewElement#isEditorShowLabel()
     * @see #getViewElement()
     * @generated
     */
    EAttribute getViewElement_EditorShowLabel();

    /**
     * Returns the meta object for the attribute '{@link era.foss.erf.ViewElement#getEditorColumnSpan <em>Editor Column Span</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Editor Column Span</em>'.
     * @see era.foss.erf.ViewElement#getEditorColumnSpan()
     * @see #getViewElement()
     * @generated
     */
    EAttribute getViewElement_EditorColumnSpan();

    /**
     * Returns the meta object for the reference '{@link era.foss.erf.ViewElement#getAttributeDefinition <em>Attribute Definition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Attribute Definition</em>'.
     * @see era.foss.erf.ViewElement#getAttributeDefinition()
     * @see #getViewElement()
     * @generated
     */
    EReference getViewElement_AttributeDefinition();

    /**
     * Returns the meta object for the attribute '{@link era.foss.erf.ViewElement#getEditorRowPosition <em>Editor Row Position</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Editor Row Position</em>'.
     * @see era.foss.erf.ViewElement#getEditorRowPosition()
     * @see #getViewElement()
     * @generated
     */
    EAttribute getViewElement_EditorRowPosition();

    /**
     * Returns the meta object for the attribute '{@link era.foss.erf.ViewElement#getEditorRowSpan <em>Editor Row Span</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Editor Row Span</em>'.
     * @see era.foss.erf.ViewElement#getEditorRowSpan()
     * @see #getViewElement()
     * @generated
     */
    EAttribute getViewElement_EditorRowSpan();

    /**
     * Returns the meta object for the attribute '{@link era.foss.erf.ViewElement#getEditorColumnPosition <em>Editor Column Position</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Editor Column Position</em>'.
     * @see era.foss.erf.ViewElement#getEditorColumnPosition()
     * @see #getViewElement()
     * @generated
     */
    EAttribute getViewElement_EditorColumnPosition();

    /**
     * Returns the meta object for class '{@link era.foss.erf.EraToolExtension <em>Era Tool Extension</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Era Tool Extension</em>'.
     * @see era.foss.erf.EraToolExtension
     * @generated
     */
    EClass getEraToolExtension();

    /**
     * Returns the meta object for the containment reference list '{@link era.foss.erf.EraToolExtension#getViews <em>Views</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Views</em>'.
     * @see era.foss.erf.EraToolExtension#getViews()
     * @see #getEraToolExtension()
     * @generated
     */
    EReference getEraToolExtension_Views();

    /**
     * Returns the meta object for class '{@link era.foss.erf.Color <em>Color</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Color</em>'.
     * @see era.foss.erf.Color
     * @generated
     */
    EClass getColor();

    /**
     * Returns the meta object for the attribute '{@link era.foss.erf.Color#getRed <em>Red</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Red</em>'.
     * @see era.foss.erf.Color#getRed()
     * @see #getColor()
     * @generated
     */
    EAttribute getColor_Red();

    /**
     * Returns the meta object for the attribute '{@link era.foss.erf.Color#getGreen <em>Green</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Green</em>'.
     * @see era.foss.erf.Color#getGreen()
     * @see #getColor()
     * @generated
     */
    EAttribute getColor_Green();

    /**
     * Returns the meta object for the attribute '{@link era.foss.erf.Color#getBlue <em>Blue</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Blue</em>'.
     * @see era.foss.erf.Color#getBlue()
     * @see #getColor()
     * @generated
     */
    EAttribute getColor_Blue();

    /**
     * Returns the meta object for data type '{@link org.eclipse.emf.common.util.DiagnosticChain <em>Diagnostic Chain</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Diagnostic Chain</em>'.
     * @see org.eclipse.emf.common.util.DiagnosticChain
     * @model instanceClass="org.eclipse.emf.common.util.DiagnosticChain"
     * @generated
     */
    EDataType getDiagnosticChain();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ErfFactory getErfFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->.
     *
     * @generated
     */
    interface Literals {

        /**
         * The meta object literal for the '{@link era.foss.erf.impl.AttributeDefinitionImpl <em>Attribute Definition</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.AttributeDefinitionImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getAttributeDefinition()
         * @generated
         */
        EClass ATTRIBUTE_DEFINITION = eINSTANCE.getAttributeDefinition();
        /**
         * The meta object literal for the '<em><b>Type</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ATTRIBUTE_DEFINITION__TYPE = eINSTANCE.getAttributeDefinition_Type();
        /**
         * The meta object literal for the '<em><b>Ident</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ATTRIBUTE_DEFINITION__IDENT = eINSTANCE.getAttributeDefinition_Ident();
        /**
         * The meta object literal for the '<em><b>Unique</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ATTRIBUTE_DEFINITION__UNIQUE = eINSTANCE.getAttributeDefinition_Unique();
        /**
         * The meta object literal for the '<em><b>Spec Type</b></em>' container reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ATTRIBUTE_DEFINITION__SPEC_TYPE = eINSTANCE.getAttributeDefinition_SpecType();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.AttributeValueImpl <em>Attribute Value</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.AttributeValueImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getAttributeValue()
         * @generated
         */
        EClass ATTRIBUTE_VALUE = eINSTANCE.getAttributeValue();
        /**
         * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ATTRIBUTE_VALUE__DEFINITION = eINSTANCE.getAttributeValue_Definition();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.DatatypeDefinitionImpl <em>Datatype Definition</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.DatatypeDefinitionImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getDatatypeDefinition()
         * @generated
         */
        EClass DATATYPE_DEFINITION = eINSTANCE.getDatatypeDefinition();
        /**
         * The meta object literal for the '<em><b>Attribute Definitions</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DATATYPE_DEFINITION__ATTRIBUTE_DEFINITIONS = eINSTANCE.getDatatypeDefinition_AttributeDefinitions();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.SpecElementWithUserDefinedAttributesImpl <em>Spec Element With User Defined Attributes</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.SpecElementWithUserDefinedAttributesImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getSpecElementWithUserDefinedAttributes()
         * @generated
         */
        EClass SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES = eINSTANCE.getSpecElementWithUserDefinedAttributes();
        /**
         * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__VALUES = eINSTANCE.getSpecElementWithUserDefinedAttributes_Values();
        /**
         * The meta object literal for the '<em><b>Type</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__TYPE = eINSTANCE.getSpecElementWithUserDefinedAttributes_Type();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.SpecObjectImpl <em>Spec Object</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.SpecObjectImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getSpecObject()
         * @generated
         */
        EClass SPEC_OBJECT = eINSTANCE.getSpecObject();
        /**
         * The meta object literal for the '<em><b>Sources</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SPEC_OBJECT__SOURCES = eINSTANCE.getSpecObject_Sources();
        /**
         * The meta object literal for the '<em><b>Targets</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SPEC_OBJECT__TARGETS = eINSTANCE.getSpecObject_Targets();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.SpecTypeImpl <em>Spec Type</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.SpecTypeImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getSpecType()
         * @generated
         */
        EClass SPEC_TYPE = eINSTANCE.getSpecType();
        /**
         * The meta object literal for the '<em><b>Spec Attributes</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SPEC_TYPE__SPEC_ATTRIBUTES = eINSTANCE.getSpecType_SpecAttributes();
        /**
         * The meta object literal for the '{@link java.util.Map <em>Map</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see java.util.Map
         * @see era.foss.erf.impl.ErfPackageImpl#getMap()
         * @generated
         */
        EClass MAP = eINSTANCE.getMap();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.AttributeValueSimpleImpl <em>Attribute Value Simple</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.AttributeValueSimpleImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getAttributeValueSimple()
         * @generated
         */
        EClass ATTRIBUTE_VALUE_SIMPLE = eINSTANCE.getAttributeValueSimple();
        /**
         * The meta object literal for the '<em><b>The Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ATTRIBUTE_VALUE_SIMPLE__THE_VALUE = eINSTANCE.getAttributeValueSimple_TheValue();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.DatatypeDefinitionIntegerImpl <em>Datatype Definition Integer</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.DatatypeDefinitionIntegerImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getDatatypeDefinitionInteger()
         * @generated
         */
        EClass DATATYPE_DEFINITION_INTEGER = eINSTANCE.getDatatypeDefinitionInteger();
        /**
         * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DATATYPE_DEFINITION_INTEGER__MAX = eINSTANCE.getDatatypeDefinitionInteger_Max();
        /**
         * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DATATYPE_DEFINITION_INTEGER__MIN = eINSTANCE.getDatatypeDefinitionInteger_Min();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.DatatypeDefinitionSimpleImpl <em>Datatype Definition Simple</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.DatatypeDefinitionSimpleImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getDatatypeDefinitionSimple()
         * @generated
         */
        EClass DATATYPE_DEFINITION_SIMPLE = eINSTANCE.getDatatypeDefinitionSimple();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.DatatypeDefinitionStringImpl <em>Datatype Definition String</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.DatatypeDefinitionStringImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getDatatypeDefinitionString()
         * @generated
         */
        EClass DATATYPE_DEFINITION_STRING = eINSTANCE.getDatatypeDefinitionString();
        /**
         * The meta object literal for the '<em><b>Max Length</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DATATYPE_DEFINITION_STRING__MAX_LENGTH = eINSTANCE.getDatatypeDefinitionString_MaxLength();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.IdentifiableImpl <em>Identifiable</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.IdentifiableImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getIdentifiable()
         * @generated
         */
        EClass IDENTIFIABLE = eINSTANCE.getIdentifiable();
        /**
         * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IDENTIFIABLE__ID = eINSTANCE.getIdentifiable_ID();
        /**
         * The meta object literal for the '<em><b>Desc</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IDENTIFIABLE__DESC = eINSTANCE.getIdentifiable_Desc();
        /**
         * The meta object literal for the '<em><b>Long Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IDENTIFIABLE__LONG_NAME = eINSTANCE.getIdentifiable_LongName();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.AttributeDefinitionSimpleImpl <em>Attribute Definition Simple</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.AttributeDefinitionSimpleImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getAttributeDefinitionSimple()
         * @generated
         */
        EClass ATTRIBUTE_DEFINITION_SIMPLE = eINSTANCE.getAttributeDefinitionSimple();
        /**
         * The meta object literal for the '<em><b>Default Value</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ATTRIBUTE_DEFINITION_SIMPLE__DEFAULT_VALUE = eINSTANCE.getAttributeDefinitionSimple_DefaultValue();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.ERFImpl <em>ERF</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.ERFImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getERF()
         * @generated
         */
        EClass ERF = eINSTANCE.getERF();
        /**
         * The meta object literal for the '<em><b>Core Content</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ERF__CORE_CONTENT = eINSTANCE.getERF_CoreContent();
        /**
         * The meta object literal for the '<em><b>Tool Extensions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ERF__TOOL_EXTENSIONS = eINSTANCE.getERF_ToolExtensions();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.ContentImpl <em>Content</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.ContentImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getContent()
         * @generated
         */
        EClass CONTENT = eINSTANCE.getContent();
        /**
         * The meta object literal for the '<em><b>Spec Objects</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONTENT__SPEC_OBJECTS = eINSTANCE.getContent_SpecObjects();
        /**
         * The meta object literal for the '<em><b>Spec Types</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONTENT__SPEC_TYPES = eINSTANCE.getContent_SpecTypes();
        /**
         * The meta object literal for the '<em><b>Data Types</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONTENT__DATA_TYPES = eINSTANCE.getContent_DataTypes();
        /**
         * The meta object literal for the '<em><b>Spec Relations</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONTENT__SPEC_RELATIONS = eINSTANCE.getContent_SpecRelations();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.SpecRelationImpl <em>Spec Relation</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.SpecRelationImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getSpecRelation()
         * @generated
         */
        EClass SPEC_RELATION = eINSTANCE.getSpecRelation();
        /**
         * The meta object literal for the '<em><b>Source</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SPEC_RELATION__SOURCE = eINSTANCE.getSpecRelation_Source();
        /**
         * The meta object literal for the '<em><b>Target</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SPEC_RELATION__TARGET = eINSTANCE.getSpecRelation_Target();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.EmbeddedValueImpl <em>Embedded Value</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.EmbeddedValueImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getEmbeddedValue()
         * @generated
         */
        EClass EMBEDDED_VALUE = eINSTANCE.getEmbeddedValue();
        /**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EMBEDDED_VALUE__KEY = eINSTANCE.getEmbeddedValue_Key();
        /**
         * The meta object literal for the '<em><b>Other Content</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EMBEDDED_VALUE__OTHER_CONTENT = eINSTANCE.getEmbeddedValue_OtherContent();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.EnumValueImpl <em>Enum Value</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.EnumValueImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getEnumValue()
         * @generated
         */
        EClass ENUM_VALUE = eINSTANCE.getEnumValue();
        /**
         * The meta object literal for the '<em><b>Properties</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ENUM_VALUE__PROPERTIES = eINSTANCE.getEnumValue_Properties();
        /**
         * The meta object literal for the '<em><b>Color</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ENUM_VALUE__COLOR = eINSTANCE.getEnumValue_Color();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.DatatypeDefinitionEnumerationImpl <em>Datatype Definition Enumeration</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.DatatypeDefinitionEnumerationImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getDatatypeDefinitionEnumeration()
         * @generated
         */
        EClass DATATYPE_DEFINITION_ENUMERATION = eINSTANCE.getDatatypeDefinitionEnumeration();
        /**
         * The meta object literal for the '<em><b>Specified Values</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DATATYPE_DEFINITION_ENUMERATION__SPECIFIED_VALUES = eINSTANCE.getDatatypeDefinitionEnumeration_SpecifiedValues();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.AttributeDefinitionEnumerationImpl <em>Attribute Definition Enumeration</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.AttributeDefinitionEnumerationImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getAttributeDefinitionEnumeration()
         * @generated
         */
        EClass ATTRIBUTE_DEFINITION_ENUMERATION = eINSTANCE.getAttributeDefinitionEnumeration();
        /**
         * The meta object literal for the '<em><b>Multi Valued</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ATTRIBUTE_DEFINITION_ENUMERATION__MULTI_VALUED = eINSTANCE.getAttributeDefinitionEnumeration_MultiValued();
        /**
         * The meta object literal for the '<em><b>Default Value</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ATTRIBUTE_DEFINITION_ENUMERATION__DEFAULT_VALUE = eINSTANCE.getAttributeDefinitionEnumeration_DefaultValue();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.AttributeValueEnumerationImpl <em>Attribute Value Enumeration</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.AttributeValueEnumerationImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getAttributeValueEnumeration()
         * @generated
         */
        EClass ATTRIBUTE_VALUE_ENUMERATION = eINSTANCE.getAttributeValueEnumeration();
        /**
         * The meta object literal for the '<em><b>Values</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ATTRIBUTE_VALUE_ENUMERATION__VALUES = eINSTANCE.getAttributeValueEnumeration_Values();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.DatatypeDefinitionBooleanImpl <em>Datatype Definition Boolean</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.DatatypeDefinitionBooleanImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getDatatypeDefinitionBoolean()
         * @generated
         */
        EClass DATATYPE_DEFINITION_BOOLEAN = eINSTANCE.getDatatypeDefinitionBoolean();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.AttributeDefinitionBooleanImpl <em>Attribute Definition Boolean</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.AttributeDefinitionBooleanImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getAttributeDefinitionBoolean()
         * @generated
         */
        EClass ATTRIBUTE_DEFINITION_BOOLEAN = eINSTANCE.getAttributeDefinitionBoolean();
        /**
         * The meta object literal for the '<em><b>Default Value</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ATTRIBUTE_DEFINITION_BOOLEAN__DEFAULT_VALUE = eINSTANCE.getAttributeDefinitionBoolean_DefaultValue();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.AttributeValueBooleanImpl <em>Attribute Value Boolean</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.AttributeValueBooleanImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getAttributeValueBoolean()
         * @generated
         */
        EClass ATTRIBUTE_VALUE_BOOLEAN = eINSTANCE.getAttributeValueBoolean();
        /**
         * The meta object literal for the '<em><b>The Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ATTRIBUTE_VALUE_BOOLEAN__THE_VALUE = eINSTANCE.getAttributeValueBoolean_TheValue();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.ToolExtensionImpl <em>Tool Extension</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.ToolExtensionImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getToolExtension()
         * @generated
         */
        EClass TOOL_EXTENSION = eINSTANCE.getToolExtension();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.ViewImpl <em>View</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.ViewImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getView()
         * @generated
         */
        EClass VIEW = eINSTANCE.getView();
        /**
         * The meta object literal for the '<em><b>View Elements</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VIEW__VIEW_ELEMENTS = eINSTANCE.getView_ViewElements();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.ViewElementImpl <em>View Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.ViewElementImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getViewElement()
         * @generated
         */
        EClass VIEW_ELEMENT = eINSTANCE.getViewElement();
        /**
         * The meta object literal for the '<em><b>Editor Show Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VIEW_ELEMENT__EDITOR_SHOW_LABEL = eINSTANCE.getViewElement_EditorShowLabel();
        /**
         * The meta object literal for the '<em><b>Editor Column Span</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VIEW_ELEMENT__EDITOR_COLUMN_SPAN = eINSTANCE.getViewElement_EditorColumnSpan();
        /**
         * The meta object literal for the '<em><b>Attribute Definition</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VIEW_ELEMENT__ATTRIBUTE_DEFINITION = eINSTANCE.getViewElement_AttributeDefinition();
        /**
         * The meta object literal for the '<em><b>Editor Row Position</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VIEW_ELEMENT__EDITOR_ROW_POSITION = eINSTANCE.getViewElement_EditorRowPosition();
        /**
         * The meta object literal for the '<em><b>Editor Row Span</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VIEW_ELEMENT__EDITOR_ROW_SPAN = eINSTANCE.getViewElement_EditorRowSpan();
        /**
         * The meta object literal for the '<em><b>Editor Column Position</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VIEW_ELEMENT__EDITOR_COLUMN_POSITION = eINSTANCE.getViewElement_EditorColumnPosition();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.EraToolExtensionImpl <em>Era Tool Extension</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.EraToolExtensionImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getEraToolExtension()
         * @generated
         */
        EClass ERA_TOOL_EXTENSION = eINSTANCE.getEraToolExtension();
        /**
         * The meta object literal for the '<em><b>Views</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ERA_TOOL_EXTENSION__VIEWS = eINSTANCE.getEraToolExtension_Views();
        /**
         * The meta object literal for the '{@link era.foss.erf.impl.ColorImpl <em>Color</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see era.foss.erf.impl.ColorImpl
         * @see era.foss.erf.impl.ErfPackageImpl#getColor()
         * @generated
         */
        EClass COLOR = eINSTANCE.getColor();
        /**
         * The meta object literal for the '<em><b>Red</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COLOR__RED = eINSTANCE.getColor_Red();
        /**
         * The meta object literal for the '<em><b>Green</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COLOR__GREEN = eINSTANCE.getColor_Green();
        /**
         * The meta object literal for the '<em><b>Blue</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COLOR__BLUE = eINSTANCE.getColor_Blue();
        /**
         * The meta object literal for the '<em>Diagnostic Chain</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.emf.common.util.DiagnosticChain
         * @see era.foss.erf.impl.ErfPackageImpl#getDiagnosticChain()
         * @generated
         */
        EDataType DIAGNOSTIC_CHAIN = eINSTANCE.getDiagnosticChain();

    }

} //ErfPackage
