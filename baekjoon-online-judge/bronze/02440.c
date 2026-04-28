#include <stdio.h>
int main() {
	int N;
	scanf("%d", &N);
	while (N--)
		for (int i = 0; i < N + 2; i++)
			putchar(i <= N  ? '*' : 10);
}