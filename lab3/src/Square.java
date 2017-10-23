import javafx.util.Pair;

import javax.swing.*;

public class Square extends JButton {

    private int x;
    private int y;
    private String number;

    public Square(int x, int y, String num) {
        super(String.valueOf(num));
        this.x = x;
        this.y = y;
    }

    public Pair getCoordinates(){
        return new Pair<>(x,y);
    }
}
