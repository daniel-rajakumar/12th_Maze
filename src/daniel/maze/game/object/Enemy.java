package daniel.maze.game.object;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import daniel.maze.game.App;
import daniel.maze.game.graphics.Render;

public class Enemy extends GameObject {
    int count = 0;

    public Enemy(int x, int y) {
        super(x, y, "dino.png", "grass.png");
        direction = 2;
    }


    int random(int from, int to){
        return (int)(Math.random() * (to - from + 1)) + from;
    }


    @Override
    public void drawBg() {
        img_x = (bx * PIXEL_SIZE) + PIXEL_SIZE;
        img_y = (by * PIXEL_SIZE) + PIXEL_SIZE;
        img_width = PIXEL_SIZE;
        img_height = PIXEL_SIZE;
        Render.graphics.drawImage(backgroundImage, img_x, img_y, img_width, img_height, null);
    }


    @Override
    public void drawFg() {
        if (++count%5 == 0){
            System.out.println("30: " + Render.count);

            moveForward();

            boolean left, right, front;

            GameObject obj_front = App.maze.whatIsIn(fx, fy);
            GameObject obj_left = App.maze.whatIsIn(fx, fy);
            GameObject obj_right = App.maze.whatIsIn(fx, fy);
            switch (getDirection()){
                case 0: 
                    obj_front = App.maze.whatIsIn(fx, fy - 1);
                    obj_left  = App.maze.whatIsIn(fx - 1, fy); 
                    obj_right = App.maze.whatIsIn(fx + 1, fy); 
                    break; 

                case 1: 
                    obj_front = App.maze.whatIsIn(fx + 1, fy);
                    obj_left  = App.maze.whatIsIn(fx, fy - 1); 
                    obj_right = App.maze.whatIsIn(fx, fy + 1); 
                    break; 

                case 2: 
                    obj_front = App.maze.whatIsIn(fx, fy + 1);
                    obj_left  = App.maze.whatIsIn(fx + 1, fy); 
                    obj_right = App.maze.whatIsIn(fx - 1, fy); 
                    break; 

                case 3: 
                    obj_front = App.maze.whatIsIn(fx - 1, fy);
                    obj_left  = App.maze.whatIsIn(fx, fy + 1); 
                    obj_right = App.maze.whatIsIn(fx, fy - 1); 
                    break; 
            }

            // left  = !(obj_left  instanceof Water || obj_left  == null);
            // right = !(obj_right instanceof Water || obj_right == null);
            left  = obj_left  instanceof Grass;
            right = obj_right instanceof Grass;
            front = !(obj_front instanceof Water || obj_front == null);

            
            System.out.println("73: moving! " + count);

            if (!left && !front && right) {
                turnRight();
            } 
            if (left && !front && !right){
                turnLeft();
            } 
            if (left && !front && right){
                switch(random(0, 1)){
                    case 0: turnLeft(); break;
                    case 1: turnRight(); break;
                }
            } 
            if (!left && !front && !right){
                turnBack();
            } 
            if (left && front && !right){
                if (random(0, 2) == 0){
                    turnLeft();
                }
            } 
            if (!left && front && right){
                if (random(0, 2) == 0){
                    turnRight();
                }
            }
        }





        // rotate image based on the player direction
        switch (getDirection()){
            case 0: rotateImage(90 * 1); break;
            case 1: rotateImage(90 * 2); break;
            case 2: rotateImage(90 * 3); break;
            case 3: rotateImage(90 * 0); break;
        }
        
    }

}
