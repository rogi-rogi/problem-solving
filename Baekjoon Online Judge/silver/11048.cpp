#include <iostream>
#define SIZE 1001
using namespace std;

int dp[SIZE][SIZE];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int N, M;
    cin >> N >> M;
    for (int i = 1; i <= N; ++i) {
        for (int j = 1; j <= M; ++j) {
            cin >> dp[i][j];
            dp[i][j] += max(max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
        }
    }
    cout << dp[N][M];
}
