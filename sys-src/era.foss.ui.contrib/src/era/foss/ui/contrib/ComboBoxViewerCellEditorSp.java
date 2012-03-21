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
 * $Id: ComboBoxViewerCellEditorSp.java 346 2011-07-09 18:10:18Z schorsch $
 *************************************************************************/
package era.foss.ui.contrib;

import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Composite;

/**
 * Wrapper for ComboBoxViewerCellEditor providing an ISelectionProvider interface.
 */
public class ComboBoxViewerCellEditorSp extends ComboBoxViewerCellEditor implements ISelectionProvider {

    /**
     * Instantiates a new combo box viewer cell editor sp.
     * 
     * @param parent the parent {@link ComboBoxViewerCellEditor#ComboBoxViewerCellEditor(Composite)}
     */
    public ComboBoxViewerCellEditorSp( Composite parent ) {
        super( parent );
    }

    /**
     * Instantiates a new {@link ComboBoxViewerCellEditorSp}
     * 
     * @param parent the parent
     * @param style the style {@link ComboBoxViewerCellEditor#ComboBoxViewerCellEditor(Composite, int)}
     */
    public ComboBoxViewerCellEditorSp( Composite parent, int style ) {
        super( parent, style );
    }

    /**
     * Adds the selection changed listener.
     * 
     * @param listener the listener {@link ISelectionProvider#addSelectionChangedListener(ISelectionChangedListener)}
     */
    @Override
    public void addSelectionChangedListener( ISelectionChangedListener listener ) {
        getViewer().addSelectionChangedListener( listener );
    }

    /**
     * Gets the selection.
     * 
     * @return the selection {@link ISelectionProvider#getSelection()}
     */
    @Override
    public ISelection getSelection() {
        return getViewer().getSelection();
    }

    /**
     * Removes the selection changed listener.
     * 
     * @param listener the listener {@link ISelectionProvider#removeSelectionChangedListener(ISelectionChangedListener)}
     */
    @Override
    public void removeSelectionChangedListener( ISelectionChangedListener listener ) {
        getViewer().removeSelectionChangedListener( listener );
    }

    /**
     * Sets the selection.
     * 
     * @param selection the new selection {@link ISelectionProvider#setSelection(ISelection)}
     */
    @Override
    public void setSelection( ISelection selection ) {
        getViewer().setSelection( selection );
    }
}
