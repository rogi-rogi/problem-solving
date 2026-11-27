#include <stdio.h>
#define MAX 10001
int n_selfNum(int n){
	int result = n;
	for (; n > 0; n /= 10) result += n%10;
	return result;
}
int main(){
	int arr[MAX] = {0, };
	for (int i = 1; i < MAX; i++){
		int n = n_selfNum(i);
		n < MAX && (arr[n] = 1);
	}
	for (int i = 1; i < MAX; i++)
		!arr[i] && printf("%d\n", i);
}