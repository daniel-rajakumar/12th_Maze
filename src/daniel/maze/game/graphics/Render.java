package daniel.maze.game.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import daniel.maze.game.App;
import daniel.maze.game.graphics.*;
import daniel.maze.game.maze.Maze;
import daniel.maze.game.object.Enemy;
import daniel.maze.game.object.Finish;
import daniel.maze.game.object.Grass;
import daniel.maze.game.object.Player;
import daniel.maze.game.object.Water;

public class Render {

    public static Graphics2D graphics;

    Render() { }

    public void render2DLevel() throws IOException {
        renderObjects();
    }

    public void renderObjects() throws IOException {
        for (Grass grass: Maze.list_grass)      grass.draw(); 
        for (Enemy enemy: Maze.list_enemy)      enemy.draw();
        for (Water water: Maze.list_water)      water.draw();
        for (Finish finish: Maze.list_finish)   finish.draw();
        for (Player player: Maze.list_player)   player.draw();
    }

    public void render3DLevel() throws IOException {
        // renderObjects();
    }

}
