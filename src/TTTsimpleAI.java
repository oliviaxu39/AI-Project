import java.util.Random;

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
        if(nextMove((TTTBoard) board, "X")!=""){
            System.out.println("true");
            return nextMove((TTTBoard) board,"X");
        }
        if(nextMove((TTTBoard)board, "O")!=""){
            return nextMove((TTTBoard)board,"O");
        }
        else{
            int num=board.getEmptyLocs().size();
            Random rn= new Random();
            int location= rn.nextInt(num);
            return board.getEmptyLocs().get(location)+"" ;

        }
        }

    /**
     * getsMove
     * @param board the board of the game
     * @return location to move
     */
    public String nextMove(TTTBoard board, String player){
        for(String spot: board.getEmptyLocs()){
            board.placePiece(spot, player);
            if(board.streakInNorthEastDiag(2,0,player,3)==true){
                board.retractPiece(spot);
                return spot;
            }
            if(board.streakInSouthEastDiag(0,0,player,3)==true) {
                board.retractPiece(spot);
                return spot;
            }
            for(int n=0; n<3; n++) {
                if (board.streakInCol(n, player, 3)){
                    board.retractPiece(spot);
                    return spot;
                }
            }
            for(int n=0; n<3; n++) {
                if (board.streakInRow(n, player, 3)){
                    board.retractPiece(spot);
                    return spot;
                }
            }
            board.retractPiece(spot);
            }
            return "";
        }

    }


