/**
 * <copyright>
 * </copyright>
 *
 * $Id: SpecObjectTest.java 351 2011-09-07 19:19:17Z cpn $
 */
package era.foss.erf.tests;

import era.foss.erf.ErfFactory;
import era.foss.erf.SpecObject;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Spec Object</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SpecObjectTest extends SpecElementWithUserDefinedAttributesTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main( String[] args ) {
        TestRunner.run( SpecObjectTest.class );
    }

    /**
     * Constructs a new Spec Object test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SpecObjectTest( String name ) {
        super( name );
    }

    /**
     * Returns the fixture for this Spec Object test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected SpecObject getFixture() {
        return (SpecObject)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture( ErfFactory.eINSTANCE.createSpecObject() );
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

} //SpecObjectTest
