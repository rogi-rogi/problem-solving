#include <stdio.h>
#include <stdbool.h>
#define MAX 1001
bool not_prime[MAX];
int main(){
	int N, K;
	scanf("%d %d", &N, &K);

	for (int i = 2; i <= N; i++)
		for (int j = i; j <= N; j += i)
			if (!(not_prime[j]++)){
				if (!(--K)){
					printf("%d", j);
					return 0;
				}
			}
}