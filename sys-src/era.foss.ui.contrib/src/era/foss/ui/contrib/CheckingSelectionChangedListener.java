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
 */
public class CheckingSelectionChangedListener implements ISelectionChangedListener {

    private ISelectionProvider provider;

    /**
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
