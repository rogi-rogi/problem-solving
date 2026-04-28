#include <stdio.h>
int main(){
	int n;
	scanf("%d", &n);
	long long sum = n;
	for (int i = 2, temp; i < n; i = temp+1){
		int prime = (n - 1)/i + 1;
		temp = (n-1) / ((n-1)/i);
		sum += prime*(temp -i +1);
	}
	printf("%lld", sum + (n > 1 ? 1 : 0));
}