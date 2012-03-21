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
package era.foss.objecteditor;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationStrategy;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TableViewerEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import era.foss.erf.AttributeDefinition;
import era.foss.erf.AttributeDefinitionSimple;
import era.foss.erf.AttributeValue;
import era.foss.erf.AttributeValueSimple;
import era.foss.erf.ERF;
import era.foss.erf.ErfPackage;
import era.foss.erf.SpecObject;
import era.foss.erf.SpecType;
import era.foss.erf.impl.ErfFactoryImpl;
import era.foss.ui.contrib.EraImages;
import era.foss.ui.contrib.IActiveColumn;
import era.foss.ui.contrib.TableViewerExtensions;

//SuppressWarnings("restriction")
/**
 * The Class SpecObjectsViewer.
 */
public class SpecObjectsViewer extends TableViewer implements IActiveColumn, IAllowViewerSchemaChange {

    /** The Constant SPEC_ATTRIBUTE_COLUMN_DATA. */
    final static String SPEC_ATTRIBUTE_COLUMN_DATA = "Spec Attribute";

    /** The editing domain. */
    protected AdapterFactoryEditingDomain editingDomain = null;

    /** The erf model. */
    protected ERF erfModel = null;

    /** The era command stack. */
    protected EraCommandStack eraCommandStack = null;

    /** The active column. */
    protected int activeColumn;

    /**
     * Instantiates a new spec objects viewer.
     * 
     * @param parent the parent
     * @param erfObjectEditor the erf object editor
     */
    public SpecObjectsViewer( Composite parent, AdapterFactoryEditingDomain editingDomain, ERF erfModel ) {
        super( parent, SWT.MULTI | SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION );
        // CPN: use casts to avoid direct dependencies to the generated Erf*Editor class(es)
        this.editingDomain = editingDomain;
        this.erfModel = erfModel;
    }

    /**
     * Setup table viewer.
     */
    private void setupTableViewer() {

        Table table = this.getTable();
        TableLayout layout = new TableLayout();
        table.setLayout( layout );
        table.setHeaderVisible( true );
        table.setLinesVisible( true );

        // prepare the activation strategy for setting the behavior when editing table cells
        ColumnViewerEditorActivationStrategy actStrategy = new ColumnViewerEditorActivationStrategy( this ) {
            protected boolean isEditorActivationEvent( ColumnViewerEditorActivationEvent event ) {
                return event.eventType == ColumnViewerEditorActivationEvent.TRAVERSAL
                    || event.eventType == ColumnViewerEditorActivationEvent.MOUSE_DOUBLE_CLICK_SELECTION
                    || event.eventType == ColumnViewerEditorActivationEvent.PROGRAMMATIC;
            }
        };

        // create table viewer editor (*?*)
        TableViewerEditor.create( this, actStrategy, ColumnViewerEditor.TABBING_HORIZONTAL
            | ColumnViewerEditor.TABBING_MOVE_TO_ROW_NEIGHBOR
            | ColumnViewerEditor.TABBING_VERTICAL
            | ColumnViewerEditor.KEYBOARD_ACTIVATION );

        // create columns
        create_columns();

        this.setContentProvider( new SpecObjectContentProvider( this.editingDomain.getAdapterFactory() ) );

        // enable tooltips
        ColumnViewerToolTipSupport.enableFor( this, ToolTip.NO_RECREATE );

        // create context menu
        createContextMenu();

        // add key press listeners
        addKeyListerner();

        // add detection for active column
        TableViewerExtensions.addActiveColumnDetection( this );

        this.setInput( erfModel.getCoreContent().getSpecObjects() );
    }

    /*
     * (non-Javadoc)
     * 
     * @see era.foss.objecteditor.IAllowViewerSchemaChange#recreateViewerSchema()
     */
    @Override
    public void recreateViewerSchema() {
        for( TableColumn column : this.getTable().getColumns() ) {
            column.dispose();
        }
        this.create_columns();
        this.refresh();
    }

    /**
     * Create columns for the spec Object viewer.
     */
    private void create_columns() {

        // in case we don't have a spec type don't create columns
        if( erfModel.getCoreContent().getSpecTypes().isEmpty() ) {
            return;
        }

        // get attributes for the spec object
        // Remark: currently we only have one specType
        SpecType specType = erfModel.getCoreContent().getSpecTypes().get( 0 );
        EList<AttributeDefinition> specAttributeList = specType.getSpecAttributes();

        for( AttributeDefinition attribute : specAttributeList ) {
            TableViewerColumn column = new TableViewerColumn( this, SWT.NONE );
            column.getColumn().setText( attribute.getLongName() );
            column.getColumn().setResizable( true );
            column.getColumn().setMoveable( true );
            column.getColumn().setWidth( 100 );
            column.getColumn().setData( SPEC_ATTRIBUTE_COLUMN_DATA, attribute );
            column.setEditingSupport( new SpecObjectEditingSupport( this, attribute ) );
            column.setLabelProvider( new SpecObjectLabelProvider( attribute ) );
        }

    }

