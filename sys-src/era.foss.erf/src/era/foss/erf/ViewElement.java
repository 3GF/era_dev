package era.foss.erf;

import org.eclipse.emf.ecore.EObject;

/**
 * @model
 */
public interface ViewElement extends EObject {
    /**
     * @model lowerBound="1"
     * @Not generated
     * @return
     */
    public AttributeDefinition getAttributeDefinition();

    /**
     * Sets the value of the '{@link era.foss.erf.ViewElement#getAttributeDefinition <em>Attribute Definition</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Attribute Definition</em>' reference.
     * @see #getAttributeDefinition()
     * @generated
     */
    void setAttributeDefinition( AttributeDefinition value );

    /**
     * @model unique="false" default="true" required="true"
     * @Not generated
     * @return
     */
    boolean isEditorShowLabel();

    /**
     * Sets the value of the '{@link era.foss.erf.ViewElement#isEditorShowLabel <em>Editor Show Label</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Editor Show Label</em>' attribute.
     * @see #isEditorShowLabel()
     * @generated
     */
    void setEditorShowLabel( boolean value );

    /**
     * @model unique="false" default="1" lowerBound="1" upperBound="1"
     * @Not generated
     * @return
     */
    int getEditorRowNumber();

    /**
     * Sets the value of the '{@link era.foss.erf.ViewElement#getEditorRowNumber <em>Editor Row Number</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Editor Row Number</em>' attribute.
     * @see #getEditorRowNumber()
     * @generated
     */
    void setEditorRowNumber( int value );

    /**
     * @model unique="false" default="1" lowerBound="1" upperBound="1"
     * @Not generated
     * @return
     */
    int getEditorColumnSpan();

    /**
     * Sets the value of the '{@link era.foss.erf.ViewElement#getEditorColumnSpan <em>Editor Column Span</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Editor Column Span</em>' attribute.
     * @see #getEditorColumnSpan()
     * @generated
     */
    void setEditorColumnSpan( int value );

}
