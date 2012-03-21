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
package era.foss.vieweditor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.databinding.viewers.IViewerObservableValue;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableValueEditingSupport;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;

import era.foss.erf.AttributeDefinition;
import era.foss.erf.ERF;
import era.foss.erf.EraToolExtension;
import era.foss.erf.ErfPackage;
import era.foss.erf.SpecType;
import era.foss.erf.ToolExtension;
import era.foss.erf.View;
import era.foss.objecteditor.EraCommandStack;
import era.foss.objecteditor.IAllowViewerSchemaChange;
import era.foss.typeeditor.AddDeleteTableViewer;
import era.foss.typeeditor.Ui;
import era.foss.typeeditor.ui.BindingCheckBox;
import era.foss.typeeditor.ui.BindingText;
import era.foss.ui.contrib.ComboBoxViewerCellEditorSp;

/**
 * The topmost UI class of the typeeditor plug-in: representing the overall dialog.
 * <p>
 * Structured by a tab folder for which it instantiates forms for DatatypeDefinitions and SpecificationTypes.
 * <p>
 * Instantiates the {@link EraCommandStack} for handling the OK and Cancel buttons.
 * 
 */
public class ViewDialog extends Dialog {

    /** The editor. */
    private IEditorPart editor = null;

    /** The editing domain. */
    private EditingDomain editingDomain = null;
    // commandStack is required for Ok and Cancel Buttons
    /** The era command stack. */
    private EraCommandStack eraCommandStack = null;

    /** The type editor activator. */
    private Activator viewEditorActivator = null;

    /** the erf model */
    ERF erfModel;

    /**
     * Era Tool extension model object
     */
    private EraToolExtension toolExtension;

    /** UI object for helper methods */
    Ui ui;

    /** The databinding context for binding model elements to widgets show in this dialog */
    DataBindingContext dataBindContext;

    /** Master object for observing the selected {@link View}s */
    private IViewerObservableValue viewMaster;

    /** Master object for observing the selected {@link ViewElement}s */
    private IViewerObservableValue viewElementMaster;

    /**
     * Creates a editor for Datatype, Attributes and Spectypes.
     * 
     * @param activeShell the active shell
     * @param editor the editor
     */
    public ViewDialog( Shell activeShell, IEditorPart editor ) {
        super( activeShell );
        setShellStyle( getShellStyle() | SWT.RESIZE | SWT.MAX );

        // set-up context
        this.editor = editor;
        this.editingDomain = ((IEditingDomainProvider)editor).getEditingDomain();
        this.eraCommandStack = (EraCommandStack)editingDomain.getCommandStack();
        this.viewEditorActivator = era.foss.vieweditor.Activator.INSTANCE;

        // plant an initial checkpoint
        this.eraCommandStack.plantCheckpoint();

        // check and fix model
        Resource erfResource = (XMIResource)editingDomain.getResourceSet()
                                                         .getResource( EditUIUtil.getURI( editor.getEditorInput() ),
                                                                       true );
        this.erfModel = (ERF)(erfResource).getContents().get( 0 );

        // find Era specific tool extensions
        for( ToolExtension toolExtension : this.erfModel.getToolExtensions() ) {
            if( toolExtension.eClass().getClassifierID() == ErfPackage.ERA_TOOL_EXTENSION ) {
                this.toolExtension = (EraToolExtension)toolExtension;
            }
        }
        assert (this.toolExtension != null);

        dataBindContext = new DataBindingContext();

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
     */
    protected void configureShell( Shell shell ) {
        super.configureShell( shell );
        shell.setText( viewEditorActivator.getString( "_UI_View_Editor_label" ) );
        shell.setMinimumSize( 800, 400 );
    }

    /*
     * (non-Javadoc) Method declared on Dialog.
     */
    protected Control createDialogArea( Composite parent ) {
        ui = new Ui( editingDomain );
        Composite composite = (Composite)super.createDialogArea( parent );
        composite.addDisposeListener( new DisposeListener() {

            @Override
            public void widgetDisposed( DisposeEvent e ) {
                ViewDialog.this.ui.dispose();

            }
        } );
        composite.setLayout( new GridLayout( 3, true ) );

        createViewTableViewer( composite );
        createViewElementTableViewer( composite );
        createDetails( composite );

        // (font of parent will be applied recursively to the newly added controls!)
        applyDialogFont( composite );

        return composite;
    }

    /**
     * Ok pressed.
     * 
     * @see org.eclipse.jface.dialogs.Dialog#okPressed()
     * @since 03.03.2010
     */
    protected void okPressed() {
        super.okPressed();
        // the performed commands should not be available for undo after OK.
        eraCommandStack.inhibitUndos();

        // redraw the SpecObject editor
        if( editor instanceof IViewerProvider ) {
            Viewer viewer = ((IViewerProvider)editor).getViewer();
            if( viewer instanceof IAllowViewerSchemaChange ) {
                ((IAllowViewerSchemaChange)viewer).recreateViewerSchema();
            }
        }
    }

    /**
     * Cancel pressed.
     * 
     * @see org.eclipse.jface.dialogs.Dialog#cancelPressed()
     * @since 03.03.2010
     */
    protected void cancelPressed() {
        super.cancelPressed();
        // undo the complete CommandStack:
        eraCommandStack.rollback();
    }

    /**
     * Creates the table viewer for {@link View}s
     */
    private void createViewTableViewer( Composite composite ) {

        AddDeleteTableViewer viewTableViewer = new AddDeleteTableViewer( composite, SWT.MULTI
            | SWT.V_SCROLL
            | SWT.BORDER
            | SWT.FULL_SELECTION );
        viewTableViewer.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true ) );
        viewTableViewer.setEditingDomain( editingDomain );
        viewTableViewer.setElementInformation( toolExtension,
                                               ErfPackage.Literals.ERA_TOOL_EXTENSION__VIEWS,
                                               ErfPackage.Literals.VIEW );