    /**
     * Creates the context menu.
     */
    private void createContextMenu() {

        /**
         * Action for removing a value from a spec object
         * 
         * From the point of the user this will be seen as setting a value to it respective default value
         */
        final class RemoveValueAction extends Action {

            // data already computed before adding the action to the menu
            private IStructuredSelection selection;
            private AttributeDefinition attributeDefinition;

            public RemoveValueAction( IStructuredSelection selection, AttributeDefinition attributeDefinition ) {
                this.setText( "Restore default value" );
                this.setImageDescriptor( EraImages.getImageDescriptor( EraImages.IMG_DEFAULT_VALUE ) );
                this.selection = selection;
                this.attributeDefinition = attributeDefinition;

            }

            @Override
            public void run() {
                // remove attribute values of all spec object in selection
                for( Object specObject : selection.toArray() ) {
                    AttributeValue value = SpecObjectsViewer.this.getSpecObjectValue( (SpecObject)specObject,
                                                                                      attributeDefinition );
                    if( value != null ) {
                        SpecObjectsViewer.this.removeAttributeValue( value );
                    }
                }
            }
        }

        /**
         * Action for creating a new specObject
         */
        final class AddElementAction extends Action {

            // data already computed before adding the action to the menu
            private IStructuredSelection selection;

            public AddElementAction( IStructuredSelection selection ) {
                this.setText( "Add new object" );
                this.selection = selection;
                this.setImageDescriptor( PlatformUI.getWorkbench()
                                                   .getSharedImages()
                                                   .getImageDescriptor( ISharedImages.IMG_OBJ_ADD ) );
            }

            @Override
            public void run() {
                SpecObjectsViewer.this.addSpecObectElement( selection );
            }
        }

        /**
         * Action for removing specObjects
         */
        final class RemoveElementAction extends Action {

            // data already computed before adding the action to the menu
            private IStructuredSelection selection;

            public RemoveElementAction( IStructuredSelection selection ) {
                this.setText( "Remove elements" );
                this.setImageDescriptor( PlatformUI.getWorkbench()
                                                   .getSharedImages()
                                                   .getImageDescriptor( ISharedImages.IMG_TOOL_DELETE ) );
                this.selection = selection;
            }

            @Override
            public void run() {
                SpecObjectsViewer.this.removeSpecObjectElements( selection );
            }
        }

        final MenuManager menuMgr = new MenuManager();
        menuMgr.setRemoveAllWhenShown( true );

        menuMgr.addMenuListener( new IMenuListener() {
            /*
             * (non-Javadoc)
             * 
             * @see org.eclipse.jface.action.IMenuListener#menuAboutToShow(org.eclipse.jface.action.IMenuManager)
             */
            public void menuAboutToShow( IMenuManager manager ) {

                // get selected elements
                IStructuredSelection selection = (IStructuredSelection)SpecObjectsViewer.this.getSelection();

                // action for adding new elements
                // selection might be empty (element is appeneded then)
                menuMgr.add( new AddElementAction( selection ) );

                if( selection.isEmpty() ) {
                    return;
                }

                // remove element action
                menuMgr.add( new RemoveElementAction( selection ) );

                //
                // Context menu entry for setting to default value
                //

                // get current column
                int columnIndex = getActiveColumn();
                // get attribute definition shown in this column
                AttributeDefinition attributeDefinition = (AttributeDefinition)SpecObjectsViewer.this.getColumnViewerOwner( columnIndex )
                                                                                                     .getData( SPEC_ATTRIBUTE_COLUMN_DATA );

                // remove show menu only if first element of selection has a value
                SpecObject specObject = (SpecObject)selection.getFirstElement();
                AttributeValue value = SpecObjectsViewer.this.getSpecObjectValue( specObject, attributeDefinition );
                if( value != null ) {
                    menuMgr.add( new RemoveValueAction( selection, attributeDefinition ) );
                }

            }
        } );
        // register menu at the table viewer
        SpecObjectsViewer.this.getControl()
                              .setMenu( menuMgr.createContextMenu( SpecObjectsViewer.this.getControl() ) );
    }

