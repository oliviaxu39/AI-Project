/**
 * Created by margheritafirenze on 2/25/19.
 */
public class C4ProAI extends Player{


    /**
     * Constucts a new TTTPlayerProAI
     * @param name
     */
    public C4ProAI(String name) {
        super(name);
    }

    /**
     * Return the move location for the player
     * @param board the game board
     * @return the move location for the player
     */
    public String getMove(Board board) {
        MoveInfo mi = recMove( (C4Board) board, this.name, "", 0);
        return mi.getLoc();
    }

    /**
     * Performs the MinMax algorithm to determine the
     * move of this AI player.
     * @param board the game board
     * @param playerTurn the player moving
     * @return the MoveInfo for the move
     */
    private MoveInfo recMove(C4Board board, String playerTurn, String moveLoc, int depth) {
        MoveInfo max = new MoveInfo(moveLoc, -10);
        MoveInfo min = new MoveInfo(moveLoc, 10);
        depth=depth+1;
        if (board.isWinner("R")){
            return new MoveInfo(moveLoc, 10);}

        else if (board.isWinner("Y"))
            return new MoveInfo(moveLoc, -10);

        else if (board.getEmptyLocs().size()==0)
            return new MoveInfo(moveLoc, 0);

        else if (depth==6)
            if(nextMove((C4Board) board, "R")>nextMove((C4Board) board, "Y")){
                return new MoveInfo(moveLoc, nextMove((C4Board) board, "R"));
            }
            else{
                return new MoveInfo(moveLoc, nextMove((C4Board) board, "Y")*-1);
            }

        for (String s:board.getEmptyLocs()) {
            board.placePiece(s, playerTurn);
            if (playerTurn.equals("R")) {

                MoveInfo move = recMove(board, "Y", s, depth);
                if (move.getScore()>max.getScore())
                    max=new MoveInfo(s, move.getScore());
            }
            else {

                MoveInfo move = recMove(board, "R", s, depth);
                if (move.getScore()<min.getScore())
                    min=new MoveInfo(s, move.getScore());
            }
            board.retractPiece(s);
        }
        if (playerTurn.equals("R"))
            return max;
        else
            return min;
    }


    /**
     * getsMove
     * @param board the board of the game
     * @return location to move
     */
    public int nextMove(C4Board board, String player){
        int count=0;
        boolean done=false;
        for(String spot: board.getEmptyLocs()){
            done=false;

            board.placePiece(spot, player);

            for(int n=3; n<=5; n++){
                for(int i=0; i<=3; i++){
                    if(board.streakInNorthEastDiag(n, i, player, 4)){
                        done=true;
                        board.retractPiece(spot);
                        count++;
                    }
                }
            }

            for(int n=0; n<=2; n++){
                for(int i=0; i<=3; i++){
                    if(board.streakInSouthEastDiag(n, i, player, 4)){
                        done=true;
                        board.retractPiece(spot);
                        count++;
                    }
                }
            }

            for(int n=0; n<6; n++) {
                if (board.streakInRow(n, player,4)){
                    done=true;
                    board.retractPiece(spot);
                    count++;
                }
            }

            for(int n=0; n<7; n++) {
                if (board.streakInCol(n, player, 4)){
                    done=true;
                    board.retractPiece(spot);
                    count++;
                }
            }
            if(!done){
                board.retractPiece(spot);
            }

        }

        return count;
    }

}

