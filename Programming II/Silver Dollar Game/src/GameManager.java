import java.util.Scanner;

public class GameManager {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        Game.setup();

        do {
            Game game = new Game();
            game.play();
        }while(playAgain());
    }

    private static boolean playAgain(){
        String answer;

        System.out.println("Would you like to play again? (y/n)");
        answer = input.next();

        return (answer.equals("y") || answer.equals("Y"));
    }
}
