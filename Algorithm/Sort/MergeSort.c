#define SIZE 500000

int arr[SIZE], buff[(SIZE>>1) + 1];

static void __MergeSort(int left, int right)
{
  if (left < right) {
    int mid = (left + right) / 2;
    __MergeSort(left, mid);
    __MergeSort(mid + 1, right);
    /*
    int idx = left, buff_p = 0;
    while (idx <= mid) buff[buff_p++] = arr[idx++];
    int sort_p = left, buff_idx = 0;
    */
    memcpy(buff, &arr[left], sizeof(int) * (mid - left + 1));
    int idx = mid + 1, sort_p = left;
    int buff_idx = 0, buff_p = mid - left + 1; 
   
    while (idx <= right && buff_idx < buff_p)
      arr[sort_p++] = ((buff[buff_idx] <= arr[idx]) ? buff[buff_idx++] : arr[idx++]);
    memcpy(&arr[sort_p], &buff[buff_idx], sizeof(int) * (buff_p - buff_idx)); // while (buff_idx < buff_p) arr[sort_p++] = buff[buff_idx++];
  }
}

void MergeSort(int size) { __MergeSort(0, size - 1); }
