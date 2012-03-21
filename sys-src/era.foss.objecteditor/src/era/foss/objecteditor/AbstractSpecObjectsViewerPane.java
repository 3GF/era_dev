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
 * $Id: AbstractSpecObjectsViewerPane.java 331 2011-06-01 22:55:34Z cpn $
 *************************************************************************/
package era.foss.objecteditor;

import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;

import era.foss.erf.ERF;

/**
 * The Class SpecObjectsViewerPane.
 */
public abstract class AbstractSpecObjectsViewerPane extends ViewerPane {

    /** EditingDomain, being required for the Command creation. */
    protected AdapterFactoryEditingDomain editingDomain = null;

    /** The erf model. */
    protected ERF erfModel = null;

    /**
     * Instantiates a new spec objects viewer pane.
     * 
     * @param page the page
     * @param erfEditor the erf editor
     * @param parent the parent
     */
    public AbstractSpecObjectsViewerPane( IWorkbenchPage page, IEditorPart erfEditor, Composite parent ) {
        super( page, erfEditor );

        this.editingDomain = (AdapterFactoryEditingDomain)((IEditingDomainProvider)erfEditor).getEditingDomain();
        this.erfModel = (ERF)((IEditingDomainProvider)erfEditor).getEditingDomain()
                                                                             .getResourceSet()
                                                                             .getResource( EditUIUtil.getURI( erfEditor.getEditorInput() ),
                                                                                           true )
                                                                             .getContents()
                                                                             .get( 0 );
        
        // Create Viewer, i.e. implicitly calls createViewer(..) below
        this.createControl( parent );
    }

}
