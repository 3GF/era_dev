package era.foss.erf;

import org.eclipse.emf.common.util.EList;

/**
 * Represents a hierarchically structured requirements specification. It is the root node of the tree that
 * hierarchically structures SpecObject instances.
 * 
 * @model
 */
public interface Specification extends SpecElementWithUserDefinedAttributes {

    /**
     * Next level of owned SpecHierarchy
     * 
     * @model containment="true" ordered="true" opposite="root"
     */
    public EList<SpecHierarchy> getChildren();

    /**
     * The back linkage to the owning ReqIFContent element.
     * 
     * @model required="true"
     */
    public Content getCoreContent();

    /**
     * Sets the value of the '{@link era.foss.erf.Specification#getCoreContent <em>Core Content</em>}' container
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Core Content</em>' container reference.
     * @see #getCoreContent()
     * @generated
     */
    void setCoreContent( Content value );

}
