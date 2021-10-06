package daniel.maze.game.graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import daniel.maze.game.App;

import java.awt.*;

public class Panel extends JPanel {
    private JFrame frame;

    public Panel(){
        frame = new JFrame("A maze program");
        frame.setSize(1150, 600);
        frame.add(this);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g){
        //Make Background Blank
		super.paintComponent(g);
		Graphics2D graphics=(Graphics2D)g;
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0,0,frame.getWidth(), frame.getHeight());

        graphics.setColor(Color.GRAY);


        for (int y = 0; y < App.maze.getHeight(); y++){
            for (int x = 0; x < App.maze.getWidth(); x++){
                System.out.print(App.maze.getMap()[y][x]);
            }
            System.out.println();
        }
        /*
		// DRAW MAZE
		g2.setColor(Color.GRAY);
		for(int c=0;c<map[0].length;c++)
		for(int r=0;r<map.length;r++){
			if (maze[r][c] == 'E'){
				//EXPLORER
				g2.setColor(Color.RED);
				g2.fillRect(c*size+size,r*size+size,size,size);
				g2.setColor(Color.GRAY);
			}
			else if (maze[r][c] == 'F'){
				//SET FINISH OR GOAL SQUARE
			}
			else if(maze[r][c]==' ') // OPEN SQUARE GRAY
				g2.fillRect(c*size+size,r*size+size,size,size);
			else // BLOCKED SQUARE GRAY OUTLINE
				g2.drawRect(c*size+size,r*size+size,size,size);
		}
		if (App.DEBUG){ // PRINT EXTRA INFO TO HELP DEBUG
			g2.setColor(Color.YELLOW);
			g2.drawString("Debug message here",40, numRows*size+2*size);
			g2.setColor(Color.GRAY);
		}
	}
    */
    }
    
}
