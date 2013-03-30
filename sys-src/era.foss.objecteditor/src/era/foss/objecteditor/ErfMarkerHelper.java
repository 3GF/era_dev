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

import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.emf.edit.ui.util.EditUIMarkerHelper;


/**
 * The Class ErfMarkerHelper.
 */
public class ErfMarkerHelper extends EditUIMarkerHelper
{

  /**
     * get the ID of the marker. In our case this is the ID used for Eclipse markers which are based on diagnostics of
     * EMF objects.
     * 
     * @return the marker id
     */
  @Override
  protected String getMarkerID()
  {
    return EValidator.MARKER;
  }

  /**
     * Create markers for the issues in the diagnostic object and report errors to the Logging facility of the Edit
     * plugin.
     * 
     * @param diagnostic holding all issues showed up during validation
     */
  public void createMarkers(Diagnostic diagnostic)
  {
    try
    {
      super.createMarkers(diagnostic);
    }
    catch (CoreException e)
    {
      EMFEditUIPlugin.INSTANCE.log(e);
    }
  }

  /**
     * extract the data of validation issues from the diagnostic object.
     * 
     * @param marker the marker
     * @param diagnostic the diagnostic
     * @param parentDiagnostic the parent diagnostic
     * @throws CoreException the core exception
     */
  @Override
  protected void adjustMarker(IMarker marker, Diagnostic diagnostic, Diagnostic parentDiagnostic) throws CoreException
  {
    List<?> data = diagnostic.getData();
    StringBuilder relatedURIs = new StringBuilder();
    boolean first = true;
    for (Object object : data)
    {
      if (object instanceof EObject)
      {
        EObject eObject = (EObject)object;
        if (first)
        {
          first = false;
          marker.setAttribute(EValidator.URI_ATTRIBUTE, EcoreUtil.getURI(eObject).toString());
        }
        else
        {
          if (relatedURIs.length() != 0)
          {
            relatedURIs.append(' ');
          }
          relatedURIs.append(URI.encodeFragment(EcoreUtil.getURI(eObject).toString(), false));
        }
      }
    }

    if (relatedURIs.length() > 0)
    {
      marker.setAttribute(EValidator.RELATED_URIS_ATTRIBUTE, relatedURIs.toString());
    }

    super.adjustMarker(marker, diagnostic, parentDiagnostic);      
  }
}
