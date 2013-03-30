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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.ReplaceCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import era.foss.erf.AttributeDefinition;
import era.foss.erf.DatatypeDefinition;
import era.foss.erf.Content;
import era.foss.erf.ErfPackage;
import era.foss.erf.SpecType;

/**
 * The Class ReplaceDatatypeDefinitionCommand.
 */
public class ReplaceDatatypeDefinitionCommand extends ReplaceCommand {

    /**
     * Instantiates a new replace datatype definition command.
     *
     * @param domain the domain
     * @param owner the owner
     * @param feature the feature
     * @param value the value
     * @param collection the collection
     * @since Jul 28, 2010
     */
    public ReplaceDatatypeDefinitionCommand( EditingDomain domain,
                                             EObject owner,
                                             EStructuralFeature feature,
                                             Object value,
                                             Collection<?> collection ) {
        super( domain, owner, feature, value, collection );
        assert(collection.size() == 1);
    }

    @Override
    public void doExecute()
    {
      super.doExecute();
      
      SpecType theOneAndOnlySpecType = ((Content) this.owner).getSpecTypes().get( 0 );
      
      Collection<AttributeDefinition> affectedAttributeDefinitions = FinderUtil.helper_findAttributedefinitionsInSpectypeBasedonDatatypedefinition( (DatatypeDefinition)value, theOneAndOnlySpecType );
      // replace the old TYPE (=DataDefinition) with the new one, in each affected AttributeDefinition
      for( AttributeDefinition attributeDefinition : affectedAttributeDefinitions ) {
          Command cmd = new SetCommand(
              this.domain,
              attributeDefinition,
              attributeDefinition.eClass().getEStructuralFeature( ErfPackage.ATTRIBUTE_DEFINITION__TYPE ),
              this.collection.toArray()[0] );
          this.domain.getCommandStack().execute( cmd );
      }
    }
    
}
