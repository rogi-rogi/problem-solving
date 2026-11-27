#include <stdio.h>
#include <stdbool.h>
#define MAX 100000001
bool cNum[MAX];
int main(){
	for (int i = 2; i*i < MAX; i++)
		if (!cNum[i])
			for (int j = 2*i; j < MAX; j += i)
				cNum[j] = true;

	int n;
	scanf("%d", &n);
	long long result = 1;
	for (int i = 2; i < MAX; i++)
		if (!cNum[i]){
			long long temp = 1;
			while (temp*i <= n) temp *= i;
			result = result*temp %4294967296;
		}
	printf("%lld", result);
}