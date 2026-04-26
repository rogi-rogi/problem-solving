#include <stdio.h>
#define min(a, b) a > b ? b : a
int dp[50001];
int main(){
	int n;
	scanf("%d", &n);
	for (int i = 1; i <= n; i++){
		dp[i] = dp[i-1] + 1;
		for (int j = 2; j*j <= i; j++)
			dp[i] = min(dp[i], dp[i-j*j] + 1);
	}
	printf("%d", dp[n]);
}