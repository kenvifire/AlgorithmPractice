//
// Created by Hannah Zhang on 16/6/9.
//
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

class Person {
public:
    char name[100];
    int age;
    virtual void getdata(){
        cin >> name >> age;
    } ;

    virtual void putdata() {
        cout << name << ' ' << age;
    };

};

class Professor : public Person {
public:
    int publications;
    static int cid ;
    void getdata() {
        Person::getdata();
        cin >> publications;
    }
    void putdata() {
        Person::putdata();
        cout << ' ' << publications <<" " << cid++<< endl;
    }


};
class Student : public Person {
public:
    static int cid ;
    int sum;
    void getdata() {
        Person::getdata();
        int mark;
        sum = 0;
        for (int i = 0; i < 6; ++i) {
            cin >> mark;
            sum += mark;
        }
    }

    void putdata() {
        Person::putdata();
        cout << ' ' << sum <<' ' << cid++ << endl;
    }
};

int Professor::cid = 1;
int Student::cid = 1;

int main(){

    int n, val;
    cin>>n; //The number of objects that is going to be created.
    Person *per[n];

    for(int i = 0;i < n;i++){

        cin>>val;
        if(val == 1){
            // If val is 1 current object is of type Professor
            per[i] = new Professor;

        }
        else per[i] = new Student; // Else the current object is of type Student

        per[i]->getdata(); // Get the data from the user.

    }

    for(int i=0;i<n;i++)
        per[i]->putdata(); // Print the required output for each object.

    return 0;

}

