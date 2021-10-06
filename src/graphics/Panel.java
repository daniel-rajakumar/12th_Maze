package graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Panel extends JPanel {
    private JFrame frame;

    public Panel(){
        frame = new JFrame("A maze program");
        frame.setSize(1150, 600);
        frame.add(this);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
