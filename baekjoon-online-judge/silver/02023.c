#include <stdio.h>
#include <math.h>
int prime(int num){
	int sq = sqrt(num);
	for (int i = 2; i <= sq; i++)
		if (num%i == 0) return 0;
	return 1;
}
void dfs(int num, int digit){
	if (digit == 1) printf("%d\n", num);
	else
		for (int i = 1; i < 10; i += 2)
			if (prime(num*10 + i))
				dfs(num*10 + i, digit - 1);
}
int main(){
	int N;
	scanf("%d", &N);
	dfs(2, N);
	dfs(3, N);
	dfs(5, N);
	dfs(7, N);
}