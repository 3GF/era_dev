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
package era.foss.erf.util;

import era.foss.erf.*;
import java.util.ArrayList;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import era.foss.erf.AttributeDefinition;
import era.foss.erf.AttributeDefinitionBoolean;
import era.foss.erf.AttributeDefinitionEnumeration;
import era.foss.erf.AttributeDefinitionSimple;
import era.foss.erf.AttributeValue;
import era.foss.erf.AttributeValueBoolean;
import era.foss.erf.AttributeValueEnumeration;
import era.foss.erf.AttributeValueSimple;
import era.foss.erf.Content;
import era.foss.erf.DatatypeDefinition;
import era.foss.erf.DatatypeDefinitionBoolean;
import era.foss.erf.DatatypeDefinitionEnumeration;
import era.foss.erf.DatatypeDefinitionInteger;
import era.foss.erf.DatatypeDefinitionSimple;
import era.foss.erf.DatatypeDefinitionString;
import era.foss.erf.ERF;
import era.foss.erf.EmbeddedValue;
import era.foss.erf.EnumValue;
import era.foss.erf.EraToolExtension;
import era.foss.erf.ErfPackage;
import era.foss.erf.Identifiable;
import era.foss.erf.SpecElementWithUserDefinedAttributes;
import era.foss.erf.SpecObject;
import era.foss.erf.SpecRelation;
import era.foss.erf.SpecType;
import era.foss.erf.ToolExtension;
import era.foss.erf.View;
import era.foss.erf.ViewElement;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc -->
 * @see era.foss.erf.ErfPackage
 * @generated
 */
public class ErfValidator extends EObjectValidator {

    /** The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->. @generated */
    public static final ErfValidator INSTANCE = new ErfValidator();

    /**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
    public static final String DIAGNOSTIC_SOURCE = "era.foss.erf";

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public ErfValidator() {
        super();
    }

    /**
     * Returns the package of this validator switch.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the e package
     * @generated
     */
    @Override
    protected EPackage getEPackage() {
        return ErfPackage.eINSTANCE;
    }

