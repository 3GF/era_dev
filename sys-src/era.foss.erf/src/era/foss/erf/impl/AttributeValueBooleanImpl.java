/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package era.foss.erf.impl;

import era.foss.erf.AttributeValueBoolean;
import era.foss.erf.ErfPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Value Boolean</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link era.foss.erf.impl.AttributeValueBooleanImpl#getTheValue <em>The Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeValueBooleanImpl extends AttributeValueImpl implements AttributeValueBoolean {
    /**
     * The default value of the '{@link #getTheValue() <em>The Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTheValue()
     * @generated
     * @ordered
     */
    protected static final Boolean THE_VALUE_EDEFAULT = Boolean.FALSE;
    /**
     * The cached value of the '{@link #getTheValue() <em>The Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTheValue()
     * @generated
     * @ordered
     */
    protected Boolean theValue = THE_VALUE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AttributeValueBooleanImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErfPackage.Literals.ATTRIBUTE_VALUE_BOOLEAN;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Boolean getTheValue() {
        return theValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTheValue( Boolean newTheValue ) {
        Boolean oldTheValue = theValue;
        theValue = newTheValue;
        if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.ATTRIBUTE_VALUE_BOOLEAN__THE_VALUE,
            oldTheValue,
            theValue ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet( int featureID, boolean resolve, boolean coreType ) {
        switch (featureID) {
        case ErfPackage.ATTRIBUTE_VALUE_BOOLEAN__THE_VALUE:
            return getTheValue();
        }
        return super.eGet( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet( int featureID, Object newValue ) {
        switch (featureID) {
        case ErfPackage.ATTRIBUTE_VALUE_BOOLEAN__THE_VALUE:
            setTheValue( (Boolean)newValue );
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
        case ErfPackage.ATTRIBUTE_VALUE_BOOLEAN__THE_VALUE:
            setTheValue( THE_VALUE_EDEFAULT );
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
        case ErfPackage.ATTRIBUTE_VALUE_BOOLEAN__THE_VALUE:
            return THE_VALUE_EDEFAULT == null ? theValue != null : !THE_VALUE_EDEFAULT.equals( theValue );
        }
        return super.eIsSet( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if( eIsProxy() ) return super.toString();

        StringBuffer result = new StringBuffer( super.toString() );
        result.append( " (theValue: " );
        result.append( theValue );
        result.append( ')' );
        return result.toString();
    }

} //AttributeValueBooleanImpl
