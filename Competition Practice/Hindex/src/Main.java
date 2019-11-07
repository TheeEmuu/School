import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int papers = in.nextInt();
        long[] citations = new long[papers];

        for(int i = 0; i < papers; i++){
            citations[i] = in.nextInt();
        }

        Arrays.sort(citations);

        int above = 1;
        for(int i = papers - 1; papers > 0; i--) {
            if (citations[i] <= above) {
                System.out.println(citations[i]);
                break;
            }
            above++;
        }
        // 1 1 2 5 7
        // 1 1 3 5 7
        // 2 3 4
    }
}