package era.foss.ui.contrib;

/*******************************************************************************
 * Copyright (c) 2004, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Sebastian Davids - bug 69254
 *******************************************************************************/

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.AbstractListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * A concrete viewer based either on an SWT <code>Combo</code> control or <code>CCombo</code> control. This class is
 * intended as an alternative to the JFace <code>ListViewer</code>, which displays its content in a combo box rather
 * than a list. Wherever possible, this class attempts to behave like ListViewer.
 * <p>
 * 
 * This class is designed to be instantiated with a pre-existing SWT combo control and configured with a domain-specific
 * content provider, label provider, element filter (optional), and element sorter (optional).
 * </p>
 * 
 * @see org.eclipse.jface.viewers.ListViewer
 * @since 3.0 (made non-final in 3.4)
 */
public class MultiComboViewer extends AbstractListViewer {

    /**
     * This viewer's list control if this viewer is instantiated with a CCombo control; otherwise <code>null</code>.
     * 
     * @see #ComboViewer(CCombo)
     * @since 3.3
     */
    private MultiCCombo multiCombo;

    /**
     * Creates a combo viewer on a newly-created combo control under the given parent. The viewer has no input, no
     * content provider, a default label provider, no sorter, and no filters.
     * 
     * @param parent the parent control
     */
    public MultiComboViewer( Composite parent ) {
        this( parent, SWT.READ_ONLY | SWT.BORDER );
    }

    public MultiComboViewer( Composite parent, int style ) {
        this.multiCombo = new MultiCCombo( parent, style );
        hookControl( multiCombo );
    }

    protected void listAdd( String string, int index ) {
        multiCombo.add( string, index );
    }

    protected void listSetItem( int index, String string ) {
        multiCombo.setItem( index, string );
    }

    protected int[] listGetSelectionIndices() {
        return multiCombo.getSelectionIndices();

    }

    protected int listGetItemCount() {
        return multiCombo.getItemCount();

    }

    protected void listSetItems( String[] labels ) {
        multiCombo.setItems( labels );
    }

    protected void listRemoveAll() {
        multiCombo.removeAll();
    }

    protected void listRemove( int index ) {

        multiCombo.remove( index );
    }

    /*
     * (non-Javadoc) Method declared on Viewer.
     */
    public Control getControl() {
        return multiCombo;
    }

    /**
     * Returns this list viewer's list control. If the viewer was not created on a CCombo control, some kind of
     * unchecked exception is thrown.
     * 
     * @return the list control
     * @since 3.3
     */
    public MultiCCombo getCCombo() {
        Assert.isNotNull( multiCombo );
        return multiCombo;
    }

    /*
     * Do nothing -- combos only display the selected element, so there is no way we can ensure that the given element
     * is visible without changing the selection. Method defined on StructuredViewer.
     */
    public void reveal( Object element ) {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.AbstractListViewer#listSetSelection(int[])
     */
    protected void listSetSelection( int[] ixs ) {
        multiCombo.select( ixs );
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.AbstractListViewer#listDeselectAll()
     */
    protected void listDeselectAll() {
        multiCombo.deselectAll();
        multiCombo.clearSelection();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.AbstractListViewer#listShowSelection()
     */
    protected void listShowSelection() {
    }
}
