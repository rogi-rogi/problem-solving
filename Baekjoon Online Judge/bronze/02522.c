#include <stdio.h>
#include <math.h>
int main(){
	int N;
	scanf("%d", &N);
	for (int i = -N + 1; i < N; i++){
		for (int j = 0; j < N; j++)
			putchar(j < abs(i) ? 32 : '*');
		putchar(10);
	}
}