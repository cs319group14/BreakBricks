import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by kemalbuyukkaya on 05/12/15.
 */
public class ControlAdapter extends KeyAdapter{

    Paddle paddle;

    public ControlAdapter(Paddle p){
        paddle = p;
    }

    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
        paddle.keyReleased(e);
    }

    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        paddle.keyPressed(e);
    }
}
