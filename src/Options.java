import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Kaan on 28/10/15.
 */
public class Options extends JPanel implements BreakBricksCommons {


    JPanel brickPanel;
    JLabel paddleLabel, ballLabel, brickLabel;
    Image imageBall, imagePaddle, imageBrick;
    public JButton backButton;

    public Options() {

        backButton = new JButton("Back");

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("X is: " + e.getX() + " Y is: " + e.getY());
            }
        });

        //brickPanel= new JPanel();
        // this.add(brickPanel);
        //brickPanel.setSize(new Dimension(300,300));

        add(backButton);
        backButton.setSize(new Dimension(150, 50));
        backButton.setLocation(5, 520);
    }

    private void drawObjects(Graphics2D g2d) {

        ImageIcon ii = new ImageIcon("assets/asset_ball.png");
        imageBall = ii.getImage();
        ii = new ImageIcon("assets/asset_paddle.png");
        imagePaddle = ii.getImage();
        ii = new ImageIcon("assets/asset_brick.png");
        imageBrick = ii.getImage();

        g2d.drawImage(imageBall, 50, 300,this);
        g2d.drawImage(imagePaddle, 50, 350,this);
    }
}

