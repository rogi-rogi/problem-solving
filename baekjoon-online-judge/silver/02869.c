#include <stdio.h>
int main(){
	int A, B, V;
	scanf("%d %d %d", &A, &B, &V);
	printf("%d\n", 1+(V-B-1)/(A-B));
}