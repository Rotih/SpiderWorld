import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Diamond
{
    private BufferedImage image;
    private Color c;
    // I don't believe this needs coordinates as its position is dependent on cell

    public Diamond(Color c)
    {
        this.c = c;

        loadImage();
    }

    // TODO need either make my own images or use ASCII
    private void loadImage()
    {
        try {
            image = ImageIO.read(new File("images/diamond.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g, int size) {
        g.drawImage(image, 0, 0, null);
    }
}
