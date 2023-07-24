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
        DrawGrid draw_grid = new DrawGrid();
        add(draw_grid);
        pack();
    }



    public void run(){
        ArrayList<Block> currBlocks = DataSource.getInstance().getConnectedBlocks();
        for (Block block: currBlocks){
            if (block.getType().equals("turn")){
                spider.turn();
            }
            else if (block.getType().equals("step")){
                int newRow = spider.row;
                int newCol = spider.col;
                if (spider.dir == 0){
                    newRow--;
                }
                else if (spider.dir == 1){
                    newCol++;
                }
                else if (spider.dir == 2){
                    newRow++;
                }
                else{
                    newCol--;
                }
                if (newRow <0 || newCol < 00 || newRow >= arr.length || newCol >= arr[0].length){
                    // spider out of bounds
                    //possible pop up box
                    break;
                }
                else{
                    arr[spider.row][spider.col].spider = null;
                    spider.move();
                    arr[spider.row][spider.col].spider = spider;
                }
            }
            else if (block.getType().startsWith("paint")){
                String [] words = block.getType().split("\\s+");
                arr[spider.row][spider.col].setColor(words[1]);
            }
            repaint();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public class DrawGrid extends JPanel
    {
        public void paint(Graphics g){

            for (int row = 0; row < arr.length; row++){
                for (int col = 0; col < arr[row].length; col++){
                    int tempId = arr[row][col].id;
                    arr[row][col].draw(g, tempId, row, col);

                }
            }
        }
    }
}

