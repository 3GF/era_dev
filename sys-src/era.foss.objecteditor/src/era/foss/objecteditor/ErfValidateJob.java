package era.foss.objecteditor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;

import era.foss.erf.ERF;
import era.foss.erf.SpecObject;

public class ErfValidateJob extends Job {
    private ErfMarkerHelper markerHelper = new ErfMarkerHelper();
    private ERF erfModel;

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
