#include <stdio.h>
int main(){
	char num[16];
	int result = 0;
	scanf("%s", num);
	for (int i = 0; i < num[i] != '\0'; i++)
		for (char ch = num[i], wait = 0; ; wait++){
			if (ch < "@@ADGJMPTW["[wait])
				break;
			result += 1;
		}
	printf("%d", result);
}