#include <bits/stdc++.h>

using namespace std;

int main() {
    // Init
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // Input
    int n;
    cin >> n;
    int arr[n + 1][n + 1];
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) 
            cin >> arr[i][j];
    }

    // Solve
    int res = 0;
    for (int i = 1; i <= n - 2; ++i) {
        for (int j = 1; j <= n - 2; ++j) {
            int cnt = 0;
            for (int row = i; row <= i + 2; ++row) {
                for (int col = j; col <= j + 2; ++col) {
                    if (arr[row][col] == 1) ++cnt;
                }
            }
            res = max(res, cnt);
            if (res == 9) break;
        }
    }
    
    // Output
    cout << res;
}
