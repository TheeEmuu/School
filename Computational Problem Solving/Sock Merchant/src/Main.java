import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Main {
    static int indexOf(int[] array, int value, int startIndex){
        for(int i = startIndex; i < array.length; i++){
            if(array[i] == value)
                return i;
        }

        return -1;
    }

    static int sockMerchant(int n, int[] ar) {
        int totalPairs = 0;

        for(int i = 0; i < n; i++){
            int buddy = indexOf(ar, ar[i], i + 1);
            if(buddy != -1 && ar[i] != -1 && ar[buddy] > 0){
                totalPairs++;
                ar[buddy] = -1;
            }
            ar[i] = -1;
        }

        return totalPairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
