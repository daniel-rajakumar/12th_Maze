package daniel.maze.game.graphics;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

import daniel.maze.game.App;
import daniel.maze.game.inputEvents.PlayerMovement;

/**
 *  The core class of the game graphics using swing.
 */
public class GamePanel extends JPanel  {
    private JFrame frame;
    public static Render render;

    public GamePanel(){
        frame = new JFrame("A maze program");
        frame.setSize(1150, 800);
        frame.add(this);
        frame.setResizable(false);
        frame.addKeyListener(new PlayerMovement()); //all the keyboard movements for the player
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        try {
            startRepaint(10); //start a new threat with 10 milliSeconds call
            render = new Render(new Render_2d(), new Render_3d());

        } catch (Exception e) { e.printStackTrace(); }
    }

    /**
     * code to run for each game frame
     */
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
        Render.graphics = (Graphics2D) g;
		Render.graphics.setColor(Color.BLACK);
		Render.graphics.fillRect(0, 0, frame.getWidth(), frame.getHeight());

        try { // toggle between 2d and 3d when user press spacebar
            if (App.maze.getIs3D()) render.render3DLevel();
            else                    render.render2DLevel();
            
        } catch (NullPointerException e) { 
            System.out.println("Nothing to render on the screen");

        } catch (IOException e) { 
            e.printStackTrace(); 
        }
    }


    /**
     *  Refresh the game for every given milliseconds
     */
    public void startRepaint(int milliSeconds){

        //create, schedule, and start the refresher
        new Timer().schedule(new TimerTask() {
            public void run(){
                repaint();
            }
        }, 0, milliSeconds);
    }

}
