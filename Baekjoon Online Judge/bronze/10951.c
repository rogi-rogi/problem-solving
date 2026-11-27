#include <stdio.h>
int main() {
	int A, B;
	while (EOF != scanf("%d %d", &A, &B) && printf("%d\n", A + B));
}