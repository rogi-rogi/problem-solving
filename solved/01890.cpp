#include <iostream>
#define SIZE 101
using namespace std;

int board[SIZE][SIZE];
long long dp[SIZE][SIZE];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N;
    cin >> N;
    for (int i = 1; i <= N; ++i)
        for (int j = 1; j <= N; ++j)
            cin >> board[i][j];
    dp[1][1] = 1;
    for (int i = 1; i <= N; ++i) {
        for (int j = 1; j <= N; ++j) {
            if (board[i][j] == 0 || i == N && j == N) continue;
            int ni = board[i][j] + i;
            int nj = board[i][j] + j;
            if (ni <= N) dp[ni][j] += dp[i][j];
            if (nj <= N) dp[i][nj] += dp[i][j];
        }
    }
    cout << dp[N][N];
}
