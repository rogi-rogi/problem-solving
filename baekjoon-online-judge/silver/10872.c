#include <stdio.h>
int factorial(int n){
	return (!n ? 1 : n * factorial(n-1));
}
int main(){
	int N;
	scanf("%d", &N);
	printf("%d", factorial(N));
}