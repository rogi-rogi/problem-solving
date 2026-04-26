#include <stdio.h>
int gcd(int a, int b){
	return b ? gcd(b, a%b) : a;
}
int main(){
	int N, M;
	scanf("%d %d", &N, &M);
	printf("%d", M - gcd(N, M));
}