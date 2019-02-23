import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Player p1=new TTTsimpleAI("P");
        boolean ishumanT=false;
        boolean isHumanC=false;
        Board b1 = new TTTBoard();
        int count = 1;

        Scanner in = new Scanner(System.in);
        System.out.println("What game would you like to play, enter a number:");
        System.out.println("1. Tic Tac Toe (Human VS Human)");
        System.out.println("2. Tic Tac Toe (Human VS Simple AI)");
        System.out.println("3. Tic Tac Toe (Human VS Pro AI)");
        System.out.println("4. Connect Four (Human VS Human)");
        System.out.println("5. Connect Four (Human VS Simple AI)");

        String s = in.nextLine();
        int n=1;
        String player1="X";
        String player2="O";
        String piece;
        boolean isC4=false;
        if (s.equals("1"))
            ishumanT=true;
        if (s.equals("2"))
            p1=new TTTsimpleAI("X");
        if(s.equals("3"))
            p1=new TTTPlayerProAI("X");
        if(s.equals("4")){
            isHumanC=true;
            b1=new C4Board();
            player1="R";
            player2="Y";
        }
        if(s.equals("5")) {
            p1 = new C4simpleAI("X");
            b1=new C4Board();
            isC4=true;
            player1="R";
            player2="Y";
        }
        if(isC4 || isHumanC){
            System.out.println("1234567");
        }
        System.out.println(b1.toString());
        boolean check=true;
        while (check) {
            if(ishumanT || isHumanC) {
                System.out.println("Where would you like to move? ");
                if(isHumanC){
                    System.out.println("1234567");
                    System.out.println(b1.toString());
                }

                String s1 = in.nextLine();

                if(n==1) {
                    piece = player1;
                }
                else{
                    piece = player2;
                }
                if (isHumanC) {
                    int pt = Integer.parseInt(s1) - 1;
                    b1.placePiece(pt + "", piece);
                }
                else
                    b1.placePiece(s1, piece);
                n=n*-1;
                System.out.println(b1.toString());
            }
            else{
                if(n==-1) {
                    System.out.println("Where would you like to move? ");
                    if(isC4){
                        System.out.println("1234567");
                        System.out.println(b1.toString());
                    }

                    String s1 = in.nextLine();
                    //piece = player1;
                    if(isC4){
                        int pt=Integer.parseInt(s1)-1;
                        b1.placePiece(pt+"", "Y");
                    }
                    else {
                        b1.placePiece(s1, "O");
                    }
                }
                else {
                    String ss = p1.getMove(b1);
                    if(isC4){
                        b1.placePiece(ss, "R");
                    }
                    else {
                        b1.placePiece(ss, "X");
                    }
                    System.out.println(b1.toString());

                }
                n=n*-1;
            }

            if(b1.isGameOver()){
                if(b1.isWinner(player1))
                    if(isC4){
                        System.out.println(b1.toString());
                    }
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
