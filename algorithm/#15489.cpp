#include <iostream>
#define SIZE 30

using namespace std;

int main()
{
    int dp[SIZE + 1][SIZE + 1];
    for (int i = 1; i <= SIZE; ++i) dp[i][1] = dp[i][i] = 1;
  /*
    for (int i = 2; i < SIZE - 1; ++i)
        for (int j = 2; j <= i; ++j)
            dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            */
    int R, C, W, sum = 0;
    cin >> R >> C >> W;
    for (int i = 0; i < W; ++i)
        for (int j = 0; j <= i; ++j)
            sum += dp[R + i][C + j];
    cout << sum;
}
