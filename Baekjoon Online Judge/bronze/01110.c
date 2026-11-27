#include <stdio.h>
int main() {
	int N, circle = 0, result;
	scanf("%d", &N);
	int save_N = N;
	while (1) {
		result = ((N%10)*10) + (((N/10) + (N%10))%10);
		circle++;
		if (result == save_N)
			break;
		N = result;
	}
	printf("%d", circle);
}