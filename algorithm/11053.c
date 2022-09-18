#include <stdio.h>

int dp[1000];

int main()
{
    int N, res = 0, A[1000];
    scanf("%d", &N);
    for (int i = 0; i < N; ++i) {
        scanf("%d", &A[i]);
        for (int j = 0; j < i; ++j)
            if (A[j] < A[i] && dp[i] < dp[j])
                dp[i] = dp[j];
        dp[i] = dp[i] + 1; 
        if (res < dp[i]) res = dp[i];  
    }
    printf("%d", res);
}
