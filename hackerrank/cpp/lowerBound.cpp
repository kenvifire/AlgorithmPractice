//
// Created by Hannah Zhang on 16/6/10.
//
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int N,Q;
    cin >> N;
    vector<int> v;
    int x;
    for (int i = 0; i < N; ++i) {
       cin >> x;
       v.push_back(x);
    }
    vector<int>::iterator low;
    cin >> Q;
    int y;
    for (int j = 0; j < Q; ++j) {
        cin >> y;
        low = lower_bound(v.begin(), v.end(), y);
        cout << (*low ==  y ? "Yes" : "No") << ' ' << (low - v.begin() + 1) <<endl;
    }

    return 0;
}

