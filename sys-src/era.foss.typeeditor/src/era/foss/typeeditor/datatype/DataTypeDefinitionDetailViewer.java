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
 * $Id: DetailViewer.java 314 2011-04-05 22:28:39Z schorsch $
 *************************************************************************/
package era.foss.typeeditor.datatype;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import era.foss.erf.DatatypeDefinition;
import era.foss.erf.ErfPackage;
import era.foss.typeeditor.common.AbstractDetailViewer;
import era.foss.typeeditor.common.AddDeleteTableViewer;
import era.foss.typeeditor.common.BindingText;
import era.foss.typeeditor.common.Ui;

/**
 * Create GUI elements for structural features of EMF model elements.A structural feature is only shown in case it has a
 * annotation 'UI' where the annotation detail key 'Detail' is set to 'true'
 * <p>
 * Currently following structural features are supported:
 * <li>Attributes holding a boolean or string value
 * <li>Containment references
 * 
 */
public class DataTypeDefinitionDetailViewer extends AbstractDetailViewer {

    /**
     * @see AbstractDetailViewer#AbstractDetailViewer(Composite, int, EditingDomain, IObservableValue)
     */
    DataTypeDefinitionDetailViewer( Composite parent, int style, EditingDomain editingDomain, IObservableValue master ) {
        super( parent, style, editingDomain, master );
        // TODO Auto-generated constructor stub
    }

    /**
     * create UI elements according to the type of the DatatypeDefition
     */
    protected void createDetails() {

        // In case no dataType definition has been selected
        if( master.getValue() == null ) {
            return;
        }

        // pick function for creating GUI elements according to type of DatatypeDefinition
        ui = new Ui( editingDomain );
        assert (master.getValue() instanceof DatatypeDefinition);
        DatatypeDefinition dataTypeDefintion = (DatatypeDefinition)master.getValue();

        switch (dataTypeDefintion.eClass().getClassifierID()) {

        case ErfPackage.DATATYPE_DEFINITION_INTEGER:
            createDetailsInteger();
            break;

        case ErfPackage.DATATYPE_DEFINITION_STRING:
            createDetailsString();
            break;

        case ErfPackage.DATATYPE_DEFINITION_ENUMERATION:
            createDetailsEnumeration();
            break;

        default:
            /*
             * nothing to be done for: ErfPackage.DATATYPE_DEFINITION_BOOLEAN
             */
        }
    }

    /**
     * Show UI elements for DatatypeDefintionString
     */
    private void createDetailsString() {

        // label for for maximum value of the DatatypeDefinitionInteger
        Label minlabel = new Label( detailComposite, SWT.NONE );
        minlabel.setText( Ui.getUiName( ErfPackage.Literals.DATATYPE_DEFINITION_INTEGER__MAX ) );
        minlabel.setLayoutData( new GridData( SWT.LEFT, SWT.DEFAULT, true, false ) );

        // text field for maximum value of the DatatypeDefinitionInteger
        EAttribute[] max = {ErfPackage.Literals.DATATYPE_DEFINITION_INTEGER__MAX};
        BindingText maxText = new BindingText( detailComposite, SWT.BORDER );
        maxText.bind( editingDomain, max, master );
        maxText.setLayoutData( new GridData( SWT.FILL, SWT.DEFAULT, true, false ) );
    }

    /**
     * Show UI elements for DatatypeDefintionInteger
     */
    private void createDetailsInteger() {

        // label for for maximum value of the DatatypeDefinitionInteger
        Label maxlabel = new Label( detailComposite, SWT.NONE );
        maxlabel.setText( Ui.getUiName( ErfPackage.Literals.DATATYPE_DEFINITION_INTEGER__MAX ) );
        maxlabel.setLayoutData( new GridData( SWT.LEFT, SWT.DEFAULT, true, false ) );

        // text field for maximum value of the DatatypeDefinitionInteger
        EAttribute[] max = {ErfPackage.Literals.DATATYPE_DEFINITION_INTEGER__MAX};
        BindingText maxText = new BindingText( detailComposite, SWT.BORDER );
        maxText.bind( editingDomain, max, master );
        maxText.setLayoutData( new GridData( SWT.FILL, SWT.DEFAULT, true, false ) );

        // label for for minimum value of the DatatypeDefinitionInteger
        Label minlabel = new Label( detailComposite, SWT.NONE );
        minlabel.setText( Ui.getUiName( ErfPackage.Literals.DATATYPE_DEFINITION_INTEGER__MIN ) );
        minlabel.setLayoutData( new GridData( SWT.LEFT, SWT.DEFAULT, true, false ) );

        // text field for minimum value of the DatatypeDefinitionInteger
        EAttribute[] min = {ErfPackage.Literals.DATATYPE_DEFINITION_INTEGER__MIN};
        BindingText minText = new BindingText( detailComposite, SWT.BORDER );
        minText.bind( editingDomain, min, master );
        minText.setLayoutData( new GridData( SWT.FILL, SWT.DEFAULT, true, false ) );
    }

    /**
     * Show UI elements for DatatypeDefintionEnumeration
     */
    private void createDetailsEnumeration() {

        // create table for enumeration values
        AddDeleteTableViewer tableViewer = new AddDeleteTableViewer( detailComposite, SWT.MULTI
            | SWT.V_SCROLL
            | SWT.BORDER
            | SWT.FULL_SELECTION );
        tableViewer.setLayoutData( new GridData( SWT.FILL, SWT.FILL, true, true, 2, 1 ) );
        tableViewer.setEditingDomain( editingDomain );
        tableViewer.setElementInformation( (EObject)this.master.getValue(),
                                           ErfPackage.Literals.DATATYPE_DEFINITION_ENUMERATION__SPECIFIED_VALUES,
                                           ErfPackage.Literals.ENUM_VALUE );

        ObservableListContentProvider cp = new ObservableListContentProvider();
        tableViewer.setContentProvider( cp );

        TableColumnLayout columnLayout = (TableColumnLayout)tableViewer.getTable().getParent().getLayout();
        // create column with name of the element
        TableViewerColumn column = new TableViewerColumn( tableViewer, SWT.NONE );

        columnLayout.setColumnData( column.getColumn(), new ColumnWeightData( 20, 20 ) );
        column.getColumn().setResizable( true );
        column.getColumn().setMoveable( false );
        column.getColumn().setText( Ui.getUiName( ErfPackage.Literals.IDENTIFIABLE__LONG_NAME ) );
        EStructuralFeature[] structuralFeature = {ErfPackage.Literals.IDENTIFIABLE__LONG_NAME};
        ui.bindColumn( column, structuralFeature );

        IEMFListProperty enumerationProperty = EMFProperties.list( ErfPackage.Literals.DATATYPE_DEFINITION_ENUMERATION__SPECIFIED_VALUES );
        tableViewer.setInput( enumerationProperty.observe( master.getValue() ) );

    }
}
