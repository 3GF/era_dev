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

import era.foss.erf.Color;
import era.foss.erf.ErfPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link era.foss.erf.Color} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ColorItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
        IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ColorItemProvider( AdapterFactory adapterFactory ) {
        super( adapterFactory );
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors( Object object ) {
        if( itemPropertyDescriptors == null ) {
            super.getPropertyDescriptors( object );

            addRedPropertyDescriptor( object );
            addGreenPropertyDescriptor( object );
            addBluePropertyDescriptor( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Red feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addRedPropertyDescriptor( Object object ) {
        itemPropertyDescriptors.add( createItemPropertyDescriptor( ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                                                                   getResourceLocator(),
                                                                   getString( "_UI_Color_red_feature" ),
                                                                   getString( "_UI_PropertyDescriptor_description",
                                                                              "_UI_Color_red_feature",
                                                                              "_UI_Color_type" ),
                                                                   ErfPackage.Literals.COLOR__RED,
                                                                   true,
                                                                   false,
                                                                   false,
                                                                   ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                                                                   null,
                                                                   null ) );
    }

    /**
     * This adds a property descriptor for the Green feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addGreenPropertyDescriptor( Object object ) {
        itemPropertyDescriptors.add( createItemPropertyDescriptor( ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                                                                   getResourceLocator(),
                                                                   getString( "_UI_Color_green_feature" ),
                                                                   getString( "_UI_PropertyDescriptor_description",
                                                                              "_UI_Color_green_feature",
                                                                              "_UI_Color_type" ),
                                                                   ErfPackage.Literals.COLOR__GREEN,
                                                                   true,
                                                                   false,
                                                                   false,
                                                                   ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                                                                   null,
                                                                   null ) );
    }

    /**
     * This adds a property descriptor for the Blue feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addBluePropertyDescriptor( Object object ) {
        itemPropertyDescriptors.add( createItemPropertyDescriptor( ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                                                                   getResourceLocator(),
                                                                   getString( "_UI_Color_blue_feature" ),
                                                                   getString( "_UI_PropertyDescriptor_description",
                                                                              "_UI_Color_blue_feature",
                                                                              "_UI_Color_type" ),
                                                                   ErfPackage.Literals.COLOR__BLUE,
                                                                   true,
                                                                   false,
                                                                   false,
                                                                   ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                                                                   null,
                                                                   null ) );
    }

    /**
     * This returns Color.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage( Object object ) {
        return overlayImage( object, getResourceLocator().getImage( "full/obj16/Color" ) );
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText( Object object ) {
        Color color = (Color)object;
        return getString( "_UI_Color_type" ) + " " + color.getRed();
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void notifyChanged( Notification notification ) {
        updateChildren( notification );

        switch (notification.getFeatureID( Color.class )) {
        case ErfPackage.COLOR__RED:
        case ErfPackage.COLOR__GREEN:
        case ErfPackage.COLOR__BLUE:
            fireNotifyChanged( new ViewerNotification( notification, notification.getNotifier(), false, true ) );
            return;
        }
        super.notifyChanged( notification );
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
     * that can be created under this object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors( Collection<Object> newChildDescriptors, Object object ) {
        super.collectNewChildDescriptors( newChildDescriptors, object );
    }

    /**
     * Return the resource locator for this item provider's resources.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return ErfEditPlugin.INSTANCE;
    }

}
