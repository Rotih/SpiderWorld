import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class DraggableBlockDecorator extends Block {

    private int offsetX;
    private int offsetY;
    private boolean dragging;


    public DraggableBlockDecorator(Block decoratedBlock, int width, int height) {
        super(decoratedBlock.getType(),width, height);


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
                snapToOtherBlock();
                Point blockPosition = new Point(getX(), getY());
                if (decoratedBlock.getBounds().contains(e.getPoint())) {
                    if (blockPosition.x <= 50 && blockPosition.y >= 500) {
                        removeBlock();
                    }
                }
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

    private void snapToOtherBlock() {
        boolean snapped = false;

        for (Component component : getParent().getComponents()) {
            if (component instanceof DraggableBlockDecorator && component != this) {
                DraggableBlockDecorator otherBlock = (DraggableBlockDecorator) component;

                int thisBottom = getY() + getHeight();
                int otherBottom = otherBlock.getY() + otherBlock.getHeight();
                int snapThreshold = 20;

                if (Math.abs(thisBottom - otherBlock.getY()) < snapThreshold) {
                    setLocation(getX(), otherBlock.getY() - getHeight());
                    snapped = true;
                    break;
                }

                if (Math.abs(getY() - otherBottom) < snapThreshold) {

                    setLocation(getX(), otherBlock.getY() + otherBlock.getHeight());

                    DataSource.getInstance().addConnectedBlock(this);
                    snapped = true;
                    break;
                }
            }
        }


        if (!snapped) {
            DataSource.getInstance().getConnectedBlocks().remove(this);
        }
    }

}
