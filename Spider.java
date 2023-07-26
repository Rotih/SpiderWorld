import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Spider
{
	// Location
	int row;
	int col;
	// Rotation
	public int dir; // index in array of dirs
	public char[] dirs = {'N', 'E', 'S', 'W'};

	// Images
	private BufferedImage image;
	private BufferedImage[] images = new BufferedImage[4];

	// Constructor
	public Spider(int row, int col)
	{
		this.dir = 0;
		this.row = row;
		this.col = col;
		// assign the spider an image
		importImages();
		updateImage();
	}

	// Method designed to load all the spider images just once
	private void importImages()
	{
		String[] imagePaths = {"images/spider_north.png", "images/spider_east.png", "images/spider_south.png", "images/spider_west.png"};

		for (int i = 0; i < imagePaths.length; i++) {
			try {
				images[i] = ImageIO.read(new File(imagePaths[i]));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// Needs to be called whenever the spider turns (and initially!)
	private void updateImage()
	{
		image = images[dir];
	}

	// Will translate Spider's position according to current direction
	public void move()
	{
		if (dir == 0) row--;
		else if (dir == 1) col++;
		else if (dir == 2) row++;
		else col--;
	}

	public void draw(Graphics g, int x, int y)
	{
		g.drawImage(image, x, y, null);
	}

	// for use with the Turn button
	public void turn()
	{
		dir++;

		if (dir >= dirs.length) dir = 0;

		updateImage();
	}
}
