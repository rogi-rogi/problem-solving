#include <stdio.h>
int main(){
	int N, sum = 0;
	char str[101];
	scanf("%d %s", &N, str);
	for (int i = 0; i < N; i++)
		sum += str[i] - 48;
	printf("%d", sum);
}