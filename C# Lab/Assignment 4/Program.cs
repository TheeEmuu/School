using System;

class Program{
    static void Main(string[] args){
        Fraction a = new Fraction(1, 5);
		Fraction b = new Fraction(2, 5);

		Console.WriteLine((a + b).toString());
        Console.WriteLine((a - b).toString());
        Console.WriteLine((a * b).toString());
        Console.WriteLine((a / b).toString());
    }
}
