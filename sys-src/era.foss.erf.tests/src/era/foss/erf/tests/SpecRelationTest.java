/**
 * <copyright>
 * </copyright>
 *
 * $Id: SpecRelationTest.java 351 2011-09-07 19:19:17Z cpn $
 */
package era.foss.erf.tests;

import era.foss.erf.ErfFactory;
import era.foss.erf.SpecRelation;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Spec Relation</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SpecRelationTest extends SpecElementWithUserDefinedAttributesTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main( String[] args ) {
        TestRunner.run( SpecRelationTest.class );
    }

    /**
     * Constructs a new Spec Relation test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SpecRelationTest( String name ) {
        super( name );
    }

    /**
     * Returns the fixture for this Spec Relation test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected SpecRelation getFixture() {
        return (SpecRelation)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture( ErfFactory.eINSTANCE.createSpecRelation() );
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

} //SpecRelationTest
