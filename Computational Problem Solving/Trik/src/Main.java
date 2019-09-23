import java.util.Scanner;

// https://open.kattis.com/problems/trik
public class Main {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);

        int[] location = new int[]{1, 0, 0};

        String moves = in.nextLine();

        int a, b;
        for(int i = 0; i < moves.length(); i++){
            Character move = moves.charAt(i);

            switch(move){
                case 'A':
                    a = location[0];
                    b = location[1];
                    location[0] = b;
                    location[1] = a;
                    break;
                case 'B':
                    a = location[1];
                    b = location[2];
                    location[1] = b;
                    location[2] = a;
                    break;
                case 'C':
                    a = location[0];
                    b = location[2];
                    location[0] = b;
                    location[2] = a;
                    break;
            }
        }

        int loc = 0;
        for(int i = 0; i < 3; i++){
            if(location[i] == 1){
                loc = i + 1;
            }
        }

        System.out.println(loc);
    }
}
