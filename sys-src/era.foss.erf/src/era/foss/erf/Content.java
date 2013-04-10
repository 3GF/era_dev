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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * This element represents the root of the Exchange Document core content.
 * 
 * @model
 */
public interface Content extends EObject {

    /**
     * Gets the spec objects.
     * 
     * @return the spec objects
     * @model containment="true"
     */
    public EList<SpecObject> getSpecObjects();

    /**
     * Gets the spec types.
     * 
     * @return the spec types
     * @model containment="true"
     */
    public EList<SpecType> getSpecTypes();

    /**
     * Gets the data types.
     * 
     * @return the data types
     * @model containment="true"
     */
    public EList<DatatypeDefinition> getDataTypes();

    /**
     * Gets the spec relations.
     * 
     * @return the spec relations
     * @model containment="true"
     */
    public EList<SpecRelation> getSpecRelations();

    /**
     * Specification content elements
     * 
     * @model containment="true" opposite="coreContent"
     */
    public EList<Specification> getSpecifications();

}
