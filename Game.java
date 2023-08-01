import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener {
    private WorldPanel worldPanel;
    private WorkAreaPanel workAreaPanel;

    public Game() {
        JFrame frame = new JFrame("SpiderWorld");
        frame.setResizable(false);
        frame.setLayout(new GridBagLayout());

        // Create the main panels
        JPanel northPanel = createPanel(Color.black);
        northPanel.setLayout(new FlowLayout());
        workAreaPanel = new WorkAreaPanel();
        worldPanel = new WorldPanel(1);

        JButton runButton = new JButton("Run");
        JButton reset = new JButton("Reset");

        runButton.addActionListener(this);
        reset.addActionListener(this);

        JButton levelone = new JButton("1");
        JButton leveltwo = new JButton("2");
        JButton levelthree = new JButton("3");
        JButton levelfour = new JButton("4");
        JButton levelfive = new JButton("5");
        JButton levelsix = new JButton("6");
        JButton levelseven = new JButton("7");
        levelone.addActionListener(this);
        leveltwo.addActionListener(this);
        levelthree.addActionListener(this);
        levelfour.addActionListener(this);
        levelfive.addActionListener(this);
        levelsix.addActionListener(this);
        levelseven.addActionListener(this);

        // Add the main panels to the frame with GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0; // Adjust the weightx value to make the east panel wider
        gbc.weighty = 0.1; // Adjust the weighty value to make the north panel taller
        gbc.fill = GridBagConstraints.BOTH;
        frame.add(northPanel, gbc);
        northPanel.add(runButton);
        northPanel.add(reset);
        northPanel.add(levelone);
        northPanel.add(leveltwo);
        northPanel.add(levelthree);
        northPanel.add(levelfour);
        northPanel.add(levelfive);
        northPanel.add(levelsix);
        northPanel.add(levelseven);

        gbc.gridy = 1;
        gbc.weightx = 0.4; // (40% of the width)
        gbc.weighty = 0.6; // Adjust the weighty value to make the westEastContainer taller


        JPanel westEastContainer = new JPanel(new GridBagLayout());
        frame.add(westEastContainer, gbc);


        GridBagConstraints westGbc = new GridBagConstraints();
        westGbc.gridx = 0;
        westGbc.gridy = 0;
        westGbc.weightx = 0.5;
        westGbc.weighty = 1.0;
        westGbc.fill = GridBagConstraints.BOTH;
        westEastContainer.add(worldPanel, westGbc);

        GridBagConstraints centerGbc = new GridBagConstraints();
        centerGbc.gridx = 1;
        centerGbc.gridy = 0;
        centerGbc.weightx = 0.4;
        centerGbc.weighty = 1.0;
        centerGbc.fill = GridBagConstraints.BOTH;
        westEastContainer.add(workAreaPanel, centerGbc);

        GridBagConstraints eastGbc = new GridBagConstraints();
        eastGbc.gridx = 2;
        eastGbc.gridy = 0;
        eastGbc.weightx = 0.10;
        eastGbc.weighty = 1.0;
        eastGbc.fill = GridBagConstraints.BOTH;

        // Set the default window size
        worldPanel.setPreferredSize(new Dimension(500, 700));
        frame.setPreferredSize(new Dimension(1400, 800));
        frame.pack();
        frame.setVisible(true);
    }

    public void switchLevel(int newLevelId) {

        worldPanel.setPreferredSize(new Dimension(500, 700));
        workAreaPanel.resetWorkAreaPanel();

        worldPanel.setLevel(newLevelId);
        worldPanel.repaint();
        worldPanel.revalidate();

        DataSource.getInstance().resetConnectedBlocks();
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

    public void checkLevel() {
        boolean finished = worldPanel.check();
        if (finished) {

            if (DataSource.getInstance().getNumLevels() > worldPanel.getWorld().level)
                switchLevel(worldPanel.getWorld().level + 1);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("Run")) {
                worldPanel.run();
                checkLevel();
            } else if (button.getText().equals("Reset")) {
                worldPanel.reset();
            } else {
                switchLevel(Integer.parseInt(button.getText()));
            }
            worldPanel.setPreferredSize(new Dimension(500, 700));
            worldPanel.repaint();
            worldPanel.revalidate();
        }
    }
}

