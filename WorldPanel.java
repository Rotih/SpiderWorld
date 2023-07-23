import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WorldPanel extends JPanel implements MouseListener {

    public void paint(Graphics g){
        Cell[][] arr = DataSource.getInstance().getCurrentLevel().getCells();
        for (int row = 0; row < arr.length; row++){
            for (int col = 0; col < arr[row].length; col++){
                int tempId = arr[row][col].id;
                arr[row][col].draw(g, tempId, row, col);

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
