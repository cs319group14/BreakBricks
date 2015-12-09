import java.io.IOException;

/**
 * Created by kemalbuyukkaya on 09/12/15.
 */
public class NormalBrick extends Brick {

    public NormalBrick(int x, int y) throws IOException {
        super(x,y,"assets/normal_brick.png");
        strength = 2;
    }
    public void breakdown(){
        if (strength > 0) {
            if (appliedPowerUpId == 0)
                strength = 0;
            else {
                strength--;
                if (strength == 1) {
                    setImage("assets/normal_brick_damaged.png");
                }
            }
        }
    }
}
