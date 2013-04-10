package era.foss.erf;

/**
 * Base class for classes that may restrict user access to their information.
 * 
 * @model abstract="true"
 */
public interface AccessControlledElement extends Identifiable {

    /**
     * <ul>
     * <li>True means that the element’s contents may be modified by the user of a tool containing the element.
     * <li>False or leaving isEditable out means that the element is read-only to the user of a tool containing the
     * element.
     * <ul>
     * 
     * @model unique="true" default="true" required="false"
     */
    public boolean isEditable();

    /**
     * Sets the value of the '{@link era.foss.erf.AccessControlledElement#isEditable <em>Editable</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Editable</em>' attribute.
     * @see #isEditable()
     * @generated
     */
    void setEditable( boolean value );

}
