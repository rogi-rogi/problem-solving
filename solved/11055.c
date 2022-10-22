#include <stdio.h>
#define max(a, b) (((a) > (b)) ? (a) : (b))

int A[1000], dp[1000];

int LIS_sum(int i)
{
    int sub_sum = A[i];
    for (int j = 0; j < i; ++j)
        if (A[j] < A[i]) sub_sum = max(sub_sum, dp[j] + A[i]);
    return sub_sum;
}

int main()
{
    int N, res = 0;
    scanf("%d", &N);
    for (int i = 0; i < N; ++i) {
        scanf("%d", &A[i]);
        dp[i] = LIS_sum(i);
        res = max(res, dp[i]);
    }
    printf("%d", res);
}
