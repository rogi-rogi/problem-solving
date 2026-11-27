#include <stdio.h>
int arr[8], N, M;
void BT(int depth){
	for (int i = 1; i <= N; i++){
		if (!depth) arr[0] = i;
		else{
			int j;
			for (j = 0; j < depth; j++)
				if (arr[j] > i) break;

			if (j == depth) arr[depth] = i;
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
	BT(0);
}