#include <stdio.h>
#define ll long long
const int MOD = 1e9;
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
    ll n1, n2, result = 0;
    scanf("%lld %lld", &n1, &n2);
	ll n = n1+1;
	for (int op = -1; op < 2; op+= 2){
		ll temp[2][2] = {1, 0, 0, 1};
		while (n){
        	if (n & 1) fibo(temp, X);
       		fibo(X, X);
        	n >>= 1;
    	}
    	result = op*(result + temp[1][0]-1) %MOD;
    	X[0][0] = 0;
		X[0][1] = X[1][0] = X[1][1] = 1;
    	n = n2+2;
	}
    printf("%lld", (result+MOD)%MOD);
}