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
import java.net.URISyntaxException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.ui.statushandlers.StatusManager;

/**
 * Static helper methods to convert error and diagnostic types to {@link IStatus} and to show errors to the user.
 * 
 * @author poldi
 */
public class Log {
    

    /**
     * Converts ecore diagnostic result to a {@link IStatus} multi status object.
     * 
     * @param diagnostics errors or warnings
     * @param plugin the plug-in logging the error
     * @param severity {@link IStatus} severity
     * @return status or null on error
     * @since Jul 31, 2009
     */
    public static IStatus convert( Diagnostic diagnostics, String plugin, int severity ) {
        try {
            return new ResourceStatus(
                severity,
                plugin,
                new URI( diagnostics.getLocation() ),
                diagnostics.getLine(),
                diagnostics.getColumn(),
                diagnostics.getMessage(),
                new Exception() );
        } catch( URISyntaxException e ) {
            return null;
        }
    }

    /**
     * Shows a modal error dialog to the user if running the GUI else lgs the errors to the console.
     * 
     * @param status The error to show
     * @since Jul 31, 2009
     */
    public static void show( IStatus status ) {
        StatusManager.getManager().handle( status, StatusManager.BLOCK );
    }

    /**
     * Log errors to the error log.
     * 
     * @param status the errors to log
     * @since Jul 31, 2009
     */
    public static void log( IStatus status ) {
        StatusManager.getManager().handle( status, StatusManager.LOG );
    }

} // Error
