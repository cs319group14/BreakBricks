import com.sun.org.apache.xpath.internal.axes.MatchPatternIterator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class HighScore extends JPanel implements BreakBricksCommons {

    JLabel firstLabel, secondLabel, thirdLabel, hsLabel;
    public JButton backButton;

    public HighScore() throws IOException {


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("X is: "+e.getX()+" Y is: "+e.getY());
            }
        });


        firstLabel = new JLabel("-");
        secondLabel = new JLabel("-");
        thirdLabel = new JLabel("-");
        hsLabel = new JLabel();
        backButton=new JButton("Back");

        backButton.setSize(new Dimension(150,50));
        backButton.setLocation(5,520);
        backButton.setVisible(true);
        this.add(backButton);

        firstLabel.setSize(new Dimension(150, 50));
        firstLabel.setText("First Label ");
        firstLabel.setVisible(true);
        this.add(firstLabel);
        firstLabel.setLocation(200,165);

        secondLabel.setSize(new Dimension(150,50));
        secondLabel.setText("Second Label ");
        secondLabel.setVisible(true);
        this.add(secondLabel);
        secondLabel.setLocation(136,222);

        thirdLabel.setSize(new Dimension(150,50));
        thirdLabel.setText("Third Label ");
        thirdLabel.setVisible(true);
        this.add(thirdLabel);
        thirdLabel.setLocation(310,245);

        hsLabel.setSize(new Dimension(150,150));
        hsLabel.setText("High Scores ");
        hsLabel.setVisible(true);
        this.add(hsLabel);
        hsLabel.setLocation(190,20);

        setLayout(new GridBagLayout());

        refreshHS();
        repaint();
        revalidate();
    }

    public void refreshHS() throws IOException {

        ArrayList arr= db.getAllScores();

        try{
            firstLabel.setText(arr.get(2)+"");
            secondLabel.setText(arr.get(1)+"");
            thirdLabel.setText(arr.get(0)+"");
            repaint();
        }catch (NullPointerException e)
        {
            System.out.println("Null database index");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon ii = new ImageIcon("assets/highScores.png");
        Image im = ii.getImage();

        g.drawImage(im,100,150,null);
    }
}
