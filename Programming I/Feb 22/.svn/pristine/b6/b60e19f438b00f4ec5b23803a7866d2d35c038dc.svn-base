import java.io.*;

public class SpeedyPrime {
    static boolean isPrime(int num){
        boolean test;
        double top = Math.sqrt(num) + 1;
        for (int i = 3; i <= top; i += 2){
            //If the number is divisible by any number, it's not prime
            test = num % i ==0;
            if (test)
                return false;
        }
        //Otherwise, the number must be prime
        return true;
    }

    public static void main (String[] args) throws Exception{
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        final long startTime = System.nanoTime();

        int max = 1000000;

        if (max > 2) {
            out.write(String.valueOf(2));
            out.write('\n');
        }

        for (int i = 3; i < max; i += 2){
            if(isPrime(i)) {
                out.write(String.valueOf(i) + '\n');
            }
        }
        out.flush();

        final long elapsedTime = System.nanoTime() - startTime;

        System.out.println("\nExecution finished in " + elapsedTime/1000000000.0 + " seconds");
    }
}