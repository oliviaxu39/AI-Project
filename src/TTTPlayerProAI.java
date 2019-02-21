import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;

public class TTTPlayerProAI extends Player {

    /**
     * Constucts a new TTTPlayerProAI
     * @param name
     */
    public TTTPlayerProAI(String name) {
        super(name);
    }

    /**
     * Return the move location for the player
     * @param board the game board
     * @return the move location for the player
     */
    public String getMove(Board board) {
        MoveInfo mi = recMove( (TTTBoard) board, this.name, "");
        return mi.getLoc();
    }

    /**
     * Performs the MinMax algorithm to determine the
     * move of this AI player.
     * @param board the game board
     * @param playerTurn the player moving
     * @return the MoveInfo for the move
     */
    private MoveInfo recMove(TTTBoard board, String playerTurn, String moveLoc) {
        MoveInfo max = new MoveInfo(moveLoc, -10);
        MoveInfo min = new MoveInfo(moveLoc, 10);

        if (board.isWinner("X"))
            return new MoveInfo(moveLoc, 10);
        else if (board.isWinner("O"))
            return new MoveInfo(moveLoc, -10);
        else if (board.getEmptyLocs().size()==0)
            return new MoveInfo(moveLoc, 0);

        for (String s:board.getEmptyLocs()) {
            board.placePiece(s, playerTurn);
            if (playerTurn.equals("X")) {

                MoveInfo move = recMove(board, "O", s);
                if (move.getScore()>max.getScore())
                    max=new MoveInfo(s, move.getScore());
            }
            else {

                MoveInfo move = recMove(board, "X", s);
                if (move.getScore()<min.getScore())
                    min=new MoveInfo(s, move.getScore());
            }
            board.retractPiece(s);
        }
        if (playerTurn.equals("X"))
            return max;
        else
            return min;
    }
}