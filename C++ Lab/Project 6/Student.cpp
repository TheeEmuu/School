#include "Student.h"

#include <string>
#include <iostream>

Student::Student(std::string name, std::shared_ptr<School> school) : name{name}, school{school} {}

Student::~Student() {
    std::cout << name << " student is being destroyed" << std::endl;
}

std::string Student::get_name() {
    return name;
}

std::string Student::get_school_name() {
    return school->get_name();
}

