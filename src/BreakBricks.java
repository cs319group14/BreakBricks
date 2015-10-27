import javax.swing.*;

public class BreakBricks extends JFrame{


    public BreakBricks()
    {
        add(new Board());
    }

    public static void main(String [ ] args)
    {
        new BreakBricks();
    }
}
