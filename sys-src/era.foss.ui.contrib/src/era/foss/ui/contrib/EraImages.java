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
package era.foss.ui.contrib;

import java.util.HashMap;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * The Class EraImages.
 */
public class EraImages {

    /** The image registry. */
    private static HashMap<String, Image> imageRegistry;

    /** Image for setting default value. @since 3.4 */
    public final static String IMG_DEFAULT_VALUE = "elcl16/defaultValue.gif";

    /** Image for moving elements up. @since 3.4 */
    public final static String IMG_MOVE_UP = "elcl16/moveUp.png";

    /** Image for moving elements down. @since 3.4 */
    public final static String IMG_MOVE_DOWN = "elcl16/moveDown.png";

    /**
     * Gets the image.
     *
     * @param imageName the image name
     * @return the image
     */
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

    /**
     * Gets the image descriptor.
     *
     * @param imageName the image name
     * @return the image descriptor
     */
    public static ImageDescriptor getImageDescriptor( String imageName ) {
        return ImageDescriptor.createFromImage( EraImages.getImage( imageName ) );
    }
}
