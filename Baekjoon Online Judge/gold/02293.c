#include <stdio.h>
int main(){
	int n, k;
	scanf("%d %d", &n, &k);
	int coin[n], dp[100001] = {1,};
	for (int i = 0; i < n; i++)
		scanf("%d", &coin[i]);
	for (int i = 0; i < n; i++)
		for (int j = coin[i]; j <= k; j++)
			dp[j] += dp[j - coin[i]];
	printf("%d", dp[k]);
}