#include <stdio.h>
#define ll long long
const int MOD = 1e9 + 7;
ll X[2][2] = {0, 1, 1, 1};

void fibo(ll result[][2], ll f[][2]){
	int temp[2][2] = {0,};
	for (int i = 0; i < 2; i++)
		for (int j = 0; j < 2; j++)
			for (int k = 0; k < 2; k++)
				temp[i][j] += (result[i][k]*f[k][j]) %MOD;

	for (int i = 0; i < 2; i++)
		for (int j = 0; j < 2; j++)
			result[i][j] = temp[i][j] %MOD;
}
int main(){
	ll n, result[2][2] = {1, 0, 0, 1};
	scanf("%lld", &n);
	n += (n%2 ? 0 : 1);
	while (n){
		if (n & 1) fibo(result, X);
		fibo(X, X);
		n >>= 1;
	}
	printf("%d ", result[1][0] -1);
}