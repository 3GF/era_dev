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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import era.foss.erf.AttributeDefinitionEnumeration;
import era.foss.erf.AttributeValueEnumeration;
import era.foss.erf.ErfPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Attribute Definition Enumeration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link era.foss.erf.impl.AttributeDefinitionEnumerationImpl#isMultiValued <em>Multi Valued</em>}</li>
 *   <li>{@link era.foss.erf.impl.AttributeDefinitionEnumerationImpl#getDefaultValue <em>Default Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeDefinitionEnumerationImpl extends AttributeDefinitionImpl implements
        AttributeDefinitionEnumeration {
    /**
     * The default value of the '{@link #isMultiValued() <em>Multi Valued</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #isMultiValued()
     * @generated
     * @ordered
     */
    protected static final boolean MULTI_VALUED_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isMultiValued() <em>Multi Valued</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #isMultiValued()
     * @generated
     * @ordered
     */
    protected boolean multiValued = MULTI_VALUED_EDEFAULT;

    /**
     * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDefaultValue()
     * @generated
     * @ordered
     */
    protected AttributeValueEnumeration defaultValue;

    /**
     * This is true if the Default Value containment reference has been set. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     * @ordered
     */
    protected boolean defaultValueESet;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected AttributeDefinitionEnumerationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErfPackage.Literals.ATTRIBUTE_DEFINITION_ENUMERATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return true, if is multi valued
     * @generated
     */
    public boolean isMultiValued() {
        return multiValued;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param newMultiValued the new multi valued
     * @generated
     */
    public void setMultiValued( boolean newMultiValued ) {
        boolean oldMultiValued = multiValued;
        multiValued = newMultiValued;
        if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.ATTRIBUTE_DEFINITION_ENUMERATION__MULTI_VALUED,
            oldMultiValued,
            multiValued ) );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the default value
     * @generated
     */
    public AttributeValueEnumeration getDefaultValue() {
        return defaultValue;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param newDefaultValue the new default value
     * @param msgs the msgs
     * @return the notification chain
     * @generated
     */
    public NotificationChain basicSetDefaultValue( AttributeValueEnumeration newDefaultValue, NotificationChain msgs ) {
        AttributeValueEnumeration oldDefaultValue = defaultValue;
        defaultValue = newDefaultValue;
        boolean oldDefaultValueESet = defaultValueESet;
        defaultValueESet = true;
        if( eNotificationRequired() ) {
            ENotificationImpl notification = new ENotificationImpl(
                this,
                Notification.SET,
                ErfPackage.ATTRIBUTE_DEFINITION_ENUMERATION__DEFAULT_VALUE,
                oldDefaultValue,
                newDefaultValue,
                !oldDefaultValueESet );
            if( msgs == null ) msgs = notification;
            else msgs.add( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param newDefaultValue the new default value
     * @generated
     */
    public void setDefaultValue( AttributeValueEnumeration newDefaultValue ) {
        if( newDefaultValue != defaultValue ) {
            NotificationChain msgs = null;
            if( defaultValue != null ) msgs = ((InternalEObject)defaultValue).eInverseRemove( this,
                                                                                              EOPPOSITE_FEATURE_BASE
                                                                                                  - ErfPackage.ATTRIBUTE_DEFINITION_ENUMERATION__DEFAULT_VALUE,
                                                                                              null,
                                                                                              msgs );
            if( newDefaultValue != null ) msgs = ((InternalEObject)newDefaultValue).eInverseAdd( this,
                                                                                                 EOPPOSITE_FEATURE_BASE
                                                                                                     - ErfPackage.ATTRIBUTE_DEFINITION_ENUMERATION__DEFAULT_VALUE,
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
                ErfPackage.ATTRIBUTE_DEFINITION_ENUMERATION__DEFAULT_VALUE,
                newDefaultValue,
                newDefaultValue,
                !oldDefaultValueESet ) );
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param msgs the msgs
     * @return the notification chain
     * @generated
     */
    public NotificationChain basicUnsetDefaultValue( NotificationChain msgs ) {
        AttributeValueEnumeration oldDefaultValue = defaultValue;
        defaultValue = null;
        boolean oldDefaultValueESet = defaultValueESet;
        defaultValueESet = false;
        if( eNotificationRequired() ) {
            ENotificationImpl notification = new ENotificationImpl(
                this,
                Notification.UNSET,
                ErfPackage.ATTRIBUTE_DEFINITION_ENUMERATION__DEFAULT_VALUE,
                oldDefaultValue,
                null,
                oldDefaultValueESet );
            if( msgs == null ) msgs = notification;
            else msgs.add( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void unsetDefaultValue() {
        if( defaultValue != null ) {
            NotificationChain msgs = null;
            msgs = ((InternalEObject)defaultValue).eInverseRemove( this, EOPPOSITE_FEATURE_BASE
                - ErfPackage.ATTRIBUTE_DEFINITION_ENUMERATION__DEFAULT_VALUE, null, msgs );
            msgs = basicUnsetDefaultValue( msgs );
            if( msgs != null ) msgs.dispatch();
        } else {
            boolean oldDefaultValueESet = defaultValueESet;
            defaultValueESet = false;
            if( eNotificationRequired() ) eNotify( new ENotificationImpl(
                this,
                Notification.UNSET,
                ErfPackage.ATTRIBUTE_DEFINITION_ENUMERATION__DEFAULT_VALUE,
                null,
                null,
                oldDefaultValueESet ) );
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return true, if is sets the default value
     * @generated
     */
    public boolean isSetDefaultValue() {
        return defaultValueESet;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove( InternalEObject otherEnd, int featureID, NotificationChain msgs ) {
        switch (featureID) {
        case ErfPackage.ATTRIBUTE_DEFINITION_ENUMERATION__DEFAULT_VALUE:
            return basicUnsetDefaultValue( msgs );
        }
        return super.eInverseRemove( otherEnd, featureID, msgs );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet( int featureID, boolean resolve, boolean coreType ) {
        switch (featureID) {
        case ErfPackage.ATTRIBUTE_DEFINITION_ENUMERATION__MULTI_VALUED:
            return isMultiValued();
        case ErfPackage.ATTRIBUTE_DEFINITION_ENUMERATION__DEFAULT_VALUE:
            return getDefaultValue();
        }
        return super.eGet( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet( int featureID, Object newValue ) {
        switch (featureID) {
        case ErfPackage.ATTRIBUTE_DEFINITION_ENUMERATION__MULTI_VALUED:
            setMultiValued( (Boolean)newValue );
            return;
        case ErfPackage.ATTRIBUTE_DEFINITION_ENUMERATION__DEFAULT_VALUE:
            setDefaultValue( (AttributeValueEnumeration)newValue );
            return;
        }
        super.eSet( featureID, newValue );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset( int featureID ) {
        switch (featureID) {
        case ErfPackage.ATTRIBUTE_DEFINITION_ENUMERATION__MULTI_VALUED:
            setMultiValued( MULTI_VALUED_EDEFAULT );
            return;
        case ErfPackage.ATTRIBUTE_DEFINITION_ENUMERATION__DEFAULT_VALUE:
            unsetDefaultValue();
            return;
        }
        super.eUnset( featureID );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet( int featureID ) {
        switch (featureID) {
        case ErfPackage.ATTRIBUTE_DEFINITION_ENUMERATION__MULTI_VALUED:
            return multiValued != MULTI_VALUED_EDEFAULT;
        case ErfPackage.ATTRIBUTE_DEFINITION_ENUMERATION__DEFAULT_VALUE:
            return isSetDefaultValue();
        }
        return super.eIsSet( featureID );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if( eIsProxy() ) return super.toString();

        StringBuffer result = new StringBuffer( super.toString() );
        result.append( " (multiValued: " );
        result.append( multiValued );
        result.append( ')' );
        return result.toString();
    }

} // AttributeDefinitionEnumerationImpl
