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

import era.foss.erf.ErfPackage;
import era.foss.erf.SpecObject;

import era.foss.erf.SpecRelation;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Spec Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link era.foss.erf.impl.SpecObjectImpl#getSources <em>Sources</em>}</li>
 *   <li>{@link era.foss.erf.impl.SpecObjectImpl#getTargets <em>Targets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecObjectImpl extends SpecElementWithUserDefinedAttributesImpl implements SpecObject {

    /**
     * The cached value of the '{@link #getSources() <em>Sources</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSources()
     * @generated
     * @ordered
     */
    protected EList<SpecRelation> sources;
    /**
     * The cached value of the '{@link #getTargets() <em>Targets</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargets()
     * @generated
     * @ordered
     */
    protected EList<SpecRelation> targets;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SpecObjectImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErfPackage.Literals.SPEC_OBJECT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the sources
     * @generated
     */
    public EList<SpecRelation> getSources() {
        if( sources == null ) {
            sources = new EObjectWithInverseResolvingEList<SpecRelation>(
                SpecRelation.class,
                this,
                ErfPackage.SPEC_OBJECT__SOURCES,
                ErfPackage.SPEC_RELATION__TARGET );
        }
        return sources;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the targets
     * @generated
     */
    public EList<SpecRelation> getTargets() {
        if( targets == null ) {
            targets = new EObjectWithInverseResolvingEList<SpecRelation>(
                SpecRelation.class,
                this,
                ErfPackage.SPEC_OBJECT__TARGETS,
                ErfPackage.SPEC_RELATION__SOURCE );
        }
        return targets;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd( InternalEObject otherEnd, int featureID, NotificationChain msgs ) {
        switch (featureID) {
        case ErfPackage.SPEC_OBJECT__SOURCES:
            return ((InternalEList<InternalEObject>)(InternalEList<?>)getSources()).basicAdd( otherEnd, msgs );
        case ErfPackage.SPEC_OBJECT__TARGETS:
            return ((InternalEList<InternalEObject>)(InternalEList<?>)getTargets()).basicAdd( otherEnd, msgs );
        }
        return super.eInverseAdd( otherEnd, featureID, msgs );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove( InternalEObject otherEnd, int featureID, NotificationChain msgs ) {
        switch (featureID) {
        case ErfPackage.SPEC_OBJECT__SOURCES:
            return ((InternalEList<?>)getSources()).basicRemove( otherEnd, msgs );
        case ErfPackage.SPEC_OBJECT__TARGETS:
            return ((InternalEList<?>)getTargets()).basicRemove( otherEnd, msgs );
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
        case ErfPackage.SPEC_OBJECT__SOURCES:
            return getSources();
        case ErfPackage.SPEC_OBJECT__TARGETS:
            return getTargets();
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
        case ErfPackage.SPEC_OBJECT__SOURCES:
            getSources().clear();
            getSources().addAll( (Collection<? extends SpecRelation>)newValue );
            return;
        case ErfPackage.SPEC_OBJECT__TARGETS:
            getTargets().clear();
            getTargets().addAll( (Collection<? extends SpecRelation>)newValue );
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
        case ErfPackage.SPEC_OBJECT__SOURCES:
            getSources().clear();
            return;
        case ErfPackage.SPEC_OBJECT__TARGETS:
            getTargets().clear();
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
        case ErfPackage.SPEC_OBJECT__SOURCES:
            return sources != null && !sources.isEmpty();
        case ErfPackage.SPEC_OBJECT__TARGETS:
            return targets != null && !targets.isEmpty();
        }
        return super.eIsSet( featureID );
    }

} //SpecObjectImpl
