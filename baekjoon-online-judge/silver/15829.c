#include <stdio.h>
#define MOD 1234567891
int main(){
	char str[51];
	long long result = 0, r = 1;
	int L;
	scanf("%d %s", &L, str);
	for (int i = 0; i < L; i++){
		result = (result + (str[i]-'a'+1) * r) % MOD;
		r = (r*31) % MOD;
	}
	printf("%lld", result);
}