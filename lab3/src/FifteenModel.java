import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Random;

public class FifteenModel implements Boardgame {
    private String currentMessage = "No message yet";
    private String[][] status = new String[4][4];  // spelplanen
    private int xemp, yemp;                        // index till den tomma rutan

    public FifteenModel() {
        //populate the board
        populateSortedBoard();
        //shuffles the board
        shuffleBoard();

    }


    /** Populates the board with sorted numbers
     */
    private void populateSortedBoard(){
        int n = 1;
        for (int x=0; x < 4; x++) {
            for (int y=0; y < 4; y++) {
                if (n < 10) {
                    status[x][y] = " " + Integer.toString(n);
                }
                else if (n > 9 && n < 16) {
                    status[x][y] = Integer.toString(n);
                } else {
                    xemp = x;
                    yemp = y;
                } n++;
            }
        }
    }

    //https://stackoverflow.com/questions/20389890/generating-a-random-number-between-1-and-10-java
    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    /**
     * shuffles the board with the help of valid movies
     */
    private void shuffleBoard(){
        ArrayList<Pair> validM;
        Pair newMove;
        Pair oldMove = new Pair<Integer, Integer>(xemp, yemp);
        for(int moves=0; moves<100;moves++){
            validM = validMoves(xemp, yemp);
            int randomIndex = randInt(0, validM.size()-1);
            newMove = validM.get(randomIndex);

            if(newMove.getValue()==oldMove.getValue() && newMove.getKey() == oldMove.getValue()){
                continue;
            }
            int left = (Integer) newMove.getKey();
            int right = (Integer) newMove.getValue();
            move(left, right);

            validM.clear();
        }
    }

    private ArrayList<Pair> validMoves(int x, int y){
        ArrayList<Pair> availableMoves = new ArrayList<Pair>();

        if(inBounds(x-1)){
            availableMoves.add(new Pair(x-1, y));
        }
        if(inBounds(x+1)){
            availableMoves.add(new Pair(x+1, y));
        }
        if(inBounds(y-1)){
            availableMoves.add(new Pair(x, y-1));

        }
        if(inBounds(y+1)){
            availableMoves.add(new Pair(x, y+1));
         }

         return availableMoves;

    }


    public void printBoard(){
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++)
                System.out.print("  " + getStatus(i,j)); // getStatus
            System.out.println();
        }
    }

    private static boolean inBounds(int x){
        boolean condition = (x >= 0) && (x < 4);
        return condition;
    }

    @Override
    public boolean move(int i, int j){
        if(!inBounds(i) || !inBounds(j)){
            currentMessage = "Please choose a position on the board!";
            return false;
        }
        ArrayList<Pair> availMoves = validMoves(xemp, yemp);
        if(availMoves.contains(new Pair(i,j))){
            currentMessage="OK";
            status[xemp][yemp]= status[i][j];
            status[i][j] = null;
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

