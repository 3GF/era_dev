package era.foss.objecteditor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.viewers.IViewerObservableValue;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import era.foss.erf.AttributeDefinition;
import era.foss.erf.AttributeValue;
import era.foss.erf.DatatypeDefinition;
import era.foss.erf.ErfPackage;
import era.foss.erf.SpecObject;
import era.foss.erf.View;
import era.foss.erf.ViewElement;

class SpecObjectViewerRow extends Composite {

    /** Delete button */
    private Label deleteButton;

    /** Master observable for the chosen view */
    static private IViewerObservableValue viewMaster;

    /** The editing domain used for modifications on the model */
    static private EditingDomain editingDomain;

    /**
     * Map holding the element of the chose
     */
    private final List<ViewElement> viewElementList = new ArrayList<ViewElement>();

    /**
     * The composite holding the all the controls according to the chosen view
     */
    Composite viewComposite;

    /**
     * List of Composites holding the graphical representation of a single AttributeDefinition
     */
    private final List<AbstractAttributeDefinitionComposite> attributeDefintionCompositeList = new ArrayList<AbstractAttributeDefinitionComposite>();

    /**
     * offset of the SpecObject associated with this row
     */
    private int specObjectOffset;

    /** List of selection listeners of this row */
    private List<SelectionListener> selectionListenerList = new LinkedList<SelectionListener>();

    private SpecObject specObject;

    /**
     * Constructor of the Row Composite
     * 
     * @param parent
     * @param style
     */
    public SpecObjectViewerRow( Composite parent, int style ) {
        super( parent, style );
        sortViewElements();
        doLayout();
        createSelectionListener();
    }

    /**
     * Set the master of the view to observe
     * 
     * @param viewMaster master observable
     */
    public static void setViewMaster( IViewerObservableValue viewMaster ) {
        SpecObjectViewerRow.viewMaster = viewMaster;
    }

    /**
     * Set the editing domain used for operations on an AttributeValue of the associated SpecObject
     * 
     * @param editingDomain
     */
    public static void setEditingDomain( EditingDomain editingDomain ) {
        SpecObjectViewerRow.editingDomain = editingDomain;
    }

    /**
     * Sort the elements in the view according to row number and position in row
     */
    private void sortViewElements() {

        // get view
        View selectedView = (View)SpecObjectViewerRow.viewMaster.getValue();
        if( selectedView == null ) {
            return;
        }

        // check if there are elements to be shown in the selected view
        if( selectedView.getViewElements().size() == 0 ) {
            return;
        }

        // Sort view elements in visual order (row first, index in list second)
        viewElementList.addAll( selectedView.getViewElements() );
        Collections.sort( viewElementList, new Comparator<ViewElement>() {
            @Override
            public int compare( ViewElement elem1, ViewElement elem2 ) {
                int elemRow1 = elem1.getEditorRowPosition();
                int elemRow2 = elem2.getEditorRowPosition();
                return elemRow1 != elemRow2 ? elemRow1 - elemRow2 : viewElementList.indexOf( elem1 )
                    - viewElementList.indexOf( elem2 );
            }
        } );
    }

    /**
     * Layout the row:
     * <ul>
     * <li>Delete button</li>
     * <li>Controls for the editing the SpecObject</li>
     * </ul>
     * 
     */
    private void doLayout() {
        this.setLayout( new GridLayout( 2, false ) );

        createDeleteButton();

        createSpecObjectControls();
    }

    /**
     * create the delete button for the row
     */
    private void createDeleteButton() {
        // create delete button
        Composite buttonComposite = new Composite( this, SWT.BORDER );
        buttonComposite.setLayoutData( new GridData( SWT.LEFT, SWT.CENTER, false, false, 0, 0 ) );
        buttonComposite.setLayout( new FillLayout() );

        deleteButton = new Label( buttonComposite, SWT.NONE );
        deleteButton.addMouseTrackListener( new MouseTrackAdapter() {

            @Override
            public void mouseEnter( MouseEvent e ) {
                ((Label)(e.widget)).setImage( PlatformUI.getWorkbench()
                                                        .getSharedImages()
                                                        .getImage( ISharedImages.IMG_TOOL_DELETE ) );
            }

            @Override
            public void mouseExit( MouseEvent e ) {
                ((Label)(e.widget)).setImage( PlatformUI.getWorkbench()
                                                        .getSharedImages()
                                                        .getImage( ISharedImages.IMG_TOOL_DELETE_DISABLED ) );
            }

        } );

        deleteButton.setImage( PlatformUI.getWorkbench()
                                         .getSharedImages()
                                         .getImage( ISharedImages.IMG_TOOL_DELETE_DISABLED ) );

    }

