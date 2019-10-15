#include "Customer.h"
#include <string>

Customer::Customer(std::string name) : customer_name{name}, customer_balance{0}{

}

Customer::Customer(std::string name, double balance) : customer_name{name}, customer_balance{balance} {

}

double Customer::transaction(double value) {
    Customer::customer_balance += value;
}

const std::string &Customer::getCustomerName() const {
    return customer_name;
}

double Customer::getCustomerBalance() const {
    return customer_balance;
}

void Customer::setCustomerBalance(double customerBalance) {
    customer_balance = customerBalance;
}
