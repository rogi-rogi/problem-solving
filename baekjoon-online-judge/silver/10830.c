#include <stdio.h>
int N;
void square(int result[][5], int matrix[][5]){
	int temp[5][5] = {0,};
	for (int i = 0; i < N; i++)
		for (int j = 0; j < N; j++)
			for (int k = 0; k < N; k++)
				temp[i][j] += (result[i][k]*matrix[k][j]) %1000;

	for (int i = 0; i < N; i++)
		for (int j = 0; j < N; j++)
			result[i][j] = temp[i][j] %1000;
}
int main(){
	long long B;
	scanf("%d %lld", &N, &B);
	int matrix[5][5], result[5][5] = {0,};
	for (int i = 0; i < N; i++){
		for (int j = 0; j < N; j++)
			scanf("%d", &matrix[i][j]);
		result[i][i] = 1;
	}

	while (B){
		if (B&1) square(result, matrix);
		square(matrix, matrix);
		B >>= 1;
	}

	for (int i = 0; i < N; i++){
		for (int j = 0; j < N; j++)
			printf("%d ", result[i][j]);
		putchar(10);
	}
}