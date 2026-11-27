#include <stdio.h>
#define MAX 101
#define max(a, b) a > b ? a : b
int c[MAX], m[MAX];
int dp[10001];
int main(){
	int N, M;
	scanf("%d %d", &N, &M);

	for (int i = 0; i < N; i++)
		scanf("%d", &m[i]);

	int sum = 0;
	for (int i = 0; i < N; i++){
		scanf("%d", &c[i]);
		sum += c[i];
	}

	for (int i = 0; i < N; i++)
		for (int cost = sum; cost >= c[i]; cost--)
			dp[cost] = max(dp[cost], dp[cost-c[i]] + m[i]);

	for (int cost = 0; cost <= sum; cost++)
		if (dp[cost] >= M){
			printf("%d", cost);
			break;
		}
}