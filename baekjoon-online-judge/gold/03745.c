#include <stdio.h>
#include <memory.h>
#define SIZE 1000000

int temp[SIZE];

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
    while (scanf("%d", &N) != EOF) {
        int idx = 0, res = 0, val;
        scanf("%d", &val);
        temp[idx++] = val;
        while(--N) {
            scanf("%d", &val);
            if (temp[idx - 1] < val) temp[idx++] = val;
            else temp[lowerBound(temp, idx, val)] = val;
        }
        printf("%d\n", idx);
        memset(temp, 0, SIZE * sizeof(int));
    }
}
