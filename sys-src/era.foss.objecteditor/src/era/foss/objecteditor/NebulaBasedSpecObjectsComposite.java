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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.nebula.widgets.compositetable.CompositeTable;
import org.eclipse.swt.nebula.widgets.compositetable.IRowContentProvider;
import org.eclipse.swt.nebula.widgets.compositetable.RowFocusAdapter;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import era.foss.erf.AttributeDefinition;
import era.foss.erf.AttributeDefinitionSimple;
import era.foss.erf.AttributeValue;
import era.foss.erf.AttributeValueSimple;
import era.foss.erf.DatatypeDefinition;
import era.foss.erf.ERF;
import era.foss.erf.EraToolExtension;
import era.foss.erf.ErfPackage;
import era.foss.erf.SpecObject;
import era.foss.erf.SpecType;
import era.foss.erf.ToolExtension;
import era.foss.erf.View;
import era.foss.erf.ViewElement;
import era.foss.erf.impl.ErfFactoryImpl;

/**
 * 
 */
public class NebulaBasedSpecObjectsComposite extends Composite implements ISelectionProvider {

    /** EditingDomain, being required for the Command creation. */
    protected AdapterFactoryEditingDomain editingDomain = null;

    /** The erf model. */
    protected ERF erfModel = null;

    /** Era tool extension */
    protected EraToolExtension toolExtension;

    /** The erf model. */
    protected SpecType theOneAndOnlySpecType = null;

    /** The composite table. */
    protected CompositeTable compositeTable = null;

    /** The basic command stack. */
    protected BasicCommandStack basicCommandStack;

    /** The specobj list. */
    EList<SpecObject> specobjList = null;

    /** The current selection */
    protected SpecObject selectedSpecObject = null;

    /** Keeping ISelectionChangedListener */
    List<ISelectionChangedListener> selectionChangedListeners = new LinkedList<ISelectionChangedListener>();

    /**
     * Instantiates a new nebula based spec objects viewer.
     * 
     * @param parent the parent
     * @param editingDomain the editing domain
     * @param erfModel the erf model
     */
    public NebulaBasedSpecObjectsComposite( Composite parent, AdapterFactoryEditingDomain editingDomain, ERF erfModel ) {
        super( parent, SWT.NULL | SWT.NO_SCROLL );

        // super( parent, SWT.MULTI | SWT.V_SCROLL | SWT.BORDER |
        // SWT.FULL_SELECTION );
        this.editingDomain = editingDomain;
        this.erfModel = (ERF)erfModel;
        this.theOneAndOnlySpecType = this.erfModel.getCoreContent().getSpecTypes().get( 0 );

        // CPN: use casts to avoid direct dependencies to the generated
        // Erf*Editor class(es)
        this.basicCommandStack = (BasicCommandStack)editingDomain.getCommandStack();

        // find Era specific tool extensions
        for( ToolExtension toolExtension : this.erfModel.getToolExtensions() ) {
            if( toolExtension.eClass().getClassifierID() == ErfPackage.ERA_TOOL_EXTENSION ) {
                this.toolExtension = (EraToolExtension)toolExtension;
            }
        }
        assert (this.toolExtension != null);

        /* ***************************************** */
        /* create CompositeTable */
        /* ***************************************** */

        this.setLayout( new FillLayout() );
        this.compositeTable = new CompositeTable( this, SWT.NULL | SWT.NO_SCROLL );

        /* ***************************************** */
        /* create NebulaDemandedSpecObjectEditor */
        /* ***************************************** */
        new NebulaDemandedSpecObjectRowControl( compositeTable, SWT.NULL );

        compositeTable.setRunTime( true );

        this.specobjList = getElements();
        compositeTable.setNumRowsInCollection( specobjList.toArray().length );

        // Note the JFace-like virtual table API
        compositeTable.addRowFocusListener( new RowFocusAdapter() {
            public void arrive( CompositeTable sender, int currentObjectOffset, Control newRow ) {
                selectedSpecObject = specobjList.get( currentObjectOffset );
                for( ISelectionChangedListener iter : selectionChangedListeners ) {
                    iter.selectionChanged( new SelectionChangedEvent(
                        NebulaBasedSpecObjectsComposite.this,
                        NebulaBasedSpecObjectsComposite.this.getSelection() ) );
                }

            }
        } );
        // row needs to be filled with data
        compositeTable.addRowContentProvider( new IRowContentProvider() {
            public void refresh( CompositeTable sender, int currentObjectOffset, Control rowControl ) {
                SpecObject refreshedSpecObject = NebulaBasedSpecObjectsComposite.this.specobjList.get( currentObjectOffset );
                assert (rowControl instanceof NebulaDemandedSpecObjectRowControl);
                NebulaDemandedSpecObjectRowControl row = (NebulaDemandedSpecObjectRowControl)rowControl;
                /* iterate AttributeDefinitions */
                EList<AttributeDefinition> specAttributeList = theOneAndOnlySpecType.getSpecAttributes();
                for( AttributeDefinition attrDef : specAttributeList ) {
                    String currentObjectString = getValue( refreshedSpecObject, attrDef );
                    Text textField = (Text)row.dataFields.get( attrDef.getID() );
                    // not each model attribute necessarily has a view field
                    if( textField == null ) continue;
                    // write model attribute into field text
                    textField.setText( currentObjectString );
                }
            }
        } );

    }

