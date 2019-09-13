#ifndef PROJECT1_POINT_H
#define PROJECT1_POINT_H

#include <string>

// A simple example of a class, displaying some C++ notation.  Lots in common with
// Java, though there are syntatic differences
class Point : public std::error_code {
public:
    // A pair of constructors
    Point();
    Point(double x, double y);

    // find the distance from this point to other
    double distance_to(const Point& other) const;

    // add other to this point
    void add(const Point& other);

    // scale the coordinates of this by factor
    void scale(double factor);

    // create a string representation of this
    std::string to_string() const;

private:
    double x;
    double y;
};

#endif //PROJECT1_POINT_H

