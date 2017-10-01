import java.util.Random;

public class FifteenModel implements Boardgame {
    private String currentMessage = "No message yet";
    private String[][] status = new String[4][4];  // spelplanen
    private int MIN_X=0;
    private int MIN_Y=0;
    private int MAX_X=1;
    private int MAX_Y=1;
    private int xemp, yemp;                        // index till den tomma rutan

    public FifteenModel() {
        //populate the board
        int number = 1;
        for (int i=0; i<4; i++) {
            for (int j = 0; j < 4; j++) {
                if(i==3 && j==3){
                   xemp=i;
                   yemp=j;
                }
                else{
                    status[i][j] = String.valueOf(number);
                }
                number++;
            }

        }
        shuffleBoard();

    }

    //https://stackoverflow.com/questions/20389890/generating-a-random-number-between-1-and-10-java
    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    private void shuffleBoard(){
        
    }

    private static boolean inBounds(int x){
        boolean condition = (x >= 0) && (x < 4);
        return condition;
    }

    @Override
    public boolean move(int i, int j) {
        if(!inBounds(i) && !inBounds(j)){
            currentMessage = "Please choose a position on the board!";
            return false;
        }

        if(inBounds(i+1) && status[i+1][j] == null){

            currentMessage="OK";

            //move the numbers
            status[i+1][j] = status[i][j];
            status[i][j] = null;

            //set the blank variables
            xemp = i;
            yemp = j;

        }
        else if(inBounds(i-1) && status[i-1][j] == null){
            currentMessage="OK";
            status[i-1][j] = status[i][j];
            status[i][j] = null;

            //set the blank variables
            xemp = i;
            yemp = j;
        }
        else if(inBounds(j+1) && status[i][j+1]== null){
            currentMessage="OK";
            status[i][j+1] = status[i][j];
            status[i][j] = null;

            //set the blank variables
            xemp = i;
            yemp = j;
        }
        else if(inBounds(j-1) && status[i][j-1]== null){
            currentMessage="OK";
            status[i][j-1] = status[i][j];
            status[i][j] = null;

            //set the blank variables
            xemp = i;
            yemp = j;
        }

        else{
            currentMessage="Please choose a position next to the empty one!";
            return false;
        }


        return true;
    }

    @Override
    public String getStatus(int i, int j) {
        if (status[i][j]==null){
            return " ";
        }
        return status[i][j];
    }

    @Override
    public String getMessage() {
        return currentMessage;
    }
}
