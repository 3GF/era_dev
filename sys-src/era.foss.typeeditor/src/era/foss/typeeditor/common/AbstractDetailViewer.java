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
package era.foss.typeeditor.common;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

import era.foss.typeeditor.Activator;

/**
 * Create GUI elements for structural features of EMF model elements.A structural feature is only shown in case it has a
 * annotation 'UI' where the annotation detail key 'Detail' is set to 'true'
 * <p>
 * Currently following structural features are supported:
 * <li>Attributes holding a boolean or string value
 * <li>Containment references
 * 
 */
public abstract class AbstractDetailViewer extends ScrolledComposite {

    /** The master element which attributes are shown */
    protected IObservableValue master;

    /** the current editing domain */
    protected EditingDomain editingDomain;

    /**
     * Ui provides methods for creating Ui elements using databinding As the methods of the UI object create Observables
     * and listenters it has to be disposed
     */
    protected Ui ui;

    /** Composite holding the UI Elements for editing the DatatypeDefintions */
    protected Composite detailComposite;

    /** The databinding context used in the forms */
    protected DataBindingContext dataBindingContext;

    /**
     * Create a new detail viewer.
     *
     * @param parent the parent composite
     * @param style the widget style
     * @param editingDomain the editing domain
     * @param master the master object for which the details are shown
     */
    protected AbstractDetailViewer( Composite parent, int style, EditingDomain editingDomain, IObservableValue master ) {
        super( parent, style | SWT.V_SCROLL | SWT.H_SCROLL );
        this.editingDomain = editingDomain;
        this.master = master;
        // this.setAlwaysShowScrollBars( true );
        dataBindingContext = new DataBindingContext();

        // set-up layout
        GridLayout gridLayout = new GridLayout( 1, true );
        this.setLayout( gridLayout );

        // create label for detail viewer
        Label label = new Label( this, SWT.NONE );
        label.setLayoutData( new GridData( SWT.LEFT, SWT.TOP, true, true, 1, 1 ) );
        label.setText( Activator.INSTANCE.getString( "_UI_DetailViewer_title" ) + ":" );

        // Create composite holding the UI elements of the
        detailComposite = new Composite( this, SWT.BORDER );
        detailComposite.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true ) );
        detailComposite.setLayout( new GridLayout( 2, true ) );
        this.setContent( detailComposite );

        // create UI elements for attributes
        this.createDetails();
        this.setContent( detailComposite );

        this.setExpandHorizontal( true );
        this.setExpandVertical( true );

        master.addValueChangeListener( new IValueChangeListener() {

            /**
             * Redraw the detail viewer when the master object changes
             */
            @Override
            public void handleValueChange( ValueChangeEvent event ) {

                Object newValue = event.diff.getNewValue();

                AbstractDetailViewer.this.disposeDetails();

                // create new ui elements
                if( newValue != null ) {
                    AbstractDetailViewer.this.createDetails();
                }

                // we need this so that the modified content will be drawn
                detailComposite.layout();
            }
        } );

    }

    /**
     * create UI elements according to the type of the DatatypeDefition
     */
    abstract protected void createDetails();

    /**
     * Dispose stuff created in the details viewer.
     */
    protected void disposeDetails() {
        if( ui != null ) {
            ui.dispose();
        }
        if( this.isDisposed() == false ) {
            for( Control control : detailComposite.getChildren() ) {
                control.dispose();
            }
        }
    }

    /**
     * Clean up when disposing the details viewer
     * 
     * @see org.eclipse.swt.widgets.Widget#dispose()
     * @see era.foss.typeeditor.common.Ui#dispose()
     */
    @Override
    public void dispose() {
        super.dispose();
        this.disposeDetails();
        master.dispose();
        dataBindingContext.dispose();
    }

}
