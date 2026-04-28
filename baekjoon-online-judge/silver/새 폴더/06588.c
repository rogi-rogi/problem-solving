#include <stdio.h>
#include <math.h>
#include <stdbool.h>
#define MAX 1000001
int main(){
	int sq = sqrt(MAX-1);
	bool not_prime[MAX] = {0,};
	for (int i = 2; i <= sq; i++)
		for (int j = 2*i; j < MAX-1; j += i)
			not_prime[j] = true;

	while (1){
		int N;
		scanf("%d", &N);
		if (!N) break;

		int first = 3, last = N-3;

		while (first <= last){
			if (!not_prime[first] && !not_prime[last] && first+last == N) break;
			first += 2, last -= 2;
		}

		if (first > last) puts("Goldbach's conjecture is wrong.");
		else printf("%d = %d + %d\n", N, first, last);
	}
}