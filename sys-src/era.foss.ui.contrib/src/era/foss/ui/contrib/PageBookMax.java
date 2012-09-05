package era.foss.ui.contrib;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.ui.part.PageBookView;

/**
 * Layout for PageBook which calculates the maximum size of all child contols
 */

/**
 * A pagebook is a composite control where only a single control is visible at a time. It is similar to a notebook, but
 * without tabs. For calculation of the size maximum size of all the children is used.
 * <p>
 * This class may be instantiated; it is not intended to be subclassed.
 * </p>
 * <p>
 * Note that although this class is a subclass of <code>Composite</code>, it does not make sense to set a layout on it.
 * </p>
 * 
 * @see PageBookView
 * @noextend This class is not intended to be subclassed by clients.
 */
public class PageBookMax extends Composite {

    private class PageBookLayout extends Layout {

        protected Point computeSize( Composite composite, int wHint, int hHint, boolean flushCache ) {
            int maxWidth = 0;
            int maxHeight = 0;

            Point sizeOfChild;
            for( Control child : composite.getChildren() ) {
                sizeOfChild = child.computeSize( wHint, hHint );
                maxWidth = Math.max( sizeOfChild.x, maxWidth );
                maxHeight = Math.max( sizeOfChild.y, maxHeight );
            }
            return new Point( maxWidth, maxHeight );

        }

        protected void layout( Composite composite, boolean flushCache ) {
            if( currentPage != null ) {
                currentPage.setBounds( composite.getClientArea() );
            }
        }
    }

    /**
     * The current control; <code>null</code> if none.
     */
    private Control currentPage = null;

    /**
     * Creates a new empty pagebook.
     * 
     * @param parent the parent composite
     * @param style the SWT style bits
     */
    public PageBookMax( Composite parent, int style ) {
        super( parent, style );
        setLayout( new PageBookLayout() );
    }

    /**
     * Shows the given page. This method has no effect if the given page is not contained in this pagebook.
     * 
     * @param page the page to show
     */
    public void showPage( Control page ) {
        if( page.isDisposed() || page.getParent() != this ) {
            return;
        }

        currentPage = page;

        // show new page
        page.setVisible( true );
        layout( true );

        // hide old (and all others) *after* new page has been made visible in
        // order to avoid flashing
        Control[] children = getChildren();
        for( int i = 0; i < children.length; i++ ) {
            Control child = children[i];
            if( child != page && !child.isDisposed() ) {
                child.setVisible( false );
            }
        }
    }
}