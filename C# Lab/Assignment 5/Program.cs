using System;
using System.Collections.Generic;

delegate double ArrayAnalysisDelegate(List<Double> x);

class Program{
    static void Main(string[] args){
        ArrayAnalysisDelegate minimum = new ArrayAnalysisDelegate(Min);


    }
}
