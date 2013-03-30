/**************************************************************************
 * ERA - Eclipse Requirements Analysis
 * ==============================================
 * Copyright (C) 2009-2013 by Georg Blaschke, Christoph P. Neumann
 * and Bernd Haberstumpf (http://era.origo.ethz.ch)
 **************************************************************************
 * Licensed under the Eclipse Public License - v 1.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.eclipse.org/org/documents/epl-v10.html
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **************************************************************************
*/
package era.foss.erf;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Spec Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link era.foss.erf.SpecRelation#getSource <em>Source</em>}</li>
 *   <li>{@link era.foss.erf.SpecRelation#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see era.foss.erf.ErfPackage#getSpecRelation()
 * @model
 * @generated
 */
public interface SpecRelation extends SpecElementWithUserDefinedAttributes {
    /**
     * Returns the value of the '<em><b>Source</b></em>' reference.
     * It is bidirectional and its opposite is '{@link era.foss.erf.SpecObject#getTargets <em>Targets</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source</em>' reference.
     * @see #setSource(SpecObject)
     * @see era.foss.erf.ErfPackage#getSpecRelation_Source()
     * @see era.foss.erf.SpecObject#getTargets
     * @model opposite="targets" required="true"
     * @generated
     */
    SpecObject getSource();

    /**
     * Sets the value of the '{@link era.foss.erf.SpecRelation#getSource <em>Source</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source</em>' reference.
     * @see #getSource()
     * @generated
     */
    void setSource( SpecObject value );

    /**
     * Returns the value of the '<em><b>Target</b></em>' reference.
     * It is bidirectional and its opposite is '{@link era.foss.erf.SpecObject#getSources <em>Sources</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target</em>' reference.
     * @see #setTarget(SpecObject)
     * @see era.foss.erf.ErfPackage#getSpecRelation_Target()
     * @see era.foss.erf.SpecObject#getSources
     * @model opposite="sources" required="true"
     * @generated
     */
    SpecObject getTarget();

    /**
     * Sets the value of the '{@link era.foss.erf.SpecRelation#getTarget <em>Target</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target</em>' reference.
     * @see #getTarget()
     * @generated
     */
    void setTarget( SpecObject value );

} // SpecRelation
