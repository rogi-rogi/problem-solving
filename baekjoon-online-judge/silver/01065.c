#include <stdio.h>
int ap(int n){
	int cnt = 0;
	for (int i = 1; i <= n; i++)
		if ( i > 0 && i < 100) cnt ++;
		else if (i/100 - (i%100)/10 == (i%100)/10 - ((i%100)%10)) cnt++;
	return cnt;
}
int main(){
	int N;
	scanf("%d", &N);
	printf("%d", ap(N));
}