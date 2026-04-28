#include <stdio.h>
int main(){
	int X, cnt = 0;
	scanf("%d", &X);
	do{
		if (X & 1) cnt++;
	} while (X >>= 1);
	printf("%d", cnt);
}