#include <cmath>
#include <iostream>
using namespace std;

int main()
{
    int p1, s1;
    cin >> p1 >> s1;
    int p2, s2;
    cin >> s2 >> p2;
    int p = p1 + p2, s = s1 + s2;
    string res;
    if (p == s) {
        if (p1 == s2) res = "Penalty";
        else if (p1 < s2) res = "Persepolis";
        else res = "Esteghlal";
    } else if(p < s) res = "Esteghlal";
    else res = "Persepolis";
    cout << res;
}
