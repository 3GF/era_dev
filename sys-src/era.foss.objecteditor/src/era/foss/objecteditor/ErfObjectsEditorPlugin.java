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
package era.foss.objecteditor;

import org.eclipse.emf.common.EMFPlugin;

import org.eclipse.emf.common.ui.EclipseUIPlugin;

import org.eclipse.emf.common.util.ResourceLocator;

/**
 * This is the central singleton for the Erf editor plugin.
 */
public final class ErfObjectsEditorPlugin extends EMFPlugin {
    /**
     * Keep track of the singleton.
     */
    public static final ErfObjectsEditorPlugin INSTANCE = new ErfObjectsEditorPlugin();

    /**
     * Keep track of the singleton.
     */
    private static Implementation plugin;

    /**
     * Create the instance.
     */
    public ErfObjectsEditorPlugin() {
        super( new ResourceLocator[]{} );
    }

    /**
     * Returns the singleton instance of the Eclipse plugin.
     * @return the singleton instance.
     */
    @Override
    public ResourceLocator getPluginResourceLocator() {
        return plugin;
    }

    /**
     * Returns the singleton instance of the Eclipse plugin.
     * @return the singleton instance.
     */
    public static Implementation getPlugin() {
        return plugin;
    }

    /**
     * The actual implementation of the Eclipse <b>Plugin</b>.
     * @generated
     */
    public static class Implementation extends EclipseUIPlugin {
        /**
         * Creates an instance.
         */
        public Implementation() {
            super();

            // Remember the static instance.
            //
            plugin = this;
        }
    }

}
