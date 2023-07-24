import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class World extends JFrame {
    public int level;

    public Cell[][] arr;
    public Spider spider;
    // public Levels levels;
    public World(int level, int width, int height){
        spider = null;
        this.level = level;
        arr = Level.getLevel(level);
        // double for loop checking for spider boolean
        // we get coords of spider
        // assign to new spider instance
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (arr[i][j].spider != null){
                    spider = arr[i][j].spider;
                    break;
                }
            }
            if (spider != null){
                break;
            }
        }
        setSize(width,height);
        setBounds(0, 0, width, height);
        pack();
    }

}
