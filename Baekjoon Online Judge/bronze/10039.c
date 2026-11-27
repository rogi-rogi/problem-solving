#include <stdio.h>
int main() {
	int arr[5], sum = 0;
	for (int i = 0; i < 5; i++) {
		scanf("%d", &arr[i]);
		arr[i] < 40 && (arr[i] = 40);
		sum += arr[i];
	}
	printf("%d\n", sum / 5);
}