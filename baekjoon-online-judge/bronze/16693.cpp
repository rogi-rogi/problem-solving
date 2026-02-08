#include <cmath>
#include <iostream>
using namespace std;

int main()
{
    double A, P1, R, P2;
    cin >> A >> P1 >> R >> P2;
    cout << (P1 / A < P2 /(R * R * acos(-1))? "Slice of pizza" : "Whole pizza");
}
