import javax.swing.*;
import java.util.ArrayList;

public class HighScore extends JPanel implements BreakBricksCommons {

    ArrayList hS;//sample array
    JTextField myL;

    public HighScore(){
    }

    public void refreshHS() {

        hS=db.getAllScores();

    }
}
