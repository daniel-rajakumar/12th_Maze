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

        // Render.graphics.setColor(Color.GRAY);

        try {
            if (App.maze.getIs3D()){
                int shrink = 50;
                System.out.println("Im in 3D");
                render.render3DLevel();


                for (int i = 0; i < 5; i++) {
                    int[] xLocs = {100 + shrink*i, 150 + shrink*i, 150 + shrink*i, 100 + shrink*i};
                    int[] yLocs = {100 + shrink*i, 150 + shrink*i, 650 - shrink*i, 700 - shrink*i};

                    Rectangle rect = new Rectangle(100 + shrink*i, 150 + shrink*i, 50, (650 - 150) - shrink*(i*2));


                    Polygon leftWall = new Polygon(xLocs, yLocs, xLocs.length);
                    Render.graphics.setColor(Color.WHITE);
                    Render.graphics.fill(leftWall);
                    Render.graphics.setColor(Color.RED);
                    Render.graphics.setColor(Color.BLACK);
                    Render.graphics.draw(leftWall);

                    Render.graphics.setColor(Color.RED);
                    Render.graphics.fill(rect);
                    Render.graphics.draw(rect);
                }


                for (int i = 0; i < 5; i++) {
                    int[] yLocs = {100 + shrink*i, 150 + shrink*i, 150 + shrink*i, 100 + shrink*i};
                    int[] xLocs = {100 + shrink*i, 150 + shrink*i, 650 - shrink*i, 700 - shrink*i};

                    Polygon ceil = new Polygon(xLocs, yLocs, xLocs.length);
                    Render.graphics.setColor(Color.WHITE);
                    // Render.graphics.fill(ceil);
                    Render.graphics.setColor(Color.BLACK);
                    // Render.graphics.draw(ceil);
                }

                Rectangle rectangle = new Rectangle();





            } else {
                System.out.println("Im in 2D");
                render.render2DLevel();
            }
        } catch (IOException e) { e.printStackTrace(); }


    }

    public void repaint(){
        super.repaint();
    }
}
