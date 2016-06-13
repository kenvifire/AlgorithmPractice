//
// Created by Hannah Zhang on 16/6/9.
//
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int N;
    cin >> N;
    vector<int> v;

    int t;
    for (int i = 0; i < N; ++i) {
        cin >> t;
        v.push_back(t);
    }

    int x,a,b;
    cin >> x >> a >> b;

    vector<int>::iterator iter;
    int i=1;
    for(iter=v.begin(), i = 1; iter != v.end(); ) {
        if(i == x) {
            v.erase(iter);
            break;
        }else {
            iter++;
            i++;
        }
    }
    for(iter=v.begin(), i = 1 ; iter != v.end();  i++) {
        if( i >= a && i < b) {
            v.erase(iter);
        }else {
            iter++;
        }
    }

    cout<<v.size()<<endl;
    for (iter = v.begin(); iter != v.end(); iter++){
        cout<< *iter << ' ';
    }



    return 0;
}



