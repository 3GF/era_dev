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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import era.foss.erf.AttributeDefinition;
import era.foss.erf.AttributeValue;
import era.foss.erf.Content;
import era.foss.erf.SpecType;

/**
 * The Class RemoveAttributeDefinitionCommand.
 */
public class RemoveAttributeDefinitionCommand extends RemoveCommand {

    /**
     * Instantiates a new removes the attribute definition command.
     *
     * @param domain the domain
     * @param owner the owner
     * @param feature the feature
     * @param collection the collection
     */
    public RemoveAttributeDefinitionCommand( EditingDomain domain,
                                             EObject owner,
                                             EStructuralFeature feature,
                                             Collection<?> collection ) {
        super( domain, owner, feature, collection );
    }

    @Override
    public void doExecute() {
        super.doExecute();

        Content erfContentCore = (Content)((SpecType)this.owner).eContainer();

        for( Object obj : this.collection ) {
            AttributeDefinition ego = (AttributeDefinition)obj;
            removeAttributedefinition_checkAndHandleLastAttributedefinitionRemoval( ego, erfContentCore );
            removeAttributedefinition_cleanupAffectedAttributevalues( ego, erfContentCore );
        }
    }

    private void removeAttributedefinition_checkAndHandleLastAttributedefinitionRemoval( AttributeDefinition ego,
                                                                                         Content erfContentCore ) {
        /*
         * purge all SpecObjects, because if then again new AttributeDefinitions are created, there still exists the
         * pointless old list of empty SpecObjects with generated internal IDs
         */
        if( ((SpecType)this.owner).getSpecAttributes().isEmpty() ) {
            // remove all SpecObjects
            Command removeCommand = RemoveCommand.create( this.domain, erfContentCore.getSpecObjects() );
            this.domain.getCommandStack().execute( removeCommand );
        }
    }

    private void removeAttributedefinition_cleanupAffectedAttributevalues( AttributeDefinition ego,
                                                                           Content erfContentCore ) {
        LinkedList<AttributeValue> attributeValuesToRemove = FinderUtil.helper_findAttributevaluesInAllSpecobjectsBasedonAttributedefinition( ego,
                                                                                                                                              erfContentCore );
        if( !attributeValuesToRemove.isEmpty() ) {
            Command removeCommand = RemoveCommand.create( this.domain, attributeValuesToRemove );
            this.domain.getCommandStack().execute( removeCommand );
        }
    }
}
