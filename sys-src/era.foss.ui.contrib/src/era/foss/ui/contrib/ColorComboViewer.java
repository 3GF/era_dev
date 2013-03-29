package era.foss.ui.contrib;

import java.util.List;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

public class ColorComboViewer extends ComboViewer {

    public ColorComboViewer( Composite parent ) {
        super( parent );
    }

    public ColorComboViewer( Combo list ) {
        super( list );
    }

    public ColorComboViewer( CCombo list ) {
        super( list );
    }

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
