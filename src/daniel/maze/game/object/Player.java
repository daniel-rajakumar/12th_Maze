package daniel.maze.game.object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import daniel.maze.game.App;
import daniel.maze.game.graphics.Render;
import daniel.maze.game.maze.Maze;

/**
 * This class is used to create player (or explorer) in the game.
 */
public class Player extends GameObject {

    private int steps, totalSteps;
    private boolean didWin, didLose;
    private int direction;


    public Player(int x, int y) throws IOException {
        super(x, y, "blob.png", "grass.png");

        // direction = 0;
        didWin = false;
        didLose = false;
        steps = 0;
        totalSteps = 0;
        direction = 0;
    }

    @Override
    public void draw() {
        switch (getDirection()){
            case 0: rotateImage(90 * 0); break;
            case 1: rotateImage(90 * 1); break;
            case 2: rotateImage(90 * 2); break;
            case 3: rotateImage(90 * 3); break;
        }
    }

    

}
