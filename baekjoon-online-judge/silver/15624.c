#include <stdio.h>

const int MOD = 1e9 + 7;

int main()
{
    int n;
    scanf("%d", &n);
    int dp[2] = {0, 1};
    for (int i = 1; i < n; ++i)
        dp[(i + 1) % 2] = (dp[i % 2] + dp[(i - 1) % 2]) % MOD;
    printf("%d", dp[n % 2]);
}
