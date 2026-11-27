#include <algorithm>
#include <iostream>
using namespace std;

int main()
{
    long long A, B, C;
    cin >> A >> B >> C;
    cout << max(1LL* A * B / C, 1LL* A * C / B);
}
