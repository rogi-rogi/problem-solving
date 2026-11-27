#include <stdio.h>
#include <stdlib.h>
int compare1(const void *a, const void *b){
	int n1 = *(int *)a, n2 = *(int *)b;
	if (n1 < n2)
		return -1;
	else if (n1 > n2)
		return 1;
	return 0;
}
int compare2(const void *a, const void *b){
	int n1 = *(int *)a, n2 = *(int *)b;
	if (n1 > n2)
		return -1;
	else if (n1 < n2)
		return 1;
	return 0;
}
int main(){
	int N;
	scanf("%d", &N);
	int A[N], B[N];
	for (int i = 0; i < N; i++)
		scanf("%d", &A[i]);
	for (int i = 0; i < N; i++)
		scanf("%d", &B[i]);
	qsort(A, N, sizeof(int), compare1);
	qsort(B, N, sizeof(int), compare2);
	int sum = 0;
	for (int i = 0; i < N; i++)
		sum += A[i]*B[i];
	printf("%d", sum);
}