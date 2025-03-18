import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/** Singleton class for loading and accessing sprite images through a single array,
 * where each image file has been copied to an Image object only once.
 */
public class SpriteHandler {
    private final String[] IMAGE_PATHS = {""};
    private final Image[] images = new Image[IMAGE_PATHS.length];
    private static final SpriteHandler instance = new SpriteHandler();
    private SpriteHandler() {
        for (int i = 0; i < IMAGE_PATHS.length; i++) {
            try {
                images[i] = ImageIO.read(new File(IMAGE_PATHS[i]));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static SpriteHandler getInstance() {
        return instance;
    }
    public Image getImage(int i) {
        return images[i];
    }

}
