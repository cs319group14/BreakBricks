import java.io.IOException;

/**
 * Created by kemalbuyukkaya on 09/12/15.
 */
public class GlassBrick extends Brick {

    public GlassBrick(int x, int y) throws IOException {
        super(x,y,"assets/glass_brick.png");
        strength = 1;
    }
}
