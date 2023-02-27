#include <stdio.h>

int main()
{
    int dp[7] = {1, 0, 1, 1, 1, 1, 0};
    { // preprocessing
        // dp[1] = dp[3] = dp[4] = 1;
        // dp[2] = 0;
        // for (int i = 5; i < SIZE; ++i) {
        //     if (dp[i - 1] + dp[i - 3] + dp[i - 4] == 3) dp[i] = 0;
        //     else dp[i] = 1;
        //     /*
        //         i -1, i -3, i -4 번째 모두 상근이의 승리라면, i번째는 무조건 창영이가 이긴다.
        //      (1 2 3 4 5 6 7) (8 9 10 11 12 13 14) (15 16 17...)
        // (1 0 1 1 1 1 0) (1 0 1  1  1  1  0 ) (1  0  1 ...) for toggling
        //     */
        // }
        // 
    }
    int N;
    scanf("%d", &N);
    printf("%s", dp[(N - 1) % 7] == 1 ? "SK" : "CY");
}
