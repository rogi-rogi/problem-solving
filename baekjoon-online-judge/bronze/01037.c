#include <stdio.h>
int main(){
	int N, val, max, min;
	scanf("%d", &N);
	for (int i = 0; i < N; i++){
		scanf("%d", &val);
		if (!i){
			max = min = val;
			continue;
		}
		val > max && (max = val);
		val < min && (min = val);
	}
	printf("%d", max*min);
}