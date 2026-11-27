#include <stdio.h>
#define ll long long
int facter[100];
int gcd(int a, int b){
	return b ? gcd(b, a%b) : a;
}
ll lcm(ll a, int b){
	return a*b/gcd(a, b);
}
int main(){
	int A, B;
	scanf("%d %d", &A, &B);

	if (A == B) return !printf("1");
	if (A > B){
		int swap = A;
		A = B;
		B = swap;
	}

	int idx = 0, diff = B-A, result = diff;
	for (int i = 1; i*i <= diff; i++)
		if (diff % i == 0){
			facter[idx++] = i;
			if (diff/i != i) facter[idx++] = diff/i;
		}

	ll min = 1e18, N;
	for (int i = 0, f; i < idx; i++){
		if (A % (f = facter[i])){
			N = f- A%f;
			ll temp = lcm(A+N, B+N);
			if (temp < min){
				min = temp;
				result = N;
			}else if (min == temp && N < result) result = N;
		}
	}
	printf("%d", result);
}