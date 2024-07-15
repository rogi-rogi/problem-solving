#include <stdio.h>
#define SIZE 1000001

int main()
{
    // Init
    int N;
    int dp[SIZE];
    
    // Input
    scanf("%d", &N);
    
    // Solve
    for (int i = 2; i < SIZE; ++i) {
        dp[i] = dp[i - 1] + 1;
        if (i % 2 == 0 && dp[i / 2] + 1 < dp[i])
            dp[i] = dp[i / 2] + 1;
        if (i % 3 == 0 && dp[i / 3] + 1 < dp[i])
            dp[i] = dp[i / 3] + 1;
    }
    
    // Output
    printf("%d", dp[N]);
}