    /**
     * create controls for elements in the chosen view
     */
    private void createSpecObjectControls() {

        // Only create controls in case there are elements to show
        if( viewElementList.size() == 0 ) {
            return;
        }

        // calculate maxColumnSpan
        int maxColumnSpan = calculateMaxColumnSpan();

        viewComposite = new Composite( this, SWT.NONE );
        viewComposite.setLayout( new GridLayout( maxColumnSpan, true ) );
        viewComposite.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true ) );

        // get row number of first view element
        int curRow = viewElementList.get( 0 ).getEditorRowPosition();

        int curSpan = 0;
        for( final ViewElement viewElement : viewElementList ) {
            final int r = viewElement.getEditorRowPosition();
            // do we have a row switch at this point of iteration?
            if( r > curRow ) {
                // WARNING: this code block is not executed for the end of the last line!
                // 1) finalize intermediate rows:
                int paddingColumnSpan = maxColumnSpan - curSpan;
                if( paddingColumnSpan > 0 ) {
                    // padding: fill up this line with an empty label
                    Label labelLongName = new Label( viewComposite, SWT.NULL );
                    labelLongName.setText( "" );
                    labelLongName.setLayoutData( new GridData(
                        SWT.FILL,
                        SWT.CENTER,
                        false,
                        false,
                        paddingColumnSpan,
                        1 ) );
                }
                // 2) reset for new row
                curRow = r;
                curSpan = 0;
            }

            // track current row span for the "end of row" padding above
            final int controlSpan = viewElement.getEditorColumnSpan();
            curSpan += controlSpan;

            // initialize label
            if( viewElement.isEditorShowLabel() ) {
                curSpan++;
                Label labelLongName = new Label( viewComposite, SWT.NULL );
                labelLongName.setText( viewElement.getAttributeDefinition().getLongName() + ":" );
                labelLongName.setLayoutData( new GridData( SWT.RIGHT, SWT.CENTER, false, false ) );
            }

            AbstractAttributeDefinitionComposite control = null;
            DatatypeDefinition dataTypeDefinition = viewElement.getAttributeDefinition().getType();
            if( dataTypeDefinition != null ) {

                switch (dataTypeDefinition.eClass().getClassifierID()) {
                case ErfPackage.DATATYPE_DEFINITION_INTEGER:
                case ErfPackage.DATATYPE_DEFINITION_STRING:
                    control = new AttributeDefinitionStringComposite( viewComposite, viewElement, specObject );
                    break;
                case ErfPackage.DATATYPE_DEFINITION_BOOLEAN:
                    control = new AttributeDefinitionBooleanComposite( viewComposite, viewElement, specObject );
                    break;
                case ErfPackage.DATATYPE_DEFINITION_ENUMERATION:
                    control = new AttributeDefinitionEnumComposite( viewComposite, viewElement, specObject );
                    break;
                }

            }

            if( control != null ) {
                control.setLayoutData( new GridData( SWT.FILL, SWT.CENTER, true, false, controlSpan, 1 ) );
                attributeDefintionCompositeList.add( control );
            }
        }
    }

    /**
     * calculate the maximum column span required for displaying all the elements configured in the view
     * 
     * @return maximum Column span
     */
    private int calculateMaxColumnSpan() {
        int maxColumnSpan = 0;

        // get row number of first entry
        int curRow = viewElementList.get( 0 ).getEditorRowPosition();

        int curSpan = 0;
        for( ViewElement viewElement : viewElementList ) {
            int r = viewElement.getEditorRowPosition();
            // do we have a row switch at this point of iteration?
            if( r > curRow ) {
                // WARNING: this code block is not executed for the end of the last line!
                // reset
                curRow = r;
                curSpan = 0;
            }
            curSpan += viewElement.getEditorColumnSpan() + (viewElement.isEditorShowLabel() ? 1 : 0);
            // always check the column count: is it a new maximum?
            if( maxColumnSpan < curSpan ) {
                maxColumnSpan = curSpan;
            }
        }
        return maxColumnSpan;
    }

    /**
     * Binds the current SpecObject
     * 
     * @param The SpecObject to bind
     */
    public void bind( SpecObject specObject ) {

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
     * Get the delete button of this row
     * 
     * @return the delete Button of this row
     */
    public Label getDeleteButton() {
        return deleteButton;
    }

    /**
     * Set the selection status of this row. Alter the background when the row gets selected.
     * 
     * @param isSelected if true the row is displayed as selected
     * @param setFocus
     * 
     * */
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
     * Add a selection listener to this row
     * 
     * @param listener
     */
    public void addSelectionListener( SelectionListener listener ) {
        this.selectionListenerList.add( listener );
    }

    /**
     * Remove a selection listener
     * 
     * @param listener
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
     * set the offset of the SpecObject associated with this row
     * 
     * @param offset of the SpecObject
     */
    public void setSpecObject( SpecObject specObject, int offset ) {
        this.specObjectOffset = offset;
        this.specObject = specObject;
    }

    /**
     * get the offset of the SpecObject associated with this row
     * 
     * @return the offset of the SpecObject
     */
    public int getSpecObjectOffset() {
        return this.specObjectOffset;
    }

}