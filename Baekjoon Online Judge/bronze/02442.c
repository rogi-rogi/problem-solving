#include <stdio.h>
int main() {
	int N;
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
	    for (int j = 0; j < N + i; j++)
	        putchar(j < N-i-1 ? 32 : '*');
		putchar(10);
	}
}