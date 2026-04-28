#include <stdio.h>
int main(){
	int T, N;
	long long dp[100] = {1, 1, 1, 2, 2};
	for (int i = 5; i < 100; i++)
		dp[i] = dp[i-5] + dp[i-1];
	scanf("%d", &T);
	while (T--){
		scanf("%d", &N);
		printf("%lld\n", dp[N-1]);
	}
}