    /**
     * Gets the elements.
     * 
     * @return the elements
     */
    @SuppressWarnings("unchecked")
    protected EList<SpecObject> getElements() {

        EList<SpecObject> specObjects = null;
        try {
            specObjects = erfModel.getCoreContent().getSpecObjects();
        } catch( NullPointerException e ) {
            specObjects = (EList<SpecObject>)ECollections.EMPTY_ELIST;
        }
        return specObjects;
    }

    /**
     * Gets the value.
     * 
     * @param specObject the spec object
     * @param attributeDefinition the attribute definition
     * @return the value
     */
    protected String getValue( SpecObject specObject, AttributeDefinition attributeDefinition ) {
        AttributeValue value = getSpecObjectValue( specObject, attributeDefinition );
        return getSpecObjectValueString( value, attributeDefinition );
    }

    /**
     * Sets the value. <br>
     * Will NOT execute a SET command if the editorValue equals the current SpecObject's value in the specified
     * AttributeDefinition!
     * 
     * @param specObject the spec object
     * @param attributeDefinition the attribute definition
     * @param editorValue the editor value
     */
    protected void setValue( SpecObject specObject, AttributeDefinition attributeDefinition, String editorValue ) {
        if( attributeDefinition instanceof AttributeDefinitionSimple ) {
            setValueAttributeDefintionSimple( specObject, (AttributeDefinitionSimple)attributeDefinition, editorValue );
        }
    }

    /**
     * Sets the value attribute definition SIMPLE. (Will NOT execute a SET command if the editorValue equals the current
     * SpecObject's value in the specified AttributeDefinition.)
     * 
     * @param specObject the spec object
     * @param attributeDefinition the attribute definition
     * @param editorValue the editor value
     */
    private void setValueAttributeDefintionSimple( SpecObject specObject,
                                                   AttributeDefinitionSimple attributeDefinition,
                                                   String editorValue ) {

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

            // set reference to the respective Attribute Definition
            attributeValue.setDefinition( attributeDefinition );
            // set value of attribute definition
            attributeValue.setTheValue( (String)editorValue );

            // create new Attribute value in the model
            Command cmd = AddCommand.create( editingDomain,
                                             specObject,
                                             ErfPackage.SPEC_OBJECT__VALUES,
                                             attributeValue );
            basicCommandStack.execute( cmd );
        }

        /* don't update the model if the value is identical to current value of the spec object */
        else if( editorValue.equals( attributeValue.getTheValue() ) ) {
            return;
        }

        // The value in the editor and the model differ: set value in the model
        else {
            // The set command does not work when the object is created via the
            // create() method. Reason: Due to a bug the 'feature Id' is not
            // passed
            // to the command. Therefore the execution fails.
            Command cmd = new SetCommand(
                editingDomain,
                attributeValue,
                ErfPackage.Literals.ATTRIBUTE_VALUE_SIMPLE__THE_VALUE,
                editorValue );

            basicCommandStack.execute( cmd );
        }
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

    @Override
    public void addSelectionChangedListener( ISelectionChangedListener listener ) {
        if( selectionChangedListeners.contains( listener ) ) return;
        selectionChangedListeners.add( listener );
    }

    @Override
    public void removeSelectionChangedListener( ISelectionChangedListener listener ) {
        selectionChangedListeners.remove( listener );
    }

    @Override
    public ISelection getSelection() {
        if( selectedSpecObject == null ) return StructuredSelection.EMPTY;
        return new StructuredSelection( selectedSpecObject );
    }

    @Override
    public void setSelection( ISelection selection ) {
        if( selection.isEmpty() ) return;
        // unpack ISelection into SpecObject
        assert (selection instanceof StructuredSelection);
        Object obj = ((StructuredSelection)selection).toList().get( 0 );
        assert (obj instanceof SpecObject);
        // set selectedSpecObject to given one
        selectedSpecObject = (SpecObject)obj;
        // find selectedSpecObject in list to get index/offset
        int objIdx = specobjList.indexOf( selectedSpecObject );
        // re-focus the composite table to correct position
        compositeTable.setCurrentRow( objIdx );
    }

    /**
     * The Class NebulaDemandedSpecObjectRowControl.
     */
    private static class NebulaDemandedSpecObjectRowControl extends Composite {

        /** The text fields. */
        public HashMap<String, Control> dataFields = new HashMap<String, Control>();

