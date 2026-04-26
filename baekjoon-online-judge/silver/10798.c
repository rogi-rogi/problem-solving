#include <stdio.h>
int main(){
	char str[5][15] = { 0, };
	for (int row = 0; row < 5; row++)
		scanf("%s", str[row]);
	for (int col = 0; col < 15; col++)
		for (int row = 0; row < 5; row++)
			if (str[row][col] != '\0')
				putchar(str[row][col]);
}