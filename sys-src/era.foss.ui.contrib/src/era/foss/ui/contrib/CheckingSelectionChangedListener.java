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

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;

/**
 * Selection change listener which checks if the elements are already selected before setting the new selection of
 * elements. This is useful for preventing loops if to viewers listen to each other changes.
 *
 * @see CheckingSelectionChangedEvent
 */
public class CheckingSelectionChangedListener implements ISelectionChangedListener {

    /** The provider. */
    private ISelectionProvider provider;

    /**
     * Instantiates a new checking selection changed listener.
     *
     * @param provider the selection provider where the selected elements are set
     */
    public CheckingSelectionChangedListener( ISelectionProvider provider ) {
        this.provider = provider;
    }

    @Override
    public void selectionChanged( SelectionChangedEvent event ) {

        final List<?> currentSelectionList = ((IStructuredSelection)provider.getSelection()).toList();
        final ISelection eventSelection = event.getSelection();
        final List<?> eventSelectionList = ((IStructuredSelection)eventSelection).toList();
        if( currentSelectionList.size() != eventSelectionList.size()
            || !currentSelectionList.containsAll( eventSelectionList ) ) {
            provider.setSelection( eventSelection );
        }

    }

}
