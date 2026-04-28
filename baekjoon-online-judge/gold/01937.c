#include <stdio.h>
#define max(a,b) a > b ? a : b
#define MAX 500
int forest[MAX][MAX], n;
int dp[MAX][MAX];
int dx[4] = {-1, 1}, dy[4] = {0, 0, -1, 1};

int dfs(int x, int y){
	if (!dp[x][y]){
		dp[x][y] = 1;
		for (int i = 0; i < 4; i++){
			int tx = x + dx[i], ty = y + dy[i];

			if (tx >= 0 && ty >= 0 && tx < n && ty < n)
				if (forest[tx][ty] > forest[x][y])
					dp[x][y] = max(dp[x][y], dfs(tx, ty)+1);
		}
	}
	return dp[x][y];
}
int main(){
	scanf("%d", &n);
	for (int i = 0; i < n*n; i++)
		scanf("%d", &forest[i/n][i%n]);

	int cnt = 0;
	for (int i = 0; i < n; i++)
		for(int j = 0; j < n; j++)
			cnt = max(cnt, dfs(i, j));
	printf("%d", cnt);
}