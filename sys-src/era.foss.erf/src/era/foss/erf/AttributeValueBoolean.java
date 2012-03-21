package era.foss.erf;

/**
 * @model
 */
public interface AttributeValueBoolean extends AttributeValue {

    /**
     * @model lowerBound="1" defaultValue="false"
     */
    public Boolean getTheValue();

    /**
     * Sets the value of the '{@link era.foss.erf.AttributeValueBoolean#getTheValue <em>The Value</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>The Value</em>' attribute.
     * @see #getTheValue()
     * @generated
     */
    void setTheValue( Boolean value );

}
