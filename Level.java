public class Level {
    public int level;
    public static Cell[][] cells;

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
                cells = new Cell[5][5];
                cells[0][0] = new Cell(1, Cell.Diamond.DEFAULT, true, 0, 0);
                cells[0][1] = new Cell(2, Cell.Diamond.RED, false, 0, 1);
                cells[0][2] = new Cell(3, Cell.Diamond.DEFAULT, false, 0, 2);
                cells[0][3] = new Cell(4, Cell.Diamond.DEFAULT, false, 0, 3);
                cells[0][4] = new Cell(5, Cell.Diamond.DEFAULT, false, 0, 4);
                cells[1][0] = new Cell(6, Cell.Diamond.DEFAULT, false, 1, 0);
                cells[1][1] = new Cell(7, Cell.Diamond.DEFAULT, false, 1, 1);
                cells[1][2] = new Cell(8, Cell.Diamond.DEFAULT, false, 1, 2);
                cells[1][3] = new Cell(9, Cell.Diamond.DEFAULT, false, 1, 3);
                cells[1][4] = new Cell(10, Cell.Diamond.DEFAULT, false, 1, 4);
                cells[2][0] = new Cell(11, Cell.Diamond.DEFAULT, false, 2, 0);
                cells[2][1] = new Cell(12, Cell.Diamond.DEFAULT, false, 2, 1);
                cells[2][2] = new Cell(13, Cell.Diamond.DEFAULT, false, 2, 2);
                cells[2][3] = new Cell(14, Cell.Diamond.DEFAULT, false, 2, 3);
                cells[2][4] = new Cell(15, Cell.Diamond.GREEN, false, 2, 4);
                cells[3][0] = new Cell(16, Cell.Diamond.DEFAULT, false, 3, 0);
                cells[3][1] = new Cell(17, Cell.Diamond.BLUE, false, 3, 1);
                cells[3][2] = new Cell(18, Cell.Diamond.DEFAULT, false, 3, 2);
                cells[3][3] = new Cell(19, Cell.Diamond.DEFAULT, false, 3, 3);
                cells[3][4] = new Cell(20, Cell.Diamond.DEFAULT, false, 3, 4);
                cells[4][0] = new Cell(21, Cell.Diamond.DEFAULT, false, 4, 0);
                cells[4][1] = new Cell(22, Cell.Diamond.DEFAULT, false, 4, 1);
                cells[4][2] = new Cell(23, Cell.Diamond.DEFAULT, false, 4, 2);
                cells[4][3] = new Cell(24, Cell.Diamond.DEFAULT, false, 4, 3);
                cells[4][4] = new Cell(25, Cell.Diamond.DEFAULT, false, 4, 4);
                break;
            case 2:
                cells = new Cell[5][5];
                cells[0][0] = new Cell(1, Cell.Diamond.BLUE, true, 0, 0);
                cells[0][1] = new Cell(2, Cell.Diamond.DEFAULT, false, 0, 1);
                cells[0][2] = new Cell(3, Cell.Diamond.GREEN, false, 0, 2);
                cells[0][3] = new Cell(4, Cell.Diamond.DEFAULT, false, 0, 3);
                cells[0][4] = new Cell(5, Cell.Diamond.DEFAULT, false, 0, 4);
                cells[1][0] = new Cell(6, Cell.Diamond.DEFAULT, false, 1, 0);
                cells[1][1] = new Cell(7, Cell.Diamond.RED, false, 1, 1);
                cells[1][2] = new Cell(8, Cell.Diamond.DEFAULT, false, 1, 2);
                cells[1][3] = new Cell(9, Cell.Diamond.BLUE, false, 1, 3);
                cells[1][4] = new Cell(10, Cell.Diamond.DEFAULT, false, 1, 4);
                cells[2][0] = new Cell(11, Cell.Diamond.DEFAULT, false, 2, 0);
                cells[2][1] = new Cell(12, Cell.Diamond.DEFAULT, false, 2, 1);
                cells[2][2] = new Cell(13, Cell.Diamond.DEFAULT, false, 2, 2);
                cells[2][3] = new Cell(14, Cell.Diamond.DEFAULT, false, 2, 3);
                cells[2][4] = new Cell(15, Cell.Diamond.DEFAULT, false, 2, 4);
                cells[3][0] = new Cell(16, Cell.Diamond.DEFAULT, false, 3, 0);
                cells[3][1] = new Cell(17, Cell.Diamond.DEFAULT, false, 3, 1);
                cells[3][2] = new Cell(18, Cell.Diamond.DEFAULT, false, 3, 2);
                cells[3][3] = new Cell(19, Cell.Diamond.DEFAULT, false, 3, 3);
                cells[3][4] = new Cell(20, Cell.Diamond.DEFAULT, false, 3, 4);
                cells[4][0] = new Cell(21, Cell.Diamond.DEFAULT, false, 4, 0);
                cells[4][1] = new Cell(22, Cell.Diamond.DEFAULT, false, 4, 1);
                cells[4][2] = new Cell(23, Cell.Diamond.DEFAULT, false, 4, 2);
                cells[4][3] = new Cell(24, Cell.Diamond.DEFAULT, false, 4, 3);
                cells[4][4] = new Cell(25, Cell.Diamond.DEFAULT, false, 4, 4);
        }
        return cells;
    }
}