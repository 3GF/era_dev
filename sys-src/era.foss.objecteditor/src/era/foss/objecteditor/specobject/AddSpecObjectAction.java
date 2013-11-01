package era.foss.objecteditor.specobject;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import era.foss.erf.SpecHierarchy;
import era.foss.erf.SpecObject;
import era.foss.objecteditor.ErfObjectsEditorPlugin;

/**
 * Action for adding a {@link SpecObject}
 * 
 */
public class AddSpecObjectAction extends Action {

    private EditingDomain editingDomain;
    private SpecObject specObject;
    private boolean isBelow;

    public AddSpecObjectAction( EditingDomain editingDomain, SpecObject specObject, boolean isBelow ) {
        this.editingDomain = editingDomain;
        this.specObject = specObject;
        this.isBelow = isBelow;

        ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
        this.setImageDescriptor( sharedImages.getImageDescriptor( ISharedImages.IMG_OBJ_ADD ) );
        this.setDisabledImageDescriptor( sharedImages.getImageDescriptor( ISharedImages.IMG_OBJ_ADD ) );

        if( isBelow == true ) {
            this.setText( ErfObjectsEditorPlugin.INSTANCE.getString( "_UI_AddSpecObjectBelow_label" ) );
        } else {
            this.setText( ErfObjectsEditorPlugin.INSTANCE.getString( "_UI_AddSpecObject_label" ) );
        }

    }

    @Override
    public void run() {

        if( specObject != null && specObject.getSpecHierarchy() != null ) {
            if( specObject.getSpecHierarchy().getParent() != null || isBelow == true ) {

                // set get the parent SpecHierarchy
                SpecHierarchy specHierarchy;
                if( isBelow == true ) {
                    specHierarchy = this.specObject.getSpecHierarchy();
                } else {
                    specHierarchy = this.specObject.getSpecHierarchy().getParent();
                }
                SpecObjectHandler.createNewSpecObject( this.editingDomain,
                                                       this.specObject.getCoreContent(),
                                                       this.specObject.getType(),
                                                       specHierarchy );

            } else if( specObject.getSpecHierarchy().getRoot() != null ) {
                SpecObjectHandler.createNewSpecObject( this.editingDomain,
                                                       this.specObject.getCoreContent(),
                                                       this.specObject.getType(),
                                                       this.specObject.getSpecHierarchy().getRoot() );
            }
        }
    }
}
