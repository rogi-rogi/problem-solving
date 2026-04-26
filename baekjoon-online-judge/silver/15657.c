#include <stdio.h>
#include <stdlib.h>
int arr[8], N, M, num[8];
int compare(const void *a, const void *b){
	return *(int*)a - *(int*)b;
}
void BT(int depth){
	for (int i = 0; i < N; i++){
		if (!depth) arr[0] = num[i];
		else{
			int j;
			for (j = 0; j < depth; j++)
				if (arr[j] > num[i]) break;

			if (j == depth) arr[depth] = num[i];
			else continue;
		}

		if (depth + 1 == M){
			for (int idx = 0; idx < M; idx++)
				printf("%d ", arr[idx]);
			putchar(10);
		}else BT(depth + 1);
	}
}
int main(){
	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; i++)
		scanf("%d", &num[i]);
	qsort(num, N, sizeof(int), compare);
	BT(0);
}