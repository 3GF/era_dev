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

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import era.foss.erf.DatatypeDefinitionEnumeration;
import era.foss.erf.EnumValue;
import era.foss.erf.ErfPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Datatype Definition Enumeration</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link era.foss.erf.impl.DatatypeDefinitionEnumerationImpl#getSpecifiedValues <em>Specified Values</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DatatypeDefinitionEnumerationImpl extends DatatypeDefinitionImpl implements
        DatatypeDefinitionEnumeration {
    /**
     * The cached value of the '{@link #getSpecifiedValues() <em>Specified Values</em>}' reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSpecifiedValues()
     * @generated
     * @ordered
     */
    protected EList<EnumValue> specifiedValues;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DatatypeDefinitionEnumerationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErfPackage.Literals.DATATYPE_DEFINITION_ENUMERATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     * 
     * @return the specified values
     * @generated
     */
    public EList<EnumValue> getSpecifiedValues() {
        if( specifiedValues == null ) {
            specifiedValues = new EObjectResolvingEList<EnumValue>(
                EnumValue.class,
                this,
                ErfPackage.DATATYPE_DEFINITION_ENUMERATION__SPECIFIED_VALUES );
        }
        return specifiedValues;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
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

} // DatatypeDefinitionEnumerationImpl
