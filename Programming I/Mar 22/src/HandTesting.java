import java.util.Scanner;

public class HandTesting {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int cardsToDeal = in.nextInt();

        Deck deck = new Deck();
        deck.shuffle();
        Hand hand = new Hand();

        for(int i = 0; i < cardsToDeal; i++){
            hand.addCard(deck.dealCard());
            System.out.printf("%s of %s\n", hand.getCard(i).getValueAsString(), hand.getCard(i).getSuitAsString());
        }

        if(hand.isStraight())
            System.out.println(true);
        else
            System.out.println(false);
    }
}
