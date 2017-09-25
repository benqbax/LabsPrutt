import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Main {
        public static void main(String[] args){
           // MyButton onButton = new MyButton(Color.white, Color.cyan, "On", "Off");
           // MyButton runButton = new MyButton(Color.green, Color.red, "Run", "Stop");
            frame frame = new frame();
            frame.setSize(400,400);

            //Kollar att första argumentet är en siffra
            if(!isNumeric(args[0])){
                System.out.println("The first argument must be a number!");
                System.exit(0);
            };
            int numberOfButtons = Integer.parseInt(args[0]);
            System.out.println("You want: " + numberOfButtons + " buttons");
            ArrayList<String> oddArgs = new ArrayList<String>();
            ArrayList<String> evenArgs = new ArrayList<String>();


            for(int i=1; i<args.length; i++){
                if(i%2==0){
                    oddArgs.add(args[i]);
                }
                else{
                    evenArgs.add(args[i]);
                }
            }
            //check if the arguments match the number of buttons, if not exit program
            if(args.length != (numberOfButtons*2) +1){
                System.out.println("You entered wrong number of arguments for the button!");
                System.exit(0);
            }

            for(int j=0; j<numberOfButtons; j++){
                MyButton newButton = new MyButton(Color.white, Color.cyan, evenArgs.get(j), oddArgs.get(j));
                frame.addButton(newButton);
            }
    }

    //tagen från stack overflow
    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }



}
