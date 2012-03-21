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
package era.foss.erf.util;

import era.foss.erf.*;

import java.util.List;

import java.util.Map;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see era.foss.erf.ErfPackage
 * @generated
 */
public class ErfSwitch<T2> {

    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ErfPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ErfSwitch() {
        if( modelPackage == null ) {
            modelPackage = ErfPackage.eINSTANCE;
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    public T2 doSwitch( EObject theEObject ) {
        return doSwitch( theEObject.eClass(), theEObject );
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T2 doSwitch( EClass theEClass, EObject theEObject ) {
        if( theEClass.eContainer() == modelPackage ) {
            return doSwitch( theEClass.getClassifierID(), theEObject );
        } else {
            List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return eSuperTypes.isEmpty() ? defaultCase( theEObject ) : doSwitch( eSuperTypes.get( 0 ), theEObject );
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T2 doSwitch( int classifierID, EObject theEObject ) {
        switch (classifierID) {
        case ErfPackage.ATTRIBUTE_DEFINITION: {
            AttributeDefinition attributeDefinition = (AttributeDefinition)theEObject;
            T2 result = caseAttributeDefinition( attributeDefinition );
            if( result == null ) result = caseIdentifiable( attributeDefinition );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        case ErfPackage.ATTRIBUTE_VALUE: {
            AttributeValue attributeValue = (AttributeValue)theEObject;
            T2 result = caseAttributeValue( attributeValue );
            if( result == null ) result = caseIdentifiable( attributeValue );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        case ErfPackage.DATATYPE_DEFINITION: {
            DatatypeDefinition datatypeDefinition = (DatatypeDefinition)theEObject;
            T2 result = caseDatatypeDefinition( datatypeDefinition );
            if( result == null ) result = caseIdentifiable( datatypeDefinition );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        case ErfPackage.SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES: {
            SpecElementWithUserDefinedAttributes specElementWithUserDefinedAttributes = (SpecElementWithUserDefinedAttributes)theEObject;
            T2 result = caseSpecElementWithUserDefinedAttributes( specElementWithUserDefinedAttributes );
            if( result == null ) result = caseIdentifiable( specElementWithUserDefinedAttributes );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        case ErfPackage.SPEC_OBJECT: {
            SpecObject specObject = (SpecObject)theEObject;
            T2 result = caseSpecObject( specObject );
            if( result == null ) result = caseSpecElementWithUserDefinedAttributes( specObject );
            if( result == null ) result = caseIdentifiable( specObject );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        case ErfPackage.SPEC_TYPE: {
            SpecType specType = (SpecType)theEObject;
            T2 result = caseSpecType( specType );
            if( result == null ) result = caseIdentifiable( specType );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        case ErfPackage.ATTRIBUTE_VALUE_SIMPLE: {
            AttributeValueSimple attributeValueSimple = (AttributeValueSimple)theEObject;
            T2 result = caseAttributeValueSimple( attributeValueSimple );
            if( result == null ) result = caseAttributeValue( attributeValueSimple );
            if( result == null ) result = caseIdentifiable( attributeValueSimple );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        case ErfPackage.DATATYPE_DEFINITION_INTEGER: {
            DatatypeDefinitionInteger datatypeDefinitionInteger = (DatatypeDefinitionInteger)theEObject;
            T2 result = caseDatatypeDefinitionInteger( datatypeDefinitionInteger );
            if( result == null ) result = caseDatatypeDefinitionSimple( datatypeDefinitionInteger );
            if( result == null ) result = caseDatatypeDefinition( datatypeDefinitionInteger );
            if( result == null ) result = caseIdentifiable( datatypeDefinitionInteger );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        case ErfPackage.DATATYPE_DEFINITION_SIMPLE: {
            DatatypeDefinitionSimple datatypeDefinitionSimple = (DatatypeDefinitionSimple)theEObject;
            T2 result = caseDatatypeDefinitionSimple( datatypeDefinitionSimple );
            if( result == null ) result = caseDatatypeDefinition( datatypeDefinitionSimple );
            if( result == null ) result = caseIdentifiable( datatypeDefinitionSimple );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        case ErfPackage.DATATYPE_DEFINITION_STRING: {
            DatatypeDefinitionString datatypeDefinitionString = (DatatypeDefinitionString)theEObject;
            T2 result = caseDatatypeDefinitionString( datatypeDefinitionString );
            if( result == null ) result = caseDatatypeDefinitionSimple( datatypeDefinitionString );
            if( result == null ) result = caseDatatypeDefinition( datatypeDefinitionString );
            if( result == null ) result = caseIdentifiable( datatypeDefinitionString );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        case ErfPackage.IDENTIFIABLE: {
            Identifiable identifiable = (Identifiable)theEObject;
            T2 result = caseIdentifiable( identifiable );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        case ErfPackage.ATTRIBUTE_DEFINITION_SIMPLE: {
            AttributeDefinitionSimple attributeDefinitionSimple = (AttributeDefinitionSimple)theEObject;
            T2 result = caseAttributeDefinitionSimple( attributeDefinitionSimple );
            if( result == null ) result = caseAttributeDefinition( attributeDefinitionSimple );
            if( result == null ) result = caseIdentifiable( attributeDefinitionSimple );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        case ErfPackage.ERF: {
            ERF erf = (ERF)theEObject;
            T2 result = caseERF( erf );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        case ErfPackage.CONTENT: {
            Content content = (Content)theEObject;
            T2 result = caseContent( content );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        case ErfPackage.SPEC_RELATION: {
            SpecRelation specRelation = (SpecRelation)theEObject;
            T2 result = caseSpecRelation( specRelation );
            if( result == null ) result = caseSpecElementWithUserDefinedAttributes( specRelation );
            if( result == null ) result = caseIdentifiable( specRelation );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        case ErfPackage.EMBEDDED_VALUE: {
            EmbeddedValue embeddedValue = (EmbeddedValue)theEObject;
            T2 result = caseEmbeddedValue( embeddedValue );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        case ErfPackage.ENUM_VALUE: {
            EnumValue enumValue = (EnumValue)theEObject;
            T2 result = caseEnumValue( enumValue );
            if( result == null ) result = caseIdentifiable( enumValue );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        case ErfPackage.DATATYPE_DEFINITION_ENUMERATION: {
            DatatypeDefinitionEnumeration datatypeDefinitionEnumeration = (DatatypeDefinitionEnumeration)theEObject;
            T2 result = caseDatatypeDefinitionEnumeration( datatypeDefinitionEnumeration );
            if( result == null ) result = caseDatatypeDefinition( datatypeDefinitionEnumeration );
            if( result == null ) result = caseIdentifiable( datatypeDefinitionEnumeration );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        case ErfPackage.ATTRIBUTE_DEFINITION_ENUMERATION: {
            AttributeDefinitionEnumeration attributeDefinitionEnumeration = (AttributeDefinitionEnumeration)theEObject;
            T2 result = caseAttributeDefinitionEnumeration( attributeDefinitionEnumeration );
            if( result == null ) result = caseAttributeDefinition( attributeDefinitionEnumeration );
            if( result == null ) result = caseIdentifiable( attributeDefinitionEnumeration );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        case ErfPackage.ATTRIBUTE_VALUE_ENUMERATION: {
            AttributeValueEnumeration attributeValueEnumeration = (AttributeValueEnumeration)theEObject;
            T2 result = caseAttributeValueEnumeration( attributeValueEnumeration );
            if( result == null ) result = caseAttributeValue( attributeValueEnumeration );
            if( result == null ) result = caseIdentifiable( attributeValueEnumeration );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        case ErfPackage.DATATYPE_DEFINITION_BOOLEAN: {
            DatatypeDefinitionBoolean datatypeDefinitionBoolean = (DatatypeDefinitionBoolean)theEObject;
            T2 result = caseDatatypeDefinitionBoolean( datatypeDefinitionBoolean );
            if( result == null ) result = caseDatatypeDefinition( datatypeDefinitionBoolean );
            if( result == null ) result = caseIdentifiable( datatypeDefinitionBoolean );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        case ErfPackage.ATTRIBUTE_DEFINITION_BOOLEAN: {
            AttributeDefinitionBoolean attributeDefinitionBoolean = (AttributeDefinitionBoolean)theEObject;
            T2 result = caseAttributeDefinitionBoolean( attributeDefinitionBoolean );
            if( result == null ) result = caseAttributeDefinition( attributeDefinitionBoolean );
            if( result == null ) result = caseIdentifiable( attributeDefinitionBoolean );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        case ErfPackage.ATTRIBUTE_VALUE_BOOLEAN: {
            AttributeValueBoolean attributeValueBoolean = (AttributeValueBoolean)theEObject;
            T2 result = caseAttributeValueBoolean( attributeValueBoolean );
            if( result == null ) result = caseAttributeValue( attributeValueBoolean );
            if( result == null ) result = caseIdentifiable( attributeValueBoolean );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        case ErfPackage.TOOL_EXTENSION: {
            ToolExtension toolExtension = (ToolExtension)theEObject;
            T2 result = caseToolExtension( toolExtension );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        case ErfPackage.VIEW: {
            View view = (View)theEObject;
            T2 result = caseView( view );
            if( result == null ) result = caseIdentifiable( view );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        case ErfPackage.VIEW_ELEMENT: {
            ViewElement viewElement = (ViewElement)theEObject;
            T2 result = caseViewElement( viewElement );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        case ErfPackage.ERA_TOOL_EXTENSION: {
            EraToolExtension eraToolExtension = (EraToolExtension)theEObject;
            T2 result = caseEraToolExtension( eraToolExtension );
            if( result == null ) result = caseToolExtension( eraToolExtension );
            if( result == null ) result = defaultCase( theEObject );
            return result;
        }
        default:
            return defaultCase( theEObject );
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Attribute Definition</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Attribute Definition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseAttributeDefinition( AttributeDefinition object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Attribute Value</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Attribute Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseAttributeValue( AttributeValue object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Datatype Definition</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Datatype Definition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseDatatypeDefinition( DatatypeDefinition object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Spec Element With User Defined Attributes</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Spec Element With User Defined Attributes</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseSpecElementWithUserDefinedAttributes( SpecElementWithUserDefinedAttributes object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Spec Object</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Spec Object</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseSpecObject( SpecObject object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Spec Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Spec Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseSpecType( SpecType object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Map</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Map</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <T, T1> T2 caseMap( Map<T, T1> object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Attribute Value Simple</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Attribute Value Simple</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseAttributeValueSimple( AttributeValueSimple object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Datatype Definition Integer</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Datatype Definition Integer</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseDatatypeDefinitionInteger( DatatypeDefinitionInteger object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Datatype Definition Simple</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Datatype Definition Simple</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseDatatypeDefinitionSimple( DatatypeDefinitionSimple object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Datatype Definition String</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Datatype Definition String</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseDatatypeDefinitionString( DatatypeDefinitionString object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Identifiable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Identifiable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseIdentifiable( Identifiable object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Attribute Definition Simple</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Attribute Definition Simple</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseAttributeDefinitionSimple( AttributeDefinitionSimple object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>ERF</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>ERF</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseERF( ERF object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Content</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Content</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseContent( Content object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Spec Relation</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Spec Relation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseSpecRelation( SpecRelation object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Embedded Value</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Embedded Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseEmbeddedValue( EmbeddedValue object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Enum Value</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Enum Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseEnumValue( EnumValue object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Datatype Definition Enumeration</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Datatype Definition Enumeration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseDatatypeDefinitionEnumeration( DatatypeDefinitionEnumeration object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Attribute Definition Enumeration</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Attribute Definition Enumeration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseAttributeDefinitionEnumeration( AttributeDefinitionEnumeration object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Attribute Value Enumeration</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Attribute Value Enumeration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseAttributeValueEnumeration( AttributeValueEnumeration object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Datatype Definition Boolean</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Datatype Definition Boolean</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseDatatypeDefinitionBoolean( DatatypeDefinitionBoolean object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Attribute Definition Boolean</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Attribute Definition Boolean</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseAttributeDefinitionBoolean( AttributeDefinitionBoolean object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Attribute Value Boolean</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Attribute Value Boolean</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseAttributeValueBoolean( AttributeValueBoolean object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Tool Extension</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Tool Extension</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseToolExtension( ToolExtension object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>View</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>View</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseView( View object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>View Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>View Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseViewElement( ViewElement object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Era Tool Extension</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Era Tool Extension</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T2 caseEraToolExtension( EraToolExtension object ) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    public T2 defaultCase( EObject object ) {
        return null;
    }

} //ErfSwitch
