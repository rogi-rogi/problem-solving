#include <stdio.h>
int main(){
	int N, M, K, x1, y1, x2, y2;
	scanf("%d %d", &N, &M);
	int arr[N][M];
	for (int i = 0; i < N*M; i++)
		scanf("%d", &arr[i/M][i%M]);
	scanf("%d", &K);
	while (K--){
		scanf("%d %d %d %d", &x1, &y1, &x2, &y2);
		int sum = 0;
		for (int i = x1; i <= x2; i++)
			for (int j = y1; j <= y2; j++)
				sum += arr[i-1][j-1];
		printf("%d\n", sum);
	}
}