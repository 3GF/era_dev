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
package era.foss.typeeditor;

import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.IEditorPart;

import era.foss.erf.DatatypeDefinition;
import era.foss.erf.ERF;
import era.foss.erf.EraToolExtension;
import era.foss.erf.ErfPackage;
import era.foss.erf.SpecType;
import era.foss.erf.ToolExtension;
import era.foss.objecteditor.EraCommandStack;
import era.foss.objecteditor.IAllowViewerSchemaChange;
import era.foss.typeeditor.datatype.DatatypeDefinitionsForm;
import era.foss.typeeditor.spectype.SpecTypeForm;
import era.foss.typeeditor.view.ViewForm;

/**
 * The topmost UI class of the typeeditor plug-in: representing the overall dialog.
 * <p>
 * Structured by a tab folder for which it instantiates forms for DatatypeDefinitions and SpecificationTypes.
 * <p>
 * Instantiates the {@link EraCommandStack} for handling the OK and Cancel buttons.
 * 
 */
public class TypeDialog extends TitleAreaDialog {

    /** The editor. */
    private IEditorPart editor = null;

    /** The editing domain. */
    private EditingDomain editingDomain = null;
    // commandStack is required for Ok and Cancel Buttons
    /** The era command stack. */
    private EraCommandStack eraCommandStack = null;

    /** The type editor activator. */
    private Activator typeEditorActivator = null;

    private ERF erfModel;

    private Resource erfResource;

    /**
     * Era Tool extension model object
     */
    private EraToolExtension toolExtension;

    /**
     * Creates a editor for Datatype, Attributes and Spectypes.
     * 
     * @param activeShell the active shell
     * @param editor the editor
     */
    public TypeDialog( Shell activeShell, IEditorPart editor ) {
        super( activeShell );
        setShellStyle( getShellStyle() | SWT.RESIZE | SWT.MAX );

        // set-up context
        this.editor = editor;
        this.editingDomain = ((IEditingDomainProvider)editor).getEditingDomain();
        URI resourceURI = EditUIUtil.getURI( editor.getEditorInput() );
        this.erfResource = editingDomain.getResourceSet().getResource( resourceURI, true );
        this.erfModel = (ERF)erfResource.getContents().get( 0 );
        this.eraCommandStack = (EraCommandStack)editingDomain.getCommandStack();
        this.typeEditorActivator = era.foss.typeeditor.Activator.INSTANCE;

        // find Era specific tool extensions
        for( ToolExtension toolExtension : this.erfModel.getToolExtensions() ) {
            if( toolExtension.eClass().getClassifierID() == ErfPackage.ERA_TOOL_EXTENSION ) {
                this.toolExtension = (EraToolExtension)toolExtension;
            }
        }
        assert (this.toolExtension != null);

        // plant an initial checkpoint
        this.eraCommandStack.plantCheckpoint();

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
     */
    protected void configureShell( Shell shell ) {
        super.configureShell( shell );
        shell.setText( typeEditorActivator.getString( "_UI_Type_Editor_label" ) );
        shell.setMinimumSize( 1000, 400 );
    }

    /*
     * (non-Javadoc) Method declared on Dialog.
     */
    protected Control createDialogArea( Composite parent ) {
        Composite composite = (Composite)super.createDialogArea( parent );

        TabFolder typeEditorTabFolder = new TabFolder( composite, SWT.NONE );
        typeEditorTabFolder.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true ) );

        // Lists for TabItems: Controls and Labels
        Control[] listOfControls = {
            new ViewForm( typeEditorTabFolder, this.editor ),
            new SpecTypeForm( typeEditorTabFolder, this.editor ),
            new DatatypeDefinitionsForm( typeEditorTabFolder, this.editor )};
        String[] listOfTabLabels = {
            typeEditorActivator.getString( "_UI_ViewTab_label" ),
            typeEditorActivator.getString( "_UI_SpecTypeTab_label" ),
            typeEditorActivator.getString( "_UI_DataTypeDefinitionTab_label" )};
        TabItem additionalTabItem = null;
        for( int iter = 0; iter < listOfControls.length; ++iter ) {
            additionalTabItem = new TabItem( typeEditorTabFolder, SWT.NONE );
            additionalTabItem.setText( listOfTabLabels[iter] );
            additionalTabItem.setControl( listOfControls[iter] );
        }
        additionalTabItem = null;

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
        // validate model
        BasicDiagnostic diagnostic = Diagnostician.INSTANCE.createDefaultDiagnostic( erfModel.getCoreContent() );
        for( DatatypeDefinition dataType : erfModel.getCoreContent().getDataTypes() ) {
            Diagnostician.INSTANCE.validate( dataType, diagnostic );
        }
        for( SpecType specType : erfModel.getCoreContent().getSpecTypes() ) {
            Diagnostician.INSTANCE.validate( specType, diagnostic );
        }
        Diagnostician.INSTANCE.validate( toolExtension, diagnostic );

        if( !diagnostic.getChildren().isEmpty() ) {
            MessageDialog dialog = new MessageDialog(
                this.getShell(),
                typeEditorActivator.getString( "_UI_ValidationErrorDialog_title" ),
                null,
                typeEditorActivator.getString( "_UI_ValidationErrorDialog_text" ),
                MessageDialog.ERROR,
                new String[]{"OK"},
                0 );
            dialog.open();

            String errorMessage = "";
            for( Diagnostic diagnosticChildren : diagnostic.getChildren() ) {
                errorMessage += diagnosticChildren.getMessage() + "\n";
            }
            this.setErrorMessage( errorMessage );
        } else {
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

}
