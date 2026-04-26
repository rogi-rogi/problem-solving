#include <stdio.h>
#define min(a,b) a < b ? a : b
int main(){
	int N, K;
	scanf("%d %d", &N, &K);

	int first = 1, last = K;
	while (first <= last){
		int mid = (first+last) / 2, cnt = 0;
		for (int i = 1; i <= N; i++)
			cnt += min(N, mid/i);
		if (cnt < K) first = mid + 1;
		else last = mid - 1;
	}
	printf("%d", last + 1);
}