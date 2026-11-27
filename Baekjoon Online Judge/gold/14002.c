#include <stdio.h>
#define SIZE 1000000

int A[SIZE], dp[SIZE], index_list[SIZE];

void print_LIS(int length, int idx)
{
    if (idx == -1) return;
    if (index_list[idx] == length) {
        print_LIS(length - 1, idx - 1);
        printf("%d ", A[idx]);
    } else print_LIS(length, idx - 1);
}

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
    int N;
    scanf("%d", &N);
    scanf("%d", &A[0]);
    dp[0] = A[0];
    index_list[0] = 0;
    int idx = 1, temp_idx;
    for(int i = 1; i < N; ++i) {
        scanf("%d", &A[i]);
        if (A[i] > dp[idx - 1]) {
            dp[idx] = A[i];
            index_list[i] = idx++;
        } else {
            temp_idx = lowerBound(dp, idx - 1, A[i]);
            dp[temp_idx] = A[i];
            index_list[i] = temp_idx;
        }
    }
    printf("%d\n", idx);
    print_LIS(idx - 1, N - 1);
}
