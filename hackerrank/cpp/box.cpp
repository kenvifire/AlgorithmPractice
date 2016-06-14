//
// Created by Hannah Zhang on 16/6/11.
//
#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int BoxesCreated,BoxesDestroyed;

class Box {
private:
    int l,b,h;
public:
    Box() {
        l = 0;
        b = 0;
        h = 0;
        BoxesCreated++;
    }
    Box(int length, int breadth, int height) {
        this->l = length;
        this->b = breadth;
        this->h = height;
        BoxesCreated++;
    }

    Box(Box& box) {
        this->l = box.l;
        this->h = box.h;
        this->b = box.b;
        BoxesCreated++;
    }

    int getLength() {
        return this->l;
    }

    int getBreadth() {
        return this->b;
    }
    int getHeight() {
        return this->h;
    }
    long long CalculateVolume() {
        long long v = 1;
        v *= l;
        v *= h;
        v *= b;
        return v;
    }

    bool operator < (Box &b) {
        return (this->l < b.l) ||
               (this->b < b.b && this->l == b.l) ||
               (this->h < b.h && this->b == b.b && this->l == b.l);

    }

    friend ostream& operator << (ostream& out, Box box) {
        out << box.l << ' ' << box.b << ' ' << box.h;
        return out;
    }
    ~Box() {
        BoxesDestroyed ++;
    }


};

void check2()
{
    int n;
    cin>>n;
    Box temp;
    for(int i=0;i<n;i++)
    {
        int type;
        cin>>type;
        if(type ==1)
        {
            cout<<temp<<endl;
        }
        if(type == 2)
        {
            int l,b,h;
            cin>>l>>b>>h;
            Box NewBox(l,b,h);
            temp=NewBox;
            cout<<temp<<endl;
        }
        if(type==3)
        {
            int l,b,h;
            cin>>l>>b>>h;
            Box NewBox(l,b,h);
            if(NewBox<temp)
            {
                cout<<"Lesser"<<endl;
            }
            else
            {
                cout<<"Greater"<<endl;
            }
        }
        if(type==4)
        {
            cout<<temp.CalculateVolume()<<endl;
        }
        if(type==5)
        {
            Box NewBox(temp);
            cout<<NewBox<<endl;
        }

    }
}

int main()
{
    BoxesCreated = 0;
    BoxesDestroyed = 0;
    check2();
    cout<<"Boxes Created : "<<BoxesCreated<<endl<<"Boxes Destroyed : "<<BoxesDestroyed<<endl;
}

