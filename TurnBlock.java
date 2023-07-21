import javax.swing.*;
import java.awt.*;

public class TurnBlock extends Block {
    public TurnBlock() {
        super("Turn");
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
