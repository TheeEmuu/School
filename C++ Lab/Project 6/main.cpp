#include <iostream>
#include <vector>

#include "School.h"
#include "Student.h"

using namespace std;

int main() {
    vector<Student> students;

    auto LVC = make_shared<School>("LVC");
    auto RIT = make_shared<School>("RIT");
    auto JW = make_shared<School>("Johnson & Wiggles Clown College");

    Student George("George", LVC);
    students.push_back(George);
    students.push_back(Student("Ryan", LVC));
    students.push_back(Student("Brandon", LVC));
    students.push_back(Student("Sean", LVC));
    students.push_back(Student("Jake", RIT));
    students.push_back(Student("Tyler", RIT));
    students.push_back(Student("Bobby", RIT));
    students.push_back(Student("Bongo", JW));
    students.push_back(Student("Puddles", JW));

    for(auto x : students){
        cout << x.get_name() << " attends " << x.get_school_name() << endl;
    }

    JW->set_name("Jingles & Walters Clown Community College");

    for(auto x : students){
        cout << x.get_name() << " attends " << x.get_school_name() << endl;
    }

    return 0;
}