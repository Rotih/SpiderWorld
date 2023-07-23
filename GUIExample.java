import javax.swing.*;
import java.awt.*;

public class GUIExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("GUI Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        // Create the main panels
        JPanel northPanel = createPanel( Color.black);
        JPanel westPanel = createPanel(Color.lightGray);
        //JPanel eastPanel = createPanel(Color.lightGray);
        WorkAreaPanel workAreaPanel = new WorkAreaPanel();

        // Add the main panels to the frame with GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0; // Adjust the weightx value to make the east panel wider
        gbc.weighty = 0.1; // Adjust the weighty value to make the north panel taller
        gbc.fill = GridBagConstraints.BOTH;
        frame.add(northPanel, gbc);

        gbc.gridy = 1;
        gbc.weightx = 0.4; // (40% of the width)
        gbc.weighty = 0.6; // Adjust the weighty value to make the westEastContainer taller


        JPanel westEastContainer = new JPanel(new GridBagLayout());
        frame.add(westEastContainer, gbc);


        GridBagConstraints westGbc = new GridBagConstraints();
        westGbc.gridx = 0;
        westGbc.gridy = 0;
        westGbc.weightx = 0.4;
        westGbc.weighty = 1.0;
        westGbc.fill = GridBagConstraints.BOTH;
        westEastContainer.add(westPanel, westGbc);

        GridBagConstraints eastGbc = new GridBagConstraints();
        eastGbc.gridx = 1;
        eastGbc.gridy = 0;
        eastGbc.weightx = 0.6;
        eastGbc.weighty = 1.0;
        eastGbc.fill = GridBagConstraints.BOTH;
        westEastContainer.add(workAreaPanel, eastGbc);

        // Set the default window size
        frame.setPreferredSize(new Dimension(1200, 750));

        frame.pack();
        frame.setVisible(true);
    }

    private static JPanel createPanel(Color color) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setLayout(new BorderLayout());


        return panel;
    }


}
