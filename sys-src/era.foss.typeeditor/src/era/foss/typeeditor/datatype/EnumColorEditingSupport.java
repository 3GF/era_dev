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

public class EnumColorEditingSupport extends EditingSupport {

    protected ColorCellEditor colorCellEditor;
    protected EditingDomain editingDomain;

    public EditingDomain getEditingDomain() {
        return editingDomain;
    }

    public void setEditingDomain( EditingDomain editingDomain ) {
        this.editingDomain = editingDomain;
    }

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
