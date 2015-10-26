import javax.swing.*;
import java.awt.event.KeyEvent;

public class Paddle extends GameKit implements BreakBricksCommons {
    String paddle = ""; //TODO

    int dx;

    public Paddle() {

        ImageIcon ii = new ImageIcon(paddle);
        image = ii.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
        resetState();
    }

    public void resetState() {
        x = 200;
        y = 360;
    }

    public void move() {
        x += dx;
        if (x <= 2)
            x = 2;
        if (x >= BreakBricksCommons.PADDLE_RIGHT)
            x = BreakBricksCommons.PADDLE_RIGHT;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }
    
}
