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
import era.foss.erf.SpecHierarchy;
import era.foss.erf.SpecObject;
import era.foss.erf.Specification;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Spec Hierarchy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link era.foss.erf.impl.SpecHierarchyImpl#isTableInternal <em>Table Internal</em>}</li>
 *   <li>{@link era.foss.erf.impl.SpecHierarchyImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link era.foss.erf.impl.SpecHierarchyImpl#getObject <em>Object</em>}</li>
 *   <li>{@link era.foss.erf.impl.SpecHierarchyImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link era.foss.erf.impl.SpecHierarchyImpl#getRoot <em>Root</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecHierarchyImpl extends AccessControlledElementImpl implements SpecHierarchy {
    /**
     * The default value of the '{@link #isTableInternal() <em>Table Internal</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isTableInternal()
     * @generated
     * @ordered
     */
    protected static final boolean TABLE_INTERNAL_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isTableInternal() <em>Table Internal</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isTableInternal()
     * @generated
     * @ordered
     */
    protected boolean tableInternal = TABLE_INTERNAL_EDEFAULT;

    /**
     * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getChildren()
     * @generated
     * @ordered
     */
    protected EList<SpecHierarchy> children;

    /**
     * The cached value of the '{@link #getObject() <em>Object</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getObject()
     * @generated
     * @ordered
     */
    protected SpecObject object;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SpecHierarchyImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErfPackage.Literals.SPEC_HIERARCHY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isTableInternal() {
        return tableInternal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTableInternal( boolean newTableInternal ) {
        boolean oldTableInternal = tableInternal;
        tableInternal = newTableInternal;
        if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.SPEC_HIERARCHY__TABLE_INTERNAL,
            oldTableInternal,
            tableInternal ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<SpecHierarchy> getChildren() {
        if( children == null ) {
            children = new EObjectContainmentWithInverseEList<SpecHierarchy>(
                SpecHierarchy.class,
                this,
                ErfPackage.SPEC_HIERARCHY__CHILDREN,
                ErfPackage.SPEC_HIERARCHY__PARENT );
        }
        return children;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SpecObject getObject() {
        if( object != null && object.eIsProxy() ) {
            InternalEObject oldObject = (InternalEObject)object;
            object = (SpecObject)eResolveProxy( oldObject );
            if( object != oldObject ) {
                if( eNotificationRequired() ) eNotify( new ENotificationImpl(
                    this,
                    Notification.RESOLVE,
                    ErfPackage.SPEC_HIERARCHY__OBJECT,
                    oldObject,
                    object ) );
            }
        }
        return object;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SpecObject basicGetObject() {
        return object;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetObject( SpecObject newObject, NotificationChain msgs ) {
        SpecObject oldObject = object;
        object = newObject;
        if( eNotificationRequired() ) {
            ENotificationImpl notification = new ENotificationImpl(
                this,
                Notification.SET,
                ErfPackage.SPEC_HIERARCHY__OBJECT,
                oldObject,
                newObject );
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
    public void setObject( SpecObject newObject ) {
        if( newObject != object ) {
            NotificationChain msgs = null;
            if( object != null ) msgs = ((InternalEObject)object).eInverseRemove( this,
                                                                                  ErfPackage.SPEC_OBJECT__SPEC_HIERARCHY,
                                                                                  SpecObject.class,
                                                                                  msgs );
            if( newObject != null ) msgs = ((InternalEObject)newObject).eInverseAdd( this,
                                                                                     ErfPackage.SPEC_OBJECT__SPEC_HIERARCHY,
                                                                                     SpecObject.class,
                                                                                     msgs );
            msgs = basicSetObject( newObject, msgs );
            if( msgs != null ) msgs.dispatch();
        } else if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.SPEC_HIERARCHY__OBJECT,
            newObject,
            newObject ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SpecHierarchy getParent() {
        if( eContainerFeatureID() != ErfPackage.SPEC_HIERARCHY__PARENT ) return null;
        return (SpecHierarchy)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetParent( SpecHierarchy newParent, NotificationChain msgs ) {
        msgs = eBasicSetContainer( (InternalEObject)newParent, ErfPackage.SPEC_HIERARCHY__PARENT, msgs );
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParent( SpecHierarchy newParent ) {
        if( newParent != eInternalContainer()
            || (eContainerFeatureID() != ErfPackage.SPEC_HIERARCHY__PARENT && newParent != null) ) {
            if( EcoreUtil.isAncestor( this, newParent ) ) throw new IllegalArgumentException(
                "Recursive containment not allowed for " + toString() );
            NotificationChain msgs = null;
            if( eInternalContainer() != null ) msgs = eBasicRemoveFromContainer( msgs );
            if( newParent != null ) msgs = ((InternalEObject)newParent).eInverseAdd( this,
                                                                                     ErfPackage.SPEC_HIERARCHY__CHILDREN,
                                                                                     SpecHierarchy.class,
                                                                                     msgs );
            msgs = basicSetParent( newParent, msgs );
            if( msgs != null ) msgs.dispatch();
        } else if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.SPEC_HIERARCHY__PARENT,
            newParent,
            newParent ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Specification getRoot() {
        if( eContainerFeatureID() != ErfPackage.SPEC_HIERARCHY__ROOT ) return null;
        return (Specification)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetRoot( Specification newRoot, NotificationChain msgs ) {
        msgs = eBasicSetContainer( (InternalEObject)newRoot, ErfPackage.SPEC_HIERARCHY__ROOT, msgs );
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRoot( Specification newRoot ) {
        if( newRoot != eInternalContainer()
            || (eContainerFeatureID() != ErfPackage.SPEC_HIERARCHY__ROOT && newRoot != null) ) {
            if( EcoreUtil.isAncestor( this, newRoot ) ) throw new IllegalArgumentException(
                "Recursive containment not allowed for " + toString() );
            NotificationChain msgs = null;
            if( eInternalContainer() != null ) msgs = eBasicRemoveFromContainer( msgs );
            if( newRoot != null ) msgs = ((InternalEObject)newRoot).eInverseAdd( this,
                                                                                 ErfPackage.SPECIFICATION__CHILDREN,
                                                                                 Specification.class,
                                                                                 msgs );
            msgs = basicSetRoot( newRoot, msgs );
            if( msgs != null ) msgs.dispatch();
        } else if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.SPEC_HIERARCHY__ROOT,
            newRoot,
            newRoot ) );
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
        case ErfPackage.SPEC_HIERARCHY__CHILDREN:
            return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd( otherEnd, msgs );
        case ErfPackage.SPEC_HIERARCHY__OBJECT:
            if( object != null ) msgs = ((InternalEObject)object).eInverseRemove( this,
                                                                                  ErfPackage.SPEC_OBJECT__SPEC_HIERARCHY,
                                                                                  SpecObject.class,
                                                                                  msgs );
            return basicSetObject( (SpecObject)otherEnd, msgs );
        case ErfPackage.SPEC_HIERARCHY__PARENT:
            if( eInternalContainer() != null ) msgs = eBasicRemoveFromContainer( msgs );
            return basicSetParent( (SpecHierarchy)otherEnd, msgs );
        case ErfPackage.SPEC_HIERARCHY__ROOT:
            if( eInternalContainer() != null ) msgs = eBasicRemoveFromContainer( msgs );
            return basicSetRoot( (Specification)otherEnd, msgs );
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
        case ErfPackage.SPEC_HIERARCHY__CHILDREN:
            return ((InternalEList<?>)getChildren()).basicRemove( otherEnd, msgs );
        case ErfPackage.SPEC_HIERARCHY__OBJECT:
            return basicSetObject( null, msgs );
        case ErfPackage.SPEC_HIERARCHY__PARENT:
            return basicSetParent( null, msgs );
        case ErfPackage.SPEC_HIERARCHY__ROOT:
            return basicSetRoot( null, msgs );
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
        case ErfPackage.SPEC_HIERARCHY__PARENT:
            return eInternalContainer().eInverseRemove( this,
                                                        ErfPackage.SPEC_HIERARCHY__CHILDREN,
                                                        SpecHierarchy.class,
                                                        msgs );
        case ErfPackage.SPEC_HIERARCHY__ROOT:
            return eInternalContainer().eInverseRemove( this,
                                                        ErfPackage.SPECIFICATION__CHILDREN,
                                                        Specification.class,
                                                        msgs );
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
        case ErfPackage.SPEC_HIERARCHY__TABLE_INTERNAL:
            return isTableInternal();
        case ErfPackage.SPEC_HIERARCHY__CHILDREN:
            return getChildren();
        case ErfPackage.SPEC_HIERARCHY__OBJECT:
            if( resolve ) return getObject();
            return basicGetObject();
        case ErfPackage.SPEC_HIERARCHY__PARENT:
            return getParent();
        case ErfPackage.SPEC_HIERARCHY__ROOT:
            return getRoot();
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
        case ErfPackage.SPEC_HIERARCHY__TABLE_INTERNAL:
            setTableInternal( (Boolean)newValue );
            return;
        case ErfPackage.SPEC_HIERARCHY__CHILDREN:
            getChildren().clear();
            getChildren().addAll( (Collection<? extends SpecHierarchy>)newValue );
            return;
        case ErfPackage.SPEC_HIERARCHY__OBJECT:
            setObject( (SpecObject)newValue );
            return;
        case ErfPackage.SPEC_HIERARCHY__PARENT:
            setParent( (SpecHierarchy)newValue );
            return;
        case ErfPackage.SPEC_HIERARCHY__ROOT:
            setRoot( (Specification)newValue );
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
        case ErfPackage.SPEC_HIERARCHY__TABLE_INTERNAL:
            setTableInternal( TABLE_INTERNAL_EDEFAULT );
            return;
        case ErfPackage.SPEC_HIERARCHY__CHILDREN:
            getChildren().clear();
            return;
        case ErfPackage.SPEC_HIERARCHY__OBJECT:
            setObject( (SpecObject)null );
            return;
        case ErfPackage.SPEC_HIERARCHY__PARENT:
            setParent( (SpecHierarchy)null );
            return;
        case ErfPackage.SPEC_HIERARCHY__ROOT:
            setRoot( (Specification)null );
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
        case ErfPackage.SPEC_HIERARCHY__TABLE_INTERNAL:
            return tableInternal != TABLE_INTERNAL_EDEFAULT;
        case ErfPackage.SPEC_HIERARCHY__CHILDREN:
            return children != null && !children.isEmpty();
        case ErfPackage.SPEC_HIERARCHY__OBJECT:
            return object != null;
        case ErfPackage.SPEC_HIERARCHY__PARENT:
            return getParent() != null;
        case ErfPackage.SPEC_HIERARCHY__ROOT:
            return getRoot() != null;
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
        result.append( " (tableInternal: " );
        result.append( tableInternal );
        result.append( ')' );
        return result.toString();
    }

} //SpecHierarchyImpl
