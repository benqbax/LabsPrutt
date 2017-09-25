import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class frame extends JFrame implements ActionListener {
    private ArrayList<MyButton> buttonList = new ArrayList<MyButton>();
    public frame() {
        this.setLayout(new FlowLayout());
        this.getContentPane().setBackground(Color.pink);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    void addButton(MyButton button){
        button.addActionListener(this);
        buttonList.add(button);
        this.add(button);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(buttonList.contains(e.getSource())){
            int pressedIndex = buttonList.indexOf(e.getSource());
            for(int i=0; i<buttonList.size();i++){
                if(pressedIndex != i){
                    buttonList.get(i).toggleState();
                }
            }

        }
    }
}

