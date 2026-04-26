#include <stdio.h>
#include <math.h>
int main(){
	int N;
	scanf("%d", &N);
	for (int i = -2*N+2; i < 2*N-1; i++){
		for (int j = -2*N+2; j < 2*N-1; j++){
			if (i%2==0 && abs(j) <= abs(i)) putchar('*');
			else if (j%2==0 && abs(i) <= abs(j)) putchar('*');
			else putchar(32);
		}
		putchar(10);
	}
}