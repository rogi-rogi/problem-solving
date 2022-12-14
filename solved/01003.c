#include <stdio.h>

int main()
{
	int T;
	scanf("%d", &T);
	while (T--) {
		int dp[2] = {1, 0}, N;
		scanf("%d", &N);
		while (N--) {
			int temp = dp[0] + dp[1];
			dp[0] = dp[1];
			dp[1] = temp;
		}
		printf("%d %d\n", dp[0], dp[1]);
	}
}
