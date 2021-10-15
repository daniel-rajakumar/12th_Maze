package daniel.maze.game.graphics;

import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import daniel.maze.game.App;
import daniel.maze.game.object.*;
import daniel.maze.game.inputEvents.PlayerMovement;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Panel extends JPanel  {
    private JFrame frame;
    public static Render render;

    public Panel(){
        frame = new JFrame("A maze program");
        frame.setSize(1150, 800);
        frame.add(this);
        frame.setResizable(false);
        frame.addKeyListener(new PlayerMovement());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        render = new Render();
    }

    public void paintComponent(Graphics g) {
        //Make Background Blank
		super.paintComponent(g);
        Render.graphics = (Graphics2D) g;
		Render.graphics.setColor(Color.BLACK);
		Render.graphics.fillRect(0,0,frame.getWidth(), frame.getHeight());

        try {
            if (App.maze.getIs3D()) render.render3DLevel();
            else                    render.render2DLevel();
        } catch (IOException e) { e.printStackTrace(); }
    }

    public void repaint(){
        super.repaint();
    }
}
