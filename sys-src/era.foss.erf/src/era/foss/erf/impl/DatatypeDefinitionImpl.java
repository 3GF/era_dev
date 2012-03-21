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

import era.foss.erf.AttributeDefinition;
import era.foss.erf.DatatypeDefinition;
import era.foss.erf.ErfPackage;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Datatype Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link era.foss.erf.impl.DatatypeDefinitionImpl#getAttributeDefinitions <em>Attribute Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DatatypeDefinitionImpl extends IdentifiableImpl implements DatatypeDefinition {

    /**
     * The cached value of the '{@link #getAttributeDefinitions() <em>Attribute Definitions</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAttributeDefinitions()
     * @generated
     * @ordered
     */
    protected EList<AttributeDefinition> attributeDefinitions;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DatatypeDefinitionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ErfPackage.Literals.DATATYPE_DEFINITION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<AttributeDefinition> getAttributeDefinitions() {
        if( attributeDefinitions == null ) {
            attributeDefinitions = new EObjectWithInverseResolvingEList<AttributeDefinition>(
                AttributeDefinition.class,
                this,
                ErfPackage.DATATYPE_DEFINITION__ATTRIBUTE_DEFINITIONS,
                ErfPackage.ATTRIBUTE_DEFINITION__TYPE );
        }
        return attributeDefinitions;
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
        case ErfPackage.DATATYPE_DEFINITION__ATTRIBUTE_DEFINITIONS:
            return ((InternalEList<InternalEObject>)(InternalEList<?>)getAttributeDefinitions()).basicAdd( otherEnd,
                                                                                                           msgs );
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
        case ErfPackage.DATATYPE_DEFINITION__ATTRIBUTE_DEFINITIONS:
            return ((InternalEList<?>)getAttributeDefinitions()).basicRemove( otherEnd, msgs );
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
        case ErfPackage.DATATYPE_DEFINITION__ATTRIBUTE_DEFINITIONS:
            return getAttributeDefinitions();
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
        case ErfPackage.DATATYPE_DEFINITION__ATTRIBUTE_DEFINITIONS:
            getAttributeDefinitions().clear();
            getAttributeDefinitions().addAll( (Collection<? extends AttributeDefinition>)newValue );
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
        case ErfPackage.DATATYPE_DEFINITION__ATTRIBUTE_DEFINITIONS:
            getAttributeDefinitions().clear();
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
        case ErfPackage.DATATYPE_DEFINITION__ATTRIBUTE_DEFINITIONS:
            return attributeDefinitions != null && !attributeDefinitions.isEmpty();
        }
        return super.eIsSet( featureID );
    }

} //DatatypeDefinitionImpl
