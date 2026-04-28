#include <stdio.h>
int main(){
	int num[2];
	scanf("%d %d", &num[0], &num[1]);
	for (int i = 0; i < 2; i++){
		int temp = (num[i]/100) + (num[i]/10% 10 *10) + (num[i]%10 *100);
		num[i] = temp;
	}
	printf("%d\n", num[0] > num[1] ? num[0] : num[1]);
}