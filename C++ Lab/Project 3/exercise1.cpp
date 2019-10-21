#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

int main() {
    ifstream ifs;
    ifs.open("D:\\Programming\\school\\C++ Lab\\Project 3\\Input");

    vector<string> words;
    string x;
    int index = 0;

    while(ifs >> x){
        words.push_back(x);
    }

    ifs.close();

    for(int i = words.size() - 1; i > -1; i--){
        cout << words[i] << endl;
    }

    return 0;
}