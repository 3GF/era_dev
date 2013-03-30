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
package era.foss.typeeditor.datatype;

import org.eclipse.jface.viewers.OwnerDrawLabelProvider;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Event;

import era.foss.erf.Color;
import era.foss.erf.EnumValue;

/**
 * The Class EnumColorLabelProvider.
 */
public class EnumColorLabelProvider extends OwnerDrawLabelProvider {

    @Override
    protected void paint( Event event, Object element ) {
        // TODO Auto-generated method stub
        assert (element instanceof EnumValue);

        Color color = ((EnumValue)element).getColor();
        event.gc.setBackground( color.getColor() );
        Rectangle bounds = event.getBounds();
        bounds.width += 100;
        event.gc.fillRectangle( bounds );
    }

    @Override
    protected void measure( Event event, Object element ) {
        // event.setBounds(new Rectangle(event.x, event.y, country.getWidth(event),
        // country.getHeight(event)));

    }
}
