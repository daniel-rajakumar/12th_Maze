package daniel.maze.game.graphics;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import daniel.maze.game.App;
import daniel.maze.game.inputEvents.PlayerMovement;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Panel extends JPanel {
    private JFrame frame;
    public static Render render;

    public Panel(){
        frame = new JFrame("A maze program");
        frame.setSize(1150, 600);
        frame.add(this);
        frame.setResizable(false);
        frame.addKeyListener(new PlayerMovement());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        //Make Background Blank
		super.paintComponent(g);
		Graphics2D graphics=(Graphics2D)g;
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0,0,frame.getWidth(), frame.getHeight());

        graphics.setColor(Color.GRAY);


        render = new Render(graphics);

    }

    public void _repaint(){ 
        repaint(); 
    }
}
