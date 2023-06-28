#include <stdio.h>
#include <math.h>

void hanoi(int n, int from, int to, int temp)
{
	if(n == 1) printf("%d %d\n", from, to);
	else{
		hanoi(n - 1, from, to, temp);
		printf("%d %d\n", from, to);
		hanoi(n - 1, temp, from, to);
	}
}

int main()
{
	int n;
	scanf("%d", &n);
	printf("%d\n", (int)pow(2, n) - 1);
	hanoi(n, 1, 2, 3);
}
