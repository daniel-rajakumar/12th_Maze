package daniel.maze.game.object;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import daniel.maze.game.App;
import daniel.maze.game.graphics.Render;

public class Enemy extends GameObject {

    public Enemy(int x, int y) {
        super(x, y, "dino.png", "grass.png");
        direction = 1;
    }

    @Override
    public void draw()  {
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

}
