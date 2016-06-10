//
// Created by Hannah Zhang on 16/6/10.
//

#include <iostream>
#include <iomanip>

using namespace std;

int main() {
    int T; cin >> T;
    cout << setiosflags(ios::uppercase);
    cout << setw(0xf)  << internal;
    while (T--) {
        double A; cin >> A;
        double B; cin >> B;
        double C; cin >> C;
        cout << setiosflags(ios::showbase);
        cout.unsetf(ios::uppercase);
        cout.width(0);
        cout << setbase(16)<< (long)A<<endl;
        cout.fill('_');
        cout.width(0xf);
        cout.setf(ios_base::left);
        cout << fixed <<   showpos << setprecision(2) <<   B << endl;

        cout.setf(ios::uppercase);
        cout.unsetf(ios::showpos);
        cout<<scientific <<  setprecision(9)  << C << endl;


    }

    return 0;

}

