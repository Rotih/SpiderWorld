import java.util.Observable;
import java.util.ArrayList;

public class DataSource extends Observable {
    // class setup
    private static DataSource _instance;
    private ArrayList<Block> connectedBlocks;

    // constructor (private for singleton)
    private DataSource()
    {
        connectedBlocks = new ArrayList<>();
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

    public String[] getBlocksRunnable() {
        String[] connected = new String[connectedBlocks.size()];
        for (int i = 0; i < connectedBlocks.size(); i++) {
            connected[i] = connectedBlocks.get(i).getType();
        }
        return connected;
    }

}
