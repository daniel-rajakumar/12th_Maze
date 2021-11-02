package daniel.maze.game.graphics;

import java.io.IOException;
import java.util.ConcurrentModificationException;

import daniel.maze.game.maze.Maze;
import daniel.maze.game.object.Enemy;
import daniel.maze.game.object.Finish;
import daniel.maze.game.object.Grass;
import daniel.maze.game.object.Player;
import daniel.maze.game.object.Water;

public class Render_2d {

    Render_2d() { }

    public void render() throws IOException {
        try {
            for (Grass grass:   Maze.list_grass)    grass.drawBg(); 
            for (Enemy enemy:   Maze.list_enemy)    enemy.drawBg();
            for (Water water:   Maze.list_water)    water.drawBg();
            for (Finish finish: Maze.list_finish)   finish.drawBg();
            for (Player player: Maze.list_player)   player.drawBg();


            for (Grass grass:   Maze.list_grass)    grass.drawFg(); 
            for (Enemy enemy:   Maze.list_enemy)    enemy.drawFg();
            for (Water water:   Maze.list_water)    water.drawFg();
            for (Finish finish: Maze.list_finish)   finish.drawFg();
            for (Player player: Maze.list_player)   player.drawFg();
            
        } catch (ConcurrentModificationException e) {
            System.out.println("message: " + e.getMessage());
        }
        
    }



    
}
