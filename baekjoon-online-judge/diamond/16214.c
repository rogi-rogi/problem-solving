#include <stdio.h>
int EPF(int n){
	int euler = n;
	for (int p = 2; p*p <= n; p++){
		if (n % p == 0) euler = euler/p *(p - 1);
		while (n % p == 0) n = n/p;
	}
	return n == 1 ? euler : euler/n *(n - 1);
}

int NM(int n, int m){
	if (n == 1 || m == 1) return 1;
	long long A = n;
	int B = NM(n, EPF(m)) + EPF(m), result = 1;
	while (B){
		if (B & 1) result = result*A %m;
		B >>= 1;
		A = A*A %m;
	}
	return result;
}

int main(){
	int T, N, M, result;
	scanf("%d", &T);
	while (T--){
		scanf("%d %d", &N, &M);
		printf("%d\n", NM(N, M) %M);
	}
}