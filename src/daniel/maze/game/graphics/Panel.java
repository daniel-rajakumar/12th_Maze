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
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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

        try {
            try {
                Thread.sleep(100);
            } catch (Exception e) { }
            startRepaint(10);
            render = new Render(new Render_2d(), new Render_3d());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        //Make Background Blank
		super.paintComponent(g);
        Render.graphics = (Graphics2D) g;
		Render.graphics.setColor(Color.BLACK);
		Render.graphics.fillRect(0, 0, frame.getWidth(), frame.getHeight());

        try {
            if (App.maze.getIs3D()) render.render3DLevel();
            else                    render.render2DLevel();
        } catch (NullPointerException e) { 
            System.out.println("Nothing to render on the screen");
        } catch (IOException e) { 
            System.out.println("hello!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            // e.printStackTrace(); 
        }
    }

    public void startRepaint(int milliSeconds){
        TimerTask animate = new TimerTask() {
            public void run(){
                repaint();
            }
        };

        new Timer().schedule(animate, 0, milliSeconds);
    }
}
