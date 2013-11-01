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
package era.foss.objecteditor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.databinding.viewers.IViewerObservableValue;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;

import era.foss.erf.AttributeDefinition;
import era.foss.erf.AttributeValue;
import era.foss.erf.DatatypeDefinition;
import era.foss.erf.ERF;
import era.foss.erf.ErfPackage;
import era.foss.erf.SpecObject;
import era.foss.erf.SpecType;
import era.foss.erf.View;
import era.foss.erf.ViewElement;
import era.foss.ui.contrib.PageBookMax;
import era.foss.util.types.Tuple;

/**
 * The Class SpecObjectViewerRow.
 */
class SpecObjectViewerRow extends Composite {

    /** Master observable for the chosen view. */
    static private IViewerObservableValue viewMaster;

    /** The editing domain used for modifications on the model. */
    static private EditingDomain editingDomain;

    /** The model. */
    private static ERF erfModel;

    /** The composite holding the all the controls according to the chosen view. */
    PageBookMax pageBook;

    /** List of Composites holding the graphical representation of a single AttributeDefinition. */
    private final List<AbstractAttributeDefinitionComposite> attributeDefintionCompositeList = new ArrayList<AbstractAttributeDefinitionComposite>();

    /** offset of the SpecObject associated with this row. */
    private int specObjectOffset;

    /** List of selection listeners of this row. */
    private List<SelectionListener> selectionListenerList = new LinkedList<SelectionListener>();

    /** The spec object. */
    private SpecObject specObject;

    /** The page map. */
    private HashMap<SpecType, Composite> pageMap = new HashMap<SpecType, Composite>();

    /** listner for adding and removing AttributeValue of SpecObjects */
    private AttributeValueAddRemoveListener attributeValueAddRemoveListener;

    /**
     * Updates the composites in case of an AttributeValue is added or removed from a SpecObject (e.g. by Undo or Redo
     * actions)
     * 
     * In case a an AttributeValue is added or removed then the respective composite is bound to a the new
     * AttributeValue in case there is any
     */
    private class AttributeValueAddRemoveListener extends AdapterImpl {
        @Override
        public void notifyChanged( Notification msg ) {
            super.notifyChanged( msg );

            Object changedValue = null;

            // find changed object for determining the attribute definition
            if( (msg.getEventType() == Notification.REMOVE) ) {
                changedValue = msg.getOldValue();

            } else if( (msg.getEventType() == Notification.ADD) ) {
                changedValue = msg.getNewValue();
            }

            if( (changedValue != null) && (changedValue instanceof AttributeValue) ) {
                AttributeDefinition attributeDefinition = ((AttributeValue)changedValue).getDefinition();

                // find composites to re-bind
                for( AbstractAttributeDefinitionComposite attributeDefinitionComposite : attributeDefintionCompositeList ) {
                    if( attributeDefinitionComposite.getViewElement().getAttributeDefinition() == attributeDefinition ) {
                        attributeDefinitionComposite.bind( (SpecObject)msg.getNotifier(),
                                                           (AttributeValue)msg.getNewValue(),
                                                           editingDomain );
                    }
                }
            }

        }
    };

