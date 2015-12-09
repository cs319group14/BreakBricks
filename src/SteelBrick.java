import java.io.IOException;

/**
 * Created by kemalbuyukkaya on 09/12/15.
 */
public class SteelBrick extends Brick {

    public SteelBrick(int x, int y) throws IOException {
        super(x,y,"assets/steel_brick.png");
        strength = 3;
    }
    public void breakdown(){
        if (strength > 0) {
            if (appliedPowerUpId == 0){
                strength = 0;
            }
            else {
                strength--;
                if (strength == 2) {
                    setImage("assets/steel_brick_damaged_1.png");
                } else if (strength == 1) {
                    setImage("assets/steel_brick_damaged_2.png");
                }
            }

        }
    }
}
