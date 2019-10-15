#include <iostream>
#include "Rectangle.h"
#include "Processing.h"
#include <vector>
#include <set>

using namespace std;

int main() {
    vector<Rectangle> list = Processing::read("D:\\Programming\\school\\C++ Lab\\Project 4\\input");

    set<int> toRemove;
    for(int i = 0; i < list.size(); i++){
        for(int k = 0; k < list.size(); k++){
            if(list[i].getId() != list[k].getId() && list[i].overlaps(list[k])){
                toRemove.insert(k);
            }
        }
    }

    vector<Rectangle> result;
    bool flag;
    for(int i = 0; i < list.size(); i++){
        flag = true;
        for(auto x : toRemove){
            if(i == x)
                flag = false;
        }

        if(flag)
            result.push_back(list[i]);
    }

    Processing::write(result);

    return 0;
}