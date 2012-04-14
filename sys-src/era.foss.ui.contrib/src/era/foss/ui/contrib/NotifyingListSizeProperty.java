package era.foss.ui.contrib;

import org.eclipse.core.databinding.property.INativePropertyListener;
import org.eclipse.core.databinding.property.ISimplePropertyListener;
import org.eclipse.core.databinding.property.SimplePropertyEvent;
import org.eclipse.core.databinding.property.value.SimpleValueProperty;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.NotifyingList;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

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

    private class Listener extends AdapterImpl implements INativePropertyListener {
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

    @Override
    public Object getValueType() {
        return Integer.class;
    }

}
