import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

public class WorldPanel extends JPanel implements MouseListener, ActionListener {

    public World w;
    private int sevenX;
    private int sevenY;

    private JSlider speedSlider;

    public WorldPanel(int levelId) {
        setLayout(null);
        speedSlider = new JSlider(JSlider.HORIZONTAL, 0, 3000, 1500);
        speedSlider.setMajorTickSpacing(1500);
        speedSlider.setMinorTickSpacing(100);
        speedSlider.setPaintTicks(true);
        Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
        labelTable.put(0, new JLabel("Slow"));
        labelTable.put(3000, new JLabel("Fast"));
        speedSlider.setLabelTable(labelTable);
        speedSlider.setPaintLabels(true);
        speedSlider.setName("Speed");
        speedSlider.setBounds(100, 600, 300, 50);
        this.add(speedSlider);
        w = new World(levelId, 2, 2);

        revalidate();
        repaint();
    }

    private int getAdjustedSpeed() {
        return 3000 - speedSlider.getValue();
    }

    public void setLevel(int levelId)
    {
        w = new World(levelId, 2, 2);
        if (levelId == 7) {
            sevenX = w.spider.row;
            sevenY = w.spider.col;
        }
    }

    public void reset() {
        if (w.level != 7) {
            for (int row = 0; row < w.cells.length; row++) {
                for (int col = 0; col < w.cells[row].length; col++) {
                    w.cells[row][col].setColor("black");
                }
            }
            int initX = DataSource.getInstance().getSpiderInit()[w.level - 1][0];
            int initY = DataSource.getInstance().getSpiderInit()[w.level - 1][1];
            w.cells[w.spider.row][w.spider.col].spider = null;
            w.spider.resetPos(initX, initY);
            w.cells[initX][initY].spider = w.spider;
            System.out.print(w.spider.dir);
        } else {
            w.cells[w.spider.row][w.spider.col].spider = null;
            w.spider.resetPos(sevenY, sevenX);
            w.cells[sevenX][sevenY].spider = w.spider;
        }
    }
    public World getWorld() {
        return w;
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
            String title;
            if (DataSource.getInstance().getNumLevels() > w.level) {
                title = "You are now ready for Level " + (w.level + 1);
            } else {
                title = "You have completed the final level!";
            }
            String message = "CONGRATULATIONS!!! You Completed Level " + w.level;
            JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
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
            this.repaint();
            this.revalidate();
            try {
                Thread.sleep(getAdjustedSpeed());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int row = 0; row < w.cells.length; row++){
            for (int col = 0; col < w.cells[row].length; col++){
                int tempId = w.cells[row][col].id;
                w.cells[row][col].draw(g, tempId, row, col);
            }
        }
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
