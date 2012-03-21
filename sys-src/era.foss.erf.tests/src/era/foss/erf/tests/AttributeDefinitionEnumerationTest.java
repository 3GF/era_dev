/**
 * <copyright>
 * </copyright>
 *
 * $Id: AttributeDefinitionEnumerationTest.java 351 2011-09-07 19:19:17Z cpn $
 */
package era.foss.erf.tests;

import era.foss.erf.AttributeDefinitionEnumeration;
import era.foss.erf.ErfFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Attribute Definition Enumeration</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AttributeDefinitionEnumerationTest extends AttributeDefinitionTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main( String[] args ) {
        TestRunner.run( AttributeDefinitionEnumerationTest.class );
    }

    /**
     * Constructs a new Attribute Definition Enumeration test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AttributeDefinitionEnumerationTest( String name ) {
        super( name );
    }

    /**
     * Returns the fixture for this Attribute Definition Enumeration test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected AttributeDefinitionEnumeration getFixture() {
        return (AttributeDefinitionEnumeration)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture( ErfFactory.eINSTANCE.createAttributeDefinitionEnumeration() );
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

} //AttributeDefinitionEnumerationTest
