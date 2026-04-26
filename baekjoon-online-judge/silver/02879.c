#include <stdio.h>
#include <math.h>
int main(){
	int N;
	scanf("%d", &N);
	int dp[N], val, line = N;
	for (int i = 0; i < N; i++)
		scanf("%d", &dp[i]);
	for (int i = 0; i < N; i++){
		scanf("%d", &val);
		dp[i] -= val;
		!dp[i] && --line;
	}

	int cnt = 0;
	while (line){
		int start = 0, end, min = 80, op = 0;
		for (int i = 0; i < N; i++){
			if (!op && !dp[i]) continue;

			if (!op){
				start = i;
				op = (dp[i] > 0 ? -1 : 1);
			}else if (!dp[i] || dp[i]>0 && op==1 || dp[i]<0 && op==-1) break;

			end = i;
			int temp = abs(dp[i]);
			min > temp && (min = temp);
		}

		for (int j = start; j <= end; j++){
			dp[j] += min*op;
			if (!dp[j]) line--;
		}
		cnt += min;
	}
	printf("%d", cnt);
}