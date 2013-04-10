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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import era.foss.erf.AttributeDefinition;
import era.foss.erf.ErfPackage;
import era.foss.erf.SpecType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Spec Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link era.foss.erf.impl.SpecTypeImpl#getSpecAttributes <em>Spec Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecTypeImpl extends IdentifiableImpl implements SpecType {

    /**
     * The cached value of the '{@link #getSpecAttributes() <em>Spec Attributes</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSpecAttributes()
     * @generated
     * @ordered
     */
    protected EList<AttributeDefinition> specAttributes;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected SpecTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErfPackage.Literals.SPEC_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the spec attributes
     * @generated
     */
    public EList<AttributeDefinition> getSpecAttributes() {
        if( specAttributes == null ) {
            specAttributes = new EObjectContainmentWithInverseEList<AttributeDefinition>(
                AttributeDefinition.class,
                this,
                ErfPackage.SPEC_TYPE__SPEC_ATTRIBUTES,
                ErfPackage.ATTRIBUTE_DEFINITION__SPEC_TYPE );
        }
        return specAttributes;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd( InternalEObject otherEnd, int featureID, NotificationChain msgs ) {
        switch (featureID) {
        case ErfPackage.SPEC_TYPE__SPEC_ATTRIBUTES:
            return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpecAttributes()).basicAdd( otherEnd, msgs );
        }
        return super.eInverseAdd( otherEnd, featureID, msgs );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove( InternalEObject otherEnd, int featureID, NotificationChain msgs ) {
        switch (featureID) {
        case ErfPackage.SPEC_TYPE__SPEC_ATTRIBUTES:
            return ((InternalEList<?>)getSpecAttributes()).basicRemove( otherEnd, msgs );
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
        case ErfPackage.SPEC_TYPE__SPEC_ATTRIBUTES:
            return getSpecAttributes();
        }
        return super.eGet( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet( int featureID, Object newValue ) {
        switch (featureID) {
        case ErfPackage.SPEC_TYPE__SPEC_ATTRIBUTES:
            getSpecAttributes().clear();
            getSpecAttributes().addAll( (Collection<? extends AttributeDefinition>)newValue );
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
        case ErfPackage.SPEC_TYPE__SPEC_ATTRIBUTES:
            getSpecAttributes().clear();
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
        case ErfPackage.SPEC_TYPE__SPEC_ATTRIBUTES:
            return specAttributes != null && !specAttributes.isEmpty();
        }
        return super.eIsSet( featureID );
    }

} // SpecTypeImpl
