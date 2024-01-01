// #include <bits/stdc++.h>
#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // freopen("sample_input.txt", "r", stdin);

    int T;
    cin >> T;
    for (int TC = 1; TC <= T; ++TC) {
        // Input
        int N;
        cin >> N;
        int P_SIZE = 2 * N;
        vector<long> P(P_SIZE), res(N);
        for (int i = 0; i < P_SIZE; ++i)
            cin >> P[i];

        // Solve
        for (int i = 0, idx = -1; i < P_SIZE; ++i) {
            if (P[i] == -1) continue;
            res[++idx] = P[i];
            for (int j = i + 1; j < P_SIZE; ++j) {
                if (P[j] == (P[i] * 4) / 3) {
                    P[j] = -1;
                    break;
                }
            }
            P[i] = -1;
        }

        // Output
        cout << '#' << TC;
        for (int i = 0; i < N; ++i)
            cout << ' ' << res[i];
        cout << '\n';
    }
    return 0;
}
