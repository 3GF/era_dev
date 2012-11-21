package era.foss.typeeditor.datatype;

import org.eclipse.jface.viewers.OwnerDrawLabelProvider;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Event;

import era.foss.erf.Color;
import era.foss.erf.EnumValue;

public class EnumColorLabelProvider extends OwnerDrawLabelProvider {

    @Override
    protected void paint( Event event, Object element ) {
        // TODO Auto-generated method stub
        assert (element instanceof EnumValue);

        Color color = ((EnumValue)element).getColor();
        event.gc.setBackground( color.getColor() );
        Rectangle bounds = event.getBounds();
        bounds.width += 100;
        event.gc.fillRectangle( bounds );
    }

    @Override
    protected void measure( Event event, Object element ) {
        // event.setBounds(new Rectangle(event.x, event.y, country.getWidth(event),
        // country.getHeight(event)));

    }
}
