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


public class Render_3d {


    private Polygon leftWall, topWall, bottomWall, rightWall; 
    private Rectangle door_left, door_right;


    Render_3d(){}

    public void render(){
        int shrink = 50;
        int poly_x_1, poly_x_2, poly_x_3, poly_x_4;
        int poly_y_1, poly_y_2, poly_y_3, poly_y_4;


        Player player = Maze.list_player.get(0);

        for (int i = 0; i < 5; i++) {
            poly_x_1 = 100 + shrink * i; poly_y_1 = 100 + shrink * i;
            poly_x_2 = 150 + shrink * i; poly_y_2 = 150 + shrink * i;
            poly_x_3 = 150 + shrink * i; poly_y_3 = 650 - shrink * i;
            poly_x_4 = 100 + shrink * i; poly_y_4 = 700 - shrink * i;

            int[] xLocs =   {poly_x_1, poly_x_2, poly_x_3, poly_x_4};
            int[] yLocs =   {poly_y_1, poly_y_2, poly_y_3, poly_y_4};
            int[] xLocs_2 = {poly_y_4, poly_y_3, poly_x_3, poly_x_4};
            int[] yLocs_2 = {poly_y_4, poly_y_3, poly_y_3, poly_y_4};

            leftWall   = new Polygon(xLocs, yLocs, xLocs.length);
            topWall    = new Polygon(yLocs, xLocs, xLocs.length);
            bottomWall = new Polygon(xLocs_2, yLocs_2, xLocs_2.length);
            rightWall  = new Polygon(yLocs_2, xLocs_2, xLocs_2.length);
            door_left  = new Rectangle(poly_x_1, poly_x_2, shrink, (poly_y_3 - poly_x_3));
            door_right = new Rectangle(poly_y_3, poly_x_2, shrink, (poly_y_3 - poly_x_3));


            // System.out.printf("player: [x: %s][y: %s]\n", player.getX(), player.getY());



            boolean left = true, right = true;
            for (Water water: Maze.list_water){
                int x1 = player.getX(), y1 = player.getY();
                int x2 = water.getX(), y2 = water.getY();

                if (x1 - 1 == x2 && y1 - i == y2) {
                    System.out.printf("water: [x: %s][y: %s]\n", water.getX(), water.getY());
                    left = false;
                } 
                if (x1 + 1 == x2 && y1 - i == y2) {
                    System.out.printf("water: [x: %s][y: %s]\n", water.getX(), water.getY());
                    right = false;
                }
            }

            renderObjects(left, right);
            renderObjects_outline(left, right);



            // try { Thread.sleep(5000); } catch (Exception e) { }
        }

    }


    void renderObjects(boolean leftDoor, boolean rightDoor){
        Render.graphics.setColor(Color.WHITE);
        Render.graphics.fill(leftWall);
        Render.graphics.fill(topWall);
        Render.graphics.fill(bottomWall);
        Render.graphics.fill(rightWall);
        Render.graphics.setColor(Color.LIGHT_GRAY);

        if (leftDoor)  Render.graphics.fill(door_left);
        if (rightDoor) Render.graphics.fill(door_right);
    }




    void renderObjects_outline(boolean leftDoor, boolean rightDoor){
        Render.graphics.setColor(Color.BLACK);
        Render.graphics.draw(rightWall);
        Render.graphics.draw(leftWall);
        Render.graphics.draw(bottomWall);
        Render.graphics.draw(topWall);

        if (leftDoor)  Render.graphics.draw(door_left);
        if (rightDoor) Render.graphics.draw(door_right);
    }
    
}
