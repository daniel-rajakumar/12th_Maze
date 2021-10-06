package daniel.maze.game.graphics;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import daniel.maze.game.App;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Panel extends JPanel {
    private JFrame frame;

    public Panel(){
        frame = new JFrame("A maze program");
        frame.setSize(1150, 600);
        frame.add(this);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        //Make Background Blank
		super.paintComponent(g);
		Graphics2D graphics=(Graphics2D)g;
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0,0,frame.getWidth(), frame.getHeight());

        graphics.setColor(Color.GRAY);


        for (int y = 0; y < App.maze.getHeight(); y++){
            for (int x = 0; x < App.maze.getWidth(); x++){

                int img_x = (x * App.maze.getPixelSize()) + App.maze.getPixelSize();
                int img_y = (y * App.maze.getPixelSize()) + App.maze.getPixelSize(); 
                int img_width = App.maze.getPixelSize();
                int img_height = App.maze.getPixelSize();

                File root = new File(System.getProperty("user.dir"));
                if (App.maze.getMap()[y][x] == 'E'){
                    try {
                        BufferedImage image = ImageIO.read(new File(root, "res/img/blob.png"));
                        graphics.drawImage(image, img_x, img_y, img_width, img_height, null);
                    } catch (IOException e) { e.printStackTrace(); }

                } else if (App.maze.getMap()[y][x] == 'F'){ //SET FINISH OR GOAL SQUARE
                        try {
                            BufferedImage image_1 = ImageIO.read(new File(root, "res/img/grass.png"));
                            BufferedImage image_2 = ImageIO.read(new File(root, "res/img/pizza.png"));
                            graphics.drawImage(image_1, img_x, img_y, img_width, img_height, null);
                            graphics.drawImage(image_2, img_x, img_y, img_width, img_height, null);
                        } catch (IOException e) { e.printStackTrace(); }

                    } else if(App.maze.getMap()[y][x] == 'D'){ // OPEN SQUARE GRAY
                        try {
                            BufferedImage image_1 = ImageIO.read(new File(root, "res/img/grass.png"));
                            BufferedImage image_2 = ImageIO.read(new File(root, "res/img/dino.png"));
                            graphics.drawImage(image_1, img_x, img_y, img_width, img_height, null);
                            graphics.drawImage(image_2, img_x, img_y, img_width, img_height, null);
                        } catch (IOException e) { e.printStackTrace(); }


                    } else if(App.maze.getMap()[y][x] == ' '){ // OPEN SQUARE GRAY
                        try {
                            BufferedImage image = ImageIO.read(new File(root, "res/img/grass.png"));
                            graphics.drawImage(image, img_x, img_y, img_width, img_height, null);
                        } catch (IOException e) { e.printStackTrace(); }

                    } else { // BLOCKED SQUARE GRAY OUTLINE
                        try {
                            BufferedImage image = ImageIO.read(new File(root, "res/img/water.png"));
                            graphics.drawImage(image, img_x, img_y, img_width, img_height, null);
                        } catch (IOException e) { e.printStackTrace(); }
                    }
            }
        }

    }
}
