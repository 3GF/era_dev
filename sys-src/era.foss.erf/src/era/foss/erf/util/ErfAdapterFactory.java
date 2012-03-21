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

import java.util.Map;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see era.foss.erf.ErfPackage
 * @generated
 */
public class ErfAdapterFactory extends AdapterFactoryImpl {

    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ErfPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ErfAdapterFactory() {
        if( modelPackage == null ) {
            modelPackage = ErfPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType( Object object ) {
        if( object == modelPackage ) {
            return true;
        }
        if( object instanceof EObject ) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ErfSwitch<Adapter> modelSwitch = new ErfSwitch<Adapter>() {
        @Override
        public Adapter caseAttributeDefinition( AttributeDefinition object ) {
            return createAttributeDefinitionAdapter();
        }

        @Override
        public Adapter caseAttributeValue( AttributeValue object ) {
            return createAttributeValueAdapter();
        }

        @Override
        public Adapter caseDatatypeDefinition( DatatypeDefinition object ) {
            return createDatatypeDefinitionAdapter();
        }

        @Override
        public Adapter caseSpecElementWithUserDefinedAttributes( SpecElementWithUserDefinedAttributes object ) {
            return createSpecElementWithUserDefinedAttributesAdapter();
        }

        @Override
        public Adapter caseSpecObject( SpecObject object ) {
            return createSpecObjectAdapter();
        }

        @Override
        public Adapter caseSpecType( SpecType object ) {
            return createSpecTypeAdapter();
        }

        @Override
        public <T, T1> Adapter caseMap( Map<T, T1> object ) {
            return createMapAdapter();
        }

        @Override
        public Adapter caseAttributeValueSimple( AttributeValueSimple object ) {
            return createAttributeValueSimpleAdapter();
        }

        @Override
        public Adapter caseDatatypeDefinitionInteger( DatatypeDefinitionInteger object ) {
            return createDatatypeDefinitionIntegerAdapter();
        }

        @Override
        public Adapter caseDatatypeDefinitionSimple( DatatypeDefinitionSimple object ) {
            return createDatatypeDefinitionSimpleAdapter();
        }

        @Override
        public Adapter caseDatatypeDefinitionString( DatatypeDefinitionString object ) {
            return createDatatypeDefinitionStringAdapter();
        }

        @Override
        public Adapter caseIdentifiable( Identifiable object ) {
            return createIdentifiableAdapter();
        }

        @Override
        public Adapter caseAttributeDefinitionSimple( AttributeDefinitionSimple object ) {
            return createAttributeDefinitionSimpleAdapter();
        }

        @Override
        public Adapter caseERF( ERF object ) {
            return createERFAdapter();
        }

        @Override
        public Adapter caseContent( Content object ) {
            return createContentAdapter();
        }

        @Override
        public Adapter caseSpecRelation( SpecRelation object ) {
            return createSpecRelationAdapter();
        }

        @Override
        public Adapter caseEmbeddedValue( EmbeddedValue object ) {
            return createEmbeddedValueAdapter();
        }

        @Override
        public Adapter caseEnumValue( EnumValue object ) {
            return createEnumValueAdapter();
        }

        @Override
        public Adapter caseDatatypeDefinitionEnumeration( DatatypeDefinitionEnumeration object ) {
            return createDatatypeDefinitionEnumerationAdapter();
        }

        @Override
        public Adapter caseAttributeDefinitionEnumeration( AttributeDefinitionEnumeration object ) {
            return createAttributeDefinitionEnumerationAdapter();
        }

        @Override
        public Adapter caseAttributeValueEnumeration( AttributeValueEnumeration object ) {
            return createAttributeValueEnumerationAdapter();
        }

        @Override
        public Adapter caseDatatypeDefinitionBoolean( DatatypeDefinitionBoolean object ) {
            return createDatatypeDefinitionBooleanAdapter();
        }

        @Override
        public Adapter caseAttributeDefinitionBoolean( AttributeDefinitionBoolean object ) {
            return createAttributeDefinitionBooleanAdapter();
        }

        @Override
        public Adapter caseAttributeValueBoolean( AttributeValueBoolean object ) {
            return createAttributeValueBooleanAdapter();
        }

        @Override
        public Adapter caseToolExtension( ToolExtension object ) {
            return createToolExtensionAdapter();
        }

        @Override
        public Adapter caseView( View object ) {
            return createViewAdapter();
        }

        @Override
        public Adapter caseViewElement( ViewElement object ) {
            return createViewElementAdapter();
        }

        @Override
        public Adapter caseEraToolExtension( EraToolExtension object ) {
            return createEraToolExtensionAdapter();
        }

        @Override
        public Adapter defaultCase( EObject object ) {
            return createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter( Notifier target ) {
        return modelSwitch.doSwitch( (EObject)target );
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.AttributeDefinition <em>Attribute Definition</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.AttributeDefinition
     * @generated
     */
    public Adapter createAttributeDefinitionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.AttributeValue <em>Attribute Value</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.AttributeValue
     * @generated
     */
    public Adapter createAttributeValueAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.DatatypeDefinition <em>Datatype Definition</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.DatatypeDefinition
     * @generated
     */
    public Adapter createDatatypeDefinitionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.SpecElementWithUserDefinedAttributes <em>Spec Element With User Defined Attributes</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.SpecElementWithUserDefinedAttributes
     * @generated
     */
    public Adapter createSpecElementWithUserDefinedAttributesAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.SpecObject <em>Spec Object</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.SpecObject
     * @generated
     */
    public Adapter createSpecObjectAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.SpecType <em>Spec Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.SpecType
     * @generated
     */
    public Adapter createSpecTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link java.util.Map <em>Map</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see java.util.Map
     * @generated
     */
    public Adapter createMapAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.AttributeValueSimple <em>Attribute Value Simple</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.AttributeValueSimple
     * @generated
     */
    public Adapter createAttributeValueSimpleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.DatatypeDefinitionInteger <em>Datatype Definition Integer</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.DatatypeDefinitionInteger
     * @generated
     */
    public Adapter createDatatypeDefinitionIntegerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.DatatypeDefinitionSimple <em>Datatype Definition Simple</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.DatatypeDefinitionSimple
     * @generated
     */
    public Adapter createDatatypeDefinitionSimpleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.DatatypeDefinitionString <em>Datatype Definition String</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.DatatypeDefinitionString
     * @generated
     */
    public Adapter createDatatypeDefinitionStringAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.Identifiable <em>Identifiable</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.Identifiable
     * @generated
     */
    public Adapter createIdentifiableAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.AttributeDefinitionSimple <em>Attribute Definition Simple</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.AttributeDefinitionSimple
     * @generated
     */
    public Adapter createAttributeDefinitionSimpleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.ERF <em>ERF</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.ERF
     * @generated
     */
    public Adapter createERFAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.Content <em>Content</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.Content
     * @generated
     */
    public Adapter createContentAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.SpecRelation <em>Spec Relation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.SpecRelation
     * @generated
     */
    public Adapter createSpecRelationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.EmbeddedValue <em>Embedded Value</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.EmbeddedValue
     * @generated
     */
    public Adapter createEmbeddedValueAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.EnumValue <em>Enum Value</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.EnumValue
     * @generated
     */
    public Adapter createEnumValueAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.DatatypeDefinitionEnumeration <em>Datatype Definition Enumeration</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.DatatypeDefinitionEnumeration
     * @generated
     */
    public Adapter createDatatypeDefinitionEnumerationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.AttributeDefinitionEnumeration <em>Attribute Definition Enumeration</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.AttributeDefinitionEnumeration
     * @generated
     */
    public Adapter createAttributeDefinitionEnumerationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.AttributeValueEnumeration <em>Attribute Value Enumeration</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.AttributeValueEnumeration
     * @generated
     */
    public Adapter createAttributeValueEnumerationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.DatatypeDefinitionBoolean <em>Datatype Definition Boolean</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.DatatypeDefinitionBoolean
     * @generated
     */
    public Adapter createDatatypeDefinitionBooleanAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.AttributeDefinitionBoolean <em>Attribute Definition Boolean</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.AttributeDefinitionBoolean
     * @generated
     */
    public Adapter createAttributeDefinitionBooleanAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.AttributeValueBoolean <em>Attribute Value Boolean</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.AttributeValueBoolean
     * @generated
     */
    public Adapter createAttributeValueBooleanAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.ToolExtension <em>Tool Extension</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.ToolExtension
     * @generated
     */
    public Adapter createToolExtensionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.View <em>View</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.View
     * @generated
     */
    public Adapter createViewAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.ViewElement <em>View Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.ViewElement
     * @generated
     */
    public Adapter createViewElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link era.foss.erf.EraToolExtension <em>Era Tool Extension</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see era.foss.erf.EraToolExtension
     * @generated
     */
    public Adapter createEraToolExtensionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //ErfAdapterFactory
