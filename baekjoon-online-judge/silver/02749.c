#include <stdio.h>
#define MOD 1000000
#define P 1500000
int dp[P]={0,1};
int main(){
	long long n;
	scanf("%lld", &n);
	for (int i = 2; i < P; i++){
		dp[i] = dp[i-1] + dp[i-2];
		dp[i] %= MOD;
	}
	printf("%d", dp[n%P]);
}