#include <stdio.h>
int main(){
	long A, B, C;
	scanf("%ld %ld %ld", &A, &B, &C);
	if (B >= C)
		puts("-1");
	else
		printf("%lld", A/(C-B)+1);
}