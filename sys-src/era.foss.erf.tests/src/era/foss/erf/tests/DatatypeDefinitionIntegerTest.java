/**
 * <copyright>
 * </copyright>
 *
 * $Id: DatatypeDefinitionIntegerTest.java 351 2011-09-07 19:19:17Z cpn $
 */
package era.foss.erf.tests;

import era.foss.erf.DatatypeDefinitionInteger;
import era.foss.erf.ErfFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Datatype Definition Integer</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DatatypeDefinitionIntegerTest extends DatatypeDefinitionSimpleTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main( String[] args ) {
        TestRunner.run( DatatypeDefinitionIntegerTest.class );
    }

    /**
     * Constructs a new Datatype Definition Integer test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DatatypeDefinitionIntegerTest( String name ) {
        super( name );
    }

    /**
     * Returns the fixture for this Datatype Definition Integer test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected DatatypeDefinitionInteger getFixture() {
        return (DatatypeDefinitionInteger)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture( ErfFactory.eINSTANCE.createDatatypeDefinitionInteger() );
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

} //DatatypeDefinitionIntegerTest
