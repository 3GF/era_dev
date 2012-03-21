/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package era.foss.erf.impl;

import era.foss.erf.AttributeDefinitionBoolean;
import era.foss.erf.AttributeValueBoolean;
import era.foss.erf.ErfPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Definition Boolean</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link era.foss.erf.impl.AttributeDefinitionBooleanImpl#getDefaultValue <em>Default Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeDefinitionBooleanImpl extends AttributeDefinitionImpl implements AttributeDefinitionBoolean {
    /**
     * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultValue()
     * @generated
     * @ordered
     */
    protected AttributeValueBoolean defaultValue;

    /**
     * This is true if the Default Value containment reference has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean defaultValueESet;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AttributeDefinitionBooleanImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErfPackage.Literals.ATTRIBUTE_DEFINITION_BOOLEAN;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AttributeValueBoolean getDefaultValue() {
        return defaultValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDefaultValue( AttributeValueBoolean newDefaultValue, NotificationChain msgs ) {
        AttributeValueBoolean oldDefaultValue = defaultValue;
        defaultValue = newDefaultValue;
        boolean oldDefaultValueESet = defaultValueESet;
        defaultValueESet = true;
        if( eNotificationRequired() ) {
            ENotificationImpl notification = new ENotificationImpl(
                this,
                Notification.SET,
                ErfPackage.ATTRIBUTE_DEFINITION_BOOLEAN__DEFAULT_VALUE,
                oldDefaultValue,
                newDefaultValue,
                !oldDefaultValueESet );
            if( msgs == null ) msgs = notification;
            else msgs.add( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefaultValue( AttributeValueBoolean newDefaultValue ) {
        if( newDefaultValue != defaultValue ) {
            NotificationChain msgs = null;
            if( defaultValue != null ) msgs = ((InternalEObject)defaultValue).eInverseRemove( this,
                                                                                              EOPPOSITE_FEATURE_BASE
                                                                                                  - ErfPackage.ATTRIBUTE_DEFINITION_BOOLEAN__DEFAULT_VALUE,
                                                                                              null,
                                                                                              msgs );
            if( newDefaultValue != null ) msgs = ((InternalEObject)newDefaultValue).eInverseAdd( this,
                                                                                                 EOPPOSITE_FEATURE_BASE
                                                                                                     - ErfPackage.ATTRIBUTE_DEFINITION_BOOLEAN__DEFAULT_VALUE,
                                                                                                 null,
                                                                                                 msgs );
            msgs = basicSetDefaultValue( newDefaultValue, msgs );
            if( msgs != null ) msgs.dispatch();
        } else {
            boolean oldDefaultValueESet = defaultValueESet;
            defaultValueESet = true;
            if( eNotificationRequired() ) eNotify( new ENotificationImpl(
                this,
                Notification.SET,
                ErfPackage.ATTRIBUTE_DEFINITION_BOOLEAN__DEFAULT_VALUE,
                newDefaultValue,
                newDefaultValue,
                !oldDefaultValueESet ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicUnsetDefaultValue( NotificationChain msgs ) {
        AttributeValueBoolean oldDefaultValue = defaultValue;
        defaultValue = null;
        boolean oldDefaultValueESet = defaultValueESet;
        defaultValueESet = false;
        if( eNotificationRequired() ) {
            ENotificationImpl notification = new ENotificationImpl(
                this,
                Notification.UNSET,
                ErfPackage.ATTRIBUTE_DEFINITION_BOOLEAN__DEFAULT_VALUE,
                oldDefaultValue,
                null,
                oldDefaultValueESet );
            if( msgs == null ) msgs = notification;
            else msgs.add( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetDefaultValue() {
        if( defaultValue != null ) {
            NotificationChain msgs = null;
            msgs = ((InternalEObject)defaultValue).eInverseRemove( this, EOPPOSITE_FEATURE_BASE
                - ErfPackage.ATTRIBUTE_DEFINITION_BOOLEAN__DEFAULT_VALUE, null, msgs );
            msgs = basicUnsetDefaultValue( msgs );
            if( msgs != null ) msgs.dispatch();
        } else {
            boolean oldDefaultValueESet = defaultValueESet;
            defaultValueESet = false;
            if( eNotificationRequired() ) eNotify( new ENotificationImpl(
                this,
                Notification.UNSET,
                ErfPackage.ATTRIBUTE_DEFINITION_BOOLEAN__DEFAULT_VALUE,
                null,
                null,
                oldDefaultValueESet ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetDefaultValue() {
        return defaultValueESet;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove( InternalEObject otherEnd, int featureID, NotificationChain msgs ) {
        switch (featureID) {
        case ErfPackage.ATTRIBUTE_DEFINITION_BOOLEAN__DEFAULT_VALUE:
            return basicUnsetDefaultValue( msgs );
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
        case ErfPackage.ATTRIBUTE_DEFINITION_BOOLEAN__DEFAULT_VALUE:
            return getDefaultValue();
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
        case ErfPackage.ATTRIBUTE_DEFINITION_BOOLEAN__DEFAULT_VALUE:
            setDefaultValue( (AttributeValueBoolean)newValue );
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
        case ErfPackage.ATTRIBUTE_DEFINITION_BOOLEAN__DEFAULT_VALUE:
            unsetDefaultValue();
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
        case ErfPackage.ATTRIBUTE_DEFINITION_BOOLEAN__DEFAULT_VALUE:
            return isSetDefaultValue();
        }
        return super.eIsSet( featureID );
    }

} //AttributeDefinitionBooleanImpl
