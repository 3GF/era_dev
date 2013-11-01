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
 * Base class for classes that may restrict user access to their information.
 * 
 * @model abstract="true"
 */
public interface AccessControlledElement extends Identifiable {

    /**
     * <ul>
     * <li>True means that the element’s contents may be modified by the user of a tool containing the element.
     * <li>False or leaving isEditable out means that the element is read-only to the user of a tool containing the
     * element.
     * <ul>
     * 
     * @model unique="true" default="true" required="false"
     */
    public boolean isEditable();

    /**
     * Sets the value of the '{@link era.foss.erf.AccessControlledElement#isEditable <em>Editable</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Editable</em>' attribute.
     * @see #isEditable()
     * @generated
     */
    void setEditable( boolean value );

}
