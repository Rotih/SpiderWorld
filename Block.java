import javax.swing.*;
import java.awt.*;

public abstract class Block extends JPanel {
    protected String label; // Text inside the block

    public Block(String label) {
        this.label = label;
        setPreferredSize(new Dimension(70, 40));
    }

    public abstract void draw();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the block background
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw the label
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 18));
        FontMetrics fontMetrics = g.getFontMetrics();
        int labelWidth = fontMetrics.stringWidth(label);
        int labelHeight = fontMetrics.getHeight();
        int labelX = (getWidth() - labelWidth) / 2;
        int labelY = (getHeight() + labelHeight) / 2 - fontMetrics.getDescent();
        g.drawString(label, labelX, labelY);
    }
}
