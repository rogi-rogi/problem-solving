#include <stdio.h>
int main(){
	int N, M;
	scanf("%d %d", &N, &M);
	int arr[N];
	for (int i = 0; i < N; i++)
		scanf("%d", &arr[i]);
	int start = 0, end = 0, sum = 0, cnt = 0;
	while (end <= N){
		sum += (sum < M ? arr[end++] : -arr[start++]);
		sum == M && cnt++;
	}
	printf("%d", cnt);
}