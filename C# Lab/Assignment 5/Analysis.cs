using System;
using System.Collections.Generic;

class Analysis{
    public double Min(List<double> list){
        double min = list[0];

        foreach(double x in list){
            if(x < min)
                min = x;
        }

        return min;
    }

    public double max(List<double> list){
        double max = list[0];

        foreach(double x in list){
            if(x > max)
                max = x;
        }

        return max;
    }

    public double median(List<double> list){
        double middle = list.Count / 2;

        if(middle % 1 > 0)
            return list[(int)(middle - .5)];
        else
            return (list[(int)middle] + list[(int)middle - 1]) / 2;
    }

    public double average(List<double> list){
        double avg = 0;

        foreach(double x in list){
            avg += x;
        }

        return avg / list.Count;
    }

    public double standardDeviation(List<double> list){
        List<Double> squares = new List<Double>();
        double listMean = average(list);

        foreach(double x in list){
            squares.Add(Math.Pow(x - listMean , 2));
        }

        return Math.Sqrt(average(squares));
    }
}