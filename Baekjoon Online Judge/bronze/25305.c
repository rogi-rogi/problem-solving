#include <stdio.h>
#include <stdlib.h>

#define SIZE 1000
int arr[SIZE];

int compare(const void *a, const void *b)
{
    return (*(int*)a < *(int*)b);
}

int main()
{
    int N, k;
    scanf("%d %d", &N, &k);
    for (int i = 0; i < N; ++i) scanf("%d", &arr[i]);
    qsort(arr, N, sizeof(int), compare);
    printf("%d", arr[k - 1]);
}
