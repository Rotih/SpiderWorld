import javax.swing.*;
import javax.xml.crypto.Data;

public class World extends JFrame {
    public int level;
    public Cell[][] cells;
    public Spider spider;

    // public Levels levels;
    public World(int levelId, int width, int height){
        this.level = levelId;

        Level currLevel = DataSource.getInstance().getLevel(levelId);
        this.cells = currLevel.getCells();
        this.spider = currLevel.getSpider();

        setSize(width,height);
        setBounds(0, 0, width, height);
        pack();
    }

}
