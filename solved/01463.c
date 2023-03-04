#include <stdio.h>
#define SIZE 1000001

int dp[SIZE];

int main()
{
    { // preprocessing
        for (int i = 2; i < SIZE; ++i) {
            dp[i] = dp[i - 1] + 1;                                          // (3) 
	    if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) dp[i] = dp[i / 2] + 1; // (2)
	    if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) dp[i] = dp[i / 3] + 1; // (1)
        }
    }
    int N;
    scanf("%d", &N);
    printf("%d", dp[N]);
}
