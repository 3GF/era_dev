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

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import era.foss.erf.SpecObject;

/**
 * Action for removing a SpecObject
 * 
 */
public class RemoveSpecObjectAction extends Action {

    private EditingDomain editingDomain;

    /** SpecObject to be removed */
    private SpecObject specObject;

    public RemoveSpecObjectAction( EditingDomain editingDomain, SpecObject specObject ) {
        this.specObject = specObject;
        this.editingDomain = editingDomain;
        this.setText( ErfObjectsEditorPlugin.INSTANCE.getString( "_UI_DeleteSpecObject_label" ) );
        ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
        this.setImageDescriptor( sharedImages.getImageDescriptor( ISharedImages.IMG_TOOL_DELETE ) );
        this.setDisabledImageDescriptor( sharedImages.getImageDescriptor( ISharedImages.IMG_TOOL_DELETE_DISABLED ) );
    }

    @Override
    public void run() {
        SpecObjectHandler.deleteSpecObject( editingDomain, specObject );
    }

}
