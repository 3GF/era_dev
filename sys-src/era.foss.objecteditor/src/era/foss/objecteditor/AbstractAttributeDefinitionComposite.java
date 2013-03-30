package era.foss.objecteditor;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import era.foss.erf.AttributeValue;
import era.foss.erf.SpecObject;
import era.foss.erf.ViewElement;
import era.foss.ui.contrib.EraImages;

public abstract class AbstractAttributeDefinitionComposite extends Composite {

    /** color for default values */
    final static int COLOR_DEFAULT_VALUE = SWT.COLOR_INFO_BACKGROUND;

    /** The view element to show which refers to a AttributeDefifinition */
    final ViewElement viewElement;

    /** Create one data binding context for all Elements */
    static final DataBindingContext dbc = new DataBindingContext();

    /** binding of the GUI element to the model element */
    Binding binding;

    private Control control;

    private ControlDecoration errorDecoration;
    protected AttributeValue attributeValue;
    protected EditingDomain editingDomain;

    protected SpecObject specObject;

    private IChangeListener changeListener;

    public AbstractAttributeDefinitionComposite( Composite parent, ViewElement viewElement ) {
        super( parent, SWT.NONE );
        this.setLayout( new FillLayout() );
        this.viewElement = viewElement;

        this.control = createControl();

        // create a change listener triggering the validation
        this.changeListener = new IChangeListener() {
            @Override
            public void handleChange( ChangeEvent event ) {
                AbstractAttributeDefinitionComposite.this.validate();
            }
        };

        // set up decoration for showing erroneous validation
        errorDecoration = new ControlDecoration( this.control, SWT.RIGHT | SWT.TOP );
        errorDecoration.hide();
        FieldDecoration fieldDecoration = FieldDecorationRegistry.getDefault()
                                                                 .getFieldDecoration( FieldDecorationRegistry.DEC_ERROR );
        errorDecoration.setImage( fieldDecoration.getImage() );

        // add menu
        createContextMenu();

    }

    /** Create the control according to the respective AttributeDefinition */
    abstract public Control createControl();

    /** Get the control actually representing the AttributeDefinition */
    public abstract Control getControl();

    /**
     * Bind the AttributeValue to the control
     * 
     * @param specObject SpecObject holding this attribute
     * @param attributeValue AttributeValue to bind (may also be null)
     * @param editingDomain the editing Domain
     */
    public abstract void doBind( SpecObject specObject, AttributeValue attributeValue, EditingDomain editingDomain );

    /**
     * Return the view element associated with this GUI element
     * 
     * @return the view element associated with this GUI element
     */
    public ViewElement getViewElement() {
        return viewElement;
    }

    /**
     * Bind the GUI element to the model element. This has to be implemented be subclasses.
     * 
     * <strong>Subclasses have to to call this method in case the ovveride it.</strong>
     */
    public void bind( SpecObject specObject, AttributeValue attributeValue, EditingDomain editingDomain ) {
        this.unbind();
        this.specObject = specObject;
        this.attributeValue = attributeValue;
        this.editingDomain = editingDomain;
        this.doBind( specObject, attributeValue, editingDomain );
        this.setupValidation();
    }

    /**
     * Unbind the GUI element from the model element.
     * 
     * <strong>Subclasses have to to call this method in case the ovveride it.</strong>
     */
    public void unbind() {
        if( this.binding != null ) {
            removeValidation();
            dbc.removeBinding( binding );
            binding.dispose();
            binding = null;
            attributeValue = null;
        }
    }

    /**
     * Setup validation
     * <ol>
     * <li>Update validation status
     * <li>Add listener to invoke validation on any changes
     * </ol>
     */
    private void setupValidation() {
        this.validate();
        if( binding != null && binding.isDisposed() == false ) {
            binding.getModel().addChangeListener( this.changeListener );
        }
    }

    /**
     * Tear down validation
     * <ol>
     * <li>Remove change listener
     * </ol>
     */
    private void removeValidation() {
        this.validate();
        if( binding != null && binding.isDisposed() == false && this.changeListener != null ) {
            binding.getModel().removeChangeListener( this.changeListener );
        }
    }

    /**
     * Validate the value and adapt decoration
     */
    private void validate() {
        if( attributeValue != null ) {
            Diagnostic diagnostic = Diagnostician.INSTANCE.validate( attributeValue );
            if( diagnostic.getSeverity() == Diagnostic.ERROR ) {
                errorDecoration.show();
            } else {
                errorDecoration.hide();
            }
        } else {
            errorDecoration.hide();
        }
    }

    /**
     * Creates the context menu for all kind of AttributeDefinitions
     */
    protected void createContextMenu() {

        /**
         * Action for removing a value from a spec object
         * 
         * From the point of the user this will be seen as setting a value to it respective default value
         */
        final class RemoveValueAction extends Action {

            public RemoveValueAction() {
                this.setText( "Restore default value" );
                this.setImageDescriptor( EraImages.getImageDescriptor( EraImages.IMG_DEFAULT_VALUE ) );
            }

            @Override
            public void run() {
                AttributeValue attributeValueLocal = attributeValue;
                unbind();
                Command deleteCommand = new DeleteCommand( editingDomain, new StructuredSelection(
                    attributeValueLocal ).toList() );
                editingDomain.getCommandStack().execute( deleteCommand );
                bind( specObject, null, editingDomain );
            }
        }

        final MenuManager menuMgr = new MenuManager();
        menuMgr.setRemoveAllWhenShown( true );
        menuMgr.addMenuListener( new IMenuListener() {
            /*
             * (non-Javadoc)
             * 
             * @see org.eclipse.jface.action.IMenuListener#menuAboutToShow(org.eclipse.jface.action.IMenuManager)
             */
            public void menuAboutToShow( IMenuManager manager ) {
                AbstractAttributeDefinitionComposite.this.menuAboutToShow( manager );
                manager.add( new Separator() );
                if( attributeValue != null ) {
                    manager.add( new RemoveValueAction() );
                }
                manager.add( new Separator() );

            }
        } );

        // register menu at the table viewer
        control.setMenu( menuMgr.createContextMenu( control ) );
    }

    protected void menuAboutToShow( IMenuManager manager ) {

    }

}
