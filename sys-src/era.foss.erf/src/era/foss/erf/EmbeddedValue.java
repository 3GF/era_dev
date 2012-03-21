package era.foss.erf;

import org.eclipse.emf.ecore.EObject;

/**
 * @model
 */
public interface EmbeddedValue extends EObject {

    /**
     * @model unique="false" default="0" lowerBound="1" upperBound="1" ordered="false"
     */
    int getKey();

    /**
     * Sets the value of the '{@link era.foss.erf.EmbeddedValue#getKey <em>Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Key</em>' attribute.
     * @see #getKey()
     * @generated
     */
    void setKey( int value );

    /**
     * @model unique="false" default="" lowerBound="1" upperBound="1" ordered="false"
     */
    String getOtherContent();

    /**
     * Sets the value of the '{@link era.foss.erf.EmbeddedValue#getOtherContent <em>Other Content</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Other Content</em>' attribute.
     * @see #getOtherContent()
     * @generated
     */
    void setOtherContent( String value );
}