        ObservableListContentProvider cp = new ObservableListContentProvider();
        viewTableViewer.setContentProvider( cp );

        TableColumnLayout columnLayout = (TableColumnLayout)viewTableViewer.getTable().getParent().getLayout();

        // create column with name of the view
        TableViewerColumn nameColumn = new TableViewerColumn( viewTableViewer, SWT.NONE );
        columnLayout.setColumnData( nameColumn.getColumn(), new ColumnWeightData( 100, 70 ) );
        nameColumn.getColumn().setResizable( false );
        nameColumn.getColumn().setMoveable( false );
        nameColumn.getColumn().setText( Ui.getUiName( ErfPackage.Literals.IDENTIFIABLE__LONG_NAME ) );
        ui.bindColumn( nameColumn, new EStructuralFeature[]{ErfPackage.Literals.IDENTIFIABLE__LONG_NAME} );

        // provide input for the table
        IEMFListProperty viewsProperty = EMFProperties.list( ErfPackage.Literals.ERA_TOOL_EXTENSION__VIEWS );
        viewTableViewer.setInput( viewsProperty.observe( toolExtension ) );
        viewTableViewer.getTable().select( 0 );

        this.viewMaster = ViewerProperties.singleSelection().observe( viewTableViewer );

    }

    /**
     * Creates the table viewer for {@link ViewElements}
     */
    private void createViewElementTableViewer( Composite composite ) {
        final AddDeleteTableViewer viewElementTableViewer = new AddDeleteTableViewer( composite, SWT.MULTI
            | SWT.V_SCROLL
            | SWT.BORDER
            | SWT.FULL_SELECTION
            | AddDeleteTableViewer.NO_DESCRIPTION ) {

            @Override
            public void addElement() {
                this.elementOwner = (EObject)viewMaster.getValue();
                super.addElement();
            }
        };

        // the owner is null as it is set in the overridden addElement() method
        viewElementTableViewer.setElementInformation( (EObject)viewMaster.getValue(),
                                                      ErfPackage.Literals.VIEW__VIEW_ELEMENTS,
                                                      ErfPackage.Literals.VIEW_ELEMENT );

        viewElementTableViewer.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true ) );
        viewElementTableViewer.setEditingDomain( editingDomain );

        ObservableListContentProvider cp = new ObservableListContentProvider();
        viewElementTableViewer.setContentProvider( cp );

        TableColumnLayout columnLayout = (TableColumnLayout)viewElementTableViewer.getTable().getParent().getLayout();

        // create column showing the Attribute Definition
        TableViewerColumn attributeDefinitionColumn = new TableViewerColumn( viewElementTableViewer, SWT.NONE );
        columnLayout.setColumnData( attributeDefinitionColumn.getColumn(), new ColumnWeightData( 100, 70 ) );
        attributeDefinitionColumn.getColumn().setResizable( false );
        attributeDefinitionColumn.getColumn().setMoveable( false );
        attributeDefinitionColumn.getColumn()
                                 .setText( Ui.getUiName( ErfPackage.Literals.VIEW_ELEMENT__ATTRIBUTE_DEFINITION ) );

        // label provider for column showing the AttributeDefintion
        IValueProperty elementProperty = EMFEditProperties.value( editingDomain,
                                                                  FeaturePath.fromList( new EStructuralFeature[]{
                                                                      ErfPackage.Literals.VIEW_ELEMENT__ATTRIBUTE_DEFINITION,
                                                                      ErfPackage.Literals.IDENTIFIABLE__LONG_NAME} ) );
        IObservableMap attributeMap = elementProperty.observeDetail( cp.getKnownElements() );
        attributeDefinitionColumn.setLabelProvider( new ObservableMapCellLabelProvider( attributeMap ) );

        // editing support column showing the AttributeDefintion

        // Combo box: Create combo box to select choices for the reference
        ComboBoxViewerCellEditor combo = new ComboBoxViewerCellEditorSp(
            (Composite)viewElementTableViewer.getControl(),
            SWT.READ_ONLY );
        // Combo box: Set Content Provider;
        combo.setContenProvider( new ArrayContentProvider() );

        // Combo box: Set Label Provider
        combo.setLabelProvider( new LabelProvider() {

            @Override
            public String getText( Object element ) {
                String text = ((AttributeDefinition)element).getSpecType().getLongName() + ":";
                text += ((AttributeDefinition)element).getLongName();
                return text;
            }
        } );

        // Combo box: set input to all attribute definitions of all spectypes
        List<AttributeDefinition> attributeDefintionList = new ArrayList<AttributeDefinition>();
        for( SpecType specType : erfModel.getCoreContent().getSpecTypes() ) {
            attributeDefintionList.addAll( specType.getSpecAttributes() );
        }

        combo.setInput( attributeDefintionList.toArray() );

        // Set editing support of table cell
        IValueProperty editorElementProperty = EMFEditProperties.value( editingDomain,
                                                                        ErfPackage.Literals.VIEW_ELEMENT__ATTRIBUTE_DEFINITION );
        IValueProperty cellEditorProperty = ViewerProperties.singleSelection();

        attributeDefinitionColumn.setEditingSupport( ObservableValueEditingSupport.create( viewElementTableViewer,
                                                                                           dataBindContext,
                                                                                           combo,
                                                                                           cellEditorProperty,
                                                                                           editorElementProperty ) );

        // create column showing the SpecType of the referred AttributeDefinition
        TableViewerColumn specTypeColumn = new TableViewerColumn( viewElementTableViewer, SWT.NONE );
        columnLayout.setColumnData( specTypeColumn.getColumn(), new ColumnWeightData( 100, 70 ) );
        specTypeColumn.getColumn().setResizable( false );
        specTypeColumn.getColumn().setMoveable( false );
        specTypeColumn.getColumn().setText( Ui.getUiName( ErfPackage.Literals.ATTRIBUTE_DEFINITION__SPEC_TYPE ) );

        // label provider for column showing the SpecType
        IValueProperty specTypeProperty = EMFEditProperties.value( editingDomain,
                                                                   FeaturePath.fromList( new EStructuralFeature[]{
                                                                       ErfPackage.Literals.VIEW_ELEMENT__ATTRIBUTE_DEFINITION,
                                                                       ErfPackage.Literals.ATTRIBUTE_DEFINITION__SPEC_TYPE,
                                                                       ErfPackage.Literals.IDENTIFIABLE__LONG_NAME} ) );
        IObservableMap specTypeObservableMap = specTypeProperty.observeDetail( cp.getKnownElements() );
        specTypeColumn.setLabelProvider( new ObservableMapCellLabelProvider( specTypeObservableMap ) );

        // provide input for the table
        IEMFListProperty viewsProperty = EMFProperties.list( ErfPackage.Literals.VIEW__VIEW_ELEMENTS );
        viewElementTableViewer.setInput( viewsProperty.observeDetail( viewMaster ) );
        viewElementTableViewer.getTable().select( 0 );

        this.viewElementMaster = ViewerProperties.singleSelection().observe( viewElementTableViewer );
    }

    /**
     * Creates the table viewer.
     */
    private void createDetails( Composite parent ) {

        // composite holding the label and the composite with the widgets
        Composite detailsComposite = new Composite( parent, SWT.NONE );
        detailsComposite.setLayout( new GridLayout( 1, true ) );
        detailsComposite.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true ) );

        // create label for detail viewer
        Label label = new Label( detailsComposite, SWT.NONE );
        label.setLayoutData( new GridData( SWT.LEFT, SWT.TOP, true, false ) );
        label.setText( Activator.INSTANCE.getString( "_UI_Details_label" ) + ":" );

        // Create composite holding the UI elements of the
        final Composite widgetComposite = new Composite( detailsComposite, SWT.BORDER );
        widgetComposite.setLayout( new GridLayout( 2, true ) );
        widgetComposite.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true ) );

        if( viewElementMaster.getValue() != null ) {
            createWidgets( widgetComposite );
        }

        viewElementMaster.addValueChangeListener( new IValueChangeListener() {

            /**
             * Redraw the composite with the widgets
             */
            @Override
            public void handleValueChange( ValueChangeEvent event ) {

                if( event.diff.getNewValue() == null ) {
                    for( Control control : widgetComposite.getChildren() ) {
                        control.dispose();
                    }
                }

                if( event.diff.getNewValue() != null && event.diff.getOldValue() == null ) {
                    createWidgets( widgetComposite );
                }

                // we need this so that the modified content will be drawn
                widgetComposite.layout();
                widgetComposite.redraw();
                widgetComposite.update();

                widgetComposite.getParent().layout();
                widgetComposite.getParent().redraw();
                widgetComposite.getParent().update();
            }
        } );

    }

    private void createWidgets( Composite parent ) {

        // create checkbox for editoShowLabel property
        createCheckbox( parent, ErfPackage.Literals.VIEW_ELEMENT__EDITOR_SHOW_LABEL );

        // text field for editorRowNumber property
        createTextField( parent, ErfPackage.Literals.VIEW_ELEMENT__EDITOR_ROW_NUMBER );

        // text field for editorColumnSpan property
        createTextField( parent, ErfPackage.Literals.VIEW_ELEMENT__EDITOR_COLUMN_SPAN );
    }

    private void createCheckbox( Composite parent, EStructuralFeature eStructuralFeature ) {

        // create label
        Label showLabelLabel = new Label( parent, SWT.NONE );
        showLabelLabel.setText( Ui.getUiName( eStructuralFeature ) );
        showLabelLabel.setLayoutData( new GridData( SWT.LEFT, SWT.CENTER, true, false ) );

        // create checkbox
        BindingCheckBox showLabelCheckbox = new BindingCheckBox( parent, SWT.NONE );
        showLabelCheckbox.bind( editingDomain, eStructuralFeature, viewElementMaster );
        showLabelCheckbox.setLayoutData( new GridData( SWT.LEFT, SWT.DEFAULT, true, false ) );

    }

    private void createTextField( Composite parent, EStructuralFeature eStructuralFeature ) {
        // label for editorRowNumber property
        Label defaultValueLabel = new Label( parent, SWT.NONE );
        defaultValueLabel.setText( Ui.getUiName( eStructuralFeature ) );
        defaultValueLabel.setLayoutData( new GridData( SWT.LEFT, SWT.CENTER, true, false ) );

        // text field for editorRowNumber property
        BindingText defaultValueTextfield = new BindingText( parent, SWT.BORDER );
        defaultValueTextfield.bind( editingDomain, eStructuralFeature, viewElementMaster );
        defaultValueTextfield.setLayoutData( new GridData( SWT.FILL, SWT.CENTER, true, false ) );

    }
}
