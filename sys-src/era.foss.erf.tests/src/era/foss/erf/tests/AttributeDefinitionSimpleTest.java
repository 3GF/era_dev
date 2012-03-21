/**
 * <copyright>
 * </copyright>
 *
 * $Id: AttributeDefinitionSimpleTest.java 351 2011-09-07 19:19:17Z cpn $
 */
package era.foss.erf.tests;

import era.foss.erf.AttributeDefinitionSimple;
import era.foss.erf.ErfFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Attribute Definition Simple</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AttributeDefinitionSimpleTest extends AttributeDefinitionTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main( String[] args ) {
        TestRunner.run( AttributeDefinitionSimpleTest.class );
    }

    /**
     * Constructs a new Attribute Definition Simple test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AttributeDefinitionSimpleTest( String name ) {
        super( name );
    }

    /**
     * Returns the fixture for this Attribute Definition Simple test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected AttributeDefinitionSimple getFixture() {
        return (AttributeDefinitionSimple)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture( ErfFactory.eINSTANCE.createAttributeDefinitionSimple() );
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

} //AttributeDefinitionSimpleTest
