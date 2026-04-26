#include <stdio.h>
int GCD(int a, int b){
    return b ? GCD(b, a%b) : a;
}
int main(){
    int t, n, arr[100];
    scanf("%d", &t);
    while (t--){
    	scanf("%d", &n);
    	long long gcd_sum = 0;
    	for (int i = 0; i < n; i++)
			scanf("%d", &arr[i]);
		for (int i = 0; i < n-1; i++)
			for (int j = 1 + i; j < n; j++)
				gcd_sum += GCD(arr[i], arr[j]);
		printf("%lld\n", gcd_sum);
	}
}