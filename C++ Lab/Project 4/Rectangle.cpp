#include "Rectangle.h"
#include <stdlib.h>
#include <sstream>
#include <iostream>

Rectangle::Rectangle(int x1, int y1, int x2, int y2, int i) {
    a.first = x1;
    a.second = y1;

    b.first = x2;
    b.second = y2;

    size = abs(x2 - x1) * abs(x2 - x1);

    id = i;
}

bool Rectangle::overlaps(Rectangle other) {
    return a.first <= other.a.first && a.second <= other.a.second && b.first >= other.b.first && b.second >= other.b.second;
}

bool Rectangle::compare(Rectangle a, Rectangle b) {
    return a.size > b.size;
}

int Rectangle::getSize() const {
    return size;
}

std::string Rectangle::toString() {
    std::stringstream ss;
    ss << a.first << ' ' << a.second << ' ' << b.first << ' ' << b.second;
    std::string s = ss.str();
    return s;
}

int Rectangle::getId() const {
    return id;
}
