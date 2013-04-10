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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import era.foss.erf.AttributeDefinition;
import era.foss.erf.DatatypeDefinition;
import era.foss.erf.ErfPackage;
import era.foss.erf.SpecType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Attribute Definition</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link era.foss.erf.impl.AttributeDefinitionImpl#getType <em>Type</em>}</li>
 *   <li>{@link era.foss.erf.impl.AttributeDefinitionImpl#isIdent <em>Ident</em>}</li>
 *   <li>{@link era.foss.erf.impl.AttributeDefinitionImpl#isUnique <em>Unique</em>}</li>
 *   <li>{@link era.foss.erf.impl.AttributeDefinitionImpl#getSpecType <em>Spec Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AttributeDefinitionImpl extends IdentifiableImpl implements AttributeDefinition {

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getType()
     * @generated
     * @ordered
     */
    protected DatatypeDefinition type;

    /**
     * The default value of the '{@link #isIdent() <em>Ident</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #isIdent()
     * @generated
     * @ordered
     */
    protected static final boolean IDENT_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIdent() <em>Ident</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #isIdent()
     * @generated
     * @ordered
     */
    protected boolean ident = IDENT_EDEFAULT;

    /**
     * The default value of the '{@link #isUnique() <em>Unique</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #isUnique()
     * @generated
     * @ordered
     */
    protected static final boolean UNIQUE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isUnique() <em>Unique</em>}' attribute.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #isUnique()
     * @generated
     * @ordered
     */
    protected boolean unique = UNIQUE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected AttributeDefinitionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErfPackage.Literals.ATTRIBUTE_DEFINITION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the type
     * @generated
     */
    public DatatypeDefinition getType() {
        if( type != null && type.eIsProxy() ) {
            InternalEObject oldType = (InternalEObject)type;
            type = (DatatypeDefinition)eResolveProxy( oldType );
            if( type != oldType ) {
                if( eNotificationRequired() ) eNotify( new ENotificationImpl(
                    this,
                    Notification.RESOLVE,
                    ErfPackage.ATTRIBUTE_DEFINITION__TYPE,
                    oldType,
                    type ) );
            }
        }
        return type;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the datatype definition
     * @generated
     */
    public DatatypeDefinition basicGetType() {
        return type;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param newType the new type
     * @param msgs the msgs
     * @return the notification chain
     * @generated
     */
    public NotificationChain basicSetType( DatatypeDefinition newType, NotificationChain msgs ) {
        DatatypeDefinition oldType = type;
        type = newType;
        if( eNotificationRequired() ) {
            ENotificationImpl notification = new ENotificationImpl(
                this,
                Notification.SET,
                ErfPackage.ATTRIBUTE_DEFINITION__TYPE,
                oldType,
                newType );
            if( msgs == null ) msgs = notification;
            else msgs.add( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param newType the new type
     * @generated
     */
    public void setType( DatatypeDefinition newType ) {
        if( newType != type ) {
            NotificationChain msgs = null;
            if( type != null ) msgs = ((InternalEObject)type).eInverseRemove( this,
                                                                              ErfPackage.DATATYPE_DEFINITION__ATTRIBUTE_DEFINITIONS,
                                                                              DatatypeDefinition.class,
                                                                              msgs );
            if( newType != null ) msgs = ((InternalEObject)newType).eInverseAdd( this,
                                                                                 ErfPackage.DATATYPE_DEFINITION__ATTRIBUTE_DEFINITIONS,
                                                                                 DatatypeDefinition.class,
                                                                                 msgs );
            msgs = basicSetType( newType, msgs );
            if( msgs != null ) msgs.dispatch();
        } else if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.ATTRIBUTE_DEFINITION__TYPE,
            newType,
            newType ) );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return true, if is ident
     * @generated
     */
    public boolean isIdent() {
        return ident;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param newIdent the new ident
     * @generated
     */
    public void setIdent( boolean newIdent ) {
        boolean oldIdent = ident;
        ident = newIdent;
        if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.ATTRIBUTE_DEFINITION__IDENT,
            oldIdent,
            ident ) );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return true, if is unique
     * @generated
     */
    public boolean isUnique() {
        return unique;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param newUnique the new unique
     * @generated
     */
    public void setUnique( boolean newUnique ) {
        boolean oldUnique = unique;
        unique = newUnique;
        if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.ATTRIBUTE_DEFINITION__UNIQUE,
            oldUnique,
            unique ) );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @return the spec type
     * @generated
     */
    public SpecType getSpecType() {
        if( eContainerFeatureID() != ErfPackage.ATTRIBUTE_DEFINITION__SPEC_TYPE ) return null;
        return (SpecType)eContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param newSpecType the new spec type
     * @param msgs the msgs
     * @return the notification chain
     * @generated
     */
    public NotificationChain basicSetSpecType( SpecType newSpecType, NotificationChain msgs ) {
        msgs = eBasicSetContainer( (InternalEObject)newSpecType, ErfPackage.ATTRIBUTE_DEFINITION__SPEC_TYPE, msgs );
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->.
     *
     * @param newSpecType the new spec type
     * @generated
     */
    public void setSpecType( SpecType newSpecType ) {
        if( newSpecType != eInternalContainer()
            || (eContainerFeatureID() != ErfPackage.ATTRIBUTE_DEFINITION__SPEC_TYPE && newSpecType != null) ) {
            if( EcoreUtil.isAncestor( this, newSpecType ) ) throw new IllegalArgumentException(
                "Recursive containment not allowed for " + toString() );
            NotificationChain msgs = null;
            if( eInternalContainer() != null ) msgs = eBasicRemoveFromContainer( msgs );
            if( newSpecType != null ) msgs = ((InternalEObject)newSpecType).eInverseAdd( this,
                                                                                         ErfPackage.SPEC_TYPE__SPEC_ATTRIBUTES,
                                                                                         SpecType.class,
                                                                                         msgs );
            msgs = basicSetSpecType( newSpecType, msgs );
            if( msgs != null ) msgs.dispatch();
        } else if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.ATTRIBUTE_DEFINITION__SPEC_TYPE,
            newSpecType,
            newSpecType ) );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd( InternalEObject otherEnd, int featureID, NotificationChain msgs ) {
        switch (featureID) {
        case ErfPackage.ATTRIBUTE_DEFINITION__TYPE:
            if( type != null ) msgs = ((InternalEObject)type).eInverseRemove( this,
                                                                              ErfPackage.DATATYPE_DEFINITION__ATTRIBUTE_DEFINITIONS,
                                                                              DatatypeDefinition.class,
                                                                              msgs );
            return basicSetType( (DatatypeDefinition)otherEnd, msgs );
        case ErfPackage.ATTRIBUTE_DEFINITION__SPEC_TYPE:
            if( eInternalContainer() != null ) msgs = eBasicRemoveFromContainer( msgs );
            return basicSetSpecType( (SpecType)otherEnd, msgs );
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
        case ErfPackage.ATTRIBUTE_DEFINITION__TYPE:
            return basicSetType( null, msgs );
        case ErfPackage.ATTRIBUTE_DEFINITION__SPEC_TYPE:
            return basicSetSpecType( null, msgs );
        }
        return super.eInverseRemove( otherEnd, featureID, msgs );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature( NotificationChain msgs ) {
        switch (eContainerFeatureID()) {
        case ErfPackage.ATTRIBUTE_DEFINITION__SPEC_TYPE:
            return eInternalContainer().eInverseRemove( this,
                                                        ErfPackage.SPEC_TYPE__SPEC_ATTRIBUTES,
                                                        SpecType.class,
                                                        msgs );
        }
        return super.eBasicRemoveFromContainerFeature( msgs );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet( int featureID, boolean resolve, boolean coreType ) {
        switch (featureID) {
        case ErfPackage.ATTRIBUTE_DEFINITION__TYPE:
            if( resolve ) return getType();
            return basicGetType();
        case ErfPackage.ATTRIBUTE_DEFINITION__IDENT:
            return isIdent();
        case ErfPackage.ATTRIBUTE_DEFINITION__UNIQUE:
            return isUnique();
        case ErfPackage.ATTRIBUTE_DEFINITION__SPEC_TYPE:
            return getSpecType();
        }
        return super.eGet( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet( int featureID, Object newValue ) {
        switch (featureID) {
        case ErfPackage.ATTRIBUTE_DEFINITION__TYPE:
            setType( (DatatypeDefinition)newValue );
            return;
        case ErfPackage.ATTRIBUTE_DEFINITION__IDENT:
            setIdent( (Boolean)newValue );
            return;
        case ErfPackage.ATTRIBUTE_DEFINITION__UNIQUE:
            setUnique( (Boolean)newValue );
            return;
        case ErfPackage.ATTRIBUTE_DEFINITION__SPEC_TYPE:
            setSpecType( (SpecType)newValue );
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
        case ErfPackage.ATTRIBUTE_DEFINITION__TYPE:
            setType( (DatatypeDefinition)null );
            return;
        case ErfPackage.ATTRIBUTE_DEFINITION__IDENT:
            setIdent( IDENT_EDEFAULT );
            return;
        case ErfPackage.ATTRIBUTE_DEFINITION__UNIQUE:
            setUnique( UNIQUE_EDEFAULT );
            return;
        case ErfPackage.ATTRIBUTE_DEFINITION__SPEC_TYPE:
            setSpecType( (SpecType)null );
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
        case ErfPackage.ATTRIBUTE_DEFINITION__TYPE:
            return type != null;
        case ErfPackage.ATTRIBUTE_DEFINITION__IDENT:
            return ident != IDENT_EDEFAULT;
        case ErfPackage.ATTRIBUTE_DEFINITION__UNIQUE:
            return unique != UNIQUE_EDEFAULT;
        case ErfPackage.ATTRIBUTE_DEFINITION__SPEC_TYPE:
            return getSpecType() != null;
        }
        return super.eIsSet( featureID );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if( eIsProxy() ) return super.toString();

        StringBuffer result = new StringBuffer( super.toString() );
        result.append( " (ident: " );
        result.append( ident );
        result.append( ", unique: " );
        result.append( unique );
        result.append( ')' );
        return result.toString();
    }

} // AttributeDefinitionImpl
