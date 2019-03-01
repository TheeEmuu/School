using System;
using System.Collections.Generic;

class VowelCount{
    static void Main(){
        int total = 0;

        var vowels = new HashSet<char> {'a', 'e', 'i', 'o', 'u'};

        Console.Write("Please input a sentence: ");
        string input = Console.ReadLine();

        for(int i = 0; i < input.Length; i++){
            if(vowels.Contains(input[i]))
                total++;
        }

        Console.WriteLine("There are " + total + " vowels in the sentence");
    }
}