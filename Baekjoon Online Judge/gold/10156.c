#include <stdio.h>
int main(){
	int K, N, M;
	scanf("%d %d %d", &K, &N, &M);
	printf("%d", K*N > M ? K*N-M : 0);
}