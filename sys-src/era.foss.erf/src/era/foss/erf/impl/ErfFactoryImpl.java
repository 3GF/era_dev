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
package era.foss.erf.impl;

import era.foss.erf.*;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ErfFactoryImpl extends EFactoryImpl implements ErfFactory {

    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return the erf factory
     * @generated
     */
    public static ErfFactory init() {
        try {
            ErfFactory theErfFactory = (ErfFactory)EPackage.Registry.INSTANCE.getEFactory( "http://era/foss/erf" );
            if( theErfFactory != null ) {
                return theErfFactory;
            }
        } catch( Exception exception ) {
            EcorePlugin.INSTANCE.log( exception );
        }
        return new ErfFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ErfFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create( EClass eClass ) {
        switch (eClass.getClassifierID()) {
        case ErfPackage.SPEC_OBJECT:
            return createSpecObject();
        case ErfPackage.SPEC_TYPE:
            return createSpecType();
        case ErfPackage.ATTRIBUTE_VALUE_SIMPLE:
            return createAttributeValueSimple();
        case ErfPackage.DATATYPE_DEFINITION_INTEGER:
            return createDatatypeDefinitionInteger();
        case ErfPackage.DATATYPE_DEFINITION_STRING:
            return createDatatypeDefinitionString();
        case ErfPackage.ATTRIBUTE_DEFINITION_SIMPLE:
            return createAttributeDefinitionSimple();
        case ErfPackage.ERF:
            return createERF();
        case ErfPackage.CONTENT:
            return createContent();
        case ErfPackage.SPEC_RELATION:
            return createSpecRelation();
        case ErfPackage.EMBEDDED_VALUE:
            return createEmbeddedValue();
        case ErfPackage.ENUM_VALUE:
            return createEnumValue();
        case ErfPackage.DATATYPE_DEFINITION_ENUMERATION:
            return createDatatypeDefinitionEnumeration();
        case ErfPackage.ATTRIBUTE_DEFINITION_ENUMERATION:
            return createAttributeDefinitionEnumeration();
        case ErfPackage.ATTRIBUTE_VALUE_ENUMERATION:
            return createAttributeValueEnumeration();
        case ErfPackage.DATATYPE_DEFINITION_BOOLEAN:
            return createDatatypeDefinitionBoolean();
        case ErfPackage.ATTRIBUTE_DEFINITION_BOOLEAN:
            return createAttributeDefinitionBoolean();
        case ErfPackage.ATTRIBUTE_VALUE_BOOLEAN:
            return createAttributeValueBoolean();
        case ErfPackage.VIEW:
            return createView();
        case ErfPackage.VIEW_ELEMENT:
            return createViewElement();
        case ErfPackage.ERA_TOOL_EXTENSION:
            return createEraToolExtension();
        case ErfPackage.COLOR:
            return createColor();
        default:
            throw new IllegalArgumentException( "The class '" + eClass.getName() + "' is not a valid classifier" );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString( EDataType eDataType, String initialValue ) {
        switch (eDataType.getClassifierID()) {
        case ErfPackage.DIAGNOSTIC_CHAIN:
            return createDiagnosticChainFromString( eDataType, initialValue );
        default:
            throw new IllegalArgumentException( "The datatype '"
                + eDataType.getName()
                + "' is not a valid classifier" );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString( EDataType eDataType, Object instanceValue ) {
        switch (eDataType.getClassifierID()) {
        case ErfPackage.DIAGNOSTIC_CHAIN:
            return convertDiagnosticChainToString( eDataType, instanceValue );
        default:
            throw new IllegalArgumentException( "The datatype '"
                + eDataType.getName()
                + "' is not a valid classifier" );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SpecObject createSpecObject() {
        SpecObjectImpl specObject = new SpecObjectImpl();
        return specObject;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SpecType createSpecType() {
        SpecTypeImpl specType = new SpecTypeImpl();
        return specType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AttributeValueSimple createAttributeValueSimple() {
        AttributeValueSimpleImpl attributeValueSimple = new AttributeValueSimpleImpl();
        return attributeValueSimple;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DatatypeDefinitionInteger createDatatypeDefinitionInteger() {
        DatatypeDefinitionIntegerImpl datatypeDefinitionInteger = new DatatypeDefinitionIntegerImpl();
        return datatypeDefinitionInteger;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DatatypeDefinitionString createDatatypeDefinitionString() {
        DatatypeDefinitionStringImpl datatypeDefinitionString = new DatatypeDefinitionStringImpl();
        return datatypeDefinitionString;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AttributeDefinitionSimple createAttributeDefinitionSimple() {
        AttributeDefinitionSimpleImpl attributeDefinitionSimple = new AttributeDefinitionSimpleImpl();
        return attributeDefinitionSimple;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ERF createERF() {
        ERFImpl erf = new ERFImpl();
        return erf;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Content createContent() {
        ContentImpl content = new ContentImpl();
        return content;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SpecRelation createSpecRelation() {
        SpecRelationImpl specRelation = new SpecRelationImpl();
        return specRelation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EmbeddedValue createEmbeddedValue() {
        EmbeddedValueImpl embeddedValue = new EmbeddedValueImpl();
        return embeddedValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EnumValue createEnumValue() {
        EnumValueImpl enumValue = new EnumValueImpl();
        return enumValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DatatypeDefinitionEnumeration createDatatypeDefinitionEnumeration() {
        DatatypeDefinitionEnumerationImpl datatypeDefinitionEnumeration = new DatatypeDefinitionEnumerationImpl();
        return datatypeDefinitionEnumeration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AttributeDefinitionEnumeration createAttributeDefinitionEnumeration() {
        AttributeDefinitionEnumerationImpl attributeDefinitionEnumeration = new AttributeDefinitionEnumerationImpl();
        return attributeDefinitionEnumeration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AttributeValueEnumeration createAttributeValueEnumeration() {
        AttributeValueEnumerationImpl attributeValueEnumeration = new AttributeValueEnumerationImpl();
        return attributeValueEnumeration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DatatypeDefinitionBoolean createDatatypeDefinitionBoolean() {
        DatatypeDefinitionBooleanImpl datatypeDefinitionBoolean = new DatatypeDefinitionBooleanImpl();
        return datatypeDefinitionBoolean;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AttributeDefinitionBoolean createAttributeDefinitionBoolean() {
        AttributeDefinitionBooleanImpl attributeDefinitionBoolean = new AttributeDefinitionBooleanImpl();
        return attributeDefinitionBoolean;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AttributeValueBoolean createAttributeValueBoolean() {
        AttributeValueBooleanImpl attributeValueBoolean = new AttributeValueBooleanImpl();
        return attributeValueBoolean;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public View createView() {
        ViewImpl view = new ViewImpl();
        return view;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ViewElement createViewElement() {
        ViewElementImpl viewElement = new ViewElementImpl();
        return viewElement;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EraToolExtension createEraToolExtension() {
        EraToolExtensionImpl eraToolExtension = new EraToolExtensionImpl();
        return eraToolExtension;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Color createColor() {
        ColorImpl color = new ColorImpl();
        return color;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @param eDataType the e data type
     * @param initialValue the initial value
     * @return the diagnostic chain
     * @generated
     */
    public DiagnosticChain createDiagnosticChainFromString( EDataType eDataType, String initialValue ) {
        return (DiagnosticChain)super.createFromString( eDataType, initialValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @param eDataType the e data type
     * @param instanceValue the instance value
     * @return the string
     * @generated
     */
    public String convertDiagnosticChainToString( EDataType eDataType, Object instanceValue ) {
        return super.convertToString( eDataType, instanceValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the erf package
     * @generated
     */
    public ErfPackage getErfPackage() {
        return (ErfPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the package
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ErfPackage getPackage() {
        return ErfPackage.eINSTANCE;
    }

} //ErfFactoryImpl
