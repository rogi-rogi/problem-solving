#include <stdio.h>
int main(){
	int n, op = 1;
	long long dp[2] = {0, 1};
	scanf("%d", &n);
	if (n < 0){
		if (n%2 == 0) op = -1;
		n *= -1;
	}else op = (n ? 1 : 0);
	if (n >= 2){
		for (int i = 1; i < n; i++){
			long long temp = (dp[0] + dp[1]) %1000000000;
			dp[0] = dp[1], dp[1] = temp;
		}
		n = 1;
	}
	printf("%d\n%lld", op, dp[n]);
}