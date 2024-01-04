// #include <bits/stdc++.h>

#include <cmath>
#include <iostream>
#include <vector>

using namespace std;

const int SIZE = 51;
const int MAX = 999888777;

int board[SIZE][SIZE];
int dp[SIZE][SIZE];
bool check[2501];

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    // freopen("sample_input.txt", "r", stdin);

    int T;
    cin >> T;
    for (int TC = 1; TC <= T; ++TC) {
        // Input
        int N, K;

        cin >> N >> K;
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j) {
                dp[i][j] = MAX;
            }
        }

        fill(check, check + 2501, false);

        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j) {
                cin >> board[i][j];
                if (board[i][j] == 1) dp[i][j] = 0;
                check[board[i][j]] = true;
            }
        }

        // Solve
        bool possible = true;
        for (int i = 1; i <= K; ++i) {
            if (!check[i]) {
                possible = false;
                break;
            }
        }

        if (possible) {
            for (int ck = 1; ck < K; ++ck) { // board check
                for (int cy = 1; cy <= N; ++cy) {
                    for (int cx = 1; cx <= N; ++cx) {
                        if (board[cy][cx] != ck) continue;
                        for (int ny = 1; ny <= N; ++ny) { // dp
                            for (int nx = 1; nx <= N; ++nx) {
                                if (board[ny][nx] == ck + 1) {
                                    dp[ny][nx] = min(dp[ny][nx], dp[cy][cx] + abs(ny - cy) + abs(nx - cx));
                                }
                            }
                        }
                    }
                }
            }

            // Output
            int res = MAX;
            for (int i = 1; i <= N; ++i) {
                for (int j = 1; j <= N; ++j) {
                    if (board[i][j] == K && dp[i][j] < res) {
                        res = dp[i][j];
                    }
                }
            }
            cout << '#' << TC << ' ' << res << '\n';
        } else cout << '#' << TC << ' ' << -1 << '\n';
    }
    return 0;
}
