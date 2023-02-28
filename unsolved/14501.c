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
/*
N = 7
0   1   2   3   4   5   6
3   5   1   1   2   4   2
10  20  10  20  15  40  200
45  45  45  35  15  0   0
*/
