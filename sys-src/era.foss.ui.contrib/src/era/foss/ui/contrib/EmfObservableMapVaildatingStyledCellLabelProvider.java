package era.foss.ui.contrib;

import java.util.Set;

import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;

public class EmfObservableMapVaildatingStyledCellLabelProvider extends StyledCellLabelProvider {
    /**
     * Observable maps typically mapping from viewer elements to label values. Subclasses may use these maps to provide
     * custom labels.
     */
    protected IObservableMap[] attributeMaps;

    private IMapChangeListener mapChangeListener = new IMapChangeListener() {
        public void handleMapChange( MapChangeEvent event ) {
            Set<?> affectedElements = event.diff.getChangedKeys();
            LabelProviderChangedEvent newEvent = new LabelProviderChangedEvent(
                EmfObservableMapVaildatingStyledCellLabelProvider.this,
                affectedElements.toArray() );
            fireLabelProviderChanged( newEvent );
        }
    };

    /**
     * Creates a new label provider that tracks changes to one attribute.
     * 
     * @param attributeMap
     */
    public EmfObservableMapVaildatingStyledCellLabelProvider( IObservableMap attributeMap ) {
        this( new IObservableMap[]{attributeMap} );
    }

    /**
     * Creates a new label provider that tracks changes to more than one attribute. This constructor should be used by
     * subclasses that override {@link #update(ViewerCell)} and make use of more than one attribute.
     * 
     * @param attributeMaps
     */
    protected EmfObservableMapVaildatingStyledCellLabelProvider( IObservableMap[] attributeMaps ) {
        System.arraycopy( attributeMaps,
                          0,
                          this.attributeMaps = new IObservableMap[attributeMaps.length],
                          0,
                          attributeMaps.length );
        for( int i = 0; i < attributeMaps.length; i++ ) {
            attributeMaps[i].addMapChangeListener( mapChangeListener );
        }
    }

    public void dispose() {
        for( int i = 0; i < attributeMaps.length; i++ ) {
            attributeMaps[i].removeMapChangeListener( mapChangeListener );
        }
        super.dispose();
        this.attributeMaps = null;
        this.mapChangeListener = null;
    }

    public void update( ViewerCell cell ) {
        Object element = cell.getElement();
        Object value = attributeMaps[0].get( element );
        cell.setText( value == null ? "" : value.toString() ); //$NON-NLS-1$
    }

}
