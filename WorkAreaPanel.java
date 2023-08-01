import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class WorkAreaPanel extends JPanel implements MouseListener, ActionListener {
    private Block connectHere;
    private JButton step;
    private JButton turn;
    private JButton red;
    private JButton blue;
    private JButton black;
    private JButton green;
    private ArrayList<Block> blocksOnScreen;
    Color PaintCustom = new Color(199, 125, 72);

    public WorkAreaPanel() {
        setLayout(null); // Set the layout manager to null for absolute positioning
        setBackground(Color.WHITE);
        blocksOnScreen = new ArrayList<>();

        connectHere = new DraggableBlockDecorator(new MoveBlock("Connect Here"), 150, 25);
        connectHere.setBounds(175, 15, 150, 25);
        this.add(connectHere);

        step = createButton("Step", 630, 15, 85, 25, Color.GRAY);
        turn = createButton("Turn", 630, 55, 85, 25, Color.GRAY);
        red = createButton("Paint Red", 630, 95, 150, 25, PaintCustom);
        blue = createButton("Paint Blue", 630, 135, 150, 25, PaintCustom);
        black = createButton("Paint Black", 630, 215, 150, 25, PaintCustom);
        green = createButton("Paint Green", 630, 175, 150, 25, PaintCustom);

        setPreferredSize(new Dimension(800, 600));

        TrashCan trashCan = new TrashCan("images/trash.png");
        trashCan.setBounds(15, 625, 100, 100); // Adjust the position and size as needed
        add(trashCan);

        step.addMouseListener(this);
        turn.addMouseListener(this);
        red.addMouseListener(this);
        blue.addMouseListener(this);
        black.addMouseListener(this);
        green.addMouseListener(this);
    }
    private JButton createButton(String text, int x, int y, int width, int height, Color color) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.addActionListener(this);
        this.add(button);
        return button;
    }
    public void resetWorkAreaPanel() {
        for (Block block : blocksOnScreen) {
            this.remove(block);
        }
        blocksOnScreen.clear();
        this.revalidate();
        this.repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int rectWidth = getWidth() * 30 / 100;
        int rectHeight = getHeight();
        int rectX = getWidth() - rectWidth;
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(rectX, 0, rectWidth, rectHeight);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == step) {
            Block newStepBlock = new DraggableBlockDecorator(new MoveBlock("step"), 85, 15);
            newStepBlock.setBounds(470, 570, 85, 25);
            this.add(newStepBlock);
            blocksOnScreen.add(newStepBlock);
            this.revalidate();
            this.repaint();
        } else if (e.getSource() == turn) {
            Block newBlock = new DraggableBlockDecorator(new MoveBlock("turn"), 85, 15);
            newBlock.setBounds(470, 570, 85, 25);
            this.add(newBlock);
            blocksOnScreen.add(newBlock);
            this.revalidate();
            this.repaint();
        } else if (e.getSource() == black) {
            Block pBlack = new DraggableBlockDecorator(new MoveBlock("paint black"), 85, 15);
            pBlack.setBounds(470, 570, 85, 25);
            this.add(pBlack);
            blocksOnScreen.add(pBlack);
            this.revalidate();
            this.repaint();
        } else if (e.getSource() == blue) {
            Block pBlue = new DraggableBlockDecorator(new MoveBlock("paint blue"), 85, 15);
            pBlue.setBounds(470, 570, 85, 25);
            this.add(pBlue);
            blocksOnScreen.add(pBlue);
            this.revalidate();
            this.repaint();
        } else if (e.getSource() == green) {
            Block pGreen = new DraggableBlockDecorator(new MoveBlock("paint green"), 85, 15);
            pGreen.setBounds(470, 570, 85, 25);
            this.add(pGreen);
            blocksOnScreen.add(pGreen);
            this.revalidate();
            this.repaint();
        } else if (e.getSource() == red) {
            Block pRed = new DraggableBlockDecorator(new MoveBlock("paint red"), 85, 10);
            pRed.setBounds(470, 570, 85, 25);
            this.add(pRed);
            blocksOnScreen.add(pRed);
            this.revalidate();
            this.repaint();
        }
    }
}
