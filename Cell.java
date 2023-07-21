public class Cell {
    public int id;
    enum Diamond {
        RED,
        BLUE,
        GREEN,
        DEFAULT
    }
    public Diamond aDiamond;
    public boolean spider;

    public Cell(int id, Diamond aDiamond, boolean spider){
        this.id = id;
        this.aDiamond = aDiamond;
        this.spider = spider;
    }





}
