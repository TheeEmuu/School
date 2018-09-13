public class Prime {
    static boolean isPrime(int num){
        //No prime numbers are below 2
        if (num < 2)
            return false;

            //Even numbers aren't prime
        else if (num % 2 == 0)
            return false;

            //Only need to check below the sqrt of the input, and brute force primes
        else{
            for (int i = 2; i <= Math.sqrt(num) + 1; i++){
                //If the number is divisible by any number, it's not prime
                if (num % i == 0)
                    return false;
            }
            //Otherwise, the number must be prime
            return true;
        }
    }
    public static void main (String[] args){
        int max = 1000000;
        for (int i = 0; i < max; i++){
            if(isPrime(i))
                System.out.println(i);
        }
    }
}
