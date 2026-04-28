#include <stdio.h>
const int MOD = 1e9+7;
int main(){
	long long N, K, A = 1, B = 1;
	scanf("%d %d", &N, &K);
	for (int i = N; i > N-K; i--)
		A = A*i %MOD;
	for (int i = K; i >= 2; i--)
		B = B*i %MOD;

	N = 1, K = MOD-2;
	while (K){
		if (K & 1) N = N*B %MOD;
		K >>= 1;
		B = B*B %MOD;
	}
	printf("%d", A*N %MOD);
}