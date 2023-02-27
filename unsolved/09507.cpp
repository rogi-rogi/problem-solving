#include <stdio.h>
#define SIZE 68

typedef long long ll;

int main()
{
    ll koong[SIZE] = {1, 1, 2, 4, 8, };
    { // preprocessing
        for (int i = 5; i < SIZE; ++i)
            koong[i] = 2*koong[i - 1] - koong[i - 5];
            /*
            koong[i] = koong[i - 1] + (koong[i - 2] + koong[i - 3] + koong[i - 4]);
            koong[i] = koong[i - 1] + (koong[i - 1] - koong[i - 5]);
            */
    }
    int t;
    scanf("%d", &t);
    while (t--) {
        int n;
        scanf("%d", &n);
        printf("%lld\n", koong[n]);
    }
}
