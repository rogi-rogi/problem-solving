#include <stdio.h>
#define MAX 1000001
#define MIN(a,b) (a < b ? a : b)

int main(){
	int N, result = MAX;
	scanf("%d", &N);
	int cost[N][3], min[3] = {0,}, old[3] = {0,};

	for (int i = 0; i < N; i++)
		scanf("%d %d %d", &cost[i][0], &cost[i][1], &cost[i][2]);

	for (int i = 0; i < 3; i++){
		old[0] = old[1] = old[2] = MAX;
		old[i] = cost[0][i];

		for (int j = 1; j < N; j++){
			min[0] = cost[j][0] + MIN(old[1], old[2]);
			min[1] = cost[j][1] + MIN(old[0], old[2]);
			min[2] = cost[j][2] + MIN(old[0], old[1]);

			for (int k = 0; k < 3; k++)
				old[k] = min[k];
		}

		for (int j = 0; j < 3; j++)
			if (i != j) result = MIN(result, min[j]);
	}
	printf("%d\n", result);
}