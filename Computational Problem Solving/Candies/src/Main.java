import java.util.Scanner;

public class Main {
    // https://www.hackerrank.com/challenges/candies/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] scores = new int[n];
        for(int i = 0; i < n; i++){
            scores[i] = in.nextInt();
        }

        int[] candies = new int[n];

        if(n > 1 && scores[0] > scores[1])
            candies[0] = 2;
        else
            candies[0] = 1;

        for(int i = 1; i < n; i++){
            candies[i] = 1;
            if(scores[i] > scores[i-1])
                candies[i] = candies[i-1] + 1;
        }

        for(int i = n-1; i > 0; i--){
            if(scores[i] < scores[i-1])
                candies[i-1] = Math.max(candies[i-1], candies[i] + 1);
        }

        long total = 0;
        for(int candy : candies){
            total += candy;
        }

        System.out.println(total);
    }
}
