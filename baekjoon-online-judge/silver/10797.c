#include <stdio.h>
int main(){
	int num, car, cnt = 0;
	scanf("%d", &num);
	for (int i = 0; i < 5; i++){
		scanf("%d", &car);
		num == car && cnt++;
	}
	printf("%d\n", cnt);
}