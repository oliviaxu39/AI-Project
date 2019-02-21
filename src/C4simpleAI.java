import java.util.Random;

/**
 * Created by oliviaxu on 2/20/19.
 */
public class C4simpleAI extends Player {
    public C4simpleAI(String name) {
        super(name);
    }


    public String getMove(Board board){
        if(nextMove((C4Board) board, "X").equals("")){
            System.out.println("true");
            return nextMove((C4Board) board,"X");
        }
        if(nextMove((C4Board) board, "O").equals("")){
            return nextMove((C4Board) board,"O");
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
    public String nextMove(C4Board board, String player){
        for(String spot: board.getEmptyLocs()){
            board.placePiece(spot, player);

            for(int n=3; n<=5; n++){
                for(int i=0; i<=3; i++){
                    if(board.streakInNorthEastDiag(n, i, player, 4)){
                        board.retractPiece(spot);
                        return spot;
                    }
                }
            }

            for(int n=0; n<=2; n++){
                for(int i=0; i<=3; i++){
                    if(board.streakInSouthEastDiag(n, i, player, 4)){
                        board.retractPiece(spot);
                        return spot;
                    }
                }
            }

            for(int n=0; n<6; n++) {
                if (board.streakInRow(n, player, 3)){
                    board.retractPiece(spot);
                    return spot;
                }
            }

            for(int n=0; n<7; n++) {
                if (board.streakInCol(n, player, 3)){
                    board.retractPiece(spot);
                    return spot;
                }
            }
            board.retractPiece(spot);
        }
        return "";
    }

}

