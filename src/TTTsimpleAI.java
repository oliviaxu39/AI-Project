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
        if(board.streakInNorthEastDiag(0,0,"O",2)){
            if(!board.get(0,0).equals("O") && !board.get(0,0).equals("X")){
                return "1";
            }
            if(!board.get(1,1).equals("O") && !board.get(1,1).equals("X")){
                return "5";
            }
            if(!board.get(2,2).equals("O") && !board.get(2,2).equals("X")){
                return "9";
            }
        }
        if(board.streakInSouthEastDiag(0,2,"O",2)){
            if(!board.get(0,2).equals("O") && !board.get(0,2).equals("X")){
                return "3";
            }
            if(!board.get(1,1).equals("O") && !board.get(1,1).equals("X")){
                return "5";
            }
            if(!board.get(2,0).equals("O") && !board.get(2,0).equals("X")){
                return "7";
            }
        }
        for(int n=0; n<2; n++){
            if(board.streakInCol(n,"O",2)){

                if(!board.get(0, n).equals("O") && !board.get(0, n).equals("X")){
                    return board.get(0,n).toString();
                }

                if(!board.get(1, n).equals("O") && !board.get(1, n).equals("X")){
                    return board.get(1, n).toString();
                }

                if(!board.get(2, n).equals("O") && !board.get(2,n).equals("X")){
                    return board.get(2, n).toString();
                }
            }
            if(board.streakInRow(n,"O",2)){
                System.out.println("yes");
                if(!board.get(n, 0).equals("O") &&!board.get(n,0).equals("X")){
                    return board.get(n,0).toString();
                }

                if(!board.get(n, 1).equals("O") && !board.get(n,1).equals("X")){
                    return board.get(n,1).toString();
                }

                if(!board.get(n, 2).equals("O")  && !board.get(n,2).equals("X")){

                    return board.get(n,2).toString();
                }
            }

        }

        int num=board.getEmptyLocs().size();
        Random rn =  new Random();
        int location= rn.nextInt(num);
        return board.getEmptyLocs().get(location)+"";

        }

    }


