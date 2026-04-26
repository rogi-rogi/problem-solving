#include <stdio.h>
int main(){
	int N, cnt;
	scanf("%d", &N);
	for (cnt = 1; N > 1; cnt++)
		N -= (6*cnt);
	printf("%d", cnt);
}