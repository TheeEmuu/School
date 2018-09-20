import java.util.Scanner;

public class Game {
    CoinStrip coins;
    boolean turn;
    Vector board;
    static String player1;
    static String player2;

    static Scanner input = new Scanner(System.in);

    public static void setup(){
        System.out.print("Please enter Player 1's name: ");
        player1 = input.next();
        System.out.print("\nPlease enter Player 2's name: ");
        player2 = input.next();
    }

    public void play(){
        coins = new CoinStrip();

        if((int)(Math.random() * 2) == 1){
            turn = true;
        }
        else
            turn = false;

        do {
            makeBoard();
            turn();
        }while(gameOver());

        System.out.print("Game over, ");
        //Players switch at the beginning of each turn, so check must be inverted
        if(!turn)
            System.out.println(player1 + " Wins!");
        else
            System.out.println(player2 + " Wins!");
    }

    private void makeBoard(){
        board = new Vector((int)coins.getCoinStrip().lastElement() + 1);

        for(int i = 0; i < (int)coins.getCoinStrip().lastElement() + 1; i++){
            board.add("-");
        }

        for(int i = 0; i < coins.getCoinStrip().size(); i++) {
            board.set(coins.getCoin(i), 0);
        }

        System.out.print("[");
        for(int i = 0; i < board.size(); i++){
            System.out.print(board.get(i));
        }
        System.out.print("]\n\n");
    }

    private boolean gameOver(){
        return (int)coins.getTotalCoins() != ((int)coins.getCoinStrip().lastElement() + 1);
    }

    private void turn(){
        int coinToMove;
        int moves;
        boolean legal;

        if(turn) {
            turn = false;
            System.out.println("It's " + player1 + "'s turn");
        }
        else {
            turn = true;
            System.out.println("It's " + player2 + "'s turn");
        }

        do {
            System.out.println("Make sure to input a legal move");

            System.out.print("What coin would you like to move? ");
            coinToMove = input.nextInt() - 1;
            System.out.print("\nHow many spaces would you like to move? ");
            moves = input.nextInt();

            legal = coins.move(coinToMove, moves);
        }while(!legal);
    }
}
