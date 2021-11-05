package daniel.maze.game.maze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.text.PlainDocument;

import daniel.maze.game.App;
import daniel.maze.game.graphics.GamePanel;
import daniel.maze.game.object.*;

public class Maze {

    private int height, width;
    private char[][] char_map;
    private GameObject[][] obj_map;
    private int pixelSize;
    private String file = "res/level/level_0.txt";
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

        File root = new File(System.getProperty("user.dir"));
        input = new BufferedReader(new FileReader(new File(root, file)));

        height = (int) Files.lines(Paths.get(file)).count();
        width = (new BufferedReader(new FileReader(new File(file))).readLine().length());

        char_map = new char[height][width];
        obj_map = new GameObject[height][width];

        for (int i = 0; i < height; i++){
            char_map[i] = input.readLine().toCharArray();
        }
    }


    public void setupLevel() throws IOException {
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                setupObjects(x, y);
            }
        }
    }


    public void setupObjects(int x, int y) throws IOException {
        switch (char_map[y][x]) {
            case 'E': Player player = new Player(x, y); obj_map[y][x] = player; list_player.add(player); break;
            case 'F': Finish finish = new Finish(x, y); obj_map[y][x] = finish; list_finish.add(finish); break;
            case 'D': Enemy enemy   = new Enemy(x, y);  obj_map[y][x] = enemy;  list_enemy.add(enemy);   break;
            case ' ': Grass grass   = new Grass(x, y);  obj_map[y][x] = grass;  list_grass.add(grass);   break;
            case '#': Water water   = new Water(x, y);  obj_map[y][x] = water;  list_water.add(water);   break;
            default : System.out.println("Nothing"); 
        }
    }


    public void remove(int x, int y){
        if (obj_map[y][x] instanceof Enemy) {
            for (int i = 0; i < list_enemy.size(); i++) {
                if (list_enemy.get(i).equals(obj_map[y][x])) {
                    list_enemy.remove(i);
                }
            }
        }

        obj_map[y][x] = new Grass(x, y);
        Maze.list_grass.add((Grass) obj_map[y][x]);
    }





    public GameObject whatIsIn(int x, int y){
        x -= GameObject.shift_x;
        y -= GameObject.shift_y;
        if (x >= width || y >= height || x < 0 || y < 0) {
            System.out.println("out of bounce!");
            return null;
        }


        return obj_map[y][x];
    }

    public char[][] getMap() { return char_map; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public int getPixelSize() { return pixelSize; }
    public boolean getIs3D(){ return is3D; }


    public void setMap(char[][] map) { this.char_map = map; }
	public void setIs3D(boolean is3D) { this.is3D = is3D; }

    public GameObject[][] getObj_map() {
        return obj_map;
    }
}
