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
import org.eclipse.core.databinding.property.ISimplePropertyListener;
import org.eclipse.core.databinding.property.SimplePropertyEvent;
import org.eclipse.core.databinding.property.value.SimpleValueProperty;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.NotifyingList;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

/**
 * The Class NotifyingListSizeProperty.
 */
public class NotifyingListSizeProperty extends SimpleValueProperty {
    @Override
    @SuppressWarnings({"rawtypes"})
    protected Object doGetValue( final Object source ) {
        return ((NotifyingList)source).size();
    }

    @Override
    protected void doSetValue( final Object source, final Object value ) {
        throw new UnsupportedOperationException( this.toString() + " is unmodifiable" );
    }

    @Override
    public INativePropertyListener adaptListener( final ISimplePropertyListener listener ) {
        return new Listener( listener );
    }

    /**
     * The Class Listener.
     */
    private class Listener extends AdapterImpl implements INativePropertyListener {
        
        /** The delegate. */
        ISimplePropertyListener delegate;

        public Listener( final ISimplePropertyListener delegate ) {
            this.delegate = delegate;
        }

        @SuppressWarnings({"rawtypes"})
        public void addTo( final Object source ) {
            if( source != null ) {
                ((Notifier)((NotifyingList)source).getNotifier()).eAdapters().add( this );
            }
        }

        @SuppressWarnings({"rawtypes"})
        public void removeFrom( final Object source ) {
            if( source != null ) {
                ((Notifier)((NotifyingList)source).getNotifier()).eAdapters().remove( this );
            }
        }

        @Override
        public void notifyChanged( final Notification msg ) {
            this.delegate.handleEvent( new SimplePropertyEvent(
                SimplePropertyEvent.CHANGE,
                msg.getNotifier(),
                NotifyingListSizeProperty.this,
                null ) );
        }
    }

    @Override
    public String toString() {
        return "EList.size <int>";
    }

    /* (non-Javadoc)
     * @see org.eclipse.core.databinding.property.value.IValueProperty#getValueType()
     */
    @Override
    public Object getValueType() {
        return Integer.class;
    }

}
