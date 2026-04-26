#include <stdio.h>
#include <memory.h>
char arr[399][397];
void mark_star(int p, int N){
	if (N == 1){
		arr[p][p] = arr[p+1][p] = arr[p+2][p] = '*';
	}else {
		int row = 4*N-1, col = row-2;
		for (int i = p; i < p+col; i++)
			arr[p][i] = arr[p+row-1][i] = '*';

		for (int i = p+2; i < p+row-1; i++)
			arr[i][p] = arr[i][p+col-1] = '*';

		arr[p+1][p] = arr[p+2][p+col-2] = '*';

		mark_star(p+2, N-1);
	}
}
int main(){
	int N;
	scanf("%d", &N);
	if (N == 1) putchar('*');
	else {
		memset(arr, 32, sizeof(arr));
		mark_star(0, N);

		int row = 4*N-1, col = row-2;
		for (int i = 0; i < row; i++)
			if (i != 1){
				for (int j = 0; j < col; j++)
					putchar(arr[i][j]);
				putchar(10);
			}else puts("*");
	}
}