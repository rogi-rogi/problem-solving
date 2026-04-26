#include <stdio.h>
int main() {
	int N, sum = 0;
	scanf("%d", &N);
	for (; N; sum += N--);
	printf("%d", sum);
}