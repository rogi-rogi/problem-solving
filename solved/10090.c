#include <stdio.h>
#include <stdlib.h>
#define SIZE 1000000

int arr[SIZE], buff[(SIZE>>1) + 1];
long long res = 0;

static void __mergeSort(int left, int right)
{
  if (left < right) {
    int mid = (left + right) / 2;
    __mergeSort(left, mid);
    __mergeSort(mid + 1, right);
    long long cnt = 0;
    int idx = left, buff_p = 0;
    while (idx <= mid) buff[buff_p++] = arr[idx++];
    int sort_p = left, buff_idx = 0;
    while (idx <= right && buff_idx < buff_p)
      if (buff[buff_idx] <= arr[idx]) {
        arr[sort_p++] = buff[buff_idx++];
        res += cnt;
      } else {
        arr[sort_p++] = arr[idx++];
        ++cnt;
      }
    while (buff_idx < buff_p) {
      arr[sort_p++] = buff[buff_idx++];
      res += cnt;
    }
  }
}

void mergeSort(int size) { __mergeSort(0, size - 1); }

int main()
{
    int N;
    scanf("%d", &N);
    for (int i = 0; i < N; ++i) scanf("%d ", &arr[i]);
    mergeSort(N);
    printf("%lld", res);
}
