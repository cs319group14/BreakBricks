import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Graphics;


public class Board extends JPanel implements BreakBricksCommons {

    Timer timer;
    boolean paused=false;
    String message = "Game Over";
    Ball ball;
    Paddle paddle;
    Brick bricks[];
    boolean ingame = true;
    int currentScore;
    SoundManager sm;

    public Board() throws IOException, UnsupportedAudioFileException {
        currentScore=0;
        paddle = new Paddle();
        ball = new Ball();
        bricks = new Brick[30];
        setDoubleBuffered(true);
        timer = new Timer();
        sm = new SoundManager();
      //addKeyListener(new TAdapter());
        addMouseListener(new MAdapter());
        setFocusable(true);
        requestFocusInWindow();

    }

    public Paddle getPaddle(){
        return this.paddle;
    }

    public void addNotify() {
        super.addNotify();
        System.out.print("Notify block.");
        try {
            gameInit();
            System.out.print("Game initialized.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        timer.scheduleAtFixedRate(new ScheduleTask(), 1000, 5);
    }

    public void gameInit() throws IOException {

        int k = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                Random rand = new Random();
                int x = rand.nextInt(3);
                if (x == 0) {
                    bricks[k] = new GlassBrick(j * 70 + 15, i * 25 + 50);
                }
                else if (x == 1){
                    bricks[k] = new NormalBrick(j * 70 + 15, i * 25 + 50);
                }
                else {
                    bricks[k] = new SteelBrick(j * 70 + 15, i * 25 + 50);
                }
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
        paused=true;
    }
    // Not tried yet may cause errors
    public void resumeGame() {
        timer.scheduleAtFixedRate(new ScheduleTask(), 500, 10);
        paused=false;
    }
/*
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

            db.storeScore(currentScore);
        }


        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

*/

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        ImageIcon ii = new ImageIcon("assets/background.png");
        Image image = ii.getImage();

        if (ingame) {
            g2d.drawImage(image,0,0,null);
            drawObjects(g2d);
        } else {

            gameFinished(g2d);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics2D g2d) {
        g2d.drawImage(ball.getImage(), ball.getX(), ball.getY(),
                ball.getWidth(), ball.getHeight(), this);
        g2d.drawImage(paddle.getImage(), paddle.getX(), paddle.getY(),
                paddle.getWidth(), paddle.getHeight(), this);

        for (int i = 0; i < 30; i++) {
            if (!bricks[i].isDestroyed()) {
                g2d.drawImage(bricks[i].getImage(), bricks[i].getX(),
                        bricks[i].getY(), bricks[i].getWidth(),
                        bricks[i].getHeight(), this);
            }
        }
    }

    private void gameFinished(Graphics2D g2d) {

        Font font = new Font("Verdana", Font.BOLD, 18);
        FontMetrics metr = this.getFontMetrics(font);

        g2d.setColor(Color.BLACK);
        g2d.setFont(font);
        g2d.drawString(message,
                (BreakBricksCommons.WIDTH - metr.stringWidth(message)) / 2,
                BreakBricksCommons.WIDTH / 2);
    }
    public void checkCollision() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        if (ball != null && ball.getRect().getMaxY() > BreakBricksCommons.BOTTOM) {
            stopGame();
        }

        for (int i = 0, j = 0; i < 30; i++) {
            if (bricks[i] != null && bricks[i].isDestroyed()) {
                j++;
                currentScore++;
            }
            if (j == 30) {
                message = "Victory";
                db.storeScore(currentScore);
                stopGame();
            }
        }

        if (ball != null && paddle != null && (ball.getRect()).intersects(paddle.getRect())) {

            sm.playSound(0);
            int paddleLPos = (int) paddle.getRect().getMinX();
            int ballLPos = (int) ball.getRect().getMinX();

            int first = paddleLPos + 10;
            int second = paddleLPos + 30;
            int third = paddleLPos + 45;
            int fourth = paddleLPos + 65;


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
            if (ball != null && bricks[i] != null && (ball.getRect()).intersects(bricks[i].getRect())) {

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

                    if(bricks[i] instanceof NormalBrick)
                        sm.playSound(1);
                    else if(bricks[i] instanceof SteelBrick)
                        sm.playSound(3);
                    else if(bricks[i] instanceof GlassBrick)
                        sm.playSound(2);

                    bricks[i].breakdown();
                    if(bricks[i].getStrength() == 0){
                        bricks[i].setDestroyed(true);
                    }

                }
            }
        }
    }

    //**********************************************************
    //* Inner Classes
    //**********************************************************
    private class TAdapter extends KeyAdapter {
        public TAdapter(){
            System.out.println("Adapter Created");
        }

        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
            System.out.println("Key released");
            paddle.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            System.out.println("Key pressed");
            paddle.keyPressed(e);
        }
    }

    private class MAdapter extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            System.out.println("clicked");
            paddle.mouseClicked(e);
        }
    }


    class ScheduleTask extends TimerTask {

        // Paddle has serious problems
        public void run() {
            if (ball != null)
                 ball.move();
            if(paddle != null) {
                paddle.move();
            }

            try {
                checkCollision();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }

            repaint();

        }
    }
    //**********************************************************

}
