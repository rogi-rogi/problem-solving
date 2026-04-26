#include <stdio.h>
#include <stdlib.h>
int N, M, arr[8], visited[8];
int compare(const void *a, const void *b){
	return *(int*)a - *(int*)b;
}
void BT(int depth, int start){
	for (int i = start, temp = 0; i < N; i++)
		if (temp != arr[i]){
			temp = visited[depth] = arr[i];

			if (depth + 1 == M){
				for (int idx = 0; idx < M; idx++)
					printf("%d ", visited[idx]);
				putchar(10);
			}else BT(depth + 1, i);
		}
}
int main(){
	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; i++)
		scanf("%d", &arr[i]);
	qsort(arr, N, sizeof(int), compare);
	BT(0, 0);
}