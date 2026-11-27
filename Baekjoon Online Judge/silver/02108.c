#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b) {return *(int*)a - *(int*)b;}

double get_arithmetic_mean(double sum, int N) {return sum / N;}

int get_median(int *arr, int N) {return (N == 1 ? arr[0] : arr[(N+1) / 2 - 1]);}

int get_mode(int *arr, int N)
{
    int num[8001] = {0,}, max = 0, cnt = 0, idx;
    for (int i = 0; i < N; ++i) {
        ++num[idx = arr[i] + 4000];
        max < num[idx] && (max = num[idx]);
    }
    idx = 0;
    for (int i = 0; i < 8001 ; ++i)
        if (num[i] == max)
            if (cnt == 0) {
                idx = i;
                ++cnt;
            } else if (cnt == 1) {
                idx = i;
                break;
            }
    return idx - 4000;
}

int main()
{
    int N;
    scanf("%d", &N);
    double sum = 0;
    int arr[N];
    for (int i = 0; i < N; ++i) {
        scanf("%d", &arr[i]);
        sum += arr[i];
    }
    qsort(arr, N, sizeof(int), compare);
    double avg = get_arithmetic_mean(sum, N);
    if (avg > -1 && avg  < 0) avg = 0;
    printf("%.0f\n", avg);
    printf("%d\n", get_median(arr, N));
    printf("%d\n", get_mode(arr, N));
    printf("%d\n", arr[N-1] - arr[0]);
}
