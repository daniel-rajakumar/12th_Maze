package daniel.maze.game.object;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import daniel.maze.game.App;
import daniel.maze.game.graphics.Render;

public class Water extends Objects {

    public Water(int x, int y) throws IOException {
        super(x, y, "water.png");
    }

}
