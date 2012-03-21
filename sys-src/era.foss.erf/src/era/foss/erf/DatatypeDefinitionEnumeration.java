package era.foss.erf;

import org.eclipse.emf.common.util.EList;

/**
 * @model
 */
public interface DatatypeDefinitionEnumeration extends DatatypeDefinition {

    /**
     * @model containment="true" ordered="true"
     */
    EList<EnumValue> getSpecifiedValues();

}
