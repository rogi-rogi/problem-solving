#include <stdio.h>
#define SIZE 1000000

int dp[SIZE];

int lowerBound(int *arr, int right, int key)
{
    int left = 0, mid;
    while (left < right) {
        if (arr[mid = (left + right) / 2] < key) left = mid + 1;
        else right = mid;
    }
    return left;
}

int main()
{
    int N, idx = 0, res = 0, temp;
    scanf("%d", &N);
    scanf("%d", &temp);
    dp[idx++] = temp;
    while (--N) {
        scanf("%d", &temp);
        if (dp[idx - 1] < temp) dp[idx++] = temp;
        else dp[lowerBound(dp, idx, temp)] = temp;
    }
    printf("%d", idx);
}
