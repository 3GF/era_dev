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

import era.foss.erf.AccessControlledElement;
import era.foss.erf.ErfPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Access Controlled Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link era.foss.erf.impl.AccessControlledElementImpl#isEditable <em>Editable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AccessControlledElementImpl extends IdentifiableImpl implements AccessControlledElement {
    /**
     * The default value of the '{@link #isEditable() <em>Editable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEditable()
     * @generated
     * @ordered
     */
    protected static final boolean EDITABLE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isEditable() <em>Editable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEditable()
     * @generated
     * @ordered
     */
    protected boolean editable = EDITABLE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AccessControlledElementImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErfPackage.Literals.ACCESS_CONTROLLED_ELEMENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isEditable() {
        return editable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEditable( boolean newEditable ) {
        boolean oldEditable = editable;
        editable = newEditable;
        if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.ACCESS_CONTROLLED_ELEMENT__EDITABLE,
            oldEditable,
            editable ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet( int featureID, boolean resolve, boolean coreType ) {
        switch (featureID) {
        case ErfPackage.ACCESS_CONTROLLED_ELEMENT__EDITABLE:
            return isEditable();
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
        case ErfPackage.ACCESS_CONTROLLED_ELEMENT__EDITABLE:
            setEditable( (Boolean)newValue );
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
        case ErfPackage.ACCESS_CONTROLLED_ELEMENT__EDITABLE:
            setEditable( EDITABLE_EDEFAULT );
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
        case ErfPackage.ACCESS_CONTROLLED_ELEMENT__EDITABLE:
            return editable != EDITABLE_EDEFAULT;
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
        result.append( " (editable: " );
        result.append( editable );
        result.append( ')' );
        return result.toString();
    }

} //AccessControlledElementImpl
