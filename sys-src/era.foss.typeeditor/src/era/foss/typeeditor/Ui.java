/**************************************************************************
 * ERA - Eclipse Requirements Analysis
 * ==============================================
 * Copyright (C) 2009-2011 by Georg Blaschke, Christoph P. Neumann
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
 * $Id: Ui.java 346 2011-07-09 18:10:18Z schorsch $
 *************************************************************************/
package era.foss.typeeditor;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.CellEditorProperties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableValueEditingSupport;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import era.foss.erf.provider.ErfEditPlugin;
import era.foss.ui.contrib.ComboBoxViewerCellEditorSp;

/**
 * This class provides methods for creating UI elements for Ecore models.
 */
public class Ui {

    // The editing domain
    /** The editing domain. */
    private EditingDomain editingDomain;

    // data binding context used for binding EMF elements to UI elements
    /** The data bind context. */
    private DataBindingContext dataBindContext;

    /**
     * Create Ui Please call the dispose method when an object of this type is not required anymore.
     * 
     * @param editingDomain used for binding the UI elements to
     * @param erfModel the erf model
     */
    public Ui( EditingDomain editingDomain ) {
        this.editingDomain = editingDomain;
        dataBindContext = new EMFDataBindingContext();
    }

    /**
     * Dispose the data binding context created during initialization.
     */
    public void dispose() {
        dataBindContext.dispose();
    }

    /**
     * Get UI name for an eclass.
     * 
     * @param eClass to get the name for
     * @return the ui name
     */
    public static String getUiName( EClass eClass ) {
        String name = ErfEditPlugin.INSTANCE.getString( "_UI_" + eClass.getName() + "_type" );
        return (name == null) ? eClass.getName() : name;
    }

    /**
     * Get UI name for an eAttribute.
     * 
     * @param eStructuralFeature to get the name for
     * @return the ui name
     */
    public static String getUiName( EStructuralFeature eStructuralFeature ) {
        String name = ErfEditPlugin.INSTANCE.getString( "_UI_"
            + eStructuralFeature.getEContainingClass().getName()
            + "_"
            + eStructuralFeature.getName()
            + "_feature" );
        return (name == null) ? eStructuralFeature.getName() : name;
    }

    public void bindColumn( TableViewerColumn column, EStructuralFeature[] eStructuralFeatureList ) {
        bindColumn( column, eStructuralFeatureList, null, null );
    }

    /**
     * Create a column with EMF databinding for a table viewer
     * 
     * <li>In case the top level structural feature is a reference display a combo box</li> <li>In case the top level
     * structural feature is a containment reference create element if it does not exist</li> <li>In case the structural
     * feature is a boolean show a checkbox</li> <li>Otherwise show a simple text field</li>.
     * 
     * @param tableViewer the table viewer
     * @param eStructuralFeatureList list to create a feature path from
     */
    public void bindColumn( TableViewerColumn column,
                            EStructuralFeature[] eStructuralFeatureList,
                            EObject refObservedObject,
                            EStructuralFeature[] refEStructuralFeatureList ) {

        TableViewer tableViewer = (TableViewer)column.getViewer();
        ObservableListContentProvider cp = (ObservableListContentProvider)tableViewer.getContentProvider();
        assert (cp != null);

        // get the top level structural feature
        EStructuralFeature topStructuralFeature = eStructuralFeatureList[0];

        // set label provider
        IValueProperty elementProperty = EMFEditProperties.value( editingDomain,
                                                                  FeaturePath.fromList( eStructuralFeatureList ) );
        IObservableMap attributeMap = elementProperty.observeDetail( cp.getKnownElements() );
        column.setLabelProvider( new ObservableMapCellLabelProvider( attributeMap ) );

        EditingSupport editingSupport = null;

        // Show combo box for references
        if( refObservedObject != null && refEStructuralFeatureList != null ) {

            // Combo box: Create combo box to select choices for the reference
            ComboBoxViewerCellEditor combo = new ComboBoxViewerCellEditorSp(
                (Composite)tableViewer.getControl(),
                SWT.READ_ONLY );
            // Combo box: Set Content Provider
            ObservableListContentProvider comboContentProvider = new ObservableListContentProvider();
            combo.setContenProvider( comboContentProvider );

            IObservableMap comboAttributeMap = EMFProperties.value( eStructuralFeatureList[eStructuralFeatureList.length - 1] )
                                                            .observeDetail( comboContentProvider.getKnownElements() );
            combo.setLabelProvider( new ObservableMapLabelProvider( comboAttributeMap ) );
            // Combo box: set input
            IEMFListProperty dataTypeDefinitions = EMFProperties.list( FeaturePath.fromList( refEStructuralFeatureList ) );
            combo.setInput( dataTypeDefinitions.observe( refObservedObject ) );

            // Set editing support of table cell
            IValueProperty editorElementProperty = EMFEditProperties.value( editingDomain, topStructuralFeature );
            IValueProperty cellEditorProperty = ViewerProperties.singleSelection();

            editingSupport = ObservableValueEditingSupport.create( tableViewer,
                                                                   dataBindContext,
                                                                   combo,
                                                                   cellEditorProperty,
                                                                   editorElementProperty );

        }
        // Simple text
        else {
            IValueProperty cellEditorProperty = CellEditorProperties.control()
                                                                    .value( WidgetProperties.text( SWT.Modify ) );

            editingSupport = ObservableValueEditingSupport.create( tableViewer, dataBindContext, new TextCellEditor(
                tableViewer.getTable() ), cellEditorProperty, elementProperty );
        }

        column.setEditingSupport( editingSupport );

    }

}
