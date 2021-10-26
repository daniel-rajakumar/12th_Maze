package daniel.maze.game.object;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.IIOException;
import javax.imageio.ImageIO;

import daniel.maze.game.App;

// this class is the parent class of all the 2D-objects in this game from explorer to walls. 
public abstract class GameObject {
    protected int x, y;
    protected final int PIXEL_SIZE = 40;
    protected int img_x, img_y, img_width, img_height;
    protected BufferedImage backgroundImage, foregroundImage;

    GameObject(int x, int y, String backgroundFile){
        this(x, y, backgroundFile, null);
    }

    GameObject(int x, int y, String backgroundFile, String foregroundFile){
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

}




