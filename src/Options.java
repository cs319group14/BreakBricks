import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Kaan on 28/10/15.
 */
public class Options extends JPanel implements BreakBricksCommons{


    JPanel brickPanel;
    JLabel paddleLabel,ballLabel,brickLabel;
    Image imageBall,imagePaddle,imageBrick;
    public JButton backButton;

public Options(){

    backButton= new JButton("Back");

    addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            System.out.println("X is: "+e.getX()+" Y is: "+e.getY());
        }
    });

    //brickPanel= new JPanel();
    // this.add(brickPanel);
    //brickPanel.setSize(new Dimension(300,300));

    add(backButton);
    backButton.setSize(new Dimension(150,50));
    backButton.setLocation(5,520);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        ImageIcon ii = new ImageIcon("assets/asset_ball.png");
        imageBall = ii.getImage();
        ii = new ImageIcon("assets/asset_paddle.png");
        imagePaddle = ii.getImage();
        ii = new ImageIcon("assets/asset_brick.png");
        imageBrick = ii.getImage();

        //ToDo cant display images

        g.drawImage(imageBall, 30, 100, null);
        g.drawImage(imagePaddle, 30, 380, null);
        g.drawImage(imageBrick, 30, 300, null);



    }
}
