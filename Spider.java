import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Spider
{
    // Rotation
    private int dir; // index in array of dirs
    private char[] dirs = {'N', 'E', 'S', 'W'};

    // Images
    private BufferedImage image;
    private BufferedImage[] images = new BufferedImage[4];

    // Constructor
    public Spider(int x, int y, int dir)
    {
        this.dir = dir;

        // assign the spider an image
        importImages();
        updateImage();
    }

    // Method designed to load all the spider images just once
    private void importImages()
    {
        String[] imagePaths =
        {
            "images/spider_north.png",
            "images/spider_east.png",
            "images/spider_south.png",
            "images/spider_west.png"
        };

        for (int i = 0; i < imagePaths.length; i++)
        {
            try {
                images[i] = ImageIO.read(new File(imagePaths[i]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Needs to be called whenever the spider turns (and initially!)
    private void updateImage() {
        image = images[dir];
    }

    // Will translate Spider's position according to current direction
    public void move()
    {
        DataSource.getInstance().get
        if (dir == 0)
            y++;
        else if (dir == 1)
            x++;
        else if (dir == 2)
            y--;
        else
            x--;
    }

    public void draw(Graphics g, int size) {
        g.drawImage(image, 0, 0, null);
    }

    // for use with the Turn button
    public void turn()
    {
        dir++;

        if (dir >= dirs.length)
            dir = 0;

        updateImage();
    }

    public void paintCell()
    {
        // should work with the World class
    }
}
