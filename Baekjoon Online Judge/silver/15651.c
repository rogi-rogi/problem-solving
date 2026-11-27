#include <stdio.h>
int N, M, visited[7];
void BT(int depth){
	for (int i = 0; i < N; i++){
		visited[depth] = i+1;

		if(depth + 1 == M){
			for (int idx = 0; idx < M; idx++)
				printf("%d ", visited[idx]);
			putchar(10);
		}else BT(depth + 1);
	}
}
int main(){
	scanf("%d %d", &N, &M);
	BT(0);
}