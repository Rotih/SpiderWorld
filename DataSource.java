import java.util.Observable;
import java.util.ArrayList;

public class DataSource extends Observable {
    // class setup
    private static DataSource _instance;
    private ArrayList<Block> connectedBlocks;

    // levels
    private int currentLevel = 1;
    public int getCurrentLevelNum() { return currentLevel; }
    public Level getCurrentLevel() { return levels[currentLevel]; }
    private Level[] levels;
    public Level getLevel(int idx) { return levels[idx]; }

// TODO the following should be in the Level class

//    // cells
//    private Cell[][] cells;
//    public void createCells(int n) { cells = new Cell[n][n]; }
//    public Cell[][] getCells() { return cells; }
//    public Cell getCell(int x, int y) { return cells[x][y]; }

   

    // constructor (private for singleton)
    private DataSource()
    {
        connectedBlocks = new ArrayList<>();
        // nothing yet!
    }

    // for singleton
    public static DataSource getInstance() {
        if (_instance == null)
            _instance = new DataSource();

        return _instance;
    }

    public void delete(Object o)
    {
        System.out.println("Attempted to delete a class in DataSource.");
    }

    //methods for blocks
    public void addConnectedBlock(Block block) {
        connectedBlocks.add(block);
    }

    public ArrayList<Block> getConnectedBlocks() {
        return connectedBlocks;
    }

}
