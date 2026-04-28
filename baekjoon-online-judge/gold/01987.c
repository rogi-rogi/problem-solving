#include <stdio.h>
#include <stdbool.h>
char arr[20][20];
bool visited[26];
int R, C, result;
int dx[4] = {-1, 1}, dy[4] = {0, 0, -1, 1};

void BT(int x, int y, int cnt){
	cnt > result && (result = cnt);

	for (int i = 0; i < 4; i++){
		int nx = x + dx[i], ny = y + dy[i];

		if (nx >= 0 && ny >= 0 && nx < R && ny < C){
			int idx = arr[nx][ny] - 65;

			if (!visited[idx]){
				visited[idx] = true;
				BT(nx, ny, cnt + 1);
				visited[idx] = false;
			}
		}
	}
}
int main(){
	scanf("%d %d", &R, &C);
	for(int i = 0; i < R; i++)
		for (int j = 0; j < C; j++)
			scanf(" %c", &arr[i][j]);

	visited[arr[0][0]-65] = true;
	BT(0, 0, 1);
	printf("%d", result);
}