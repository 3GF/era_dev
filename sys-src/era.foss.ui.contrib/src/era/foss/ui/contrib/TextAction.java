package era.foss.ui.contrib;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.WorkbenchMessages;

/**
 * Action for a {@link Text} control
 */
@SuppressWarnings("restriction")
public class TextAction extends Action {

    /**
     * text field
     */
    private Text text;
    private TextActionType actionType;

    /**
     * Actions provided by this factory
     */
    public enum TextActionType {
        COPY, PASTE, CUT
    }

    /**
     * Creates a action for a {@link Text} control
     * 
     * @param text text field to copy data from
     */
    public TextAction( Text text, TextActionType actionType ) {

        this.actionType = actionType;
        this.text = text;

        ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
        switch (actionType) {
        case COPY:
            this.setText( WorkbenchMessages.Workbench_copy );
            this.setToolTipText( WorkbenchMessages.Workbench_copyToolTip );
            this.setImageDescriptor( sharedImages.getImageDescriptor( ISharedImages.IMG_TOOL_COPY ) );
            this.setDisabledImageDescriptor( sharedImages.getImageDescriptor( ISharedImages.IMG_TOOL_COPY_DISABLED ) );
            break;

        case CUT:
            this.setText( WorkbenchMessages.Workbench_cut );
            this.setToolTipText( WorkbenchMessages.Workbench_cutToolTip );
            this.setImageDescriptor( sharedImages.getImageDescriptor( ISharedImages.IMG_TOOL_CUT ) );
            this.setDisabledImageDescriptor( sharedImages.getImageDescriptor( ISharedImages.IMG_TOOL_CUT_DISABLED ) );
            break;

        case PASTE:
            this.setText( WorkbenchMessages.Workbench_paste );
            this.setToolTipText( WorkbenchMessages.Workbench_pasteToolTip );
            this.setImageDescriptor( sharedImages.getImageDescriptor( ISharedImages.IMG_TOOL_PASTE ) );
            this.setDisabledImageDescriptor( sharedImages.getImageDescriptor( ISharedImages.IMG_TOOL_PASTE_DISABLED ) );

            // disable paste action in case there is nothing in the clipboard
            Clipboard clipboard = new Clipboard( Display.getCurrent() );
            TextTransfer textTransfer = TextTransfer.getInstance();
            String clipboardTextData = (String)clipboard.getContents( textTransfer );
            clipboard.dispose();
            if( clipboardTextData == null ) {
                this.setEnabled( false );
            } else {
                this.setEnabled( true );
            }
            break;
        }

        // disable copy or cut action in case there is nothing selected
        if( (actionType == TextActionType.COPY || actionType == TextActionType.CUT)
            && text.getSelectionText().isEmpty() ) {
            this.setEnabled( false );
        } else {
            this.setEnabled( true );
        }

    }

    @Override
    public void run() {
        switch (this.actionType) {
        case COPY:
            text.copy();
            break;
        case CUT:
            text.cut();
            break;
        case PASTE:
            text.paste();
            break;
        }
    }
}
