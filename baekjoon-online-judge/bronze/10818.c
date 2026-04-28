#include <stdio.h>
int main() {
	int N, num, max, min;
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%d", &num);
		if (!i) max = min = num;
		if (num < min) min = num;
		else if (num > max) max = num;
	}
	printf("%d %d", min, max);
}