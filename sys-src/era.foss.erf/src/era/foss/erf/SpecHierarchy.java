package era.foss.erf;

import org.eclipse.emf.common.util.EList;

/**
 * Represents a node in a hierarchically structured requirements specification.
 * 
 * @model
 */
public interface SpecHierarchy extends AccessControlledElement {

    /**
     * 
     * Some requirements authoring tools enable the user to use tables as part of a requirement’s content, where parts
     * of the table represent requirements as well. If that is the case, this attribute needs to be set to true for the
     * root node of the table hierarchy and all descendant SpecHierarchy nodes.
     * 
     * * @model unique="true" default="false" required="false"
     */
    boolean isTableInternal();

    /**
     * Sets the value of the '{@link era.foss.erf.SpecHierarchy#isTableInternal <em>Table Internal</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Table Internal</em>' attribute.
     * @see #isTableInternal()
     * @generated
     */
    void setTableInternal( boolean value );

    /**
     * Next level of owned SpecHierarchy
     * 
     * @model containment="true" ordered="true" opposite="parent"
     */
    public EList<SpecHierarchy> getChildren();

    /**
     * Pointer to the associated SpecObject
     * 
     * @model kind="reference" required="true"
     */
    public SpecObject getObject();

    /**
     * Sets the value of the '{@link era.foss.erf.SpecHierarchy#getObject <em>Object</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Object</em>' reference.
     * @see #getObject()
     * @generated
     */
    void setObject( SpecObject value );

    /**
     * Up link to previous level of SpecHierarchy (which owns this level)
     * 
     * @model required="false" opposite="children"
     */
    public SpecHierarchy getParent();

    /**
     * Sets the value of the '{@link era.foss.erf.SpecHierarchy#getParent <em>Parent</em>}' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Parent</em>' container reference.
     * @see #getParent()
     * @generated
     */
    void setParent( SpecHierarchy value );

    /**
     * Up link to specification hierarchy root (which may own this level)
     * 
     * @model required="false" opposite="children"
     */
    public Specification getRoot();

    /**
     * Sets the value of the '{@link era.foss.erf.SpecHierarchy#getRoot <em>Root</em>}' container reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Root</em>' container reference.
     * @see #getRoot()
     * @generated
     */
    void setRoot( Specification value );

}
