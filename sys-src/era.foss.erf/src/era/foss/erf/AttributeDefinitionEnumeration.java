package era.foss.erf;

/**
 * @model
 */
public interface AttributeDefinitionEnumeration extends AttributeDefinition {

    /**
     * @model default="false"
     */
    boolean isMultiValued();

    /**
     * Sets the value of the '{@link era.foss.erf.AttributeDefinitionEnumeration#isMultiValued <em>Multi Valued</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Multi Valued</em>' attribute.
     * @see #isMultiValued()
     * @generated
     */
    void setMultiValued( boolean value );

    /**
     * @model containment="true" unsettable="true" ordered="false"
     * @return
     */
    AttributeValueEnumeration getDefaultValue();

    /**
     * Sets the value of the '{@link era.foss.erf.AttributeDefinitionEnumeration#getDefaultValue <em>Default Value</em>}' containment reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Value</em>' containment reference.
     * @see #isSetDefaultValue()
     * @see #unsetDefaultValue()
     * @see #getDefaultValue()
     * @generated
     */
    void setDefaultValue( AttributeValueEnumeration value );

    /**
     * Unsets the value of the '{@link era.foss.erf.AttributeDefinitionEnumeration#getDefaultValue <em>Default Value</em>}' containment reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #isSetDefaultValue()
     * @see #getDefaultValue()
     * @see #setDefaultValue(AttributeValueEnumeration)
     * @generated
     */
    void unsetDefaultValue();

    /**
     * Returns whether the value of the '{@link era.foss.erf.AttributeDefinitionEnumeration#getDefaultValue <em>Default Value</em>}' containment reference is set.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @return whether the value of the '<em>Default Value</em>' containment reference is set.
     * @see #unsetDefaultValue()
     * @see #getDefaultValue()
     * @see #setDefaultValue(AttributeValueEnumeration)
     * @generated
     */
    boolean isSetDefaultValue();
}
