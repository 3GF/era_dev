/**
 * <copyright>
 * </copyright>
 *
 * $Id: DatatypeDefinitionBooleanTest.java 351 2011-09-07 19:19:17Z cpn $
 */
package era.foss.erf.tests;

import era.foss.erf.DatatypeDefinitionBoolean;
import era.foss.erf.ErfFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Datatype Definition Boolean</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DatatypeDefinitionBooleanTest extends DatatypeDefinitionTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main( String[] args ) {
        TestRunner.run( DatatypeDefinitionBooleanTest.class );
    }

    /**
     * Constructs a new Datatype Definition Boolean test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DatatypeDefinitionBooleanTest( String name ) {
        super( name );
    }

    /**
     * Returns the fixture for this Datatype Definition Boolean test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected DatatypeDefinitionBoolean getFixture() {
        return (DatatypeDefinitionBoolean)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture( ErfFactory.eINSTANCE.createDatatypeDefinitionBoolean() );
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

} //DatatypeDefinitionBooleanTest
