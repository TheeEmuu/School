using System;
using System.Collections.Generic;

delegate double ArrayAnalysisDelegate(List<double> x);

class Analysis{
    public static double Min(List<double> list){
        double min = list[0];

        foreach(double x in list){
            if(x < min)
                min = x;
        }

        return min;
    }

    public static double Max(List<double> list){
        double max = list[0];

        foreach(double x in list){
            if(x > max)
                max = x;
        }

        return max;
    }

    public static double Median(List<double> list){
        double middle = list.Count / 2;

        if(middle % 1 > 0)
            return list[(int)(middle - .5)];
        else
            return (list[(int)middle] + list[(int)middle - 1]) / 2;
    }

    public static double Average(List<double> list){
        double avg = 0;

        foreach(double x in list){
            avg += x;
        }

        return avg / list.Count;
    }

    public static double StandardDeviation(List<double> list){
        List<Double> squares = new List<Double>();
        double listMean = Average(list);

        foreach(double x in list){
            squares.Add(Math.Pow(x - listMean , 2));
        }

        return Math.Sqrt(Average(squares));
    }

    // static void Main(string[] args){
    //     ArrayAnalysisDelegate minimum = new ArrayAnalysisDelegate(Min);
    //     ArrayAnalysisDelegate maximum = new ArrayAnalysisDelegate(Max);
    //     ArrayAnalysisDelegate median = new ArrayAnalysisDelegate(Median);
    //     ArrayAnalysisDelegate average = new ArrayAnalysisDelegate(Average);
    //     ArrayAnalysisDelegate sd = new ArrayAnalysisDelegate(StandardDeviation);

    //     List<double> list = new List<double>() {1, 2, 3, 4, 5, 6};

    //     Console.WriteLine(minimum(list));
    //     Console.WriteLine(maximum(list));
    //     Console.WriteLine(median(list));
    //     Console.WriteLine(average(list));
    //     Console.WriteLine(sd(list));
    // }
}