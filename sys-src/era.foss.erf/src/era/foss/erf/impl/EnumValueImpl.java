/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package era.foss.erf.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import era.foss.erf.Color;
import era.foss.erf.EmbeddedValue;
import era.foss.erf.EnumValue;
import era.foss.erf.ErfPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Enum Value</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link era.foss.erf.impl.EnumValueImpl#getProperties <em>Properties</em>}</li>
 * <li>{@link era.foss.erf.impl.EnumValueImpl#getColor <em>Color</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EnumValueImpl extends IdentifiableImpl implements EnumValue {
    /**
     * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getProperties()
     * @generated
     * @ordered
     */
    protected EmbeddedValue properties;

    /**
     * The cached value of the '{@link #getColor() <em>Color</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getColor()
     * @generated
     * @ordered
     */
    protected Color color;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @not generated
     */
    protected EnumValueImpl() {
        super();
        this.properties = new EmbeddedValueImpl();
        this.color = new ColorImpl();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErfPackage.Literals.ENUM_VALUE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EmbeddedValue getProperties() {
        return properties;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetProperties( EmbeddedValue newProperties, NotificationChain msgs ) {
        EmbeddedValue oldProperties = properties;
        properties = newProperties;
        if( eNotificationRequired() ) {
            ENotificationImpl notification = new ENotificationImpl(
                this,
                Notification.SET,
                ErfPackage.ENUM_VALUE__PROPERTIES,
                oldProperties,
                newProperties );
            if( msgs == null ) msgs = notification;
            else msgs.add( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setProperties( EmbeddedValue newProperties ) {
        if( newProperties != properties ) {
            NotificationChain msgs = null;
            if( properties != null ) msgs = ((InternalEObject)properties).eInverseRemove( this,
                                                                                          EOPPOSITE_FEATURE_BASE
                                                                                              - ErfPackage.ENUM_VALUE__PROPERTIES,
                                                                                          null,
                                                                                          msgs );
            if( newProperties != null ) msgs = ((InternalEObject)newProperties).eInverseAdd( this,
                                                                                             EOPPOSITE_FEATURE_BASE
                                                                                                 - ErfPackage.ENUM_VALUE__PROPERTIES,
                                                                                             null,
                                                                                             msgs );
            msgs = basicSetProperties( newProperties, msgs );
            if( msgs != null ) msgs.dispatch();
        } else if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.ENUM_VALUE__PROPERTIES,
            newProperties,
            newProperties ) );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public Color getColor() {
        return color;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetColor( Color newColor, NotificationChain msgs ) {
        Color oldColor = color;
        color = newColor;
        if( eNotificationRequired() ) {
            ENotificationImpl notification = new ENotificationImpl(
                this,
                Notification.SET,
                ErfPackage.ENUM_VALUE__COLOR,
                oldColor,
                newColor );
            if( msgs == null ) msgs = notification;
            else msgs.add( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setColor( Color newColor ) {
        if( newColor != color ) {
            NotificationChain msgs = null;
            if( color != null ) msgs = ((InternalEObject)color).eInverseRemove( this, EOPPOSITE_FEATURE_BASE
                - ErfPackage.ENUM_VALUE__COLOR, null, msgs );
            if( newColor != null ) msgs = ((InternalEObject)newColor).eInverseAdd( this, EOPPOSITE_FEATURE_BASE
                - ErfPackage.ENUM_VALUE__COLOR, null, msgs );
            msgs = basicSetColor( newColor, msgs );
            if( msgs != null ) msgs.dispatch();
        } else if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.ENUM_VALUE__COLOR,
            newColor,
            newColor ) );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove( InternalEObject otherEnd, int featureID, NotificationChain msgs ) {
        switch (featureID) {
        case ErfPackage.ENUM_VALUE__PROPERTIES:
            return basicSetProperties( null, msgs );
        case ErfPackage.ENUM_VALUE__COLOR:
            return basicSetColor( null, msgs );
        }
        return super.eInverseRemove( otherEnd, featureID, msgs );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet( int featureID, boolean resolve, boolean coreType ) {
        switch (featureID) {
        case ErfPackage.ENUM_VALUE__PROPERTIES:
            return getProperties();
        case ErfPackage.ENUM_VALUE__COLOR:
            return getColor();
        }
        return super.eGet( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet( int featureID, Object newValue ) {
        switch (featureID) {
        case ErfPackage.ENUM_VALUE__PROPERTIES:
            setProperties( (EmbeddedValue)newValue );
            return;
        case ErfPackage.ENUM_VALUE__COLOR:
            setColor( (Color)newValue );
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
        case ErfPackage.ENUM_VALUE__PROPERTIES:
            setProperties( (EmbeddedValue)null );
            return;
        case ErfPackage.ENUM_VALUE__COLOR:
            setColor( (Color)null );
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
        case ErfPackage.ENUM_VALUE__PROPERTIES:
            return properties != null;
        case ErfPackage.ENUM_VALUE__COLOR:
            return color != null;
        }
        return super.eIsSet( featureID );
    }

} // EnumValueImpl