    /**
     * Adds the key listerner.
     */
    private void addKeyListerner() {
        // add key listener
        this.getTable().addKeyListener( new KeyListener() {

            public void keyPressed( KeyEvent e ) {
                if( e.character == SWT.DEL ) {
                    SpecObjectsViewer.this.removeSpecObjectElements( (IStructuredSelection)SpecObjectsViewer.this.getSelection() );
                } else if( e.stateMask == SWT.CTRL && (e.character == SWT.LF || e.character == SWT.CR) ) {
                    SpecObjectsViewer.this.addSpecObectElement( (IStructuredSelection)SpecObjectsViewer.this.getSelection() );
                }
            }

            @Override
            public void keyReleased( KeyEvent e ) {
                /* do nothing */
            }
        } );

    }

    /**
     * Remove selected spec objects.
     * 
     * @param selection the selection
     */
    private void removeSpecObjectElements( IStructuredSelection selection ) {
        Command removeCommand = RemoveCommand.create( editingDomain, selection.toList() );
        editingDomain.getCommandStack().execute( removeCommand );
        this.refresh();
    }

    /**
     * Add spec object.
     * 
     * @param selection the selection
     */
    private void addSpecObectElement( IStructuredSelection selection ) {
        SpecObject newSpecObject = ErfFactoryImpl.eINSTANCE.createSpecObject();

        // Currently we only have one spec type
        newSpecObject.setType( erfModel.getCoreContent().getSpecTypes().get( 0 ) );
        Command cmd = AddCommand.create( editingDomain, erfModel.getCoreContent(), null, newSpecObject );
        BasicCommandStack basicCommandStack = (BasicCommandStack)editingDomain.getCommandStack();
        basicCommandStack.execute( cmd );
        this.refresh();
    }

    /**
     * Provide data for table containing spec objects.
     */
    public class SpecObjectContentProvider extends AdapterFactoryContentProvider {

        /**
         * Instantiates a new spec object content provider.
         * 
         * @param adapterFactory the adapter factory
         */
        public SpecObjectContentProvider( AdapterFactory adapterFactory ) {
            super( adapterFactory );
        }

        // get elements shown in the table viewer holding S
        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getElements(java.lang.Object)
         */
        public Object[] getElements( Object object ) {

            SpecObject[] objects;
            try {
                objects = (SpecObject[])erfModel.getCoreContent().getSpecObjects().toArray();
            } catch( NullPointerException e ) {
                objects = new SpecObject[0];
            }
            return objects;
        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#notifyChanged(org.eclipse.emf.common.notify
         * .Notification)
         */
        @Override
        public void notifyChanged( Notification notification ) {
            super.notifyChanged( notification );

            // PopupFactory factory = PopupFactory.getSharedInstance();
            // JTextArea jtext = new JTextArea();
            // jtext.append( this.getClass().getCanonicalName()+ ": \n" );
            // jtext.append( notification.toString() );
            // Popup popup = factory.getPopup(null, jtext , 0, 0);
            // popup.show();
            // popup.hide();

            System.out.println( "== " + this.getClass().getCanonicalName() );
            System.out.println( notification.toString() );
            //
            // handleInstanceLevel( notification );
            // handleTypeLevel( notification );
        }

    }

    /**
     * Provide label for data of table containing SpecTypes.
     */
    public class SpecObjectLabelProvider extends ColumnLabelProvider {

        /** The Color default value bg. */
        private Color ColorDefaultValueBg = null;

        /**
         * The attribute definition for this label provider * Required for getting the defatult value in case no value
         * is defined.
         */
        private AttributeDefinition attributeDefinition;

