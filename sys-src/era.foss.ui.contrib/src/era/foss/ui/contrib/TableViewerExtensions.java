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
package era.foss.ui.contrib;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;


/**
 * The Class TableViewerExtensions.
 */
public class TableViewerExtensions 
{
    
    /**
     * Requires a TableViewer. Will translate a MouseClick into the active column. Primary use-case: reset column value
     * to its default value.
     * 
     * @param tableViewer the table viewer
     */
    public static void addActiveColumnDetection( final TableViewer tableViewer ) {
        tableViewer.getTable().addMouseListener( new MouseAdapter() {

            public void mouseDown( MouseEvent e ) {
                int x = 0;
                for( int i = 0; i < tableViewer.getTable().getColumnCount(); i++ ) {
                    x += tableViewer.getTable().getColumn( i ).getWidth();
                    if( e.x <= x ) {
                        ((IActiveColumn) tableViewer).setActiveColumn(i);
                        break;
                    }
                }
            }

        } );
    }
}
