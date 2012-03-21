package era.foss.ui.contrib;

import java.util.HashMap;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

public class EraImages {

    private static HashMap<String, Image> imageRegistry;

    /**
     * Image for setting default value
     * 
     * @since 3.4
     */
    public final static String IMG_DEFAULT_VALUE = "elcl16/defaultValue.gif";

    /**
     * Image for moving elements up
     * 
     * @since 3.4
     */
    public final static String IMG_MOVE_UP = "elcl16/moveUp.png";

    /**
     * Image for moving elements down
     * 
     * @since 3.4
     */
    public final static String IMG_MOVE_DOWN = "elcl16/moveDown.png";

    public static Image getImage( String imageName ) {

        // create new registry if it doesn't exists
        if( imageRegistry == null ) {
            imageRegistry = new HashMap<String, Image>();
        }

        Image image;
        // check if a descriptor for this image has already been created
        if( imageRegistry.containsKey( imageName ) ) {
            image = imageRegistry.get( imageName );
        } else {
            // register image descriptor in registry
            ImageDescriptor imageDescriptor = Activator.getImageDescriptor( imageName );
            if( imageDescriptor == null ) {
                image = null;
            } else {
                image = imageDescriptor.createImage();
                imageRegistry.put( imageName, image );
            }
        }

        return image;
    }

    public static ImageDescriptor getImageDescriptor( String imageName ) {
        return ImageDescriptor.createFromImage( EraImages.getImage( imageName ) );
    }
}
