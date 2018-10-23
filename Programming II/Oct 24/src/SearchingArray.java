import java.util.Arrays;
import java.util.Scanner;

public class SearchingArray {
    private static int[] primes = new int[] {2,3,5,7,11,13,17,19,23,29};

    public static boolean search(int[] array, int num){
        int index = array.length/2;

        if(array[index] < num){
            return search(Arrays.copyOfRange(array, 0, index), num);
        }
        if(array[index] > num){
            return search(Arrays.copyOfRange(array, index, array.length), num);
        }

        return(array[index] == num);
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int term = input.nextInt();

        System.out.println(search(primes, term));

    }
}
