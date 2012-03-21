package era.foss.erf;

import org.eclipse.emf.common.util.EList;

/**
 * @model
 */
public interface View extends Identifiable {

    /**
     * @model containment="true" ordered="true"
     */
    public EList<ViewElement> getViewElements();

}
