import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener {
    private WorldPanel worldPanel;
    private WorkAreaPanel workAreaPanel;
    public Game() {
        JFrame frame = new JFrame("SpiderWorld");
        frame.setLayout(new GridBagLayout());

        // Create the main panels
        JPanel northPanel = createPanel(Color.black);
        northPanel.setLayout(new FlowLayout());
        //JPanel westPanel = createPanel(Color.lightGray);
        //JPanel eastPanel = createPanel(Color.lightGray);
        workAreaPanel = new WorkAreaPanel();
        worldPanel = new WorldPanel();
        JButton runButton = new JButton("Run");
        JButton levelone = new JButton("1");
        JButton leveltwo = new JButton("2");

        // Add the main panels to the frame with GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0; // Adjust the weightx value to make the east panel wider
        gbc.weighty = 0.1; // Adjust the weighty value to make the north panel taller
        gbc.fill = GridBagConstraints.BOTH;
        frame.add(northPanel, gbc);
        northPanel.add(runButton);
        northPanel.add(levelone);
        northPanel.add(leveltwo);

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
        westEastContainer.add(worldPanel, westGbc);

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

    public static void main(String[] args) {
        Game spiderWorld = new Game();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("Run")) {
                //run blocks
                worldPanel.run(DataSource.getInstance().getBlocksRunnable());
            }
        }
    }
}
