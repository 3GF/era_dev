package era.foss.erf;

import org.eclipse.emf.common.util.EList;

/**
 * @model
 */
public interface AttributeValueEnumeration extends AttributeValue {

    /**
     * @model upperBound="-1" lowerBound="1"
     */
    EList<EnumValue> getValues();

}
