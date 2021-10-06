package object;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Maze {

    private int height, width;
    private char[][] map;
    private int map_height, map_width;
    private int pixelSize;
    private String file = "res/level/level_1.txt";
    private BufferedReader input;

    public Maze() throws Exception {
        File root = new File(System.getProperty("user.dir"));
        input = new BufferedReader(new FileReader(new File(root, file)));

        map_height = (int) Files.lines(Paths.get(file)).count();
        map_width = (new BufferedReader(new FileReader(new File(file))).readLine().length());

        map = new char[map_height][map_width];

        System.out.printf("[y: %s, x: %s] \n", map_height, map_width);

    }
}
