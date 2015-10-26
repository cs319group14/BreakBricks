import javax.swing.*;

public class Brick extends GameKit implements BreakBricksCommons {

    String brickImageDirectory = "";
    boolean destroyed;

    public Brick(int x, int y) {
        this.x = x;
        this.y = y;
        ImageIcon ii = new ImageIcon(brickImageDirectory);
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
