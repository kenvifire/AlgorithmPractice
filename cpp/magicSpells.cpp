//
// Created by Hannah Zhang on 16/6/9.
//
#include <iostream>
#include <vector>
using namespace std;

class Spell {
private:
    string scrollName;
public:
    Spell(): scrollName("") { }
    Spell(string name): scrollName(name) { }
    virtual ~Spell() { }
    string revealScrollName() {
        return scrollName;
    }
};

class Fireball : public Spell {
private: int power;
public:
    Fireball(int power): power(power) { }
    void revealFirepower(){
        cout << "Fireball: " << power << endl;
    }
};

class Frostbite : public Spell {
private: int power;
public:
    Frostbite(int power): power(power) { }
    void revealFrostpower(){
        cout << "Frostbite: " << power << endl;
    }
};

class Thunderstorm : public Spell {
private: int power;
public:
    Thunderstorm(int power): power(power) { }
    void revealThunderpower(){
        cout << "Thunderstorm: " << power << endl;
    }
};

class Waterbolt : public Spell {
private: int power;
public:
    Waterbolt(int power): power(power) { }
    void revealWaterpower(){
        cout << "Waterbolt: " << power << endl;
    }
};

class SpellJournal {
public:
    static string journal;
    static string read() {
        return journal;
    }
};
string SpellJournal::journal = "";

void counterspell(Spell *spell) {
    if(Fireball* fire = dynamic_cast<Fireball*>(spell)) {
       fire->revealFirepower();
    }else if(Frostbite * frost = dynamic_cast<Frostbite*>(spell)) {
        frost->revealFrostpower();
    }else if(Waterbolt* water = dynamic_cast<Waterbolt*>(spell)) {
        water->revealWaterpower();
    }else if(Thunderstorm* thuner = dynamic_cast<Thunderstorm*>(spell)) {
        thuner->revealThunderpower();
    }else {
        int ** dp;
        int i,j;
        string str1 = spell->revealScrollName();
        string str2 = SpellJournal::journal;

        dp =  new int*[str1.size() + 1];
        for (int l = 0; l <= str1.size(); ++l) {
            dp[l] = new int[str2.size() + 1];
        }

        for (int k = 0; k <= str1.size(); ++k) {
            dp[k][0] = 0;
        }

        for (int k = 0; k <= str2.size(); ++k) {
            dp[0][k] = 0;
        }
        int max = 0;
        for (int i = 1; i <=str1.size() ; ++i) {
            for (int j = 1; j <=str2.size() ; ++j) {
               if(str1[i-1] == str2[j-1]) {
                   dp[i][j] = dp[i-1][j-1] + 1;
               }else if(dp[i-1][j] >= dp[i][j-1]) {
                   dp[i][j] = dp[i-1][j];
               }else{
                   dp[i][j] = dp[i][j-1];
               }
                if(dp[i][j] > max) {
                    max = dp[i][j];
                }


            }
        }
        cout<<max<<endl;

        for (int l = 0; l <= str1.size(); ++l) {
            delete[] dp[l];
        }
        delete[] dp;

    }
}



class Wizard {
public:
    Spell *cast() {
        Spell *spell;
        string s; cin >> s;
        int power; cin >> power;
        if(s == "fire") {
            spell = new Fireball(power);
        }
        else if(s == "frost") {
            spell = new Frostbite(power);
        }
        else if(s == "water") {
            spell = new Waterbolt(power);
        }
        else if(s == "thunder") {
            spell = new Thunderstorm(power);
        }
        else {
            spell = new Spell(s);
            cin >> SpellJournal::journal;
        }
        return spell;
    }
};

int main() {
    int T;
    cin >> T;
    Wizard Arawn;
    while(T--) {
        Spell *spell = Arawn.cast();
        counterspell(spell);
    }
    return 0;
}

