import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNextInt()){
            int participants = in.nextInt();
            int budget = in.nextInt();
            int hotels = in.nextInt();
            int weeks = in.nextInt();

            int bestPrice = budget + 1;
            for(int i = 0; i < hotels; i++){
                int price = in.nextInt();
                boolean flag = false;
                for(int k = 0; k < weeks; i++){
                    if(in.nextInt() <= participants){
                        flag = true;
                    }
                }
                if(flag){
                    int stay = price * participants;
                    if(stay < bestPrice){
                        bestPrice = stay;
                    }
                }
            }

            if(bestPrice <= budget){
                System.out.println(bestPrice);
            }
            else{
                System.out.println("stay home");
            }
        }
    }
}
