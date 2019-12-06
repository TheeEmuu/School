#include "Base.h"
#include <iostream>

Base::Base(int s) : size{s}{}

void Base::adjust() {
    size += 42;
}

Base::~Base(){
    std::cout << "Base Destroyed" << std::endl;
}

double Base::print() {
    std::cout << "size: " << size << std::endl;
}