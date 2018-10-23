import java.util.Arrays;
import java.util.Scanner;

public class SearchingArray {
    private static int[] primes = new int[] {2,3,5,7,11,13,17,19,23,29};

    public static boolean search(int[] array, int num){
        int index = array.length/2;

        if(array[index] < num && num <= array[array.length - 1]){
            return search(Arrays.copyOfRange(array, index + 1, array.length - 1), num);
        }
        if(array[index] > num && num >= array[0]){
            return search(Arrays.copyOfRange(array, 0, index - 1), num);
        }

        return(array[index] == num);
    }

    private boolean search(int[] array, int num, int low, int high){

    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int term = input.nextInt();

        System.out.println(search(primes, term));
    }
}
