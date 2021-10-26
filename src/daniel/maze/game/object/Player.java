package daniel.maze.game.object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import daniel.maze.game.App;
import daniel.maze.game.graphics.Render;
import daniel.maze.game.maze.Maze;

/**
 * This class is used to create player (or explorer) in the game.
 */
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

        // rotate image based on the player direction
        switch (getDirection()){
            case 0: rotateImage(90 * 0); break;
            case 1: rotateImage(90 * 1); break;
            case 2: rotateImage(90 * 2); break;
            case 3: rotateImage(90 * 3); break;
        }
    }

    void rotateImage(int deg){
        Render.graphics.drawImage(rotate(backgroundImage, deg), img_x, img_y, img_width, img_height, null);
    }

    /**
     * return rotated image with given degree 
     */
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


    /**
     * move player one box forward based on the player's location. 
     */
    public void moveForward(){
        if (!canPlayerMoveForward()) return;

        switch (direction){
            case 0: y--; break;
            case 1: x++; break;
            case 2: y++; break;
            case 3: x--; break;
        }
    }

    /**
     *  does the object in front of player is reachable? 
     */
    boolean canPlayerMoveForward(){
        GameObject obj;

        switch (direction) {
            case 0 : obj = App.maze.whatIsIn(x, y - 1); break;
            case 1 : obj = App.maze.whatIsIn(x + 1, y); break;
            case 2 : obj = App.maze.whatIsIn(x, y + 1); break;
            case 3 : obj = App.maze.whatIsIn(x - 1, y); break;
            default: obj = null;
        }

        return !(obj instanceof Water || obj == null);
    }


    public void turnLeft(){
        if (--direction < 0) direction = 3;
    }

    public void turnRight(){
        if (++direction > 3) direction = 0;
    }

    public int getDirection() { return direction; }
    public void setDirection(int direction) { this.direction = direction; }

}
