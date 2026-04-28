#include <stdio.h>
#include <stdlib.h>
#define ll long long
int compare(const void *a, const void *b){
	return *(int*)a - *(int*)b;
}
int main(){
	int N;
	scanf("%d", &N);
	int arr[N];
	for (int i = 0; i < N; i++)
		scanf("%lld", &arr[i]);
	qsort(arr, N, sizeof(int), compare);

	ll sum = 3e9;
	int val[3] = {0};
	for (int idx = 0; idx < N-2; idx++){
		int left = idx+1, right = N-1;

		while (left < right){
			ll temp = (ll)arr[idx] + arr[left] + arr[right];

			if (llabs(temp) < sum){
				sum = llabs(temp);
				val[0] = arr[idx];
				val[1] = arr[left];
				val[2] = arr[right];
			}

			temp < 0 ? ++left : --right;
		}
	}
	printf("%d %d %d", val[0], val[1], val[2]);
}