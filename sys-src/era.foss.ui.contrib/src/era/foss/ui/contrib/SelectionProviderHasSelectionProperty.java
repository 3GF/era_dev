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

import org.eclipse.core.databinding.property.INativePropertyListener;
import org.eclipse.core.databinding.property.IProperty;
import org.eclipse.core.databinding.property.ISimplePropertyListener;
import org.eclipse.core.databinding.property.NativePropertyListener;
import org.eclipse.core.databinding.property.value.SimpleValueProperty;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;

/**
 * The Class SelectionProviderHasSelectionProperty.
 */
public class SelectionProviderHasSelectionProperty extends SimpleValueProperty {

    /* (non-Javadoc)
     * @see org.eclipse.core.databinding.property.value.IValueProperty#getValueType()
     */
    @Override
    public Object getValueType() {
        // TODO Auto-generated method stub
        return Boolean.class;
    }

    @Override
    protected Object doGetValue( Object source ) {
        ISelection selection = ((ISelectionProvider)source).getSelection();
        if( selection instanceof IStructuredSelection ) {
            return (!((IStructuredSelection)selection).isEmpty());
        }
        return null;
    }

    @Override
    protected void doSetValue( Object source, Object value ) {
        // do nothing
    }

    @Override
    public INativePropertyListener adaptListener( ISimplePropertyListener listener ) {
        return new SelectionChangedListener( this, listener );
    }

    /**
     * The listener interface for receiving selectionChanged events.
     * The class that is interested in processing a selectionChanged
     * event implements this interface, and the object created
     * with that class is registered with a component using the
     * component's <code>addSelectionChangedListener<code> method. When
     * the selectionChanged event occurs, that object's appropriate
     * method is invoked.
     *
     * @see SelectionChangedEvent
     */
    private class SelectionChangedListener extends NativePropertyListener implements ISelectionChangedListener {

        SelectionChangedListener( IProperty property, ISimplePropertyListener listener ) {
            super( property, listener );
        }

        public void selectionChanged( SelectionChangedEvent event ) {
            fireChange( event.getSource(), null );
        }

        public void doAddTo( Object source ) {
            ((ISelectionProvider)source).addSelectionChangedListener( this );
        }

        public void doRemoveFrom( Object source ) {
            ((ISelectionProvider)source).removeSelectionChangedListener( this );
        }
    }
}
