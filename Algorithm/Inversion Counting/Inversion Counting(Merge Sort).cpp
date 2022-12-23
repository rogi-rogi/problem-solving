#include <iostream>

#define SIZE 500000

int arr[SIZE], buff[(SIZE>>1) + 1];
long long res = 0;

static void __mergeSort(int left, int right)
{
  if (left < right) {
    int mid = (left + right) / 2;
    __mergeSort(left, mid);
    __mergeSort(mid + 1, right);
    int idx = left, buff_p = 0;
    while (idx <= mid) buff[buff_p++] = arr[idx++];
    int sort_p = left, buff_idx = 0;
    while (buff_idx < buff_p && idx <= right)
      if (buff[buff_idx] <= arr[idx])
        arr[sort_p++] = buff[buff_idx++];
      else {
        arr[sort_p++] = arr[idx++];
        res += (long long)(buff_p - buff_idx);
      }
    while (buff_idx < buff_p)
      arr[sort_p++] = buff[buff_idx++];
  }
}

void mergeSort(int size) { __mergeSort(0, size - 1); }

int main()
{
    int N;
    cin >> N;
    for (int i = 0; i < N; ++i) cin >> arr[i];
    mergeSort(N);
    cout << res;
}
