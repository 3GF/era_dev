/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package era.foss.erf.impl;

import era.foss.erf.DatatypeDefinitionEnumeration;
import era.foss.erf.EnumValue;
import era.foss.erf.ErfPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Datatype Definition Enumeration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link era.foss.erf.impl.DatatypeDefinitionEnumerationImpl#getSpecifiedValues <em>Specified Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DatatypeDefinitionEnumerationImpl extends DatatypeDefinitionImpl implements
        DatatypeDefinitionEnumeration {
    /**
     * The cached value of the '{@link #getSpecifiedValues() <em>Specified Values</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSpecifiedValues()
     * @generated
     * @ordered
     */
    protected EList<EnumValue> specifiedValues;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DatatypeDefinitionEnumerationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErfPackage.Literals.DATATYPE_DEFINITION_ENUMERATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<EnumValue> getSpecifiedValues() {
        if( specifiedValues == null ) {
            specifiedValues = new EObjectContainmentEList<EnumValue>(
                EnumValue.class,
                this,
                ErfPackage.DATATYPE_DEFINITION_ENUMERATION__SPECIFIED_VALUES );
        }
        return specifiedValues;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove( InternalEObject otherEnd, int featureID, NotificationChain msgs ) {
        switch (featureID) {
        case ErfPackage.DATATYPE_DEFINITION_ENUMERATION__SPECIFIED_VALUES:
            return ((InternalEList<?>)getSpecifiedValues()).basicRemove( otherEnd, msgs );
        }
        return super.eInverseRemove( otherEnd, featureID, msgs );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet( int featureID, boolean resolve, boolean coreType ) {
        switch (featureID) {
        case ErfPackage.DATATYPE_DEFINITION_ENUMERATION__SPECIFIED_VALUES:
            return getSpecifiedValues();
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
        case ErfPackage.DATATYPE_DEFINITION_ENUMERATION__SPECIFIED_VALUES:
            getSpecifiedValues().clear();
            getSpecifiedValues().addAll( (Collection<? extends EnumValue>)newValue );
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
        case ErfPackage.DATATYPE_DEFINITION_ENUMERATION__SPECIFIED_VALUES:
            getSpecifiedValues().clear();
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
        case ErfPackage.DATATYPE_DEFINITION_ENUMERATION__SPECIFIED_VALUES:
            return specifiedValues != null && !specifiedValues.isEmpty();
        }
        return super.eIsSet( featureID );
    }

} //DatatypeDefinitionEnumerationImpl
