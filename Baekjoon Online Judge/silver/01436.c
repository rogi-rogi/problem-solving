#include <stdio.h>
int main(){
	int N, cnt = 0, result, temp;
	scanf("%d", &N);
	for (result = 665; cnt < N;){
		temp = ++result;
		while (temp)
			if (temp % 1000 == 666){
				cnt++;
				break;
			}else temp /= 10;
	}
	printf("%d\n", result);
}