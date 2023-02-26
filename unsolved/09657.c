#include <stdio.h>
#define SIZE 1001

int main()
{
    int dp[SIZE];
    { // preprocessing
        dp[1] = dp[3] = dp[4] = 1;
        dp[2] = 0;
        for (int i = 5; i < SIZE; ++i) {
            if (dp[i - 1] + dp[i - 3] + dp[i - 4] == 3) dp[i] = 0;
            else dp[i] = 1;
            /*
                i -1, i -3, i -4 번째 모두 상근이의 승리라면, i번째는 무조건 창영이가 이긴다.
                1 0 1 1 1 1 0 1 0 1 1 1 1 0 1 0 1 1 1 1 0 1 0 1 1 1 1 0 1 0 1 1 1 1 0 1 반복구간 발생..
                토글링 적용 가능.
            */
        }
    }
    int N;
    scanf("%d", &N);
    for (int i = 0; i < 100; ++i) printf("%d ", dp[i]);
    printf("%d", dp[N] == 1 ? "SK" : "CY");
}
