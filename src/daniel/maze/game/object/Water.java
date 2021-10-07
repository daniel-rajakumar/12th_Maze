package daniel.maze.game.object;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import daniel.maze.game.App;
import daniel.maze.game.graphics.Render;

public class Water {

    private BufferedImage image;
    private int x, y;
    private int direction;
    private int steps, totalSteps;
    private boolean didWin, didLose;
    private int img_x, img_y, img_width, img_height;


    public Water(int img_x, int img_y, int img_width, int img_height) throws IOException{
        this.img_x = img_x;
        this.img_y = img_y;
        this.img_width = img_width;
        this.img_height = img_height;
        test();
    }

    public void test() throws IOException {
        BufferedImage image = ImageIO.read(new File(App.PATH_IMG + "water.png"));
        Render.graphics.drawImage(image, img_x, img_y, img_width, img_height, null);
    }

}
