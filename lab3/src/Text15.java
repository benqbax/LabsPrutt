import java.util.Scanner;

public class Text15 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Boardgame fifteen = new FifteenModel();                 // Model object is created
        //System.out.println("\nWelcome to fifteen puzzle\n");
        Boardgame tictactoe = new Tictactoe();

        //ViewControlFM vc = new ViewControlFM(fifteen,4, "FifteenModel");
    /*
        while (true) {
            // Print the current board
            for (int i=0; i<4; i++) {
                for (int j=0; j<4; j++)
                    System.out.print("  " + fifteen.getStatus(i,j)); // getStatus
                System.out.println();
            }
            System.out.println();
            System.out.print("Your move: ");
            int i = scan.nextInt();  // get an int number from terminal window
            int j = scan.nextInt();
            fifteen.move(i,j);	                             // move
            System.out.println(fifteen.getMessage());	     // getMessage
        } */


    }
}
