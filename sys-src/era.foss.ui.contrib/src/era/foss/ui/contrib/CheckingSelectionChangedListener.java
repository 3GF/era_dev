package era.foss.ui.contrib;

import java.util.List;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;

/**
 * Selection change listener which checks if the elements are already selected before setting the new selection of
 * elements. This is useful for preventing loops if to viewers listen to each other changes.
 */
public class CheckingSelectionChangedListener implements ISelectionChangedListener {

    private ISelectionProvider provider;

    /**
     * @param provider the selction provider where the selected elements are set
     */
    public CheckingSelectionChangedListener( ISelectionProvider provider ) {
        this.provider = provider;
    }

    @Override
    public void selectionChanged( SelectionChangedEvent event ) {
        List<?> currentSelection = ((IStructuredSelection)provider.getSelection()).toList();

        if( !currentSelection.containsAll( ((IStructuredSelection)event.getSelection()).toList() ) ) {
            provider.setSelection( event.getSelection() );
        }
    }

}
