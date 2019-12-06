#include "Derived.h"
#include "Base.h"
#include <iostream>

Derived::Derived(int s, double w)  : Base(s), weight{w}{}

void Derived::adjust(){
    Base::adjust();
    weight *= 1.1;
}

Derived::~Derived(){
    std::cout << "Derived destroyed" << std::endl;
}

double Derived::print() {
    std::cout << "weight: " << weight << " ";
    Base::print();
}
