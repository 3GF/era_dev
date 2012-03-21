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

import java.util.UUID;

import era.foss.erf.Identifiable;
import era.foss.erf.ErfPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Identifiable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link era.foss.erf.impl.IdentifiableImpl#getID <em>ID</em>}</li>
 *   <li>{@link era.foss.erf.impl.IdentifiableImpl#getDesc <em>Desc</em>}</li>
 *   <li>{@link era.foss.erf.impl.IdentifiableImpl#getLongName <em>Long Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class IdentifiableImpl extends EObjectImpl implements Identifiable {

    /**
     * The default value of the '{@link #getID() <em>ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getID()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getID() <em>ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getID()
     * @generated
     * @ordered
     */
    protected String iD = ID_EDEFAULT;

    /**
     * This is true if the ID attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean iDESet;

    /**
     * The default value of the '{@link #getDesc() <em>Desc</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDesc()
     * @generated
     * @ordered
     */
    protected static final String DESC_EDEFAULT = "";

    /**
     * The cached value of the '{@link #getDesc() <em>Desc</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDesc()
     * @generated
     * @ordered
     */
    protected String desc = DESC_EDEFAULT;

    /**
     * The default value of the '{@link #getLongName() <em>Long Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLongName()
     * @generated
     * @ordered
     */
    protected static final String LONG_NAME_EDEFAULT = "";

    /**
     * The cached value of the '{@link #getLongName() <em>Long Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLongName()
     * @generated
     * @ordered
     */
    protected String longName = LONG_NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @NOT generated
     */
    protected IdentifiableImpl() {
        super();
        setID( UUID.randomUUID().toString() );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErfPackage.Literals.IDENTIFIABLE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getID() {
        return iD;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setID( String newID ) {
        String oldID = iD;
        iD = newID;
        boolean oldIDESet = iDESet;
        iDESet = true;
        if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.IDENTIFIABLE__ID,
            oldID,
            iD,
            !oldIDESet ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetID() {
        String oldID = iD;
        boolean oldIDESet = iDESet;
        iD = ID_EDEFAULT;
        iDESet = false;
        if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.UNSET,
            ErfPackage.IDENTIFIABLE__ID,
            oldID,
            ID_EDEFAULT,
            oldIDESet ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetID() {
        return iDESet;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDesc() {
        return desc;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDesc( String newDesc ) {
        String oldDesc = desc;
        desc = newDesc;
        if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.IDENTIFIABLE__DESC,
            oldDesc,
            desc ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLongName() {
        return longName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLongName( String newLongName ) {
        String oldLongName = longName;
        longName = newLongName;
        if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.IDENTIFIABLE__LONG_NAME,
            oldLongName,
            longName ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet( int featureID, boolean resolve, boolean coreType ) {
        switch (featureID) {
        case ErfPackage.IDENTIFIABLE__ID:
            return getID();
        case ErfPackage.IDENTIFIABLE__DESC:
            return getDesc();
        case ErfPackage.IDENTIFIABLE__LONG_NAME:
            return getLongName();
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
        case ErfPackage.IDENTIFIABLE__ID:
            setID( (String)newValue );
            return;
        case ErfPackage.IDENTIFIABLE__DESC:
            setDesc( (String)newValue );
            return;
        case ErfPackage.IDENTIFIABLE__LONG_NAME:
            setLongName( (String)newValue );
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
        case ErfPackage.IDENTIFIABLE__ID:
            unsetID();
            return;
        case ErfPackage.IDENTIFIABLE__DESC:
            setDesc( DESC_EDEFAULT );
            return;
        case ErfPackage.IDENTIFIABLE__LONG_NAME:
            setLongName( LONG_NAME_EDEFAULT );
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
        case ErfPackage.IDENTIFIABLE__ID:
            return isSetID();
        case ErfPackage.IDENTIFIABLE__DESC:
            return DESC_EDEFAULT == null ? desc != null : !DESC_EDEFAULT.equals( desc );
        case ErfPackage.IDENTIFIABLE__LONG_NAME:
            return LONG_NAME_EDEFAULT == null ? longName != null : !LONG_NAME_EDEFAULT.equals( longName );
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
        result.append( " (iD: " );
        if( iDESet ) result.append( iD );
        else result.append( "<unset>" );
        result.append( ", desc: " );
        result.append( desc );
        result.append( ", longName: " );
        result.append( longName );
        result.append( ')' );
        return result.toString();
    }

} //IdentifiableImpl
