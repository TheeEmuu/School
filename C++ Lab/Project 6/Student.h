#ifndef PROJECT_6_STUDENT_H
#define PROJECT_6_STUDENT_H

#include <string>
#include <memory>
#include "School.h"

class Student {
    public:
        Student(std::string n, std::shared_ptr<School> s);
        ~Student();

        std::string get_name();
        std::string get_school_name();

    private:
        std::string name;
        std::shared_ptr<School> school;
};


#endif //PROJECT_6_STUDENT_H
