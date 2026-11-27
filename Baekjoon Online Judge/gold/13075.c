#include <stdio.h>
#define ll long long
const int MOD = 1e9;
ll X[2][2] = {0, 1, 1, 1};

void fibo(ll result[][2], ll f[][2]){
	ll temp[2][2] = {0,};
	for (int i = 0; i < 2; i++)
		for (int j = 0; j < 2; j++)
			for (int k = 0; k < 2; k++)
				temp[i][j] += (result[i][k]*f[k][j]) %MOD;

	for (int i = 0; i < 2; i++)
		for (int j = 0; j < 2; j++)
			result[i][j] = temp[i][j] %MOD;
}
int main(){
	int t;
	scanf("%d", &t);
	while (t--){
		ll n;
		scanf("%lld", &n);

		ll result[2][2] = {1, 0, 0, 1};
		while (n){
			if (n & 1) fibo(result, X);
			fibo(X, X);
			n >>= 1;
		}
		printf("%lld\n", result[1][0]);
		X[0][0] = 0;
		X[0][1] = X[1][0] = X[1][1] = 1;
	}
}