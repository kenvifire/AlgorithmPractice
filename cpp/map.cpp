//
// Created by Hannah Zhang on 16/6/10.
//

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <set>
#include <map>
#include <algorithm>
#include <string>

using namespace std;

int main() {
    int Q, type, y;
    string x;

    cin >> Q;
    map<string, int> stdMap;
    map<string, int>::iterator iter;

    for (int i = 0; i < Q; ++i) {
        cin >>  type;
        switch (type) {
            case 1:
                cin >> x >> y;
                iter = stdMap.find(x);
                if(iter != stdMap.end()) {
                    stdMap[x] = y + iter->second;
                }else {
                    stdMap[x] = y;
                }
                break;
            case 2:
                cin >> x;
                stdMap.erase(x);
                break;
            case 3:
                cin >> x;
                iter = stdMap.find(x);
                if(iter != stdMap.end()) {
                    cout << iter->second << endl;
                }else {
                    cout<< 0 << endl;
                }
                break;
        }
    }

    stdMap.clear();

}