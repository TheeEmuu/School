#ifndef PROJECT_4_RECTANGLE_H
#define PROJECT_4_RECTANGLE_H

#include <utility>
#include <string>


class Rectangle {
public:
    Rectangle(int x1, int y1, int x2, int y2, int i);

    bool overlaps(Rectangle other);

    static bool compare(Rectangle a, Rectangle b);

    std::string toString();
private:
    std::pair<int, int> a;
    std::pair<int, int> b;
    int size;
    int id;
public:
    int getId() const;

public:
    int getSize() const;
};


#endif //PROJECT_4_RECTANGLE_H
