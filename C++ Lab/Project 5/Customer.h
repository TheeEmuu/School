#ifndef PROJECT_5_CUSTOMER_H
#define PROJECT_5_CUSTOMER_H

#include <string>

class Customer {
public:
    Customer(std::string name);
    Customer(std::string name, double balance);

    double transaction(double value);
private:
    std::string customer_name;
public:
    void setCustomerBalance(double customerBalance);

private:
    double customer_balance;
public:
    const std::string &getCustomerName() const;

    double getCustomerBalance() const;
};


#endif //PROJECT_5_CUSTOMER_H
