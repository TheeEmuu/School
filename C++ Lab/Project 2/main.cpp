#include <iostream>
#include <fstream>

int dValue(int avg, int min, int max);

int main() {
    std::string a, b;

    std::cout << "Please input a file to read from: ";
    std::cin >> a;
    std::cout << "Please input a file to output to: ";
    std::cin >> b;

    std::ifstream in(a);
    std::ofstream out(b);

    int filesize;
    in >> filesize;

    int x, arr[filesize];
    int index = 0;
    while(in >> x){
        arr[index] = x;
        index++;
    }

    int total = 0;
    int min = arr[0], max = arr[0];
    for(int x : arr){
        total = total + x;
        if(x > max)
            max = x;
        if(x < min)
            min = x;
    }
    int average = total / filesize;

    int d = dValue(average, min, max);

    index = 1;
    int output[sizeof(arr)];
    for(int x : arr){
        if(std::abs(x - average) < d * .75){
            output[index] = x;
            index++;
        }
    }

    output[0] = index - 1;
    for(int i = 0; i < index; i++){
        out << output[i] << std::endl;
    }

    return 0;
}

int dValue(int avg, int min, int max){
    if(max - avg > avg - min)
        return (max - avg);
    else
        return (avg - min);
}

