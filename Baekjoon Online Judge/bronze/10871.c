#include <stdio.h>
int main(){
	int N, X, num;
	scanf("%d %d", &N, &X);
	while (N-- && scanf("%d", &num))
		num < X && printf("%d ", num);
}