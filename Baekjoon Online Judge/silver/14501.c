#include <stdio.h>
#define MAX(a, b) ((a) > (b) ? (a) : (b))
#define SIZE 16

int dp[SIZE], T[SIZE], P[SIZE]; 

int main()
{
    int N;
    scanf("%d", &N);
    for (int i = 0; i < N; ++i)
        scanf("%d %d", &T[i], &P[i]);
    {   // preprocessing
        for (int day = N - 1; day >= 0; --day) {
            int t = T[day];
            if (day + t <= N)
                dp[day] = MAX(dp[day + 1], P[day] + dp[day + t]);
            else dp[day] = dp[day + 1];
        }
    }
    printf("%d", dp[0]);
}
