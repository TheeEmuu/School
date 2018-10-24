import java.util.Arrays;
import java.util.Scanner;

public class SearchingArray {
    private static int[] primes = new int[] {2,3,5,7,11,13,17,19,23,29};

    public static int search(int[] array, int num){
        if(num > array[array.length-1] || num < array[0])
            return -1;
        return (search(array, num, 0, array.length-1));
    }

    private static int search(int[] array, int num, int low, int high){
        int index = (high-low) + low;

        if(index < 0)
            return -1;

        if(array[index] < num) {
            //Num is above index, so index + 1 becomes new low
            return search(array, num, index + 1, high);
        }
        if(array[index] > num) {
            //Num is below index, thus index - 1 becomes new high
            return search(array, num, low, index - 1);
        }
        return index;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int term = input.nextInt();

        System.out.printf("%d found at %d", term, search(primes, term));
    }
}
