import java.awt.*;

public class Cell {
    public int id;
    public String color;
    enum Diamond {
        RED,
        BLUE,
        GREEN,
        DEFAULT
    }
    public Diamond aDiamond;
    public Spider spider;
    public int row;
    public int col;


    public Cell(int id, Diamond aDiamond, boolean spider, int row, int col){
        if (spider){
            this.spider = new Spider(row, col);
        }
        else{
            this.spider = null;
        }
        this.id = id;
        this.aDiamond = aDiamond;
        color = "black";
        this.row = row;
        this.col = col;
    }
    public void setColor(String color){
        this.color = color;

    }

    public void draw(Graphics g, int cellId, int row, int col){
        int width = 100;
        int height = 100;
        int diamondWidth = 20;
        int x = col * width;
        int y = row * height;
        int centerX = x + (width/2);
        int centerY = y + (height/2);
        int[] diamondX = {centerX-diamondWidth, centerX, centerX+diamondWidth, centerX};
        int[] diamondY = {centerY, centerY-diamondWidth, centerY, centerY+diamondWidth};

        //drawing Cell
        if (color.equals("black")){
            g.setColor(Color.BLACK);
        } else if (color.equals("red")) {
            g.setColor(Color.RED);
        }
        else if (color.equals("green")) {
            g.setColor(Color.GREEN);
        }
        else if (color.equals("blue")) {
            g.setColor(Color.BLUE);
        }

        g.fillRect(x, y, width, height);
        g.setColor(Color.WHITE);
        g.drawRect(x, y, width, height);


        //drawing diamond
        if (aDiamond == Diamond.RED){
            g.setColor(Color.RED);
            g.fillPolygon(diamondX, diamondY, 4);
        }
        else if (aDiamond == Diamond.BLUE) {
            g.setColor(Color.BLUE);
            g.fillPolygon(diamondX, diamondY, 4);
        }
        else if (aDiamond == Diamond.GREEN)  {
            g.setColor(Color.GREEN);
            g.fillPolygon(diamondX, diamondY, 4);
        }
        else{
        }

        //drawing spider
        if (spider != null){
            spider.draw(g, centerX-25, centerY-25);
        }
    }

}

