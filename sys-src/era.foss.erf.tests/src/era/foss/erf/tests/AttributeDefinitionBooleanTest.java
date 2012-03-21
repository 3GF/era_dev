/**
 * <copyright>
 * </copyright>
 *
 * $Id: AttributeDefinitionBooleanTest.java 351 2011-09-07 19:19:17Z cpn $
 */
package era.foss.erf.tests;

import era.foss.erf.AttributeDefinitionBoolean;
import era.foss.erf.ErfFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Attribute Definition Boolean</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AttributeDefinitionBooleanTest extends AttributeDefinitionTest {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main( String[] args ) {
        TestRunner.run( AttributeDefinitionBooleanTest.class );
    }

    /**
     * Constructs a new Attribute Definition Boolean test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AttributeDefinitionBooleanTest( String name ) {
        super( name );
    }

    /**
     * Returns the fixture for this Attribute Definition Boolean test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected AttributeDefinitionBoolean getFixture() {
        return (AttributeDefinitionBoolean)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp() throws Exception {
        setFixture( ErfFactory.eINSTANCE.createAttributeDefinitionBoolean() );
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

} //AttributeDefinitionBooleanTest
