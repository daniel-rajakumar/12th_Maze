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


            modifyShift();


            for (int i = 0; i < App.maze.getMap().length; i++){
                for (int j = 0; j < App.maze.getMap()[i].length; j++){
                    App.maze.getObj_map()[i][j].shift();
                    App.maze.getObj_map()[i][j].drawBg();
                }
            }

            // try { Thread.sleep(1000); } catch (Exception e) { //TODO: handle exception }

            for (int i = 0; i < App.maze.getMap().length; i++){
                for (int j = 0; j < App.maze.getMap()[i].length; j++){
                    App.maze.getObj_map()[i][j].drawFg();
                }
            }

            Maze.timer.draw();
            
        } catch (ConcurrentModificationException e) {
            System.out.println("message: " + e.getMessage());
        }
        
    }

    


    void modifyShift(){
            int x = Maze.list_player.get(0).getForegroundX() - GameObject.shift_x;
            int y = Maze.list_player.get(0).getForegroundY() - GameObject.shift_y;

            GameObject.shift_x = 0; 
            GameObject.shift_y = 0; 

            int sizeWidth =  (App.panel.getWidth() /GameObject.PIXEL_SIZE)/2;
            int sizeHeight = (App.panel.getHeight()/GameObject.PIXEL_SIZE)/2;

            int num_x = App.maze.getWidth() -  (App.panel.getWidth() /GameObject.PIXEL_SIZE); 
            int num_y = App.maze.getHeight() - (App.panel.getHeight()/GameObject.PIXEL_SIZE); 

            if      (x > num_x + sizeWidth)   GameObject.shift_x = -num_x;
            else if (x > sizeWidth)           GameObject.shift_x = (-x + 1 + sizeWidth); 

            if      (y > num_y + sizeHeight)  GameObject.shift_y = -num_y;
            else if (y > sizeHeight)          GameObject.shift_y = (-y + 1 + sizeHeight); 


            // GameObject.shift_x = 4; 
            // GameObject.shift_y = 4; 


    }

    
}
