import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Main {
        public static void main(String[] args){
            MyButton onButton = new MyButton(Color.white, Color.cyan, "On", "Off");
            MyButton runButton = new MyButton(Color.green, Color.red, "Run", "Stop");
            frame frame = new frame();
            frame.setSize(400,400);

            frame.add(onButton);
            frame.add(runButton);
    }



}
