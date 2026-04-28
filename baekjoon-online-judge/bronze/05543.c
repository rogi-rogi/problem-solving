#include <stdio.h>
int main() {
	int arr[5], price = 2000;
	for (int i = 0; i < 5; i++){
		scanf("%d", &arr[i]);
		if (i < 3 && arr[i] < price) price = arr[i];
	}
	printf("%d\n",price + (arr[3] < arr[4] ? arr[3] : arr[4]) - 50);
}