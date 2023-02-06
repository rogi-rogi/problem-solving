#include <stdio.h>

typedef long long ll;

ll euler_phi(ll n)
{
    ll euler = n;
    for (ll prime = 2; prime*prime <= n; ++prime) {
		if (n % prime == 0) {
		    euler = euler / prime * (prime - 1);
		    while (n % prime == 0) n /= prime;
		}
    }
    return (n == 1 ? euler : euler / n * (n - 1));
}

int main()
{
	ll n;
	while (1) {
		scanf("%lld", &n);
		if (!n) break;
		printf("%lld\n", n == 1 ? 0 : euler_phi(n)); // ouput euler_phi(n) [n : 0 < n - 1]
	}
}
