package era.foss.erf;

/**
 * @model
 */
public interface EnumValue extends Identifiable {

    /**
     * @model lowerBound="1" upperBound="1" containment="true"
     */
    EmbeddedValue getProperties();

    /**
     * Sets the value of the '{@link era.foss.erf.EnumValue#getProperties <em>Properties</em>}' containment reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Properties</em>' containment reference.
     * @see #getProperties()
     * @generated
     */
    void setProperties( EmbeddedValue value );

}
