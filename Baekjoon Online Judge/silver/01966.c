#include <stdio.h>
int main(){
	int T, N, M;
	scanf("%d", &T);
	while (T--){
		scanf("%d %d", &N, &M);
		int queue[N], idx = 0, cnt = 1;
		for (int i = 0; i < N; i++)
			scanf("%d", &queue[i]);

		while (1){
			int max = 0;
			for (int j = 0; j < N; j++)
				max < queue[j] && (max = queue[j]);
			while (queue[idx] != max) idx = (idx+1) % N;
			if (idx == M) break;
			cnt++;
			queue[idx] = -1;
		}
		printf("%d\n", cnt);
	}
}