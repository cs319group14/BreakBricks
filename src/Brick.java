import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;

public class Brick extends GameKit implements BreakBricksCommons {

   // String brickImageDirectory = "https://raw.githubusercontent.com/cs319group14/BreakBricks/master/assets/assets_brick.png";
  //  String brickImageDirectory = "assets/assets_brick.png";
    boolean destroyed;
    PowerUp p;
    int strength;

    public Brick(int x, int y) throws IOException {
         this(x,y,"assets/assets_brick.png");
    }

    public Brick(int x, int y, String textureDirectory) throws IOException {
        this.x = x;
        this.y = y;
        setImage(textureDirectory);
        width = image.getWidth(null);
        height = image.getHeight(null);
        destroyed = false;
        //TODO
        p=new PowerUp();//Generate a random power up

    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public void setImage(String textureDirectory) {
        ImageIcon ii = new ImageIcon(textureDirectory);
        image = ii.getImage();
    }

    public void breakdown(){
        if (strength > 0)
            strength--;
    }

    public int getStrength(){ return strength;}

    public int getPowerUpId()
    {
        return p.getId();
    }
}
