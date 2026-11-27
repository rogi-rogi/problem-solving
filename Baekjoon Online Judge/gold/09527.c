#include <stdio.h>
#define ll long long
ll count(ll n){
	ll cnt = 0, a = n, b = 1;
	while (a){
		cnt += (n+1)/(b << 1) *b;
		if (a & 1) cnt += (n+1)%b;
		a >>= 1;
		b <<= 1;
	}
	return cnt;
}
int main(){
	long long A, B;
	scanf("%lld %lld", &A, &B);
	printf("%lld", count(B) - count(A-1));
}