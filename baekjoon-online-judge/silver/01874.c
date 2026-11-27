#include <stdio.h>
int main(){
	int n;
	scanf("%d", &n);
	int stack[n], top = 0, val, idx = 0, num = 0;
	char op[2*n];
	for (int i = 0; i < n; i++){
		scanf("%d", &val);

		for (int j = num; j < val; j++){
			stack[top++] = ++num;
			op[idx++] = '+';
		}
		if (stack[top-1] == val){
			top--;
			op[idx++] = '-';
		}else {
			idx = 0;
			puts("NO");
			break;
		}
	}
	if (idx)
		for (int i = 0; i < 2*n; i++)
			printf("%c\n", op[i]);
}