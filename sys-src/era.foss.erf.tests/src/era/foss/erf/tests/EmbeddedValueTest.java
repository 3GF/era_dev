/**
 * <copyright>
 * </copyright>
 *
 * $Id: EmbeddedValueTest.java 351 2011-09-07 19:19:17Z cpn $
 */
package era.foss.erf.tests;

import era.foss.erf.EmbeddedValue;
import era.foss.erf.ErfFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Embedded Value</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EmbeddedValueTest extends TestCase {

    /**
     * The fixture for this Embedded Value test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EmbeddedValue fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main( String[] args ) {
        TestRunner.run( EmbeddedValueTest.class );
    }

    /**
     * Constructs a new Embedded Value test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EmbeddedValueTest( String name ) {
        super( name );
    }

    /**
     * Sets the fixture for this Embedded Value test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture( EmbeddedValue fixture ) {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Embedded Value test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EmbeddedValue getFixture() {
        return fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture( ErfFactory.eINSTANCE.createEmbeddedValue() );
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

} //EmbeddedValueTest
