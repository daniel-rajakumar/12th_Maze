package daniel.maze.game.inputEvents;

import java.awt.event.*;
import java.io.IOException;

import daniel.maze.game.App;
import daniel.maze.game.graphics.Panel;
import daniel.maze.game.graphics.Render;
import daniel.maze.game.object.Maze;
import daniel.maze.game.object.Player;

public class PlayerMovement implements KeyListener  {

    int dir = 0;

    public void keyPressed(KeyEvent arg0) {
        System.out.println("hello world");

        try {
            Panel.render.getPlayer().setDirection(++dir%4);
            Panel.render.getPlayer().turn();

        } catch (IOException e) { e.printStackTrace(); }

        App.panel._repaint();
    }

    public void keyReleased(KeyEvent arg0) { }
    public void keyTyped(KeyEvent arg0) { }


    

}
