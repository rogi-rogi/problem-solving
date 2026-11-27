#include <stdio.h>
#include <math.h>
int main(){
	int T, x, y, n, distance;
	scanf("%d", &T);
	while (T--){
		scanf("%d %d", &x, &y);
		n = sqrt(distance = y-x);
		if (distance == n*n)
			printf("%d\n", 2*n-1);
		else
			printf("%d\n", distance <= n*n + n ? 2*n : 2*n+1);
	}
}