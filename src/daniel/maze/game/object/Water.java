package daniel.maze.game.object;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import daniel.maze.game.App;
import daniel.maze.game.graphics.Render;

public class Water extends GameObject {

    public Water(int x, int y) throws IOException {
        super(x, y, "water.png");
    }

    @Override
    public void drawBg() {
        img_x = (fx * PIXEL_SIZE);
        img_y = (fy * PIXEL_SIZE);
        img_width = PIXEL_SIZE;
        img_height = PIXEL_SIZE;

        Render.graphics.drawImage(backgroundImage, img_x, img_y, img_width, img_height, null);
    }

    @Override
    public void drawFg() {
        // TODO Auto-generated method stub
        
    }


}
