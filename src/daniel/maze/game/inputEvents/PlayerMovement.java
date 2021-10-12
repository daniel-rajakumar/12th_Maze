package daniel.maze.game.inputEvents;

import java.awt.event.*;
import java.io.IOException;

import daniel.maze.game.App;
import daniel.maze.game.graphics.Panel;
import daniel.maze.game.graphics.Render;
import daniel.maze.game.maze.Maze;
import daniel.maze.game.object.Player;

public class PlayerMovement implements KeyListener  {

    public void keyPressed(KeyEvent arg0) {
        // System.out.println("hello world");

        switch (arg0.getKeyCode()){
            case 37: Maze.list_player.get(0).turnLeft(); break;
            case 38: Maze.list_player.get(0).moveForward(); break;
            case 39: Maze.list_player.get(0).turnRight(); break;
            case 32: App.maze.setIs3D(!App.maze.getIs3D());
        }


        App.panel.repaint();
    }

    public void keyReleased(KeyEvent arg0) { }
    public void keyTyped(KeyEvent arg0) { }


    

}
