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

    /**
     * Instantiates a new binding check box.
     *
     * @param parent the parent
     * @param style the style
     */
    public BindingCheckBox( Composite parent, int style ) {
        super( parent, style | SWT.CHECK );
        dataBindContext = new DataBindingContext();
    }

    /**
     * Bind.
     *
     * @param editingDomain the editing domain
     * @param eStructuralFeature the e structural feature
     * @param master the master
     */
    public void bind( EditingDomain editingDomain, EStructuralFeature eStructuralFeature, IObservableValue master ) {
        this.bind( editingDomain, new EStructuralFeature[]{eStructuralFeature}, master );
    }

    /**
     * Bind.
     *
     * @param editingDomain the editing domain
     * @param eStructuralFeatureList the e structural feature list
     * @param master the master
     */
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
