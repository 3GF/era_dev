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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Spec Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link era.foss.erf.impl.SpecRelationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link era.foss.erf.impl.SpecRelationImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecRelationImpl extends SpecElementWithUserDefinedAttributesImpl implements SpecRelation {
    /**
     * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSource()
     * @generated
     * @ordered
     */
    protected SpecObject source;

    /**
     * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTarget()
     * @generated
     * @ordered
     */
    protected SpecObject target;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SpecRelationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErfPackage.Literals.SPEC_RELATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the source
     * @generated
     */
    public SpecObject getSource() {
        if( source != null && source.eIsProxy() ) {
            InternalEObject oldSource = (InternalEObject)source;
            source = (SpecObject)eResolveProxy( oldSource );
            if( source != oldSource ) {
                if( eNotificationRequired() ) eNotify( new ENotificationImpl(
                    this,
                    Notification.RESOLVE,
                    ErfPackage.SPEC_RELATION__SOURCE,
                    oldSource,
                    source ) );
            }
        }
        return source;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the spec object
     * @generated
     */
    public SpecObject basicGetSource() {
        return source;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @param newSource the new source
     * @param msgs the msgs
     * @return the notification chain
     * @generated
     */
    public NotificationChain basicSetSource( SpecObject newSource, NotificationChain msgs ) {
        SpecObject oldSource = source;
        source = newSource;
        if( eNotificationRequired() ) {
            ENotificationImpl notification = new ENotificationImpl(
                this,
                Notification.SET,
                ErfPackage.SPEC_RELATION__SOURCE,
                oldSource,
                newSource );
            if( msgs == null ) msgs = notification;
            else msgs.add( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @param newSource the new source
     * @generated
     */
    public void setSource( SpecObject newSource ) {
        if( newSource != source ) {
            NotificationChain msgs = null;
            if( source != null ) msgs = ((InternalEObject)source).eInverseRemove( this,
                                                                                  ErfPackage.SPEC_OBJECT__TARGETS,
                                                                                  SpecObject.class,
                                                                                  msgs );
            if( newSource != null ) msgs = ((InternalEObject)newSource).eInverseAdd( this,
                                                                                     ErfPackage.SPEC_OBJECT__TARGETS,
                                                                                     SpecObject.class,
                                                                                     msgs );
            msgs = basicSetSource( newSource, msgs );
            if( msgs != null ) msgs.dispatch();
        } else if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.SPEC_RELATION__SOURCE,
            newSource,
            newSource ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the target
     * @generated
     */
    public SpecObject getTarget() {
        if( target != null && target.eIsProxy() ) {
            InternalEObject oldTarget = (InternalEObject)target;
            target = (SpecObject)eResolveProxy( oldTarget );
            if( target != oldTarget ) {
                if( eNotificationRequired() ) eNotify( new ENotificationImpl(
                    this,
                    Notification.RESOLVE,
                    ErfPackage.SPEC_RELATION__TARGET,
                    oldTarget,
                    target ) );
            }
        }
        return target;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the spec object
     * @generated
     */
    public SpecObject basicGetTarget() {
        return target;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @param newTarget the new target
     * @param msgs the msgs
     * @return the notification chain
     * @generated
     */
    public NotificationChain basicSetTarget( SpecObject newTarget, NotificationChain msgs ) {
        SpecObject oldTarget = target;
        target = newTarget;
        if( eNotificationRequired() ) {
            ENotificationImpl notification = new ENotificationImpl(
                this,
                Notification.SET,
                ErfPackage.SPEC_RELATION__TARGET,
                oldTarget,
                newTarget );
            if( msgs == null ) msgs = notification;
            else msgs.add( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @param newTarget the new target
     * @generated
     */
    public void setTarget( SpecObject newTarget ) {
        if( newTarget != target ) {
            NotificationChain msgs = null;
            if( target != null ) msgs = ((InternalEObject)target).eInverseRemove( this,
                                                                                  ErfPackage.SPEC_OBJECT__SOURCES,
                                                                                  SpecObject.class,
                                                                                  msgs );
            if( newTarget != null ) msgs = ((InternalEObject)newTarget).eInverseAdd( this,
                                                                                     ErfPackage.SPEC_OBJECT__SOURCES,
                                                                                     SpecObject.class,
                                                                                     msgs );
            msgs = basicSetTarget( newTarget, msgs );
            if( msgs != null ) msgs.dispatch();
        } else if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.SPEC_RELATION__TARGET,
            newTarget,
            newTarget ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd( InternalEObject otherEnd, int featureID, NotificationChain msgs ) {
        switch (featureID) {
        case ErfPackage.SPEC_RELATION__SOURCE:
            if( source != null ) msgs = ((InternalEObject)source).eInverseRemove( this,
                                                                                  ErfPackage.SPEC_OBJECT__TARGETS,
                                                                                  SpecObject.class,
                                                                                  msgs );
            return basicSetSource( (SpecObject)otherEnd, msgs );
        case ErfPackage.SPEC_RELATION__TARGET:
            if( target != null ) msgs = ((InternalEObject)target).eInverseRemove( this,
                                                                                  ErfPackage.SPEC_OBJECT__SOURCES,
                                                                                  SpecObject.class,
                                                                                  msgs );
            return basicSetTarget( (SpecObject)otherEnd, msgs );
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
        case ErfPackage.SPEC_RELATION__SOURCE:
            return basicSetSource( null, msgs );
        case ErfPackage.SPEC_RELATION__TARGET:
            return basicSetTarget( null, msgs );
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
        case ErfPackage.SPEC_RELATION__SOURCE:
            if( resolve ) return getSource();
            return basicGetSource();
        case ErfPackage.SPEC_RELATION__TARGET:
            if( resolve ) return getTarget();
            return basicGetTarget();
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
        case ErfPackage.SPEC_RELATION__SOURCE:
            setSource( (SpecObject)newValue );
            return;
        case ErfPackage.SPEC_RELATION__TARGET:
            setTarget( (SpecObject)newValue );
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
        case ErfPackage.SPEC_RELATION__SOURCE:
            setSource( (SpecObject)null );
            return;
        case ErfPackage.SPEC_RELATION__TARGET:
            setTarget( (SpecObject)null );
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
        case ErfPackage.SPEC_RELATION__SOURCE:
            return source != null;
        case ErfPackage.SPEC_RELATION__TARGET:
            return target != null;
        }
        return super.eIsSet( featureID );
    }

} //SpecRelationImpl
