#include <stdio.h>
#define SIZE 11

int main() {
    // Init
    int dp[SIZE] = {0, 1, 2, 4,};
    int T;
    
    // Solve
    for (int i = 4; i < SIZE; ++i)
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];

    // Input
    scanf("%d", &T);
    while (T--) {
        int n;
        scanf("%d", &n);
        printf("%d\n", dp[n]);
    }
}
