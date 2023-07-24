import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToolBoxPanel extends JPanel implements ActionListener {


    public ToolBoxPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
