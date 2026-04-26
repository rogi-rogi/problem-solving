#include <stdio.h>
#include <stdbool.h>
bool board[11][11], l[19], r[19];
int N, result[2];

void bishop(int row, int col, int cnt, int color){
	if (col >= N){
		col = (col+1)%2;

        if (++row == N){
			cnt > result[color] && (result[color] = cnt);
			return;
		}
	}

	int lp = (col-row)+N-1, rp = row+col;
	if (board[row][col] && l[lp] + r[rp] == 0){
		l[lp] = r[rp] = true;
		bishop(row, col + 2, cnt + 1, color);
		l[lp] = r[rp] = false;
	}

	bishop(row, col+2, cnt, color);
}
int main(){
	scanf("%d", &N);
	for (int i = 0; i < N*N; i++)
		scanf("%d", &board[i/N][i%N]);

	bishop(0, 0, 0, 0);
	bishop(0, 1, 0, 1);
	printf("%d", result[0]+result[1]);
}