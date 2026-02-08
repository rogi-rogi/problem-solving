#include <iostream>

using namespace std;

typedef long long ll;

const int MAX = 1e5;
ll D[MAX], P[MAX];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    int N;
    cin >> N;
    for (int d = 0; d < N - 1; ++d)
        cin >> D[d];
    for (int p = 0; p < N; ++p)
        cin >> P[p];

    // Solve
    for (int p = 1; p < N; ++p)
    {
        if (P[p] > P[p - 1])
            P[p] = P[p - 1];
    }

    ll res = 0;
    for (int d = 0; d < N - 1; ++d)
        res += D[d] * P[d];

    // Output
    cout << res;
}
