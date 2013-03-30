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
package era.foss.objecteditor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;

import era.foss.erf.ERF;
import era.foss.erf.SpecObject;

/**
 * The Class ErfValidateJob.
 */
public class ErfValidateJob extends Job {
    
    /** The marker helper. */
    private ErfMarkerHelper markerHelper = new ErfMarkerHelper();
    
    /** The erf model. */
    private ERF erfModel;

    /**
     * Instantiates a new erf validate job.
     *
     * @param erfModel the erf model
     */
    public ErfValidateJob( ERF erfModel ) {
        super( "Validate Spec Objects" );
        this.erfModel = erfModel;
    }

    @Override
    protected IStatus run( IProgressMonitor monitor ) {

        markerHelper.deleteMarkers( erfModel.eResource() );
        BasicDiagnostic diagnostic = new BasicDiagnostic(); // Diagnostician.INSTANCE.createDefaultDiagnostic( object );
        for( SpecObject specObject : erfModel.getCoreContent().getSpecObjects() ) {
            Diagnostician.INSTANCE.validate( specObject, diagnostic );
        }
        markerHelper.createMarkers( diagnostic );
        return Status.OK_STATUS;
    }
}
