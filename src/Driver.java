import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Player p1=new TTTsimpleAI("P");
        boolean ishuman=false;
        Board b1 = new TTTBoard();

        Scanner in = new Scanner(System.in);
        System.out.println("What game would you like to play: human, simple AI, pro AI, or C4?");
        String s = in.nextLine();
        int n=1;
        String player1="X";
        String player2="O";
        String piece;
        if (s.equals("human"))
            ishuman=true;
        if (s.equals("simple AI"))
            p1=new TTTsimpleAI("X");
        if(s.equals("pro AI"))
            p1=new TTTPlayerProAI("X");
        if(s.equals("C4")) {
            p1 = new C4simpleAI("X");
            b1=new C4Board();
        }
        System.out.println(b1.toString());
        boolean check=true;
        while (check) {


            if(ishuman) {
                System.out.println("Where would you like to move? ");
                String s1 = in.nextLine();
                if(n==-1) {
                    piece = player1;
                }
                else{
                    piece = player2;
                }
                b1.placePiece(s1, piece);
                n=n*-1;
                System.out.println(b1.toString());
            }
            else{
                if(n==-1) {
                    System.out.println("Where would you like to move? ");
                    String s1 = in.nextLine();
                    //piece = player1;
                    b1.placePiece(s1, "O");
                    System.out.println(b1.toString());

                }
                else {
                    String ss = p1.getMove(b1);
                    b1.placePiece(ss, "X");

                    System.out.println(b1.toString());

                }
                n=n*-1;
            }
            if(b1.isGameOver()){
                if(b1.isWinner(player1))
                    System.out.println("PLAYER 1 WINS");
                else if (b1.isWinner(player2))
                    System.out.println("PLAYER 2 WINS");
                else
                    System.out.println("TIE");
                check=false;
            }
        }
    }
}