        protected NebulaBasedSpecObjectsComposite myViewer = null;

        /**
         * Instantiates a new nebula demanded spec object row control.
         * 
         * @param parent the parent
         * @param style the style
         */
        public NebulaDemandedSpecObjectRowControl( Composite parent, int style ) {
            super( parent, style | SWT.BORDER );

            /* ***************************************** */
            /* initialize viewer-based members */
            /* ***************************************** */

            // search hierachy for the ancestor that is a
            // NebulaBasedSpecObjectsViewer
            assert (parent instanceof CompositeTable);
            Composite ancestor = parent;
            while ((ancestor != null) && !(ancestor instanceof NebulaBasedSpecObjectsComposite)) {
                ancestor = ancestor.getParent();
            }
            assert (ancestor != null);
            myViewer = (NebulaBasedSpecObjectsComposite)ancestor;

            // get view
            if( myViewer.toolExtension.getViews().size() == 0 ) {
                return;
            }
            View selectedView = (View)myViewer.toolExtension.getViews().get( 0 );

            // check if there are elements to be shown in the selected view
            if( selectedView.getViewElements().size() == 0 ) {
                return;
            }

            // Sort view elements in visual order (row first, index in list second)
            final List<ViewElement> viewElementList = new ArrayList<ViewElement>();
            viewElementList.addAll( selectedView.getViewElements() );
            Collections.sort( viewElementList, new Comparator<ViewElement>() {
                @Override
                public int compare( ViewElement elem1, ViewElement elem2 ) {
                    int elemRow1 = elem1.getEditorRowNumber();
                    int elemRow2 = elem2.getEditorRowNumber();
                    return elemRow1 != elemRow2 ? elemRow1 - elemRow2 : viewElementList.indexOf( elem1 )
                        - viewElementList.indexOf( elem2 );
                }
            } );

            // we must always begin row count with the first element's row number:
            int firstRow = viewElementList.get( 0 ).getEditorRowNumber();

            // calc maxColumnSpan
            int maxColumnSpan = 0;
            int curRow = firstRow;
            int curSpan = 0;
            for( ViewElement viewElement : viewElementList ) {
                int r = viewElement.getEditorRowNumber();
                // do we have a row switch at this point of iteration?
                if( r > curRow ) {
                    // WARNING: this code block is not executed for the end of the last line!
                    // reset
                    curRow = r;
                    curSpan = 0;
                }
                curSpan += viewElement.getEditorColumnSpan() + (viewElement.isEditorShowLabel() ? 1 : 0);
                // always check the column count: is it a new maximum?
                if( maxColumnSpan < curSpan ) maxColumnSpan = curSpan;
            }

            this.dataFields = new HashMap<String, Control>( viewElementList.size() );

            GridLayout gridLayout = new GridLayout( maxColumnSpan, true );
            setLayout( gridLayout );

            curRow = firstRow;
            curSpan = 0;
            for( final ViewElement viewElement : viewElementList ) {
                final int r = viewElement.getEditorRowNumber();
                // do we have a row switch at this point of iteration?
                if( r > curRow ) {
                    // WARNING: this code block is not executed for the end of the last line!
                    // 1) finalize intermediate rows:
                    int paddingColumnSpan = maxColumnSpan - curSpan;
                    if( paddingColumnSpan > 0 ) {
                        // padding: fill up this line with an empty label
                        Label labelLongName = new Label( this, SWT.NULL );
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
                    Label labelLongName = new Label( this, SWT.NULL );
                    labelLongName.setText( viewElement.getAttributeDefinition().getLongName() + ":" );
                    labelLongName.setLayoutData( new GridData( SWT.RIGHT, SWT.CENTER, false, false, 1, 1 ) );
                }

                Control currentControl = null;
                DatatypeDefinition dataTypeDefinition = viewElement.getAttributeDefinition().getType();
                if( dataTypeDefinition != null ) {
                    switch (dataTypeDefinition.eClass().getClassifierID()) {
                    case ErfPackage.DATATYPE_DEFINITION_INTEGER:
                    case ErfPackage.DATATYPE_DEFINITION_STRING:
                        final Text textField = new Text( this, SWT.BORDER );
                        textField.addModifyListener( new ModifyListener() {
                            @Override
                            public void modifyText( ModifyEvent e ) {
                                if( myViewer.selectedSpecObject == null ) {
                                    return;
                                }
                                myViewer.setValue( myViewer.selectedSpecObject,
                                                   viewElement.getAttributeDefinition(),
                                                   textField.getText() );
                            }
                        } );
                        currentControl = textField;
                        break;
                    }
                }

                if( currentControl != null ) {
                    currentControl.setLayoutData( new GridData( SWT.FILL, SWT.CENTER, true, false, controlSpan, 1 ) );
                    dataFields.put( viewElement.getAttributeDefinition().getID(), currentControl );
                }
            }
        }
    }

}
