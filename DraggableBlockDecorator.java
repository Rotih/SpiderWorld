import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DraggableBlockDecorator extends Block {
    private Block decoratedBlock;
    private int offsetX;
    private int offsetY;
    private boolean dragging;

    public DraggableBlockDecorator(Block decoratedBlock) {
        super(decoratedBlock.getType());
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
                snapToOtherBlock();
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
                int snapThreshold = 10; // Adjust this value as needed for snapping sensitivity

                // Check if the bottom edge of this block is close to the top edge of the other block
                if (Math.abs(thisBottom - otherBlock.getY()) < snapThreshold) {
                    // Snap this block to the top of the other block
                    setLocation(getX(), otherBlock.getY() - getHeight());
                    snapped = true;
                    break;
                }

                // Check if the top edge of this block is close to the bottom edge of the other block
                if (Math.abs(getY() - otherBottom) < snapThreshold) {
                    // Snap this block to the bottom of the other block
                    setLocation(getX(), otherBlock.getY() + otherBlock.getHeight());
                    // Add this block to the connectedBlocks list
                    DataSource.getInstance().addConnectedBlock(this);
                    snapped = true;
                    break;
                }
            }
        }

        // not snapped to any other block remove it from connectedBlocks list
        if (!snapped) {
            DataSource.getInstance().getConnectedBlocks().remove(this);
        }

        // System.out.println("Connected Blocks:");
        // for (Block block : DataSource.getInstance().getConnectedBlocks()) {
        //     System.out.println(block.getType());
        // }
    }


    @Override
    public void draw() {

    }
}
