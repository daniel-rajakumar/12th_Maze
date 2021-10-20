package daniel.maze.game.object;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import daniel.maze.game.App;
import daniel.maze.game.graphics.Render;
import daniel.maze.game.maze.Maze;

public class Player extends GameObject {

    private int steps, totalSteps;
    private boolean didWin, didLose;
    private int img_x, img_y, img_width, img_height;
    private int direction;


    public Player(int x, int y) throws IOException {
        super(x, y, "blob.png");

        // direction = 0;
        didWin = false;
        didLose = false;
        steps = 0;
        totalSteps = 0;
        direction = 0;

    }

    @Override
    public void draw() {
        img_x = (x * PIXEL_SIZE) + PIXEL_SIZE;
        img_y = (y * PIXEL_SIZE) + PIXEL_SIZE;
        img_width = PIXEL_SIZE;
        img_height = PIXEL_SIZE;

        switch (this.getDirection()){
            case 0:  Render.graphics.drawImage(this.rotate(backgroundImage, (90 * 0)), img_x, img_y, img_width, img_height, null); break;
            case 1:  Render.graphics.drawImage(this.rotate(backgroundImage, (90 * 1)), img_x, img_y, img_width, img_height, null); break;
            case 2:  Render.graphics.drawImage(this.rotate(backgroundImage, (90 * 2)), img_x, img_y, img_width, img_height, null); break;
            case 3:  Render.graphics.drawImage(this.rotate(backgroundImage, (90 * 3)), img_x, img_y, img_width, img_height, null); break;
        }
    }

    public BufferedImage rotate(BufferedImage img, int deg) {
        int imgWidth =  img.getWidth();
        int imgHeight = img.getHeight();
        int imgType =   img.getType();

        BufferedImage rotatedImage = new BufferedImage(imgWidth, imgHeight, imgType);

        Graphics2D graphics2D = rotatedImage.createGraphics();

        graphics2D.rotate(Math.toRadians(deg), imgWidth / 2, imgHeight / 2);
        graphics2D.drawImage(img, null, 0, 0);

        
        return rotatedImage;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void moveForward(){
        // switch (direction){
        //     case 0: System.out.println(App.maze.getMap()[y -  1][x]);
        //     case 1: System.out.println(App.maze.getMap()[y][x + 1]);
        //     case 2: System.out.println(App.maze.getMap()[y + 1][x]);
        //     case 3: System.out.println(App.maze.getMap()[y][x - 1]);
        // }


        switch (direction){
            case 0: y--; break;
            case 1: x++; break;
            case 2: y++; break;
            case 3: x--; break;
        }
    }


    public void turnLeft(){
        if (--direction < 0) direction = 3;
    }

    public void turnRight(){
        if (++direction > 3) direction = 0;
    }

    public int getDirection() {
        return direction;
    }

}
