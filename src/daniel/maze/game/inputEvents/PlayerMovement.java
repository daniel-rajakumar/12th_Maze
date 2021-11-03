package daniel.maze.game.inputEvents;

import java.awt.event.*;
import java.io.IOException;

import daniel.maze.game.App;
import daniel.maze.game.graphics.GamePanel;
import daniel.maze.game.graphics.Render;
import daniel.maze.game.maze.Maze;
import daniel.maze.game.object.Player;

public class PlayerMovement implements KeyListener  {
    int count = 0;

    public void keyPressed(KeyEvent arg0) {
        switch (arg0.getKeyCode()){
            case KeyEvent.VK_LEFT: Maze.list_player.get(0).turnLeft(); break;
            case KeyEvent.VK_UP: Maze.list_player.get(0).moveForward(); break;
            case KeyEvent.VK_RIGHT: Maze.list_player.get(0).turnRight(); break;
            case KeyEvent.VK_SPACE: App.maze.setIs3D(!App.maze.getIs3D());
        }
    }

    public void keyReleased(KeyEvent arg0) { 
        // switch (arg0.getKeyCode()){
        //     case KeyEvent.VK_LEFT: Maze.list_player.get(0).turnLeft(); break;
        //     case KeyEvent.VK_UP: Maze.list_player.get(0).moveForward(); break;
        //     case KeyEvent.VK_RIGHT: Maze.list_player.get(0).turnRight(); break;
        //     case KeyEvent.VK_SPACE: App.maze.setIs3D(!App.maze.getIs3D());
        // }
    }
    public void keyTyped(KeyEvent arg0) { }

    

}
