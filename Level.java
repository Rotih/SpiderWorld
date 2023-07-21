import java.util.random.*;
public class Level {
    public int level;
    private static Cell[][] cells;

    public Level(int level) {
        this.level = level;
        getLevel(level);
    }

    public Cell[][] getCells() {
        return cells;
    }

    public static Cell[][] getLevel(int level){
        switch(level){
            case 1:
                cells = new Cell[2][2];
                cells[0][0] = new Cell(1, Cell.Diamond.DEFAULT, false);
                cells[0][1] = new Cell(2, Cell.Diamond.RED, false);
                cells[1][0] = new Cell(3, Cell.Diamond.GREEN, false);
                cells[1][1] = new Cell(3, Cell.Diamond.GREEN, false);
                break;
            case 2:
                cells = new Cell[3][3];
                cells[0][0] = new Cell(1, Cell.Diamond.DEFAULT, false);
                cells[0][1] = new Cell(2, Cell.Diamond.RED, false);
                cells[0][1] = new Cell(3, Cell.Diamond.GREEN, false);
                break;
        }
        return cells;
    }
}
}
