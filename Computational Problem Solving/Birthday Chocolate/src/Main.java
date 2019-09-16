import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    static int birthday(List<Integer> s, int d, int m) {
        int ways = 0;

        for(int i = 0; i < s.size() - m + 1; i++){
            int sum = 0;
            for(int k = i; k < m + i; k++){
                sum += s.get(k);
            }
            if(sum == d)
                ways++;
        }

        return ways;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int segments = in.nextInt();

        Vector<Integer> bar = new Vector<>();
        for(int i = 0; i < segments; i++)
            bar.add(in.nextInt());

        int day = in.nextInt();
        int month = in.nextInt();

        System.out.println(birthday(bar, day, month));
    }
}
