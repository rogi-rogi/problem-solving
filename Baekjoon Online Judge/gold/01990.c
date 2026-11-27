#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <math.h>
#define MAX 9989900
bool cNum[MAX] = {0, 1};
int main(){
	int sq = sqrt(MAX);
	for (int i = 2; i <= sq; i++)
		if(!cNum[i])
			for (int j = 2*i; j < MAX; j += i)
				cNum[j] = true;

	int a, b;
	scanf("%d %d", &a, &b);
	b >= MAX  && (b = MAX-1);
	for (int i = a; i <= b; i++)
		if (!cNum[i]){
			char str[8];
			sprintf(str, "%d", i);
			int len = strlen(str), j;
			for (j = 0; j < len/2; j++)
				if (str[j] != str[len-j-1]) break;
			if (j == len/2) printf("%d\n", i);
		}
	puts("-1");
}