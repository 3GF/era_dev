/**
 * <copyright>
 * </copyright>
 *
 * $Id: AttributeValueBooleanTest.java 351 2011-09-07 19:19:17Z cpn $
 */
package era.foss.erf.tests;

import era.foss.erf.AttributeValueBoolean;
import era.foss.erf.ErfFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Attribute Value Boolean</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AttributeValueBooleanTest extends AttributeValueTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main( String[] args ) {
        TestRunner.run( AttributeValueBooleanTest.class );
    }

    /**
     * Constructs a new Attribute Value Boolean test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AttributeValueBooleanTest( String name ) {
        super( name );
    }

    /**
     * Returns the fixture for this Attribute Value Boolean test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected AttributeValueBoolean getFixture() {
        return (AttributeValueBoolean)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture( ErfFactory.eINSTANCE.createAttributeValueBoolean() );
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

} //AttributeValueBooleanTest
