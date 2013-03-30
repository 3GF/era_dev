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
package era.foss.erf.provider;

import java.util.Collection;
import java.util.LinkedList;

import era.foss.erf.AttributeDefinition;
import era.foss.erf.AttributeValue;
import era.foss.erf.AttributeValueSimple;
import era.foss.erf.DatatypeDefinition;
import era.foss.erf.Content;
import era.foss.erf.SpecObject;
import era.foss.erf.SpecType;

/**
 * The Class FinderUtil.
 */
public class FinderUtil {

    /**
     * Helper_find attributevalues in all specobjects basedon attributedefinition.
     *
     * @param attributeDefinition the attribute definition
     * @param erfCoreContent the erf core content
     * @return the linked list
     */
    public static LinkedList<AttributeValue> helper_findAttributevaluesInAllSpecobjectsBasedonAttributedefinition( AttributeDefinition attributeDefinition, Content erfCoreContent ) {
        LinkedList<AttributeValue> retList = new LinkedList<AttributeValue>();
        // look at every SpecObject
        for( SpecObject specObject : erfCoreContent.getSpecObjects() ) {
            // look at every AttributeValue
            for( AttributeValue attributeValue : specObject.getValues() ) {
                assert (attributeValue instanceof AttributeValueSimple);
                // search for an affected AttributeValue
                if( ((AttributeValueSimple)attributeValue).getDefinition().getID() != attributeDefinition.getID() ) continue;
                // this AttributeValue is of the type of the affected AttributeDefinition
                retList.add( attributeValue );
            }
        }
        return retList;
    }

    /**
     * Helper_find attributedefinitions in spectype basedon datatypedefinition.
     *
     * @param self the self
     * @param theOneAndOnlySpecType the the one and only spec type
     * @return the collection
     */
    public static Collection<AttributeDefinition> helper_findAttributedefinitionsInSpectypeBasedonDatatypedefinition( DatatypeDefinition self, SpecType theOneAndOnlySpecType) {
        LinkedList<AttributeDefinition> retList = new LinkedList<AttributeDefinition>();
        for( AttributeDefinition attributeDefinition : theOneAndOnlySpecType.getSpecAttributes() ) {
            if( (attributeDefinition.getType() != self) ) continue;
            retList.add( attributeDefinition );
        }
        return retList;
    }

}
