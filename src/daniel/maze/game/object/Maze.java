package daniel.maze.game.object;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Maze {

    private int height, width;
    private char[][] map;
    private int pixelSize;
    private String file = "res/level/level_1.txt";
    private BufferedReader input;

    public Maze() throws Exception {
        pixelSize = 40;
        File root = new File(System.getProperty("user.dir"));
        input = new BufferedReader(new FileReader(new File(root, file)));

        height = (int) Files.lines(Paths.get(file)).count();
        width = (new BufferedReader(new FileReader(new File(file))).readLine().length());

        map = new char[height][width];

        for (int i = 0; i < height; i++){
            map[i] = input.readLine().toCharArray();
        }

        System.out.printf("[y: %s, x: %s] \n", height, width);
    }

    public char[][] getMap() {
        return map;
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

    
}
