/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package era.foss.erf.provider;

import era.foss.erf.AttributeValueBoolean;

import era.foss.erf.ErfPackage;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link era.foss.erf.AttributeValueBoolean} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AttributeValueBooleanItemProvider extends AttributeValueItemProvider implements
        IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
        IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AttributeValueBooleanItemProvider( AdapterFactory adapterFactory ) {
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

            addTheValuePropertyDescriptor( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the The Value feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addTheValuePropertyDescriptor( Object object ) {
        itemPropertyDescriptors.add( createItemPropertyDescriptor( ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                                                                   getResourceLocator(),
                                                                   getString( "_UI_AttributeValueBoolean_theValue_feature" ),
                                                                   getString( "_UI_PropertyDescriptor_description",
                                                                              "_UI_AttributeValueBoolean_theValue_feature",
                                                                              "_UI_AttributeValueBoolean_type" ),
                                                                   ErfPackage.Literals.ATTRIBUTE_VALUE_BOOLEAN__THE_VALUE,
                                                                   true,
                                                                   false,
                                                                   false,
                                                                   ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                                                                   null,
                                                                   null ) );
    }

    /**
     * This returns AttributeValueBoolean.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage( Object object ) {
        return overlayImage( object, getResourceLocator().getImage( "full/obj16/AttributeValueBoolean" ) );
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText( Object object ) {
        String label = ((AttributeValueBoolean)object).getID();
        return label == null || label.length() == 0
            ? getString( "_UI_AttributeValueBoolean_type" )
            : getString( "_UI_AttributeValueBoolean_type" ) + " " + label;
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

        switch (notification.getFeatureID( AttributeValueBoolean.class )) {
        case ErfPackage.ATTRIBUTE_VALUE_BOOLEAN__THE_VALUE:
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

}
