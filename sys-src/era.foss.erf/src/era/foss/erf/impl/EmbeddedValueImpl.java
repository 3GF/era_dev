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

import era.foss.erf.EmbeddedValue;
import era.foss.erf.ErfPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Embedded Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link era.foss.erf.impl.EmbeddedValueImpl#getKey <em>Key</em>}</li>
 *   <li>{@link era.foss.erf.impl.EmbeddedValueImpl#getOtherContent <em>Other Content</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EmbeddedValueImpl extends EObjectImpl implements EmbeddedValue {
    /**
     * The default value of the '{@link #getKey() <em>Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getKey()
     * @generated
     * @ordered
     */
    protected static final int KEY_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getKey() <em>Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getKey()
     * @generated
     * @ordered
     */
    protected int key = KEY_EDEFAULT;

    /**
     * The default value of the '{@link #getOtherContent() <em>Other Content</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOtherContent()
     * @generated
     * @ordered
     */
    protected static final String OTHER_CONTENT_EDEFAULT = "";

    /**
     * The cached value of the '{@link #getOtherContent() <em>Other Content</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOtherContent()
     * @generated
     * @ordered
     */
    protected String otherContent = OTHER_CONTENT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EmbeddedValueImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErfPackage.Literals.EMBEDDED_VALUE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the key
     * @generated
     */
    public int getKey() {
        return key;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @param newKey the new key
     * @generated
     */
    public void setKey( int newKey ) {
        int oldKey = key;
        key = newKey;
        if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.EMBEDDED_VALUE__KEY,
            oldKey,
            key ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the other content
     * @generated
     */
    public String getOtherContent() {
        return otherContent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @param newOtherContent the new other content
     * @generated
     */
    public void setOtherContent( String newOtherContent ) {
        String oldOtherContent = otherContent;
        otherContent = newOtherContent;
        if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.EMBEDDED_VALUE__OTHER_CONTENT,
            oldOtherContent,
            otherContent ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet( int featureID, boolean resolve, boolean coreType ) {
        switch (featureID) {
        case ErfPackage.EMBEDDED_VALUE__KEY:
            return getKey();
        case ErfPackage.EMBEDDED_VALUE__OTHER_CONTENT:
            return getOtherContent();
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
        case ErfPackage.EMBEDDED_VALUE__KEY:
            setKey( (Integer)newValue );
            return;
        case ErfPackage.EMBEDDED_VALUE__OTHER_CONTENT:
            setOtherContent( (String)newValue );
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
        case ErfPackage.EMBEDDED_VALUE__KEY:
            setKey( KEY_EDEFAULT );
            return;
        case ErfPackage.EMBEDDED_VALUE__OTHER_CONTENT:
            setOtherContent( OTHER_CONTENT_EDEFAULT );
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
        case ErfPackage.EMBEDDED_VALUE__KEY:
            return key != KEY_EDEFAULT;
        case ErfPackage.EMBEDDED_VALUE__OTHER_CONTENT:
            return OTHER_CONTENT_EDEFAULT == null
                ? otherContent != null
                : !OTHER_CONTENT_EDEFAULT.equals( otherContent );
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
        result.append( " (key: " );
        result.append( key );
        result.append( ", otherContent: " );
        result.append( otherContent );
        result.append( ')' );
        return result.toString();
    }

} //EmbeddedValueImpl
