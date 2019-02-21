import java.util.ArrayList;

/**
 * Created by margheritafirenze on 2/20/19.
 */
public class C4Board extends Board {

    // Constants
    public static final int ROWS = 6;
    public static final int COLS = 7;

    /**
     * Constructs a 3x3 board for Tic Tac Toe and initializes
     * the board in the following format:
     * 123
     * 456
     * 789
     */
    public C4Board() {
        super(ROWS, COLS);

        int count = 1;
        for (int r = 0; r <= ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (r!=ROWS) {
                    set(r, c, "-");
                    count++;
                }
                else
                    set(r, c, Integer.toString(c+1));
            }
        }
    }

    /**
     * Places a player piece on the board at the given location.
     * @param loc the location to place the piece
     * @param player the player making the move
     */
    public void placePiece(String loc, String player) {
        int c=0;
        for (int r = ROWS-1; r >= 0; r++) {
            if (theBoard[r][Integer.parseInt(loc)].equals("-") && c==0) {
                theBoard[r][Integer.parseInt(loc)] = player;
                c=c+1;
            }
        }
    }

    /**
     * Retracts the piece at the given location.
     * @param loc the location to reset
     */
    public void retractPiece(String loc) {
        int currentLoc = 1;
        boolean done=false;
        int col=Integer.parseInt(loc);
        for (int r = 0; r < ROWS; r++) {
            if(theBoard[r][col]!="-" && !done){
                theBoard[r][col]="-";
                done=true;
            }

        }
    }

    /**
     * Returns the empty locations on the
     */
    public ArrayList<String> getEmptyLocs() {
        ArrayList<String> empty = new ArrayList<>();
        boolean all=false;
        for(int c = 0; c < theBoard[0].length; c++) {
            all=false;
            for(int r = 0; r < theBoard.length; r++) {
                if(theBoard[r][c].equals("R") && theBoard[r][c].equals("Y"))
                    all=true;
            }
            if(all){
                empty.add(c+"");
            }
        }

        return empty;
    }

    /**
     * Returns true if the given player wins the game in the
     * current state, false otherwise
     * @param player the player to check for a win
     */
    public boolean isWinner(String player) {

        // check rows for streak
        for(int i = 0; i < getRows(); i++) {
            if (streakInRow(i, player, 4) || streakInCol(i, player, 4))
                return true;
        }
        for(int n=3; n<=5; n++){
            for(int i=0; i<=3; i++){
                if(streakInNorthEastDiag(n, i, player, 4)){
                    return true;
                }
            }
        }
        for(int n=0; n<=2; n++){
            for(int i=0; i<=3; i++){
                if(streakInSouthEastDiag(n, i, player, 4)){
                    return true;
                }
            }
        }

        return false;
    }




    /**
     * Returns true if the game is over, false otherwise
     * @return true if the game is over, false otherwise
     */
    public boolean isGameOver() {
        if(isWinner("X") || isWinner("O") || getEmptyLocs().size() == 0)
            return true;
        else
            return false;

    }

}
