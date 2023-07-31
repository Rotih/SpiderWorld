import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

public class WorldPanel extends JPanel implements MouseListener {

    public World w;
    public WorldPanel(int levelId) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        w = new World(levelId, 2, 2);
    }

    public void setLevel(int levelId)
    {
        w = new World(levelId, 2, 2);
    }

    public World getWorld() {
        return w;
    }
    public void paint(Graphics g){
        for (int row = 0; row < w.cells.length; row++){
            for (int col = 0; col < w.cells[row].length; col++){
                int tempId = w.cells[row][col].id;
                w.cells[row][col].draw(g, tempId, row, col);
            }
        }
    }

    public void runSeparately(String instruction) {
        ArrayList<Block> block = new ArrayList<Block>();
        if (instruction.equals("Turn")) {
            MoveBlock turning = new MoveBlock("turn");
            block.add(turning);
        } else if (instruction.equals("Step")) {
            MoveBlock stepping = new MoveBlock("step");
            block.add(stepping);
        } else if (instruction.equals("Red") || instruction.equals("Blue") || instruction.equals("Green")) {
            MoveBlock paint;
            if (instruction.equals("Red")) {
                paint = new MoveBlock("paint red");
            } else if (instruction.equals("Blue")) {
                paint = new MoveBlock("paint blue");
            } else {
                paint = new MoveBlock("paint green");
            }
            block.add(paint);
        }
        run(block);
    }


    public void run() {
        ArrayList<Block> currBlocks = DataSource.getInstance().getConnectedBlocks();
        run(currBlocks);

    }

    public boolean check(){
        boolean success = true;
        for (int row = 0; row < w.cells.length && success; row++){
            for (int col = 0; col < w.cells[row].length && success; col++){
                if (w.cells[row][col].aDiamond == Cell.Diamond.DEFAULT){
                    if (!w.cells[row][col].color.equals("black")){
                        success = false;
                    }
                }
                else{
                    if (w.cells[row][col].aDiamond == Cell.Diamond.BLUE) {
                        if (!w.cells[row][col].color.equals("blue")) {
                            success = false;
                        }
                    }
                    else if (w.cells[row][col].aDiamond == Cell.Diamond.RED) {
                        if (!w.cells[row][col].color.equals("red")) {
                            success = false;
                        }
                    }
                    else if (w.cells[row][col].aDiamond == Cell.Diamond.GREEN) {
                        if (!w.cells[row][col].color.equals("green")) {
                            success = false;
                        }
                    }
                }
            }
        }
        if (success){
            //pop for success
            String message = "CONGRATULATIONS!!! You Completed Level " + w.level;
            JOptionPane.showMessageDialog(null, message, "You are now ready for Level " + (w.level + 1), JOptionPane.PLAIN_MESSAGE);
        }
        return success;
    }

    public void run(ArrayList<Block> blocks) {
        for (Block block: blocks){
            if (block.getType().equals("turn")){
                w.spider.turn();
            }
            else if (block.getType().equals("step")){
                int newRow = w.spider.row;
                int newCol = w.spider.col;
                if (w.spider.dir == 0){
                    newRow--;
                }
                else if (w.spider.dir == 1){
                    newCol++;
                }
                else if (w.spider.dir == 2){
                    newRow++;
                }
                else{
                    newCol--;
                }
                if (newRow <0 || newCol < 00 || newRow >= w.cells.length || newCol >= w.cells[0].length){
                    // spider out of bounds
                    //possible pop up box
                    break;
                }
                else{
                    w.cells[w.spider.row][w.spider.col].spider = null;
                    w.spider.move();
                    w.cells[w.spider.row][w.spider.col].spider = w.spider;
                }
            }
            else if (block.getType().startsWith("paint")){
                String [] words = block.getType().split("\\s+");
                w.cells[w.spider.row][w.spider.col].setColor(words[1]);
            }
            repaint();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
