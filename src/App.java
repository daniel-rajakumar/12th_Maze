import java.io.FileNotFoundException;

import graphics.*;
import object.*;

public class App {

    public static final boolean DEBUG = false;

    App() throws Exception {
        new Maze();
        new Panel();
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
