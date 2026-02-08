#include <iostream>
using namespace std;

int main()
{
    int A, B, C;
    cin >> A >> B >> C;
    if      (A && !B && !C || !A && B && C) cout << "A";
    else if (!A && B && !C || A && !B && C) cout << "B";
    else if (!A && !B && C || A && B && !C) cout << "C";
    else cout << "*";
    cout << "\n";
}
