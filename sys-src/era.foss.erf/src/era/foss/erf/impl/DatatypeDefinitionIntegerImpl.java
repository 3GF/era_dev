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

import era.foss.erf.DatatypeDefinitionInteger;
import era.foss.erf.ErfPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Datatype Definition Integer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link era.foss.erf.impl.DatatypeDefinitionIntegerImpl#getMax <em>Max</em>}</li>
 *   <li>{@link era.foss.erf.impl.DatatypeDefinitionIntegerImpl#getMin <em>Min</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DatatypeDefinitionIntegerImpl extends DatatypeDefinitionSimpleImpl implements DatatypeDefinitionInteger {

    /**
     * The default value of the '{@link #getMax() <em>Max</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMax()
     * @generated
     * @ordered
     */
    protected static final Integer MAX_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMax() <em>Max</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMax()
     * @generated
     * @ordered
     */
    protected Integer max = MAX_EDEFAULT;

    /**
     * This is true if the Max attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean maxESet;

    /**
     * The default value of the '{@link #getMin() <em>Min</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMin()
     * @generated
     * @ordered
     */
    protected static final Integer MIN_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMin() <em>Min</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMin()
     * @generated
     * @ordered
     */
    protected Integer min = MIN_EDEFAULT;

    /**
     * This is true if the Min attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean minESet;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DatatypeDefinitionIntegerImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErfPackage.Literals.DATATYPE_DEFINITION_INTEGER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer getMax() {
        return max;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMax( Integer newMax ) {
        Integer oldMax = max;
        max = newMax;
        boolean oldMaxESet = maxESet;
        maxESet = true;
        if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.DATATYPE_DEFINITION_INTEGER__MAX,
            oldMax,
            max,
            !oldMaxESet ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetMax() {
        Integer oldMax = max;
        boolean oldMaxESet = maxESet;
        max = MAX_EDEFAULT;
        maxESet = false;
        if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.UNSET,
            ErfPackage.DATATYPE_DEFINITION_INTEGER__MAX,
            oldMax,
            MAX_EDEFAULT,
            oldMaxESet ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetMax() {
        return maxESet;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer getMin() {
        return min;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMin( Integer newMin ) {
        Integer oldMin = min;
        min = newMin;
        boolean oldMinESet = minESet;
        minESet = true;
        if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.DATATYPE_DEFINITION_INTEGER__MIN,
            oldMin,
            min,
            !oldMinESet ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetMin() {
        Integer oldMin = min;
        boolean oldMinESet = minESet;
        min = MIN_EDEFAULT;
        minESet = false;
        if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.UNSET,
            ErfPackage.DATATYPE_DEFINITION_INTEGER__MIN,
            oldMin,
            MIN_EDEFAULT,
            oldMinESet ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetMin() {
        return minESet;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet( int featureID, boolean resolve, boolean coreType ) {
        switch (featureID) {
        case ErfPackage.DATATYPE_DEFINITION_INTEGER__MAX:
            return getMax();
        case ErfPackage.DATATYPE_DEFINITION_INTEGER__MIN:
            return getMin();
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
        case ErfPackage.DATATYPE_DEFINITION_INTEGER__MAX:
            setMax( (Integer)newValue );
            return;
        case ErfPackage.DATATYPE_DEFINITION_INTEGER__MIN:
            setMin( (Integer)newValue );
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
        case ErfPackage.DATATYPE_DEFINITION_INTEGER__MAX:
            unsetMax();
            return;
        case ErfPackage.DATATYPE_DEFINITION_INTEGER__MIN:
            unsetMin();
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
        case ErfPackage.DATATYPE_DEFINITION_INTEGER__MAX:
            return isSetMax();
        case ErfPackage.DATATYPE_DEFINITION_INTEGER__MIN:
            return isSetMin();
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
        result.append( " (max: " );
        if( maxESet ) result.append( max );
        else result.append( "<unset>" );
        result.append( ", min: " );
        if( minESet ) result.append( min );
        else result.append( "<unset>" );
        result.append( ')' );
        return result.toString();
    }

} //DatatypeDefinitionIntegerImpl
