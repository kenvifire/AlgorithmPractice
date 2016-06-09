//
// Created by Hannah Zhang on 16/6/9.
//
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>

using  namespace std;

class Matrix {
public:
    vector<vector<int> > a;

    Matrix operator + (Matrix n) {
        Matrix r;
        for (int i = 0; i < a.size(); ++i) {
            vector<int> c;
            for (int j = 0; j < a[0].size(); ++j) {
                c.push_back(a[i][j] + n.a[i][j]);
            }
            r.a.push_back(c);

        }
        return r;
    }

};

int main() {
    int cases, k;
    cin >> cases;
    for (int k = 0; k < cases; ++k) {
        Matrix x;
        Matrix y;
        Matrix result;
        int n,m,i,j;
        cin >> n >> m;
        for (int i = 0; i < n; ++i) {
            vector<int> b;
            int num;
            for (int j = 0; j < m; ++j) {
                cin >> num;
                b.push_back(num);
            }
            x.a.push_back(b);
        }

        for (int i = 0; i < n; ++i) {
            vector<int> b;
            int num;
            for (int j = 0; j < m; ++j) {
                cin >> num;
                b.push_back(num);
            }
            y.a.push_back(b);
        }

        result = x + y;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                cout << result.a[i][j] << " ";
            }
            cout << endl;
        }
    }
}

