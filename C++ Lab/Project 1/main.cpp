// import standard library facilities we need
#include <string>
#include <iostream>

// import local stuff -- notice the "" instead of <>
#include "point.h"
#include "smallest_circle.h"

// allows us to drop std:: qualifier from standard library stuff
using namespace std;

int main() {
    cout << "Enter the name of the file containing our point data: ";
    string fname;

    cin >> fname;

    // When you have an initializer, you can use auto as the type, and the compiler
    // will figure it out.

    // call the functions defined in the "smallest_circle" module.
    auto points = load_points(fname);

    auto center = find_center(points);

    auto radius = find_radius(center, points);

    // let's print our results:
    cout << "\n\nThe center is at " << center << " and the radius is " << radius << endl;
}