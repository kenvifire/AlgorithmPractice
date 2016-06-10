//
// Created by Hannah Zhang on 16/6/10.
//

#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <set>
#include <algorithm>

using namespace std;

int main() {
    int Q, y, x;

    cin >> Q;
    set<int> st;
    for (int i = 0; i < Q; ++i) {
        cin >> y >> x;

        switch(y) {
            case 1:
                st.insert(x);
                break;
            case 2:
                st.erase(x);
                break;
            case 3:
                set<int>::iterator iter = st.find(x);
                if(iter != st.end()) {
                   cout << "Yes" << endl;
                }else {
                   cout << "No"  << endl;
                }
                break;

        }

    }


}
