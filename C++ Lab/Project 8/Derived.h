

#ifndef PROJECT_8_DERIVED_H
#define PROJECT_8_DERIVED_H


#include "Base.h"

class Derived : public Base{
public:
    Derived(int s, double w);
    ~Derived();
    void adjust();

    double print();
private:
    double weight;
};


#endif //PROJECT_8_DERIVED_H
