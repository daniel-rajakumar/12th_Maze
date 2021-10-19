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
    Render_2d render_2d;
    Render_3d render_3d;

    Render(Render_2d render_2d, Render_3d render_3d) { 
        this.render_2d = render_2d;
        this.render_3d = render_3d;
    }

    public void render2DLevel() throws IOException {
        render_2d.render();
    }

    public void render3DLevel() throws IOException {
        render_3d.render();
    }

}
