import sun.jvm.hotspot.jdi.IntegerTypeImpl;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Ball extends GameKit implements BreakBricksCommons {

    private int xDirection;
    private int yDirection;
//  protected String ballImageDirectory = "https://raw.githubusercontent.com/cs319group14/BreakBricks/master/assets/asset_ball.png";
    protected String ballImageDirectory = "assets/asset_ball.png";
    private int appliedPowerUpId = Integer.MAX_VALUE;

    public Ball() throws IOException {

        xDirection = 0;
        yDirection = -1;

        //URL url = new URL(ballImageDirectory);
        //ImageIcon ii = new ImageIcon(ImageIO.read(url));
        ImageIcon ii = new ImageIcon(ballImageDirectory);
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
        x = 240;
        y = 520;
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

    public boolean applyPowerUp(int powerUpId) {

        appliedPowerUpId = powerUpId;
        if (powerUpId == 0) {
            setImage("assets/fireball.png");
            return true;
        }
        return false;
    }

    public void cancelPowerUp() {

        if (appliedPowerUpId == 0){
            setImage(ballImageDirectory);
        }
        appliedPowerUpId = Integer.MAX_VALUE;
    }


}
