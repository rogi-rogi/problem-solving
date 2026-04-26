#include <stdio.h>
#include <stdlib.h>
int compare (const void *a, const void *b){
	int n1 = *(int*)a, n2 = *(int*)b;
	if (n1 < n2)
		return -1;
	else if (n1 > n2)
		return 1;
	return 0;
}
int main(){
	int L, n;
	scanf("%d", &L);
	int S[L];
	for(int i = 0; i < L; i++)
		scanf("%d", &S[i]);
	scanf("%d", &n);
	qsort(S, L, sizeof(int), compare);

	int max, min = 1, cnt = 0;
	for (int i = 0; i < L; i++){
		if (n <= S[i]){
			max = S[i];
			break;
		}
		min = S[i] + 1;
	}
	for(int i = min; i < max; i++)
		for(int j = i + 1; j < max; j++)
			if(i <= n && n <= j)
				cnt++;

	printf("%d", cnt);
}