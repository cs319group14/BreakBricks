import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class HighScore extends JPanel implements BreakBricksCommons {

    JLabel firstLabel, secondLabel, thirdLabel, hsLabel;
    JTextField myL;
    public JButton backButton;
    public HighScore() throws IOException {

        firstLabel = new JLabel();
        secondLabel = new JLabel();
        thirdLabel = new JLabel();
        hsLabel = new JLabel();

        backButton=new JButton("Back");
        backButton.setSize(new Dimension(30,30));
        backButton.setVisible(true);

        firstLabel.setSize(new Dimension(300,300));
        firstLabel.setText("First Label ");
        firstLabel.setVisible(true);

        secondLabel.setSize(new Dimension(300,300));
        secondLabel.setText("Second Label ");
        secondLabel.setVisible(true);

        thirdLabel.setSize(new Dimension(300,300));
        thirdLabel.setText("Third Label ");
        thirdLabel.setVisible(true);

        hsLabel.setSize(new Dimension(300,300));
        hsLabel.setText("High Scores ");
        hsLabel.setVisible(true);

        this.setLayout(new BorderLayout());
        this.add(firstLabel);
        this.add(secondLabel);
        this.add(thirdLabel);
        this.add(backButton);
        repaint();
        refreshHS();

    }

    public void refreshHS() throws IOException {
        try{
            firstLabel.setText((String) db.getAllScores().get(0));
            secondLabel.setText((String) db.getAllScores().get(1));
            thirdLabel.setText((String) db.getAllScores().get(2));
        }catch (NullPointerException e)
        {
            System.out.println("Null database index");
        }


    }
}
