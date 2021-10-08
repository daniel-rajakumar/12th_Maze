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

public class Panel extends JPanel implements KeyListener {
    private JFrame frame;
    public static Render render;

    public Panel(){
        frame = new JFrame("A maze program");
        frame.setSize(1150, 600);
        frame.add(this);
        frame.setResizable(false);
        // frame.addKeyListener(new PlayerMovement());
        frame.addKeyListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        //Make Background Blank
		super.paintComponent(g);
        Render.graphics =  (Graphics2D) g;
		Render.graphics.setColor(Color.BLACK);
		Render.graphics.fillRect(0,0,frame.getWidth(), frame.getHeight());

        Render.graphics.setColor(Color.GRAY);


        render = new Render();

    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        
        if (arg0.getKeyCode() == 37){
            if (--Player.direction < 0){
                Player.direction = 0;
            }
            System.out.println("hello");
        }



        repaint();
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }
}
