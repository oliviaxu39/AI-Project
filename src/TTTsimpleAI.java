/**
 * Created by margheritafirenze on 2/6/19.
 */
public class TTTsimpleAI extends Player {

    /**
     * Constucts a new HumanPlayer
     * @param name
     */
    public TTTsimpleAI(String name) {
        super(name);
    }

    /**
     * getsMove
     * @param board the board of the game
     * @return location to move
     */
    public String getMove(Board board){
        for(int n=0; n<2; n++){
            if(board.streakInCol(n,"O",2)){
                for(int x=0; x<2; x++){
                    if(board.get(x, n).equals("X") || board.get(x, n).equals("O") );
                }
            }
        }
        return "";
    }
}
