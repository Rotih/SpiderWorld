import java.io.File;
import java.util.Observable;
import java.util.ArrayList;

public class DataSource extends Observable
{

	// class setup
	private static DataSource _instance;

	// constructor (private for singleton)
	private DataSource()
	{
		resetConnectedBlocks();
		importLevels();
	}

	// for singleton
	public static DataSource getInstance()
	{
		if (_instance == null) _instance = new DataSource();

		return _instance;
	}

	// Levels
	private ArrayList<Level> levels;

	public void importLevels()
	{
		levels = new ArrayList<Level>();

		File folder = new File("levels/");
		File[] levelFiles = folder.listFiles();

		for (File level : levelFiles) {
			if (level.isFile()) {
				String levelName = level.getName().substring(0, level.getName().lastIndexOf('.'));
				levels.add(new Level(Integer.parseInt(levelName)));
			}
		}
	}

	// Blocks
	private ArrayList<Block> connectedBlocks;

	public void addConnectedBlock(Block block)
	{
		connectedBlocks.add(block);
	}

	public void resetConnectedBlocks()
	{
		connectedBlocks = new ArrayList<Block>();
	}

	public ArrayList<Block> getConnectedBlocks()
	{
		return connectedBlocks;
	}

	public String[] getBlocksRunnable()
	{
		String[] connected = {"turn", "step"};
		return connected;
	}

}
