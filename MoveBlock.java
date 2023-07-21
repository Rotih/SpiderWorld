import javax.swing.*;
import java.awt.*;

public class MoveBlock extends Block {
    public MoveBlock(String type) {
        super(type);
        setBackground(Color.GRAY);
    }

    @Override
    public void draw() {
        JLabel textLabel = new JLabel(label);
        textLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        // Add textLabel to the JPanel
        add(textLabel);
    }
}
