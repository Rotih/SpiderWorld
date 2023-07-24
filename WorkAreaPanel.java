import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WorkAreaPanel extends JPanel implements MouseListener, ActionListener {
    private Block connectHere;

    public WorkAreaPanel() {
        setBackground(Color.WHITE);
        connectHere = new DraggableBlockDecorator(new MoveBlock("Connect Here", 150, 25), 150, 25);
        connectHere.setBounds(50, 100, 100, 25);
        this.add(connectHere);
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
