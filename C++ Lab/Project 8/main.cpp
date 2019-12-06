#include "Base.h"
#include "Derived.h"

#include <iostream>
#include <fstream>
#include <vector>
#include <memory>

using namespace std;

void processRef(Base& b){
    b.adjust();
}

void process(Base b){
    b.adjust();
}

void print(Base a, Derived b){
    a.print();
    b.print();
    cout << endl;
}

int main() {
    vector<unique_ptr<Base>> vector;
    ifstream in("D:\\Programming\\school\\C++ Lab\\Project 8\\input");
    string a;
    int b;
    double c;
    while((in >> a) && !in.eof()){
        if(a.compare("derived") == 0){
            in >> b;
            in >> c;
            unique_ptr<Derived> entry = make_unique<Derived>(b, c);
            vector.push_back(move(entry));
        }
        else if(a.compare("base") == 0){
            in >> b;
            unique_ptr<Base> entry = make_unique<Base>(b);
            vector.push_back(move(entry));
        }
    }

    for(auto& x : vector){
        x->print();
    }

    /*At the end of the scope, all the Bases are destroyed, but no
      Derives are explicitly destroyed. They are destroyed, but as
      Bases rather and Derives

      After making the destructor virtual, Derives  are destroyed
      as Derives, and Bases are destroyed as Bases.
    */

// Assignment 1/2:
//    Base a(5);
//    Derived b(5, 2);
//
//    print(a,b);
//    //size: 5
//    //weight: 2
//
//    //size: 5
//    //weight: 2
//
//    process(a);
//    process(b);
//
//    print(a,b);
//    //size: 5
//    //weight: 2
//
//    //size: 5
//    //weight: 2
//
//    processRef(a);
//    processRef(b);
//
//    print(a,b);
//    //size: 47
//    //weight: 2
//
//    //size: 47
//    //weight: 2.2
//
//    /*
//     * Polymorphism was not achieved, when we processRef(b), it only
//     * adjusts the size, and not the weight
//     *
//     * Another interesting result is because we don't pass the reference
//     * to process() and rather pass a copy, our local copy doesn't change
//     * like it does when passing to processRef()
//     *
//     * The polymorphism now works as expected, processRef(b) now calls the
//     * adjust function of Derived. To achive polymorphism with parameter
//     * passing, the functions we what to be polymorphic have to be marked
//     * virtual and have different implementation in the extended class.
//     */
}