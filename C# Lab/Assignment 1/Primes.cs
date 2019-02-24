using System;

namespace Assignment_1
{
    class Primes
    {
        static void Main(string[] args)
        {
            int upper;

            Console.Write("Enter a number: ");

            upper = Convert.ToInt32(Console.ReadLine());

            for(int i = 2; i < upper; i++){
                if(isPrime(i))
                    Console.WriteLine(i);
            }
        }

        static bool isPrime(int x){
            x = Math.Abs(x);

            if(x == 2)
                return true;

            if(x % 2 == 0)
                return false;

            for(int i = 3; i < x; i = i + 2){
                if(x % i == 0)
                    return false;
            }

            return true;
        }
    }
}
