import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Player p1=new TTTsimpleAI("x");;
        boolean ishuman=false;
        Board b1 = new TTTBoard();

        Scanner in = new Scanner(System.in);
        System.out.println("What game would you like to play: human, simple AI, or proAI?");
        String s = in.nextLine();
        int n=-1;
        String player1="X";
        String player2="O";
        String piece = "X";
        if (s.equals("human"))
            ishuman=true;
        if(s.equals("pro AI"))
            p1=new TTTPlayerProAI("X");
        boolean check=true;
        while (check) {
            System.out.println(b1.toString());
            System.out.println("Where would you like to move? ");
            if(ishuman) {
                String s1 = in.nextLine();
                if(n==-1) {
                    piece = player1;
                }
                else{
                    piece = player2;
                }

                b1.placePiece(s1, piece);
                n=n*-1;
            }
            else{
                String ss=p1.getMove(b1);
                b1.placePiece(ss, "X");
            }
            if(!b1.isGameOver()){
                if(b1.isWinner(player1))
                    System.out.println("PLAYER 1 WINS");
                else
                    System.out.println("PLAYER 2 WINS");
                check=false;
            }
        }
    }
}
