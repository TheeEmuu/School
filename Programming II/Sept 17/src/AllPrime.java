import java.util.Scanner;

public class AllPrime {
    public static void main(String[] args){
        int bound;
        SetVector primes;
        Scanner input = new Scanner(System.in);

        System.out.print("Please input an upper bound for the primes calculation: ");
        bound = input.nextInt();

        primes = allPrimes(bound);

        System.out.print("The primes between 2 and " + bound + " are: [");
        for(int i =0; i < primes.size(); i++){
            System.out.print(primes.get(i) + ", ");
        }
        System.out.print("]\n");
    }

    protected static AbstractSet allPrimes(int N){
        SetVector primes = new SetVector();

        for(int i = 3; i < N; i++){
            if(isPrime(i))
                primes.add(i);
        }

        return primes;
    }

    protected static boolean isPrime(int a){
        if(a % 2 == 0)
            return false;

        for(int i = 3; i < Math.sqrt(a); i++){
            if(a % i ==0)
                return false;
        }

        return true;
    }
}
