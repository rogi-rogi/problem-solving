#include <stdio.h>
#include <stdlib.h>
#define MAX 4000
int AB[MAX*MAX], CD[MAX*MAX];
int compare(const void *a, const void *b){
	return *(int*)a - *(int*)b;
}
int main(){
	int n;
	scanf("%d", &n);
	int A[n], B[n], C[n], D[n], N = n*n;
	for (int i = 0; i < n; i++)
		scanf("%d %d %d %d", &A[i], &B[i], &C[i], &D[i]);

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++){
			AB[i*n+j] = A[i]+B[j];
			CD[i*n+j] = C[i]+D[j];
		}

	qsort(AB, N, sizeof(int), compare);
	qsort(CD, N, sizeof(int), compare);

	long long cnt = 0;
	for (int i = 0; i < N; i++){
		int left = 0, right = N, mid;

		while (left < right){
			mid = (left+right) / 2;
			if (AB[mid]+CD[i] > 0) right = mid;
			else left = mid + 1;
		}
		int temp = right;

		left = 0, mid = temp;
		do{
			if (AB[mid]+CD[i] >= 0) right = mid;
			else left = mid + 1;
			mid = (left+right) / 2;
		}while (left < right);

		cnt += (temp - right);
	}
	printf("%lld", cnt);
}