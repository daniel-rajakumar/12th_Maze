package daniel.maze.game.object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import daniel.maze.game.App;
import daniel.maze.game.graphics.Render;

public class Objects {
    protected int x, y;
    protected int pixelSize;
    protected BufferedImage image;
    protected int img_x, img_y, img_width, img_height;
    final protected int PIXEL_SIZE = 40;

    Objects(int x, int y, String fileName){
        this.x = x;
        this.y = y;
        this.pixelSize = pixelSize;
        try {
            image = ImageIO.read(new File(App.PATH_IMG + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setupDraw(){
    }

    public void draw() throws IOException{
        img_x = (x * pixelSize) + pixelSize;
        img_y = (y * pixelSize) + pixelSize;
        img_width = pixelSize;
        img_height = pixelSize;

        if (this instanceof Player) {
            Player player = (Player) this;
            switch (player.getDirection()){
                case 0:  Render.graphics.drawImage(player.rotate(image, (90 * 0)), img_x, img_y, img_width, img_height, null); break;
                case 1:  Render.graphics.drawImage(player.rotate(image, (90 * 1)), img_x, img_y, img_width, img_height, null); break;
                case 2:  Render.graphics.drawImage(player.rotate(image, (90 * 2)), img_x, img_y, img_width, img_height, null); break;
                case 3:  Render.graphics.drawImage(player.rotate(image, (90 * 3)), img_x, img_y, img_width, img_height, null); break;
            }
            return;
        }
        
        Render.graphics.drawImage(image, img_x, img_y, img_width, img_height, null);
    }


    public int getX() { return x; }
    public int getY() { return y; }

}

