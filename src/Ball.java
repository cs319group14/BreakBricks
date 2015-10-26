import javax.swing.ImageIcon;

public class Ball extends GameKit implements BreakBricksCommons {

    private int xDirection;
    private int yDirection;
    protected String ballImageDirectory = ""; // TODO

    public Ball() {

        xDirection = 1;
        yDirection = -1;

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
