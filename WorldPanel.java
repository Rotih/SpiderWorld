import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WorldPanel extends JPanel implements MouseListener {

    private World w;
    public WorldPanel() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        w = new World(1, 2, 2);
        setBackground(Color.lightGray);
    }

    public void paint(Graphics g){
        for (int row = 0; row < w.arr.length; row++){
            for (int col = 0; col < w.arr[row].length; col++){
                int tempId = w.arr[row][col].id;
                w.arr[row][col].draw(g, tempId, row, col);
            }
        }
    }

    public void run(String [] sample) {
        System.out.println("running");
        for (int i = 0; i < sample.length; i++) {
            if (sample[i].equals("turn")) {
                w.spider.turn();
            } else if (sample[i].equals("step")) {
                int newRow = w.spider.row;
                int newCol = w.spider.col;
                if (w.spider.dir == 0) {
                    newRow--;
                } else if (w.spider.dir == 1) {
                    newCol++;
                } else if (w.spider.dir == 2) {
                    newRow++;
                } else {
                    newCol--;
                }
                if (newRow < 0 || newCol < 00 || newRow >= w.arr.length || newCol >= w.arr[0].length) {
                    // spider out of bounds
                    //possible pop up box
                    break;
                } else {
                    w.arr[w.spider.row][w.spider.col].spider = null;
                    w.spider.move();
                    w.arr[w.spider.row][w.spider.col].spider = w.spider;
                }
            }
            repaint();
            try {
                Thread.sleep(2000);
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
