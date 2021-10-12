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
            System.out.println("left");

            try {
                Maze.list_player.get(0).turn(0);
            } catch (IOException e) { e.printStackTrace(); }


            // System.out.println("distance: " + Panel.render.getPlayer().getDirection());
            // int direction = Panel.render.getPlayer().getDirection();
            // if (direction < 0){
            //     System.out.println("1");
            //     Panel.render.getPlayer().setDirection(3);
            // } else {
            //     System.out.println("2");
            //     Panel.render.getPlayer().setDirection(direction - 1);
            // }


            // Panel.render.getPlayer().setDirection(direction + 1);
        }

        if (arg0.getKeyCode() == 38){
            System.out.println("up");
            try {
                Maze.list_player.get(0).turn(1);
            } catch (IOException e) { e.printStackTrace(); }
        }


        App.panel.repaint();
        System.out.println("dir: " + Maze.list_player.get(0).getDirection());

    }

    public void keyReleased(KeyEvent arg0) { }
    public void keyTyped(KeyEvent arg0) { }


    

}
