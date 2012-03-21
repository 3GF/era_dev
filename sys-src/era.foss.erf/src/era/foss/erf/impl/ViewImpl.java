/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package era.foss.erf.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import era.foss.erf.ErfPackage;
import era.foss.erf.View;
import era.foss.erf.ViewElement;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>View</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link era.foss.erf.impl.ViewImpl#getViewElements <em>View Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewImpl extends IdentifiableImpl implements View {
    /**
     * The cached value of the '{@link #getViewElements() <em>View Elements</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getViewElements()
     * @generated
     * @ordered
     */
    protected EList<ViewElement> viewElements;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected ViewImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErfPackage.Literals.VIEW;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<ViewElement> getViewElements() {
        if( viewElements == null ) {
            viewElements = new EObjectContainmentEList<ViewElement>(
                ViewElement.class,
                this,
                ErfPackage.VIEW__VIEW_ELEMENTS );
        }
        return viewElements;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove( InternalEObject otherEnd, int featureID, NotificationChain msgs ) {
        switch (featureID) {
        case ErfPackage.VIEW__VIEW_ELEMENTS:
            return ((InternalEList<?>)getViewElements()).basicRemove( otherEnd, msgs );
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
        case ErfPackage.VIEW__VIEW_ELEMENTS:
            return getViewElements();
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
        case ErfPackage.VIEW__VIEW_ELEMENTS:
            getViewElements().clear();
            getViewElements().addAll( (Collection<? extends ViewElement>)newValue );
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
        case ErfPackage.VIEW__VIEW_ELEMENTS:
            getViewElements().clear();
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
        case ErfPackage.VIEW__VIEW_ELEMENTS:
            return viewElements != null && !viewElements.isEmpty();
        }
        return super.eIsSet( featureID );
    }

} // ViewImpl
