#include <fstream>
#include <iostream>
#include <map>

using namespace std;

int main(){
    ifstream ifs;
    ifs.open("D:\\Programming\\school\\C++ Lab\\Project 3\\final input");

    map<string, double> customers;
    map<string, double> items;

    string item_name;
    string customer_name;
    double price;

    while(ifs >> item_name >> customer_name >> price){
        customers[customer_name] += price;
        items[item_name] += price;
    }

    for(auto& entry : customers){
        cout << entry.first << " spent $" << entry.second << endl;
    }
    cout << endl;
    for(auto& entry : items){
        cout << entry.first << " raised $" << entry.second << endl;
    }

    return 0;
}

