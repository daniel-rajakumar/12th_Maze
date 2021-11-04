package daniel.maze.game.graphics;

import java.io.IOException;
import java.util.ConcurrentModificationException;

import daniel.maze.game.App;
import daniel.maze.game.maze.Maze;
import daniel.maze.game.object.Enemy;
import daniel.maze.game.object.Finish;
import daniel.maze.game.object.GameObject;
import daniel.maze.game.object.Grass;
import daniel.maze.game.object.Player;
import daniel.maze.game.object.Water;

public class Render_2d {

    Render_2d() { }

    public void render() throws IOException {
        try {
            // for (Grass grass:   Maze.list_grass)    grass.drawBg(); 
            // for (Enemy enemy:   Maze.list_enemy)    enemy.drawBg();
            // for (Water water:   Maze.list_water)    water.drawBg();
            // for (Finish finish: Maze.list_finish)   finish.drawBg();
            // for (Player player: Maze.list_player)   player.drawBg();

            // for (Grass grass:   Maze.list_grass)    grass.drawFg(); 
            // for (Enemy enemy:   Maze.list_enemy)    enemy.drawFg();
            // for (Water water:   Maze.list_water)    water.drawFg();
            // for (Finish finish: Maze.list_finish)   finish.drawFg();
            // for (Player player: Maze.list_player)   player.drawFg();


            // int x = Maze.list_player.get(0).getForegroundX() - Maze.list_player.get(0).getX();
            // int y = Maze.list_player.get(0).getForegroundY() - Maze.list_player.get(0).getY();
            // int x = Maze.list_player.get(0).getX() - Maze.list_player.get(0).getForegroundX();
            // int y = Maze.list_player.get(0).getY() - Maze.list_player.get(0).getForegroundY();
            int x = Maze.list_player.get(0).getForegroundX() - GameObject.shift_x;
            int y = Maze.list_player.get(0).getForegroundY() - GameObject.shift_y;




            GameObject.shift_y = 0; 
            GameObject.shift_x = 0; 

            int size = 10;
            if (x > size) GameObject.shift_x = (-x + 1 + size); 
            if (y > size) GameObject.shift_y = (-y + 1 + size); 

            System.out.println("33: (" + x + ", " + y + ") ");

            
            
            for (int i = 0; i < App.maze.getMap().length; i++){
                for (int j = 0; j < App.maze.getMap()[i].length; j++){
                    App.maze.getObj_map()[i][j].shift();
                    App.maze.getObj_map()[i][j].drawBg();;
                }
            }

            for (int i = 0; i < App.maze.getMap().length; i++){
                for (int j = 0; j < App.maze.getMap()[i].length; j++){
                    App.maze.getObj_map()[i][j].drawFg();;
                }
            }

        } catch (ConcurrentModificationException e) {
            System.out.println("message: " + e.getMessage());
        }
        
    }



    
}
