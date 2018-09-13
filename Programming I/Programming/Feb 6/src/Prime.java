public class Prime {

    static boolean isPrime(int num){
        if (num < 2)
            return false;
        else if (num % 2 == 0)
            return false;
        else{
            for (int i = 2; i <= Math.sqrt(num) + 1; i++){
                if (num % i == 0)
                    return false;
            }
            return true;
        }
    }

    public static void main(String [] args){
        int a;
        int i;
        int lowPrime, highPrime;

        System.out.print("Please input a number: ");
        a = TextIO.getInt();

        if (isPrime(a)) {
            lowPrime = a;
            highPrime = a;
        }
        else {
            for (i = a; i > 0; i--) {
                if (isPrime(i))
                    lowPrime = i;
            }

            for (i = a;; i++){
                if (isPrime(i))
                    highPrime = i;
            }
        }

        System.out.printf("\nThe largest prime under %d is %d. \nThe smallest prime over %d is %d.", a, lowPrime, a, highPrime);
    }
}
