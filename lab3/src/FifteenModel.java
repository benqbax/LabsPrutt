public class FifteenModel implements Boardgame {
    private String currentMessage = "No message yet";
    private String[][] status = new String[4][4];  // spelplanen
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

    private void shuffleBoard(){

    }

    @Override
    public boolean move(int i, int j) {
        return false;
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
        return null;
    }
}
