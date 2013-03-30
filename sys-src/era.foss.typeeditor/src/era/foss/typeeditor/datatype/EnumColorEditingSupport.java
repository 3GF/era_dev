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
package era.foss.typeeditor.datatype;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColorCellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;

import era.foss.erf.Color;
import era.foss.erf.EnumValue;
import era.foss.erf.ErfPackage;

/**
 * The Class EnumColorEditingSupport.
 */
public class EnumColorEditingSupport extends EditingSupport {

    /** The color cell editor. */
    protected ColorCellEditor colorCellEditor;
    
    /** The editing domain. */
    protected EditingDomain editingDomain;

    /**
     * Gets the editing domain.
     *
     * @return the editing domain
     */
    public EditingDomain getEditingDomain() {
        return editingDomain;
    }

    /**
     * Sets the editing domain.
     *
     * @param editingDomain the new editing domain
     */
    public void setEditingDomain( EditingDomain editingDomain ) {
        this.editingDomain = editingDomain;
    }

    /**
     * Instantiates a new enum color editing support.
     *
     * @param viewer the viewer
     */
    public EnumColorEditingSupport( ColumnViewer viewer ) {
        super( viewer );
        colorCellEditor = new ColorCellEditor( (Composite)viewer.getControl() );
    }

    @Override
    protected void setValue( Object element, Object value ) {
        assert (value instanceof RGB);
        assert (element instanceof EnumValue);

        Color color = ((EnumValue)element).getColor();
        RGB rgb = (RGB)value;
        CompoundCommand setColorCommand = new CompoundCommand();

        setColorCommand.append( new SetCommand( editingDomain, color, ErfPackage.Literals.COLOR__RED, rgb.red ) );
        setColorCommand.append( new SetCommand( editingDomain, color, ErfPackage.Literals.COLOR__GREEN, rgb.green ) );
        setColorCommand.append( new SetCommand( editingDomain, color, ErfPackage.Literals.COLOR__BLUE, rgb.blue ) );
        editingDomain.getCommandStack().execute( setColorCommand );

        this.getViewer().refresh();
    }

    @Override
    protected Object getValue( Object element ) {
        assert (element instanceof EnumValue);
        Color color = ((EnumValue)element).getColor();

        return new RGB( color.getRed(), color.getGreen(), color.getBlue() );
    }

    @Override
    protected CellEditor getCellEditor( Object element ) {

        return colorCellEditor;
    }

    @Override
    protected boolean canEdit( Object element ) {
        // TODO Auto-generated method stub
        return true;
    }
}
