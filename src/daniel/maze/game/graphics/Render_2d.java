package daniel.maze.game.graphics;

import java.io.IOException;

import daniel.maze.game.maze.Maze;
import daniel.maze.game.object.Enemy;
import daniel.maze.game.object.Finish;
import daniel.maze.game.object.Grass;
import daniel.maze.game.object.Player;
import daniel.maze.game.object.Water;

public class Render_2d {

    Render_2d() { }

    public void render() throws IOException {
        for (Grass grass: Maze.list_grass)      grass.draw(); 
        for (Enemy enemy: Maze.list_enemy)      enemy.draw();
        for (Water water: Maze.list_water)      water.draw();
        for (Finish finish: Maze.list_finish)   finish.draw();
        for (Player player: Maze.list_player)   player.draw();
    }
    
}
