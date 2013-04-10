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

import era.foss.erf.ErfPackage;
import era.foss.erf.ViewElement;

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
 * This is the item provider adapter for a {@link era.foss.erf.ViewElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ViewElementItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
        IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ViewElementItemProvider( AdapterFactory adapterFactory ) {
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

            addEditorShowLabelPropertyDescriptor( object );
            addEditorColumnSpanPropertyDescriptor( object );
            addAttributeDefinitionPropertyDescriptor( object );
            addEditorRowPositionPropertyDescriptor( object );
            addEditorRowSpanPropertyDescriptor( object );
            addEditorColumnPositionPropertyDescriptor( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Editor Show Label feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addEditorShowLabelPropertyDescriptor( Object object ) {
        itemPropertyDescriptors.add( createItemPropertyDescriptor( ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                                                                   getResourceLocator(),
                                                                   getString( "_UI_ViewElement_editorShowLabel_feature" ),
                                                                   getString( "_UI_PropertyDescriptor_description",
                                                                              "_UI_ViewElement_editorShowLabel_feature",
                                                                              "_UI_ViewElement_type" ),
                                                                   ErfPackage.Literals.VIEW_ELEMENT__EDITOR_SHOW_LABEL,
                                                                   true,
                                                                   false,
                                                                   false,
                                                                   ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                                                                   null,
                                                                   null ) );
    }

    /**
     * This adds a property descriptor for the Editor Column Span feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addEditorColumnSpanPropertyDescriptor( Object object ) {
        itemPropertyDescriptors.add( createItemPropertyDescriptor( ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                                                                   getResourceLocator(),
                                                                   getString( "_UI_ViewElement_editorColumnSpan_feature" ),
                                                                   getString( "_UI_PropertyDescriptor_description",
                                                                              "_UI_ViewElement_editorColumnSpan_feature",
                                                                              "_UI_ViewElement_type" ),
                                                                   ErfPackage.Literals.VIEW_ELEMENT__EDITOR_COLUMN_SPAN,
                                                                   true,
                                                                   false,
                                                                   false,
                                                                   ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                                                                   null,
                                                                   null ) );
    }

    /**
     * This adds a property descriptor for the Attribute Definition feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addAttributeDefinitionPropertyDescriptor( Object object ) {
        itemPropertyDescriptors.add( createItemPropertyDescriptor( ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                                                                   getResourceLocator(),
                                                                   getString( "_UI_ViewElement_attributeDefinition_feature" ),
                                                                   getString( "_UI_PropertyDescriptor_description",
                                                                              "_UI_ViewElement_attributeDefinition_feature",
                                                                              "_UI_ViewElement_type" ),
                                                                   ErfPackage.Literals.VIEW_ELEMENT__ATTRIBUTE_DEFINITION,
                                                                   true,
                                                                   false,
                                                                   true,
                                                                   null,
                                                                   null,
                                                                   null ) );
    }

    /**
     * This adds a property descriptor for the Editor Row Position feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addEditorRowPositionPropertyDescriptor( Object object ) {
        itemPropertyDescriptors.add( createItemPropertyDescriptor( ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                                                                   getResourceLocator(),
                                                                   getString( "_UI_ViewElement_editorRowPosition_feature" ),
                                                                   getString( "_UI_PropertyDescriptor_description",
                                                                              "_UI_ViewElement_editorRowPosition_feature",
                                                                              "_UI_ViewElement_type" ),
                                                                   ErfPackage.Literals.VIEW_ELEMENT__EDITOR_ROW_POSITION,
                                                                   true,
                                                                   false,
                                                                   false,
                                                                   ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                                                                   null,
                                                                   null ) );
    }

    /**
     * This adds a property descriptor for the Editor Row Span feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addEditorRowSpanPropertyDescriptor( Object object ) {
        itemPropertyDescriptors.add( createItemPropertyDescriptor( ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                                                                   getResourceLocator(),
                                                                   getString( "_UI_ViewElement_editorRowSpan_feature" ),
                                                                   getString( "_UI_PropertyDescriptor_description",
                                                                              "_UI_ViewElement_editorRowSpan_feature",
                                                                              "_UI_ViewElement_type" ),
                                                                   ErfPackage.Literals.VIEW_ELEMENT__EDITOR_ROW_SPAN,
                                                                   true,
                                                                   false,
                                                                   false,
                                                                   ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                                                                   null,
                                                                   null ) );
    }

    /**
     * This adds a property descriptor for the Editor Column Position feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addEditorColumnPositionPropertyDescriptor( Object object ) {
        itemPropertyDescriptors.add( createItemPropertyDescriptor( ((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                                                                   getResourceLocator(),
                                                                   getString( "_UI_ViewElement_editorColumnPosition_feature" ),
                                                                   getString( "_UI_PropertyDescriptor_description",
                                                                              "_UI_ViewElement_editorColumnPosition_feature",
                                                                              "_UI_ViewElement_type" ),
                                                                   ErfPackage.Literals.VIEW_ELEMENT__EDITOR_COLUMN_POSITION,
                                                                   true,
                                                                   false,
                                                                   false,
                                                                   ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
                                                                   null,
                                                                   null ) );
    }

    /**
     * This returns ViewElement.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage( Object object ) {
        return overlayImage( object, getResourceLocator().getImage( "full/obj16/ViewElement" ) );
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText( Object object ) {
        ViewElement viewElement = (ViewElement)object;
        return getString( "_UI_ViewElement_type" ) + " " + viewElement.isEditorShowLabel();
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

        switch (notification.getFeatureID( ViewElement.class )) {
        case ErfPackage.VIEW_ELEMENT__EDITOR_SHOW_LABEL:
        case ErfPackage.VIEW_ELEMENT__EDITOR_COLUMN_SPAN:
        case ErfPackage.VIEW_ELEMENT__EDITOR_ROW_POSITION:
        case ErfPackage.VIEW_ELEMENT__EDITOR_ROW_SPAN:
        case ErfPackage.VIEW_ELEMENT__EDITOR_COLUMN_POSITION:
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
