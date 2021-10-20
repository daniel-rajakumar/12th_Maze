package daniel.maze.game.object;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import daniel.maze.game.App;
import daniel.maze.game.graphics.Render;

public class Water {

    private BufferedImage image;
    private int img_x, img_y, img_width, img_height;
    int x, y;
    int pixelSize;

    public Water(int x, int y, int pixelSize) throws IOException {
        this.x = x;
        this.y = y;
        this.pixelSize = pixelSize;

        draw();
    }

    public void draw() throws IOException {
        image = ImageIO.read(new File(App.PATH_IMG + "water.png"));
        img_x = (x * pixelSize) + pixelSize;
        img_y = (y * pixelSize) + pixelSize;
        img_width = pixelSize;
        img_height = pixelSize;

        Render.graphics.drawImage(image, img_x, img_y, img_width, img_height, null);
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
