/**
 * <copyright>
 * </copyright>
 *
 * $Id: DatatypeDefinitionStringTest.java 351 2011-09-07 19:19:17Z cpn $
 */
package era.foss.erf.tests;

import era.foss.erf.DatatypeDefinitionString;
import era.foss.erf.ErfFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Datatype Definition String</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DatatypeDefinitionStringTest extends DatatypeDefinitionSimpleTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main( String[] args ) {
        TestRunner.run( DatatypeDefinitionStringTest.class );
    }

    /**
     * Constructs a new Datatype Definition String test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DatatypeDefinitionStringTest( String name ) {
        super( name );
    }

    /**
     * Returns the fixture for this Datatype Definition String test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected DatatypeDefinitionString getFixture() {
        return (DatatypeDefinitionString)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture( ErfFactory.eINSTANCE.createDatatypeDefinitionString() );
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

} //DatatypeDefinitionStringTest
