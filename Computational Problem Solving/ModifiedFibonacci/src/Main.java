import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        BigInteger t1 = BigInteger.valueOf(in.nextInt());
        BigInteger t2 = BigInteger.valueOf(in.nextInt());
        int n = in.nextInt();

        BigInteger[] nums = new BigInteger[n];

        nums[0] = t1;
        nums[1] = t2;
        System.out.println(fib(n, nums));
    }

    public static BigInteger fib(int n, BigInteger[] nums){
        for(int i = 2; i < n; i++){
            nums[i] = nums[i - 2].add(nums[i - 1].pow(2));
        }

        return nums[n - 1];
    }
}
