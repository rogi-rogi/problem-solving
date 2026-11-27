#include <stdio.h>
int main(){
	int N, dp[2] = {1, 2}, temp;
	scanf("%d", &N);
    if (N == 1){
        printf("%d", 1);
        return 0;
    }
	for (int i = 3; i <= N; i++){
		temp = dp[0];
		dp[0] = dp[1];
		dp[1] = (temp + dp[1]) % 15746;
	}
	printf("%d", dp[1]);
}