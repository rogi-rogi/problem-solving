#include <stdio.h>
#define LL long long
LL GCD(LL a, LL b){
    return b ? GCD(b, a%b) : a;
}
int main(){
    LL A, B;
    scanf("%lld %lld", &A, &B);
    LL i = GCD(A, B);
	while (i--) putchar('1');
}