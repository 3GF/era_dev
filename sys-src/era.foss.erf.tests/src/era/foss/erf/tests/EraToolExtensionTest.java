/**
 * <copyright>
 * </copyright>
 *
 * $Id: EraToolExtensionTest.java 351 2011-09-07 19:19:17Z cpn $
 */
package era.foss.erf.tests;

import era.foss.erf.EraToolExtension;
import era.foss.erf.ErfFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Era Tool Extension</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EraToolExtensionTest extends ToolExtensionTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main( String[] args ) {
        TestRunner.run( EraToolExtensionTest.class );
    }

    /**
     * Constructs a new Era Tool Extension test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EraToolExtensionTest( String name ) {
        super( name );
    }

    /**
     * Returns the fixture for this Era Tool Extension test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EraToolExtension getFixture() {
        return (EraToolExtension)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture( ErfFactory.eINSTANCE.createEraToolExtension() );
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

} //EraToolExtensionTest
