#include <stdio.h>
#include <string.h>
int main(){
	int M, S = 0, num;
	char op[7];
	scanf("%d", &M);
	while (M--){
		scanf("%s", op);
		if (!strcmp(op, "all")) S = (1 << 21) - 1;
		else if (!strcmp(op, "empty")) S = 0;
		else {
			scanf("%d", &num);
			if (!strcmp(op, "add")) S |= (1 << num);
			else if (!strcmp(op, "remove")) S &= ~(1 << num);
			else if (!strcmp(op, "check"))
				puts(S & (1 << num) ? "1" : "0");
			else if (!strcmp(op, "toggle")) S ^= (1 << num);
		}
	}
}