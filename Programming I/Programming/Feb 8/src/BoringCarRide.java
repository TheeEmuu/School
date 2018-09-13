public class BoringCarRide {
    public static void main(String[] args){
        int guess;
        int number = (int)(1000*Math.random());

        for(;;){
            System.out.print("Please guess a number: ");
            guess = TextIO.getInt();

            if (guess == number)
                break;
            else if (guess < number)
                System.out.println("Higher\n");
            else if (guess > number)
                System.out.println("Lower\n");
            else
                System.out.println("ERROR");
        }

        System.out.println("Correct!");
    }
}
