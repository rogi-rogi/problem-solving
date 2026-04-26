#include <stdio.h>
#define min(a, b) a < b ? a : b
char bulb[18][18], temp[18][18];
int dx[5] = {0, -1, 1}, dy[5] = {0, 0, 0, -1, 1}, N;

void press(int x, int y){
	for (int i = 0; i < 5; i++){
		int nx = x + dx[i], ny = y + dy[i];

		if (nx >= 0 && ny >= 0 && nx < N && ny < N)
			temp[nx][ny] = (temp[nx][ny] == '1' ? '0' : '1');
	}
}
int main(){
	scanf("%d", &N);

	for (int i = 0, val; i < N*N; i++)
		scanf(" %c", &bulb[i/N][i%N]);

	int cnt = N*N+1;
	for (int fRow = (1 << N)-1; fRow >= 0; fRow--){
		int temp_cnt = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				temp[i][j] = bulb[i][j];

		for (int fCol = 0; fCol < N; fCol++)
			if (fRow & (1 << fCol)){
				press(0, fCol);
				temp_cnt++;
			}

		for (int nRow = 1; nRow < N; nRow++)
			for (int nCol = 0; nCol < N; nCol++)
				if (temp[nRow-1][nCol] == '1'){
					press(nRow, nCol);
					temp_cnt++;
				}

		int flag = 1;
        for (int nCol = 0; nCol < N; nCol++)
        	if (temp[N-1][nCol] == '1'){
        		flag = 0;
        		break;
			}
		if (flag) cnt = min(cnt, temp_cnt);
	}
	printf("%d\n", cnt == N*N+1 ? -1 : cnt);
}