/**************************************************************************
* ERA - Eclipse Requirements Analysis
* ==============================================
* Copyright (C) 2009-2011 by Georg Blaschke, Christoph P. Neumann
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
* $Id$
*************************************************************************/

package era.foss.util.log;

import java.net.URI;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;

/**
 * The Class ResourceStatus.
 * 
 * {@link IStatus} with workbench resource information (URI,line,column) that can be added as a marker.
 * 
 * @author poldi
 */
public class ResourceStatus extends Status {

    //
    // private members

    /** The uri. */
    private URI uri;
    
    /** The line. */
    private int line;
    
    /** The column. */
    private int column;

    /**
     * Instantiates a new resource status.
     * 
     * @param severity the severity
     * @param pluginId the plugin id
     * @param uri the uri
     * @param line the line
     * @param column the column
     * @param message the message
     * @param exception the exception
     * @since Jul 31, 2009
     */
    public ResourceStatus( int severity,
                           String pluginId,
                           URI uri,
                           int line,
                           int column,
                           String message,
                           Throwable exception ) {
        super( severity, pluginId, message, exception );
        this.uri = uri;
        this.line = line;
        this.column = column;
    }

    /**
     * Get an URI to the file.
     * 
     * @return the uri
     * @since Jul 31, 2009
     */
    public URI getUri() {
        return uri;
    }

    /**
     * Get the line in the file.
     * 
     * @return the line
     * @since Jul 31, 2009
     */
    public int getLine() {
        return line;
    }

    /**
     * Get the column in the file.
     * 
     * @return the column
     * @since Jul 31, 2009
     */
    public int getColumn() {
        return column;
    }
    
    /**
     * Creates a marker object and places it to a workspace resource if the uri points to a resource.
     * 
     * @return the marker or null
     * @since Jul 31, 2009
     */
    public IMarker createResourceMarker() {
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        if( workspace == null ) return null;
        IFile file = workspace.getRoot().getFile( new Path( uri.toASCIIString() ) );
        if( file == null ) return null;
        
        IMarker marker;
        try {
            marker = file.createMarker( IMarker.PROBLEM );
            switch( getSeverity() ) {
                case ERROR:
                    marker.setAttribute( IMarker.SEVERITY, IMarker.SEVERITY_ERROR );
                    break;
                case WARNING:
                    marker.setAttribute( IMarker.SEVERITY, IMarker.SEVERITY_WARNING );
                    break;
                case INFO:
                    marker.setAttribute( IMarker.SEVERITY, IMarker.SEVERITY_INFO );
                    break;
                default:
                    marker.setAttribute( IMarker.SEVERITY, IMarker.SEVERITY_INFO );
                    break;
            }
            marker.setAttribute( IMarker.MESSAGE, getMessage() );
            marker.setAttribute( IMarker.LINE_NUMBER, getLine() );
            marker.setAttribute( IMarker.LOCATION, "Line: " + getLine() + ", Column: " + column );
        } catch( CoreException e ) {
            return null;
        }
        
        return marker;
        
    }

} // ResourceStatus
