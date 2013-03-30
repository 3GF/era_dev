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
package era.foss.erf.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.ReplaceCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import era.foss.erf.Content;
import era.foss.erf.ErfFactory;
import era.foss.erf.ErfPackage;

/**
 * This is the item provider adapter for a {@link era.foss.erf.Content} object.
 * <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * @generated
 */
public class ContentItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
        IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
    
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param adapterFactory the adapter factory
     * @generated
     */
    public ContentItemProvider( AdapterFactory adapterFactory ) {
        super( adapterFactory );
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors( Object object ) {
        if( itemPropertyDescriptors == null ) {
            super.getPropertyDescriptors( object );

        }
        return itemPropertyDescriptors;
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures( Object object ) {
        if( childrenFeatures == null ) {
            super.getChildrenFeatures( object );
            childrenFeatures.add( ErfPackage.Literals.CONTENT__SPEC_OBJECTS );
            childrenFeatures.add( ErfPackage.Literals.CONTENT__SPEC_TYPES );
            childrenFeatures.add( ErfPackage.Literals.CONTENT__DATA_TYPES );
            childrenFeatures.add( ErfPackage.Literals.CONTENT__SPEC_RELATIONS );
        }
        return childrenFeatures;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature( Object object, Object child ) {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature( object, child );
    }

    /**
     * This returns Content.gif.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage( Object object ) {
        return overlayImage( object, getResourceLocator().getImage( "full/obj16/Content" ) );
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText( Object object ) {
        return getString( "_UI_Content_type" );
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating
     * a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @generated
     */
    @Override
    public void notifyChanged( Notification notification ) {
        updateChildren( notification );

        switch (notification.getFeatureID( Content.class )) {
        case ErfPackage.CONTENT__SPEC_OBJECTS:
        case ErfPackage.CONTENT__SPEC_TYPES:
        case ErfPackage.CONTENT__DATA_TYPES:
        case ErfPackage.CONTENT__SPEC_RELATIONS:
            fireNotifyChanged( new ViewerNotification( notification, notification.getNotifier(), true, false ) );
            return;
        }
        super.notifyChanged( notification );
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
     * that can be created under this object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors( Collection<Object> newChildDescriptors, Object object ) {
        super.collectNewChildDescriptors( newChildDescriptors, object );

        newChildDescriptors.add( createChildParameter( ErfPackage.Literals.CONTENT__SPEC_OBJECTS,
                                                       ErfFactory.eINSTANCE.createSpecObject() ) );

        newChildDescriptors.add( createChildParameter( ErfPackage.Literals.CONTENT__SPEC_TYPES,
                                                       ErfFactory.eINSTANCE.createSpecType() ) );

        newChildDescriptors.add( createChildParameter( ErfPackage.Literals.CONTENT__DATA_TYPES,
                                                       ErfFactory.eINSTANCE.createDatatypeDefinitionInteger() ) );

        newChildDescriptors.add( createChildParameter( ErfPackage.Literals.CONTENT__DATA_TYPES,
                                                       ErfFactory.eINSTANCE.createDatatypeDefinitionString() ) );

        newChildDescriptors.add( createChildParameter( ErfPackage.Literals.CONTENT__DATA_TYPES,
                                                       ErfFactory.eINSTANCE.createDatatypeDefinitionEnumeration() ) );

        newChildDescriptors.add( createChildParameter( ErfPackage.Literals.CONTENT__DATA_TYPES,
                                                       ErfFactory.eINSTANCE.createDatatypeDefinitionBoolean() ) );

        newChildDescriptors.add( createChildParameter( ErfPackage.Literals.CONTENT__SPEC_RELATIONS,
                                                       ErfFactory.eINSTANCE.createSpecRelation() ) );
    }

    /**
     * Return the resource locator for this item provider's resources.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the resource locator
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return ErfEditPlugin.INSTANCE;
    }

    protected Command createReplaceCommand( EditingDomain domain,
                                            EObject owner,
                                            EStructuralFeature feature,
                                            EObject value,
                                            Collection<?> collection ) {
        if( feature.getFeatureID() == ErfPackage.CONTENT__DATA_TYPES ) {
            return new ReplaceDatatypeDefinitionCommand( domain, owner, feature, value, collection );
        }
        return new ReplaceCommand( domain, owner, feature, value, collection );
    }

}
