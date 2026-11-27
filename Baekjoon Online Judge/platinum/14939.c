#include <stdio.h>
#include <string.h>
#include <memory.h>
#define min(a, b) a < b ? a : b
char bulb[10][10], temp[10][10];
const char* lRow = "##########";
int dx[5] = {0, -1, 1}, dy[5] = {0, 0, 0, -1, 1};

void press(int x, int y){
	for (int i = 0; i < 5; i++){
		int nx = x + dx[i], ny = y + dy[i];

		if (nx >= 0 && ny >= 0 && nx < 10 && ny < 10)
			temp[nx][ny] = (temp[nx][ny] == '#' ? 'O' : '#');
	}
}
int main(){
	for (int i = 0; i < 100; i++)
		scanf(" %c", &bulb[i/10][i%10]);

	int cnt = 101;
	for (int fRow = (1 << 10)-1; fRow >= 0; fRow--){
		int temp_cnt = 0;
		memcpy(temp, bulb, sizeof(bulb));

		for (int fCol = 0; fCol < 10; ++fCol)
			if (fRow & (1 << fCol)){
				press(0, fCol);
				temp_cnt++;
			}

		for (int nRow = 1; nRow < 10; ++nRow)
			for (int nCol = 0; nCol < 10; nCol++)
				if (temp[nRow-1][nCol] == 'O'){
					press(nRow, nCol);
					temp_cnt++;
				}

		if (!strcmp(temp[9], lRow))
			cnt = min(cnt, temp_cnt);
	}
	printf("%d\n", cnt == 101 ? -1 : cnt);
}