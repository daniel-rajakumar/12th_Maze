package daniel.maze.game.object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;

import daniel.maze.game.App;
import daniel.maze.game.graphics.Render;
import daniel.maze.game.maze.Maze;

// this class is the parent class of all the 2D-objects in this game from explorer to walls. 
public abstract class GameObject {
    protected int fx, fy, bx, by;
    protected final int PIXEL_SIZE = 40;
    protected int img_x, img_y, img_width, img_height;
    protected BufferedImage backgroundImage, foregroundImage;
    protected int direction;

    GameObject(int x, int y, String backgroundFile){
        this(x, y, null, backgroundFile);
    }

    GameObject(int x, int y, String foregroundFile, String backgroundFile){
        this.fx = x;
        this.fy = y;
        this.bx = x;
        this.by = y;
        try {
            this.backgroundImage = ImageIO.read(new File(App.PATH_IMG + backgroundFile));
            this.foregroundImage = ImageIO.read(new File(App.PATH_IMG + foregroundFile));
        } catch (IIOException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void drawBg();
    public abstract void drawFg();

    public int getForegroundX() { return fx; }
    public int getForegroundY() { return fy; }


    /**************************************** 
     ******** for movable objects ***********
     ****************************************/
	public void drawForeground(int deg) {
        img_x = (fx * PIXEL_SIZE) + PIXEL_SIZE;
        img_y = (fy * PIXEL_SIZE) + PIXEL_SIZE;
        img_width = PIXEL_SIZE;
        img_height = PIXEL_SIZE;
        Render.graphics.drawImage(rotate(foregroundImage, deg), img_x, img_y, img_width, img_height, null);
	}

	public void drawBackground() {
        img_x = (bx * PIXEL_SIZE) + PIXEL_SIZE;
        img_y = (by * PIXEL_SIZE) + PIXEL_SIZE;
        img_width = PIXEL_SIZE;
        img_height = PIXEL_SIZE;
        Render.graphics.drawImage(backgroundImage, img_x, img_y, img_width, img_height, null);
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


    public int getDirection() { return direction; }
    public void setDirection(int direction) { this.direction = direction; }

    public void turnLeft(){
        if (--direction < 0) direction = 3;
    }

    public void turnRight(){
        if (++direction > 3) direction = 0;
    }

    public void turnBack(){
        direction++;
        if (++direction > 3) direction = 0;
    }

    /**
     * move player one box forward based on the player's location. 
     */
    public void moveForward(){
        if (!canMoveForward()) return;

        switch (direction){
            case 0: fy--; break;
            case 1: fx++; break;
            case 2: fy++; break;
            case 3: fx--; break;
        }

    }

    /**
     *  does the object in front of player is reachable? 
     */
    boolean canMoveForward(){
        GameObject obj;

        switch (direction) {
            case 0 : obj = App.maze.whatIsIn(fx, fy - 1); break;
            case 1 : obj = App.maze.whatIsIn(fx + 1, fy); break;
            case 2 : obj = App.maze.whatIsIn(fx, fy + 1); break;
            case 3 : obj = App.maze.whatIsIn(fx - 1, fy); break;
            default: obj = null;
        }
        

        return !(obj instanceof Water || obj == null);
    }

}




