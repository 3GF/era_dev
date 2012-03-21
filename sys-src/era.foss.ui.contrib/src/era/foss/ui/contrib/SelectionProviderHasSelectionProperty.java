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

public class SelectionProviderHasSelectionProperty extends SimpleValueProperty {

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
