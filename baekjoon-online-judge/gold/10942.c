#include <stdio.h>
int dp[2001][2001];
int main(){
	int N, M;
	scanf("%d", &N);
	int arr[N+1], S, E;
	for (int i = 1; i <= N; i++){
		scanf("%d", &arr[i]);
		dp[i][i] = 1;
		if (i > 1 && arr[i] == arr[i-1]) dp[i-1][i] = 1;
	}

	for (int len = 2; len < N; len++)
		for (int S = 1; (E = S+len) <= N; S++)
			if (arr[S] == arr[E] && dp[S+1][E-1]) dp[S][E] = 1;

	scanf("%d", &M);
	while (M--){
		scanf("%d %d", &S, &E);
		printf("%d\n", dp[S][E]);
	}
}