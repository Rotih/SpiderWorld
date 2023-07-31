import java.io.*;
import java.util.*;

public class DataSource extends Observable {

    // class setup
    private static DataSource _instance;

    // constructor (private for singleton)
    private DataSource() {
        resetConnectedBlocks();

        generateRandomLevel(7);
        importLevels();
    }

    // for singleton
    public static DataSource getInstance() {
        if (_instance == null) _instance = new DataSource();

        return _instance;
    }

    // Levels
    private ArrayList<Level> levels;

    public Level getLevel(int id) {
        return levels.get(id - 1);
    }

    private void importLevels() {
        levels = new ArrayList<Level>();

        File folder = new File("levels/");
        File[] levelFiles = folder.listFiles();

        Arrays.sort(levelFiles, Comparator.comparingInt(DataSource::extractLevelNum));

        for (File level : levelFiles) {
            if (level.isFile()) {

                try {
                    levels.add(parseFile(level));
                } catch (IOException e) {
                    System.out.println(e);
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static int extractLevelNum(File f) {
        String levelName = f.getName().substring(0, f.getName().lastIndexOf('.'));
        return Integer.parseInt(levelName);
    }

    private Level parseFile(File level) throws IOException {
        // create identifier
        String levelName = level.getName().substring(0, level.getName().lastIndexOf('.'));
        int id = Integer.parseInt(levelName);

        // find n size of cells
        BufferedReader reader = new BufferedReader(new FileReader(level));
        int n = reader.readLine().length();
        reader.close();

        // parse raw text for cell information
        Cell[][] cells = new Cell[n][n];
        reader = new BufferedReader(new FileReader(level));

        int cellId = 1;
        for (int row = 0; row < n; row++) {
            String line = reader.readLine();
            char[] chars = line.toCharArray();

            if (chars.length != n) {
                System.out.println("Attempted to import a level of non-N*N size.");
            }

            for (int col = 0; col < n; col++) {
                // the only non-accounted for scenario is a diamond and spider being in the same cell

                Cell newCell = switch (chars[col]) {
                    case 'R' -> new Cell(cellId, Cell.Diamond.RED, false, row, col);
                    case 'G' -> new Cell(cellId, Cell.Diamond.GREEN, false, row, col);
                    case 'B' -> new Cell(cellId, Cell.Diamond.BLUE, false, row, col);
                    case 'S' -> new Cell(cellId, Cell.Diamond.DEFAULT, true, row, col);
                    default -> new Cell(cellId, Cell.Diamond.DEFAULT, false, row, col);
                };

                cells[row][col] = newCell;
                cellId++;
            }
        }

        return new Level(id, cells);
    }

    public void generateRandomLevel(int levelId) {
        Random random = new Random();
        int size = random.nextInt(4) + 2; // Generate a random size between 2 and 5

        char[][] grid = new char[size][size];

        // Fill the grid with mostly D's
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = 'D';
            }
        }

        // Place at least one of R, G, B and exactly one S
        int randomRow, randomCol;

        randomRow = random.nextInt(size);
        randomCol = random.nextInt(size);
        grid[randomRow][randomCol] = 'R';

        do {
            randomRow = random.nextInt(size);
            randomCol = random.nextInt(size);
        } while (grid[randomRow][randomCol] != 'D');
        grid[randomRow][randomCol] = 'G';

        do {
            randomRow = random.nextInt(size);
            randomCol = random.nextInt(size);
        } while (grid[randomRow][randomCol] != 'D');
        grid[randomRow][randomCol] = 'B';

        do {
            randomRow = random.nextInt(size);
            randomCol = random.nextInt(size);
        } while (grid[randomRow][randomCol] != 'D');
        grid[randomRow][randomCol] = 'S';

        String levelPath = "levels/0" + levelId + ".txt";

        // Delete existing file, if any
        File file = new File(levelPath);
        if (file.exists()) {
            file.delete();
        }

        // Write the grid to the file
        try (FileWriter writer = new FileWriter(levelPath)) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    writer.write(grid[i][j]);
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    // Blocks
    private ArrayList<Block> connectedBlocks;

    public void addConnectedBlock(Block block) {
        connectedBlocks.add(block);
    }

    public void resetConnectedBlocks() {
        connectedBlocks = new ArrayList<Block>();
    }

    public ArrayList<Block> getConnectedBlocks() {
        return connectedBlocks;
    }

    public int getNumLevels() {
        return levels.size();
    }

}
