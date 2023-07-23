import javax.swing.*;
import java.awt.*;

public abstract class Block extends JPanel {
    protected String type;

    public Block(String type, int width, int height) {
        this.type = type;
        setPreferredSize(new Dimension(width, height));
        setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add black outline
    }

    public abstract void draw();

    public String getType() {
        return type;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());


        g.setColor(Color.BLACK);
        Font boldFont = new Font("Arial", Font.BOLD, 16);
        g.setFont(boldFont);
        FontMetrics fontMetrics = g.getFontMetrics();
        int labelWidth = fontMetrics.stringWidth(type);
        int labelHeight = fontMetrics.getHeight();
        int labelX = (getWidth() - labelWidth) / 2;
        int labelY = (getHeight() + labelHeight) / 2 - fontMetrics.getDescent();
        g.drawString(type, labelX, labelY);
    }
}
