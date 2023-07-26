import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

public class WorldPanel extends JPanel implements MouseListener {

    public World w;
    public WorldPanel() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        w = new World(1, 2, 2);
        setBackground(Color.lightGray);
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
            MoveBlock turning = new MoveBlock("turn", 85, 25);
            block.add(turning);
        } else if (instruction.equals("Step")) {
            MoveBlock stepping = new MoveBlock("step", 85, 25);
            block.add(stepping);
        } else if (instruction.equals("Red") || instruction.equals("Blue") || instruction.equals("Green")) {
            PaintBlock paint;
            if (instruction.equals("Red")) {
                paint = new PaintBlock("paint red");
            } else if (instruction.equals("Blue")) {
                paint = new PaintBlock("paint blue");
            } else {
                paint = new PaintBlock("paint green");
            }
            block.add(paint);
        }
        for (Block b: block){
            if (b.getType().equals("turn")){
                w.spider.turn();
            }
            else if (b.getType().equals("step")){
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
            else if (b.getType().startsWith("paint")){
                String [] words = b.getType().split("\\s+");
                w.cells[w.spider.row][w.spider.col].setColor(words[1]);
            }
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void run() {
        ArrayList<Block> currBlocks = DataSource.getInstance().getConnectedBlocks();
        for (Block block: currBlocks){
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
