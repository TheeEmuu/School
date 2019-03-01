using System;
using System.Collections.Generic;

class MinimumValue{
    static void Main(string[] args){
        Console.Write("Please input a list of numbers seperated by a comma: ");
        string list = Console.ReadLine();

        string[] numbers = list.Split(",");

        List<int> numList = new List<int>();
        foreach(string value in numbers){
            numList.Add(Int32.Parse(value));
        }

        Console.WriteLine("The minimum of the list is " + minimum(numList));
        Console.WriteLine("The minimum of the modified list is " + minimumModify(numList));
    }

    static int minimum(List<int> list){
        int min = list[0];
        foreach(int value in list){
            if(value < min)
                min = value;
        }

        return min;
    }

    static int minimumModify(List<int> list){
        //Lists are passed by reference by default
        //this is so that (especially for large lists)
        //it doesn't have to be realocated when it is passed

        for(int i = 0; i < list.Count; i++){
            if(list[i] < list[list.Count - 1])
                list.Add(list[i]);
        }

        return list[list.Count - 1];
    }
}
