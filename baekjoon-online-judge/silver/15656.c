#include <stdio.h>
#include <stdlib.h>
int N, M, arr[7], visited[7];
int compare(const void *a, const void *b){
	return *(int*)a - *(int*)b;
}
void BT(int depth){
	for (int i = 0; i < N; i++){
		visited[depth] = arr[i];

		if(depth + 1 == M){
			for (int idx = 0; idx < M; idx++)
				printf("%d ", visited[idx]);
			putchar(10);
		}else BT(depth + 1);
	}
}
int main(){
	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; i++)
		scanf("%d", &arr[i]);
	qsort(arr, N, sizeof(int), compare);
	BT(0);
}