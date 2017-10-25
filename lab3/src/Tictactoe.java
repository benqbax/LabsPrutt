import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Random;

public class Tictactoe implements Boardgame {
    private String currentMessage = "Player X starts the game!";
    private String[][] status = new String[3][3];  // spelplanen
    private int xemp, yemp;                        // index till den tomma rutan
    private int count = 1;
    private boolean mark = false;
    private String currentPlayer = "X";

    public Tictactoe() { }


    /**
     * Populates the board with sorted numbers
     */
    private void populateBoard() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                status[x][y] = null;
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
    private void setCurrentPlayer() {
        currentPlayer = currentPlayer == "X" ? "O" : "X";
    }

    private boolean phaseOne(int i, int j) {
        if (getStatus(i, j) == null) {
            currentMessage = "Good move!";
            if (count % 2 != 0) {
                status[i][j] = "X";
            } else {
                status[i][j] = "O";
            }
            count++;
        } else {
            currentMessage = "Not a valid pick, choose another tile";
            return false;
        }
        return true;
    }

    private boolean phaseTwo(int i, int j) {
        if (getStatus(i, j) == null && !mark) {
            currentMessage = "Choose a marker!";
            return false;
        }
        if (!mark && getStatus(i, j) == currentPlayer) {
            //marking
            xemp = i;
            yemp = j;
            mark = true;
            currentMessage = "Tile:" + i + ", " + j + " was marked";
        } else {
            //check that the tile is empty
            if (getStatus(i, j) == null) {
                status[i][j] = status[xemp][yemp];
                status[xemp][yemp] = null;
                setCurrentPlayer();
                count++;
                mark = false;
            } else {
                currentMessage = "You choose the wrong marker, it's  " + currentPlayer + "'s turn";
            }
        }
        return true;
    }


    @Override
    public boolean move(int i, int j) {
        System.out.println("Count is:" + count);
        if (count > 6) {
            //fas 2
            return phaseTwo(i, j);
        } else {
            return phaseOne(i, j);
        }

    }


    @Override
    public String getStatus(int i, int j) {
        return status[i][j];
    }

    @Override
    public String getMessage() {
        return currentMessage;
    }
}

