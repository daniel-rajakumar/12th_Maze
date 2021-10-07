package daniel.maze.game.graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import daniel.maze.game.App;
import daniel.maze.game.graphics.*;
import daniel.maze.game.object.Enemy;
import daniel.maze.game.object.Finish;
import daniel.maze.game.object.Path;
import daniel.maze.game.object.Player;
import daniel.maze.game.object.Water;

public class Render {
    public static Graphics graphics;

    int img_x;
    int img_y;
    int img_width = App.maze.getPixelSize();
    int img_height = App.maze.getPixelSize();

    Render(Graphics graphics) {
        this.graphics = graphics;

        try {
            renderLevel();
        } catch (IOException e) { e.printStackTrace(); }
    }

    public void renderLevel() throws IOException {
        for (int y = 0; y < App.maze.getHeight(); y++){
            for (int x = 0; x < App.maze.getWidth(); x++){

                img_x = (x * App.maze.getPixelSize()) + App.maze.getPixelSize();
                img_y = (y * App.maze.getPixelSize()) + App.maze.getPixelSize(); 
                renderObjects(x, y);

            }
        }

    }

    public void renderObjects(int x, int y) throws IOException {
        switch (App.maze.getMap()[y][x]) {
            case 'E': new Player(img_x, img_y, img_width, img_height); break;
            case 'F': new Finish(img_x, img_y, img_width, img_height); break;
            case 'D': new Enemy(img_x, img_y, img_width, img_height); break;
            case ' ': new Path(img_x, img_y, img_width, img_height); break;
            default : new Water(img_x, img_y, img_width, img_height);
        }
    }


}
