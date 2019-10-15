#include <iostream>
#include <fstream>
#include <set>

using namespace std;

int main(){
    ifstream ifs;
    ifs.open("D:\\Programming\\school\\C++ Lab\\Project 3\\Input");

    set<string> words;
    string x;
    int index = 0;

    while(ifs >> x){
        words.insert(x);
    }

    cout << "Write EXIT to quit" << endl;
    while(cin >> x && x != "EXIT"){
        bool found = false;
        for(auto w : words) {
            if(w == x){
                cout << x << " was found" << endl;
                found = true;
            }
        }

        if(!found){
            cout << x << " not found" << endl;
        }

        found = false;
    }

    return 0;
}