//
// Created by Hannah Zhang on 16/6/10.
//
#include <iostream>
#include <deque>
using namespace std;
void printKMax(int arr[], int n, int k){
    deque<int> dq;
    int max = 0;
    for (int i = 0; i <= n-k; i++) {
        max = 0;
        for (int j = i; j < i+k ; j++) {
            if(arr[j] > max)  {
                max = arr[j];
            }
//            cout << j << ' ';
        }
//        cout << endl;
        cout << max << ' ';
    }
    cout <<endl;
}
int main(){

    int t;
    cin >> t;
    while(t>0) {
        int n,k;
        cin >> n >> k;
        int i;
        int arr[n];
        for(i=0;i<n;i++)
            cin >> arr[i];
        printKMax(arr, n, k);
        t--;
    }
    return 0;
}
