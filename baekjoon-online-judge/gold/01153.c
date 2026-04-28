#include <stdio.h>
#include <math.h>
#include <stdbool.h>
#define MAX 1000001
bool Cnum[MAX];
int main(){
	int sq = sqrt(MAX);
	for (int i = 2; i <= sq; i++)
		if (!Cnum[i])
			for (int j = 2*i; j < MAX; j += i)
				Cnum[j] = true;

	int N;
	scanf("%d", &N);
	if (N < 8) puts("-1");
	else if (N == 8) puts("2 2 2 2");
	else {
		if (N%2){
			printf("2 3 ");
			N -= 5;
		}else {
			printf("2 2 ");
			N -= 4;
		}

		int first = 3, last = N-3;
		while (first <= last){
			if (first+last == N && !Cnum[first] && !Cnum[last]) break;
			first += 2, last -= 2;
		}
		printf("%d %d", first, last);
	}
}