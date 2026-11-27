#include <stdio.h>
#define min(a, b) a < b ? a : b
int main(){
	int arr[100000], N, S, start = 0, end = 0;
	scanf("%d %d %d", &N, &S, &arr[0]);
	for (int i = 1; i < N; i++)
		scanf("%d", &arr[i]);

	int cnt = 1e5, sum = arr[0];
	while (start <= end && end < N){
		if (sum >= S)
			cnt = min(cnt, end - start + 1);
		sum += (sum < S ? arr[++end] : -arr[start++]);
	}
	printf("%d", cnt == 1e5 ? 0 : cnt);
}