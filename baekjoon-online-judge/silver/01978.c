#include <stdio.h>
#include <math.h>
#define MAX 1000
int main(){
	int arr[MAX], idx = 3;
	for (int i = 0; i < MAX; i++)
		arr[i] = i+1;

	for (int i = 2; i <= sqrt(MAX); i++)
		if (arr[i-1])
			for (int j = i*2; j <= MAX; j += i)
				arr[j-1] = 0;

	for (int i = 3; i < MAX; i++)
		if (arr[i]){
			arr[idx++] = arr[i];
			arr[i] = 0;
		}
	int N, prime = 0, num;
	scanf("%d", &N);
	for (int i = 0; i < N; i++){
		scanf("%d", &num);
		for (int j = 1; j < idx; j++)
			if (num == arr[j])
				prime++;
	}
	printf("%d", prime);
}