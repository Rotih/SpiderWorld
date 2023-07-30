import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class Block extends JPanel {
    protected String type;

    public Block(String type, int width, int height) {
        this.type = type;
        setBackground(Color.gray);
        setPreferredSize(new Dimension(width, height));
        setBorder(BorderFactory.createLineBorder(Color.darkGray));
    }


    public String getType() {
        return type;
    }

    protected void removeBlock() {
        Container parentContainer = getParent();
        if (parentContainer != null) {
            parentContainer.remove(this);
            DataSource.getInstance().getConnectedBlocks().remove(this);
            parentContainer.revalidate();
            parentContainer.repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.WHITE);
        Font boldFont = new Font("Arial", Font.BOLD, 12);
        g.setFont(boldFont);
        FontMetrics fontMetrics = g.getFontMetrics();
        int labelWidth = fontMetrics.stringWidth(type);
        int labelHeight = fontMetrics.getHeight();
        int labelX = (getWidth() - labelWidth) / 2;
        int labelY = (getHeight() + labelHeight) / 2 - fontMetrics.getDescent();
        g.drawString(type, labelX, labelY);
    }

}
