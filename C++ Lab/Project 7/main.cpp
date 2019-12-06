#include <iostream>
#include <vector>
#include <iostream>
#include <sstream>
#include <random>
#include <algorithm>
#include <chrono>

using namespace std;
using namespace std::chrono;

vector<string> make_vector(int size) {
    default_random_engine generator;
    uniform_int_distribution<int> distribution(0, 25);
    vector<string> result;
    for (int i = 0; i < size; i++) {
        ostringstream os;
        for(int k = 0; k < 50; k++) {
            os << "abcdefghijklmnopqrstuvwxyz"[distribution(generator)];
        }
        result.push_back(os.str());
    }

    return result;
}

vector<string> filter_vector(vector<string>& source){
    auto it = source.begin();
    while(it != source.end()){
        string copy(*it);
        reverse(copy.begin(), copy.end());
        if(*it >= copy){
            it = source.erase(it);
        } else{
            it++;
        }
    }

    return source;
}

int main() {
    for(int i = 100;; i *= 5){
        auto start = high_resolution_clock::now();
        vector<string> strings = make_vector(i);
        filter_vector(strings);
        auto stop = high_resolution_clock::now();

        auto duration = duration_cast<milliseconds>(stop - start);
        cout << i << " : " <<duration.count() << endl;
    }


    return 0;
}