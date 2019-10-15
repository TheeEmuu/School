#include "Processing.h"
#include <iostream>
#include "Rectangle.h"
#include <vector>
#include <algorithm>

std::vector<Rectangle> Processing::read(std::string filepath) {
    std::vector<Rectangle> rectangles;
    std::ifstream ifs;
    try{
        ifs.open(filepath);

        int count;
        ifs >> count;

        int x1, y1, x2, y2;
        for(int i = 0; i < count; i++){
            ifs >> x1 >> y1 >> x2 >> y2;
            rectangles.push_back(Rectangle(x1, y1, x2, y2, i));
        }
    }
    catch(int e) {
        std::cout << "Failed to find file" << std::endl;
    }

    std::sort(rectangles.begin(), rectangles.end(), Rectangle::compare);

    return rectangles;
}

int Processing::write(std::vector<Rectangle> list){
    std::fstream ofs;

    ofs.open("D:\\Programming\\school\\C++ Lab\\Project 4\\output");

    ofs << list.size() << std::endl;

    for(auto x : list){
        ofs << x.toString() << std::endl;
    }

    ofs.close();

    return 0;
}