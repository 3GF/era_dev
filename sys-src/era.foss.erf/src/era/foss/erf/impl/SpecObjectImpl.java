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

import era.foss.erf.Content;
import era.foss.erf.ErfPackage;
import era.foss.erf.SpecHierarchy;
import era.foss.erf.SpecObject;

import era.foss.erf.SpecRelation;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
 *   <li>{@link era.foss.erf.impl.SpecObjectImpl#getSpecHierarchy <em>Spec Hierarchy</em>}</li>
 *   <li>{@link era.foss.erf.impl.SpecObjectImpl#getCoreContent <em>Core Content</em>}</li>
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
     * The cached value of the '{@link #getSpecHierarchy() <em>Spec Hierarchy</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSpecHierarchy()
     * @generated
     * @ordered
     */
    protected SpecHierarchy specHierarchy;

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
    public SpecHierarchy getSpecHierarchy() {
        if( specHierarchy != null && specHierarchy.eIsProxy() ) {
            InternalEObject oldSpecHierarchy = (InternalEObject)specHierarchy;
            specHierarchy = (SpecHierarchy)eResolveProxy( oldSpecHierarchy );
            if( specHierarchy != oldSpecHierarchy ) {
                if( eNotificationRequired() ) eNotify( new ENotificationImpl(
                    this,
                    Notification.RESOLVE,
                    ErfPackage.SPEC_OBJECT__SPEC_HIERARCHY,
                    oldSpecHierarchy,
                    specHierarchy ) );
            }
        }
        return specHierarchy;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SpecHierarchy basicGetSpecHierarchy() {
        return specHierarchy;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSpecHierarchy( SpecHierarchy newSpecHierarchy, NotificationChain msgs ) {
        SpecHierarchy oldSpecHierarchy = specHierarchy;
        specHierarchy = newSpecHierarchy;
        if( eNotificationRequired() ) {
            ENotificationImpl notification = new ENotificationImpl(
                this,
                Notification.SET,
                ErfPackage.SPEC_OBJECT__SPEC_HIERARCHY,
                oldSpecHierarchy,
                newSpecHierarchy );
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
    public void setSpecHierarchy( SpecHierarchy newSpecHierarchy ) {
        if( newSpecHierarchy != specHierarchy ) {
            NotificationChain msgs = null;
            if( specHierarchy != null ) msgs = ((InternalEObject)specHierarchy).eInverseRemove( this,
                                                                                                ErfPackage.SPEC_HIERARCHY__OBJECT,
                                                                                                SpecHierarchy.class,
                                                                                                msgs );
            if( newSpecHierarchy != null ) msgs = ((InternalEObject)newSpecHierarchy).eInverseAdd( this,
                                                                                                   ErfPackage.SPEC_HIERARCHY__OBJECT,
                                                                                                   SpecHierarchy.class,
                                                                                                   msgs );
            msgs = basicSetSpecHierarchy( newSpecHierarchy, msgs );
            if( msgs != null ) msgs.dispatch();
        } else if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.SPEC_OBJECT__SPEC_HIERARCHY,
            newSpecHierarchy,
            newSpecHierarchy ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Content getCoreContent() {
        if( eContainerFeatureID() != ErfPackage.SPEC_OBJECT__CORE_CONTENT ) return null;
        return (Content)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCoreContent( Content newCoreContent, NotificationChain msgs ) {
        msgs = eBasicSetContainer( (InternalEObject)newCoreContent, ErfPackage.SPEC_OBJECT__CORE_CONTENT, msgs );
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCoreContent( Content newCoreContent ) {
        if( newCoreContent != eInternalContainer()
            || (eContainerFeatureID() != ErfPackage.SPEC_OBJECT__CORE_CONTENT && newCoreContent != null) ) {
            if( EcoreUtil.isAncestor( this, newCoreContent ) ) throw new IllegalArgumentException(
                "Recursive containment not allowed for " + toString() );
            NotificationChain msgs = null;
            if( eInternalContainer() != null ) msgs = eBasicRemoveFromContainer( msgs );
            if( newCoreContent != null ) msgs = ((InternalEObject)newCoreContent).eInverseAdd( this,
                                                                                               ErfPackage.CONTENT__SPEC_OBJECTS,
                                                                                               Content.class,
                                                                                               msgs );
            msgs = basicSetCoreContent( newCoreContent, msgs );
            if( msgs != null ) msgs.dispatch();
        } else if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.SPEC_OBJECT__CORE_CONTENT,
            newCoreContent,
            newCoreContent ) );
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
        case ErfPackage.SPEC_OBJECT__SPEC_HIERARCHY:
            if( specHierarchy != null ) msgs = ((InternalEObject)specHierarchy).eInverseRemove( this,
                                                                                                ErfPackage.SPEC_HIERARCHY__OBJECT,
                                                                                                SpecHierarchy.class,
                                                                                                msgs );
            return basicSetSpecHierarchy( (SpecHierarchy)otherEnd, msgs );
        case ErfPackage.SPEC_OBJECT__CORE_CONTENT:
            if( eInternalContainer() != null ) msgs = eBasicRemoveFromContainer( msgs );
            return basicSetCoreContent( (Content)otherEnd, msgs );
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
        case ErfPackage.SPEC_OBJECT__SPEC_HIERARCHY:
            return basicSetSpecHierarchy( null, msgs );
        case ErfPackage.SPEC_OBJECT__CORE_CONTENT:
            return basicSetCoreContent( null, msgs );
        }
        return super.eInverseRemove( otherEnd, featureID, msgs );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature( NotificationChain msgs ) {
        switch (eContainerFeatureID()) {
        case ErfPackage.SPEC_OBJECT__CORE_CONTENT:
            return eInternalContainer().eInverseRemove( this, ErfPackage.CONTENT__SPEC_OBJECTS, Content.class, msgs );
        }
        return super.eBasicRemoveFromContainerFeature( msgs );
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
        case ErfPackage.SPEC_OBJECT__SPEC_HIERARCHY:
            if( resolve ) return getSpecHierarchy();
            return basicGetSpecHierarchy();
        case ErfPackage.SPEC_OBJECT__CORE_CONTENT:
            return getCoreContent();
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
        case ErfPackage.SPEC_OBJECT__SPEC_HIERARCHY:
            setSpecHierarchy( (SpecHierarchy)newValue );
            return;
        case ErfPackage.SPEC_OBJECT__CORE_CONTENT:
            setCoreContent( (Content)newValue );
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
        case ErfPackage.SPEC_OBJECT__SPEC_HIERARCHY:
            setSpecHierarchy( (SpecHierarchy)null );
            return;
        case ErfPackage.SPEC_OBJECT__CORE_CONTENT:
            setCoreContent( (Content)null );
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
        case ErfPackage.SPEC_OBJECT__SPEC_HIERARCHY:
            return specHierarchy != null;
        case ErfPackage.SPEC_OBJECT__CORE_CONTENT:
            return getCoreContent() != null;
        }
        return super.eIsSet( featureID );
    }

} //SpecObjectImpl
