#include <stdio.h>
#define ll long long
int gcd(int a, int b){
	return b ? gcd(b, a%b) : a;
}
ll lcm(int a, int b){
	return (ll)a*b/gcd(a, b);
}
int main(){
	int n, a, b;
	scanf("%d", &n);
	while (n--){
		scanf("%d %d", &a, &b);
		printf("%lld\n", lcm(a, b));
	}
}