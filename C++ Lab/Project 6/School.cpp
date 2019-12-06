#include "School.h"
#include <string>
#include <iostream>


School::School(std::string n) : name{n}{}

School::~School() {
    std::cout << name << " school is being destroyed" << std::endl;
}

std::string School::get_name() {
    return name;
}

void School::set_name(std::string n) {
    name = n;
}
