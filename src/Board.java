import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;


public class Board extends JPanel implements BreakBricksCommons {

    Image ii;
    Timer timer;
    String message = "Game Over";
    Ball ball;
    Paddle paddle;
    Brick bricks[];
    boolean ingame = true;

    public Board() {

        addKeyListener(new TAdapter());
        setFocusable(true);

        bricks = new Brick[30];
        setDoubleBuffered(true);
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 1000, 10);
    }

    public void gameInit() {

        ball = new Ball();
        paddle = new Paddle();


        int k = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                bricks[k] = new Brick(j * 40 + 30, i * 10 + 50);
                k++;
            }
        }
    }

    public void stopGame() {
        ingame = false;
        timer.cancel();
    }

    // TODO
    public void pauseGame(){
        timer.cancel();
    }
    // Not tried yet may cause errors
    public void resumeGame() {
        timer.scheduleAtFixedRate(new ScheduleTask(), 1000, 10);
    }

    public void paint(Graphics g) {
        super.paint(g);

        if (ingame) {
            g.drawImage(ball.getImage(), ball.getX(), ball.getY(),
                    ball.getWidth(), ball.getHeight(), this);
            g.drawImage(paddle.getImage(), paddle.getX(), paddle.getY(),
                    paddle.getWidth(), paddle.getHeight(), this);

            for (int i = 0; i < 30; i++) {
                if (!bricks[i].isDestroyed())
                    g.drawImage(bricks[i].getImage(), bricks[i].getX(),
                            bricks[i].getY(), bricks[i].getWidth(),
                            bricks[i].getHeight(), this);
            }
        } else {

            Font font = new Font("Verdana", Font.BOLD, 18);
            FontMetrics metr = this.getFontMetrics(font);

            g.setColor(Color.BLACK);
            g.setFont(font);
            g.drawString(message,
                    (BreakBricksCommons.WIDTH - metr.stringWidth(message)) / 2,
                    BreakBricksCommons.WIDTH / 2);
        }


        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void checkCollision() {

        if (ball.getRect().getMaxY() > BreakBricksCommons.BOTTOM) {
            stopGame();
        }

        for (int i = 0, j = 0; i < 30; i++) {
            if (bricks[i].isDestroyed()) {
                j++;
            }
            if (j == 30) {
                message = "Victory";
                stopGame();
            }
        }

        if ((ball.getRect()).intersects(paddle.getRect())) {

            int paddleLPos = (int) paddle.getRect().getMinX();
            int ballLPos = (int) ball.getRect().getMinX();

            int first = paddleLPos + 8;
            int second = paddleLPos + 16;
            int third = paddleLPos + 24;
            int fourth = paddleLPos + 32;

            if (ballLPos < first) {
                ball.setxDirection(-1);
                ball.setyDirection(-1);
            }

            if (ballLPos >= first && ballLPos < second) {
                ball.setxDirection(-1);
                ball.setyDirection(-1 * ball.getyDirection());
            }

            if (ballLPos >= second && ballLPos < third) {
                ball.setxDirection(0);
                ball.setyDirection(-1);
            }

            if (ballLPos >= third && ballLPos < fourth) {
                ball.setxDirection(1);
                ball.setyDirection(-1 * ball.getyDirection());
            }

            if (ballLPos > fourth) {
                ball.setxDirection(1);
                ball.setyDirection(-1);
            }
        }


        for (int i = 0; i < 30; i++) {
            if ((ball.getRect()).intersects(bricks[i].getRect())) {

                int ballLeft = (int) ball.getRect().getMinX();
                int ballHeight = (int) ball.getRect().getHeight();
                int ballWidth = (int) ball.getRect().getWidth();
                int ballTop = (int) ball.getRect().getMinY();

                Point pointRight =
                        new Point(ballLeft + ballWidth + 1, ballTop);
                Point pointLeft = new Point(ballLeft - 1, ballTop);
                Point pointTop = new Point(ballLeft, ballTop - 1);
                Point pointBottom =
                        new Point(ballLeft, ballTop + ballHeight + 1);

                if (!bricks[i].isDestroyed()) {
                    if (bricks[i].getRect().contains(pointRight)) {
                        ball.setxDirection(-1);
                    } else if (bricks[i].getRect().contains(pointLeft)) {
                        ball.setxDirection(1);
                    }

                    if (bricks[i].getRect().contains(pointTop)) {
                        ball.setyDirection(1);
                    } else if (bricks[i].getRect().contains(pointBottom)) {
                        ball.setyDirection(-1);
                    }

                    bricks[i].setDestroyed(true);
                }
            }
        }
    }

    //**********************************************************
    //* Inner Classes
    //**********************************************************
    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            paddle.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            paddle.keyPressed(e);
        }
    }


    class ScheduleTask extends TimerTask {

        public void run() {

            ball.move();
            paddle.move();
            checkCollision();
            repaint();

        }
    }
    //**********************************************************

}
