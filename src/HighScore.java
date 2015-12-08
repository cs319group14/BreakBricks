import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HighScore extends JPanel implements BreakBricksCommons {

    ArrayList hS;//sample array
    JTextField myL;
    public JButton backButton;
    public HighScore(){
        backButton=new JButton("Back");
        backButton.setSize(new Dimension(300,300));
        backButton.setVisible(true);
        this.add(backButton);
        repaint();

    }

    public void refreshHS() {

        hS=db.getAllScores();

    }
}
