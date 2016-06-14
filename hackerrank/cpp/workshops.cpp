//
// Created by Hannah Zhang on 16/6/11.
//
#include<bits/stdc++.h>
#include <algorithm
>

using namespace std;

typedef struct {
    int startTime;
    int duration;
    int endTime;
} WorkShop;

typedef struct {
    int n;
    WorkShop * workShops;
}Available_Workshops;

Available_Workshops* initialize(int start_time[], int duration[], int n) {
    Available_Workshops* ws = (Available_Workshops*) malloc(sizeof(Available_Workshops));
    ws.workShops = new WorkShop[n];

    for (int i = 0; i < n; ++i) {
        ws.workShops[i] = new WorkShop();
        ws.workShops[i].startTime = start_time[i];
        ws.workShops[i].duration = duration[i];
        ws.workShops[i].endTime = start_time[i] + duration[i];
    }

    return ws;
}

int CalculateMaxWorkshops(Available_Workshops* ws) {

}



int main(int argc, char *argv[]) {
    int n; // number of workshops
    cin >> n;
    // create arrays of unknown size n
    int* start_time = new int[n];
    int* duration = new int[n];

    for(int i=0; i < n; i++){
        cin >> start_time[i];
    }
    for(int i = 0; i < n; i++){
        cin >> duration[i];
    }

    Available_Workshops * ptr;
    ptr = initialize(start_time,duration, n);
    cout << CalculateMaxWorkshops(ptr) << endl;
    return 0;
}


