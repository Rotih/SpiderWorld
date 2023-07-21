import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DraggableBlockDecorator extends Block {
    private Block decoratedBlock;
    private int offsetX;
    private int offsetY;
    private boolean dragging;

    public DraggableBlockDecorator(Block decoratedBlock) {
        super("");
        this.decoratedBlock = decoratedBlock;
        setLayout(new BorderLayout());
        add(decoratedBlock);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                offsetX = e.getX();
                offsetY = e.getY();
                dragging = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dragging = false;
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (dragging) {
                    Point point = SwingUtilities.convertPoint(decoratedBlock, e.getPoint(), getParent());
                    setLocation(point.x - offsetX, point.y - offsetY);
                }
            }
        });
    }

    @Override
    public void draw() {
    }
}
