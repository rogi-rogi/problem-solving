#include <stdio.h>
int main() {
	int n[3], temp;
	scanf("%d %d %d", &n[0], &n[1], &n[2]);
	for (int i = 0; i < 3; i++)
		for (int j = 0; j < 2; j++)
			if (n[j] >= n[j + 1]){
				temp = n[j];
				n[j] = n[j+1];
				n[j+1] = temp;
			}
	printf("%d\n", n[1]);
}