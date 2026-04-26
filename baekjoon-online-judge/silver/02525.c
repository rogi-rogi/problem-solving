#include <stdio.h>
int main(){
	int H, M, time;
	scanf("%d %d %d", &H, &M, &time);
	printf("%d %d", (H+((M+time)/60))%24, (M+time)%60);
}