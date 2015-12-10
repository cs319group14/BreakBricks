import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * Created by Kaan on 28/10/15.
 */
public class Help extends JPanel{

    JLabel infoLabel;
    JLabel leftButton;
    JLabel rightButton;
    public JButton backButton;

    public Help() throws IOException {


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("X is: "+e.getX()+" Y is: "+e.getY());
            }
        });

        backButton=new JButton("Back");

        backButton.setSize(new Dimension(150,50));
        backButton.setLocation(5,520);
        backButton.setVisible(true);

        infoLabel = new JLabel("<html>-In this game, each brick counts as 1 point,  also <br>elapsed time gives you bonuses.If you lose,<br> there wont be time bonus.<br> -FireBall: Makes you to 1 hit all types of bricks.</html>",SwingConstants.CENTER);
        infoLabel.setSize(new Dimension(350, 300));
        infoLabel.setVisible(true);

        rightButton = new JLabel();
        rightButton.setSize(new Dimension(300,50));
        rightButton.setVisible(true);

        leftButton = new JLabel();
        leftButton.setSize(new Dimension(300,50));
        leftButton.setVisible(true);

        rightButton.setLocation(250,316);
        leftButton.setLocation(100,316);
        infoLabel.setLocation(10,30);

        rightButton.setText("Move right");
        leftButton.setText("Move left");

        add(rightButton);
        add(leftButton);
        add(infoLabel);
        this.add(backButton);

        repaint();
        revalidate();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon ii = new ImageIcon("assets/keyboardKeys.png");
        Image im = ii.getImage();

        g.drawImage(im,100,300,ii.getIconWidth()/2,ii.getIconHeight()/2,null);
    }
}
