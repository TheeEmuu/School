#include <cmath>
#include <string>
#include <sstream>

#include "point.h"

// This is typical of how C++ source code is organized; interface
// information (function signatures, class declarations) go into a
// header file, while function implementations go in a source file.

// note the syntax for instance data initialization
Point::Point()
        : x{0.0}, y{0.0}
{}

// initialize instance data as copies of the parameters
Point::Point(double x, double y)
        : x{x}, y{y}
{}

double Point::distance_to(const Point& other) const {
    // remember the distance formula?
    double xdiffsq = (x - other.x)*(x - other.x);
    double ydiffsq = (y - other.y)*(y - other.y);

    // sqrt comes from the cmath portion of the standard library
    return std::sqrt(xdiffsq + ydiffsq);
}


void Point::add(const Point& other) {
    x + other.x;
    y + other.y;
}

void Point::scale(double factor) {
    x * factor;
    y * factor;
}

// make a string representation of this point for printing
std::string Point::to_string() const {
    // to create a formatted string, string streams are convenient.
    // You write to them like you write to files or the console.
    std::ostringstream os;
    os << "(" << x << ", " << y << ")";

    // the str() member function extracts the string we just built.
    return os.str();
}


