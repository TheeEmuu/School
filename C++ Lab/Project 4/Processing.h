#ifndef PROJECT_4_PROCESSING_H
#define PROJECT_4_PROCESSING_H

#include <vector>
#include "Rectangle.h"
#include <string>
#include <fstream>
#include <vector>

class Processing {
public:
    static std::vector<Rectangle> read(std::string filepath);

    static int write(std::vector<Rectangle> list);
private:

};


#endif //PROJECT_4_PROCESSING_H
