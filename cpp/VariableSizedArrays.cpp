//
// Created by Hannah Zhang on 16/6/9.
//

#include <iostream>
using namespace std;

int main() {
    int N,Q;
    cin >> N >> Q;
    int* v[N];
    int size;
    int num;
    for (int j = 0; j < N; ++j) {
        cin >> size;
        v[j] = (int *)malloc(sizeof(int) * size);
        for (int i = 0; i < size; ++i) {
            cin >> num;
            v[j][i] = num;
        }

    }
    int a,b;
    while ( Q --> 0) {
        cin >> a >> b;
        cout << v[a][b] << endl;
    }

    for (int k = 0; k < N; ++k) {
       free(v[k]);
    }

}

