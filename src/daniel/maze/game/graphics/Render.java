package daniel.maze.game.graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import daniel.maze.game.App;
import daniel.maze.game.graphics.*;

public class Render {
    private Graphics graphics;

    Render(Graphics graphics){
        this.graphics = graphics;
        renderLevel();
    }

    public void renderLevel(){
        for (int y = 0; y < App.maze.getHeight(); y++){
            for (int x = 0; x < App.maze.getWidth(); x++){

                int img_x = (x * App.maze.getPixelSize()) + App.maze.getPixelSize();
                int img_y = (y * App.maze.getPixelSize()) + App.maze.getPixelSize(); 
                int img_width = App.maze.getPixelSize();
                int img_height = App.maze.getPixelSize();

                if (App.maze.getMap()[y][x] == 'E'){
                    try {
                        BufferedImage image = ImageIO.read(new File(App.PATH_IMG + "blob.png"));
                        graphics.drawImage(image, img_x, img_y, img_width, img_height, null);
                    } catch (IOException e) { e.printStackTrace(); }

                } else if (App.maze.getMap()[y][x] == 'F'){ //SET FINISH OR GOAL SQUARE
                        try {
                            BufferedImage image_1 = ImageIO.read(new File(App.PATH_IMG + "grass.png"));
                            BufferedImage image_2 = ImageIO.read(new File(App.PATH_IMG + "pizza.png"));
                            graphics.drawImage(image_1, img_x, img_y, img_width, img_height, null);
                            graphics.drawImage(image_2, img_x, img_y, img_width, img_height, null);
                        } catch (IOException e) { e.printStackTrace(); }

                    } else if(App.maze.getMap()[y][x] == 'D'){ // OPEN SQUARE GRAY
                        try {
                            BufferedImage image_1 = ImageIO.read(new File(App.PATH_IMG + "grass.png"));
                            BufferedImage image_2 = ImageIO.read(new File(App.PATH_IMG + "dino.png"));
                            graphics.drawImage(image_1, img_x, img_y, img_width, img_height, null);
                            graphics.drawImage(image_2, img_x, img_y, img_width, img_height, null);
                        } catch (IOException e) { e.printStackTrace(); }


                    } else if(App.maze.getMap()[y][x] == ' '){ // OPEN SQUARE GRAY
                        try {
                            BufferedImage image = ImageIO.read(new File(App.PATH_IMG + "grass.png"));
                            graphics.drawImage(image, img_x, img_y, img_width, img_height, null);
                        } catch (IOException e) { e.printStackTrace(); }

                    } else { // BLOCKED SQUARE GRAY OUTLINE
                        try {
                            BufferedImage image = ImageIO.read(new File(App.PATH_IMG + "water.png"));
                            graphics.drawImage(image, img_x, img_y, img_width, img_height, null);
                        } catch (IOException e) { e.printStackTrace(); }
                    }
            }
        }

    }


}
