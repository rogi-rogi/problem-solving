#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#define ll long long
#define cMAX 10000001
const ll MAX = 1e14;
const int MOD = 1e9+7;

typedef struct{
	ll mol, prime;
}Prime;
Prime p[670122];
bool cNum[cMAX];
int idx = 1, result[670122] = {1};

int compare(const void *a, const void *b){
	Prime *n1 = (Prime*)a, *n2 = (Prime*)b;
	if (n1->mol - n2->mol < 0) return -1;
	else if (n1->mol - n2->mol > 0) return 1;
	return 0;
}
void set(){
	for (ll i = 2; i < cMAX; i++)
		if (!cNum[i]){
			for (ll j = 2*i; j < cMAX; j += i)
				cNum[j] = true;

			ll temp = i;
			while (temp <= MAX/i){
				temp *= i;
				p[idx].mol = temp;
				p[idx++].prime = i;
			}
		}
	qsort(p, idx, sizeof(Prime), compare);

	for (int i = 1; i < idx; i++)
		result[i] = result[i-1]*p[i].prime %MOD;
}
int main(){
	set();

	int T;
	scanf("%d", &T);
	for (int i = 1; i <= T; i++){
		ll N;
		scanf("%lld", &N);

		int left = 0, right = idx - 1, j;
		while (left <= right){
			int mid = (left + right) / 2;

			if (p[mid].mol <= N){
				j = mid;
				left = mid + 1;
			} else right = mid - 1;
		}
		printf("Case %d: %d\n", i, result[j]);
	}
}