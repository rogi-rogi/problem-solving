#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int compare(const void *a, const void *b){
	return *(int*)a - *(int*)b;
}
int main(){
	int N;
	scanf("%d", &N);
	int arr[N];
	for (int i = 0; i < N; i++)
		scanf("%d", &arr[i]);
	qsort(arr, N, sizeof(int), compare);

	int left = 0, right = N-1, sum = 2e9;
	int left_val = arr[left], right_val = arr[right];
	while (left < right){
		int temp = arr[left] + arr[right];

		if (abs(temp) < sum){
			sum = abs(temp);
			left_val = arr[left];
			right_val = arr[right];
		}

		temp < 0 ? ++left : --right;
	}
	printf("%d %d", left_val, right_val);
}