//
// Created by Hannah Zhang on 16/6/10.
//
#include <sstream>
#include <vector>
#include <iostream>
using namespace std;

vector<int> parseInts(string str) {
    stringstream ss(str);
    char ch;
    int a;
    vector<int> v;

    while (ss >> a ) {
        v.push_back(a);
        ss >> ch;
    }

    return v;

}

int main() {
    string str;
    cin >> str;
    vector<int> integers = parseInts(str);
    for(int i = 0; i < integers.size(); i++) {
        cout << integers[i] << "\n";
    }

    return 0;
}

