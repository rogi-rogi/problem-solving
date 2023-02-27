#include <stdio.h>
#define SIZE 68

typedef long long ll;

int main()
{
    int koong[SIZE] = {0, 1, 1, 2, 4,};
    { // preprocessing
        for (int i = 4; i < SIZE; ++i)
            koong[i] = 
            // koong[i] = koong[i - 1] + koong[i - 2] + koong[i - 3] + koong[i - 4];
            // koong(n) = Σ koong(i), { i : [n-4, n-1] }
    }
    int N;
    scanf("%d", &N);
    printf("%s", dp[(N - 1) % 7] == 1 ? "SK" : "CY");
}
