import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener {
    private WorldPanel worldPanel;
    private WorkAreaPanel workAreaPanel;
    private ToolBoxPanel toolBox;

    public Game() {
        JFrame frame = new JFrame("SpiderWorld");
        frame.setLayout(new GridBagLayout());

        // Create the main panels
        JPanel northPanel = createPanel(Color.black);
        northPanel.setLayout(new FlowLayout());
        workAreaPanel = new WorkAreaPanel();
        worldPanel = new WorldPanel(1);
        toolBox = new ToolBoxPanel();

        JButton createTurn = new JButton("New Turn Block");
        JButton createStep = new JButton("New Step Block");
        JButton createRed = new JButton("New Paint Red Block");
        JButton createBlue = new JButton("New Paint Blue Block");
        JButton createGreen = new JButton("New Paint Green Block");

        JButton runButton = new JButton("Run");
        JButton stepButton = new JButton("Step");
        JButton turnButton = new JButton("Turn");
        JButton paintRed = new JButton("Red");
        JButton paintBlue = new JButton("Blue");
        JButton paintGreen = new JButton("Green");


        createTurn.addActionListener(this);
        createStep.addActionListener(this);
        createRed.addActionListener(this);
        createBlue.addActionListener(this);
        createGreen.addActionListener(this);

        runButton.addActionListener(this);
        stepButton.addActionListener(this);
        turnButton.addActionListener(this);
        paintRed.addActionListener(this);
        paintBlue.addActionListener(this);
        paintGreen.addActionListener(this);
        JButton levelone = new JButton("1");
        JButton leveltwo = new JButton("2");
        JButton levelthree = new JButton("3");
        levelone.addActionListener(this);
        leveltwo.addActionListener(this);
        levelthree.addActionListener(this);

        // Add the main panels to the frame with GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0; // Adjust the weightx value to make the east panel wider
        gbc.weighty = 0.1; // Adjust the weighty value to make the north panel taller
        gbc.fill = GridBagConstraints.BOTH;
        frame.add(northPanel, gbc);
        northPanel.add(runButton);
        northPanel.add(stepButton);
        northPanel.add(turnButton);
        northPanel.add(paintRed);
        northPanel.add(paintBlue);
        northPanel.add(paintGreen);
        northPanel.add(levelone);
        northPanel.add(leveltwo);
        northPanel.add(levelthree);

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
        westEastContainer.add(toolBox, eastGbc);
        toolBox.add(createTurn);
        toolBox.add(createStep);
        toolBox.add(createRed);
        toolBox.add(createBlue);
        toolBox.add(createGreen);

        // Set the default window size
        worldPanel.setPreferredSize(new Dimension(500, 700));
        frame.setPreferredSize(new Dimension(1400, 800));

        frame.pack();
        frame.setVisible(true);
    }

    private void switchLevel(int newLevelId)
    {
        worldPanel.setPreferredSize(new Dimension(500, 700));
            workAreaPanel.repaint();
            workAreaPanel.revalidate();

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
        // called once to create DataSource
        DataSource.getInstance();

        Game spiderWorld = new Game();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        boolean world = false;
        boolean work = false;
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("Run")) {
                //run blocks
                worldPanel.run();
                world = true;
            }
            else if (button.getText().equals("Step")) {
                //run blocks
                worldPanel.runSeparately(button.getText());
                repaint();
                world = true;
            }
            else if (button.getText().equals("Turn")) {
                //run blocks
                worldPanel.runSeparately(button.getText());
                repaint();
                world = true;
            }
            else if (button.getText().equals("Red")) {
                //run blocks
                worldPanel.runSeparately(button.getText());
                repaint();
                world = true;
            }
            else if (button.getText().equals("Blue")) {
                //run blocks
                worldPanel.runSeparately(button.getText());
                repaint();
                world = true;
            }
            else if (button.getText().equals("Green")) {
                //run blocks
                worldPanel.runSeparately(button.getText());
                repaint();
                world = true;
            }
            else if (button.getText().equals("New Turn Block")) {
                System.out.println("clicked");
                workAreaPanel.add(new DraggableBlockDecorator(new MoveBlock("turn", 85, 25), 85, 25));
                work = true;
            } else if (button.getText().equals("New Step Block")) {
                workAreaPanel.add(new DraggableBlockDecorator(new MoveBlock("step", 85, 25), 85, 25));
                work = true;
            } else if (button.getText().equals("New Paint Red Block")) {
                workAreaPanel.add(new DraggableBlockDecorator(new PaintBlock("paint red"), 85, 25));
                work = true;
            } else if (button.getText().equals("New Paint Blue Block")) {
                workAreaPanel.add(new DraggableBlockDecorator(new PaintBlock("paint blue"), 85, 25));
                work = true;
            } else if (button.getText().equals("New Paint Green Block")) {
                workAreaPanel.add(new DraggableBlockDecorator(new PaintBlock("paint green"), 85, 25));
                work = true;
            } else if (button.getText().equals("1"))
            {
                switchLevel(1);
            }
             else if (button.getText().equals("2"))
            {
                switchLevel(2);
            }
             else if (button.getText().equals("3"))
            {
                switchLevel(3);
            }
            worldPanel.setPreferredSize(new Dimension(500, 700));
            if (work == true) {
                workAreaPanel.repaint();
                workAreaPanel.revalidate();
            }
            if (world == true) {
                worldPanel.repaint();
                worldPanel.revalidate();
            }

        }
    }
}
