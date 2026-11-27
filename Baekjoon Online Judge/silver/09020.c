#include <stdio.h>
#include <math.h>
#include <stdbool.h>
#define MAX 10001
bool cNum[MAX];
int main(){
	int sq = sqrt(MAX-1);
	for (int i = 2; i <= sq; i++)
		for (int j = 2*i; j < MAX-1; j += i)
			cNum[j] = true;

	int T;
	scanf("%d", &T);
	while (T--){
		int N;
		scanf("%d", &N);

		if (N == 4){
			puts("2 2");
			continue;
		}
		int first = 3, last = N-3;
		int temp[2] = {first, last};
		while (first <= last){
			if (!cNum[first] && !cNum[last] && first+last == N){
				temp[0] = first;
				temp[1] = last;
			}
			first += 2, last -= 2;
		}

		printf("%d %d\n", temp[0], temp[1]);
	}
}