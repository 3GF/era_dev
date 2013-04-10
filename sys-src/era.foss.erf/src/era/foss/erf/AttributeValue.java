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
 * The Interface AttributeValue.
 * 
 * @model abstract="true"
 */
public interface AttributeValue extends Identifiable {

    /**
     * Gets the definition.
     * 
     * @return the definition
     * @model lowerBound="1"
     */
    public AttributeDefinition getDefinition();

    /**
     * Sets the value of the '{@link era.foss.erf.AttributeValue#getDefinition <em>Definition</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value the new value of the '<em>Definition</em>' reference.
     * @see #getDefinition()
     * @generated
     */
    void setDefinition( AttributeDefinition value );

}
