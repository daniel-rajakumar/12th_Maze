package daniel.maze.game.object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;

import daniel.maze.game.App;
import daniel.maze.game.graphics.Render;

// this class is the parent class of all the 2D-objects in this game from explorer to walls. 
public abstract class GameObject {
    protected int x, y;
    protected final int PIXEL_SIZE = 40;
    protected int img_x, img_y, img_width, img_height;
    protected BufferedImage backgroundImage, foregroundImage;
    protected int direction;

    GameObject(int x, int y, String backgroundFile){
        this(x, y, null, backgroundFile);
    }

    GameObject(int x, int y, String foregroundFile, String backgroundFile){
        this.x = x;
        this.y = y;
        try {
            backgroundImage = ImageIO.read(new File(App.PATH_IMG + backgroundFile));
            foregroundImage = ImageIO.read(new File(App.PATH_IMG + foregroundFile));
        } catch (IIOException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void draw();

    public int getX() { return x; }
    public int getY() { return y; }


    /**************************************** 
     ******** for movable objects ***********
     ****************************************/
	public void rotateImage(int deg) {
        Render.graphics.drawImage(rotate(backgroundImage, deg), img_x, img_y, img_width, img_height, null);
        Render.graphics.drawImage(rotate(foregroundImage, deg), img_x, img_y, img_width, img_height, null);
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



    /**
     * move player one box forward based on the player's location. 
     */
    public void moveForward(){
        if (!canMoveForward()) return;

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
    boolean canMoveForward(){
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




}




