#include <stdio.h>
#include <stdlib.h>
int main() {
	int N;
	scanf("%d", &N);
	for (int i = -N + 1; i < N; i++){
		for (int j = abs(i); j < N; j++)
			putchar('*');
		putchar(10);
	}
}