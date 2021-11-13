package daniel.maze.game.graphics;

import java.awt.Color;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import daniel.maze.game.App;
import daniel.maze.game.maze.Maze;
import daniel.maze.game.object.GameObject;

public class GameTimer {
    public static int sec;
    public static Timer timer;

    public GameTimer(int sec){
        GameTimer.sec = sec;
        startCountdown();
    }

    public void startCountdown(){
        timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                sec--;
            }
        }, 0, (1 * 1000));
    }

    public void draw(){
        Render.graphics.setFont(new Font("TimesRoman", Font.PLAIN, GameObject.PIXEL_SIZE));
        String str = "Timer: " + sec + "   Dino: " + Maze.list_enemy.size();

        if (App.maze.getIs3D()){
            Render.graphics.setColor(Color.WHITE);
        } else {
            Render.graphics.setColor(Color.BLACK);
        }

        checkWin();

        // String str = "dino: " + Maze.list_enemy.size();
        Render.graphics.drawString(str, 10, GameObject.PIXEL_SIZE - 5);
    }

    public void checkWin(){
        if (sec > 0 && Maze.list_enemy.size() == 0){
            try {
                App.maze.nextLevel();
            } catch (Exception e) { e.printStackTrace(); } 
        }
    }


    
}
