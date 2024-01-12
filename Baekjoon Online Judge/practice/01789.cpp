#include <iostream>

typedef long long ll;

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    ll S;
    cin >> S;

    // Solve
    int cnt = 0;
    for (int num = 1; S >= num; ++num)
    {
        S -= num;
        ++cnt;
    }

    // Output
    cout << cnt;
}
