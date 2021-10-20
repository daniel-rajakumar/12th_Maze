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
import daniel.maze.game.graphics.Panel;
import daniel.maze.game.object.*;

public class Maze {

    private int height, width;
    private char[][] map;
    private GameObject[][] map_Objects;
    private int pixelSize;
    private String file = "res/level/level_1.txt";
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

        map = new char[height][width];
        map_Objects = new GameObject[height][width];

        for (int i = 0; i < height; i++){
            map[i] = input.readLine().toCharArray();
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
        switch (map[y][x]) {
            case 'E': map_Objects[y][x] = new Player(x, y); break;
            case 'F': map_Objects[y][x] = new Finish(x, y); break;
            case 'D': map_Objects[y][x] = new Enemy(x, y); break;
            case ' ': map_Objects[y][x] = new Grass(x, y); break;
            case '#': map_Objects[y][x] = new Water(x, y); break;
            default : System.out.println("Nothing"); 
        }
        setupObjects();
    }

    public void setupObjects(){
        for (GameObject[] i: map_Objects){
            for (GameObject j: i){
                if (j instanceof Player) list_player.add((Player)j);
                if (j instanceof Finish) list_finish.add((Finish)j);
                if (j instanceof Enemy) list_enemy.add((Enemy)j);
                if (j instanceof Grass) list_grass.add((Grass)j);
                if (j instanceof Water) list_water.add((Water)j);
            }
        }
    }






    public char[][] getMap() { return map; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public int getPixelSize() { return pixelSize; }
    public boolean getIs3D(){ return is3D; }


    public void setMap(char[][] map) { this.map = map; }
	public void setIs3D(boolean is3D) { this.is3D = is3D; }
}
