/**
 * <copyright>
 * </copyright>
 *
 * $Id: AttributeValueEnumerationTest.java 351 2011-09-07 19:19:17Z cpn $
 */
package era.foss.erf.tests;

import era.foss.erf.AttributeValueEnumeration;
import era.foss.erf.ErfFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Attribute Value Enumeration</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AttributeValueEnumerationTest extends AttributeValueTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main( String[] args ) {
        TestRunner.run( AttributeValueEnumerationTest.class );
    }

    /**
     * Constructs a new Attribute Value Enumeration test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AttributeValueEnumerationTest( String name ) {
        super( name );
    }

    /**
     * Returns the fixture for this Attribute Value Enumeration test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected AttributeValueEnumeration getFixture() {
        return (AttributeValueEnumeration)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture( ErfFactory.eINSTANCE.createAttributeValueEnumeration() );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#tearDown()
     * @generated
     */
    @Override
    protected void tearDown() throws Exception {
        setFixture( null );
    }

} //AttributeValueEnumerationTest
