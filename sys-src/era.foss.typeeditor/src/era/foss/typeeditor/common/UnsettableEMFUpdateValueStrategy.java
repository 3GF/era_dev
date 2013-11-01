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
package era.foss.typeeditor.common;

import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;

/**
 * The purpose of this class is to handle the update of String values which are 'unsettable' (see
 * {@link EStructuralFeature#isUnsettable()})
 */
class UnsettableEMFUpdateValueStrategy extends EMFUpdateValueStrategy {
    /**
     * Structural feature of the observed value
     */
    private EStructuralFeature eStructuralFeature;

    /**
     * Constructor
     * 
     * @param eStructuralFeature structural feature of the value to the conversion is applied
     */
    public UnsettableEMFUpdateValueStrategy( EStructuralFeature eStructuralFeature ) {
        super();
        this.eStructuralFeature = eStructuralFeature;
    }

    @Override
    /**
     * In case the value sting is empty and the observed feature is 'unsettable' 
     * then return {@link SetCommand.UNSET_VALUE}
     * Otherwise leave the value as it is
     */
    public Object convert( Object value ) {
        if( ((String)value).isEmpty() && this.eStructuralFeature.isUnsettable() ) {
            return SetCommand.UNSET_VALUE;
        }
        return super.convert( value );
    }
}
