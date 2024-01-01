// #include <bits/stdc++.h>

#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    freopen("sample_input.txt", "r", stdin);

    int T;
    cin >> T;
    for (int TC = 1; TC <= T; ++TC) {
        // Input
        int N, M;
        cin >> N >> M;
        vector<string> W;
        string s;

        int cnt = 0;
        for (int i = 0; i < N; ++i) {
            cin >> s;
            // Solve
            if (s != string(s.rbegin(), s.rend())) 
                W.push_back(s);
        }

        int SIZE = W.size();
        if (SIZE < N) cnt += 1;
        for (int i = 0; i < SIZE; ++i) {
            s = W.back();
            W.pop_back();
            if (find(W.begin(), W.end(), string(s.rbegin(), s.rend())) != W.end()) {
                cnt += 2;
            }
        }

        // Output
        cout << '#' << TC << ' ' << cnt * M << '\n';
    }
    return 0;
}
