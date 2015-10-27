import javax.swing.*;

public class Brick extends GameKit implements BreakBricksCommons {

    String brickImageDirectory = "https://raw.githubusercontent.com/cs319group14/BreakBricks/master/assets/assets_brick.png";
    boolean destroyed;

    public Brick(int x, int y) {
        this.x = x;
        this.y = y;
        ImageIcon ii = new ImageIcon(this.getClass().getResource(brickImageDirectory));
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
