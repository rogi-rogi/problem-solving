#include <stdio.h>
#include <stdlib.h>
#define MAX 200001
typedef struct{
	int idx, color, size;
}Ball;

int same_color[MAX], same_size[MAX], sum[MAX];

int compare(const void *a, const void *b){
	Ball *n1 = (Ball*)a, *n2 = (Ball*)b;
	if (n1->size == n2->size)
		return n1->color - n2->color;
	return n1->size - n2->size;
}
int main(){
	int N;
	scanf("%d", &N);
	Ball b[N];
	for (int i = 0; i < N; i++){
		scanf("%d %d", &b[i].color, &b[i].size);
		b[i].idx = i;
	}
	qsort(b, N, sizeof(Ball), compare);

	int sum_all = 0;
	for (int i = 0; i < N; i++){
		int s = b[i].size, c = b[i].color, idx = b[i].idx;

		sum_all += s;
		same_color[c] += s;
		same_size[s] += s;

		sum[idx] = sum_all + s - same_color[c] - same_size[s];
		if (i){
			if (b[i-1].color == c && b[i-1].size == s)
				sum[idx] = sum[b[i-1].idx];
		}
	}
	for (int i = 0; i < N; i++)
		printf("%d\n", sum[i]);
}