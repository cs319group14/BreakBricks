import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Ball extends GameKit implements BreakBricksCommons {

    private int xDirection;
    private int yDirection;
    protected String ballImageDirectory = "https://raw.githubusercontent.com/cs319group14/BreakBricks/master/assets/asset_ball.png"; // TODO

    public Ball() throws IOException {

        xDirection = 1;
        yDirection = -1;

        URL url = new URL(ballImageDirectory);
        //Image image = ImageIO.read(url);
        ImageIcon ii = new ImageIcon(ImageIO.read(url));
       image = ii.getImage();

        width = image.getWidth(null);
        height = image.getHeight(null);

        resetState();
    }

    public void move()
    {
        x += xDirection;
        y += yDirection;

        if (x == 0) {
            setxDirection(1);
        }

        if (x == BALL_RIGHT) {
            setxDirection(-1);
        }

        if (y == 0) {
            setyDirection(1);
        }
    }

    public void resetState()
    {
        x = 230;
        y = 55;
    }

    public void setxDirection(int xDirection) {
        this.xDirection = xDirection;
    }

    public void setyDirection(int yDirection) {
        this.yDirection = yDirection;
    }

    public int getyDirection()
    {
        return yDirection;
    }
}
