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

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.views.properties.PropertySheetPage;

/**
 * The properties viewer for the ERA ERF types.
 * <p>
 * The ID, description and long name are filtered from the initially shown property list: in the genmodel all of
 * Identifiable:[ID, desc, long name] and DatatypeDefinitionSimple:[ID, desc, long name] there is an entry in their
 * "Property Filter Flags" being set to "org.eclipse.ui.views.properties.expert".
 * <p>
 * It is a standard functionality from {@link PropertySheetPage} that each property which is tagged by
 * "org.eclipse.ui.views.properties.expert" is filtered from default view.
 * 
 * @author cpn
 * 
 * @see PropertySheetPage
 */
public class TableElemPropertySheet extends Composite {

    /**
     * The reference to the PropertySheetPage.
     * <p>
     * Required to be a member attribute, because it is referenced in the ISelectionChangedListener.
     */
    private PropertySheetPage propertySheetPage = null;

    /**
     * Constructs a new instance of this class - defaulting the style to {@link SWT#NONE}.
     * 
     * @param parent a widget which will be the parent of the new instance (cannot be null)
     * @param editor the editor from which the and {@link CommandStack} can be derived
     * @param modelTableViewer the model table viewer
     * @see #AbstractErfTypesForm(Composite, IEditorPart, int)
     */
    public TableElemPropertySheet( Composite parent, IEditorPart editor, TableViewer modelTableViewer ) {
        this( parent, editor, modelTableViewer, SWT.NONE );
    }

    /**
     * Constructs a new instance of this class.
     * <p>
     * Instantiate a {@link PropertySheetPage} and use {@link PropertySheetPage#createControl(Composite)} to create a
     * control that can be wired into the Composite structure.
     * 
     * @param parent a widget which will be the parent of the new instance (cannot be null)
     * @param editor the editor from which the and {@link CommandStack} can be derived
     * @param modelTableViewer a TableViewer that provides SelectionChangedEvent
     * @param style the style of widget to construct
     */
    public TableElemPropertySheet( Composite parent, IEditorPart editor, TableViewer modelTableViewer, int style ) {
        super( parent, style );

        this.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true ) );

        // set-up context
        EditingDomain editingDomain = ((IEditingDomainProvider)editor).getEditingDomain();
        AdapterFactory adapterFactory = ((AdapterFactoryEditingDomain)editingDomain).getAdapterFactory();

        // create the property sheet page control
        propertySheetPage = new PropertySheetPage();
        propertySheetPage.setPropertySourceProvider( new AdapterFactoryContentProvider( adapterFactory ) );
        // create the PropertySheetViewer and its control (which is a Tree)
        propertySheetPage.createControl(this);


        modelTableViewer.addSelectionChangedListener( new ISelectionChangedListener() {
            public void selectionChanged( SelectionChangedEvent event ) {
                /*
                 * No special TableElemPropertySheet.this.selection.isEmpty() is required. The property viewer is
                 * emptying the list itself.
                 */
                TableElemPropertySheet.this.propertySheetPage.selectionChanged( null, event.getSelection() );
                TableElemPropertySheet.this.propertySheetPage.refresh();
            }
        } );
    }
}
