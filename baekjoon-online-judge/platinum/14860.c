#include <stdio.h>
#include <stdbool.h>
#define MOD 1000000007
#define LL long long
bool visited[15000001];
int main(){
	int N, M;
	LL result = 1;
	scanf("%d %d", &N, &M);
	for (LL i = 2; i <= N; i++)
		if (!visited[i]){
			for (LL p = i*i; p <= N; p += i)
				visited[p]++;

			for (LL j = i; j <= N; j *= i){
				LL x = i, n = (N/j)*(M/j), temp = 1;
				while (n > 0){
					if (n & 1) temp = temp*x %MOD;
					x = x*x %MOD;
					n >>= 1;
				}
				result = result * temp %MOD;
			}
		}
	printf("%lld", result);
}