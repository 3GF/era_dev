/**
 * <copyright>
 * </copyright>
 *
 * $Id: ContentTest.java 351 2011-09-07 19:19:17Z cpn $
 */
package era.foss.erf.tests;

import era.foss.erf.Content;
import era.foss.erf.ErfFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Content</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ContentTest extends TestCase {

    /**
     * The fixture for this Content test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected Content fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main( String[] args ) {
        TestRunner.run( ContentTest.class );
    }

    /**
     * Constructs a new Content test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ContentTest( String name ) {
        super( name );
    }

    /**
     * Sets the fixture for this Content test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture( Content fixture ) {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Content test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected Content getFixture() {
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
        setFixture( ErfFactory.eINSTANCE.createContent() );
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

} //ContentTest
