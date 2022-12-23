#include <algorithm>
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
    /*
    int idx = left, buff_p = 0;
    while (idx <= mid) buff[buff_p++] = arr[idx++];
    int sort_p = left, buff_idx = 0;
    */
    
    copy(&arr[left], &arr[mid + 1], buff);
    int idx = mid + 1, sort_p = left;
    int buff_idx = 0, buff_p = mid - left + 1; 
    
    while (buff_idx < buff_p && idx <= right) {
      arr[sort_p++] = ((buff[buff_idx] <= arr[idx]) ? buff[buff_idx++] : arr[idx++]);
      if (buff[buff_idx] > arr[idx]) res += (long long)(buff_p - buff_idx); // get gap
    }
    copy(&buff[buff_idx], &buff[buff_p], &arr[sort_p]); // while (buff_idx < buff_p) arr[sort_p++] = buff[buff_idx++];
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
