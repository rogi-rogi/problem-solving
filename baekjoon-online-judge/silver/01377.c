#include <stdio.h>
#include <stdlib.h>
#define max(a, b) a > b ? a : b
typedef struct{
	int num, idx;
}Point;

int compare(const void *a, const void *b){
	return ((Point*)a)->num - ((Point*)b)->num;
}
int main(){
	int N;
	scanf("%d", &N);
	Point p[N];
	for (int i = 0; i < N; i++){
		scanf("%d", &p[i].num);
		p[i].idx = i;
	}
	qsort(p, N, sizeof(Point), compare);
	int result = 0;
	for (int i = 0; i < N; i++)
		result = max(result, p[i].idx - i);
	printf("%d", result+1);
}