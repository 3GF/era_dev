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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.gef.CompoundSnapToHelper;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;

import era.foss.erf.View;

/**
 * Our hello "root" edit part, this one will contains our nodes EditParts...
 */
public class ViewEditPart extends AbstractGraphicalEditPart {

    /**
     * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
     **/
    protected IFigure createFigure() {

        Figure f = new FreeformLayer();
        f.setLayoutManager( new FreeformLayout() );

        /*
         * In case no border is set snapToGrid breaks when selecting an element at the border of the drawing area
         */
        f.setBorder( new MarginBorder( 5 ) );

        return f;
    }

    /**
     * Register layout policies for this EditPart.
     */
    protected void createEditPolicies() {
        installEditPolicy( EditPolicy.COMPONENT_ROLE, new RootComponentEditPolicy() );
        installEditPolicy( EditPolicy.LAYOUT_ROLE, new NodeEditPolicy() );
    }

    /**
     * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren() You must implement this method if you want you
     *      root model to have children!
     **/
    protected List<Object> getModelChildren() {
        View view = (View)this.getModel();
        Object children[] = ((ViewLayoutViewer)this.getViewer()).filter( view, view.getViewElements().toArray() );
        return Arrays.asList( children );
    }

    public Object getAdapter( @SuppressWarnings("rawtypes") Class adapter ) {
        if( adapter == SnapToHelper.class ) {
            List<SnapToGrid> snapStrategies = new ArrayList<SnapToGrid>();
            snapStrategies.add( new SnapToGrid( this ) );
            SnapToHelper ss[] = new SnapToHelper[snapStrategies.size()];
            for( int i = 0; i < snapStrategies.size(); i++ )
                ss[i] = (SnapToHelper)snapStrategies.get( i );
            return new CompoundSnapToHelper( ss );
        }
        return super.getAdapter( adapter );
    }

}
