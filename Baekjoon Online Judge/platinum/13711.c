#include <stdio.h>
#define SIZE 100000

int std[SIZE], index_list[SIZE], target[SIZE], temp[SIZE];

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
    int N, val, i;
    scanf("%d", &N);
    for (i = 0; i < N; ++i) scanf("%d", &std[i]);
    for (i = 0; i < N; ++i) {
        scanf("%d", &val);
        index_list[val - 1] = i;
    }
    for (i = 0; i < N; ++i) target[i] = index_list[std[i] - 1];
    temp[0] = target[0];
    int length = 1;
    for (i = 1; i < N; ++i) {
        if (temp[length - 1] < target[i]) temp[length++] = target[i];
        else temp[lowerBound(temp, length, target[i])] = target[i];
    }
    printf("%d", length);
}
