#include <fstream>
#include <vector>
#include <string>

#include "point.h"

using namespace std;

// we will explain things like the type modifiers for this parameter
// in later projects
vector<Point> load_points(const string& file_name) {
    // create an input file stream to read from, attached to the file.
    ifstream input_stream{file_name};

    vector<Point> points;
    int num;

    // read the number of points. >> is the "read from" operator; it pulls the
    // next int out of the stream.
    input_stream >> num;

    // now read in all the points
    for (int i=0; i < num; ++i) {
        double x, y;
        input_stream >> x >> y;
        // create a point object and append it to our vector
        Point p{x, y};
        points.push_back(p);
    }

    return points;
}

Point find_center(const vector<Point>& points) {
    // average all of the coordinates together.

    // note: uses the default constructor
    Point center;

    // iterate over the array of points, adding them all to center
    for (auto p : points) {
        center.add(p);
    }

    // now divide by the number of points to find the average.
    // I created the scale member function to make this work, since
    // the coordinates of the point are private to that class.
    double factor = 1/points.size();
    center.scale(factor);

    return center;
}

// find the maximum distance from center to the points in the vector
double find_radius(Point center, const vector<Point>& points) {
    // standard "find the maximum" loop.  Notice the different for-loop
    // styles in these last two functions.
    double max = 0.0;
    for (int i=0; i < points.size(); ++i) {
        double dist = points[i].distance_to(center);
        if (dist > max)
            max = dist;
    }
    return max;
}

