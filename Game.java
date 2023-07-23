import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener {
    private WorldPanel worldPanel;
    private WorkAreaPanel workAreaPanel;
    public Game() {
        super("SpiderWorld");
        setLayout(new BorderLayout());

        workAreaPanel = new WorkAreaPanel();
        workAreaPanel.addMouseListener(workAreaPanel);

        JButton runButton = new JButton("Run");
        runButton.addActionListener(this);
        workAreaPanel.add(runButton);

        worldPanel = new WorldPanel();
        worldPanel.addMouseListener(worldPanel);

        add(worldPanel, BorderLayout.CENTER);
        add(workAreaPanel, BorderLayout.LINE_END);
    }
    public static void main(String[] args) {
        Game spiderWorld = new Game();
        spiderWorld.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        spiderWorld.setSize(1200, 750);
        spiderWorld.setVisible(true);
        spiderWorld.setResizable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("Run")) {
                //run blocks
                repaint();
            }
        }
    }
}
