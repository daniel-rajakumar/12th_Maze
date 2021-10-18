<<<<<<< HEAD
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

    public Render() { }

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
        int shrink = 50;
        int poly_x_1, poly_x_2, poly_x_3, poly_x_4;
        int poly_y_1, poly_y_2, poly_y_3, poly_y_4;

        for (int i = 0; i < 5; i++) {
            poly_x_1 = 100 + shrink * i; poly_y_1 = 100 + shrink * i;
            poly_x_2 = 150 + shrink * i; poly_y_2 = 150 + shrink * i;
            poly_x_3 = 150 + shrink * i; poly_y_3 = 650 - shrink * i;
            poly_x_4 = 100 + shrink * i; poly_y_4 = 700 - shrink * i;

            int[] xLocs =   {poly_x_1, poly_x_2, poly_x_3, poly_x_4};
            int[] yLocs =   {poly_y_1, poly_y_2, poly_y_3, poly_y_4};
            int[] xLocs_2 = {poly_y_4, poly_y_3, poly_x_3, poly_x_4};
            int[] yLocs_2 = {poly_y_4, poly_y_3, poly_y_3, poly_y_4};

            Polygon   leftWall   = new Polygon(xLocs, yLocs, xLocs.length);
            Polygon   topWall    = new Polygon(yLocs, xLocs, xLocs.length);
            Polygon   bottomWall = new Polygon(xLocs_2, yLocs_2, xLocs_2.length);
            Polygon   rightWall  = new Polygon(yLocs_2, xLocs_2, xLocs_2.length);
            Rectangle door_left  = new Rectangle(poly_x_1, poly_x_2, shrink, (poly_y_3 - poly_x_3));
            Rectangle door_right = new Rectangle(poly_y_3, poly_x_2, shrink, (poly_y_3 - poly_x_3));

            Render.graphics.setColor(Color.WHITE);
            Render.graphics.fill(leftWall);
            Render.graphics.fill(topWall);
            Render.graphics.fill(bottomWall);
            Render.graphics.fill(rightWall);
            Render.graphics.setColor(Color.LIGHT_GRAY);

            System.out.printf("(%s, %s)\n", Maze.list_player.get(0).getX(), Maze.list_player.get(0).getY());
            // Render.graphics.fill(door_left);
            // Render.graphics.fill(door_right);


            Render.graphics.setColor(Color.BLACK);
            Render.graphics.draw(leftWall);
            Render.graphics.draw(topWall);
            Render.graphics.draw(bottomWall);
            Render.graphics.draw(rightWall);
            // Render.graphics.draw(door_left);
            // Render.graphics.draw(door_right);
        }

    }

}
=======
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
        int shrink = 50;
        int poly_x_1, poly_x_2, poly_x_3, poly_x_4;
        int poly_y_1, poly_y_2, poly_y_3, poly_y_4;

        for (int i = 0; i < 5; i++) {
            poly_x_1 = 100 + shrink * i; poly_y_1 = 100 + shrink * i;
            poly_x_2 = 150 + shrink * i; poly_y_2 = 150 + shrink * i;
            poly_x_3 = 150 + shrink * i; poly_y_3 = 650 - shrink * i;
            poly_x_4 = 100 + shrink * i; poly_y_4 = 700 - shrink * i;

            int[] xLocs =   {poly_x_1, poly_x_2, poly_x_3, poly_x_4};
            int[] yLocs =   {poly_y_1, poly_y_2, poly_y_3, poly_y_4};
            int[] xLocs_2 = {poly_y_4, poly_y_3, poly_x_3, poly_x_4};
            int[] yLocs_2 = {poly_y_4, poly_y_3, poly_y_3, poly_y_4};

            Polygon   leftWall   = new Polygon(xLocs, yLocs, xLocs.length);
            Polygon   topWall    = new Polygon(yLocs, xLocs, xLocs.length);
            Polygon   bottomWall = new Polygon(xLocs_2, yLocs_2, xLocs_2.length);
            Polygon   rightWall  = new Polygon(yLocs_2, xLocs_2, xLocs_2.length);
            Rectangle door_left  = new Rectangle(poly_x_1, poly_x_2, shrink, (poly_y_3 - poly_x_3));
            Rectangle door_right = new Rectangle(poly_y_3, poly_x_2, shrink, (poly_y_3 - poly_x_3));

            Render.graphics.setColor(Color.WHITE);
            Render.graphics.fill(leftWall);
            Render.graphics.fill(topWall);
            Render.graphics.fill(bottomWall);
            Render.graphics.fill(rightWall);
            Render.graphics.setColor(Color.LIGHT_GRAY);
            Render.graphics.fill(door_left);
            Render.graphics.fill(door_right);


            Render.graphics.setColor(Color.BLACK);
            Render.graphics.draw(door_left);
            Render.graphics.draw(door_right);
            Render.graphics.draw(leftWall);
            Render.graphics.draw(topWall);
            Render.graphics.draw(bottomWall);
            Render.graphics.draw(rightWall);
        }

    }

}
>>>>>>> deb99ca87f5fbe891ca4edc87dc09c9f315d9e40
