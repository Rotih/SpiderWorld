import javax.swing.*;
import java.awt.*;

public class PaintBlock extends Block {

    Color PaintCustom = new Color(199, 125, 72);
    public PaintBlock(String type) {
        super(type, 85, 25);
        setBackground(PaintCustom);
    }

    @Override
    public void draw() {
        JLabel textLabel = new JLabel(type);
        textLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        add(textLabel);
    }
}