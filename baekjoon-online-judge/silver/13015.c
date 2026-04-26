#include <stdio.h>
#include <math.h>
int main(){
	int N;
	scanf("%d", &N);
	for (int i = -N+1; i < N; i++){
		for (int j = -2*N+2; j < N + abs(i); j++)
			if (abs(j) >= N-1 && abs(i) == N-1) putchar('*');
			else putchar((abs(j)-abs(i) == N-1) || (abs(i)==abs(j)) ? '*' : 32);
		putchar(10);
	}
}