    /**
     * Constructor of the Row Composite.
     * 
     * @param parent the parent
     * @param style the style
     */
    public SpecObjectViewerRow( Composite parent, int style ) {
        super( parent, style );

        // layout button and controls
        this.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true ) );
        this.setLayout( new GridLayout( 2, false ) );
        createDeleteButton( this );

        // Use PageBook as a top level composite for the row
        // A PageBook can show different pages for different SpecObjectTypes
        pageBook = new PageBookMax( this, SWT.NONE );
        pageBook.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true ) );

        // viewComposite.setLayout( new StackLayout() );
        // create the controls for each SpecType
        for( SpecType specType : erfModel.getCoreContent().getSpecTypes() ) {
            createSpecObjectControls( pageBook, specType );
        }

        // add menu for all elements
        createContextMenu();

        createSelectionListener();
    }

    /**
     * Creates the context menu for a SpecObject
     * 
     * This function registers menu for all gui elements the in the row. Reason: There are different cascaded controls
     * which are should react on a mouse click.
     */
    protected void createContextMenu() {

        MenuManager menuMgr = new MenuManager();
        menuMgr.setRemoveAllWhenShown( true );
        menuMgr.addMenuListener( new IMenuListener() {
            public void menuAboutToShow( IMenuManager manager ) {
                SpecObjectHandler.createCommonMenuItems( manager, editingDomain, specObject );
            }
        } );

        // register menu for all gui elements the in row
        this.createContextMenuComposite( menuMgr, this );
    }

    /**
     * Create the context menu for one composite and iterate over its children
     * 
     * @param menuMgr
     * @param control
     */
    private void createContextMenuComposite( MenuManager menuMgr, Control control ) {
        if( (control.getMenu() == null) ) {
            control.setMenu( menuMgr.createContextMenu( control ) );
        }

        // add menu to all children
        if( control instanceof Composite ) {
            for( Control childControl : ((Composite)control).getChildren() ) {
                this.createContextMenuComposite( menuMgr, childControl );
            }
        }
    }

    /**
     * Set the master of the view to observe.
     * 
     * @param viewMaster master observable
     */
    public static void setViewMaster( IViewerObservableValue viewMaster ) {
        SpecObjectViewerRow.viewMaster = viewMaster;
    }

    /**
     * Set the editing domain used for operations on an AttributeValue of the associated SpecObject.
     * 
     * @param editingDomain the new editing domain
     */
    public static void setEditingDomain( EditingDomain editingDomain ) {
        SpecObjectViewerRow.editingDomain = editingDomain;
    }

    /**
     * Set the editing domain used for operations on an AttributeValue of the associated SpecObject.
     * 
     * @param erfModel the new erf model
     */
    public static void setErfModel( ERF erfModel ) {
        SpecObjectViewerRow.erfModel = erfModel;
    }

    /**
     * Sort the elements in the view according to row number and position in row
     * 
     * @return
     */
    private ViewElement[][] createViewElementMatrix( SpecType specType ) {
        ViewElement[][] viewElementMatrix;
        List<ViewElement> viewElementList = new ArrayList<ViewElement>();

        // get view
        View selectedView = (View)viewMaster.getValue();
        if( selectedView == null ) {
            return null;
        }

        // find all view elements referring to the current specObject
        for( ViewElement viewElement : selectedView.getViewElements() ) {
            if( viewElement.getAttributeDefinition() != null
                && viewElement.getAttributeDefinition().getSpecType().equals( specType ) ) {
                viewElementList.add( viewElement );
            }
        }

        // check if there are elements to be shown in the selected view
        if( viewElementList.size() == 0 ) {
            return null;
        }

        // calculate maxColumnSpan
        Tuple<Integer, Integer> dimension = getDimensions( viewElementList );
        int numColumns = dimension.x;
        int numRows = dimension.y;

        viewElementMatrix = new ViewElement[numRows][numColumns];

        for( final ViewElement viewElement : viewElementList ) {

            final int rowPos = viewElement.getEditorRowPosition();
            final int rowSpan = viewElement.getEditorRowSpan();
            final int columnSpan = viewElement.getEditorColumnSpan();
            final int columnPos = viewElement.getEditorColumnPosition();

            for( int rowPosSpan = rowPos; rowPosSpan < (rowPos + rowSpan); rowPosSpan++ ) {
                for( int columnPosSpan = columnPos; columnPosSpan < (columnPos + columnSpan); columnPosSpan++ ) {
                    viewElementMatrix[rowPosSpan][columnPosSpan] = viewElement;
                }
            }

        }

        return viewElementMatrix;
    }

    /**
     * create the delete button for the row
     */
    private void createDeleteButton( Composite parent ) {

    }

    /**
     * create controls for elements in the chosen view
     */
    private void createSpecObjectControls( Composite parent, SpecType specType ) {

        // create matrix with holding references to ViewElements
        ViewElement viewElementMatrix[][] = createViewElementMatrix( specType );;

        // Only create controls in case there are elements to show
        if( viewElementMatrix == null ) {
            return;
        }

        int numRows = viewElementMatrix.length;
        int numColumns = viewElementMatrix[0].length;

        Composite viewCompositePage = new Composite( parent, SWT.NONE );
        // viewCompositePage.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true ) );
        viewCompositePage.setLayout( new GridLayout( numColumns, true ) );

        pageMap.put( specType, viewCompositePage );

        for( int rowPos = 0; rowPos < numRows; rowPos++ ) {
            for( int columnPos = 0; columnPos < numColumns; columnPos++ ) {

                // create padding if no element is occupying this spot
                if( viewElementMatrix[rowPos][columnPos] == null ) {
                    // determine horizontal span of the padding
                    int paddingSpan = 1;
                    while (((columnPos + paddingSpan) < numColumns)
                        && (viewElementMatrix[rowPos][columnPos + paddingSpan] == null)) {
                        paddingSpan++;
                    }
                    // padding: fill up this line with an empty label
                    Label paddingLabel = new Label( viewCompositePage, SWT.BORDER );
                    paddingLabel.setText( "Pad" );
                    paddingLabel.setVisible( false );
                    paddingLabel.setLayoutData( new GridData( SWT.FILL, SWT.CENTER, false, false, paddingSpan, 1 ) );
                    columnPos += paddingSpan - 1;
                } else {
                    ViewElement viewElement = viewElementMatrix[rowPos][columnPos];

                    // if this spot is occupied by the origin coordinates of an viewElement create the respective
                    // control
                    if( viewElement.getAttributeDefinition() != null
                        && rowPos == viewElement.getEditorRowPosition()
                        && columnPos == viewElement.getEditorColumnPosition() ) {

                        int controlColumnSpan = viewElement.getEditorColumnSpan();

                        // show label (only if there is space for a label
                        if( (viewElement.isEditorShowLabel() == true) && (controlColumnSpan > 1) ) {
                            Label label = new Label( viewCompositePage, SWT.NULL );
                            label.setText( viewElement.getAttributeDefinition().getLongName() + ":" );
                            label.setLayoutData( new GridData(
                                SWT.RIGHT,
                                SWT.BEGINNING,
                                false,
                                false,
                                1,
                                viewElement.getEditorRowSpan() ) );
                            controlColumnSpan--;
                        }

                        AbstractAttributeDefinitionComposite control = null;
                        DatatypeDefinition dataTypeDefinition = viewElement.getAttributeDefinition().getType();
                        if( dataTypeDefinition != null ) {

                            switch (dataTypeDefinition.eClass().getClassifierID()) {
                            case ErfPackage.DATATYPE_DEFINITION_INTEGER:
                            case ErfPackage.DATATYPE_DEFINITION_STRING:
                                control = new AttributeDefinitionStringComposite(
                                    viewCompositePage,
                                    viewElement,
                                    specObject );
                                break;
                            case ErfPackage.DATATYPE_DEFINITION_BOOLEAN:
                                control = new AttributeDefinitionBooleanComposite(
                                    viewCompositePage,
                                    viewElement,
                                    specObject );
                                break;
                            case ErfPackage.DATATYPE_DEFINITION_ENUMERATION:
                                control = new AttributeDefinitionEnumComposite(
                                    viewCompositePage,
                                    viewElement,
                                    specObject );
                                break;
                            }

                        }

                        if( control != null ) {
                            GridData gd = new GridData(
                                SWT.FILL,
                                SWT.FILL,
                                true,
                                true,
                                controlColumnSpan,
                                viewElement.getEditorRowSpan() );
                            gd.minimumHeight = control.computeSize( SWT.DEFAULT, SWT.DEFAULT ).y
                                * viewElement.getEditorRowSpan();
                            gd.heightHint = control.computeSize( SWT.DEFAULT, SWT.DEFAULT ).y
                                * viewElement.getEditorRowSpan();
                            control.setLayoutData( gd );
                            attributeDefintionCompositeList.add( control );
                        }
                    }
                }
            }
        }

    }

    /**
     * Get the maximum number of columns needed for the GridLayout
     * 
     * @return maximum Column span
     */
    private Tuple<Integer, Integer> getDimensions( final List<ViewElement> viewElementList ) {
        // the number of columns
        int columnPosMax = 0;
        // the number of rows
        int rowPosMax = 0;

        for( ViewElement viewElement : viewElementList ) {
            // get the last column position used by this element
            int columnPos = viewElement.getEditorColumnPosition() + viewElement.getEditorColumnSpan();
            columnPosMax = Math.max( columnPos, columnPosMax );

            // get the last row position used by this element
            int rowPos = viewElement.getEditorRowPosition() + viewElement.getEditorRowSpan();
            rowPosMax = Math.max( rowPos, rowPosMax );
        }
        return new Tuple<Integer, Integer>( columnPosMax, rowPosMax );
    }

    /**
     * Binds the current SpecObject.
     * 
     * @param specObject the spec object
     */
    public void bind( SpecObject specObject ) {

        // add listener to the spec obejct which takes care about changes in list of AttributeValue
        if( this.attributeValueAddRemoveListener == null ) {
            this.attributeValueAddRemoveListener = new AttributeValueAddRemoveListener();
        } else {
            attributeValueAddRemoveListener.getTarget().eAdapters().remove( attributeValueAddRemoveListener );
        }
        specObject.eAdapters().add( attributeValueAddRemoveListener );

        // create Hashmap for look up the attribute values for a certain attribute definition
        HashMap<AttributeDefinition, AttributeValue> attributeDefintionValueMap = new HashMap<AttributeDefinition, AttributeValue>();
        for( AttributeValue attributeValue : specObject.getValues() ) {
            attributeDefintionValueMap.put( attributeValue.getDefinition(), attributeValue );
        }

        // bind the controls
        for( AbstractAttributeDefinitionComposite attributeDefinitionComposite : attributeDefintionCompositeList ) {
            attributeDefinitionComposite.bind( specObject,
                                               attributeDefintionValueMap.get( attributeDefinitionComposite.getViewElement()
                                                                                                           .getAttributeDefinition() ),
                                               editingDomain );
        }
    }

    /**
     * Set the selection status of this row. Alter the background when the row gets selected.
     * 
     * @param isSelected if true the row is displayed as selected
     * @param setFocus the set focus
     */
    public void setSelected( boolean isSelected, boolean setFocus ) {
        if( isSelected ) {
            this.setBackground( Display.getDefault().getSystemColor( SWT.COLOR_LIST_SELECTION ) );
            // set focus to the first element in the view
            if( setFocus ) {
                if( attributeDefintionCompositeList.size() > 0 ) {
                    attributeDefintionCompositeList.get( 0 ).getControl().setFocus();
                }
            }
        } else {
            this.setBackground( Display.getDefault().getSystemColor( SWT.COLOR_WIDGET_BACKGROUND ) );
        }
    }

    /**
     * retrieve all child controls of a given composite
     * 
     * @param composite the composite to get the childs from
     * @param controlList the list where the controls are added to
     */
    private void getAllChildControls( Composite composite, List<Control> controlList ) {
        for( Control control : composite.getChildren() ) {
            controlList.add( control );
            if( control instanceof Composite ) {
                getAllChildControls( (Composite)control, controlList );
            }
        }
    }

    /**
     * Add a selection listener to this row.
     * 
     * @param listener the listener
     */
    public void addSelectionListener( SelectionListener listener ) {
        this.selectionListenerList.add( listener );
    }

    /**
     * Remove a selection listener.
     * 
     * @param listener the listener
     */
    public void removeSelectionListener( SelectionListener listener ) {
        this.selectionListenerList.remove( listener );
    }

    /**
     * create a wrapper for the mouse listener attached to all controls of the row
     */
    private void createSelectionListener() {
        MouseListener mouseListener = new MouseAdapter() {

            @Override
            public void mouseDown( MouseEvent mouseEvent ) {
                super.mouseDown( mouseEvent );

                Event event = new Event();
                event.widget = mouseEvent.widget;
                event.stateMask = mouseEvent.stateMask;
                SelectionEvent selectionEvent = new SelectionEvent( event );

                for( SelectionListener selectionListener : selectionListenerList ) {
                    selectionListener.widgetSelected( selectionEvent );
                }
            }
        };

        this.addMouseListener( mouseListener );
        List<Control> controlList = new ArrayList<Control>();
        getAllChildControls( this, controlList );
        for( Control control : controlList ) {
            control.addMouseListener( mouseListener );
        }
    }

    /**
     * set the {@link SpecObject} and offset of this {@link SpecObject} associated with this row
     * 
     * @param specObject the s{@link SpecObject} show in this row
     * @param offset of the SpecObject
     */
    public void setSpecObject( SpecObject specObject, int offset ) {
        this.specObjectOffset = offset;
        this.specObject = specObject;

        // show page according to specType
        if( specObject != null && specObject.getType() != null ) {
            Composite page = pageMap.get( specObject.getType() );
            if( page != null ) {
                pageBook.showPage( page );
            }
        }
    }

    /**
     * get the offset of the SpecObject associated with this row.
     * 
     * @return the offset of the SpecObject
     */
    public int getSpecObjectOffset() {
        return this.specObjectOffset;
    }

}