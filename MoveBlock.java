import javax.swing.*;
import java.awt.*;

public class MoveBlock extends Block {

    Color PaintCustom = new Color(199, 125, 72);
    Color ConnectCustom = new Color(169, 196, 219);
    public MoveBlock(String type) {
        super(type, 85, 15);
        if(type.equals("Connect Here"))
        {
            setBackground(ConnectCustom);
        }
        else if(type.contains("paint")){
            setBackground(PaintCustom);
        }
    }


}
