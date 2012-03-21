/**
 * <copyright>
 * </copyright>
 *
 * $Id: AttributeValueSimpleTest.java 351 2011-09-07 19:19:17Z cpn $
 */
package era.foss.erf.tests;

import era.foss.erf.AttributeValueSimple;
import era.foss.erf.ErfFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Attribute Value Simple</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AttributeValueSimpleTest extends AttributeValueTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main( String[] args ) {
        TestRunner.run( AttributeValueSimpleTest.class );
    }

    /**
     * Constructs a new Attribute Value Simple test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AttributeValueSimpleTest( String name ) {
        super( name );
    }

    /**
     * Returns the fixture for this Attribute Value Simple test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected AttributeValueSimple getFixture() {
        return (AttributeValueSimple)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture( ErfFactory.eINSTANCE.createAttributeValueSimple() );
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

} //AttributeValueSimpleTest
