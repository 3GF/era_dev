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
package era.foss.erf.impl;

import era.foss.erf.AttributeValue;
import era.foss.erf.ErfPackage;
import era.foss.erf.SpecElementWithUserDefinedAttributes;
import era.foss.erf.SpecType;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Spec Element With User Defined Attributes</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link era.foss.erf.impl.SpecElementWithUserDefinedAttributesImpl#getValues <em>Values</em>}</li>
 *   <li>{@link era.foss.erf.impl.SpecElementWithUserDefinedAttributesImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SpecElementWithUserDefinedAttributesImpl extends IdentifiableImpl implements
        SpecElementWithUserDefinedAttributes {

    /**
     * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValues()
     * @generated
     * @ordered
     */
    protected EList<AttributeValue> values;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected SpecType type;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SpecElementWithUserDefinedAttributesImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErfPackage.Literals.SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<AttributeValue> getValues() {
        if( values == null ) {
            values = new EObjectContainmentEList<AttributeValue>(
                AttributeValue.class,
                this,
                ErfPackage.SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__VALUES );
        }
        return values;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SpecType getType() {
        if( type != null && type.eIsProxy() ) {
            InternalEObject oldType = (InternalEObject)type;
            type = (SpecType)eResolveProxy( oldType );
            if( type != oldType ) {
                if( eNotificationRequired() ) eNotify( new ENotificationImpl(
                    this,
                    Notification.RESOLVE,
                    ErfPackage.SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__TYPE,
                    oldType,
                    type ) );
            }
        }
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SpecType basicGetType() {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType( SpecType newType ) {
        SpecType oldType = type;
        type = newType;
        if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__TYPE,
            oldType,
            type ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove( InternalEObject otherEnd, int featureID, NotificationChain msgs ) {
        switch (featureID) {
        case ErfPackage.SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__VALUES:
            return ((InternalEList<?>)getValues()).basicRemove( otherEnd, msgs );
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
        case ErfPackage.SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__VALUES:
            return getValues();
        case ErfPackage.SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__TYPE:
            if( resolve ) return getType();
            return basicGetType();
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
        case ErfPackage.SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__VALUES:
            getValues().clear();
            getValues().addAll( (Collection<? extends AttributeValue>)newValue );
            return;
        case ErfPackage.SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__TYPE:
            setType( (SpecType)newValue );
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
        case ErfPackage.SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__VALUES:
            getValues().clear();
            return;
        case ErfPackage.SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__TYPE:
            setType( (SpecType)null );
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
        case ErfPackage.SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__VALUES:
            return values != null && !values.isEmpty();
        case ErfPackage.SPEC_ELEMENT_WITH_USER_DEFINED_ATTRIBUTES__TYPE:
            return type != null;
        }
        return super.eIsSet( featureID );
    }

} //SpecElementWithUserDefinedAttributesImpl
