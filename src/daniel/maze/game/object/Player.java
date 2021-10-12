package daniel.maze.game.object;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import daniel.maze.game.App;
import daniel.maze.game.graphics.Render;
import daniel.maze.game.maze.Maze;

public class Player {

    private BufferedImage image;
    private int x, y;
    private int steps, totalSteps;
    private boolean didWin, didLose;
    private int img_x, img_y, img_width, img_height;
    private int direction;


    public Player(int img_x, int img_y, int img_width, int img_height) throws IOException {
        this.img_x = img_x;
        this.img_y = img_y;
        this.img_width = img_width;
        this.img_height = img_height;

        // direction = 0;
        didWin = false;
        didLose = false;
        steps = 0;
        totalSteps = 0;
        direction = 0;

        draw();
    }

    public void draw() throws IOException {
        BufferedImage image = ImageIO.read(new File(App.PATH_IMG + "blob.png"));

        switch (direction){
            case 0:  Render.graphics.drawImage(rotate(image, (90 * 0)), img_x, img_y, img_width, img_height, null); break;
            case 1:  Render.graphics.drawImage(rotate(image, (90 * 1)), img_x, img_y, img_width, img_height, null); break;
            case 2:  Render.graphics.drawImage(rotate(image, (90 * 2)), img_x, img_y, img_width, img_height, null); break;
            case 3:  Render.graphics.drawImage(rotate(image, (90 * 3)), img_x, img_y, img_width, img_height, null); break;
        }
    }

    public static BufferedImage rotate(BufferedImage img, int deg) {
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
