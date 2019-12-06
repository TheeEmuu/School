

#ifndef PROJECT_6_SCHOOL_H
#define PROJECT_6_SCHOOL_H


#include <string>

class School {
public:
    School(std::string n);
    ~School();

    std::string get_name();
    void set_name(std::string n);

private:
    std::string name;
};


#endif //PROJECT_6_SCHOOL_H
