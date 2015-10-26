import javax.swing.*;

public class HighScore extends JPanel implements BreakBricksCommons {

    int[] hS;//sample array
    String output;
    JTextField myL;

    public HighScore() {
        output = "";
        hS = new int[10];
        for (int i = 0; i < 10; i++) {
            hS[i] = i;
        }
        convert();

        myL = new JTextField(output);
        System.out.println(myL.getText());
        this.add(myL);
        myL.setVisible(true);


        setSize(BreakBricksCommons.WIDTH, BreakBricksCommons.HEIGTH);
        setIgnoreRepaint(true);
        setVisible(true);
        repaint();
    }

    public void convert() {
        for (int i = 0; i < 10; i++) {
            output = output + hS[i] + " /n";
        }
    }
}
