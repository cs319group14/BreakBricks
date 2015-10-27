import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;

public class Brick extends GameKit implements BreakBricksCommons {

    String brickImageDirectory = "https://raw.githubusercontent.com/cs319group14/BreakBricks/master/assets/assets_brick.png";
    boolean destroyed;

    public Brick(int x, int y) throws IOException {
        this.x = x;
        this.y = y;

        URL url = new URL(brickImageDirectory);
        ImageIcon ii = new ImageIcon(ImageIO.read(url));
        image = ii.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
        destroyed = false;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }
}