        /**
         * Instantiates a new spec object label provider.
         * 
         * @param attributeDefinition the attribute definition
         */
        public SpecObjectLabelProvider( AttributeDefinition attributeDefinition ) {
            this.attributeDefinition = attributeDefinition;
            ColorDefaultValueBg = new Color( Display.getCurrent(), 140, 170, 210 );
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.BaseLabelProvider#dispose()
         */
        @Override
        public void dispose() {
            ColorDefaultValueBg.dispose();
            super.dispose();
        }

        /**
         * get the attribute definition for this column.
         * 
         * @return the attribute definition
         */
        public AttributeDefinition getAttributeDefinition() {
            return attributeDefinition;
        }

        /**
         * Gets the image.
         * 
         * @param value the value
         * @param diagnostic the diagnostic
         * @return the image
         */
        public Image getImage( AttributeValue value, Diagnostic diagnostic ) {
            Image image = null;

            /* show error image in case validation of value fails */
            if( diagnostic != null && diagnostic.getSeverity() == Diagnostic.ERROR ) {
                image = PlatformUI.getWorkbench().getSharedImages().getImage( ISharedImages.IMG_OBJS_ERROR_TSK );
            }
            return image;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.CellLabelProvider#getToolTipText(java.lang.Object)
         */
        @Override
        public String getToolTipText( Object element ) {
            String text = null;
            /* show */
            AttributeValue value = SpecObjectsViewer.this.getSpecObjectValue( (SpecObject)element,
                                                                              attributeDefinition );
            if( value != null ) {
                Diagnostic diagnostic = Diagnostician.INSTANCE.validate( value );
                if( diagnostic.getSeverity() == Diagnostic.ERROR ) {
                    text = diagnostic.getChildren().get( 0 ).getMessage();
                }
            }
            return text;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.CellLabelProvider#getToolTipImage(java.lang.Object)
         */
        @Override
        /**
         * Show tooltip if validation fails
         */
        public Image getToolTipImage( Object element ) {
            Image image = null;

            AttributeValue value = SpecObjectsViewer.this.getSpecObjectValue( (SpecObject)element,
                                                                              attributeDefinition );

            /* show error image in case validation of value fails */
            if( value != null ) {
                Diagnostic diagnostic = Diagnostician.INSTANCE.validate( value );
                if( diagnostic.getSeverity() == Diagnostic.ERROR ) {
                    image = PlatformUI.getWorkbench().getSharedImages().getImage( ISharedImages.IMG_OBJS_ERROR_TSK );
                }
            }
            return image;
        }

        /**
         * show different background color if value is has default value (i.e. it is not present)
         * 
         * @param value the value
         * @return the background
         */
        public Color getBackground( AttributeValue value ) {
            Color backgroundColor = null;
            if( value == null ) {
                backgroundColor = ColorDefaultValueBg;
            }
            return backgroundColor;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.ColumnLabelProvider#update(org.eclipse.jface.viewers.ViewerCell)
         */
        @Override
        public void update( ViewerCell cell ) {
            SpecObject specObject = (SpecObject)cell.getElement();
            AttributeValue value = SpecObjectsViewer.this.getSpecObjectValue( specObject, attributeDefinition );

            Diagnostic diagnostic = null;
            if( value != null ) {
                diagnostic = Diagnostician.INSTANCE.validate( value );
            }

            cell.setText( SpecObjectsViewer.this.getSpecObjectValueString( value, attributeDefinition ) );
            cell.setImage( getImage( value, diagnostic ) );
            cell.setBackground( getBackground( value ) );
        }

    }

    /**
     * Editing support for Table holding the attribute definitions.
     * 
     */
    public class SpecObjectEditingSupport extends EditingSupport {

        /** The cell editor. */
        private CellEditor cellEditor;

        /** The basic command stack. */
        private BasicCommandStack basicCommandStack;

        /** Attribute defintion shown in this column. */
        AttributeDefinition attributeDefinition;

        /**
         * Instantiates a new spec object editing support.
         * 
         * @param viewer the viewer
         * @param attributeDefinition the attribute definition
         */
        public SpecObjectEditingSupport( ColumnViewer viewer, AttributeDefinition attributeDefinition ) {
            super( viewer );
            this.attributeDefinition = attributeDefinition;
            basicCommandStack = (BasicCommandStack)editingDomain.getCommandStack();

            // create cell editor according to AttributeDefinition types
            if( attributeDefinition instanceof AttributeDefinitionSimple ) {
                this.cellEditor = new TextCellEditor( ((TableViewer)viewer).getTable() );
            }
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.EditingSupport#canEdit(java.lang.Object)
         */
        @Override
        protected boolean canEdit( Object element ) {
            return true;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.EditingSupport#getCellEditor(java.lang.Object)
         */
        @Override
        protected CellEditor getCellEditor( Object element ) {
            return this.cellEditor;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.EditingSupport#getValue(java.lang.Object)
         */
        @Override
        protected Object getValue( Object element ) {
            SpecObject specObject = (SpecObject)element;
            AttributeValue value = SpecObjectsViewer.this.getSpecObjectValue( specObject, attributeDefinition );
            return SpecObjectsViewer.this.getSpecObjectValueString( value, attributeDefinition );
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.EditingSupport#setValue(java.lang.Object, java.lang.Object)
         */
        @Override
        protected void setValue( Object element, Object value ) {
            SpecObject specObject = (SpecObject)element;

            if( attributeDefinition instanceof AttributeDefinitionSimple ) {
                setValueAttributeDefintionSimple( specObject, value );
            }

        }

        /**
         * Sets the value attribute defintion simple.
         * 
         * @param specObject the spec object
         * @param editorValue the editor value
         */
        private void setValueAttributeDefintionSimple( SpecObject specObject, Object editorValue ) {

            AttributeDefinitionSimple attributeDefinition = (AttributeDefinitionSimple)this.attributeDefinition;
            AttributeValueSimple attributeValue = null;

            // check if the spec object provides a value for this column/attribute
            for( AttributeValue attributeValueIter : specObject.getValues() ) {
                if( attributeValueIter instanceof AttributeValueSimple ) {
                    if( attributeDefinition.equals( ((AttributeValueSimple)attributeValueIter).getDefinition() ) ) {
                        attributeValue = (AttributeValueSimple)attributeValueIter;
                    }
                }
            }

            // SpecObject has no Attribute Value for this Attribute Definition
            if( attributeValue == null ) {
                // create an Attribute Value
                attributeValue = ErfFactoryImpl.eINSTANCE.createAttributeValueSimple();

                // set reference to the respecitive Attribute Definition
                attributeValue.setDefinition( attributeDefinition );
                // set value of attribute definition
                attributeValue.setTheValue( (String)editorValue );

                // create new Attribute value in the model
                Command cmd = AddCommand.create( editingDomain,
                                                 specObject,
                                                 ErfPackage.SPEC_OBJECT__VALUES,
                                                 attributeValue );
                basicCommandStack.execute( cmd );
                SpecObjectsViewer.this.update( specObject, null );

            }

            // don't update the model
            // if the value is identical to current value of the spec object
            else if( editorValue == attributeValue.getTheValue() ) {
                return;
            }

            // The value in the editor and the model differ: set value in the model
            else {
                // The set command does not work when the object is created via the
                // create() method. Reason: Due to a bug the 'feature Id' is not passed
                // to the command. Therefore the execution fails.
                Command cmd = new SetCommand(
                    editingDomain,
                    attributeValue,
                    attributeValue.eClass().getEStructuralFeature( ErfPackage.ATTRIBUTE_VALUE_SIMPLE__THE_VALUE ),
                    editorValue );

                basicCommandStack.execute( cmd );
                SpecObjectsViewer.this.update( specObject, null );
            }
        }
    }

    // Helper for using the SpecObjectViewer from its viewer pane
    /**
     * Setup.
     */
    public void setup() {
        setupTableViewer();
    }

    /**
     * get the string representation of a spec object for a certain attribute Definition
     * 
     * in case no attribute value has been set search for the default value given for the attribute definition
     * 
     * in case no default value is specified return the empty string.
     * 
     * @param value the value
     * @param attributeDefinition of which the value is taken
     * @return String holding the value of spec object
     */
    private String getSpecObjectValueString( AttributeValue value, AttributeDefinition attributeDefinition ) {

        // return an empty string in case we find no value nor default value
        String valueString = "";

        // Handle simple attribute values
        if( attributeDefinition instanceof AttributeDefinitionSimple ) {
            // get attribute value according to the attribute definition

            // if value is not set try to use default value (if available)
            if( value == null ) {
                value = ((AttributeDefinitionSimple)attributeDefinition).getDefaultValue();
            }

            // get string if value object is defined
            if( value != null ) {
                valueString = ((AttributeValueSimple)value).getTheValue();
            }
        }

        return valueString;
    }

    /**
     * Find the attribte value object of SpecObject for a certain attribute definition.
     * 
     * @param specObject the spec object
     * @param attributeDefinition the attribute definition
     * @return <ul>
     *         <li>attribute value</li>
     *         <li><code>null</code> in case on attribute value has been found</li>
     */
    private AttributeValue getSpecObjectValue( SpecObject specObject, AttributeDefinition attributeDefinition ) {

        AttributeValue value = null;
        // check if the spec object provides a value for this column/attribute
        for( AttributeValue valueIter : specObject.getValues() ) {
            if( valueIter instanceof AttributeValueSimple ) {
                if( attributeDefinition.equals( ((AttributeValueSimple)valueIter).getDefinition() ) ) {
                    value = valueIter;
                }
            }
        }
        return value;
    }

    /**
     * remove attribute value of spec object.
     * 
     * @param value object to be removed
     */
    private void removeAttributeValue( AttributeValue value ) {
        BasicCommandStack basicCommandStack = (BasicCommandStack)editingDomain.getCommandStack();
        Command cmd = RemoveCommand.create( editingDomain, value );
        basicCommandStack.execute( cmd );
    }

    /**
     * Get column where a mouse down event occured.
     * 
     * @return number of active column
     */
    public int getActiveColumn() {
        return activeColumn;
    }

    /**
     * Set active column.
     * 
     * @param activeColumn the new active column
     */
    public void setActiveColumn( int activeColumn ) {
        this.activeColumn = activeColumn;
    }

}
