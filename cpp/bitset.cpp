//
// Created by Hannah Zhang on 16/6/9.
//
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

#define SetBit(a,k) a[(k/32)] = a[(k/32)] | 1<<a[(k%32)]
#define GetBit(a,k) a[(k/32)] & 1<<a[(k%32)]
int main() {
    int N ,S,P,Q;
    cin >> N >> S >> P >> Q;
    vector<int> v(N/32+1);
    int acc = S;
    SetBit(v, acc);
    for (int i = 1; i < N; i++) {
        acc = acc * P + Q % (1 << 31);
        SetBit(v, acc);
    }

    int cnt = 0;
    for (int j = 0; j < v.size()*8; ++j) {
        if(GetBit(v,j)) {
           cnt ++;
        }
    }
    cout << cnt;
    return 0;
}


