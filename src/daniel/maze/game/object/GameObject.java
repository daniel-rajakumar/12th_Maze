package daniel.maze.game.object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;

import daniel.maze.game.App;
import daniel.maze.game.graphics.Render;
import daniel.maze.game.maze.Maze;

// this class is the parent class of all the 2D-objects in this game from explorer to walls. 
public abstract class GameObject {
    protected int fx, fy, bx, by;
    protected int fx2, fy2, bx2, by2;
    protected int x, y;
    public static final int PIXEL_SIZE = 60;
    protected int img_x, img_y, img_width, img_height;
    protected BufferedImage backgroundImage, foregroundImage;
    protected int direction;
    public static int shift_x, shift_y;
    private int stepCount;

    GameObject(int x, int y, String backgroundFile){
        this(x, y, null, backgroundFile);
    }

    GameObject(int x, int y, String foregroundFile, String backgroundFile){
        // shift_x = 0;
        // shift_y = 0;

        this.x = x;
        this.y = y;
        this.fx = x + shift_x;
        this.fy = y + shift_y;
        this.bx = x + shift_x;
        this.by = y + shift_y;
        this.fx2 = x;
        this.fy2 = y;
        this.bx2 = x;
        this.by2 = y;

        stepCount = 0;

        try {
            this.backgroundImage = ImageIO.read(new File(App.PATH_IMG + backgroundFile));
            this.foregroundImage = ImageIO.read(new File(App.PATH_IMG + foregroundFile));
        } catch (IIOException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    /**************************************** 
     ******** for movable objects ***********
     ****************************************/
	public void drawForeground(int deg) {
        img_x = (fx * PIXEL_SIZE);
        img_y = (fy * PIXEL_SIZE);
        img_width = PIXEL_SIZE;
        img_height = PIXEL_SIZE;
        Render.graphics.drawImage(rotate(foregroundImage, deg), img_x, img_y, img_width, img_height, null);
	}

	public void drawBackground() {
        img_x = (bx * PIXEL_SIZE);
        img_y = (by * PIXEL_SIZE);
        img_width = PIXEL_SIZE;
        img_height = PIXEL_SIZE;
        Render.graphics.drawImage(backgroundImage, img_x, img_y, img_width, img_height, null);
	}


    public static BufferedImage rotate(BufferedImage img, int deg) {
        int imgWidth =  img.getWidth();
        int imgHeight = img.getHeight();
        int imgType =   img.getType();

        BufferedImage rotatedImage = new BufferedImage(imgWidth, imgHeight, imgType);

        Graphics2D graphics2D = rotatedImage.createGraphics();

        graphics2D.rotate(Math.toRadians(deg), imgWidth / 2, imgHeight / 2);
        graphics2D.drawImage(img, null, 0, 0);

        return rotatedImage;
    }


    public int getDirection() { return direction; }
    public void setDirection(int direction) { this.direction = direction; }

    public void turnLeft(){
        if (--direction < 0) direction = 3;
    }

    public void turnRight(){
        if (++direction > 3) direction = 0;
    }

    public void turnBack(){
        direction++;
        if (++direction > 3) direction = 0;
    }

    /**
     * move player one box forward based on the player's location. 
     */
    public void moveForward(){
        if (!canMoveForward()) return;


        stepCount++;

        switch (direction){
            case 0: fy--; fy2--; break;
            case 1: fx++; fx2++; break;
            case 2: fy++; fy2++; break;
            case 3: fx--; fx2--; break;
        }





      
        removeEnemyIfEaten();
    }

    private void removeEnemyIfEaten(){
        for (Enemy enemy: Maze.list_enemy) {
            Player player = Maze.list_player.get(0);
            if ((enemy.fx == player.fx) && (enemy.fy == player.fy)){
                App.maze.remove(enemy.bx2, enemy.by2);
            }
        }
    }

    /**
     *  does the object in front of player is reachable? 
     */
    boolean canMoveForward(){
        GameObject obj;

        switch (direction) {
            case 0 : obj = App.maze.whatIsIn(fx, fy - 1); break;
            case 1 : obj = App.maze.whatIsIn(fx + 1, fy); break;
            case 2 : obj = App.maze.whatIsIn(fx, fy + 1); break;
            case 3 : obj = App.maze.whatIsIn(fx - 1, fy); break;
            default: obj = null;
        }

        return !(obj instanceof Water || obj == null);
    }

    public void shift(){
        this.fx = fx2 + shift_x;
        this.fy = fy2 + shift_y;
        this.bx = bx2 + shift_x;
        this.by = by2 + shift_y;
    }


    public abstract void drawBg();
    public abstract void drawFg();


    public int getShift_x() { return shift_x; }
    public int getShift_y() { return shift_y; }
    public int getBx() { return bx; }
    public int getBy() { return by; }
    public int getFx() { return fx; }
    public int getFy() { return fy; }
    public int getX() { return x; }
    public int getY() { return y; }
    public int getForegroundX() { return fx; }
    public int getForegroundY() { return fy; }
    public int getFx2() { return fx2; }
    public int getFy2() { return fy2; }
    public int getBx2() { return bx2; }
    public int getBy2() { return by2; }
    public int getStepCount() { return stepCount; }

}




