package era.foss.typeeditor.ui;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.IViewerObservableValue;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * This class extends the SWT text field by following features: <li>observe structural feature of an EMF object</li> <li>
 * perform validation when new value is added (not yet implemented)</li>
 */
public class BindingText extends Text {

    private DataBindingContext dataBindContext;
    private Binding binding;

    public BindingText( Composite parent, int style ) {
        super( parent, style );
        dataBindContext = new DataBindingContext();
    }

    public void bind( EditingDomain editingDomain,
                      EStructuralFeature eStructuralFeature,
                      IViewerObservableValue master ) {
        this.bind( editingDomain, new EStructuralFeature[]{eStructuralFeature}, master );

    }

    public void bind( EditingDomain editingDomain, EStructuralFeature[] eStructuralFeatureList,

    IObservableValue master ) {

        // remove old binding (if exist)
        if( binding != null ) {
            dataBindContext.removeBinding( binding );
        }

        binding = dataBindContext.bindValue( WidgetProperties.text( SWT.Modify ).observeDelayed( 400, this ),
                                             EMFEditProperties.value( editingDomain,
                                                                      FeaturePath.fromList( eStructuralFeatureList ) )
                                                              .observeDetail( master ),
                                             new UnsettableEMFUpdateValueStrategy(
                                                 eStructuralFeatureList[eStructuralFeatureList.length - 1] ),
                                             new EMFUpdateValueStrategy() );
    }

    @Override
    public void dispose() {
        super.dispose();
        dataBindContext.dispose();
    }

    // Disabling the check for subclassing. Subclassing of Text is potentially dangerous.
    // As we don't do any strange things in the constructor subclassing should be
    // OK in here.
    protected void checkSubclass() {
    }

}
