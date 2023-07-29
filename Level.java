import java.util.Arrays;

public class Level {
    public int id;
    public Cell[][] cells;

    public Level(int id, Cell[][] cells) {
        this.id = id;
        this.cells = cells;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public Spider getSpider()
    {
        for (int row = 0; row < cells[0].length; row++)
        {
            for (int col = 0; col < cells[0].length; col++)
            {
                if (cells[row][col].spider != null)
                    return cells[row][col].spider;
            }
        }

        return null;
    }
}