    /**
     * Calls <code>validateXXX</code> for the corresponding classifier of the model.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    @Override
    protected boolean validate( int classifierID,
                                Object value,
                                DiagnosticChain diagnostics,
                                Map<Object, Object> context ) {
        switch (classifierID) {
        case ErfPackage.ATTRIBUTE_DEFINITION:
            return validateAttributeDefinition( (AttributeDefinition)value, diagnostics, context );
        case ErfPackage.ATTRIBUTE_VALUE:
            return validateAttributeValue( (AttributeValue)value, diagnostics, context );
        case ErfPackage.DATATYPE_DEFINITION:
            return validateDatatypeDefinition( (DatatypeDefinition)value, diagnostics, context );
        case ErfPackage.SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES:
            return validateSpecElementWithUserDefinedAttributes( (SpecElementWithUserDefinedAttributes)value,
                                                                 diagnostics,
                                                                 context );
        case ErfPackage.SPEC_OBJECT:
            return validateSpecObject( (SpecObject)value, diagnostics, context );
        case ErfPackage.SPEC_TYPE:
            return validateSpecType( (SpecType)value, diagnostics, context );
        case ErfPackage.MAP:
            return validateMap( (Map<?, ?>)value, diagnostics, context );
        case ErfPackage.ATTRIBUTE_VALUE_SIMPLE:
            return validateAttributeValueSimple( (AttributeValueSimple)value, diagnostics, context );
        case ErfPackage.DATATYPE_DEFINITION_INTEGER:
            return validateDatatypeDefinitionInteger( (DatatypeDefinitionInteger)value, diagnostics, context );
        case ErfPackage.DATATYPE_DEFINITION_SIMPLE:
            return validateDatatypeDefinitionSimple( (DatatypeDefinitionSimple)value, diagnostics, context );
        case ErfPackage.DATATYPE_DEFINITION_STRING:
            return validateDatatypeDefinitionString( (DatatypeDefinitionString)value, diagnostics, context );
        case ErfPackage.IDENTIFIABLE:
            return validateIdentifiable( (Identifiable)value, diagnostics, context );
        case ErfPackage.ATTRIBUTE_DEFINITION_SIMPLE:
            return validateAttributeDefinitionSimple( (AttributeDefinitionSimple)value, diagnostics, context );
        case ErfPackage.ERF:
            return validateERF( (ERF)value, diagnostics, context );
        case ErfPackage.CONTENT:
            return validateContent( (Content)value, diagnostics, context );
        case ErfPackage.SPEC_RELATION:
            return validateSpecRelation( (SpecRelation)value, diagnostics, context );
        case ErfPackage.EMBEDDED_VALUE:
            return validateEmbeddedValue( (EmbeddedValue)value, diagnostics, context );
        case ErfPackage.ENUM_VALUE:
            return validateEnumValue( (EnumValue)value, diagnostics, context );
        case ErfPackage.DATATYPE_DEFINITION_ENUMERATION:
            return validateDatatypeDefinitionEnumeration( (DatatypeDefinitionEnumeration)value, diagnostics, context );
        case ErfPackage.ATTRIBUTE_DEFINITION_ENUMERATION:
            return validateAttributeDefinitionEnumeration( (AttributeDefinitionEnumeration)value,
                                                           diagnostics,
                                                           context );
        case ErfPackage.ATTRIBUTE_VALUE_ENUMERATION:
            return validateAttributeValueEnumeration( (AttributeValueEnumeration)value, diagnostics, context );
        case ErfPackage.DATATYPE_DEFINITION_BOOLEAN:
            return validateDatatypeDefinitionBoolean( (DatatypeDefinitionBoolean)value, diagnostics, context );
        case ErfPackage.ATTRIBUTE_DEFINITION_BOOLEAN:
            return validateAttributeDefinitionBoolean( (AttributeDefinitionBoolean)value, diagnostics, context );
        case ErfPackage.ATTRIBUTE_VALUE_BOOLEAN:
            return validateAttributeValueBoolean( (AttributeValueBoolean)value, diagnostics, context );
        case ErfPackage.TOOL_EXTENSION:
            return validateToolExtension( (ToolExtension)value, diagnostics, context );
        case ErfPackage.VIEW:
            return validateView( (View)value, diagnostics, context );
        case ErfPackage.VIEW_ELEMENT:
            return validateViewElement( (ViewElement)value, diagnostics, context );
        case ErfPackage.ERA_TOOL_EXTENSION:
            return validateEraToolExtension( (EraToolExtension)value, diagnostics, context );
        case ErfPackage.COLOR:
            return validateColor( (Color)value, diagnostics, context );
        case ErfPackage.DIAGNOSTIC_CHAIN:
            return validateDiagnosticChain( (DiagnosticChain)value, diagnostics, context );
        default:
            return true;
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param attributeDefinition the attribute definition
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateAttributeDefinition( AttributeDefinition attributeDefinition,
                                                DiagnosticChain diagnostics,
                                                Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( attributeDefinition, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param attributeValue the attribute value
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateAttributeValue( AttributeValue attributeValue,
                                           DiagnosticChain diagnostics,
                                           Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( attributeValue, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param datatypeDefinition the datatype definition
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateDatatypeDefinition( DatatypeDefinition datatypeDefinition,
                                               DiagnosticChain diagnostics,
                                               Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( datatypeDefinition, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param specElementWithUserDefinedAttributes the spec element with user defined attributes
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateSpecElementWithUserDefinedAttributes( SpecElementWithUserDefinedAttributes specElementWithUserDefinedAttributes,
                                                                 DiagnosticChain diagnostics,
                                                                 Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( specElementWithUserDefinedAttributes, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param specObject the spec object
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateSpecObject( SpecObject specObject, DiagnosticChain diagnostics, Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( specObject, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param specType the spec type
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateSpecType( SpecType specType, DiagnosticChain diagnostics, Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( specType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param map the map
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateMap( Map<?, ?> map, DiagnosticChain diagnostics, Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( (EObject)map, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param attributeValueSimple the attribute value simple
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateAttributeValueSimple( AttributeValueSimple attributeValueSimple,
                                                 DiagnosticChain diagnostics,
                                                 Map<Object, Object> context ) {
        if( !validate_NoCircularContainment( attributeValueSimple, diagnostics, context ) ) return false;
        boolean result = validate_EveryMultiplicityConforms( attributeValueSimple, diagnostics, context );
        if( result || diagnostics != null ) result &= validate_EveryDataValueConforms( attributeValueSimple,
                                                                                       diagnostics,
                                                                                       context );
        if( result || diagnostics != null ) result &= validate_EveryReferenceIsContained( attributeValueSimple,
                                                                                          diagnostics,
                                                                                          context );
        if( result || diagnostics != null ) result &= validate_EveryBidirectionalReferenceIsPaired( attributeValueSimple,
                                                                                                    diagnostics,
                                                                                                    context );
        if( result || diagnostics != null ) result &= validate_EveryProxyResolves( attributeValueSimple,
                                                                                   diagnostics,
                                                                                   context );
        if( result || diagnostics != null ) result &= validate_UniqueID( attributeValueSimple, diagnostics, context );
        if( result || diagnostics != null ) result &= validate_EveryKeyUnique( attributeValueSimple,
                                                                               diagnostics,
                                                                               context );
        if( result || diagnostics != null ) result &= validate_EveryMapEntryUnique( attributeValueSimple,
                                                                                    diagnostics,
                                                                                    context );
        if( result || diagnostics != null ) result &= validateAttributeValueSimple_DatatypeDefinitionConstraints( attributeValueSimple,
                                                                                                                  diagnostics,
                                                                                                                  context );
        return result;
    }

    /**
     * Validates the DatatypeDefinitionConstraints constraint of '<em>Attribute Value Simple</em>'. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @param attributeValueSimple the attribute value simple
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @NOT generated
     */
    public boolean validateAttributeValueSimple_DatatypeDefinitionConstraints( AttributeValueSimple attributeValueSimple,
                                                                               DiagnosticChain diagnostics,
                                                                               Map<Object, Object> context ) {
        /* String holding the error message key in case an error is detected */
        String errorMsgKey = null;
        if( attributeValueSimple == null ) {
            return true;
        }

        DatatypeDefinition datatypeDefinition = attributeValueSimple.getDefinition().getType();
        ArrayList<Object> substitutions = new ArrayList<Object>();
        substitutions.add( attributeValueSimple.getTheValue() );

        /* Check constraints if value is of DatatypedefinitionInteger */
        if( datatypeDefinition instanceof DatatypeDefinitionInteger ) {

            DatatypeDefinitionInteger datatypeDefinitionInteger = (DatatypeDefinitionInteger)datatypeDefinition;

            int integerValue = 0;
            try {
                integerValue = Integer.parseInt( attributeValueSimple.getTheValue() );
            } catch( NumberFormatException e ) {
                errorMsgKey = "_UI_DatatypeDefinitionConstraints_InvalidInteger";
            }

            if( errorMsgKey == null ) {
                if( (datatypeDefinitionInteger.isSetMax() && integerValue > datatypeDefinitionInteger.getMax())
                    || (datatypeDefinitionInteger.isSetMin() && integerValue < datatypeDefinitionInteger.getMin()) ) {
                    errorMsgKey = "_UI_DatatypeDefinitionConstraints_Range";
                    substitutions.add( datatypeDefinitionInteger.getMin() );
                    substitutions.add( datatypeDefinitionInteger.getMax() );
                }
            }
        }

        /* Check constraints if value is of DatatypedefinitionString */
        else if( datatypeDefinition instanceof DatatypeDefinitionString ) {
            DatatypeDefinitionString datatypeDefinitionString = (DatatypeDefinitionString)datatypeDefinition;
            if( datatypeDefinitionString.isSetMaxLength()
                && attributeValueSimple.getTheValue().length() > datatypeDefinitionString.getMaxLength() ) {
                errorMsgKey = "_UI_DatatypeDefinitionConstraints_StringLength";
                substitutions.add( datatypeDefinitionString.getMaxLength() );
            }
        }

        /* check if an error has occurred */
        if( errorMsgKey != null && diagnostics != null ) {
            if( diagnostics != null ) {
                diagnostics.add( createDiagnostic( Diagnostic.ERROR,
                                                   DIAGNOSTIC_SOURCE,
                                                   0,
                                                   errorMsgKey,
                                                   substitutions.toArray(),
                                                   new Object[]{attributeValueSimple},
                                                   context ) );
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param datatypeDefinitionInteger the datatype definition integer
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateDatatypeDefinitionInteger( DatatypeDefinitionInteger datatypeDefinitionInteger,
                                                      DiagnosticChain diagnostics,
                                                      Map<Object, Object> context ) {
        if( !validate_NoCircularContainment( datatypeDefinitionInteger, diagnostics, context ) ) return false;
        boolean result = validate_EveryMultiplicityConforms( datatypeDefinitionInteger, diagnostics, context );
        if( result || diagnostics != null ) result &= validate_EveryDataValueConforms( datatypeDefinitionInteger,
                                                                                       diagnostics,
                                                                                       context );
        if( result || diagnostics != null ) result &= validate_EveryReferenceIsContained( datatypeDefinitionInteger,
                                                                                          diagnostics,
                                                                                          context );
        if( result || diagnostics != null ) result &= validate_EveryBidirectionalReferenceIsPaired( datatypeDefinitionInteger,
                                                                                                    diagnostics,
                                                                                                    context );
        if( result || diagnostics != null ) result &= validate_EveryProxyResolves( datatypeDefinitionInteger,
                                                                                   diagnostics,
                                                                                   context );
        if( result || diagnostics != null ) result &= validate_UniqueID( datatypeDefinitionInteger,
                                                                         diagnostics,
                                                                         context );
        if( result || diagnostics != null ) result &= validate_EveryKeyUnique( datatypeDefinitionInteger,
                                                                               diagnostics,
                                                                               context );
        if( result || diagnostics != null ) result &= validate_EveryMapEntryUnique( datatypeDefinitionInteger,
                                                                                    diagnostics,
                                                                                    context );
        if( result || diagnostics != null ) result &= validateDatatypeDefinitionInteger_NonNegative( datatypeDefinitionInteger,
                                                                                                     diagnostics,
                                                                                                     context );
        if( result || diagnostics != null ) result &= validateDatatypeDefinitionInteger_MaxGreaterThanMin( datatypeDefinitionInteger,
                                                                                                           diagnostics,
                                                                                                           context );
        return result;
    }

    /**
     * Validates the NonNegative constraint of '<em>Datatype Definition Integer</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param datatypeDefinitionInteger the datatype definition integer
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @NOT generated
     */
    public boolean validateDatatypeDefinitionInteger_NonNegative( DatatypeDefinitionInteger datatypeDefinitionInteger,
                                                                  DiagnosticChain diagnostics,
                                                                  Map<Object, Object> context ) {
        if( (datatypeDefinitionInteger.isSetMax() && datatypeDefinitionInteger.getMax() < 0)
            || (datatypeDefinitionInteger.isSetMin() && datatypeDefinitionInteger.getMin() < 0) ) {
            if( diagnostics != null ) {
                diagnostics.add( createDiagnostic( Diagnostic.ERROR,
                                                   DIAGNOSTIC_SOURCE,
                                                   0,
                                                   "_UI_GenericConstraint_diagnostic",
                                                   new Object[]{
                                                       "NonNegative",
                                                       getObjectLabel( datatypeDefinitionInteger, context )},
                                                   new Object[]{datatypeDefinitionInteger},
                                                   context ) );
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the MaxGreaterThanMin constraint of '<em>Datatype Definition Integer</em>'. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @param datatypeDefinitionInteger the datatype definition integer
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @NOT generated
     */
    public boolean validateDatatypeDefinitionInteger_MaxGreaterThanMin( DatatypeDefinitionInteger datatypeDefinitionInteger,
                                                                        DiagnosticChain diagnostics,
                                                                        Map<Object, Object> context ) {
        if( datatypeDefinitionInteger.isSetMax()
            && datatypeDefinitionInteger.isSetMin()
            && datatypeDefinitionInteger.getMax() < datatypeDefinitionInteger.getMin() ) {
            if( diagnostics != null ) {
                diagnostics.add( createDiagnostic( Diagnostic.ERROR,
                                                   DIAGNOSTIC_SOURCE,
                                                   0,
                                                   "_UI_GenericConstraint_diagnostic",
                                                   new Object[]{
                                                       "MaxGreaterThanMin",
                                                       getObjectLabel( datatypeDefinitionInteger, context )},
                                                   new Object[]{datatypeDefinitionInteger},
                                                   context ) );
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param datatypeDefinitionSimple the datatype definition simple
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateDatatypeDefinitionSimple( DatatypeDefinitionSimple datatypeDefinitionSimple,
                                                     DiagnosticChain diagnostics,
                                                     Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( datatypeDefinitionSimple, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param datatypeDefinitionString the datatype definition string
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateDatatypeDefinitionString( DatatypeDefinitionString datatypeDefinitionString,
                                                     DiagnosticChain diagnostics,
                                                     Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( datatypeDefinitionString, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param identifiable the identifiable
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateIdentifiable( Identifiable identifiable,
                                         DiagnosticChain diagnostics,
                                         Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( identifiable, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param attributeDefinitionSimple the attribute definition simple
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateAttributeDefinitionSimple( AttributeDefinitionSimple attributeDefinitionSimple,
                                                      DiagnosticChain diagnostics,
                                                      Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( attributeDefinitionSimple, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param erf the erf
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateERF( ERF erf, DiagnosticChain diagnostics, Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( erf, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param content the content
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateContent( Content content, DiagnosticChain diagnostics, Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( content, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param specRelation the spec relation
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateSpecRelation( SpecRelation specRelation,
                                         DiagnosticChain diagnostics,
                                         Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( specRelation, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param embeddedValue the embedded value
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateEmbeddedValue( EmbeddedValue embeddedValue,
                                          DiagnosticChain diagnostics,
                                          Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( embeddedValue, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param enumValue the enum value
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateEnumValue( EnumValue enumValue, DiagnosticChain diagnostics, Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( enumValue, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param datatypeDefinitionEnumeration the datatype definition enumeration
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateDatatypeDefinitionEnumeration( DatatypeDefinitionEnumeration datatypeDefinitionEnumeration,
                                                          DiagnosticChain diagnostics,
                                                          Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( datatypeDefinitionEnumeration, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param attributeDefinitionEnumeration the attribute definition enumeration
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateAttributeDefinitionEnumeration( AttributeDefinitionEnumeration attributeDefinitionEnumeration,
                                                           DiagnosticChain diagnostics,
                                                           Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( attributeDefinitionEnumeration, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param attributeValueEnumeration the attribute value enumeration
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateAttributeValueEnumeration( AttributeValueEnumeration attributeValueEnumeration,
                                                      DiagnosticChain diagnostics,
                                                      Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( attributeValueEnumeration, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param datatypeDefinitionBoolean the datatype definition boolean
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateDatatypeDefinitionBoolean( DatatypeDefinitionBoolean datatypeDefinitionBoolean,
                                                      DiagnosticChain diagnostics,
                                                      Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( datatypeDefinitionBoolean, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param attributeDefinitionBoolean the attribute definition boolean
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateAttributeDefinitionBoolean( AttributeDefinitionBoolean attributeDefinitionBoolean,
                                                       DiagnosticChain diagnostics,
                                                       Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( attributeDefinitionBoolean, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param attributeValueBoolean the attribute value boolean
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateAttributeValueBoolean( AttributeValueBoolean attributeValueBoolean,
                                                  DiagnosticChain diagnostics,
                                                  Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( attributeValueBoolean, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param toolExtension the tool extension
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateToolExtension( ToolExtension toolExtension,
                                          DiagnosticChain diagnostics,
                                          Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( toolExtension, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param view the view
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateView( View view, DiagnosticChain diagnostics, Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( view, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param viewElement the view element
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateViewElement( ViewElement viewElement,
                                        DiagnosticChain diagnostics,
                                        Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( viewElement, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param eraToolExtension the era tool extension
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateEraToolExtension( EraToolExtension eraToolExtension,
                                             DiagnosticChain diagnostics,
                                             Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( eraToolExtension, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @param color the color
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateColor( Color color, DiagnosticChain diagnostics, Map<Object, Object> context ) {
        return validate_EveryDefaultConstraint( color, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param diagnosticChain the diagnostic chain
     * @param diagnostics the diagnostics
     * @param context the context
     * @return true, if successful
     * @generated
     */
    public boolean validateDiagnosticChain( DiagnosticChain diagnosticChain,
                                            DiagnosticChain diagnostics,
                                            Map<Object, Object> context ) {
        return true;
    }

    /**
     * Returns the resource locator that will be used to fetch messages for this validator's diagnostics. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the resource locator
     * @NOT generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return Activator.INSTANCE.getPluginResourceLocator();
    }

} // ErfValidator
