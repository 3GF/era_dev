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

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;

/**
 * The Class SpecObjectsViewerPane.
 */
public class SpecObjectsViewerPane extends AbstractSpecObjectsViewerPane {

    /**
     * Instantiates a new spec objects viewer pane.
     * 
     * @param page the page
     * @param erfEditor the erf editor
     * @param parent the parent
     */
    public SpecObjectsViewerPane( IWorkbenchPage page, IEditorPart erfEditor, Composite parent ) {
        super( page, erfEditor, parent );
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.emf.common.ui.ViewerPane#createViewer(org.eclipse.swt.widgets.Composite)
     */
    @Override
    public Viewer createViewer( Composite parent ) {
        SpecObjectsViewer viewer = new SpecObjectsViewer( parent, editingDomain, erfModel );
        viewer.setup();
        return viewer;
    }

}
