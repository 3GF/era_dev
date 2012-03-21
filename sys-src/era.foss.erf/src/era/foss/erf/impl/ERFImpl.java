/**************************************************************************
 * ERA - Eclipse Requirements Analysis
 * ==============================================
 * Copyright (C) 2009-2011 by Georg Blaschke, Christoph P. Neumann
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
 * $Id$
 *************************************************************************/
package era.foss.erf.impl;

import era.foss.erf.ERF;
import era.foss.erf.Content;
import era.foss.erf.ErfPackage;

import era.foss.erf.ToolExtension;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ERF</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link era.foss.erf.impl.ERFImpl#getCoreContent <em>Core Content</em>}</li>
 *   <li>{@link era.foss.erf.impl.ERFImpl#getToolExtensions <em>Tool Extensions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ERFImpl extends EObjectImpl implements ERF {

    /**
     * The cached value of the '{@link #getCoreContent() <em>Core Content</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCoreContent()
     * @generated
     * @ordered
     */
    protected Content coreContent;

    /**
     * The cached value of the '{@link #getToolExtensions() <em>Tool Extensions</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getToolExtensions()
     * @generated
     * @ordered
     */
    protected EList<ToolExtension> toolExtensions;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ERFImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErfPackage.Literals.ERF;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Content getCoreContent() {
        return coreContent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCoreContent( Content newCoreContent, NotificationChain msgs ) {
        Content oldCoreContent = coreContent;
        coreContent = newCoreContent;
        if( eNotificationRequired() ) {
            ENotificationImpl notification = new ENotificationImpl(
                this,
                Notification.SET,
                ErfPackage.ERF__CORE_CONTENT,
                oldCoreContent,
                newCoreContent );
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
    public void setCoreContent( Content newCoreContent ) {
        if( newCoreContent != coreContent ) {
            NotificationChain msgs = null;
            if( coreContent != null ) msgs = ((InternalEObject)coreContent).eInverseRemove( this,
                                                                                            EOPPOSITE_FEATURE_BASE
                                                                                                - ErfPackage.ERF__CORE_CONTENT,
                                                                                            null,
                                                                                            msgs );
            if( newCoreContent != null ) msgs = ((InternalEObject)newCoreContent).eInverseAdd( this,
                                                                                               EOPPOSITE_FEATURE_BASE
                                                                                                   - ErfPackage.ERF__CORE_CONTENT,
                                                                                               null,
                                                                                               msgs );
            msgs = basicSetCoreContent( newCoreContent, msgs );
            if( msgs != null ) msgs.dispatch();
        } else if( eNotificationRequired() ) eNotify( new ENotificationImpl(
            this,
            Notification.SET,
            ErfPackage.ERF__CORE_CONTENT,
            newCoreContent,
            newCoreContent ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ToolExtension> getToolExtensions() {
        if( toolExtensions == null ) {
            toolExtensions = new EObjectContainmentEList<ToolExtension>(
                ToolExtension.class,
                this,
                ErfPackage.ERF__TOOL_EXTENSIONS );
        }
        return toolExtensions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove( InternalEObject otherEnd, int featureID, NotificationChain msgs ) {
        switch (featureID) {
        case ErfPackage.ERF__CORE_CONTENT:
            return basicSetCoreContent( null, msgs );
        case ErfPackage.ERF__TOOL_EXTENSIONS:
            return ((InternalEList<?>)getToolExtensions()).basicRemove( otherEnd, msgs );
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
        case ErfPackage.ERF__CORE_CONTENT:
            return getCoreContent();
        case ErfPackage.ERF__TOOL_EXTENSIONS:
            return getToolExtensions();
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
        case ErfPackage.ERF__CORE_CONTENT:
            setCoreContent( (Content)newValue );
            return;
        case ErfPackage.ERF__TOOL_EXTENSIONS:
            getToolExtensions().clear();
            getToolExtensions().addAll( (Collection<? extends ToolExtension>)newValue );
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
        case ErfPackage.ERF__CORE_CONTENT:
            setCoreContent( (Content)null );
            return;
        case ErfPackage.ERF__TOOL_EXTENSIONS:
            getToolExtensions().clear();
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
        case ErfPackage.ERF__CORE_CONTENT:
            return coreContent != null;
        case ErfPackage.ERF__TOOL_EXTENSIONS:
            return toolExtensions != null && !toolExtensions.isEmpty();
        }
        return super.eIsSet( featureID );
    }

} //ERFImpl
