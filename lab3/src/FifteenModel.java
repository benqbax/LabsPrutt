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

    private boolean inBounds(int x){
        boolean condition = (x >= 0) && (x < 4);
        return condition;
    }

    @Override
    public boolean move(int i, int j) {
        System.out.println(status[i-1][j]);
        boolean inBoundsX =inBounds(j+1);

        if(inBounds(i+1) && status[i+1][j] == null){
            System.out.println("good move1");
            status[i+1][j] = status[i][j];
            status[i][j] = null;
        }
        else if(inBounds(i-1) && status[i-1][j] == null){
            System.out.println("good move2");
            status[i-1][j] = status[i][j];
            status[i][j] = null;
        }
        else if(inBounds(j+1) && status[i][j+1]== null){
            System.out.println("good move3");
            status[i][j+1] = status[i][j];
            status[i][j] = null;
        }
        else if(inBounds(j-1) && status[i][j-1]== null){
            System.out.println("good move4");
            status[i][j-1] = status[i][j];
            status[i][j] = null;
        }

        else{
            System.out.println("nah");
        }

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
