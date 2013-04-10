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
 *   <li>{@link era.foss.erf.impl.ViewElementImpl#getEditorColumnSpan <em>Editor Column Span</em>}</li>
 *   <li>{@link era.foss.erf.impl.ViewElementImpl#getAttributeDefinition <em>Attribute Definition</em>}</li>
 *   <li>{@link era.foss.erf.impl.ViewElementImpl#getEditorRowPosition <em>Editor Row Position</em>}</li>
 *   <li>{@link era.foss.erf.impl.ViewElementImpl#getEditorRowSpan <em>Editor Row Span</em>}</li>
 *   <li>{@link era.foss.erf.impl.ViewElementImpl#getEditorColumnPosition <em>Editor Column Position</em>}</li>
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
     * The default value of the '{@link #getEditorRowPosition() <em>Editor Row Position</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEditorRowPosition()
     * @generated
     * @ordered
     */
    protected static final int EDITOR_ROW_POSITION_EDEFAULT = 1;

    /**
     * The cached value of the '{@link #getEditorRowPosition() <em>Editor Row Position</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEditorRowPosition()
     * @generated
     * @ordered
     */
    protected int editorRowPosition = EDITOR_ROW_POSITION_EDEFAULT;

    /**
     * The default value of the '{@link #getEditorRowSpan() <em>Editor Row Span</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEditorRowSpan()
     * @generated
     * @ordered
     */
    protected static final int EDITOR_ROW_SPAN_EDEFAULT = 1;

    /**
     * The cached value of the '{@link #getEditorRowSpan() <em>Editor Row Span</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEditorRowSpan()
     * @generated
     * @ordered
     */
    protected int editorRowSpan = EDITOR_ROW_SPAN_EDEFAULT;

    /**
     * The default value of the '{@link #getEditorColumnPosition() <em>Editor Column Position</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEditorColumnPosition()
     * @generated
     * @ordered
     */
    protected static final int EDITOR_COLUMN_POSITION_EDEFAULT = 1;

    /**
     * The cached value of the '{@link #getEditorColumnPosition() <em>Editor Column Position</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEditorColumnPosition()
     * @generated
     * @ordered
     */
    protected int editorColumnPosition = EDITOR_COLUMN_POSITION_EDEFAULT;

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
     * <!-- end-user-doc -->.
     *
     * @return true, if is editor show label
     * @generated
     */
    public boolean isEditorShowLabel() {
        return editorShowLabel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @param newEditorShowLabel the new editor show label
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
     * <!-- end-user-doc -->.
     *
     * @return the editor row position
     * @generated
     */
    public int getEditorRowPosition() {
        return editorRowPosition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @param newEditorRowPosition the new editor row position
     * @generated
     */
    public void setEditorRowPosition( int newEditorRowPosition ) {
        int oldEditorRowPosition = editorRowPosition;
        editorRowPosition = newEditorRowPosition;
        if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.VIEW_ELEMENT__EDITOR_ROW_POSITION,
            oldEditorRowPosition,
            editorRowPosition ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the editor row span
     * @generated
     */
    public int getEditorRowSpan() {
        return editorRowSpan;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @param newEditorRowSpan the new editor row span
     * @generated
     */
    public void setEditorRowSpan( int newEditorRowSpan ) {
        int oldEditorRowSpan = editorRowSpan;
        editorRowSpan = newEditorRowSpan;
        if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.VIEW_ELEMENT__EDITOR_ROW_SPAN,
            oldEditorRowSpan,
            editorRowSpan ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the editor column position
     * @generated
     */
    public int getEditorColumnPosition() {
        return editorColumnPosition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @param newEditorColumnPosition the new editor column position
     * @generated
     */
    public void setEditorColumnPosition( int newEditorColumnPosition ) {
        int oldEditorColumnPosition = editorColumnPosition;
        editorColumnPosition = newEditorColumnPosition;
        if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.VIEW_ELEMENT__EDITOR_COLUMN_POSITION,
            oldEditorColumnPosition,
            editorColumnPosition ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @return the editor column span
     * @generated
     */
    public int getEditorColumnSpan() {
        return editorColumnSpan;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @param newEditorColumnSpan the new editor column span
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
     * <!-- end-user-doc -->.
     *
     * @return the attribute definition
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
     * <!-- end-user-doc -->.
     *
     * @return the attribute definition
     * @generated
     */
    public AttributeDefinition basicGetAttributeDefinition() {
        return attributeDefinition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->.
     *
     * @param newAttributeDefinition the new attribute definition
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
        case ErfPackage.VIEW_ELEMENT__EDITOR_COLUMN_SPAN:
            return getEditorColumnSpan();
        case ErfPackage.VIEW_ELEMENT__ATTRIBUTE_DEFINITION:
            if( resolve ) return getAttributeDefinition();
            return basicGetAttributeDefinition();
        case ErfPackage.VIEW_ELEMENT__EDITOR_ROW_POSITION:
            return getEditorRowPosition();
        case ErfPackage.VIEW_ELEMENT__EDITOR_ROW_SPAN:
            return getEditorRowSpan();
        case ErfPackage.VIEW_ELEMENT__EDITOR_COLUMN_POSITION:
            return getEditorColumnPosition();
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
        case ErfPackage.VIEW_ELEMENT__EDITOR_COLUMN_SPAN:
            setEditorColumnSpan( (Integer)newValue );
            return;
        case ErfPackage.VIEW_ELEMENT__ATTRIBUTE_DEFINITION:
            setAttributeDefinition( (AttributeDefinition)newValue );
            return;
        case ErfPackage.VIEW_ELEMENT__EDITOR_ROW_POSITION:
            setEditorRowPosition( (Integer)newValue );
            return;
        case ErfPackage.VIEW_ELEMENT__EDITOR_ROW_SPAN:
            setEditorRowSpan( (Integer)newValue );
            return;
        case ErfPackage.VIEW_ELEMENT__EDITOR_COLUMN_POSITION:
            setEditorColumnPosition( (Integer)newValue );
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
        case ErfPackage.VIEW_ELEMENT__EDITOR_COLUMN_SPAN:
            setEditorColumnSpan( EDITOR_COLUMN_SPAN_EDEFAULT );
            return;
        case ErfPackage.VIEW_ELEMENT__ATTRIBUTE_DEFINITION:
            setAttributeDefinition( (AttributeDefinition)null );
            return;
        case ErfPackage.VIEW_ELEMENT__EDITOR_ROW_POSITION:
            setEditorRowPosition( EDITOR_ROW_POSITION_EDEFAULT );
            return;
        case ErfPackage.VIEW_ELEMENT__EDITOR_ROW_SPAN:
            setEditorRowSpan( EDITOR_ROW_SPAN_EDEFAULT );
            return;
        case ErfPackage.VIEW_ELEMENT__EDITOR_COLUMN_POSITION:
            setEditorColumnPosition( EDITOR_COLUMN_POSITION_EDEFAULT );
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
        case ErfPackage.VIEW_ELEMENT__EDITOR_COLUMN_SPAN:
            return editorColumnSpan != EDITOR_COLUMN_SPAN_EDEFAULT;
        case ErfPackage.VIEW_ELEMENT__ATTRIBUTE_DEFINITION:
            return attributeDefinition != null;
        case ErfPackage.VIEW_ELEMENT__EDITOR_ROW_POSITION:
            return editorRowPosition != EDITOR_ROW_POSITION_EDEFAULT;
        case ErfPackage.VIEW_ELEMENT__EDITOR_ROW_SPAN:
            return editorRowSpan != EDITOR_ROW_SPAN_EDEFAULT;
        case ErfPackage.VIEW_ELEMENT__EDITOR_COLUMN_POSITION:
            return editorColumnPosition != EDITOR_COLUMN_POSITION_EDEFAULT;
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
        result.append( ", editorColumnSpan: " );
        result.append( editorColumnSpan );
        result.append( ", editorRowPosition: " );
        result.append( editorRowPosition );
        result.append( ", editorRowSpan: " );
        result.append( editorRowSpan );
        result.append( ", editorColumnPosition: " );
        result.append( editorColumnPosition );
        result.append( ')' );
        return result.toString();
    }

} //ViewElementImpl
