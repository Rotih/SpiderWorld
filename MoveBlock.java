import javax.swing.*;
import java.awt.*;

public class MoveBlock extends Block {
    public MoveBlock(String type) {
        super(type);
        setBackground(Color.GRAY);
    }

    @Override
    public void draw() {
        JLabel textLabel = new JLabel(type);
        textLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        add(textLabel);
    }
}
