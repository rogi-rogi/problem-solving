#include <stdio.h>

typedef long long ll;
enum nums {ONE, TWO, THR, SIZE = 100001, MOD = (int)1e9 +9 };

int dp[SIZE][3];

int main()
{
    { // preprocessing
        dp[1][ONE] = 1;
        dp[2][TWO] = 1;
        dp[3][ONE] = dp[3][TWO] = dp[3][THR] = 1;
        for (int i = 4; i < SIZE; ++i) {
            dp[i][ONE] = ((ll)dp[i - 1][TWO] + dp[i - 1][THR]) % MOD;
            dp[i][TWO] = ((ll)dp[i - 2][ONE] + dp[i - 2][THR]) % MOD;
            dp[i][THR] = ((ll)dp[i - 3][ONE] + dp[i - 3][TWO]) % MOD;
            /*
                i번째 수를 주어진 수(1, 2, 3)로 구성하는 경우의 수는, 
                이전 수들(i -1, i -2, i -3)의 경우의 수를 이용해 구할 수 있다.
                dp[n][i] : n에 대해 i로 끝나는 조합의 수 
            */
        }
    }
    
    int T;
    scanf("%d", &T);
    while (T--) {
        int n;
        scanf("%d", &n);
        printf("%d\n", ((ll)dp[n][ONE] + dp[n][TWO] + dp[n][THR]) % MOD);
    }
}
