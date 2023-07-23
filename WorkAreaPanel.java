import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WorkAreaPanel extends JPanel implements MouseListener {

    private int grayRectWidth;
    private Block connectHere;

    public WorkAreaPanel() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        grayRectWidth = (int) (screenWidth * 0.2);
        setBackground(Color.WHITE);
        connectHere = new DraggableBlockDecorator(new MoveBlock("Connect Here", 150, 25), 150, 25);
        connectHere.setBounds(50, 100, 100, 25);
        this.add(connectHere);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the gray rectangle on the right side
        g.setColor(Color.GRAY);
        g.fillRect(getWidth() - grayRectWidth, 0, grayRectWidth, getHeight());
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
