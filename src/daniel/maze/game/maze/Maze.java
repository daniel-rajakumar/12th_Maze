package daniel.maze.game.maze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import daniel.maze.game.App;
import daniel.maze.game.graphics.Panel;
import daniel.maze.game.object.*;

public class Maze {

    private int height, width;
    private char[][] map;
    private int pixelSize;
    private String file = "res/level/level_3d_1.txt";
    private BufferedReader input;
    private boolean is3D = false;

    public static ArrayList<Enemy> list_enemy;
    public static ArrayList<Finish> list_finish;
    public static ArrayList<Grass> list_grass;
    public static ArrayList<Player> list_player;
    public static ArrayList<Water> list_water;

    public Maze() throws Exception {
        list_enemy = new ArrayList<>();
        list_finish = new ArrayList<>();
        list_grass = new ArrayList<>();
        list_player = new ArrayList<>();
        list_water = new ArrayList<>();

        pixelSize = 40;
        File root = new File(System.getProperty("user.dir"));
        input = new BufferedReader(new FileReader(new File(root, file)));

        height = (int) Files.lines(Paths.get(file)).count();
        width = (new BufferedReader(new FileReader(new File(file))).readLine().length());

        map = new char[height][width];

        for (int i = 0; i < height; i++){
            map[i] = input.readLine().toCharArray();
        }

    }



    int img_x;
    int img_y;
    int img_width;
    int img_height;

    public void setupLevel() throws IOException {
        // System.out.println("1");

        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){

                img_x = (x * pixelSize) + pixelSize;
                img_y = (y * pixelSize) + pixelSize; 
                img_width = pixelSize;
                img_height = pixelSize;

                setupObjects(x, y);
            }
        }
        // System.out.println("hi");

    }


    public void setupObjects(int x, int y) throws IOException {
        switch (map[y][x]) {
            case 'E': list_player.add(new Player(x, y, pixelSize)); break;
            case 'F': list_finish.add(new Finish(img_x, img_y, img_width, img_height)); break;
            case 'D': list_enemy.add(new Enemy(img_x, img_y, img_width, img_height)); break;
            case ' ': list_grass.add(new Grass(img_x, img_y, img_width, img_height)); break;
            default : list_water.add(new Water(img_x, img_y, img_width, img_height));
        }
    }


    public char[][] getMap() {
        return map;
    }

    public void setMap(char[][] map) {
        this.map = map;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPixelSize() {
        return pixelSize;
    }

    public boolean getIs3D(){
        return is3D;
    }


	public void setIs3D(boolean is3D) {
        this.is3D = is3D;
	}


    
}
