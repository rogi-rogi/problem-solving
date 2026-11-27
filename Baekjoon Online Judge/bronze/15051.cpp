#include <cmath>
#include <iostream>
using namespace std;

int main()
{
    int A1, A2, A3;
    cin >> A1 >> A2 >> A3;
    cout << min(A1 * 2 + A3 * 2, min(A1 * 4 + A2 * 2, A2 * 2 + A3 * 4));
}
