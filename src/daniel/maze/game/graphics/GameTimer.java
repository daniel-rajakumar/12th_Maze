package daniel.maze.game.graphics;

import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import daniel.maze.game.maze.Maze;
import daniel.maze.game.object.GameObject;

public class GameTimer {
    public static int sec;

    public GameTimer(int sec){
        GameTimer.sec = sec;
        startCountdown();
    }

    public void startCountdown(){
        new Timer().schedule(new TimerTask() {
            public void run() {
                sec--;
            }
        }, 0, (1 * 1000));
    }

    public void draw(){
        Render.graphics.setFont(new Font("TimesRoman", Font.PLAIN, GameObject.PIXEL_SIZE));
        // String str = "dino: " + Maze.list_enemy.size();
        String str = "Timer: " + sec + "   Dino: " + Maze.list_enemy.size();
        Render.graphics.drawString(str, 0, GameObject.PIXEL_SIZE - 5);
    }
    
}
