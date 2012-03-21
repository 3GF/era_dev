/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package era.foss.erf.impl;

import era.foss.erf.AttributeValueEnumeration;
import era.foss.erf.EnumValue;
import era.foss.erf.ErfPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Value Enumeration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link era.foss.erf.impl.AttributeValueEnumerationImpl#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeValueEnumerationImpl extends AttributeValueImpl implements AttributeValueEnumeration {
    /**
     * The cached value of the '{@link #getValues() <em>Values</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValues()
     * @generated
     * @ordered
     */
    protected EList<EnumValue> values;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AttributeValueEnumerationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErfPackage.Literals.ATTRIBUTE_VALUE_ENUMERATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<EnumValue> getValues() {
        if( values == null ) {
            values = new EObjectResolvingEList<EnumValue>(
                EnumValue.class,
                this,
                ErfPackage.ATTRIBUTE_VALUE_ENUMERATION__VALUES );
        }
        return values;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet( int featureID, boolean resolve, boolean coreType ) {
        switch (featureID) {
        case ErfPackage.ATTRIBUTE_VALUE_ENUMERATION__VALUES:
            return getValues();
        }
        return super.eGet( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet( int featureID, Object newValue ) {
        switch (featureID) {
        case ErfPackage.ATTRIBUTE_VALUE_ENUMERATION__VALUES:
            getValues().clear();
            getValues().addAll( (Collection<? extends EnumValue>)newValue );
            return;
        }
        super.eSet( featureID, newValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset( int featureID ) {
        switch (featureID) {
        case ErfPackage.ATTRIBUTE_VALUE_ENUMERATION__VALUES:
            getValues().clear();
            return;
        }
        super.eUnset( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet( int featureID ) {
        switch (featureID) {
        case ErfPackage.ATTRIBUTE_VALUE_ENUMERATION__VALUES:
            return values != null && !values.isEmpty();
        }
        return super.eIsSet( featureID );
    }

} //AttributeValueEnumerationImpl
