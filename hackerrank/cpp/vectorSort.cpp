//
// Created by Hannah Zhang on 16/6/11.
//
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int N;
    vector<int> v;
    cin >> N;
    int t;
    for (int j = 0; j < N; ++j) {
        cin >> t;
        v.push_back(t);

    }
    sort(v.begin(), v.end());

    for (int i = 0; i < N; ++i) {
       cout << v[i] << ' ';
    }

    return 0;
}


