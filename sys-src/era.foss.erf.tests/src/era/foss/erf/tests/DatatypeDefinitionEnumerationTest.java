/**
 * <copyright>
 * </copyright>
 *
 * $Id: DatatypeDefinitionEnumerationTest.java 351 2011-09-07 19:19:17Z cpn $
 */
package era.foss.erf.tests;

import era.foss.erf.DatatypeDefinitionEnumeration;
import era.foss.erf.ErfFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Datatype Definition Enumeration</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DatatypeDefinitionEnumerationTest extends DatatypeDefinitionTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main( String[] args ) {
        TestRunner.run( DatatypeDefinitionEnumerationTest.class );
    }

    /**
     * Constructs a new Datatype Definition Enumeration test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DatatypeDefinitionEnumerationTest( String name ) {
        super( name );
    }

    /**
     * Returns the fixture for this Datatype Definition Enumeration test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected DatatypeDefinitionEnumeration getFixture() {
        return (DatatypeDefinitionEnumeration)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture( ErfFactory.eINSTANCE.createDatatypeDefinitionEnumeration() );
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

} //DatatypeDefinitionEnumerationTest
