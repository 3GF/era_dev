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

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import era.foss.erf.AttributeDefinition;
import era.foss.erf.AttributeDefinitionBoolean;
import era.foss.erf.AttributeDefinitionEnumeration;
import era.foss.erf.AttributeDefinitionSimple;
import era.foss.erf.AttributeValue;
import era.foss.erf.AttributeValueBoolean;
import era.foss.erf.AttributeValueEnumeration;
import era.foss.erf.AttributeValueSimple;
import era.foss.erf.Color;
import era.foss.erf.Content;
import era.foss.erf.DatatypeDefinition;
import era.foss.erf.DatatypeDefinitionBoolean;
import era.foss.erf.DatatypeDefinitionEnumeration;
import era.foss.erf.DatatypeDefinitionInteger;
import era.foss.erf.DatatypeDefinitionSimple;
import era.foss.erf.DatatypeDefinitionString;
import era.foss.erf.EmbeddedValue;
import era.foss.erf.EnumValue;
import era.foss.erf.ErfFactory;
import era.foss.erf.ErfPackage;
import era.foss.erf.EraToolExtension;
import era.foss.erf.Identifiable;
import era.foss.erf.SpecElementWithUserDefinedAttributes;
import era.foss.erf.SpecObject;
import era.foss.erf.SpecRelation;
import era.foss.erf.SpecType;
import era.foss.erf.ToolExtension;
import era.foss.erf.View;
import era.foss.erf.ViewElement;
import era.foss.erf.util.ErfValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class ErfPackageImpl extends EPackageImpl implements ErfPackage {

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass attributeDefinitionEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass attributeValueEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass datatypeDefinitionEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass specElementWithUserDefinedAttributesEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass specObjectEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass specTypeEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass mapEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass attributeValueSimpleEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass datatypeDefinitionIntegerEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass datatypeDefinitionSimpleEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass datatypeDefinitionStringEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass identifiableEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass attributeDefinitionSimpleEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass erfEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass contentEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass specRelationEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass embeddedValueEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass enumValueEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass datatypeDefinitionEnumerationEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass attributeDefinitionEnumerationEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass attributeValueEnumerationEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass datatypeDefinitionBooleanEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass attributeDefinitionBooleanEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass attributeValueBooleanEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass toolExtensionEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass viewEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass viewElementEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass eraToolExtensionEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EClass colorEClass = null;

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private EDataType diagnosticChainEDataType = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
     * EPackage.Registry} by the package package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
     * performs initialization of the package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see era.foss.erf.ErfPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ErfPackageImpl() {
        super( eNS_URI, ErfFactory.eINSTANCE );
    }

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link ErfPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @return the erf package
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ErfPackage init() {
        if( isInited ) return (ErfPackage)EPackage.Registry.INSTANCE.getEPackage( ErfPackage.eNS_URI );

        // Obtain or create and register package
        ErfPackageImpl theErfPackage = (ErfPackageImpl)(EPackage.Registry.INSTANCE.get( eNS_URI ) instanceof ErfPackageImpl
            ? EPackage.Registry.INSTANCE.get( eNS_URI )
            : new ErfPackageImpl());

        isInited = true;

        // Create package meta-data objects
        theErfPackage.createPackageContents();

        // Initialize created meta-data
        theErfPackage.initializePackageContents();

        // Register package validator
        EValidator.Registry.INSTANCE.put( theErfPackage, new EValidator.Descriptor() {
            public EValidator getEValidator() {
                return ErfValidator.INSTANCE;
            }
        } );

        // Mark meta-data to indicate it can't be changed
        theErfPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put( ErfPackage.eNS_URI, theErfPackage );
        return theErfPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the attribute definition
     * @generated
     */
    public EClass getAttributeDefinition() {
        return attributeDefinitionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the attribute definition_ type
     * @generated
     */
    public EReference getAttributeDefinition_Type() {
        return (EReference)attributeDefinitionEClass.getEStructuralFeatures().get( 0 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the attribute definition_ ident
     * @generated
     */
    public EAttribute getAttributeDefinition_Ident() {
        return (EAttribute)attributeDefinitionEClass.getEStructuralFeatures().get( 1 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the attribute definition_ unique
     * @generated
     */
    public EAttribute getAttributeDefinition_Unique() {
        return (EAttribute)attributeDefinitionEClass.getEStructuralFeatures().get( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the attribute definition_ spec type
     * @generated
     */
    public EReference getAttributeDefinition_SpecType() {
        return (EReference)attributeDefinitionEClass.getEStructuralFeatures().get( 3 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the attribute value
     * @generated
     */
    public EClass getAttributeValue() {
        return attributeValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the attribute value_ definition
     * @generated
     */
    public EReference getAttributeValue_Definition() {
        return (EReference)attributeValueEClass.getEStructuralFeatures().get( 0 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the datatype definition
     * @generated
     */
    public EClass getDatatypeDefinition() {
        return datatypeDefinitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the datatype definition_ attribute definitions
     * @generated
     */
    public EReference getDatatypeDefinition_AttributeDefinitions() {
        return (EReference)datatypeDefinitionEClass.getEStructuralFeatures().get( 0 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the spec element with user defined attributes
     * @generated
     */
    public EClass getSpecElementWithUserDefinedAttributes() {
        return specElementWithUserDefinedAttributesEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the spec element with user defined attributes_ values
     * @generated
     */
    public EReference getSpecElementWithUserDefinedAttributes_Values() {
        return (EReference)specElementWithUserDefinedAttributesEClass.getEStructuralFeatures().get( 0 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the spec element with user defined attributes_ type
     * @generated
     */
    public EReference getSpecElementWithUserDefinedAttributes_Type() {
        return (EReference)specElementWithUserDefinedAttributesEClass.getEStructuralFeatures().get( 1 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the spec object
     * @generated
     */
    public EClass getSpecObject() {
        return specObjectEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the spec object_ sources
     * @generated
     */
    public EReference getSpecObject_Sources() {
        return (EReference)specObjectEClass.getEStructuralFeatures().get( 0 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the spec object_ targets
     * @generated
     */
    public EReference getSpecObject_Targets() {
        return (EReference)specObjectEClass.getEStructuralFeatures().get( 1 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the spec type
     * @generated
     */
    public EClass getSpecType() {
        return specTypeEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the spec type_ spec attributes
     * @generated
     */
    public EReference getSpecType_SpecAttributes() {
        return (EReference)specTypeEClass.getEStructuralFeatures().get( 0 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the map
     * @generated
     */
    public EClass getMap() {
        return mapEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the attribute value simple
     * @generated
     */
    public EClass getAttributeValueSimple() {
        return attributeValueSimpleEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the attribute value simple_ the value
     * @generated
     */
    public EAttribute getAttributeValueSimple_TheValue() {
        return (EAttribute)attributeValueSimpleEClass.getEStructuralFeatures().get( 0 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the datatype definition integer
     * @generated
     */
    public EClass getDatatypeDefinitionInteger() {
        return datatypeDefinitionIntegerEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the datatype definition integer_ max
     * @generated
     */
    public EAttribute getDatatypeDefinitionInteger_Max() {
        return (EAttribute)datatypeDefinitionIntegerEClass.getEStructuralFeatures().get( 0 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the datatype definition integer_ min
     * @generated
     */
    public EAttribute getDatatypeDefinitionInteger_Min() {
        return (EAttribute)datatypeDefinitionIntegerEClass.getEStructuralFeatures().get( 1 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the datatype definition simple
     * @generated
     */
    public EClass getDatatypeDefinitionSimple() {
        return datatypeDefinitionSimpleEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the datatype definition string
     * @generated
     */
    public EClass getDatatypeDefinitionString() {
        return datatypeDefinitionStringEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the datatype definition string_ max length
     * @generated
     */
    public EAttribute getDatatypeDefinitionString_MaxLength() {
        return (EAttribute)datatypeDefinitionStringEClass.getEStructuralFeatures().get( 0 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the identifiable
     * @generated
     */
    public EClass getIdentifiable() {
        return identifiableEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the identifiable_ id
     * @generated
     */
    public EAttribute getIdentifiable_ID() {
        return (EAttribute)identifiableEClass.getEStructuralFeatures().get( 0 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the identifiable_ desc
     * @generated
     */
    public EAttribute getIdentifiable_Desc() {
        return (EAttribute)identifiableEClass.getEStructuralFeatures().get( 1 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the identifiable_ long name
     * @generated
     */
    public EAttribute getIdentifiable_LongName() {
        return (EAttribute)identifiableEClass.getEStructuralFeatures().get( 2 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the attribute definition simple
     * @generated
     */
    public EClass getAttributeDefinitionSimple() {
        return attributeDefinitionSimpleEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the attribute definition simple_ default value
     * @generated
     */
    public EReference getAttributeDefinitionSimple_DefaultValue() {
        return (EReference)attributeDefinitionSimpleEClass.getEStructuralFeatures().get( 0 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the erf
     * @generated
     */
    public EClass getERF() {
        return erfEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the eR f_ core content
     * @generated
     */
    public EReference getERF_CoreContent() {
        return (EReference)erfEClass.getEStructuralFeatures().get( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the eR f_ tool extensions
     * @generated
     */
    public EReference getERF_ToolExtensions() {
        return (EReference)erfEClass.getEStructuralFeatures().get( 1 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the content
     * @generated
     */
    public EClass getContent() {
        return contentEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the content_ spec objects
     * @generated
     */
    public EReference getContent_SpecObjects() {
        return (EReference)contentEClass.getEStructuralFeatures().get( 0 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the content_ spec types
     * @generated
     */
    public EReference getContent_SpecTypes() {
        return (EReference)contentEClass.getEStructuralFeatures().get( 1 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the content_ data types
     * @generated
     */
    public EReference getContent_DataTypes() {
        return (EReference)contentEClass.getEStructuralFeatures().get( 2 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the content_ spec relations
     * @generated
     */
    public EReference getContent_SpecRelations() {
        return (EReference)contentEClass.getEStructuralFeatures().get( 3 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the spec relation
     * @generated
     */
    public EClass getSpecRelation() {
        return specRelationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the spec relation_ source
     * @generated
     */
    public EReference getSpecRelation_Source() {
        return (EReference)specRelationEClass.getEStructuralFeatures().get( 0 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the spec relation_ target
     * @generated
     */
    public EReference getSpecRelation_Target() {
        return (EReference)specRelationEClass.getEStructuralFeatures().get( 1 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the embedded value
     * @generated
     */
    public EClass getEmbeddedValue() {
        return embeddedValueEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the embedded value_ key
     * @generated
     */
    public EAttribute getEmbeddedValue_Key() {
        return (EAttribute)embeddedValueEClass.getEStructuralFeatures().get( 0 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the embedded value_ other content
     * @generated
     */
    public EAttribute getEmbeddedValue_OtherContent() {
        return (EAttribute)embeddedValueEClass.getEStructuralFeatures().get( 1 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the enum value
     * @generated
     */
    public EClass getEnumValue() {
        return enumValueEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the enum value_ properties
     * @generated
     */
    public EReference getEnumValue_Properties() {
        return (EReference)enumValueEClass.getEStructuralFeatures().get( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the enum value_ color
     * @generated
     */
    public EReference getEnumValue_Color() {
        return (EReference)enumValueEClass.getEStructuralFeatures().get( 1 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the datatype definition enumeration
     * @generated
     */
    public EClass getDatatypeDefinitionEnumeration() {
        return datatypeDefinitionEnumerationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the datatype definition enumeration_ specified values
     * @generated
     */
    public EReference getDatatypeDefinitionEnumeration_SpecifiedValues() {
        return (EReference)datatypeDefinitionEnumerationEClass.getEStructuralFeatures().get( 0 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the attribute definition enumeration
     * @generated
     */
    public EClass getAttributeDefinitionEnumeration() {
        return attributeDefinitionEnumerationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the attribute definition enumeration_ multi valued
     * @generated
     */
    public EAttribute getAttributeDefinitionEnumeration_MultiValued() {
        return (EAttribute)attributeDefinitionEnumerationEClass.getEStructuralFeatures().get( 0 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the attribute definition enumeration_ default value
     * @generated
     */
    public EReference getAttributeDefinitionEnumeration_DefaultValue() {
        return (EReference)attributeDefinitionEnumerationEClass.getEStructuralFeatures().get( 1 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the attribute value enumeration
     * @generated
     */
    public EClass getAttributeValueEnumeration() {
        return attributeValueEnumerationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the attribute value enumeration_ values
     * @generated
     */
    public EReference getAttributeValueEnumeration_Values() {
        return (EReference)attributeValueEnumerationEClass.getEStructuralFeatures().get( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the datatype definition boolean
     * @generated
     */
    public EClass getDatatypeDefinitionBoolean() {
        return datatypeDefinitionBooleanEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the attribute definition boolean
     * @generated
     */
    public EClass getAttributeDefinitionBoolean() {
        return attributeDefinitionBooleanEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the attribute definition boolean_ default value
     * @generated
     */
    public EReference getAttributeDefinitionBoolean_DefaultValue() {
        return (EReference)attributeDefinitionBooleanEClass.getEStructuralFeatures().get( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the attribute value boolean
     * @generated
     */
    public EClass getAttributeValueBoolean() {
        return attributeValueBooleanEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the attribute value boolean_ the value
     * @generated
     */
    public EAttribute getAttributeValueBoolean_TheValue() {
        return (EAttribute)attributeValueBooleanEClass.getEStructuralFeatures().get( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the tool extension
     * @generated
     */
    public EClass getToolExtension() {
        return toolExtensionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the view
     * @generated
     */
    public EClass getView() {
        return viewEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the view_ view elements
     * @generated
     */
    public EReference getView_ViewElements() {
        return (EReference)viewEClass.getEStructuralFeatures().get( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the view element
     * @generated
     */
    public EClass getViewElement() {
        return viewElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the view element_ editor show label
     * @generated
     */
    public EAttribute getViewElement_EditorShowLabel() {
        return (EAttribute)viewElementEClass.getEStructuralFeatures().get( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the view element_ editor column span
     * @generated
     */
    public EAttribute getViewElement_EditorColumnSpan() {
        return (EAttribute)viewElementEClass.getEStructuralFeatures().get( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the view element_ attribute definition
     * @generated
     */
    public EReference getViewElement_AttributeDefinition() {
        return (EReference)viewElementEClass.getEStructuralFeatures().get( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the view element_ editor row position
     * @generated
     */
    public EAttribute getViewElement_EditorRowPosition() {
        return (EAttribute)viewElementEClass.getEStructuralFeatures().get( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the view element_ editor row span
     * @generated
     */
    public EAttribute getViewElement_EditorRowSpan() {
        return (EAttribute)viewElementEClass.getEStructuralFeatures().get( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the view element_ editor column position
     * @generated
     */
    public EAttribute getViewElement_EditorColumnPosition() {
        return (EAttribute)viewElementEClass.getEStructuralFeatures().get( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the era tool extension
     * @generated
     */
    public EClass getEraToolExtension() {
        return eraToolExtensionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the era tool extension_ views
     * @generated
     */
    public EReference getEraToolExtension_Views() {
        return (EReference)eraToolExtensionEClass.getEStructuralFeatures().get( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the color
     * @generated
     */
    public EClass getColor() {
        return colorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the color_ red
     * @generated
     */
    public EAttribute getColor_Red() {
        return (EAttribute)colorEClass.getEStructuralFeatures().get( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the color_ green
     * @generated
     */
    public EAttribute getColor_Green() {
        return (EAttribute)colorEClass.getEStructuralFeatures().get( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the color_ blue
     * @generated
     */
    public EAttribute getColor_Blue() {
        return (EAttribute)colorEClass.getEStructuralFeatures().get( 2 );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the diagnostic chain
     * @generated
     */
    public EDataType getDiagnosticChain() {
        return diagnosticChainEDataType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the erf factory
     * @generated
     */
    public ErfFactory getErfFactory() {
        return (ErfFactory)getEFactoryInstance();
    }

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if( isCreated ) return;
        isCreated = true;

        // Create classes and their features
        attributeDefinitionEClass = createEClass( ATTRIBUTE_DEFINITION );
        createEReference( attributeDefinitionEClass, ATTRIBUTE_DEFINITION__TYPE );
        createEAttribute( attributeDefinitionEClass, ATTRIBUTE_DEFINITION__IDENT );
        createEAttribute( attributeDefinitionEClass, ATTRIBUTE_DEFINITION__UNIQUE );
        createEReference( attributeDefinitionEClass, ATTRIBUTE_DEFINITION__SPEC_TYPE );

        attributeValueEClass = createEClass( ATTRIBUTE_VALUE );
        createEReference( attributeValueEClass, ATTRIBUTE_VALUE__DEFINITION );

        datatypeDefinitionEClass = createEClass( DATATYPE_DEFINITION );
        createEReference( datatypeDefinitionEClass, DATATYPE_DEFINITION__ATTRIBUTE_DEFINITIONS );

        specElementWithUserDefinedAttributesEClass = createEClass( SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES );
        createEReference( specElementWithUserDefinedAttributesEClass,
                          SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__VALUES );
        createEReference( specElementWithUserDefinedAttributesEClass, SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__TYPE );

        specObjectEClass = createEClass( SPEC_OBJECT );
        createEReference( specObjectEClass, SPEC_OBJECT__SOURCES );
        createEReference( specObjectEClass, SPEC_OBJECT__TARGETS );

        specTypeEClass = createEClass( SPEC_TYPE );
        createEReference( specTypeEClass, SPEC_TYPE__SPEC_ATTRIBUTES );

        mapEClass = createEClass( MAP );

        attributeValueSimpleEClass = createEClass( ATTRIBUTE_VALUE_SIMPLE );
        createEAttribute( attributeValueSimpleEClass, ATTRIBUTE_VALUE_SIMPLE__THE_VALUE );

        datatypeDefinitionIntegerEClass = createEClass( DATATYPE_DEFINITION_INTEGER );
        createEAttribute( datatypeDefinitionIntegerEClass, DATATYPE_DEFINITION_INTEGER__MAX );
        createEAttribute( datatypeDefinitionIntegerEClass, DATATYPE_DEFINITION_INTEGER__MIN );

        datatypeDefinitionSimpleEClass = createEClass( DATATYPE_DEFINITION_SIMPLE );

        datatypeDefinitionStringEClass = createEClass( DATATYPE_DEFINITION_STRING );
        createEAttribute( datatypeDefinitionStringEClass, DATATYPE_DEFINITION_STRING__MAX_LENGTH );

        identifiableEClass = createEClass( IDENTIFIABLE );
        createEAttribute( identifiableEClass, IDENTIFIABLE__ID );
        createEAttribute( identifiableEClass, IDENTIFIABLE__DESC );
        createEAttribute( identifiableEClass, IDENTIFIABLE__LONG_NAME );

        attributeDefinitionSimpleEClass = createEClass( ATTRIBUTE_DEFINITION_SIMPLE );
        createEReference( attributeDefinitionSimpleEClass, ATTRIBUTE_DEFINITION_SIMPLE__DEFAULT_VALUE );

        erfEClass = createEClass( ERF );
        createEReference( erfEClass, ERF__CORE_CONTENT );
        createEReference( erfEClass, ERF__TOOL_EXTENSIONS );

        contentEClass = createEClass( CONTENT );
        createEReference( contentEClass, CONTENT__SPEC_OBJECTS );
        createEReference( contentEClass, CONTENT__SPEC_TYPES );
        createEReference( contentEClass, CONTENT__DATA_TYPES );
        createEReference( contentEClass, CONTENT__SPEC_RELATIONS );

        specRelationEClass = createEClass( SPEC_RELATION );
        createEReference( specRelationEClass, SPEC_RELATION__SOURCE );
        createEReference( specRelationEClass, SPEC_RELATION__TARGET );

        embeddedValueEClass = createEClass( EMBEDDED_VALUE );
        createEAttribute( embeddedValueEClass, EMBEDDED_VALUE__KEY );
        createEAttribute( embeddedValueEClass, EMBEDDED_VALUE__OTHER_CONTENT );

        enumValueEClass = createEClass( ENUM_VALUE );
        createEReference( enumValueEClass, ENUM_VALUE__PROPERTIES );
        createEReference( enumValueEClass, ENUM_VALUE__COLOR );

        datatypeDefinitionEnumerationEClass = createEClass( DATATYPE_DEFINITION_ENUMERATION );
        createEReference( datatypeDefinitionEnumerationEClass, DATATYPE_DEFINITION_ENUMERATION__SPECIFIED_VALUES );

        attributeDefinitionEnumerationEClass = createEClass( ATTRIBUTE_DEFINITION_ENUMERATION );
        createEAttribute( attributeDefinitionEnumerationEClass, ATTRIBUTE_DEFINITION_ENUMERATION__MULTI_VALUED );
        createEReference( attributeDefinitionEnumerationEClass, ATTRIBUTE_DEFINITION_ENUMERATION__DEFAULT_VALUE );

        attributeValueEnumerationEClass = createEClass( ATTRIBUTE_VALUE_ENUMERATION );
        createEReference( attributeValueEnumerationEClass, ATTRIBUTE_VALUE_ENUMERATION__VALUES );

        datatypeDefinitionBooleanEClass = createEClass( DATATYPE_DEFINITION_BOOLEAN );

        attributeDefinitionBooleanEClass = createEClass( ATTRIBUTE_DEFINITION_BOOLEAN );
        createEReference( attributeDefinitionBooleanEClass, ATTRIBUTE_DEFINITION_BOOLEAN__DEFAULT_VALUE );

        attributeValueBooleanEClass = createEClass( ATTRIBUTE_VALUE_BOOLEAN );
        createEAttribute( attributeValueBooleanEClass, ATTRIBUTE_VALUE_BOOLEAN__THE_VALUE );

        toolExtensionEClass = createEClass( TOOL_EXTENSION );

        viewEClass = createEClass( VIEW );
        createEReference( viewEClass, VIEW__VIEW_ELEMENTS );

        viewElementEClass = createEClass( VIEW_ELEMENT );
        createEAttribute( viewElementEClass, VIEW_ELEMENT__EDITOR_SHOW_LABEL );
        createEAttribute( viewElementEClass, VIEW_ELEMENT__EDITOR_COLUMN_SPAN );
        createEReference( viewElementEClass, VIEW_ELEMENT__ATTRIBUTE_DEFINITION );
        createEAttribute( viewElementEClass, VIEW_ELEMENT__EDITOR_ROW_POSITION );
        createEAttribute( viewElementEClass, VIEW_ELEMENT__EDITOR_ROW_SPAN );
        createEAttribute( viewElementEClass, VIEW_ELEMENT__EDITOR_COLUMN_POSITION );

        eraToolExtensionEClass = createEClass( ERA_TOOL_EXTENSION );
        createEReference( eraToolExtensionEClass, ERA_TOOL_EXTENSION__VIEWS );

        colorEClass = createEClass( COLOR );
        createEAttribute( colorEClass, COLOR__RED );
        createEAttribute( colorEClass, COLOR__GREEN );
        createEAttribute( colorEClass, COLOR__BLUE );

        // Create data types
        diagnosticChainEDataType = createEDataType( DIAGNOSTIC_CHAIN );
    }

    /** <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if( isInitialized ) return;
        isInitialized = true;

        // Initialize package
        setName( eNAME );
        setNsPrefix( eNS_PREFIX );
        setNsURI( eNS_URI );

        // Create type parameters
        addETypeParameter( mapEClass, "T" );
        addETypeParameter( mapEClass, "T1" );

        // Set bounds for type parameters

        // Add supertypes to classes
        attributeDefinitionEClass.getESuperTypes().add( this.getIdentifiable() );
        attributeValueEClass.getESuperTypes().add( this.getIdentifiable() );
        datatypeDefinitionEClass.getESuperTypes().add( this.getIdentifiable() );
        specElementWithUserDefinedAttributesEClass.getESuperTypes().add( this.getIdentifiable() );
        specObjectEClass.getESuperTypes().add( this.getSpecElementWithUserDefinedAttributes() );
        specTypeEClass.getESuperTypes().add( this.getIdentifiable() );
        attributeValueSimpleEClass.getESuperTypes().add( this.getAttributeValue() );
        datatypeDefinitionIntegerEClass.getESuperTypes().add( this.getDatatypeDefinitionSimple() );
        datatypeDefinitionSimpleEClass.getESuperTypes().add( this.getDatatypeDefinition() );
        datatypeDefinitionStringEClass.getESuperTypes().add( this.getDatatypeDefinitionSimple() );
        attributeDefinitionSimpleEClass.getESuperTypes().add( this.getAttributeDefinition() );
        specRelationEClass.getESuperTypes().add( this.getSpecElementWithUserDefinedAttributes() );
        enumValueEClass.getESuperTypes().add( this.getIdentifiable() );
        datatypeDefinitionEnumerationEClass.getESuperTypes().add( this.getDatatypeDefinition() );
        attributeDefinitionEnumerationEClass.getESuperTypes().add( this.getAttributeDefinition() );
        attributeValueEnumerationEClass.getESuperTypes().add( this.getAttributeValue() );
        datatypeDefinitionBooleanEClass.getESuperTypes().add( this.getDatatypeDefinition() );
        attributeDefinitionBooleanEClass.getESuperTypes().add( this.getAttributeDefinition() );
        attributeValueBooleanEClass.getESuperTypes().add( this.getAttributeValue() );
        viewEClass.getESuperTypes().add( this.getIdentifiable() );
        eraToolExtensionEClass.getESuperTypes().add( this.getToolExtension() );

        // Initialize classes and features; add operations and parameters
        initEClass( attributeDefinitionEClass,
                    AttributeDefinition.class,
                    "AttributeDefinition",
                    IS_ABSTRACT,
                    !IS_INTERFACE,
                    IS_GENERATED_INSTANCE_CLASS );
        initEReference( getAttributeDefinition_Type(),
                        this.getDatatypeDefinition(),
                        this.getDatatypeDefinition_AttributeDefinitions(),
                        "type",
                        null,
                        1,
                        1,
                        AttributeDefinition.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_COMPOSITE,
                        IS_RESOLVE_PROXIES,
                        !IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );
        initEAttribute( getAttributeDefinition_Ident(),
                        ecorePackage.getEBoolean(),
                        "ident",
                        "false",
                        1,
                        1,
                        AttributeDefinition.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_UNSETTABLE,
                        !IS_ID,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        !IS_ORDERED );
        initEAttribute( getAttributeDefinition_Unique(),
                        ecorePackage.getEBoolean(),
                        "unique",
                        "false",
                        1,
                        1,
                        AttributeDefinition.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_UNSETTABLE,
                        !IS_ID,
                        !IS_UNIQUE,
                        !IS_DERIVED,
                        !IS_ORDERED );
        initEReference( getAttributeDefinition_SpecType(),
                        this.getSpecType(),
                        this.getSpecType_SpecAttributes(),
                        "specType",
                        null,
                        1,
                        1,
                        AttributeDefinition.class,
                        IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_COMPOSITE,
                        !IS_RESOLVE_PROXIES,
                        !IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );

        initEClass( attributeValueEClass,
                    AttributeValue.class,
                    "AttributeValue",
                    IS_ABSTRACT,
                    !IS_INTERFACE,
                    IS_GENERATED_INSTANCE_CLASS );
        initEReference( getAttributeValue_Definition(),
                        this.getAttributeDefinition(),
                        null,
                        "definition",
                        null,
                        1,
                        1,
                        AttributeValue.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_COMPOSITE,
                        IS_RESOLVE_PROXIES,
                        !IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );

        initEClass( datatypeDefinitionEClass,
                    DatatypeDefinition.class,
                    "DatatypeDefinition",
                    IS_ABSTRACT,
                    !IS_INTERFACE,
                    IS_GENERATED_INSTANCE_CLASS );
        initEReference( getDatatypeDefinition_AttributeDefinitions(),
                        this.getAttributeDefinition(),
                        this.getAttributeDefinition_Type(),
                        "attributeDefinitions",
                        null,
                        0,
                        -1,
                        DatatypeDefinition.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_COMPOSITE,
                        IS_RESOLVE_PROXIES,
                        !IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );

        initEClass( specElementWithUserDefinedAttributesEClass,
                    SpecElementWithUserDefinedAttributes.class,
                    "SpecElementWithUserDefinedAttributes",
                    IS_ABSTRACT,
                    !IS_INTERFACE,
                    IS_GENERATED_INSTANCE_CLASS );
        initEReference( getSpecElementWithUserDefinedAttributes_Values(),
                        this.getAttributeValue(),
                        null,
                        "values",
                        null,
                        0,
                        -1,
                        SpecElementWithUserDefinedAttributes.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        IS_COMPOSITE,
                        !IS_RESOLVE_PROXIES,
                        !IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );
        initEReference( getSpecElementWithUserDefinedAttributes_Type(),
                        this.getSpecType(),
                        null,
                        "type",
                        null,
                        0,
                        1,
                        SpecElementWithUserDefinedAttributes.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_COMPOSITE,
                        IS_RESOLVE_PROXIES,
                        !IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );

        initEClass( specObjectEClass,
                    SpecObject.class,
                    "SpecObject",
                    !IS_ABSTRACT,
                    !IS_INTERFACE,
                    IS_GENERATED_INSTANCE_CLASS );
        initEReference( getSpecObject_Sources(),
                        this.getSpecRelation(),
                        this.getSpecRelation_Target(),
                        "sources",
                        null,
                        0,
                        -1,
                        SpecObject.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_COMPOSITE,
                        IS_RESOLVE_PROXIES,
                        !IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );
        initEReference( getSpecObject_Targets(),
                        this.getSpecRelation(),
                        this.getSpecRelation_Source(),
                        "targets",
                        null,
                        0,
                        -1,
                        SpecObject.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_COMPOSITE,
                        IS_RESOLVE_PROXIES,
                        !IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );

        initEClass( specTypeEClass,
                    SpecType.class,
                    "SpecType",
                    !IS_ABSTRACT,
                    !IS_INTERFACE,
                    IS_GENERATED_INSTANCE_CLASS );
        initEReference( getSpecType_SpecAttributes(),
                        this.getAttributeDefinition(),
                        this.getAttributeDefinition_SpecType(),
                        "specAttributes",
                        null,
                        0,
                        -1,
                        SpecType.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        IS_COMPOSITE,
                        !IS_RESOLVE_PROXIES,
                        !IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );

        initEClass( mapEClass, Map.class, "Map", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS );

        initEClass( attributeValueSimpleEClass,
                    AttributeValueSimple.class,
                    "AttributeValueSimple",
                    !IS_ABSTRACT,
                    !IS_INTERFACE,
                    IS_GENERATED_INSTANCE_CLASS );
        initEAttribute( getAttributeValueSimple_TheValue(),
                        ecorePackage.getEString(),
                        "theValue",
                        "",
                        1,
                        1,
                        AttributeValueSimple.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_UNSETTABLE,
                        !IS_ID,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );

        initEClass( datatypeDefinitionIntegerEClass,
                    DatatypeDefinitionInteger.class,
                    "DatatypeDefinitionInteger",
                    !IS_ABSTRACT,
                    !IS_INTERFACE,
                    IS_GENERATED_INSTANCE_CLASS );
        initEAttribute( getDatatypeDefinitionInteger_Max(),
                        ecorePackage.getEIntegerObject(),
                        "max",
                        null,
                        0,
                        1,
                        DatatypeDefinitionInteger.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        IS_UNSETTABLE,
                        !IS_ID,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        !IS_ORDERED );
        initEAttribute( getDatatypeDefinitionInteger_Min(),
                        ecorePackage.getEIntegerObject(),
                        "min",
                        null,
                        0,
                        1,
                        DatatypeDefinitionInteger.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        IS_UNSETTABLE,
                        !IS_ID,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        !IS_ORDERED );

        initEClass( datatypeDefinitionSimpleEClass,
                    DatatypeDefinitionSimple.class,
                    "DatatypeDefinitionSimple",
                    IS_ABSTRACT,
                    !IS_INTERFACE,
                    IS_GENERATED_INSTANCE_CLASS );

        initEClass( datatypeDefinitionStringEClass,
                    DatatypeDefinitionString.class,
                    "DatatypeDefinitionString",
                    !IS_ABSTRACT,
                    !IS_INTERFACE,
                    IS_GENERATED_INSTANCE_CLASS );
        initEAttribute( getDatatypeDefinitionString_MaxLength(),
                        ecorePackage.getEIntegerObject(),
                        "maxLength",
                        null,
                        0,
                        1,
                        DatatypeDefinitionString.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        IS_UNSETTABLE,
                        !IS_ID,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        !IS_ORDERED );

        initEClass( identifiableEClass,
                    Identifiable.class,
                    "Identifiable",
                    IS_ABSTRACT,
                    !IS_INTERFACE,
                    IS_GENERATED_INSTANCE_CLASS );
        initEAttribute( getIdentifiable_ID(),
                        ecorePackage.getEString(),
                        "iD",
                        null,
                        1,
                        1,
                        Identifiable.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        IS_UNSETTABLE,
                        !IS_ID,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );
        initEAttribute( getIdentifiable_Desc(),
                        ecorePackage.getEString(),
                        "desc",
                        "",
                        0,
                        1,
                        Identifiable.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_UNSETTABLE,
                        !IS_ID,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );
        initEAttribute( getIdentifiable_LongName(),
                        ecorePackage.getEString(),
                        "longName",
                        "",
                        0,
                        1,
                        Identifiable.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_UNSETTABLE,
                        !IS_ID,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );

        initEClass( attributeDefinitionSimpleEClass,
                    AttributeDefinitionSimple.class,
                    "AttributeDefinitionSimple",
                    !IS_ABSTRACT,
                    !IS_INTERFACE,
                    IS_GENERATED_INSTANCE_CLASS );
        initEReference( getAttributeDefinitionSimple_DefaultValue(),
                        this.getAttributeValueSimple(),
                        null,
                        "defaultValue",
                        null,
                        0,
                        1,
                        AttributeDefinitionSimple.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        IS_COMPOSITE,
                        !IS_RESOLVE_PROXIES,
                        IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        !IS_ORDERED );

        initEClass( erfEClass,
                    era.foss.erf.ERF.class,
                    "ERF",
                    !IS_ABSTRACT,
                    !IS_INTERFACE,
                    IS_GENERATED_INSTANCE_CLASS );
        initEReference( getERF_CoreContent(),
                        this.getContent(),
                        null,
                        "coreContent",
                        null,
                        1,
                        1,
                        era.foss.erf.ERF.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        IS_COMPOSITE,
                        !IS_RESOLVE_PROXIES,
                        !IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );
        initEReference( getERF_ToolExtensions(),
                        this.getToolExtension(),
                        null,
                        "toolExtensions",
                        null,
                        0,
                        -1,
                        era.foss.erf.ERF.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        IS_COMPOSITE,
                        !IS_RESOLVE_PROXIES,
                        !IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );

        initEClass( contentEClass, Content.class, "Content", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEReference( getContent_SpecObjects(),
                        this.getSpecObject(),
                        null,
                        "specObjects",
                        null,
                        0,
                        -1,
                        Content.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        IS_COMPOSITE,
                        !IS_RESOLVE_PROXIES,
                        !IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );
        initEReference( getContent_SpecTypes(),
                        this.getSpecType(),
                        null,
                        "specTypes",
                        null,
                        0,
                        -1,
                        Content.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        IS_COMPOSITE,
                        !IS_RESOLVE_PROXIES,
                        !IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );
        initEReference( getContent_DataTypes(),
                        this.getDatatypeDefinition(),
                        null,
                        "dataTypes",
                        null,
                        0,
                        -1,
                        Content.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        IS_COMPOSITE,
                        !IS_RESOLVE_PROXIES,
                        !IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );
        initEReference( getContent_SpecRelations(),
                        this.getSpecRelation(),
                        null,
                        "specRelations",
                        null,
                        0,
                        -1,
                        Content.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        IS_COMPOSITE,
                        !IS_RESOLVE_PROXIES,
                        !IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );

        initEClass( specRelationEClass,
                    SpecRelation.class,
                    "SpecRelation",
                    !IS_ABSTRACT,
                    !IS_INTERFACE,
                    IS_GENERATED_INSTANCE_CLASS );
        initEReference( getSpecRelation_Source(),
                        this.getSpecObject(),
                        this.getSpecObject_Targets(),
                        "source",
                        null,
                        1,
                        1,
                        SpecRelation.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_COMPOSITE,
                        IS_RESOLVE_PROXIES,
                        !IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );
        initEReference( getSpecRelation_Target(),
                        this.getSpecObject(),
                        this.getSpecObject_Sources(),
                        "target",
                        null,
                        1,
                        1,
                        SpecRelation.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_COMPOSITE,
                        IS_RESOLVE_PROXIES,
                        !IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );

        initEClass( embeddedValueEClass,
                    EmbeddedValue.class,
                    "EmbeddedValue",
                    !IS_ABSTRACT,
                    !IS_INTERFACE,
                    IS_GENERATED_INSTANCE_CLASS );
        initEAttribute( getEmbeddedValue_Key(),
                        ecorePackage.getEInt(),
                        "key",
                        "0",
                        1,
                        1,
                        EmbeddedValue.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_UNSETTABLE,
                        !IS_ID,
                        !IS_UNIQUE,
                        !IS_DERIVED,
                        !IS_ORDERED );
        initEAttribute( getEmbeddedValue_OtherContent(),
                        ecorePackage.getEString(),
                        "otherContent",
                        "",
                        1,
                        1,
                        EmbeddedValue.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_UNSETTABLE,
                        !IS_ID,
                        !IS_UNIQUE,
                        !IS_DERIVED,
                        !IS_ORDERED );

        initEClass( enumValueEClass,
                    EnumValue.class,
                    "EnumValue",
                    !IS_ABSTRACT,
                    !IS_INTERFACE,
                    IS_GENERATED_INSTANCE_CLASS );
        initEReference( getEnumValue_Properties(),
                        this.getEmbeddedValue(),
                        null,
                        "properties",
                        null,
                        1,
                        1,
                        EnumValue.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        IS_COMPOSITE,
                        !IS_RESOLVE_PROXIES,
                        !IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );
        initEReference( getEnumValue_Color(),
                        this.getColor(),
                        null,
                        "color",
                        null,
                        1,
                        1,
                        EnumValue.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        IS_COMPOSITE,
                        !IS_RESOLVE_PROXIES,
                        !IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );

        initEClass( datatypeDefinitionEnumerationEClass,
                    DatatypeDefinitionEnumeration.class,
                    "DatatypeDefinitionEnumeration",
                    !IS_ABSTRACT,
                    !IS_INTERFACE,
                    IS_GENERATED_INSTANCE_CLASS );
        initEReference( getDatatypeDefinitionEnumeration_SpecifiedValues(),
                        this.getEnumValue(),
                        null,
                        "specifiedValues",
                        null,
                        0,
                        -1,
                        DatatypeDefinitionEnumeration.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        IS_COMPOSITE,
                        !IS_RESOLVE_PROXIES,
                        !IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );

        initEClass( attributeDefinitionEnumerationEClass,
                    AttributeDefinitionEnumeration.class,
                    "AttributeDefinitionEnumeration",
                    !IS_ABSTRACT,
                    !IS_INTERFACE,
                    IS_GENERATED_INSTANCE_CLASS );
        initEAttribute( getAttributeDefinitionEnumeration_MultiValued(),
                        ecorePackage.getEBoolean(),
                        "multiValued",
                        "false",
                        0,
                        1,
                        AttributeDefinitionEnumeration.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_UNSETTABLE,
                        !IS_ID,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );
        initEReference( getAttributeDefinitionEnumeration_DefaultValue(),
                        this.getAttributeValueEnumeration(),
                        null,
                        "defaultValue",
                        null,
                        0,
                        1,
                        AttributeDefinitionEnumeration.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        IS_COMPOSITE,
                        !IS_RESOLVE_PROXIES,
                        IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        !IS_ORDERED );

        initEClass( attributeValueEnumerationEClass,
                    AttributeValueEnumeration.class,
                    "AttributeValueEnumeration",
                    !IS_ABSTRACT,
                    !IS_INTERFACE,
                    IS_GENERATED_INSTANCE_CLASS );
        initEReference( getAttributeValueEnumeration_Values(),
                        this.getEnumValue(),
                        null,
                        "values",
                        null,
                        1,
                        -1,
                        AttributeValueEnumeration.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_COMPOSITE,
                        IS_RESOLVE_PROXIES,
                        !IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );

        initEClass( datatypeDefinitionBooleanEClass,
                    DatatypeDefinitionBoolean.class,
                    "DatatypeDefinitionBoolean",
                    !IS_ABSTRACT,
                    !IS_INTERFACE,
                    IS_GENERATED_INSTANCE_CLASS );

        initEClass( attributeDefinitionBooleanEClass,
                    AttributeDefinitionBoolean.class,
                    "AttributeDefinitionBoolean",
                    !IS_ABSTRACT,
                    !IS_INTERFACE,
                    IS_GENERATED_INSTANCE_CLASS );
        initEReference( getAttributeDefinitionBoolean_DefaultValue(),
                        this.getAttributeValueBoolean(),
                        null,
                        "defaultValue",
                        null,
                        0,
                        1,
                        AttributeDefinitionBoolean.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        IS_COMPOSITE,
                        !IS_RESOLVE_PROXIES,
                        IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        !IS_ORDERED );

        initEClass( attributeValueBooleanEClass,
                    AttributeValueBoolean.class,
                    "AttributeValueBoolean",
                    !IS_ABSTRACT,
                    !IS_INTERFACE,
                    IS_GENERATED_INSTANCE_CLASS );
        initEAttribute( getAttributeValueBoolean_TheValue(),
                        ecorePackage.getEBooleanObject(),
                        "theValue",
                        "false",
                        1,
                        1,
                        AttributeValueBoolean.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_UNSETTABLE,
                        !IS_ID,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );

        initEClass( toolExtensionEClass,
                    ToolExtension.class,
                    "ToolExtension",
                    IS_ABSTRACT,
                    !IS_INTERFACE,
                    IS_GENERATED_INSTANCE_CLASS );

        initEClass( viewEClass, View.class, "View", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEReference( getView_ViewElements(),
                        this.getViewElement(),
                        null,
                        "viewElements",
                        null,
                        0,
                        -1,
                        View.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        IS_COMPOSITE,
                        !IS_RESOLVE_PROXIES,
                        !IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );

        initEClass( viewElementEClass,
                    ViewElement.class,
                    "ViewElement",
                    !IS_ABSTRACT,
                    !IS_INTERFACE,
                    IS_GENERATED_INSTANCE_CLASS );
        initEAttribute( getViewElement_EditorShowLabel(),
                        ecorePackage.getEBoolean(),
                        "editorShowLabel",
                        "true",
                        1,
                        1,
                        ViewElement.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_UNSETTABLE,
                        !IS_ID,
                        !IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );
        initEAttribute( getViewElement_EditorColumnSpan(),
                        ecorePackage.getEInt(),
                        "editorColumnSpan",
                        "1",
                        1,
                        1,
                        ViewElement.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_UNSETTABLE,
                        !IS_ID,
                        !IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );
        initEReference( getViewElement_AttributeDefinition(),
                        this.getAttributeDefinition(),
                        null,
                        "attributeDefinition",
                        null,
                        1,
                        1,
                        ViewElement.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_COMPOSITE,
                        IS_RESOLVE_PROXIES,
                        !IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );
        initEAttribute( getViewElement_EditorRowPosition(),
                        ecorePackage.getEInt(),
                        "editorRowPosition",
                        "1",
                        1,
                        1,
                        ViewElement.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_UNSETTABLE,
                        !IS_ID,
                        !IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );
        initEAttribute( getViewElement_EditorRowSpan(),
                        ecorePackage.getEInt(),
                        "editorRowSpan",
                        "1",
                        1,
                        1,
                        ViewElement.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_UNSETTABLE,
                        !IS_ID,
                        !IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );
        initEAttribute( getViewElement_EditorColumnPosition(),
                        ecorePackage.getEInt(),
                        "editorColumnPosition",
                        "1",
                        1,
                        1,
                        ViewElement.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_UNSETTABLE,
                        !IS_ID,
                        !IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );

        initEClass( eraToolExtensionEClass,
                    EraToolExtension.class,
                    "EraToolExtension",
                    !IS_ABSTRACT,
                    !IS_INTERFACE,
                    IS_GENERATED_INSTANCE_CLASS );
        initEReference( getEraToolExtension_Views(),
                        this.getView(),
                        null,
                        "views",
                        null,
                        0,
                        -1,
                        EraToolExtension.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        IS_COMPOSITE,
                        !IS_RESOLVE_PROXIES,
                        !IS_UNSETTABLE,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );

        initEClass( colorEClass, Color.class, "Color", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEAttribute( getColor_Red(),
                        ecorePackage.getEInt(),
                        "red",
                        null,
                        0,
                        1,
                        Color.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_UNSETTABLE,
                        !IS_ID,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );
        initEAttribute( getColor_Green(),
                        ecorePackage.getEInt(),
                        "green",
                        null,
                        0,
                        1,
                        Color.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_UNSETTABLE,
                        !IS_ID,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );
        initEAttribute( getColor_Blue(),
                        ecorePackage.getEInt(),
                        "blue",
                        null,
                        0,
                        1,
                        Color.class,
                        !IS_TRANSIENT,
                        !IS_VOLATILE,
                        IS_CHANGEABLE,
                        !IS_UNSETTABLE,
                        !IS_ID,
                        IS_UNIQUE,
                        !IS_DERIVED,
                        IS_ORDERED );

        // Initialize data types
        initEDataType( diagnosticChainEDataType,
                       DiagnosticChain.class,
                       "DiagnosticChain",
                       IS_SERIALIZABLE,
                       !IS_GENERATED_INSTANCE_CLASS );

        // Create resource
        createResource( eNS_URI );

        // Create annotations
        // http://www.eclipse.org/emf/2002/Ecore
        createEcoreAnnotations();
    }

    /**
     * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected void createEcoreAnnotations() {
        String source = "http://www.eclipse.org/emf/2002/Ecore";
        addAnnotation( attributeValueSimpleEClass, source, new String[]{
            "constraints",
            "DatatypeDefinitionConstraints"} );
        addAnnotation( datatypeDefinitionIntegerEClass, source, new String[]{
            "constraints",
            "NonNegative MaxGreaterThanMin"} );
    }

} // ErfPackageImpl
