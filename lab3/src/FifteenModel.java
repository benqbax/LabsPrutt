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

    private void shuffleBoard(){

    }

    private boolean outOfBounds(int x){
        boolean inBoundsX = (x >= 0) && (x < 4);
        return inBoundsX;
    }

    @Override
    public boolean move(int i, int j) {
        System.out.println(status[i-1][j]);
        boolean inBoundsX =outOfBounds(j+1);

        

        System.out.println(inBoundsX);
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
