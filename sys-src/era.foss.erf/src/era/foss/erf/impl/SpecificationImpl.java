/**
 */
package era.foss.erf.impl;

import era.foss.erf.Content;
import era.foss.erf.ErfPackage;
import era.foss.erf.SpecHierarchy;
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
 * An implementation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link era.foss.erf.impl.SpecificationImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link era.foss.erf.impl.SpecificationImpl#getCoreContent <em>Core Content</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecificationImpl extends SpecElementWithUserDefinedAttributesImpl implements Specification {
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SpecificationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErfPackage.Literals.SPECIFICATION;
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
                ErfPackage.SPECIFICATION__CHILDREN,
                ErfPackage.SPEC_HIERARCHY__ROOT );
        }
        return children;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Content getCoreContent() {
        if( eContainerFeatureID() != ErfPackage.SPECIFICATION__CORE_CONTENT ) return null;
        return (Content)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCoreContent( Content newCoreContent, NotificationChain msgs ) {
        msgs = eBasicSetContainer( (InternalEObject)newCoreContent, ErfPackage.SPECIFICATION__CORE_CONTENT, msgs );
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCoreContent( Content newCoreContent ) {
        if( newCoreContent != eInternalContainer()
            || (eContainerFeatureID() != ErfPackage.SPECIFICATION__CORE_CONTENT && newCoreContent != null) ) {
            if( EcoreUtil.isAncestor( this, newCoreContent ) ) throw new IllegalArgumentException(
                "Recursive containment not allowed for " + toString() );
            NotificationChain msgs = null;
            if( eInternalContainer() != null ) msgs = eBasicRemoveFromContainer( msgs );
            if( newCoreContent != null ) msgs = ((InternalEObject)newCoreContent).eInverseAdd( this,
                                                                                               ErfPackage.CONTENT__SPECIFICATIONS,
                                                                                               Content.class,
                                                                                               msgs );
            msgs = basicSetCoreContent( newCoreContent, msgs );
            if( msgs != null ) msgs.dispatch();
        } else if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.SPECIFICATION__CORE_CONTENT,
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
        case ErfPackage.SPECIFICATION__CHILDREN:
            return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd( otherEnd, msgs );
        case ErfPackage.SPECIFICATION__CORE_CONTENT:
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
        case ErfPackage.SPECIFICATION__CHILDREN:
            return ((InternalEList<?>)getChildren()).basicRemove( otherEnd, msgs );
        case ErfPackage.SPECIFICATION__CORE_CONTENT:
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
        case ErfPackage.SPECIFICATION__CORE_CONTENT:
            return eInternalContainer().eInverseRemove( this, ErfPackage.CONTENT__SPECIFICATIONS, Content.class, msgs );
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
        case ErfPackage.SPECIFICATION__CHILDREN:
            return getChildren();
        case ErfPackage.SPECIFICATION__CORE_CONTENT:
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
        case ErfPackage.SPECIFICATION__CHILDREN:
            getChildren().clear();
            getChildren().addAll( (Collection<? extends SpecHierarchy>)newValue );
            return;
        case ErfPackage.SPECIFICATION__CORE_CONTENT:
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
        case ErfPackage.SPECIFICATION__CHILDREN:
            getChildren().clear();
            return;
        case ErfPackage.SPECIFICATION__CORE_CONTENT:
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
        case ErfPackage.SPECIFICATION__CHILDREN:
            return children != null && !children.isEmpty();
        case ErfPackage.SPECIFICATION__CORE_CONTENT:
            return getCoreContent() != null;
        }
        return super.eIsSet( featureID );
    }

} //SpecificationImpl
