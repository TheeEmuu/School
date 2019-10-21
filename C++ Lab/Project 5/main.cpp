#include <iostream>
#include <fstream>
#include <vector>
#include "Customer.h"

using namespace std;

int main() {
    ifstream ifs;
    ifs.open("D:\\Programming\\school\\C++ Lab\\Project 5\\customers");

    vector<Customer> customers;

    string name;
    double amount;
    while(ifs >> name >> amount){
        customers.push_back(Customer(name, amount));
    }
    ifs.close();

    ifs.open("D:\\Programming\\school\\C++ Lab\\Project 5\\transactions");
    while(ifs >> name >> amount){
        for(int i = 0; i < customers.size(); i++) {
            if(customers[i].getCustomerName() == name) {
                customers[i].setCustomerBalance(customers[i].getCustomerBalance() + amount);
            }
        }
    }
    ifs.close();

    for(auto x : customers){
        if(x.getCustomerBalance() < 0)
            cout << x.getCustomerName() << endl;
    }
    return 0;
}