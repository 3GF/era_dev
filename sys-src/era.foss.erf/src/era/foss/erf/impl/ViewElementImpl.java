/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package era.foss.erf.impl;

import era.foss.erf.AttributeDefinition;
import era.foss.erf.ErfPackage;
import era.foss.erf.ViewElement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link era.foss.erf.impl.ViewElementImpl#isEditorShowLabel <em>Editor Show Label</em>}</li>
 *   <li>{@link era.foss.erf.impl.ViewElementImpl#getEditorRowNumber <em>Editor Row Number</em>}</li>
 *   <li>{@link era.foss.erf.impl.ViewElementImpl#getEditorColumnSpan <em>Editor Column Span</em>}</li>
 *   <li>{@link era.foss.erf.impl.ViewElementImpl#getAttributeDefinition <em>Attribute Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewElementImpl extends EObjectImpl implements ViewElement {
    /**
     * The default value of the '{@link #isEditorShowLabel() <em>Editor Show Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEditorShowLabel()
     * @generated
     * @ordered
     */
    protected static final boolean EDITOR_SHOW_LABEL_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isEditorShowLabel() <em>Editor Show Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEditorShowLabel()
     * @generated
     * @ordered
     */
    protected boolean editorShowLabel = EDITOR_SHOW_LABEL_EDEFAULT;

    /**
     * The default value of the '{@link #getEditorRowNumber() <em>Editor Row Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEditorRowNumber()
     * @generated
     * @ordered
     */
    protected static final int EDITOR_ROW_NUMBER_EDEFAULT = 1;

    /**
     * The cached value of the '{@link #getEditorRowNumber() <em>Editor Row Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEditorRowNumber()
     * @generated
     * @ordered
     */
    protected int editorRowNumber = EDITOR_ROW_NUMBER_EDEFAULT;

    /**
     * The default value of the '{@link #getEditorColumnSpan() <em>Editor Column Span</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEditorColumnSpan()
     * @generated
     * @ordered
     */
    protected static final int EDITOR_COLUMN_SPAN_EDEFAULT = 1;

    /**
     * The cached value of the '{@link #getEditorColumnSpan() <em>Editor Column Span</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEditorColumnSpan()
     * @generated
     * @ordered
     */
    protected int editorColumnSpan = EDITOR_COLUMN_SPAN_EDEFAULT;

    /**
     * The cached value of the '{@link #getAttributeDefinition() <em>Attribute Definition</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAttributeDefinition()
     * @generated
     * @ordered
     */
    protected AttributeDefinition attributeDefinition;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ViewElementImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErfPackage.Literals.VIEW_ELEMENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isEditorShowLabel() {
        return editorShowLabel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEditorShowLabel( boolean newEditorShowLabel ) {
        boolean oldEditorShowLabel = editorShowLabel;
        editorShowLabel = newEditorShowLabel;
        if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.VIEW_ELEMENT__EDITOR_SHOW_LABEL,
            oldEditorShowLabel,
            editorShowLabel ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getEditorRowNumber() {
        return editorRowNumber;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEditorRowNumber( int newEditorRowNumber ) {
        int oldEditorRowNumber = editorRowNumber;
        editorRowNumber = newEditorRowNumber;
        if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.VIEW_ELEMENT__EDITOR_ROW_NUMBER,
            oldEditorRowNumber,
            editorRowNumber ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getEditorColumnSpan() {
        return editorColumnSpan;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEditorColumnSpan( int newEditorColumnSpan ) {
        int oldEditorColumnSpan = editorColumnSpan;
        editorColumnSpan = newEditorColumnSpan;
        if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.VIEW_ELEMENT__EDITOR_COLUMN_SPAN,
            oldEditorColumnSpan,
            editorColumnSpan ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AttributeDefinition getAttributeDefinition() {
        if( attributeDefinition != null && attributeDefinition.eIsProxy() ) {
            InternalEObject oldAttributeDefinition = (InternalEObject)attributeDefinition;
            attributeDefinition = (AttributeDefinition)eResolveProxy( oldAttributeDefinition );
            if( attributeDefinition != oldAttributeDefinition ) {
                if( eNotificationRequired() ) eNotify( new ENotificationImpl(
                    this,
                    Notification.RESOLVE,
                    ErfPackage.VIEW_ELEMENT__ATTRIBUTE_DEFINITION,
                    oldAttributeDefinition,
                    attributeDefinition ) );
            }
        }
        return attributeDefinition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AttributeDefinition basicGetAttributeDefinition() {
        return attributeDefinition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAttributeDefinition( AttributeDefinition newAttributeDefinition ) {
        AttributeDefinition oldAttributeDefinition = attributeDefinition;
        attributeDefinition = newAttributeDefinition;
        if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.VIEW_ELEMENT__ATTRIBUTE_DEFINITION,
            oldAttributeDefinition,
            attributeDefinition ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet( int featureID, boolean resolve, boolean coreType ) {
        switch (featureID) {
        case ErfPackage.VIEW_ELEMENT__EDITOR_SHOW_LABEL:
            return isEditorShowLabel();
        case ErfPackage.VIEW_ELEMENT__EDITOR_ROW_NUMBER:
            return getEditorRowNumber();
        case ErfPackage.VIEW_ELEMENT__EDITOR_COLUMN_SPAN:
            return getEditorColumnSpan();
        case ErfPackage.VIEW_ELEMENT__ATTRIBUTE_DEFINITION:
            if( resolve ) return getAttributeDefinition();
            return basicGetAttributeDefinition();
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
        case ErfPackage.VIEW_ELEMENT__EDITOR_SHOW_LABEL:
            setEditorShowLabel( (Boolean)newValue );
            return;
        case ErfPackage.VIEW_ELEMENT__EDITOR_ROW_NUMBER:
            setEditorRowNumber( (Integer)newValue );
            return;
        case ErfPackage.VIEW_ELEMENT__EDITOR_COLUMN_SPAN:
            setEditorColumnSpan( (Integer)newValue );
            return;
        case ErfPackage.VIEW_ELEMENT__ATTRIBUTE_DEFINITION:
            setAttributeDefinition( (AttributeDefinition)newValue );
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
        case ErfPackage.VIEW_ELEMENT__EDITOR_SHOW_LABEL:
            setEditorShowLabel( EDITOR_SHOW_LABEL_EDEFAULT );
            return;
        case ErfPackage.VIEW_ELEMENT__EDITOR_ROW_NUMBER:
            setEditorRowNumber( EDITOR_ROW_NUMBER_EDEFAULT );
            return;
        case ErfPackage.VIEW_ELEMENT__EDITOR_COLUMN_SPAN:
            setEditorColumnSpan( EDITOR_COLUMN_SPAN_EDEFAULT );
            return;
        case ErfPackage.VIEW_ELEMENT__ATTRIBUTE_DEFINITION:
            setAttributeDefinition( (AttributeDefinition)null );
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
        case ErfPackage.VIEW_ELEMENT__EDITOR_SHOW_LABEL:
            return editorShowLabel != EDITOR_SHOW_LABEL_EDEFAULT;
        case ErfPackage.VIEW_ELEMENT__EDITOR_ROW_NUMBER:
            return editorRowNumber != EDITOR_ROW_NUMBER_EDEFAULT;
        case ErfPackage.VIEW_ELEMENT__EDITOR_COLUMN_SPAN:
            return editorColumnSpan != EDITOR_COLUMN_SPAN_EDEFAULT;
        case ErfPackage.VIEW_ELEMENT__ATTRIBUTE_DEFINITION:
            return attributeDefinition != null;
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
        result.append( " (editorShowLabel: " );
        result.append( editorShowLabel );
        result.append( ", editorRowNumber: " );
        result.append( editorRowNumber );
        result.append( ", editorColumnSpan: " );
        result.append( editorColumnSpan );
        result.append( ')' );
        return result.toString();
    }

} //ViewElementImpl
