import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class HighScore extends JPanel implements BreakBricksCommons {

    JLabel firstLabel, secondLabel, thirdLabel, hsLabel;
    JTextField myL;
    public JButton backButton;
    public HighScore() throws IOException {

        firstLabel = new JLabel("-");
        secondLabel = new JLabel("-");
        thirdLabel = new JLabel("-");
        hsLabel = new JLabel();



        backButton=new JButton("Back");
        backButton.setSize(new Dimension(50,50));
        backButton.setVisible(true);

        this.setLayout(new GridLayout());


        firstLabel.setSize(new Dimension(100,100));
        firstLabel.setText("First Label ");
        firstLabel.setVisible(true);

        secondLabel.setSize(new Dimension(50,50));
        secondLabel.setText("Second Label ");
        secondLabel.setVisible(true);

        thirdLabel.setSize(new Dimension(50,50));
        thirdLabel.setText("Third Label ");
        thirdLabel.setVisible(true);

        hsLabel.setSize(new Dimension(50,50));
        hsLabel.setText("High Scores ");
        hsLabel.setVisible(true);

        this.add(firstLabel);
        this.add(secondLabel);
        this.add(thirdLabel);
        this.add(backButton);


        refreshHS();
        repaint();
    }

    public void refreshHS() throws IOException {
        db.storeScore(100);
        db.storeScore(90);
        db.storeScore(80);
        try{
            firstLabel.setText((String) db.getAllScores().get(0));
            secondLabel.setText((String) db.getAllScores().get(1));
            thirdLabel.setText((String) db.getAllScores().get(2));
            repaint();
        }catch (NullPointerException e)
        {
            System.out.println("Null database index");
        }


    }
}
