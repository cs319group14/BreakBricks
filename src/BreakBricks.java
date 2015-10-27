import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BreakBricks extends JFrame implements ActionListener {

    JButton play;
    JButton options;
    JButton highS;
    JButton helpButton;
    JLabel mLabel;
    JLabel treeButtonLabel;
    Board myB;

    public BreakBricks() {

        treeButtonLabel = new JLabel();
        treeButtonLabel.setLayout(new GridLayout(3, 1));

        mLabel = new JLabel();
        mLabel.setLayout(new BorderLayout());
        add(mLabel);

        play = new JButton("Play");
        options = new JButton("Options");
        highS = new JButton("High Scores");
        helpButton = new JButton("Help");

        helpButton.addActionListener(this);
        play.addActionListener(this);
        options.addActionListener(this);
        highS.addActionListener(this);

        mLabel.add(treeButtonLabel, BorderLayout.CENTER);

        treeButtonLabel.add(play);
        treeButtonLabel.add(options);
        treeButtonLabel.add(highS);
        mLabel.add(helpButton, BorderLayout.SOUTH);

        //add(new Board());

        setTitle("Break Bricks");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(BreakBricksCommons.WIDTH, BreakBricksCommons.HEIGTH);
        setLocationRelativeTo(null);
        setIgnoreRepaint(true);
        setResizable(false);
        setVisible(true);

        play.setVisible(true);
        options.setVisible(true);
        highS.setVisible(true);
        helpButton.setVisible(true);

        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == play) {
            remove(mLabel);
            myB = new Board();
            myB.setSize(BreakBricksCommons.WIDTH, BreakBricksCommons.HEIGTH);
            add(myB);
            myB.setVisible(true);
            myB.repaint();
            repaint();
        } else if (e.getSource() == highS) {
            remove(mLabel);
            add(new HighScore());
            repaint();

        }
    }

    public static void main(String[] args) {
        new BreakBricks();
    }
}
