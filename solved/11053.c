#include <stdio.h>
#define max(a, b) (((a) > (b)) ? (a) : (b))

int A[1000], dp[1000];

int LIS_length(int i)
{
    int length = 0;
    for (int j = 0; j < i; ++j)
        if (A[j] < A[i]) length = max(length, dp[j]);
    return length + 1;
}

int main()
{
    int N, res = 0;
    scanf("%d", &N);
    for (int i = 0; i < N; ++i) {
        scanf("%d", &A[i]);
        dp[i] = LIS_length(i);
        res = max(res, dp[i]); 
    }
    printf("%d", res);
}
