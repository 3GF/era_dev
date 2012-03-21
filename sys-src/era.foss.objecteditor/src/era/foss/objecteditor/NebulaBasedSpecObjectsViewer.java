/**
 * 
 */
package era.foss.objecteditor;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.viewers.IInputSelectionProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import era.foss.erf.ERF;

/**
 * 
 */
public class NebulaBasedSpecObjectsViewer extends Viewer implements IInputSelectionProvider, IAllowViewerSchemaChange {

    NebulaBasedSpecObjectsComposite composite = null;

    /**
     * 
     */
    public NebulaBasedSpecObjectsViewer( Composite parent, AdapterFactoryEditingDomain editingDomain, ERF erfModel ) {
        // create the Nebula-based Composite that contains the CompositeTable
        this.composite = new NebulaBasedSpecObjectsComposite( parent, editingDomain, erfModel );
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.Viewer#getControl()
     */
    @Override
    public Control getControl() {
        return composite;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.Viewer#getSelection()
     */
    @Override
    public ISelection getSelection() {
        return composite.getSelection();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.Viewer#setSelection(org.eclipse.jface.viewers.ISelection, boolean)
     */
    @Override
    public void setSelection( ISelection selection, boolean reveal ) {
        // TODO currently we ignore the 'reveal' ... is this robust?
        composite.setSelection( selection );
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.Viewer#refresh()
     */
    @Override
    public void refresh() {
        composite.redraw();
    }

    @Override
    public void recreateViewerSchema() {
        // TODO (cpn) consider to throw away the composite and re-instantiate it (instead of delegation)
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.Viewer#getInput()
     */
    @Override
    public Object getInput() {
        // TODO implement getInput(..) which stems from IInputProvider
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.Viewer#setInput(java.lang.Object)
     */
    @Override
    public void setInput( Object input ) {
        // TODO implement setInput(..) which is directly inherited from Viewer and not part of the Interface-Classes
    }

}
