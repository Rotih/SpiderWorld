import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;


class TrashCan extends JLabel {
    public TrashCan(String imagePath) {
        try {
            ImageIcon icon = new ImageIcon(ImageIO.read(new File(imagePath)));
            setIcon(icon);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
