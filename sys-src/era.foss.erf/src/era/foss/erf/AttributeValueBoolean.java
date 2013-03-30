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
 * The Interface AttributeValueBoolean.
 *
 * @model
 */
public interface AttributeValueBoolean extends AttributeValue {

    /**
     * Gets the the value.
     *
     * @return the the value
     * @model lowerBound="1" defaultValue="false"
     */
    public Boolean getTheValue();

    /**
     * Sets the value of the '{@link era.foss.erf.AttributeValueBoolean#getTheValue <em>The Value</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>The Value</em>' attribute.
     * @see #getTheValue()
     * @generated
     */
    void setTheValue( Boolean value );

}
