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
package era.foss.typeeditor.view.layoutviewer;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import era.foss.erf.View;
import era.foss.erf.ViewElement;

/**
 * Edit parts factory for Gef sample. This factory returns EditPart corresponding to a given model object. In our simple
 * example, an HelloTopEditPart is returned for the top-most HelloModel object, and HelloEditPart is returned for the
 * HelloNodeModel objects (which are children of the HelloModel object).
 **/
public class GraphicalPartFactory implements EditPartFactory {

    /**
     * @see org.eclipse.gef.EditPartFactory#createEditPart(EditPart, Object)
     **/
    public EditPart createEditPart( EditPart iContext, Object iModel ) {

        EditPart editPart = null;

        if( iModel instanceof View ) {
            editPart = new ViewEditPart();
        } else if( iModel instanceof ViewElement ) {
            editPart = new ViewElementEditPart();
        }

        if( editPart != null ) {
            editPart.setModel( iModel );
        }

        return editPart;
    }

}
