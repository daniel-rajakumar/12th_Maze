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

    int maze_height;
    int maze_width;
    int img_x;
    int img_y;
    int img_width;
    int img_height;

    Render() { }

    public void renderLevel() throws IOException {
        for (int y = 0; y < App.maze.getHeight(); y++){
            for (int x = 0; x < App.maze.getWidth(); x++){

                img_x = (x * App.maze.getPixelSize()) + App.maze.getPixelSize();
                img_y = (y * App.maze.getPixelSize()) + App.maze.getPixelSize(); 
                img_width = App.maze.getPixelSize();
                img_height = App.maze.getPixelSize();

                renderObjects(x, y);
            }
        }

    }

    private Player player;

    int count = 0;
    public void renderObjects(int x, int y) throws IOException {
        System.out.println(++count);
        // switch (App.maze.getMap()[y][x]) {
        //     case 'E': Maze.list_enemy.get(0); break;
        //     case 'F': Maze.list_finish.get(0); break;
        //     case 'D': Maze.list_enemy.get(0); break;
        //     case ' ': Maze.list_grass.get(0); break;
        //     default : Maze.list_water.get(0);
        // }



        switch (App.maze.getMap()[y][x]) {
            case 'E': new Enemy(img_x, img_y, img_width, img_height); break;
            case 'F': new Finish(img_x, img_y, img_width, img_height); break;
            case 'D': new Enemy(img_x, img_y, img_width, img_height); break;
            case ' ': new Grass(img_x, img_y, img_width, img_height); break;
            default : new Water(img_x, img_y, img_width, img_height); break;
        }


        // for (Grass j: Maze.list_grass) j.draw(); 
        // for (Enemy j: Maze.list_enemy) j.draw();
        // for (Water j: Maze.list_water) j.draw();
        // for (Finish j: Maze.list_finish) j.draw();
        // for (Player j: Maze.list_player) j.draw();
        // Maze.list_player.get(0).draw();




        // App.panel.repaint();
    }


    public Player getPlayer() {
        return player;
    }

}
