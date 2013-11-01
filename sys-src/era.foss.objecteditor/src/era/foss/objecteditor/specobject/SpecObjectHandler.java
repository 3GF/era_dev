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
package era.foss.objecteditor.specobject;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.StructuredSelection;

import era.foss.erf.Content;
import era.foss.erf.ErfFactory;
import era.foss.erf.ErfPackage;
import era.foss.erf.SpecHierarchy;
import era.foss.erf.SpecObject;
import era.foss.erf.SpecType;
import era.foss.erf.Specification;
import era.foss.objecteditor.ErfObjectsEditorPlugin;

/**
 * This class holds methods for a handling {@link SpecObject}s like
 * <ul>
 * <li>creating a {@link SpecObject} in the desired hierarchy level</li>
 * <li>deleting a {@link SpecObject} and all elements in the hirarchy below</li>
 * </ul>
 * 
 */
public class SpecObjectHandler {

    public SpecObjectHandler() {

    }

    /**
     * Remove specObject and associated hierarchy element in {@link SpecHierarchy}
     * 
     * @param specObject specObject to be deleted
     * */
    public static void deleteSpecObject( EditingDomain editingDomain, SpecObject specObject ) {
        CompoundCommand compoundCommand = new CompoundCommand();
        compoundCommand.setLabel( ErfObjectsEditorPlugin.INSTANCE.getString( "_UI_DeleteSpecObject_label" ) );
        compoundCommand.setDescription( ErfObjectsEditorPlugin.INSTANCE.getString( "_UI_DeleteSpecObject_description" ) );

        // delete SpecHierarachy
        StructuredSelection specHierarchySelection = new StructuredSelection( specObject.getSpecHierarchy() );
        if( !specHierarchySelection.isEmpty() ) {
            Command deleteSpecHierarachyCommand = new DeleteCommand( editingDomain, specHierarchySelection.toList() );
            compoundCommand.append( deleteSpecHierarachyCommand );
        }

        // delete SpecObject
        Command deleteSpecObjectCommand = new DeleteCommand(
            editingDomain,
            new StructuredSelection( specObject ).toList() );
        compoundCommand.append( deleteSpecObjectCommand );

        editingDomain.getCommandStack().execute( compoundCommand );
    }

    /**
     * Create a new SpecObject and a new SpecHierarchy which refers to the SpecObject
     * 
     * The SpecHierachy is be created beneath the Specification
     * 
     * @param specType the type of the SpecObject to create
     */
    public static void createNewSpecObject( EditingDomain editingDomain,
                                            Content content,
                                            SpecType specType,
                                            Specification specification ) {
        createNewSpecObject( editingDomain, content, specType, specification, ErfPackage.SPECIFICATION__CHILDREN );
    }

    /**
     * Create a new SpecObject and a new SpecHierarchy which refers to the SpecObject
     * 
     * The SpecHierachy is be created beneath the Specification
     * 
     * @param specType the type of the SpecObject to create
     */
    public static void createNewSpecObject( EditingDomain editingDomain,
                                            Content content,
                                            SpecType specType,
                                            SpecHierarchy specHierarchyParent ) {
        createNewSpecObject( editingDomain,
                             content,
                             specType,
                             specHierarchyParent,
                             ErfPackage.SPEC_HIERARCHY__CHILDREN );
    }

    /**
     * Create a new SpecObject and a new SpecHierarchy which refers to the SpecObject
     * 
     * The SpecHierachy is be created beneath the Specification
     * 
     * @param specType the type of the SpecObject to create
     */
    private static void createNewSpecObject( EditingDomain editingDomain,
                                             Content content,
                                             SpecType specType,
                                             EObject specHierachyParent,
                                             Object feature ) {
        SpecObject newSpecObject = ErfFactory.eINSTANCE.createSpecObject();
        newSpecObject.setType( specType );

        CompoundCommand compoundCommand = new CompoundCommand();
        compoundCommand.setLabel( ErfObjectsEditorPlugin.INSTANCE.getString( "_UI_AddSpecObject_label" ) );
        compoundCommand.setDescription( ErfObjectsEditorPlugin.INSTANCE.getString( "_UI_AddSpecObject_description" ) );

        // command for creating a SpecObject
        Command addSpecObjectCommand = AddCommand.create( editingDomain,
                                                          content,
                                                          ErfPackage.CONTENT__SPEC_OBJECTS,
                                                          newSpecObject );
        compoundCommand.append( addSpecObjectCommand );

        // command for creating a SpecHierarchy

        SpecHierarchy newSpecHierarchy = ErfFactory.eINSTANCE.createSpecHierarchy();
        newSpecHierarchy.setObject( newSpecObject );
        Command addSpecHierarchyCommand = AddCommand.create( editingDomain,
                                                             specHierachyParent,
                                                             feature,
                                                             newSpecHierarchy );
        compoundCommand.append( addSpecHierarchyCommand );

        // execute compoundCommand
        CommandStack commandStack = editingDomain.getCommandStack();
        commandStack.execute( compoundCommand );
    }

    public static void createCommonMenuItems( IMenuManager manager, EditingDomain editingDomain, SpecObject specObject ) {
        // menu entries for adding a specObject
        Action addAction = new AddSpecObjectAction( editingDomain, specObject, true );
        Action addBelowAction = new AddSpecObjectAction( editingDomain, specObject, false );

        // Add menu entry for removal of SpecObject
        Action removeAction = new RemoveSpecObjectAction( editingDomain, specObject );
        if( specObject == null ) {
            addAction.setEnabled( false );
            addBelowAction.setEnabled( false );
            removeAction.setEnabled( false );
        }
        manager.add( addAction );
        manager.add( addBelowAction );
        manager.add( removeAction );

    }

}
