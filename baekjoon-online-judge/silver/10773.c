#include <stdio.h>
int main(){
	int K;
	scanf("%d", &K);
	int stack[K], top = -1, sum = 0;
	for (int i = 0; i < K; i++){
		scanf("%d", &stack[++top]);
		if (!stack[top])
			top -= 2;
	}
	for (int i = 0; i <= top; i++)
		sum += stack[i];
	printf("%d", sum);
}