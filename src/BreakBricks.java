import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class BreakBricks extends JFrame implements ActionListener {

    JButton play;
    JButton options;
    JButton highS;
    JButton helpButton;
    JLabel mLabel;
    JLabel treeButtonLabel;
    Board myB;
    HighScore hS;
    Options op;
    Help help;

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

    //TODO

    public int CalculateScore()
    {
    return -1;
    }

    //TODO
    public void saveScore()
    {

    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == play) {
            remove(mLabel);
            try {
                myB = new Board();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (UnsupportedAudioFileException e1) {
                e1.printStackTrace();
            }
            myB.setSize(BreakBricksCommons.WIDTH, BreakBricksCommons.HEIGTH);
            myB.addKeyListener(new ControlAdapter(myB.getPaddle()));
            add(myB);
            myB.jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    remove(myB);
                    add(mLabel);
                    repaint();

                }
            });

            myB.setVisible(true);
            myB.setFocusable(true);
            myB.requestFocus();
            myB.repaint();
            repaint();
        } else if (e.getSource() == highS) {
            remove(mLabel);

                try {
                    hS=new HighScore();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                hS.setSize(BreakBricksCommons.WIDTH, BreakBricksCommons.HEIGTH);
                hS.backButton.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        remove(hS);
                        add(mLabel);
                        repaint();
                    }
                });

            add(hS);
            hS.setVisible(true);
            hS.setFocusable(true);
            hS.requestFocus();
            hS.repaint();
            repaint();

        }else if(e.getSource()==options)
        {
            remove(mLabel);
            if(op==null)
            {
                op=new Options();
                op.setSize(BreakBricksCommons.WIDTH, BreakBricksCommons.HEIGTH);
                op.backButton.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        remove(op);
                        add(mLabel);
                        repaint();
                    }
                });
            }

            add(op);
            op.setVisible(true);
            op.setFocusable(true);
            op.requestFocus();
            op.repaint();
            repaint();

        }else if(e.getSource()==helpButton)
        {
            remove(mLabel);
            if(help==null)
            {
                try {
                    help=new Help();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                help.setSize(BreakBricksCommons.WIDTH, BreakBricksCommons.HEIGTH);
                help.backButton.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        remove(help);
                        add(mLabel);
                        repaint();
                    }
                });
            }

            add(help);
            help.setVisible(true);
            help.setFocusable(true);
            help.requestFocus();
            help.repaint();
            repaint();

        }
    }

    public static void main(String[] args) {
        new BreakBricks();
    }
}
