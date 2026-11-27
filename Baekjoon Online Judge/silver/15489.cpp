#include <iostream>
#define SIZE 31

using namespace std;

int dp[SIZE][SIZE];

int main()
{
    for (int i = 1; i < SIZE; ++i) dp[i][1] = dp[i][i] = 1;
    for (int i = 3; i < SIZE; ++i)
        for (int j = 2; j <= i; ++j)
            dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
    int R, C, W, sum = 0;
    cin >> R >> C >> W;
    for (int i = 0; i < W; ++i)
        for (int j = 0; j <= i; ++j)
            sum += dp[R + i][C + j];
    cout << sum;
}
