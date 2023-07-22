import java.awt.*;

public class World extends Canvas {
    public int level;
//    public Cell[][] arr;
   // public Levels levels;
    public World(int level){
        this.level = level;
       // arr = levels.getLevel(level);
    }

    /*
    public World(int level, Cell[][] arr)
    {
        this.level = level;
        this.arr = arr;
    }
    * */

    public void draw(Graphics g){
        int cellWidth = 50;
        int cellHeight = 50;
        Cell[][] arr = Level.getLevel(level);
        for (int row = 0; row < arr.length; row++){
            for (int col = 0; col < arr[row].length; col++){
                Cell temp = arr[row][col];
                g.fillRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight);
                g.setColor(Color.WHITE);
                if (temp.aDiamond == Cell.Diamond.RED){
                    //draws a red diamond
                }
                else if (temp.aDiamond == Cell.Diamond.GREEN){
                    //
                }
                else if (temp.aDiamond == Cell.Diamond.BLUE){
                    //
                }
                if (temp.spider == true){

                }
            }
        }
    }

}
