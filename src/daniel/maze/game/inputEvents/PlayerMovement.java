package daniel.maze.game.inputEvents;

import java.awt.event.*;
import java.io.IOException;

import daniel.maze.game.App;
import daniel.maze.game.graphics.Panel;
import daniel.maze.game.graphics.Render;
import daniel.maze.game.maze.Maze;
import daniel.maze.game.object.Player;

public class PlayerMovement implements KeyListener  {

    int dir = 0;

    public void keyPressed(KeyEvent arg0) {
        // System.out.println("hello world");


        if (arg0.getKeyCode() == 37){
            // System.out.println("distance: " + Panel.render.getPlayer().getDirection());
            int direction = Panel.render.getPlayer().getDirection();
            // if (direction < 0){
            //     System.out.println("1");
            //     Panel.render.getPlayer().setDirection(3);
            // } else {
            //     System.out.println("2");
            //     Panel.render.getPlayer().setDirection(direction - 1);
            // }


            // Panel.render.getPlayer().setDirection(direction + 1);
        }

        App.panel.repaint();
    }

    public void keyReleased(KeyEvent arg0) { }
    public void keyTyped(KeyEvent arg0) { }


    

}
