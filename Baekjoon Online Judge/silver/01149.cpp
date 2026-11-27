#include <bits/stdc++.h>
#define SIZE 1001

using namespace std;

int dp[SIZE][3];

int main() {
    // Init
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;

    // Input
    cin >> N;
    int dp[N + 1][3];
    for (int i = 1; i <= N; ++i) {
        int r, g, b;
        cin >> r >> g >> b;

        // Solve
        dp[i][0] = r + min(dp[i - 1][1], dp[i - 1][2]);
        dp[i][1] = g + min(dp[i - 1][0], dp[i - 1][2]);
        dp[i][2] = b + min(dp[i - 1][0], dp[i - 1][1]);
    }
    
    // Output
    cout << min(dp[N][0], min(dp[N][1], dp[N][2]));
}
