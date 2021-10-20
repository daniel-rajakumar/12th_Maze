package daniel.maze.game.object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;

import daniel.maze.game.App;
import daniel.maze.game.graphics.Render;

public abstract class Objects {
    protected int x, y;
    protected final int PIXEL_SIZE = 40;
    protected BufferedImage image1, image2;
    protected int img_x, img_y, img_width, img_height;

    Objects(int x, int y, String fileName1){
        this(x, y, fileName1, null);
    }

    Objects(int x, int y, String fileName1, String fileName2){
        this.x = x;
        this.y = y;
        try {
            image1 = ImageIO.read(new File(App.PATH_IMG + fileName1));
            image2 = ImageIO.read(new File(App.PATH_IMG + fileName2));
        } catch (IIOException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void draw();

    public int getX() { return x; }
    public int getY() { return y; }

}

