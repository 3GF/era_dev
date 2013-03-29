package era.foss.ui.contrib;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;

public abstract class ObservableMapLabelColorProvider extends ObservableMapLabelProvider implements IColorProvider {

    public ObservableMapLabelColorProvider( IObservableMap attributeMap ) {
        super( attributeMap );
    }

}
