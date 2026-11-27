#include <stdio.h>

enum nums {ONE, TWO, THR, SIZE = 10001};

int dp[SIZE][3];

int main()
{
    {   //preprocessing
        dp[1][ONE] = 1;
        dp[2][ONE] = dp[2][TWO] = 1;
        dp[3][ONE] = dp[3][TWO] = dp[3][THR] = 1;
        for (int i = 4; i < SIZE; ++i) {
            dp[i][ONE] = 1;
            dp[i][TWO] = dp[i - 2][ONE] + dp[i - 2][TWO];
            dp[i][THR] = dp[i - 1][TWO] + dp[i - 3][THR];
        }   // dp[i - 1][TWO] = dp[i - 3][ONE] + dp[i - 3][TWO]
        /*
            i번째 수를 주어진 수(1, 2, 3)로 중복없이 구성하는 경우의 수는, 
            이전 수들(i -1, i -2, i -3)의 경우의 수에 대해 오름차순으로 차이를 더하여 구할 수 있다.
            ex) i = 5, 112 is true, 121 is false
            dp[n][i] : n에 대해 i로 끝나면서 오름차순으로 정렬된 조합의 수
        */
    }
    int T;
    scanf("%d", &T);
    while (T--) {
        int n;
        scanf("%d", &n);
        printf("%d\n", dp[n][ONE] + dp[n][TWO] + dp[n][THR]);
    }
}
