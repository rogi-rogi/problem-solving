#include <stdio.h>
int dp[1001][1001];
int min(int a, int b, int c){
	if (a < b && a < c) return a;
	return b < c ? b : c;
}
int main(){
	int n, m;
	scanf("%d %d", &n, &m);
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= m; j++)
			scanf("%1d", &dp[i][j]);

	int max = 0;
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= m; j++){
			if (dp[i][j]){
				dp[i][j] = min(dp[i][j-1], dp[i-1][j-1], dp[i-1][j]) + 1;
				max < dp[i][j] && (max = dp[i][j]);
			}
		}
	printf("%d", max*max);
}