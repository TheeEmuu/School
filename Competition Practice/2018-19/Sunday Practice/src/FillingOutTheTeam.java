import java.util.Scanner;

public class FillingOutTheTeam {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        while (true) {
            double speed = input.nextDouble();
            int weight = input.nextInt();
            int strength = input.nextInt();

            if(speed == 0 && weight == 0 && strength == 0){
                break;
            }

            String position = "";

            //Wide Receiver
            if (speed <= 4.5 && weight >= 150 && strength >= 200) {
                position = position + "Wide Receiver ";
            }

            //Lineman
            if (speed <= 6.0 && weight >= 300 && strength >= 500) {
                position = position + "Lineman ";
            }
            //Quarterback
            if (speed <= 5.0 && weight >= 200 && strength >= 300) {
                position = position + "Quarterback ";
            }

            if (position.equals("")) {
                position = "No positions ";
            }

            System.out.println(position.substring(0, position.length() - 1));
        }
    }
}
