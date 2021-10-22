package daniel.maze.game;

import daniel.maze.game.graphics.*;
import daniel.maze.game.maze.Maze;
import daniel.maze.game.object.*;

public class App {

    public static final boolean DEBUG = false;
    public static final String PATH_IMG = System.getProperty("user.dir") + "/res/img/";
    public static final String PATH_LVL = System.getProperty("user.dir") + "/res/level/";

    public static Maze maze;
    public static GamePanel panel;

    App() throws Exception {
        panel = new GamePanel();
        maze = new Maze(); 
        maze.setupLevel();
    }

    public Maze getMaze() {
        return maze;
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
