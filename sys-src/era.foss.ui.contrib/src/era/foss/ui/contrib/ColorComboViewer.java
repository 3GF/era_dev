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
package era.foss.ui.contrib;

import java.util.List;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

/**
 * The Class ColorComboViewer.
 */
public class ColorComboViewer extends ComboViewer {

    /**
     * Instantiates a new color combo viewer.
     *
     * @param parent the parent
     */
    public ColorComboViewer( Composite parent ) {
        super( parent );
    }

    /**
     * Instantiates a new color combo viewer.
     *
     * @param list the list
     */
    public ColorComboViewer( Combo list ) {
        super( list );
    }

    /**
     * Instantiates a new color combo viewer.
     *
     * @param list the list
     */
    public ColorComboViewer( CCombo list ) {
        super( list );
    }

    /**
     * Instantiates a new color combo viewer.
     *
     * @param parent the parent
     * @param style the style
     */
    public ColorComboViewer( Composite parent, int style ) {
        super( parent, style );
    }

    @Override
    protected void setSelectionToWidget( @SuppressWarnings("rawtypes") List in, boolean reveal ) {
        super.setSelectionToWidget( in, reveal );
        IBaseLabelProvider labelProvider = this.getLabelProvider();
        IStructuredSelection elementList = (IStructuredSelection)this.getSelection();
        if( labelProvider instanceof IColorProvider ) {
            IColorProvider colorProvider = (IColorProvider)labelProvider;

            if( elementList.isEmpty() ) {
                this.getControl().setBackground( colorProvider.getBackground( null ) );
                this.getControl().setForeground( colorProvider.getForeground( null ) );

            } else {
                this.getControl().setBackground( colorProvider.getBackground( elementList.getFirstElement() ) );
                this.getControl().setForeground( colorProvider.getForeground( elementList.getFirstElement() ) );
            }
        }

    }

}
