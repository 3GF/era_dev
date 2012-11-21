package era.foss.erf;

import org.eclipse.emf.ecore.EObject;

/**
 * @model
 */
public interface Color extends EObject {

    /**
     * @model
     */
    int getRed();

    /**
     * Sets the value of the '{@link era.foss.erf.Color#getRed <em>Red</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value the new value of the '<em>Red</em>' attribute.
     * @see #getRed()
     * @generated
     */
    void setRed( int value );

    /**
     * @model
     */
    int getGreen();

    /**
     * Sets the value of the '{@link era.foss.erf.Color#getGreen <em>Green</em>}' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Green</em>' attribute.
     * @see #getGreen()
     * @generated
     */
    void setGreen( int value );

    /**
     * @model
     */
    int getBlue();

    /**
     * Sets the value of the '{@link era.foss.erf.Color#getBlue <em>Blue</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value the new value of the '<em>Blue</em>' attribute.
     * @see #getBlue()
     * @generated
     */
    void setBlue( int value );

    public org.eclipse.swt.graphics.Color getColor();

}
