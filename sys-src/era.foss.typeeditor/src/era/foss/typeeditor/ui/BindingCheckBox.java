package era.foss.typeeditor.ui;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * This class extends the SWT text field by following features: <li>observe structural feature of an EMF object</li> <li>
 * perform validation when new value is added (not yet implemented)</li>
 */
public class BindingCheckBox extends Button {

    DataBindingContext dataBindContext;
    private Binding binding;

    public BindingCheckBox( Composite parent, int style ) {
        super( parent, style | SWT.CHECK );
        dataBindContext = new DataBindingContext();
    }

    public void bind( EditingDomain editingDomain, EStructuralFeature eStructuralFeature, IObservableValue master ) {
        this.bind( editingDomain, new EStructuralFeature[]{eStructuralFeature}, master );
    }

    public void bind( EditingDomain editingDomain,
                      EStructuralFeature[] eStructuralFeatureList,
                      IObservableValue master ) {

        // remove old binding (if exist)
        if( binding != null ) {
            dataBindContext.removeBinding( binding );
        }

        binding = dataBindContext.bindValue( SWTObservables.observeSelection( this ),
                                             EMFEditProperties.value( editingDomain,
                                                                      FeaturePath.fromList( eStructuralFeatureList ) )
                                                              .observeDetail( master ) );
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
