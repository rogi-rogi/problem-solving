#include <stdio.h>
int r, c, cnt;
void Z(int row, int col, int n){
	if (row == r && col == c){
		printf("%d\n", cnt);
		return;
	}
    if (r >= row && c >= col && r < row + n && c < col + n) {
		Z(row, col, n/2);
		Z(row, col + n/2, n/2);
		Z(row + n/2, col, n/2);
		Z(row + n/2, col + n/2, n/2);
	}
	else cnt += n*n;
}
int main(){
	int N;
	scanf("%d %d %d", &N, &r, &c);
	Z(0, 0, 1 << N);
}