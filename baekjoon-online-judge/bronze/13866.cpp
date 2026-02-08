#include <iostream>
using namespace std;

int main()
{
    int A, B, C, D;
    cin >> A >> B >> C >> D;
    int res = (A + D) - (B + C);
    cout << (res < 0 ? -res : res);
}
