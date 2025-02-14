#include <algorithm>
#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    int L, P, V;
    for (int TC = 1;; ++TC)
    {
        cin >> L >> P >> V;
        if (L == P && P == V && L == 0)
            break;
        // Solve & Output
        cout << "Case " << TC << ": " << L * (V / P) + min(V % P, L) << '\n';
    }
}
