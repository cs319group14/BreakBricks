import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Paddle extends GameKit implements BreakBricksCommons {
    //String paddle = "https://raw.githubusercontent.com/cs319group14/BreakBricks/master/assets/assets_paddle.png";

    int dx = 0;
    String paddle = "assets/assets_paddle.png";

    public Paddle() throws IOException {

      //  URL url = new URL(paddle);
      //  ImageIcon ii = new ImageIcon(ImageIO.read(url));
        ImageIcon ii = new ImageIcon(paddle);
        image = ii.getImage();

        width = image.getWidth(null);
        height = image.getHeight(null);
        resetState();
    }

    public void resetState() {
        x = 200;
        y = 560;
    }

    public void move() {
        x += dx;
        if (x <= 2)
            x = 2;
        if (x >= BreakBricksCommons.PADDLE_RIGHT)
            x = BreakBricksCommons.PADDLE_RIGHT;
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
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
