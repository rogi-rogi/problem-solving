#include <stdio.h>
#include <stdbool.h>
#include <math.h>
#define MAX 1000001
#define MAX_PRIME 78499
typedef struct{
	int prime, cnt;
}Prime;

Prime p[MAX_PRIME];
bool cNum[MAX];
int arr[100][MAX_PRIME];

int main(){
	for (int i = 2; i*i <= MAX; i++)
		if (!cNum[i])
			for (int j = 2*i; j < MAX; j += i)
				cNum[j] = true;

	for (int i = 2, idx = 0; i < MAX; i++)
		if (!cNum[i])
			p[idx++].prime = i;

	int N;
	scanf("%d", &N);
	for (int n = 0, num; n < N; n++){
		scanf("%d", &num);

		for (int i = 0; i < MAX_PRIME; i++){
			while (num % p[i].prime == 0){
				num /= p[i].prime;
				p[i].cnt++;
				arr[n][i]++;
			}
			if (num == 1) break;
		}
	}

	int result = 1, cnt = 0;
	for (int i = 0; i < MAX_PRIME; i++){
		int gcd = p[i].cnt/N;
		for (int n = 0; n < N; n++)
			if (gcd > arr[n][i])
				cnt += (gcd - arr[n][i]);

		result *= pow(p[i].prime, gcd);
	}
	printf("%d %d", result, cnt);
}