import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButton extends JButton {
    private Color c1;
    private Color c2;
    private String s1;
    private String s2;

    public MyButton(Color c1, Color c2, String s1, String s2) {
        this.c1 = c1;
        this.c2 = c2;
        this.s1 = s1;
        this.s2 = s2;

        this.setText(s1);
        this.setBackground(c1);

        //makes sure the coloring is correct
        this.setOpaque(true);
        this.setBorderPainted(false);

        //set up actionlistener


    }
    void toggleState(){
        Color toggleColor = super.getBackground() == this.c1 ? this.c2 : this.c1;
        String toggleText = super.getText() == this.s1 ? this.s2 : this.s1;
        this.setText(toggleText);
        this.setBackground(toggleColor);
    }

    //* Called when a button is pressed and will trigger toggleState()*/

}
