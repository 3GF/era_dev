package era.foss.erf;

/**
 * @model
 */
public interface AttributeDefinitionBoolean extends AttributeDefinition {

    /**
     * @model containment="true" unsettable="true" ordered="false"
     * @return
     */
    public AttributeValueBoolean getDefaultValue();

    /**
     * Sets the value of the '{@link era.foss.erf.AttributeDefinitionBoolean#getDefaultValue <em>Default Value</em>}' containment reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Value</em>' containment reference.
     * @see #isSetDefaultValue()
     * @see #unsetDefaultValue()
     * @see #getDefaultValue()
     * @generated
     */
    void setDefaultValue( AttributeValueBoolean value );

    /**
     * Unsets the value of the '{@link era.foss.erf.AttributeDefinitionBoolean#getDefaultValue <em>Default Value</em>}' containment reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #isSetDefaultValue()
     * @see #getDefaultValue()
     * @see #setDefaultValue(AttributeValueBoolean)
     * @generated
     */
    void unsetDefaultValue();

    /**
     * Returns whether the value of the '{@link era.foss.erf.AttributeDefinitionBoolean#getDefaultValue <em>Default Value</em>}' containment reference is set.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return whether the value of the '<em>Default Value</em>' containment reference is set.
     * @see #unsetDefaultValue()
     * @see #getDefaultValue()
     * @see #setDefaultValue(AttributeValueBoolean)
     * @generated
     */
    boolean isSetDefaultValue();
}
